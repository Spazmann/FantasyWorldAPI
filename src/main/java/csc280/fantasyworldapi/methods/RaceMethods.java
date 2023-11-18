/**
 * @author dmann
 * @createdOn 11/1/2023 at 3:03 PM
 * @projectName Fantasy World API
 * @packageName csc280.fantasyworldapi.methods;
 */
package csc280.fantasyworldapi.methods;

import csc280.fantasyworldapi.objects.Race;

import java.util.ArrayList;
import java.util.List;

public class RaceMethods {

    ArrayList<Race> races = new ArrayList<>();

    public void addRace(Race document) {
        races.add(document);
    }

    public List<Race> findAllRaces() {
        return races;
    }

    public Race findRaceById(int id) {
        return races.stream().filter(m -> m.getId() == id).findFirst().orElse(null);
    }

    public void deleteRace(int id) {
        races.removeIf(m -> m.getId() == id);
    }

    public void updateRace(Race m) {
        for (Race x : races){
            if (x.getId()==m.getId()){
                x.setRaceName(m.getRaceName());
                x.setRaceImage(m.getRaceImage());
                x.setRaceDescription(m.getRaceDescription());
                x.setRaceRacialTraits(m.getRaceRacialTraits());
            }
        }
    }
}