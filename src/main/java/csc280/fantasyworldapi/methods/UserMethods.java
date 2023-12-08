///**
// * @author dmann
// * @createdOn 11/27/2023 at 2:15 PM
// * @projectName Fantasy World API
// * @packageName csc280.fantasyworldapi.methods;
// */
//package csc280.fantasyworldapi.methods;
//
//import csc280.fantasyworldapi.databases.DB;
//import csc280.fantasyworldapi.objects.User;
//
//import java.sql.SQLException;
//import java.util.List;
//
//public class UserMethods {
//    public void addUser(User document) throws SQLException {
//        DB.createUser(document);
//    }
//
//    public List<User> findAllUsers() throws SQLException {
//        return DB.findALLUsers();
//    }
//
//    public User findUserById(int id) throws SQLException {
//        return DB.findUser(id);
//    }
//
//    public void deleteUser(int id) throws SQLException {
//        DB.deleteUser(id);
//    }
//
//    public void updateUser(int id, User m) throws SQLException {
//        DB.updateUser(id, m);
//    }
//}
