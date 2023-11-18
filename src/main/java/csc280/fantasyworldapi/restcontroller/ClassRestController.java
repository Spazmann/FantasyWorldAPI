/**
 * @author dmann
 * @createdOn 11/1/2023 at 3:03 PM
 * @projectName Fantasy World API
 * @packageName csc280.fantasyworldapi;
 */
package csc280.fantasyworldapi.restcontroller;

import csc280.fantasyworldapi.methods.ClassMethods;
import csc280.fantasyworldapi.objects.Class;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.List;

@RestController
@RequestMapping("/class")
public class ClassRestController {

    private ClassMethods cm = new ClassMethods();

    @RequestMapping(path = "", method = RequestMethod.POST)
    public void createClass(@RequestBody Class document) throws SQLException {
        cm.addClass(document);
    }


    @RequestMapping(path = "", method = RequestMethod.GET)
    public List<Class> findAllMessages() throws SQLException {
        return cm.findAllClasses();
    }

    @RequestMapping(path = "/{id}", method = RequestMethod.GET)
    public Class findOneMessage(@PathVariable int id) throws SQLException {
        return cm.findClassById(id);
    }

    @RequestMapping(path = "/{id}", method = RequestMethod.DELETE)
    public void DeleteIt(@PathVariable int id) throws SQLException {
        cm.deleteClass(id);
    }

    @RequestMapping(path = "/{id}", method = RequestMethod.PUT)
    public void update(@PathVariable int id, @RequestBody Class m) throws SQLException {
        cm.updateClass(id, m);
    }
}