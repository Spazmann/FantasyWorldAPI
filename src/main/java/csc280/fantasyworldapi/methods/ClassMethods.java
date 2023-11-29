/**
 * @author dmann
 * @createdOn 11/1/2023 at 3:03 PM
 * @projectName Fantasy World API
 * @packageName csc280.fantasyworldapi.methods;
 */
package csc280.fantasyworldapi.methods;

import csc280.fantasyworldapi.objects.Class;

import java.sql.SQLException;
import java.util.List;

public class ClassMethods {

    public void addClass(Class document) throws SQLException {
        DB.createClass(document);
    }

    public List<Class> findAllClasses() throws SQLException {
        return DB.findALLClasses();
    }

    public Class findClassById(int id) throws SQLException {
        return DB.findClass(id);
    }

    public void deleteClass(int id) throws SQLException {
        DB.deleteClass(id);
    }

    public void updateClass(int id, Class m) throws SQLException {
        DB.updateClass(id, m);
    }
}
