/**
 * @author dmann
 * @createdOn 11/1/2023 at 2:45 PM
 * @projectName Fantasy World API
 * @packageName csc280.fantasyworldapi;
 */
package csc280.fantasyworldapi.objects;

public class Race {
    private int id;
    private String raceName, raceImage, raceDescription;
    private String[] raceRacialTraits;

    public Race(int id, String raceName, String raceImage, String raceDescription, String[] raceRacialTraits) {
        this.id = id;
        this.raceName = raceName;
        this.raceImage = raceImage;
        this.raceDescription = raceDescription;
        this.raceRacialTraits = raceRacialTraits;
    }

    public int getId() {
        return id;
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

    public String[] getRaceRacialTraits() {
        return raceRacialTraits;
    }

    public void setRaceRacialTraits(String[] raceRacialTraits) {
        this.raceRacialTraits = raceRacialTraits;
    }
}
