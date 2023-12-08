///**
// * @author dmann
// * @createdOn 11/1/2023 at 3:03 PM
// * @projectName Fantasy World API
// * @packageName csc280.fantasyworldapi.methods;
// */
//package csc280.fantasyworldapi.methods;
//
//import csc280.fantasyworldapi.objects.Spell;
//
//import java.util.ArrayList;
//import java.util.List;
//
//public class SpellMethods {
//
//    ArrayList<Spell> spells = new ArrayList<>();
//
//    public void addSpell(Spell document) {
//        spells.add(document);
//    }
//
//    public List<Spell> findAllSpells() {
//        return spells;
//    }
//
//    public Spell findSpellById(int id) {
//        return spells.stream().filter(m -> m.getId() == id).findFirst().orElse(null);
//    }
//
//    public void deleteSpell(int id) {
//        spells.removeIf(m -> m.getId() == id);
//    }
//
//    public void updateSpell(Spell m) {
//        for (Spell x : spells){
//            if (x.getId()==m.getId()){
//                x.setSpellName(m.getSpellName());
//                x.setSpellImage(m.getSpellImage());
//                x.setSpellDescription(m.getSpellDescription());
//                x.setSpellCastingTime(m.getSpellCastingTime());
//                x.setSpellCost(m.getSpellCost());
//            }
//        }
//    }
//}