package PresentationLayer;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;
import java.io.*;
import java.util.ArrayList;
import javax.servlet.http.*;

import FunctionLayer.LogicFacade;
import FunctionLayer.LoginSampleException;
import FunctionLayer.Ordre;
import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;
import PresentationLayer.Command;

import FunctionLayer.LogicFacade;
import FunctionLayer.LoginSampleException;
import FunctionLayer.User;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class RegistrationTest extends Mockito {
    

    @Test(expected = LoginSampleException.class)
    public void NavigationTestLoginPasswordsDontMatch() throws Exception {
        HttpServletRequest request = mock(HttpServletRequest.class);
        HttpServletResponse response = mock(HttpServletResponse.class);
        Command testObj = new Register();

        when(request.getParameter( "email" )).thenReturn("tester@test.dk");
        when(request.getParameter( "password1" )).thenReturn("samepw");
        when(request.getParameter( "password2" )).thenReturn("sampw");
        when(request.getParameter("adresse")).thenReturn("test");
        when(request.getParameter("postnr")).thenReturn("123");
        when(request.getParameter("navn")).thenReturn("test");
        when(request.getParameter("telefon")).thenReturn("123");
        when(request.getParameter("by")).thenReturn("test");
        testObj.execute(request, response);
    }
}