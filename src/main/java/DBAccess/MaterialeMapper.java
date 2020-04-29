package DBAccess;


import FunctionLayer.Materiale;


import java.sql.*;
import java.util.ArrayList;

public class MaterialeMapper {


    public ArrayList<Materiale> getAlleMaterialer() {

        ArrayList<Materiale> materialeListe = new ArrayList<>();

        try {
            Connection con = Connector.connection();
            String SQL = "SELECT * FROM materialer";
            Statement stm;
            stm = con.createStatement();
            ResultSet rs;
            rs = stm.executeQuery(SQL);


            while (rs.next()) {

                Materiale materiale = new Materiale(0, "", 0.0);

                materialeListe.add(materiale);

            }

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        return materialeListe;
    }
}
