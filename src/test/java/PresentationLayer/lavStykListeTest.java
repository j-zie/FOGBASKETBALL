package PresentationLayer;
import javax.servlet.http.*;

import FunctionLayer.LoginSampleException;
import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;

public class lavStykListeTest extends Mockito {


    // weird null pointer exception here..
    @Test
    public void LoginFails() throws LoginSampleException {
        HttpServletRequest request = mock(HttpServletRequest.class);
        HttpServletResponse response = mock(HttpServletResponse.class);
        when(request.getParameter("ordrenr")).thenReturn("1");
        Command testObj = new lavStykListe();
        Assert.assertEquals(testObj.execute(request, response), "stykliste" );
    }
}
