/**
 * @author dmann
 * @createdOn 11/1/2023 at 2:34 PM
 * @projectName Fantasy World API
 * @packageName csc280.fantasyworldapi;
 */
package csc280.fantasyworldapi.objects;

public class Class {
    private int id;
    private String className, classImage, classDescription;
    private String[] classPrimaryAbility, classSaves;

    public Class(int id, String className, String classImage, String classDescription, String[] classPrimaryAbility, String[] classSaves) {
        this.id = id;
        this.className = className;
        this.classImage = classImage;
        this.classDescription = classDescription;
        this.classPrimaryAbility = classPrimaryAbility;
        this.classSaves = classSaves;
    }

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

    public String[] getClassPrimaryAbility() {
        return classPrimaryAbility;
    }

    public void setClassPrimaryAbility(String[] classPrimaryAbility) {
        this.classPrimaryAbility = classPrimaryAbility;
    }

    public String[] getClassSaves() {
        return classSaves;
    }

    public void setClassSaves(String[] classSaves) {
        this.classSaves = classSaves;
    }
}
