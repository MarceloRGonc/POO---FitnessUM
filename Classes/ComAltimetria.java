
/**
 * 
 * @author Grupo 16
 */
import java.util.*;
import java.io.Serializable;

public abstract class ComAltimetria extends ComDistancia implements Serializable
{
    // variáveis de instância
    private double alt_min; //Altitude mínima atingida
    private double alt_max; //Altitude máxima atingida
    private double t_des; //Total de km descendentes
    private double t_asc; //Total de km ascendentes
    
    //Construtores
    public ComAltimetria (String nome){
        super(nome);
        this.alt_min = 0.0;
        this.alt_max = 0.0;
        this.t_des = 0.0;
        this.t_asc = 0.0;
    }
    
    public ComAltimetria (int peso,GregorianCalendar data,String Nome_deporto,String weather, 
                            Tempo t, double distancia, double vel_maxima, double vel_minima,
                            double alt_min, double alt_max, double t_des, double t_asc){
        super(peso,data,Nome_deporto,weather,t,distancia,vel_maxima,vel_minima);
        this.alt_min = alt_min;
        this.alt_max = alt_max;
        this.t_des = t_des;
        this.t_asc = t_asc;
    }
  
    public ComAltimetria (ComAltimetria f){
        super(f);
        this.alt_min = f.getAlt_min();
        this.alt_max = f.getAlt_max();
        this.t_des = f.getT_des();
        this.t_asc = f.getT_asc();
    }
    
    //Metodos de instancia
    /** Devolve a distancia percorrida */
    public double getAlt_min() {return alt_min;} 
    /** Devolve a velocidade máxima */
    public double getAlt_max() {return alt_max;}
    /** Devolve a velocidade minima */
    public double getT_des() {return t_des;}
    /** Devolve a velocidade média */
    public double getT_asc() {return t_asc;}
    
    /** Muda a distancia percorrida */
    public void setAlt_min() {this.alt_min = alt_min;} 
    /** Muda a velocidade máxima */
    public void setAlt_max() {this.alt_max = alt_max;}
    /** Muda a velocidade minima */
    public void setT_des() {this.t_des = t_des;}
    /** Muda a velocidade média */
    public void setT_asc() {this.t_asc = t_asc;}
    
    /**Verifica se dois Desportos deste tipo sao iguais*/
    public boolean equals(ComDistancia v) {
       return super.equals(v);  
    }
    
    /** Converte para uma representação textual */
    public String toString(){
        StringBuilder s = new StringBuilder();
            s.append(super.toString());
            s.append("Altitude Mínima: " + alt_min + "m\n");
            s.append("Altitude Máxima: " + alt_max + "m\n");
            s.append("Total Descendente: " + t_des + "Km\n");
            s.append("Total Ascendente: " + t_asc + "Km\n");
        return s.toString(); 
    }
    
    /** Cria uma cópia do receptor*/
    public abstract ComAltimetria clone();

}
