/**
 * @author dmann
 * @createdOn 11/1/2023 at 3:03 PM
 * @projectName Fantasy World API
 * @packageName csc280.fantasyworldapi;
 */
package csc280.fantasyworldapi.restcontroller;

import csc280.fantasyworldapi.objects.Class;
import csc280.fantasyworldapi.objects.ClassJPARepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.List;

@RestController
@RequestMapping("/class")
public class ClassRestController {

    @Autowired
    private ClassJPARepository classJPARepository;

    @RequestMapping(path = "", method = RequestMethod.POST)
    public void createClass(@RequestBody Class document) throws SQLException {
        classJPARepository.save(document);
    }

    @RequestMapping(path = "", method = RequestMethod.GET)
    public List<Class> findAllMessages() throws SQLException {
        return classJPARepository.findAll();
    }

    @RequestMapping(path = "/{id}", method = RequestMethod.GET)
    public Class findOneMessage(@PathVariable int id) throws SQLException {
        return classJPARepository.findById(id).get();
    }

    @RequestMapping(path = "/{id}", method = RequestMethod.DELETE)
    public void DeleteIt(@PathVariable int id) throws SQLException {
        classJPARepository.deleteById(id);
    }

    @RequestMapping(path = "/{id}", method = RequestMethod.PUT)
    public void update(@PathVariable int id, @RequestBody Class m) throws SQLException {
        Class s = classJPARepository.findById(id).get();
        s.setClassName(m.getClassName());
        s.setClassImage(m.getClassImage());
        s.setClassDescription(m.getClassDescription());
        classJPARepository.save(s);
    }
}