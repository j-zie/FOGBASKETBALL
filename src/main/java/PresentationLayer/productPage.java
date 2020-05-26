package PresentationLayer;

import FunctionLayer.LoginSampleException;
import FunctionLayer.Materiale;
import FunctionLayer.MaterialeListe;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;

public class productPage extends Command {
    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) throws LoginSampleException {

        HttpSession session = request.getSession();
        ServletContext applicaitonScope = request.getServletContext();
        String product = request.getParameter("product");
        session.setAttribute(product, product);


        return "productPage";
    }
}
