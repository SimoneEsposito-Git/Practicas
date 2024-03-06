import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;

public class Menu{
    private HashSet<Plato> platos;
    public Menu(Plato... platos){
        this.platos = new HashSet<>(Arrays.asList(platos));
    }
    public String toString(){
        String platos = "";
        Iterator<Plato> it = this.platos.iterator();
        if (it.hasNext()) {
            platos += it.next().getNombre();
            while (it.hasNext()) {
                platos += (", " + it.next().getNombre());
            }
        }
        return "["+platos+"] ";
    }
}