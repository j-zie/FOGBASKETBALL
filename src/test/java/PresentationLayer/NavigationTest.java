package PresentationLayer;
import javax.servlet.http.*;
import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;
public class NavigationTest extends Mockito {

    @Test
    public void NavigationTestlogin() throws Exception {
        HttpServletRequest request = mock(HttpServletRequest.class);
        HttpServletResponse response = mock(HttpServletResponse.class);
        when(request.getParameter("Nav")).thenReturn("login");
        Command testObj = new Navigation();
        Assert.assertEquals( "login", testObj.execute(request, response));
    }

    @Test
    public void NavigationTestkurv() throws Exception {
        HttpServletRequest request = mock(HttpServletRequest.class);
        HttpServletResponse response = mock(HttpServletResponse.class);
        when(request.getParameter("Nav")).thenReturn("kurv");
        Command testObj = new Navigation();
        Assert.assertEquals( "Kurvpage", testObj.execute(request, response));
    }
    @Test
    public void NavigationTestKatalog() throws Exception {
        HttpServletRequest request = mock(HttpServletRequest.class);
        HttpServletResponse response = mock(HttpServletResponse.class);
        when(request.getParameter("Nav")).thenReturn("Katalog");
        Command testObj = new Navigation();
        Assert.assertEquals( "Katalogpage", testObj.execute(request, response));
    }
    @Test
    public void NavigationTestQuickBygNoSession() throws Exception {
        HttpServletRequest request = mock(HttpServletRequest.class);
        HttpServletResponse response = mock(HttpServletResponse.class);
        when(request.getParameter("Nav")).thenReturn("QuickByg");
        Command testObj = new Navigation();
        Assert.assertEquals( "QuickByg/LoginOrSignuppage", testObj.execute(request, response));
    }
    @Test
    public void NavigationTestAdmin() throws Exception {
        HttpServletRequest request = mock(HttpServletRequest.class);
        HttpServletResponse response = mock(HttpServletResponse.class);
        when(request.getParameter("Nav")).thenReturn("admin");
        Command testObj = new Navigation();
        Assert.assertEquals( "admin", testObj.execute(request, response));
    }
    @Test
    public void NavigationTestRegister() throws Exception {
        HttpServletRequest request = mock(HttpServletRequest.class);
        HttpServletResponse response = mock(HttpServletResponse.class);
        when(request.getParameter("Nav")).thenReturn("register");
        Command testObj = new Navigation();
        Assert.assertEquals( "register", testObj.execute(request, response));
    }
    @Test
    public void NavigationTestInvalidInput() throws Exception {
        HttpServletRequest request = mock(HttpServletRequest.class);
        HttpServletResponse response = mock(HttpServletResponse.class);
        when(request.getParameter("Nav")).thenReturn("asdasdsadas");
        Command testObj = new Navigation();
        Assert.assertEquals( "main", testObj.execute(request, response));
    }
}