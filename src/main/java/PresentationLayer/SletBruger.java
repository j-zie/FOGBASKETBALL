package PresentationLayer;

import DBAccess.UserMapper;
import FunctionLayer.LavSelectFormHTML;
import FunctionLayer.LoginSampleException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.SQLException;

public class SletBruger extends Command {
    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) throws LoginSampleException {

        int id = Integer.parseInt(request.getParameter("id"));
        UserMapper userMapper = new UserMapper();

        try {
            userMapper.sletUser(id);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return "admin";
    }
}
