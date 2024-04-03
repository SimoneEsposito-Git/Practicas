package testers;

import java.util.List;
import alimentos.*;

public class FicherosTester extends MenusTester{
    public static void main(String[] args) {
        FicherosTester tester = new FicherosTester();
        List<Menu> menus = tester.crearMenus();
        ManejadorFicheros.guardarFichero("menus.txt", menus);
        ManejadorFicheros.leerFichero("menus.txt");
        for (Menu menu : ManejadorFicheros.getMenus()) {
            System.out.println("* " + menu);
        }
    }
}