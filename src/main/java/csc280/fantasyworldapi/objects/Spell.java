/**
 * @author dmann
 * @createdOn 11/1/2023 at 2:45 PM
 * @projectName Fantasy World API
 * @packageName csc280.fantasyworldapi;
 */
package csc280.fantasyworldapi.objects;

public class Spell {
    private int id;
    private String spellName, spellDescription, spellImage, spellCastingTime, spellCost;

    public Spell(int id, String spellName, String spellDescription, String spellImage, String spellCastingTime, String spellCost) {
        this.id = id;
        this.spellName = spellName;
        this.spellDescription = spellDescription;
        this.spellImage = spellImage;
        this.spellCastingTime = spellCastingTime;
        this.spellCost = spellCost;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSpellName() {
        return spellName;
    }

    public void setSpellName(String spellName) {
        this.spellName = spellName;
    }

    public String getSpellDescription() {
        return spellDescription;
    }

    public void setSpellDescription(String spellDescription) {
        this.spellDescription = spellDescription;
    }

    public String getSpellImage() {
        return spellImage;
    }

    public void setSpellImage(String spellImage) {
        this.spellImage = spellImage;
    }

    public String getSpellCastingTime() {
        return spellCastingTime;
    }

    public void setSpellCastingTime(String spellCastingTime) {
        this.spellCastingTime = spellCastingTime;
    }

    public String getSpellCost() {
        return spellCost;
    }

    public void setSpellCost(String spellCost) {
        this.spellCost = spellCost;
    }
}
