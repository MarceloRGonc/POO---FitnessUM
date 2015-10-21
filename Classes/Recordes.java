/**
 * 
 * @author Grupo 16 
 */
import java.util.*;
import java.io.Serializable;

public class Recordes implements Serializable
{
    recDistancia dist;
    recCalorias cal;
    
    public Recordes(){
        this.dist = new recDistancia();
        this.cal = new recCalorias();
    }
    
    public Recordes(Recordes m){
        this.dist = new recDistancia(m.getRDist());
        this.cal = new recCalorias(m.getRCal());
    }
    
    public Recordes(recDistancia m, recCalorias c){
        this.dist = m.clone();
        this.cal = c.clone();
    }
    
    public recDistancia getRDist(){ return this.dist.clone(); }
    
    public recCalorias getRCal(){ return this.cal.clone(); }
    
    public boolean equals(Object o) {
        if (this == o) return true;
        if ((o == null) || (this.getClass() != o.getClass())) return false;
        
        Recordes umRecorde = (Recordes) o;
        
        return this.dist.equals(umRecorde.getRDist()) 
                && this.cal.equals(umRecorde.getRCal());
    }
    
    public String toStringD(){
        return this.dist.toString(); 
    } 
    
    public String toStringC(){
		return this.cal.toString();
	}
    
    public String toString(){
        StringBuilder s = new StringBuilder();
        s.append(dist.toString());
        s.append(cal.toString());
        s.append("\n");
        return s.toString();
    }
    
    public Recordes clone(){ return new Recordes(this); }
    
    public void addRecorde(Desporto novo) {
		if (novo instanceof ComDistancia) {
			this.dist.addRAt(novo);
		} else if (novo instanceof SemDistancia) {
			this.cal.addRAt(novo);
		}
	}
    
    public String recordeAt(Desporto d){
        if(d instanceof SemDistancia) return this.cal.getRecorde(d);
        else if(d instanceof ComDistancia) return this.dist.getRecorde(d);
        return "";
    }  
}
