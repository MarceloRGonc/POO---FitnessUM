/**
 * 
 * @author Grupo 16
 */
import java.util.*;
import java.io.Serializable;

public abstract class SemAltimetria extends ComDistancia implements Serializable
{
    //Construtores
    public SemAltimetria (String nome){
        super(nome);
    }
    public SemAltimetria (int peso,GregorianCalendar data, String Nome_deporto,String weather,Tempo t, double distancia, double vel_maxima, double vel_minima){
        super(peso,data,Nome_deporto,weather,t,distancia,vel_maxima,vel_minima);
    }
    public SemAltimetria (SemAltimetria f){
        super(f);
    }
    
    /**Verifica se dois Desportos deste tipo sao iguais*/
    public boolean equals(SemAltimetria v) {
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
    public abstract SemAltimetria clone();

}
