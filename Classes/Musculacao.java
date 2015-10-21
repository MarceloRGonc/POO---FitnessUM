/**
 * 
 * @author Grupo 16
 */
import java.util.*;
import java.io.Serializable;

public class Musculacao extends SemDistancia implements Serializable
{
    public Musculacao (){
        super("Musculação");
    }
    
    public Musculacao(int peso,GregorianCalendar data, String atividade, String weather, Tempo t){
        super(peso,data,atividade,weather,t);
    }
    
    public Musculacao(Musculacao f){
        super(f);
    }
    
    /**Verifica se dois Desportos deste tipo sao iguais*/
    public boolean equals(Musculacao v) {
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
    public Musculacao clone(){
        return(new Musculacao(this));
    }
    
    /** Metodo que calcula as calorias dispendidas */
    public double calculaCal(int p, double h){
        double t = 500/75;
        return (t*p*h);
    }
}
