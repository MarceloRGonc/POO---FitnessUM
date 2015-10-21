/**
 * 
 * @author Grupo 16
 */
import java.util.*;
import java.io.Serializable;

public abstract class SemDistancia extends Desporto implements Serializable
{
    public SemDistancia (String nome){
        super(nome);
    }
    
    public SemDistancia (int peso,GregorianCalendar data, String Nome_desporto, String weather, Tempo t){
        super(peso,data,Nome_desporto,weather,t);
    }
    
    public SemDistancia (SemDistancia f){
        super(f);
    }
    
    /**Verifica se dois Desportos deste tipo sao iguais*/
    public boolean equals(SemDistancia v) {
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
    public abstract SemDistancia clone();
}
