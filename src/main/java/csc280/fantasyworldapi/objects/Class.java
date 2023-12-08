/**
 * @author dmann
 * @createdOn 11/1/2023 at 2:34 PM
 * @projectName Fantasy World API
 * @packageName csc280.fantasyworldapi;
 */
package csc280.fantasyworldapi.objects;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Class {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    public List<Spell> getClassSpells() {
        return classSpells;
    }

    public void setClassSpells(List<Spell> classSpells) {
        this.classSpells = classSpells;
    }

    public List<Character> getCharacters() {
        return characters;
    }

    public void setCharacters(List<Character> characters) {
        this.characters = characters;
    }

    @Column(nullable = false)
    private String className, classImage, classDescription;

    @ManyToMany(mappedBy = "classesContainingSpell")
    @JsonIgnore
    private List<Spell> classSpells = new ArrayList<>();

    @OneToMany(mappedBy = "aClass")
    @JsonIgnore
    private List<Character> characters = new ArrayList<>();

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public String getClassImage() {
        return classImage;
    }

    public void setClassImage(String classImage) {
        this.classImage = classImage;
    }

    public String getClassDescription() {
        return classDescription;
    }

    public void setClassDescription(String classDescription) {
        this.classDescription = classDescription;
    }
}
