package alimentos;

import java.util.*;

/**
 * Permite hacer combinaciones una lista de platos
 * 
 * @author Lin Qi y Simone Eposito
 */
public class Combination {

    /**
     * Devuelve las combinacion de un numero de platos a partir de una lista de platos
     * 
     * @param listPlato una lista de platos
     * @param n el numero de platos de las combinaciones
     * @return una lista que contiene todas las conbimaciones de n platos
     */
    public static List<List<Plato>> getCombinations(List<Plato> listPlato, int n) {
        List<List<Plato>> listres = new ArrayList<>();
        List<List<Plato>> listpre;
        List<Plato> listi;
        Plato element;
        int i, minium, length;
        if (n <= 0 || n > listPlato.size() || listPlato == null) {
            return listres;
        }
        else if (n == 1) {
            for (Plato j: listPlato) {
                listi = new ArrayList<>();
                listi.add(j);
                listres.add(listi);
            }
            return listres;
        }
        else if (n == listPlato.size()) {
            listres.add(listPlato);
            return listres;
        }
        else {
            length = listPlato.size() - 1;
            minium = n - 1;
            for (i = length; i >= minium; i--) {
                element = listPlato.get(i);
                listi = new ArrayList<>(listPlato.subList(0, i));
                listpre = getCombinations(listi, n - 1);
                for (List<Plato> listplato: listpre) {
                    listplato.add(element);
                }
                listres.addAll(listpre);
            }
            return listres;
        }
    }
}
