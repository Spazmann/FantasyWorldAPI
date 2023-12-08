/**
 * @author dmann
 * @createdOn 12/7/2023 at 10:37 PM
 * @projectName Fantasy World API
 * @packageName csc280.fantasyworldapi.restcontroller;
 */
package csc280.fantasyworldapi.restcontroller;

import csc280.fantasyworldapi.objects.*;
import csc280.fantasyworldapi.objects.Character;
import csc280.fantasyworldapi.objects.Class;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/character")
public class CharacterRestController {

    @Autowired
    private CharacterJPRepository characterJPRepository;

    @Autowired
    private RaceJPARepository raceJPARepository;

    @Autowired
    private ClassJPARepository classJPARepository;

    @PostMapping("/add")
    @ResponseStatus(code= HttpStatus.NO_CONTENT)
    public void addPastEnrollment(@RequestBody Character pe) {

        Race newRace = raceJPARepository.findById(pe.getRace().getId()).orElse(null);
        Class newClass = classJPARepository.findById(pe.getaClass().getId()).orElse(null);

        pe.setRace(newRace);
        pe.setaClass(newClass);

        characterJPRepository.save(pe);

        //post like this:

//        {
//            "characterName": Bob,
//            "aClass": {
//                  "id": 1
//                       },
//            "race": {
//                   "id": "1"
//                      }
//        }

    }
}
