/**
 * @author dmann
 * @createdOn 11/1/2023 at 3:04 PM
 * @projectName Fantasy World API
 * @packageName csc280.fantasyworldapi.restcontroller;
 */
package csc280.fantasyworldapi.restcontroller;

import csc280.fantasyworldapi.objects.Spell;
import csc280.fantasyworldapi.objects.SpellJPARepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.List;

@RestController
@RequestMapping("/spell")
public class SpellRestController {

    @Autowired
    private SpellJPARepository spellJPARepository;

    @RequestMapping(path = "", method = RequestMethod.POST)
    @ResponseStatus(code = HttpStatus.CREATED)
    public void createSpell(@RequestBody Spell document) throws SQLException {
        spellJPARepository.save(document);
    }

    @RequestMapping(path = "", method = RequestMethod.GET)
    public List<Spell> findAllMessages() throws SQLException {
        return spellJPARepository.findAll();
    }

    @RequestMapping(path = "/{id}", method = RequestMethod.GET)
    public Spell findOneMessage(@PathVariable int id) throws SQLException {
        return spellJPARepository.findById(id).get();
    }

    @RequestMapping(path = "/{id}", method = RequestMethod.DELETE)
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    public void DeleteIt(@PathVariable int id) throws SQLException {
        spellJPARepository.deleteById(id);
    }

    @RequestMapping(path = "/{id}", method = RequestMethod.PUT)
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    public void update(@PathVariable int id, @RequestBody Spell m) throws SQLException {
        Spell s = spellJPARepository.findById(id).get();
        s.setSpellName(m.getSpellName());
        s.setSpellImage(m.getSpellImage());
        s.setSpellDescription(m.getSpellDescription());
        spellJPARepository.save(s);
    }
}