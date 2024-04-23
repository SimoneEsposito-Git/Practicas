package testers;

import registration.*;

/**
 * Clase para probar la igualdad de registracion
 * 
 * @author eps
 */
public class TesterRepeatedObjects extends TesterStateChanges {
    /**
     * Main que prueba la igualdad de registracion
     * 
     * @param args los argumentos de main
     */
    public static void main(String[] args) {
        TesterRepeatedObjects tsc = new TesterRepeatedObjects();
        tsc.createRegistrations();
        tsc.regState.addObjects(new Registration("Ann Smith", RegistrationKind.STUDENT)); // Discarded, since repeated
        System.out.println(tsc.regState);
    }
}