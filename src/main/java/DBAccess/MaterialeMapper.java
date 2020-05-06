package DBAccess;


import FunctionLayer.Materiale;


import java.sql.*;
import java.util.ArrayList;
import java.util.Scanner;

public class MaterialeMapper {


    /**
     * Metode henter alle Materialer fra DB, smider dem ned i et ArrayList og printer dem
     * @Materiale er et objekt af klassen med samme navn.
     */

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

    /**
     * Metoden indsætter et materiale i DB´en

     */


    public void opretMateriale(String materialeNavn, String materialeBeskrivelse, String tag, double materialePris) throws SQLException, ClassNotFoundException {

        try {
            Connection con = Connector.connection();
            String SQL = "INSERT INTO materialer (materialeNavn,materialeBeskrivelse,tag,pris) VALUES (?, ?, ?, ?)";
            PreparedStatement ps = con.prepareStatement(SQL);

            ps.setString(1, materialeNavn);
            ps.setString(2, materialeBeskrivelse);
            ps.setString(3, tag);
            ps.setDouble(4, materialePris);
            ps.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void sletMateriale(int materialeId) throws SQLException, ClassNotFoundException {

        try {
            Connection con = Connector.connection();
            String SQL = "DELETE FROM materialer Where materialeId = " + "'" +materialeId+ "'" ;
            PreparedStatement ps = con.prepareStatement( SQL );
            ps.executeUpdate();
        } catch ( ClassNotFoundException | SQLException ex ) {
            System.out.println(ex);
        }
    }
    }
