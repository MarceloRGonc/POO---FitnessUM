/**
 * 
 * @author Grupo 16 
 */
import java.util.*;
import java.io.Serializable;

public class Futsal extends SemAltimetria implements Serializable
{
    public Futsal (){
        super("Futsal");
    }
    
    public Futsal (int peso,GregorianCalendar data, String Nome_deporto,String weather, Tempo t, double distancia, double vel_maxima, double vel_minima){
        super(peso,data,Nome_deporto,weather,t,distancia,vel_maxima,vel_minima);
    }
    
    public Futsal (Futsal f){
        super(f);
    }
    
    /**Verifica se dois Desportos deste tipo sao iguais*/
    public boolean equals(Futsal v) {
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
    public Futsal clone(){
        return(new Futsal(this));
    }
    
    /** Metodo que calcula as calorias dispendidas */
    public double calculaCal(int p, double h){
        double t = 500/75;
        return (t*p*h);
    }
}
