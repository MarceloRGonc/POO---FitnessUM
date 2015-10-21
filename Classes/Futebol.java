/**
 * 
 * @author Grupo 16 
 */
import java.util.*;
import java.io.Serializable;

public class Futebol extends SemAltimetria implements Serializable
{
    public Futebol(){
        super("Futebol");
    }
    
    public Futebol(int peso,GregorianCalendar data, String Nome_deporto,String weather, Tempo t, double distancia, double vel_maxima, double vel_minima){
        super(peso,data,Nome_deporto,weather,t,distancia,vel_maxima,vel_minima);
    }
    
    public Futebol(Futebol f){
        super(f);
    }
    
    /**Verifica se dois Desportos deste tipo sao iguais*/
    public boolean equals(Futebol v) {
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
    public Futebol clone(){
        return(new Futebol(this));
    }
    
    /** Metodo que calcula as calorias dispendidas */
    public double calculaCal(int p, double h){
        double t = 480/75;
        return (t*p*h);
    }
}
