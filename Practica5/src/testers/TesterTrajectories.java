package testers;

import java.util.*;
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
}