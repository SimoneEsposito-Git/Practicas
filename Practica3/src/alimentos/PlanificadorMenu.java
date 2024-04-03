package alimentos;

import java.util.*;

/**
 * Permite planificar un menu segun las condiciones
 * 
 * @author Lin Qi y Simone Eposito
 */
public class PlanificadorMenu {
    private List<Plato> platos;
    private Menu menu;
    private Map<ElementoNutricional, Double> condiciones = new HashMap<>(); 
    private Set<Alergeno> alergenos = new HashSet<>();

    /**
     * Constructor de planificador de menu
     * 
     * @param platos una lista de platos para anyadir al menu
     */
    public PlanificadorMenu(List<Plato> platos) {
        this.platos = new ArrayList<>(platos);
    }

    /**
     * Anyade una condicion de maximo al planificador
     * 
     * @param elemento indica el tipo de nutricion
     * @param max indica el maximo
     * @return el planificador si mismo
     */
    public PlanificadorMenu conMaximo(ElementoNutricional elemento, double max) {
        if ((this.condiciones).containsKey(elemento)) {
            (this.condiciones).replace(elemento, max);
            return this;
        }
        (this.condiciones).put(elemento, max);
        return this;
    }

    /**
     * Indica el rango de calorias
     * 
     * @param min el minimo valor de calorias
     * @param max el maximo valor de calorias
     * @return el menu que se crea teniendo en cuenta las condiciones
     */
    public Menu planificar(double min, double max) {
        int flag, i, n;
        double caloria;
        List<Plato> platos = new ArrayList<>();
        List<List<Plato>> listplato;
        if (!((this.alergenos).isEmpty())) {
            for (Plato plato: this.platos) {
                flag = 1;
                for (Alergeno alergeno: this.alergenos) {
                    if ((plato.getAlergenos()).contains(alergeno)) {
                        flag = 0;
                        break;
                    }
                }
                if (flag == 1) {
                    platos.add(plato);
                }
            }
        }
        if (platos.isEmpty()) {
            return null;
        }
        n = platos.size();
        for (i = 1; i <= n; i++) {
            listplato = Combination.getCombinations(platos, i);
            for (List<Plato> listp: listplato) {
                this.menu = new Menu(listp);
                caloria = ((this.menu).infoNutricional).getCalorias();
                if (caloria >= min && caloria <= max && this.checkAllValue()) {
                    return this.menu;
                }
            }
        }
        this.menu = null;
        return null;
    }

    /**
     * Indica cuales alergenos se deben quitar
     * 
     * @param alergenos los posibles alergenos que se deben quitar
     * @return si mismo
     */
    public PlanificadorMenu sinAlergenos(Alergeno... alergenos) {
        (this.alergenos).addAll(Arrays.asList(alergenos));
        return this;
    }

    /**
     * Comprobar el valor de las nutriciones
     * 
     * @param element tipo de elemento para comprobar
     * @return true si el valor es menor que max, false si es mayor
     */
    private boolean checkValue(ElementoNutricional element) {
        double value = 0;
        if (element == ElementoNutricional.HIDRATOS_DE_CARBONO) {
            value = ((this.menu).getInfoNutricional()).getHidratosDeCarbono();
        }
        else if (element == ElementoNutricional.GRASA) {
            value = ((this.menu).getInfoNutricional()).getGrasas();        
        }
        else if (element == ElementoNutricional.GRASA_SATURADA) {
            value = ((this.menu).getInfoNutricional()).getGrasasSaturadas();
        }
        else if (element == ElementoNutricional.PROTEINA) {
            value = ((this.menu).getInfoNutricional()).getProteinas();
        }
        else if (element == ElementoNutricional.AUCARES) {
            value = ((this.menu).getInfoNutricional()).getAzucar();
        }
        else if (element == ElementoNutricional.FIBRA) {
            value = ((this.menu).getInfoNutricional()).getFibra();
        }
        else if (element == ElementoNutricional.SODIO) {
            value = ((this.menu).getInfoNutricional()).getSodio();
        }
        if ((this.condiciones).get(element) == null) {
            return true;
        }
        else {
            return value <= (this.condiciones).get(element);
        }
    }

    /**
     * Chequea todas las condiciones del planificador
     * 
     * @return true si cumple todas las condiciones, false si no
     */
    private boolean checkAllValue() {
        for (ElementoNutricional element: (this.condiciones).keySet()) {
            if (!(this.checkValue(element))) {
                return false;
            }
        }
        return true;
    }
}
