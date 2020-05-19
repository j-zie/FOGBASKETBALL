package PresentationLayer;

import FunctionLayer.LogicFacade;
import FunctionLayer.LoginSampleException;
import FunctionLayer.Notification;
import FunctionLayer.User;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;

public class Notificationer extends Command {
    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) throws LoginSampleException {

        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");
        ArrayList<Notification> notificationer = (ArrayList<Notification>) session.getAttribute("notificationer");

       notificationer = LogicFacade.resetNotiss(user, notificationer);

       session.setAttribute("notificationer", notificationer);
        int antalNotis = LogicFacade.antalNyeNotificationer(notificationer);
       session.setAttribute("antalNoti", antalNotis);

        return "notificationpage";
    }
}
