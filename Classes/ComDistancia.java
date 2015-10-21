
/**
 * 
 * @author Grupo 16
 */
import java.util.*;
import java.io.Serializable;

public abstract class ComDistancia extends Desporto implements Serializable
{
   // variáveis de instância
   private double distancia; //distancia percorrida
   private double vel_maxima; //velocidade máxima atingida
   private double vel_minima;  //velocidade mínima atingida
   private double vel_media;   //velocidade média 
    
   //Construtores
   public ComDistancia (String nome){
       super(nome);
       this.distancia = 0.0;
       this.vel_maxima = 0.0;
       this.vel_minima = 0.0;
       this.vel_media = 0.0;
   }
    
   public ComDistancia (int peso,GregorianCalendar data,String Nome_deporto,String weather, Tempo t, double distancia, double vel_maxima, double vel_minima){
       super(peso,data,Nome_deporto,weather,t);
       this.distancia = distancia;
       this.vel_maxima = vel_maxima;
       this.vel_minima = vel_minima;
       this.vel_media = calMedia(distancia,t);
   }
  
   public ComDistancia (ComDistancia f){
       super(f);
       this.distancia = f.getDistancia();
       this.vel_maxima = f.getVelmax();
       this.vel_minima = f.getVelmin();
       this.vel_media = f.getVelmed();
   }
    
    //Metodos de instancia
    /** Devolve a distancia percorrida */
    public double getDistancia() {return distancia;} 
    /** Devolve a velocidade máxima */
    public double getVelmax() {return vel_maxima;}
    /** Devolve a velocidade minima */
    public double getVelmin() {return vel_minima;}
    /** Devolve a velocidade média */
    public double getVelmed() {return vel_media;}
    
    /** Muda a distancia percorrida */
    public void setDistancia() {this.distancia = distancia;} 
    /** Muda a velocidade máxima */
    public void setVelmax() {this.vel_maxima = vel_maxima;}
    /** Muda a velocidade minima */
    public void setVelmin() {this.vel_minima = vel_minima;}
    /** Muda a velocidade média */
    public void setVelmed() {this.vel_media = vel_media;}
    
    public static double calMedia(double d, Tempo w){
         double t;
         int h = w.getHoras();
         int m = w.getMinutos();
         t = h*60;
         t += m;
         double vel_media = ((d*60)/t);
         return vel_media;
        }
    
    /**Verifica se dois Desportos deste tipo sao iguais*/
    public boolean equals(ComDistancia v) {
       return super.equals(v);  
    }
    
    /** Converte para uma representação textual */
    public String toString(){
        StringBuilder s = new StringBuilder();
            s.append(super.toString());
            s.append("Distancia: " + distancia + "Km\n");
            s.append("Velocidade Máxima: " + vel_maxima + "Km/h\n");
            s.append("Velocidade Mínima: " + vel_minima + "Km/h\n");
            s.append("Velocidade Média: " + vel_media + "Km/h\n");
        return s.toString(); 
    }
    
    /** Cria uma cópia do receptor*/
    public abstract ComDistancia clone();
}
