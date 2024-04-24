<<<<<<< HEAD
package testers;

import java.util.List;

import registration.Registration;


public class TesterTrajectories extends TesterStateChanges {
    public static void main(String[] args) {
        TesterTrajectories tsc = new TesterTrajectories();
        tsc.createRegistrations();
        tsc.changeRegistrations();
        tsc.displayTrajectories();
    }

    @Override
    protected void changeRegistrations() {
        super.changeRegistrations();
        this.johnDoe.setValidated(true);
        this.lisaMartin.setAffiliation("Arkham College");
        this.regState.updateStates();
    }

    protected void displayTrajectories() {
        for (Registration r : List.of(annSmith, johnDoe, lisaMartin)){

        }
    }
=======
package testers;

import java.util.*;
import object.*;
import registration.*;

/**
 * Clase para probar las trayectorias
 * 
 * @author eps
 */
public class TesterTrajectories extends TesterStateChanges{
    /**
     * Main que prueba la trayectoria
     * 
     * @param args los argumentos de main
     */
    public static void main(String[] args) {
        TesterTrajectories tsc = new TesterTrajectories();
        tsc.createRegistrations();
        tsc.changeRegistrations();
        tsc.displayTrajectories();
    }
    
    /**
     * Cambia las registraciones
     */
    @Override
    protected void changeRegistrations() {
        super.changeRegistrations();
            this.johnDoe.setValidated(true);
            this.lisaMartin.setAffiliation("Arkham College");
            this.regState.updateStates();
        }
    
    /**
     * Imprime las trayectorias
     */
    protected void displayTrajectories() {
        for (Registration r : List.of(annSmith, johnDoe, lisaMartin))
            System.out.println(r+": "+this.regState.trajectory(r));
    }
>>>>>>> a790931343c45a4c1410195e17ef62f8c17f4180
}