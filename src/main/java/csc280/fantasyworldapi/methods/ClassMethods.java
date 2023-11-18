/**
 * @author dmann
 * @createdOn 11/1/2023 at 3:03 PM
 * @projectName Fantasy World API
 * @packageName csc280.fantasyworldapi.methods;
 */
package csc280.fantasyworldapi.methods;

import csc280.fantasyworldapi.objects.Class;

import java.util.ArrayList;
import java.util.List;

public class ClassMethods {

    ArrayList<Class> classes = new ArrayList<>();

    public void addClass(Class document) {
        classes.add(document);
    }

    public List<Class> findAllClasses() {
        return classes;
    }

    public Class findClassById(int id) {
        return classes.stream().filter(m -> m.getId() == id).findFirst().orElse(null);
    }

    public void deleteClass(int id) {
        classes.removeIf(m -> m.getId() == id);
    }

    public void updateClass(Class m) {
        for (Class x : classes){
            if (x.getId()==m.getId()){
                x.setClassName(m.getClassName());
                x.setClassImage(m.getClassImage());
                x.setClassDescription(m.getClassDescription());
                x.setClassPrimaryAbility(m.getClassPrimaryAbility());
                x.setClassSaves(m.getClassSaves());
            }
        }
    }
}
