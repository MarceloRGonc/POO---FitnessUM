
/**
 * 
 * @author Grupo 16
 */
import java.util.*;
import java.io.Serializable;

public abstract class Desporto implements Serializable
{
    // variáveis de instância
    private GregorianCalendar Data; //Data em que o Desporto foi praticado
    private String Nome_desporto; //Nome da atividade física
    private double calorias; //Calorias gastas na prática do desporto
    private Tempo tempo; //Tempo que se despendeu na atividade desportiva
    private String weather;
       
    //Construtores
    public Desporto(String nome){
        this.Data = new GregorianCalendar();
        this.Nome_desporto=nome;
        this.weather="";
        this.tempo = new Tempo();
        this.calorias = 0.0;
    }
    
    public Desporto(int peso,GregorianCalendar data, String Nome_desporto, String weather, Tempo t){
        this.Data = data;
        this.Nome_desporto = Nome_desporto;
        this.weather=weather;
        this.tempo = t;
        this.calorias = calculaCal(peso,(getTempoM()/60));
    }
    
    public Desporto(Desporto v){
        this.Data = v.getData();
        this.Nome_desporto = v.getNome_desporto();
        this.tempo = v.tempo.clone();
        this.weather=v.getWeather();
        this.calorias=v.getCalorias();
    }

     //Metodos de instancia
    /** Devolve a data em que foi praticado o desporto */
    public GregorianCalendar getData() {  return (GregorianCalendar) this.Data.clone();  }
    /** Devolve a nome do Desporto */
    public String getNome_desporto() {return Nome_desporto;}
    /** Devolve as calorias que se despendeu na atividade desportiva */
    public double getCalorias() {return calorias;}
    public double getCaloriasH() {
        double cal = 60 * calorias;
        return (cal/getTempoM());
    }
    /** Retorna o tempo da atividade em minutos*/
    public double getTempoM(){
        double t;
        t = tempo.getHoras() * 60;
        t += tempo.getMinutos();
        return t;
    }
    public Tempo getTempo(){ return tempo.clone(); }
    /** Devolve as condições atmosféricas de quando se praticou o desporto */
    public String getWeather() {return weather;}
    
    /** Muda as condições atmosféricas de quando se praticou o desporto */
    public void setWeather(String m){this.weather = m;}
    /** Muda o nome do Desporto */
    public void setNome_desporto(String m){
        this.Nome_desporto = m;
    }
    /** Muda as calorias que se despendeu na atividade desportiva */
    public void setCalorias(double md){
        this.calorias = md;
    } 
    
    /**Verifica se dois Desportos deste tipo sao iguais*/
    public boolean equals(Object o) {

        if (this == o) return true;
        if ((o == null) || (this.getClass() != o.getClass())) return false;
        Desporto umDesporto = (Desporto) o;
        return Nome_desporto.equals(umDesporto.getNome_desporto()) 
                && calorias == umDesporto.getCalorias() 
                && tempo.equals(umDesporto.tempo)
                && Data.equals(umDesporto.Data);
    }
    
    public int getAno(){
        return Data.get(Calendar.YEAR);
    }
    
    public int getMes(){
        return Data.get(Calendar.MONTH);
    }
    
    /** Converte para uma representação textual */
    public String toString(){
        StringBuilder s = new StringBuilder();
            s.append("Data: " + Data.get(Calendar.DAY_OF_MONTH) + "-" +
                                  (Data.get(Calendar.MONTH) + 1) + "-" +
                                  Data.get(Calendar.YEAR) + "\n");
            s.append("Nome_desporto: " + Nome_desporto + "\n");
            s.append("Clima: " + weather + "\n");
            s.append("Calorias: " + calorias + "kCal\n");
            s.append(tempo.toString()); 
            
        return s.toString(); 
    }
    
    /** Cria uma cópia do receptor*/
    public abstract Desporto clone();
    
    /** Metodo que calcula as calorias dispendidas */
    public abstract double calculaCal(int p, double h);

}
