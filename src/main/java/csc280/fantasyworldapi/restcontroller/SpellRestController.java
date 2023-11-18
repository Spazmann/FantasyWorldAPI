/**
 * @author dmann
 * @createdOn 11/1/2023 at 3:04 PM
 * @projectName Fantasy World API
 * @packageName csc280.fantasyworldapi.restcontroller;
 */
package csc280.fantasyworldapi.restcontroller;

import csc280.fantasyworldapi.methods.SpellMethods;
import csc280.fantasyworldapi.objects.Spell;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/spell")
public class SpellRestController {

    private SpellMethods sm = new SpellMethods();

    @RequestMapping(path="", method = RequestMethod.POST)
    public void createMessage(@RequestBody Spell document) {
        int id = 0;
        List<Spell> classes = sm.findAllSpells();
        for (Spell c : classes) {
            if (c.getId() > id) id = c.getId();
        }
        id++;
        document.setId(id);
        sm.addSpell(document);
    }

    @RequestMapping(path="", method = RequestMethod.GET)
    public List<Spell> findAllMessages() {
        return sm.findAllSpells();
    }

    @RequestMapping(path="/{id}", method = RequestMethod.GET)
    public Spell findOneMessage(@PathVariable int id) {
        return sm.findSpellById(id);
    }

    @RequestMapping(path="/{id}", method = RequestMethod.DELETE)
    public void DeleteIt(@PathVariable int id) {
        sm.deleteSpell(id);
    }

    @RequestMapping(path="/{id}", method = RequestMethod.PUT)
    public void update(@PathVariable int id, @RequestBody Spell m) {
        m.setId(id);
        sm.updateSpell(m);
    }
}