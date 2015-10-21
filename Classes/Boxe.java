/**
 * 
 * @author Grupo 16 
 */
import java.util.*;
import java.io.Serializable;

public class Boxe extends SemDistancia implements Serializable
{
    public Boxe (){
        super("Boxe");
    }
    
    public Boxe (int peso,GregorianCalendar data, String atividade,String weather, Tempo t){
        super(peso,data,atividade,weather,t);
    }
    
    public Boxe (Boxe f){
        super(f);
    }
    
    /**Verifica se dois Desportos deste tipo sao iguais*/
    public boolean equals(Boxe v) {
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
    public Boxe clone(){
        return(new Boxe(this));
    }
    
    /** Metodo que calcula as calorias dispendidas */
    public double calculaCal(int p, double h){
        double t = 660/75;
        return (t*p*h);
    }
}
