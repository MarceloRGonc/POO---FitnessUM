/**
 * 
 * @author Grupo 16 
 */
import java.util.*;
import java.io.Serializable;
import java.text.DecimalFormat;
public class recCalorias implements Serializable{
    Map<String, TreeSet<SemDistancia>> recordes;
    
    public recCalorias() {
        this.recordes = new HashMap<String, TreeSet<SemDistancia>>();
        TreeSet<SemDistancia> r = new TreeSet<SemDistancia>(new RCalComparator());
        this.recordes.put(" ", r);
    }
    
    public recCalorias(Map<String, TreeSet<SemDistancia>> r) {
        this.recordes = new HashMap<String, TreeSet<SemDistancia>>();
        Iterator<Map.Entry<String, TreeSet<SemDistancia>>> it = r.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry<String, TreeSet<SemDistancia>> entry = it.next();
            TreeSet<SemDistancia> d = new TreeSet<SemDistancia>(new RCalComparator());
            Iterator<SemDistancia> itT = entry.getValue().iterator();
            while (itT.hasNext()) {
                SemDistancia desp = itT.next();
                d.add(desp.clone());
            }
            this.recordes.put(entry.getKey(),d);
        }
    }
    
    public recCalorias(recCalorias r) {
        this.recordes = new HashMap<String, TreeSet<SemDistancia>>();

        Iterator<Map.Entry<String, TreeSet<SemDistancia>>> it = r.recordes.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry<String, TreeSet<SemDistancia>> entry = it.next();
            TreeSet<SemDistancia> d = new TreeSet<SemDistancia>(new RCalComparator());
            Iterator<SemDistancia> itT = entry.getValue().iterator();
            while (itT.hasNext()) {
                SemDistancia desp = itT.next();
                d.add(desp.clone());
            }
            this.recordes.put(entry.getKey(), d);
        }
    }
    
    public recCalorias clone(){ return new recCalorias(this); }
    
    public boolean equals(Object o) {
        if (this == o) return true;
        else if (o == null || this.getClass() != o.getClass()) return false;
        else{
            recCalorias r = (recCalorias) o;
            if (r.getNAt() != this.getNAt()) return false;

            else {
                Iterator<Map.Entry<String, TreeSet<SemDistancia>>> it = this.recordes.entrySet().iterator();
                while (it.hasNext()) {
                    Map.Entry<String, TreeSet<SemDistancia>> entry = it.next();
                    TreeSet<SemDistancia> aux = r.getRAt(entry.getKey());
                    Iterator<SemDistancia> itT = entry.getValue().iterator();
                    Iterator<SemDistancia> itO = aux.iterator();
                    while (itT.hasNext()) {
                        if (!itO.hasNext())
                            return false;
                        else if (itT.next().getCaloriasH() != itO.next().getCaloriasH())
                                return false;
                    }
                }
                return true;
            }
        }
    }
    
    public String toString() {
        StringBuilder sb = new StringBuilder();

        Iterator<Map.Entry<String, TreeSet<SemDistancia>>> it = this.recordes.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry<String, TreeSet<SemDistancia>> entry = it.next();
            String nome = entry.getKey();
            TreeSet<SemDistancia> t = entry.getValue();

            if (!nome.equals("")) { sb.append("\n Record Pessoal: " + nome + "\n"); }

            DecimalFormat decimal = new DecimalFormat("0.00");
            int flag = 0;
            for (SemDistancia des : t) {
                if (flag != 0) break;
                else flag++;
                sb.append("Tempo: " + des.getTempo().toString() + "\n");
                sb.append("Calorias despendidas: " + decimal.format(des.getCaloriasH()) + " kCal/h\n");
            }
        }
        return sb.toString();
    }
    
    /* Número de atividades com registo nos recordes */
    public int getNAt() { return this.recordes.size(); }
    
    public TreeSet<SemDistancia> getRAt(String n) {
        TreeSet<SemDistancia> t = new TreeSet<SemDistancia>(new RCalComparator());

        if (!this.recordes.containsKey(n)) {
            return t;
        } else {
            for (SemDistancia d : this.recordes.get(n))
                t.add(d.clone());
            return t;
        }
    }
    
    public void addRAt(Desporto n) {
        SemDistancia des = (SemDistancia) n;

        if (des == null) return;

        if (this.recordes.containsKey(des.getNome_desporto())) {
            TreeSet<SemDistancia> t = this.recordes.get(des.getNome_desporto());
            t.add(des);
            this.recordes.put(des.getNome_desporto(), t);
        }
        else {
            TreeSet<SemDistancia> t = new TreeSet<SemDistancia>(new RCalComparator());
            t.add(des);
            this.recordes.put(des.getNome_desporto(), t);
        }
    } 
    
    public String getRecorde(Desporto desporto){
        String nome = desporto.getNome_desporto();
        StringBuilder sb = new StringBuilder();
        String t = "Desporto não encontrado\n";
        if (this.recordes.containsKey(nome)) {
            TreeSet<SemDistancia> aux = this.recordes.get(nome);
            DecimalFormat f = new DecimalFormat("0.00");
            for (SemDistancia atv : aux) {
                sb.append("\nRecord Pessoal: " + atv.getNome_desporto() + "\n" 
                        + "Tempo: " + atv.getTempo().toString() 
                        + "Calorias dispendidas: " + f.format(atv.getCaloriasH()) + " kCal/h\n");
                break;
            }
            return sb.toString();
        } else
            return t;
    }
}
