import static org.junit.Assert.*;
import org.junit.Test;
public class AuthenticateTest {
    @Test
    public void testLoginWithCorrectInput() {
        assertEquals(true,Authenticate.login("abc100","hello",1));		
    }

    @Test
    public void testLoginWithIncorrectAccess() {
        assertEquals(false,Authenticate.login("abc100","hello",2));		
    }

    @Test
    public void testLoginWithIncorrectUsername() {
        assertEquals(false,Authenticate.login("aaa111","hello",1));		
    }

    @Test
    public void testLoginWithIncorrectPassword() {
        assertEquals(false,Authenticate.login("abc100","wrong",1));		
    }

    @Test
    public void testLogout() {
        assertEquals(false,Authenticate.logout());
    }

}
