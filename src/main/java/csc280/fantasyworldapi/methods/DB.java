/**
 * @author dmann
 * @createdOn 11/17/2023 at 7:43 PM
 * @projectName Fantasy World API
 * @packageName csc280.fantasyworldapi.methods;
 */
package csc280.fantasyworldapi.methods;
import csc280.fantasyworldapi.objects.Class;

import java.sql.*;
import java.util.Arrays;

public class DB {

    static String url = "jdbc:mysql://localhost:3306/fantasy?allowPublicKeyRetrieval=true&useSSL=false";
    static String user = "root";
    static String password = "pass";

    public static void createClass(Class document) throws SQLException {
        String sql = "INSERT INTO fantasy.classes(className, classImage, classDescription, classPrimaryAbility, classSaves) VALUES (?, ?, ?, ?, ?)";

        Connection con = DriverManager.getConnection(url, user, password);
        PreparedStatement pst = con.prepareStatement(sql);
        pst.setString(1, document.getClassName());
        pst.setString(2, document.getClassImage());
        pst.setString(3, document.getClassDescription());
        pst.setString(4, Arrays.toString(document.getClassPrimaryAbility()));
        pst.setString(5, Arrays.toString(document.getClassSaves()));
        pst.executeUpdate();
    }

    public static void selectAuthors() throws SQLException {

        //String sql = "Select name, id, booksold from testdb2.authors where id=(?) and name=(?)";
        String sql = "Select name, id, booksold from testdb2.authors";
        Connection con = DriverManager.getConnection(url, user, password);
        PreparedStatement pst = con.prepareStatement(sql);
        //pst.setInt(1, 2);
        //pst.setString(2, "JRR Tolkein");
        ResultSet rs = pst.executeQuery();

        while (rs.next()) {
            System.out.print(rs.getInt("id"));
            System.out.print(": ");
            System.out.print(rs.getString("name"));
            System.out.print(": ");
            System.out.println(rs.getInt("booksold"));
        }
    }
}