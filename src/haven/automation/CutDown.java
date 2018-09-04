package haven.automation;

import haven.*;
import java.util.*;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.util.HashSet;
import java.util.Set;

import static haven.OCache.posres; // posres calculates the position of gobs in the 3d plane

public class CutDown implements Runnable {
    private GameUI gui;
    private Gob object;
    private Set<String> vines = new HashSet<>(1);
    public boolean plantLives = true;
    private int numOfPlants = 0;
    private ArrayList<Gob> allPlants = new ArrayList<Gob>(1);

    public CutDown(GameUI gui){
        this.gui = gui;
        vines.add("gfx/tiles/paving/stranglevine");
    }

    public void shutdown() {
      plantLives = false;
    }

    @Override // implements runnable, an abstract class; just a tag, overrides a method from parent
    public void run() {

      //while (plantLives){
        Gob plantToKill = null;

        synchronized (gui.map.glob.oc){
            for(Gob gob : gui.map.glob.oc) {
                try {
                    // gonna run important stuff
                    // for each gob item; after each vine is found, it says
                    //'found vine' and the last vine found becomes the plantToKill
                    Resource res = gob.getres();
                    System.out.println(res.name);
                    /*if (res != null && vines.contains(res.name)) {
                      //System.out.println("found vine");
                      Coord2d plc = gui.map.player().rc;
                      if ((plantToKill == null || gob.rc.dist(plc) < plantToKill.rc.dist(plc)))
                          plantToKill = gob;
                          numOfPlants = numOfPlants +1;
                          allPlants.add(gob);
                    } else {

                    }*/
                } catch (Exception e){
                  //plantLives = false;
                    System.out.println(e);
                    // nothing recorded from TrellisDestroy
                }
            }
        }

        // the plants need to be sorted via coordinates
        /*
        if (plantToKill == null){
          plantLives = false;
          return;
        }
        for (int x = 0; x < numOfPlants;x++){
          plantToKill = allPlants.get(x);
          try{
          gui.act("destroy");
          gui.error("I destroyed a vine.");
          gui.map.wdgmsg("click", plantToKill.sc, plantToKill.rc.floor(posres), 1, 0, 0, (int) plantToKill.id, plantToKill.rc.floor(posres), 0, -1);
          try {
              Thread.sleep(5000);
          } catch (InterruptedException e) {
              return;
          }
          gui.map.wdgmsg("click", Coord.z, Coord.z, 3, 0);
          } catch(Loading l){

          }

        }*/
      //gui.map.wdgmsg("click", Coord.z, Coord.z, 4, 0);

        // command that gets destroy thingy
        // gui.act("destroy");
        // some clicky stuff, trellisDestroy has two clicks
        // gui.map.wdgmsg("click"
      //}
      //gui.error("All vines destroyed.");
    }

}
