/**
 * @author dmann
 * @createdOn 11/1/2023 at 3:04 PM
 * @projectName Fantasy World API
 * @packageName csc280.fantasyworldapi.restmethods;
 */
package csc280.fantasyworldapi.restcontroller;

import csc280.fantasyworldapi.methods.RaceMethods;
import csc280.fantasyworldapi.objects.Race;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/race")
public class RaceRestController {

    private RaceMethods rm = new RaceMethods();

    @RequestMapping(path="", method = RequestMethod.POST)
    public void createMessage(@RequestBody Race document) {
        int id = 0;
        List<Race> classes = rm.findAllRaces();
        for (Race c : classes) {
            if (c.getId() > id) id = c.getId();
        }
        id++;
        document.setId(id);
        rm.addRace(document);
    }

    @RequestMapping(path="", method = RequestMethod.GET)
    public List<Race> findAllMessages() {
        return rm.findAllRaces();
    }

    @RequestMapping(path="/{id}", method = RequestMethod.GET)
    public Race findOneMessage(@PathVariable int id) {
        return rm.findRaceById(id);
    }

    @RequestMapping(path="/{id}", method = RequestMethod.DELETE)
    public void DeleteIt(@PathVariable int id) {
        rm.deleteRace(id);
    }

    @RequestMapping(path="/{id}", method = RequestMethod.PUT)
    public void update(@PathVariable int id, @RequestBody Race m) {
        m.setId(id);
        rm.updateRace(m);
    }
}
