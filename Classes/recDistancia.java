/**
 * 
 * @author Grupo 16
 */
import java.util.*;
import java.io.Serializable;
import java.text.DecimalFormat;

public class recDistancia implements Serializable
{
    private Map<String,TreeSet<ComDistancia>> recordes;
    
    public recDistancia() {
        this.recordes = new HashMap<String, TreeSet<ComDistancia>>();
        TreeSet<ComDistancia> r = new TreeSet<ComDistancia>(new RDistComparator());
        this.recordes.put(" ", r);
    }
    
    public recDistancia(Map<String, TreeSet<ComDistancia>> r) {
        this.recordes = new HashMap<String, TreeSet<ComDistancia>>();
        Iterator<Map.Entry<String, TreeSet<ComDistancia>>> it = r.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry<String, TreeSet<ComDistancia>> entry = it.next();
            TreeSet<ComDistancia> d = new TreeSet<ComDistancia>(new RDistComparator());
            Iterator<ComDistancia> itT = entry.getValue().iterator();
            while (itT.hasNext()) {
                ComDistancia desp = itT.next();
                d.add(desp.clone());
            }
            this.recordes.put(entry.getKey(),d);
        }
    }
    
    public recDistancia(recDistancia r) {
        this.recordes = new HashMap<String, TreeSet<ComDistancia>>();

        Iterator<Map.Entry<String, TreeSet<ComDistancia>>> it = r.recordes.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry<String, TreeSet<ComDistancia>> entry = it.next();
            TreeSet<ComDistancia> d = new TreeSet<ComDistancia>(new RDistComparator());
            Iterator<ComDistancia> itT = entry.getValue().iterator();
            while (itT.hasNext()) {
                ComDistancia desp = itT.next();
                d.add(desp.clone());
            }
            this.recordes.put(entry.getKey(), d);
        }
    }
    
    public recDistancia clone(){ return new recDistancia(this); }
    
    public boolean equals(Object o) {
        if (this == o) return true;
        else if (o == null || this.getClass() != o.getClass()) return false;
        else{
            recDistancia r = (recDistancia) o;
            if (r.getNAt() != this.getNAt()) return false;

            else {
                Iterator<Map.Entry<String, TreeSet<ComDistancia>>> it = this.recordes.entrySet().iterator();
                while (it.hasNext()) {
                    Map.Entry<String, TreeSet<ComDistancia>> entry = it.next();
                    TreeSet<ComDistancia> aux = r.getRAt(entry.getKey());
                    Iterator<ComDistancia> itT = entry.getValue().iterator();
                    Iterator<ComDistancia> itO = aux.iterator();
                    while (itT.hasNext()) {
                        if (!itO.hasNext())
                            return false;
                        else if (itT.next().getVelmed() != itO.next().getVelmed())
                                return false;
                    }
                }
                return true;
            }
        }
    }
    
    public String toString() {
        StringBuilder sb = new StringBuilder();

        Iterator<Map.Entry<String, TreeSet<ComDistancia>>> it = this.recordes.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry<String, TreeSet<ComDistancia>> entry = it.next();
            String nome = entry.getKey();
            TreeSet<ComDistancia> t = entry.getValue();

            if (!nome.equals("")) { sb.append("\n Record Pessoal: " + nome + "\n"); }

            DecimalFormat decimal = new DecimalFormat("0.00");
            int flag = 0;
            for (ComDistancia des : t) {
                if (flag != 0) break;
				else flag++;
                sb.append("Tempo: " + des.getTempo().toString() + "\n");
                sb.append("Distância percorrida: " + des.getDistancia() + " km\n");
                sb.append("Velocidade média: " + decimal.format(des.getVelmed()) + " km/h \n");
            }
        }
        return sb.toString();
    }
    
    /* Número de atividades com registo nos recordes */
    public int getNAt() { return this.recordes.size(); }
    
    public TreeSet<ComDistancia> getRAt(String n) {
		TreeSet<ComDistancia> t = new TreeSet<ComDistancia>(new RDistComparator());

		if (!this.recordes.containsKey(n)) {
			return t;
		} else {
		    for (ComDistancia d : this.recordes.get(n))
				t.add(d.clone());
			return t;
		}
	}
	
	public void addRAt(Desporto n) {
	    ComDistancia des = (ComDistancia) n;

	    if (des == null) return;

	    if (this.recordes.containsKey(des.getNome_desporto())) {
	        TreeSet<ComDistancia> t = this.recordes.get(des.getNome_desporto());
	        t.add(des);
	        this.recordes.put(des.getNome_desporto(), t);
	    }
	    else {
	        TreeSet<ComDistancia> t = new TreeSet<ComDistancia>(
	        new RDistComparator());
	        t.add(des);
	        this.recordes.put(des.getNome_desporto(), t);
	    }
    }
    
    public String getRecorde(Desporto desporto){
        String nome = desporto.getNome_desporto();
        StringBuilder sb = new StringBuilder();
        String t = "Desporto não encontrado\n";
		if (this.recordes.containsKey(nome)) {
			TreeSet<ComDistancia> aux = this.recordes.get(nome);
			DecimalFormat f = new DecimalFormat("0.00");
			for (ComDistancia atv : aux) {
				sb.append("\nRecord Pessoal: " + atv.getNome_desporto() + "\n" + "Tempo: " + atv.getTempo().toString() 
				        + "Distância percorrida: " + atv.getDistancia() + " km\n" + "Velocidade média: "
						+ f.format(atv.getVelmed()) + " km/h \n");
				break;
			}
			return sb.toString();
		} else
			return t;
    }
}
