package domain.temas;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

/**
 *
 * @author hn
 */
public class Temas {

    List<Tema> temas;
    
    public Temas() {
        temas = new ArrayList<Tema>();
    }
    
    public Temas(Tema tema) {
        this();
        temas.add(tema);
    }
    
    public Temas(List<Tema> temas) {
        this.temas = temas;
    }
    
    public String toString() {
        ListIterator<Tema> it = temas.listIterator();
        
        StringBuilder s = new StringBuilder();
        while (it.hasNext()) {
            s.append(it.next());
            s.append(" ,");
        }
        s.delete(s.length()-2, s.length()-1);
        return s.toString();
    }
}
