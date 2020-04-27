package PresentationLayer;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;
import java.io.*;
import javax.servlet.http.*;

import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;
import PresentationLayer.Command;
public class NavigationTest extends Mockito {

    @Test
    public void NavigationTestlogin() throws Exception {
        HttpServletRequest request = mock(HttpServletRequest.class);
        HttpServletResponse response = mock(HttpServletResponse.class);
        when(request.getParameter("target")).thenReturn("nav");
        when(request.getParameter("Nav")).thenReturn("login");
        Command x = new Navigation();
        Assert.assertEquals( "login", x.execute(request, response));


    }
}