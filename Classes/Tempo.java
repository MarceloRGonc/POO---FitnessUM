
/**
 * 
 * @author Grupo 16
 */
import java.io.Serializable;

public class Tempo implements Serializable
{
    // variáveis de instância
    private int horas; 
    private int minutos;
    private int segundos;
    
    //Construtores
    public Tempo(){
        this.horas = 00;
        this.minutos = 00;
        this.segundos = 00;
    }
    
    public Tempo(int horas, int m, int segundos){
        this.horas = horas;
        setMinutos(m);
        setSegundos(segundos);
    }
    
    public Tempo(Tempo v){
        this.horas = v.getHoras();
        this.minutos = v.getMinutos(); 
        this.segundos = v.getSegundos(); 
    }
    
    public int getHoras() {return horas;}
    public int getMinutos() {return minutos;}
    public int getSegundos() {return segundos;}
        
    public void setHoras(int h) {this.horas=h;}
    public void setMinutos(int m) {
        if(m<60) this.minutos = m;
        else{
            int x = m/60;
            this.horas += x;
            double y = m%60;
            this.minutos = (int) y;
        }
    }
    public void setSegundos(int s) {
        if(s<60) this.segundos = s;
        else{
            int x = s/60;
            addMinutos (x);
            double y = s%60;
            this.segundos = (int) y;
        }
    }
    
    public void addMinutos(int m) {
        if(m<60) this.minutos += m;
        else{
            int x = m/60;
            this.horas += x;
            double y = m%60;
            this.minutos += (int) y;
        }
    }
    
     /**Verifica se dois Tempos deste tipo sao iguais*/
    public boolean equals(Object o) {

        if (this == o) return true;
        if ((o == null) || (this.getClass() != o.getClass())) return false;
        Tempo m = (Tempo) o;
        return horas == m.getHoras() && minutos == m.getMinutos() &&  segundos == m.getSegundos();
    }
    
    /** Converte para uma representação textual */
    public String toString(){
        StringBuilder s = new StringBuilder();
            s.append(horas + "h " + minutos + "min " + segundos + "s;\n");
        return s.toString(); 
    }
    
    /** Cria uma cópia do receptor*/
    public Tempo clone(){
        return new Tempo(this);
    }
    
    public boolean compare(Tempo t2) {

        if (this.horas > t2.getHoras())
            return false;
        else if (this.horas < t2.getHoras())
            return true;
        else if (this.minutos > t2.getMinutos())
            return false;
        else if (this.minutos < t2.getMinutos())
            return true;
        else if (this.segundos > t2.getSegundos())
            return false;
        else if (this.segundos < t2.getSegundos())
            return true;
        else return false;
    }
    
}
