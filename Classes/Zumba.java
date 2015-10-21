/**
 * 
 * @author Grupo 16 
 */
import java.util.*;
import java.io.Serializable;

public class Zumba extends SemDistancia implements Serializable
{
    public Zumba (){
        super("Zumba");
    }
    
    public Zumba (int peso,GregorianCalendar data, String atividade, String weather, Tempo t){
        super(peso,data,atividade,weather,t);
    }
    
    public Zumba (Zumba f){
        super(f);
    }
    
    /**Verifica se dois Desportos deste tipo sao iguais*/
    public boolean equals(Zumba v) {
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
    public Zumba clone(){
        return(new Zumba(this));
    }
    
    /** Metodo que calcula as calorias dispendidas */
    public double calculaCal(int p, double h){
        double t = 450/75;
        return (t*p*h);
    }
}
