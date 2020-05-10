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

        String carportNavn = request.getParameter("carportNavn");
        double pris = Double.parseDouble(request.getParameter("pris"));
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
        } catch (ClassNotFoundException | SQLException e ) {
            e.printStackTrace();
        }

        request.getRequestDispatcher("/WEB-INF/" + "admin" + ".jsp").forward(request, response);
    }
}