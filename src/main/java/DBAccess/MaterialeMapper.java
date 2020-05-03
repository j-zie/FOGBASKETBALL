package DBAccess;


import FunctionLayer.Materiale;


import java.sql.*;
import java.util.ArrayList;

public class MaterialeMapper {


    public static ArrayList<Materiale> getAlleMaterialer() {

        ArrayList<Materiale> materialeListe = new ArrayList<>();

        try {
            Connection con = Connector.connection();
            String SQL = "SELECT * FROM materialer";
            Statement stm;
            stm = con.createStatement();
            ResultSet rs;
            rs = stm.executeQuery(SQL);


            while (rs.next()) {
                int materialeID = rs.getInt("materialeID");
                String materialeNavn = rs.getString("materialeNavn");
                Double pris = rs.getDouble("pris");
                String tag = rs.getString("tag");
                String beskrivelse = rs.getString("materialeBeskrivelse");

                Materiale materiale = new Materiale(materialeID, materialeNavn, pris,
                                                    beskrivelse, tag);

                materialeListe.add(materiale);

            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return materialeListe;
    }
}



