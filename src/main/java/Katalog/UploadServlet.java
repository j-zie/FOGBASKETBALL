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
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

@WebServlet("/uploadd")
@MultipartConfig
public class UploadServlet extends HttpServlet {

    public static final String QUERY = "INSERT INTO materialer(materialeNavn, pris, billede) VALUES (?, ?, ?)";


    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String carportNavn = request.getParameter("carportNavn");
        double pris = Double.parseDouble(request.getParameter("pris"));
        Part filePart = request.getPart("billede");
        InputStream fileContent = filePart.getInputStream();
        System.out.println("herehere");
        Connection connection = null;
        try {
            connection = Connector.connection();
            PreparedStatement statement = null;
            try {
                statement = connection.prepareStatement(QUERY);
                statement.setString(1, carportNavn);
                statement.setDouble(2, pris);
                statement.setBlob(3, fileContent);
                statement.execute();
            } catch (SQLException e) {
                System.out.println("State cannot be executed!");
                e.printStackTrace();
                return;
            } finally {
                statement.close();
            }
        } catch (SQLException | ClassNotFoundException e) {
            System.out.println("Connection Failed!");
            e.printStackTrace();
            return;
        } finally {
            try {
                connection.close();
            } catch (SQLException e) {
                System.out.println("Connection cannot be closed?");
                e.printStackTrace();
            }
            request.getRequestDispatcher("/WEB-INF/" + "main" + ".jsp").forward(request, response);
        }
    }
}