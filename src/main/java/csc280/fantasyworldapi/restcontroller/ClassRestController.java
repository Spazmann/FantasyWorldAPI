/**
 * @author dmann
 * @createdOn 11/1/2023 at 3:03 PM
 * @projectName Fantasy World API
 * @packageName csc280.fantasyworldapi;
 */
package csc280.fantasyworldapi.restcontroller;

import csc280.fantasyworldapi.objects.Class;
import csc280.fantasyworldapi.objects.ClassJPARepository;
import csc280.fantasyworldapi.objects.Spell;
import csc280.fantasyworldapi.objects.SpellJPARepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.List;

@RestController
@RequestMapping("/class")
public class ClassRestController {

    @Autowired
    private ClassJPARepository classJPARepository;

    @Autowired
    private SpellJPARepository spellJPARepository;

    @RequestMapping(path = "", method = RequestMethod.POST)
    @ResponseStatus(code = HttpStatus.CREATED)
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
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    public void DeleteIt(@PathVariable int id) throws SQLException {
        classJPARepository.deleteById(id);
    }

    @RequestMapping(path = "/{id}", method = RequestMethod.PUT)
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    public void update(@PathVariable int id, @RequestBody Class m) throws SQLException {
        Class s = classJPARepository.findById(id).get();
        s.setClassName(m.getClassName());
        s.setClassImage(m.getClassImage());
        s.setClassDescription(m.getClassDescription());
        classJPARepository.save(s);
    }

    @Transactional
    @PostMapping("/{classId}/addSpell/{spellId}")
    @ResponseStatus(code=HttpStatus.NO_CONTENT)
    public void addSpellToClass(@PathVariable int classId, @PathVariable int spellId) {
        Class c = classJPARepository.findById(classId).get();
        Spell s = spellJPARepository.findById(spellId).get();
        c.getClassSpells().add(s);
        s.getClassesContainingSpell().add(c);
        classJPARepository.save(c);
    }
}