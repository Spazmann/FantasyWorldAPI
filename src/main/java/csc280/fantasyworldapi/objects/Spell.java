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
public class Spell {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false)
    private String spellName, spellDescription, spellImage;

    public List<Class> getClassesContainingSpell() {
        return classesContainingSpell;
    }

    public void setClassesContainingSpell(List<Class> classesContainingSpell) {
        this.classesContainingSpell = classesContainingSpell;
    }

    @ManyToMany
    @JsonIgnore
    private List<Class> classesContainingSpell = new ArrayList<>();

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
}
