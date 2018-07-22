import com.sun.rowset.JdbcRowSetImpl;
import org.junit.jupiter.api.Test;
import user.UserService;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class UserServiceTest {

    @Test
    void shouldReturnAllUsers() throws SQLException {
        // given

        ResultSet resultSetMock = mock(ResultSet.class);
        when(resultSetMock.next()).thenReturn(true).thenReturn(false);
        when(resultSetMock.getString(0)).thenReturn("Paweł");

        PreparedStatement preparedStatementMock = mock(PreparedStatement.class);
        when(preparedStatementMock.executeQuery()).thenReturn(resultSetMock);

        Connection connectionMock = mock(Connection.class);
        when(connectionMock.prepareStatement("*")).thenReturn(preparedStatementMock);
        UserService userService = new UserService(connectionMock);
        // when
        ResultSet resultSet = userService.queryUsers("*");
        // then
        assertTrue(resultSet.next());
        assertEquals("Paweł", resultSet.getString(0));
        assertFalse(resultSet.next());
    }

}