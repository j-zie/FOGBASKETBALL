package DBAccess;

import FunctionLayer.Materiale;
import FunctionLayer.Ordre;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class StykListeMapper {


    public static void insætStykListeElement(Ordre person, Materiale mat ,int antal) {
        try {
            Connection con = Connector.connection();
            String SQL = "INSERT INTO stykliste(ordre, materialer, antal) VALUES (?, ?, ?)";
            PreparedStatement ps = con.prepareStatement(SQL);
            int ordreID = person.getOrdreNr();
            int materialeID = mat.getMaterialeID();

            ps.setInt(1, ordreID);
            ps.setInt(2, materialeID);
            ps.setInt(3, antal);
            ps.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
