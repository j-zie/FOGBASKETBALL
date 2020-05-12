package Katalog;

import DBAccess.Connector;
import DBAccess.MaterialeMapper;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import java.io.File;


@WebServlet("/upload")
@MultipartConfig
public class UploadServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String choice = request.getParameter("bool");

        if (choice.equals("car")) {

            //Find path
            String appPath = request.getServletContext().getRealPath("");
            String OSSpecific = appPath + "resources/Carporte";
            String savePath = new java.io.File(OSSpecific).getCanonicalPath();


            System.out.println("first print: " + savePath);
            // creates the save directory if it does not exists
            File fileSaveDir = new File(savePath);
            if (!fileSaveDir.exists()) {
                fileSaveDir.mkdir();
            }


            // Get the stuff from request scope
            double pris = 0;
            String carportNavn = request.getParameter("carportNavn");
            // Følgende bruges til validering
            if (carportNavn.equals("")) {
                request.setAttribute("errorNavn", "Ugyldigt Carport Navn");
                request.getRequestDispatcher("/WEB-INF/" + "TilføjCarport" + ".jsp").forward(request, response);
            }
            try {
                pris = Double.parseDouble(request.getParameter("pris"));
            } catch (NumberFormatException e) {
                request.setAttribute("errorPris", "Ugyldig Pris");
                request.getRequestDispatcher("/WEB-INF/" + "TilføjCarport" + ".jsp").forward(request, response);
            }
            //valideringen er slut

            Part filePart = request.getPart("billede");


            String fileName = Paths.get(filePart.getSubmittedFileName()).getFileName().toString(); // MSIE fix.
            InputStream fileContent = filePart.getInputStream();
            filePart.write(savePath + "/" + fileName);
            System.out.println(fileName);
            String contextPath = "/FOGBASKETBALL_war/resources/Carporte/";
            MaterialeMapper sender = new MaterialeMapper();
            try {
                System.out.println("yay we send some stuff");
                sender.opretCarport(carportNavn, pris, (contextPath + fileName));
            } catch (ClassNotFoundException | SQLException e) {
                e.printStackTrace();
            }

            request.getRequestDispatcher("/WEB-INF/" + "admin" + ".jsp").forward(request, response);
        } else {
            //Find path
            String appPath = request.getServletContext().getRealPath("");
            String OSSpecific = appPath + "resources/Komponenter";
            String savePath = new java.io.File(OSSpecific).getCanonicalPath();


            System.out.println("first print: " + savePath);
            // creates the save directory if it does not exists
            File fileSaveDir = new File(savePath);
            if (!fileSaveDir.exists()) {
                fileSaveDir.mkdir();
            }


            // Get the stuff from request scope
            double pris = 0;
            String tag = request.getParameter("tag");
            String materialeNavn = request.getParameter("materialeNavn");
            String materialeBeskrivelse = request.getParameter("materialeBeskrivelse");
            //følgende bruges til validering
            try {
                pris = Double.parseDouble(request.getParameter("pris"));
            } catch (NumberFormatException e) {
                request.setAttribute("errorPris", "Ugyldig Pris");
                request.getRequestDispatcher("/WEB-INF/" + "SkabMateriale" + ".jsp").forward(request, response);
            }
            if (validering(materialeNavn, materialeBeskrivelse, tag, request) == false) {
                request.getRequestDispatcher("/WEB-INF/" + "SkabMateriale" + ".jsp").forward(request, response);
            }
            //validering er slut

            Part filePart = request.getPart("billede");
            String fileName = Paths.get(filePart.getSubmittedFileName()).getFileName().toString(); // MSIE fix.
            InputStream fileContent = filePart.getInputStream();
            filePart.write(savePath + "/" + fileName);
            System.out.println(fileName);
            String contextPath = "/FOGBASKETBALL_war/resources/Komponenter/";
            MaterialeMapper sender = new MaterialeMapper();
            try {
                System.out.println("yay we send some stuff");
                sender.opretMateriale(materialeNavn, materialeBeskrivelse,tag, pris, (contextPath + fileName));
            } catch (ClassNotFoundException | SQLException e) {
                e.printStackTrace();
            }

            request.getRequestDispatcher("/WEB-INF/" + "admin" + ".jsp").forward(request, response);
        }
    }

    /**
     * Validerer inputs fra form på SkabMateriale
     * @param MaterialeNavn
     * @param MaterialeBeskrivelse
     * @param tag
     * @param request
     * @return boolean som fortæller om der er en fejl i indputtet
     */
    public boolean validering(String MaterialeNavn, String MaterialeBeskrivelse, String tag, HttpServletRequest
            request) {
        if (MaterialeNavn.equals("")) {
            request.setAttribute("errorNavn", "Ugyldigt Materiale Navn");
            return false;
        }
        if (MaterialeBeskrivelse.equals("")) {
            request.setAttribute("errorBeskrivelse", "Ugyldigt Materiale Beskrivelse");
            return false;
        }

        if (tag.equals("")) {
            request.setAttribute("errorTag", "Ugyldigt Materialegruppering");
            return false;
        }

        return true;
    }

}