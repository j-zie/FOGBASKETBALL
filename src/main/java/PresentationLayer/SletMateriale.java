package PresentationLayer;

import DBAccess.MaterialeMapper;
import FunctionLayer.LoginSampleException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.SQLException;

public class SletMateriale extends Command {
    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) throws LoginSampleException {
        MaterialeMapper mp = new MaterialeMapper();

        String materialeIdd = request.getParameter("materialeId");
        int materialeId = Integer.parseInt(materialeIdd);
        try {

            mp.sletMateriale(materialeId);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        return "main";
    }
    public boolean validering(String MaterialeNavn, String MaterialeBeskrivelse,String Tag, Double MaterialePris,HttpServletRequest request){
        if(MaterialeNavn.equals("")){
            request.setAttribute("errorNavn","Ugyldigt Materiale Navn");
            return false;
        }
        if(MaterialeBeskrivelse.equals("")){
            request.setAttribute("errorBeskrivelse","Ugyldigt Materiale Beskrivelse");
            return false;
        }

        if(Tag.equals("")){
            request.setAttribute("errorTag","Ugyldigt Materialegruppering");
            return false;
        }
        return true;
    }

}