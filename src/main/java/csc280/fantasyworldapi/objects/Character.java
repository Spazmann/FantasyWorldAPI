/**
 * @author dmann
 * @createdOn 12/7/2023 at 10:20 PM
 * @projectName Fantasy World API
 * @packageName csc280.fantasyworldapi.objects;
 */
package csc280.fantasyworldapi.objects;

import jakarta.persistence.*;

@Entity
@Table(name = "`character`")
public class Character {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false)
    private String characterName;

    @ManyToOne
    private Class aClass;

    @ManyToOne
    private Race race;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCharacterName() {
        return characterName;
    }

    public void setCharacterName(String characterName) {
        this.characterName = characterName;
    }

    public Class getaClass() {
        return aClass;
    }

    public void setaClass(Class aClass) {
        this.aClass = aClass;
    }

    public Race getRace() {
        return race;
    }

    public void setRace(Race race) {
        this.race = race;
    }
}
