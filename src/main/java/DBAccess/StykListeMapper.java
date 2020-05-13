package DBAccess;

import FunctionLayer.*;

import java.sql.*;
import java.util.ArrayList;

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

    public static ArrayList<Integer> getIDOfComponents(Ordre order) {
            ArrayList<Integer> listOfIDs = new ArrayList();
            try {
                Connection con = Connector.connection();
                int orderNr = order.getOrdreNr();
                String SQL = "SELECT materialer FROM stykliste WHERE ordre = " + orderNr;
                PreparedStatement ps = con.prepareStatement( SQL, Statement.RETURN_GENERATED_KEYS );
                ResultSet rs = ps.executeQuery();
                while ( rs.next() ) {
                    listOfIDs.add(rs.getInt("materialer"));
                }
                return listOfIDs;
            } catch ( Exception ex ) {
                ex.getMessage();
            }
            return listOfIDs;
        }
}
