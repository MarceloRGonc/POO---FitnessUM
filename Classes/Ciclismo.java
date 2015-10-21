/**
 * 
 * @author Grupo 16 
 */
import java.util.*;
import java.io.Serializable;

public class Ciclismo extends ComAltimetria implements Serializable
{
    public Ciclismo(){
        super("Ciclismo");
    }
    
    public Ciclismo(int peso,GregorianCalendar data,String Nome_deporto,String weather, 
                   Tempo t, double distancia, double vel_maxima, double vel_minima,
                   double alt_min, double alt_max, double t_des, double t_asc){
        super(peso,data,Nome_deporto,weather,t,distancia,vel_maxima,vel_minima,alt_min,alt_max,t_des,t_asc);
    }
    
    public Ciclismo(Ciclismo f){
        super(f);
    }
    
    /**Verifica se dois Desportos deste tipo sao iguais*/
    public boolean equals(Ciclismo v) {
       return super.equals(v);  
    }
    
    /** Converte para uma representação textual */
    public String toString(){
        StringBuilder s = new StringBuilder();
            s.append(super.toString());
            s.append("\n");
        return s.toString(); 
    }
    
    /** Cria uma cópia do receptor*/
    public Ciclismo clone(){
        return(new Ciclismo(this));
    }
    
    /** Metodo que calcula as calorias dispendidas */
    public double calculaCal(int p, double h){
        double t = 800/75;
        return (t*p*h);
    }
}
