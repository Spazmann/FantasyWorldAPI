///**
// * @author dmann
// * @createdOn 11/17/2023 at 7:43 PM
// * @projectName Fantasy World API
// * @packageName csc280.fantasyworldapi.methods;
// */
//package csc280.fantasyworldapi.databases;
//import csc280.fantasyworldapi.objects.Class;
//import csc280.fantasyworldapi.objects.User;
//import org.springframework.security.crypto.bcrypt.BCrypt;
//
//import java.sql.*;
//import java.util.ArrayList;
//import java.util.Arrays;
//
//public class DB {
//
//    static String url = "jdbc:mysql://localhost:3306/fantasy?allowPublicKeyRetrieval=true&useSSL=false";
//    static String user = "root";
//    static String password = "pass";
//
//    //region Class
//    public static void createClass(Class document) throws SQLException {
//        String sql = "INSERT INTO fantasy.classes(className, classImage, classDescription, classPrimaryAbility, classSaves) VALUES (?, ?, ?, ?, ?)";
//
//        Connection con = DriverManager.getConnection(url, user, password);
//        PreparedStatement pst = con.prepareStatement(sql);
//        pst.setString(1, document.getClassName());
//        pst.setString(2, document.getClassImage());
//        pst.setString(3, document.getClassDescription());
//        pst.setString(4, Arrays.toString(document.getClassPrimaryAbility()));
//        pst.setString(5, Arrays.toString(document.getClassSaves()));
//        pst.executeUpdate();
//    }
//
//    public static ArrayList<Class> findALLClasses() throws SQLException {
//
//        String sql = "Select id, className, classImage, classDescription, classPrimaryAbility, classSaves from fantasy.classes";
//        Connection con = DriverManager.getConnection(url, user, password);
//        PreparedStatement pst = con.prepareStatement(sql);
//        ResultSet rs = pst.executeQuery();
//
//        ArrayList<Class> classes = new ArrayList<>();
//        while (rs.next()){
//            Class newClass = new Class(rs.getString("className"), rs.getString("classImage"), rs.getString("classDescription"),
//                    stringToArray(rs.getString("classPrimaryAbility")) , stringToArray(rs.getString("classSaves")));
//            newClass.setId(rs.getInt("id"));
//            classes.add(newClass);
//        }
//
//        return classes;
//    }
//
//    public static Class findClass(int id) throws SQLException {
//
//        String sql = "SELECT `id`, `className`, `classImage`, `classDescription`, `classPrimaryAbility`, `classSaves` " +
//                "FROM `fantasy`.`classes` WHERE `id` = ?";
//        Connection con = DriverManager.getConnection(url, user, password);
//        PreparedStatement pst = con.prepareStatement(sql);
//        pst.setInt(1, id);
//        ResultSet rs = pst.executeQuery();
//
//        if (rs.next()) {
//            Class newClass = new Class(rs.getString("className"),
//                    rs.getString("classImage"),
//                    rs.getString("classDescription"),
//                    stringToArray(rs.getString("classPrimaryAbility")),
//                    stringToArray(rs.getString("classSaves")));
//            newClass.setId(rs.getInt("id"));
//            return newClass;
//        } else {
//            return null;
//        }
//    }
//
//    public static void deleteClass(int id) throws SQLException {
//        String sql = "DELETE FROM fantasy.classes WHERE id = ?";
//
//        try (Connection con = DriverManager.getConnection(url, user, password);
//             PreparedStatement pst = con.prepareStatement(sql)) {
//
//            pst.setInt(1, id);
//            pst.executeUpdate();
//        }
//    }
//
//    public static void updateClass(int id, Class document) throws SQLException {
//        String sql = "UPDATE fantasy.classes SET className = ?, classImage = ?, classDescription = ?, classPrimaryAbility = ?, classSaves = ? WHERE id = ?";
//
//        try (Connection con = DriverManager.getConnection(url, user, password);
//             PreparedStatement pst = con.prepareStatement(sql)) {
//            pst.setString(1, document.getClassName());
//            pst.setString(2, document.getClassImage());
//            pst.setString(3, document.getClassDescription());
//            pst.setString(4, Arrays.toString(document.getClassPrimaryAbility()));
//            pst.setString(5, Arrays.toString(document.getClassSaves()));
//            pst.setInt(6, id);
//
//            int rowsAffected = pst.executeUpdate();
//
//            if (rowsAffected > 0) {
//                System.out.println("Class with ID " + id + " updated successfully.");
//            } else {
//                System.out.println("No class found with ID " + id + ". No changes made.");
//            }
//        }
//    }
//
//    //endregion
//
//    //region User
//    public static void createUser(User document) throws SQLException {
//        String sql = "INSERT INTO fantasy.users(role, username, password) VALUES (?, ?, ?)";
//
//        Connection con = DriverManager.getConnection(url, user, password);
//        PreparedStatement pst = con.prepareStatement(sql);
//        pst.setString(1, document.getRole());
//        pst.setString(2, document.getUsername());
//
//        String hashedPassword = BCrypt.hashpw(document.getPassword(), BCrypt.gensalt());
//        pst.setString(3, hashedPassword);
//
//        pst.executeUpdate();
//    }
//
//    public static ArrayList<User> findALLUsers() throws SQLException {
//
//        String sql = "Select id, role, username, password from fantasy.users";
//        Connection con = DriverManager.getConnection(url, user, password);
//        PreparedStatement pst = con.prepareStatement(sql);
//        ResultSet rs = pst.executeQuery();
//
//        ArrayList<User> users = new ArrayList<>();
//        while (rs.next()){
//            User newUser = new User(rs.getString("role"), rs.getString("username"), rs.getString("password"));
//            newUser.setId(rs.getInt("id"));
//            users.add(newUser);
//        }
//
//        return users;
//    }
//
//    public static User findUser(int id) throws SQLException {
//
//        String sql = "SELECT `id`, `role`, `username`, `password` FROM `fantasy`.`users` WHERE `id` = ?";
//        Connection con = DriverManager.getConnection(url, user, password);
//        PreparedStatement pst = con.prepareStatement(sql);
//        pst.setInt(1, id);
//        ResultSet rs = pst.executeQuery();
//
//        if (rs.next()) {
//            User newUser = new User(rs.getString("role"),
//                    rs.getString("username"),
//                    rs.getString("password"));
//            newUser.setId(rs.getInt("id"));
//            return newUser;
//        } else {
//            return null;
//        }
//    }
//
//    public static void deleteUser(int id) throws SQLException {
//        String sql = "DELETE FROM fantasy.users WHERE id = ?";
//
//        try (Connection con = DriverManager.getConnection(url, user, password);
//             PreparedStatement pst = con.prepareStatement(sql)) {
//
//            pst.setInt(1, id);
//            pst.executeUpdate();
//        }
//    }
//
//    public static void updateUser(int id, User document) throws SQLException {
//        String sql = "UPDATE fantasy.users SET role = ?, username = ?, password = ? WHERE id = ?";
//
//        try (Connection con = DriverManager.getConnection(url, user, password);
//             PreparedStatement pst = con.prepareStatement(sql)) {
//            pst.setString(1, document.getRole());
//            pst.setString(2, document.getUsername());
//            pst.setString(3, document.getPassword());
//            pst.setInt(4, id);
//
//            int rowsAffected = pst.executeUpdate();
//
//            if (rowsAffected > 0) {
//                System.out.println("User with ID " + id + " updated successfully.");
//            } else {
//                System.out.println("No user found with ID " + id + ". No changes made.");
//            }
//        }
//    }
//    //endregion
//
//    private static String[] stringToArray(String str) {
//
//        String[] elements = str.substring(1, str.length() - 1).split(", ");
//
//        for (int i = 0; i < elements.length; i++) {
//            elements[i] = elements[i].trim();
//        }
//
//        String[] resultArray = new String[elements.length];
//        System.arraycopy(elements, 0, resultArray, 0, elements.length);
//
//        return resultArray;
//    }
//}