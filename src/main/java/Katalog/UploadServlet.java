package Katalog;

import DBAccess.Connector;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.IOException;
import java.io.InputStream;
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

        private static final String SAVE_DIR = "uploadFiles";


    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

            // gets absolute path of the web application
            String appPath = request.getServletContext().getRealPath("");
            // constructs path of the directory to save uploaded file
            String savePath = appPath + "../" + SAVE_DIR;


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
            /* ... (do your job here) */

            filePart.write(savePath + "/" + fileName);
            System.out.println(fileName);
            System.out.println("Dispatched");
            request.getRequestDispatcher("/WEB-INF/" + "TilføjCarport" + ".jsp").forward(request, response);

        }
}