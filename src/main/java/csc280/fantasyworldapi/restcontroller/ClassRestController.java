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
import java.util.List;

@RestController
@RequestMapping("/class")
public class ClassRestController {

    private ClassMethods cm = new ClassMethods();

    @RequestMapping(path="", method = RequestMethod.POST)
    public void createClass(@RequestBody Class document) {
        int id = 0;
        List<Class> classes = cm.findAllClasses();
        for (Class c : classes) {
            if (c.getId() > id) id = c.getId();
        }
        id++;
        document.setId(id);
        cm.addClass(document);
    }

    @RequestMapping(path="", method = RequestMethod.GET)
    public List<Class> findAllMessages() {
        return cm.findAllClasses();
    }

    @RequestMapping(path="/{id}", method = RequestMethod.GET)
    public Class findOneMessage(@PathVariable int id) {
        return cm.findClassById(id);
    }

    @RequestMapping(path="/{id}", method = RequestMethod.DELETE)
    public void DeleteIt(@PathVariable int id) {
        cm.deleteClass(id);
    }

    @RequestMapping(path="/{id}", method = RequestMethod.PUT)
    public void update(@PathVariable int id, @RequestBody Class m) {
        m.setId(id);
        cm.updateClass(m);
    }
}
