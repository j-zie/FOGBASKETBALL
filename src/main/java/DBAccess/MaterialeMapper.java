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
     * Metoden opretter et materiale vha. scanner, og indsætter det dernæst i DB´en

     */


    public void opretMateriale() throws SQLException, ClassNotFoundException {

        Connection con = Connector.connection();
        Scanner sc = new Scanner(System.in);


        String materialeNavn = sc.next();
        String materialeBeskrivelse = sc.next();
        String tag = sc.next();
        double materialePris = sc.nextDouble();

        try {
            String SQL = "INSERT INTO materialer (materialeID, materialeNavn, materialeBeskrivelse, tag, pris, billedeNavn, billede) VALUES (?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement ps = con.prepareStatement(SQL, Statement.RETURN_GENERATED_KEYS);
            // ps.setInt(1, materialeID;
            ps.setString(2, materialeNavn);
            ps.setString(3, materialeBeskrivelse);
            ps.setString(4, tag);
            ps.setDouble(5, materialePris);
            ps.executeUpdate();


        } catch (Exception e) {
            e.printStackTrace();
        }

    }
    }
