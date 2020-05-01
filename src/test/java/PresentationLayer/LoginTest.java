package PresentationLayer;
import javax.servlet.http.*;
import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;

public class LoginTest extends Mockito {

    @Test
    public void LoginFails() throws Exception {
        HttpServletRequest request = mock(HttpServletRequest.class);
        HttpServletResponse response = mock(HttpServletResponse.class);
        when(request.getParameter("email")).thenReturn("test@test.dk");
        when(request.getParameter("password")).thenReturn("apassword");
        Command testObj = new Login();
        Assert.assertEquals("login", testObj.execute(request, response));
    }

    // Need to make succesful one ):(:
}