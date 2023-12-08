/**
 * @author dmann
 * @createdOn 11/1/2023 at 3:04 PM
 * @projectName Fantasy World API
 * @packageName csc280.fantasyworldapi.restmethods;
 */
package csc280.fantasyworldapi.restcontroller;

import csc280.fantasyworldapi.objects.Class;
import csc280.fantasyworldapi.objects.Race;
import csc280.fantasyworldapi.objects.RaceJPARepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.List;

@RestController
@RequestMapping("/race")
public class RaceRestController {

    @Autowired
    private RaceJPARepository raceJPARepository;

    @RequestMapping(path = "", method = RequestMethod.POST)
    @ResponseStatus(code = HttpStatus.CREATED)
    public void createRace(@RequestBody Race document) throws SQLException {
        raceJPARepository.save(document);
    }


    @RequestMapping(path = "", method = RequestMethod.GET)
    public List<Race> findAllMessages() throws SQLException {
        return raceJPARepository.findAll();
    }

    @RequestMapping(path = "/{id}", method = RequestMethod.GET)
    public Race findOneMessage(@PathVariable int id) throws SQLException {
        return raceJPARepository.findById(id).get();
    }

    @RequestMapping(path = "/{id}", method = RequestMethod.DELETE)
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    public void DeleteIt(@PathVariable int id) throws SQLException {
        raceJPARepository.deleteById(id);
    }

    @RequestMapping(path = "/{id}", method = RequestMethod.PUT)
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    public void update(@PathVariable int id, @RequestBody Race m) throws SQLException {
        Race r = raceJPARepository.findById(id).get();
        r.setRaceName(m.getRaceName());
        r.setRaceImage(m.getRaceImage());
        r.setRaceDescription(m.getRaceDescription());
        raceJPARepository.save(r);
    }
}