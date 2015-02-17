package dcp.logic.factory;

import org.apache.pivot.collections.ArrayList;
import org.apache.pivot.collections.List;

import dcp.logic.factory.TypeFactory.LOG_LEVEL;
import dcp.logic.model.Group;
import dcp.logic.model.Pack;
import dcp.main.log.Out;


public class PackFactory
{
    //Data
    private static List<Pack> packs = new ArrayList<Pack>();//List of packs
    
    //Get all Packs data
    public static List<Pack> getPacks() { return packs; }//Get packs
    
    //Returns the pack of index
    public static Pack get(int index) {
        if (index >= 0 && index < packs.getLength())
            return packs.get(index);
        return null;
    }
    public static List<Pack> getByName(String name) {
        assert name != null;
        if (name==null) return null;
        List<Pack> list = new ArrayList<Pack>();
        for(Pack P:packs)
            if (P.getName().equalsIgnoreCase(name))
                list.add(P);
        return list;
    }
    public static List<Pack> getByGroup(Group group) {
        assert group != null;
        if (group==null) return null;
        List<Pack> list = new ArrayList<Pack>();
        for(Pack P:packs)
            if (P.getGroup() != null && P.getGroup().equals(group))
                list.add(P);
        return list;
    }
    
    //Returns the index of a given Pack, or -1
    public static int indexOf(Pack pack) {
        for(int i = 0; i<packs.getLength(); i++)
            if (packs.get(i).equals(pack))
                return i;
        return -1;
    }
    
    //Add a pack
    public static boolean addPack(Pack pack) {
        packs.add(pack);
        Out.print(LOG_LEVEL.DEBUG, "Pack added: " + pack.getName());
        return true;
    }
    
    //Removes a pack
    public static boolean removePack(Pack pack) {
        packs.remove(pack);
        Out.print(LOG_LEVEL.DEBUG, "Pack deleted: " + pack.getName());
        return true;
    }
    
    //Clear all packs
    public static boolean clear() {
        packs.clear();
        Out.print(LOG_LEVEL.DEBUG, "All Packs erased.");
        return true;
    }
    
}
