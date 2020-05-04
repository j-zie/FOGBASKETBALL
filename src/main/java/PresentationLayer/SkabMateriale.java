package PresentationLayer;

import DBAccess.MaterialeMapper;
import FunctionLayer.LoginSampleException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.SQLException;

public class SkabMateriale extends Command {
    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) throws LoginSampleException {
        MaterialeMapper mp = new MaterialeMapper();
        String MaterialeNavn = request.getParameter("materialeNavn");
        String MaterialeBeskrivelse = request.getParameter("materialeBeskrivelse");
        String tag = request.getParameter("tag");
        Double MaterialePris = Double.parseDouble(request.getParameter("pris"));

        try {
            mp.opretMateriale(MaterialeNavn,MaterialeBeskrivelse,tag,MaterialePris);

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        return "main";
    }
}
