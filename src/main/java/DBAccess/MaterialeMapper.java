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
                String path = rs.getString("path");

                Materiale materiale = new Materiale(materialeID, materialeNavn, pris, tag,
                                                    beskrivelse, path);

                materialeListe.add(materiale);

            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return materialeListe;
    }


    /**

     * Metoden opretter et materiale vha. scanner, og indsætter det dernæst i DB´en
    public static void opretMateriale(int materialeID, String materialeNavn, double pris, String billedeNavn ) {
     * Metoden indsætter et materiale i DB´en

     */


    public void opretMateriale(String materialeNavn, String materialeBeskrivelse, String tag, double materialePris, String path) throws SQLException, ClassNotFoundException {

        try {
            Connection con = Connector.connection();
            String SQL = "INSERT INTO materialer (materialeNavn,materialeBeskrivelse,tag,pris,path) VALUES (?, ?, ?, ?, ?)";
            PreparedStatement ps = con.prepareStatement(SQL);

            ps.setString(1, materialeNavn);
            ps.setString(2, materialeBeskrivelse);
            ps.setString(3, tag);
            ps.setDouble(4, materialePris);
            ps.setString(5, path);

            ps.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
    public void opretCarport(String materialeNavn, double pris, String path) throws SQLException, ClassNotFoundException {

        try {
            Connection con = Connector.connection();
            String SQL = "INSERT INTO materialer (materialeNavn, pris, path, tag) VALUES (?, ?, ?, ?)";
            PreparedStatement ps = con.prepareStatement(SQL);

            ps.setString(1, materialeNavn);
            ps.setDouble(2, pris);
            ps.setString(3, path);
            ps.setString(4, "carport");
            ps.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }

    }



    public void sletMateriale(int materialeId) throws SQLException, ClassNotFoundException {
        try {
            Connection con = Connector.connection();
            String SQL = "DELETE FROM materialer Where materialeId = " + "" +materialeId+ "" ;
            PreparedStatement ps = con.prepareStatement( SQL );
            ps.executeUpdate();
        } catch ( ClassNotFoundException | SQLException ex ) {
            System.out.println(ex);
        }
    }

    public String getTagNavn(int tagtypeNr) throws SQLException, ClassNotFoundException {
        String navn = "";
        try {
            Connection con = Connector.connection();
            String SQL = "select tagtypeNavn from tagtyper Where tagtypeNr =? ";
            PreparedStatement ps = con.prepareStatement(SQL);
            ps.setInt(1, tagtypeNr);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                navn = rs.getString("tagtypeNavn");
            }

        } catch (ClassNotFoundException | SQLException ex) {
            ex.printStackTrace();
        }
        return navn;
    }
}

