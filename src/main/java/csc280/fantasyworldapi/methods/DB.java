/**
 * @author dmann
 * @createdOn 11/17/2023 at 7:43 PM
 * @projectName Fantasy World API
 * @packageName csc280.fantasyworldapi.methods;
 */
package csc280.fantasyworldapi.methods;
import csc280.fantasyworldapi.objects.Class;

import java.sql.*;
import java.util.ArrayList;
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

    public static ArrayList<Class> findALLClasses() throws SQLException {

        String sql = "Select id, className, classImage, classDescription, classPrimaryAbility, classSaves from fantasy.classes";
        Connection con = DriverManager.getConnection(url, user, password);
        PreparedStatement pst = con.prepareStatement(sql);
        ResultSet rs = pst.executeQuery();

        ArrayList<Class> classes = new ArrayList<>();
        while (rs.next()){
            Class newClass = new Class(rs.getString("className"), rs.getString("classImage"), rs.getString("classDescription"),
                    stringToArray(rs.getString("classPrimaryAbility")) , stringToArray(rs.getString("classSaves")));
            newClass.setId(rs.getInt("id"));
            classes.add(newClass);
        }

        return classes;
    }

    public static Class findClass(int id) throws SQLException {

        String sql = "SELECT `id`, `className`, `classImage`, `classDescription`, `classPrimaryAbility`, `classSaves` " +
                "FROM `fantasy`.`classes` WHERE `id` = ?";
        Connection con = DriverManager.getConnection(url, user, password);
        PreparedStatement pst = con.prepareStatement(sql);
        pst.setInt(1, id);
        ResultSet rs = pst.executeQuery();

        if (rs.next()) {
            Class newClass = new Class(rs.getString("className"),
                    rs.getString("classImage"),
                    rs.getString("classDescription"),
                    stringToArray(rs.getString("classPrimaryAbility")),
                    stringToArray(rs.getString("classSaves")));
            newClass.setId(rs.getInt("id"));
            return newClass;
        } else {
            return null;
        }
    }

    public static void deleteClass(int id) throws SQLException {
        String sql = "DELETE FROM fantasy.classes WHERE id = ?";

        Connection con = DriverManager.getConnection(url, user, password);
        PreparedStatement pst = con.prepareStatement(sql);
        pst.setInt(1, id);
        ResultSet rs = pst.executeQuery();
    }

    public static void updateClass(int id, Class document) throws SQLException {
        String sql = "UPDATE fantasy.classes SET className = ?, classImage = ?, classDescription = ?, classPrimaryAbility = ?, classSaves = ? WHERE id = ?";

        try (Connection con = DriverManager.getConnection(url, user, password);
             PreparedStatement pst = con.prepareStatement(sql)) {
            pst.setString(1, document.getClassName());
            pst.setString(2, document.getClassImage());
            pst.setString(3, document.getClassDescription());
            pst.setString(4, Arrays.toString(document.getClassPrimaryAbility()));
            pst.setString(5, Arrays.toString(document.getClassSaves()));
            pst.setInt(6, id);

            int rowsAffected = pst.executeUpdate();

            if (rowsAffected > 0) {
                System.out.println("Class with ID " + id + " updated successfully.");
            } else {
                System.out.println("No class found with ID " + id + ". No changes made.");
            }
        }
    }



    private static String[] stringToArray(String str) {

        String[] elements = str.substring(1, str.length() - 1).split(", ");

        for (int i = 0; i < elements.length; i++) {
            elements[i] = elements[i].trim();
        }

        String[] resultArray = new String[elements.length];
        System.arraycopy(elements, 0, resultArray, 0, elements.length);

        return resultArray;
    }
}