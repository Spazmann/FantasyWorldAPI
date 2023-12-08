/**
 * @author dmann
 * @createdOn 11/1/2023 at 2:45 PM
 * @projectName Fantasy World API
 * @packageName csc280.fantasyworldapi;
 */
package csc280.fantasyworldapi.objects;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Race {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false)
    private String raceName, raceImage, raceDescription;

    @OneToMany(mappedBy = "race")
    @JsonIgnore
    private List<Character> characters = new ArrayList<>();

    public int getId() {
        return id;
    }

    public List<Character> getCharacters() {
        return characters;
    }

    public void setCharacters(List<Character> characters) {
        this.characters = characters;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRaceName() {
        return raceName;
    }

    public void setRaceName(String raceName) {
        this.raceName = raceName;
    }

    public String getRaceImage() {
        return raceImage;
    }

    public void setRaceImage(String raceImage) {
        this.raceImage = raceImage;
    }

    public String getRaceDescription() {
        return raceDescription;
    }

    public void setRaceDescription(String raceDescription) {
        this.raceDescription = raceDescription;
    }
}
