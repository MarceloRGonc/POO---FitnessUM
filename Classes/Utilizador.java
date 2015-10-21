
/**
 * 
 * @author Grupo 16 
 */
import java.util.*;
import java.io.Serializable;

public class Utilizador implements Serializable
{
    // variáveis de instância
    private String email;
    private String pass;
    private String Nome;
    private String genero;
    private String desporto_favorito;
    private double altura;
    private int peso;
    private GregorianCalendar data_nascimento;
    
    private Map<String,Utilizador> P_Amizade;
    private Map<String,Utilizador> Amigos;
    
    private Set<Desporto> desportos;
    
    private Recordes rec;
    
    //Construtores
    public Utilizador(){
        this.email = new String();
        this.pass = new String();
        this.Nome = new String();
        this.genero = new String();
        this.desporto_favorito = new String();
        this.altura = 0.00;
        this.peso = 0;
        this.data_nascimento = new GregorianCalendar();
        this.P_Amizade = new HashMap<String,Utilizador>();
        this.Amigos = new HashMap<String,Utilizador>();
        this.desportos = new TreeSet<Desporto>(new DataComparator());
        this.rec = new Recordes();
    }
    
    public Utilizador(String email, String pass, String nome, String genero, String desporto_favorito, double altura, int peso, GregorianCalendar data_nascimento){
        this.email = email;
        this.pass = pass;
        this.Nome = nome;
        this.genero = genero;
        this.desporto_favorito = desporto_favorito;
        this.altura = altura;
        this.peso = peso;
        this.data_nascimento = data_nascimento;
        this.P_Amizade = new HashMap<String,Utilizador>();
        this.Amigos = new HashMap<String,Utilizador>();
        this.desportos = new TreeSet<Desporto>(new DataComparator());
        this.rec = new Recordes();
    }

    public Utilizador(Utilizador m){
        this.email = m.getEmail();
        this.pass = m.getPass();
        this.Nome = m.getNome();
        this.genero = m.getGenero();
        this.desporto_favorito = m.getDesporto_favorito();
        this.altura = m.getAltura();
        this.peso = m.getPeso();
        this.data_nascimento = m.getData_nascimento();
        this.P_Amizade = m.getP_Amizade();
        this.Amigos = m.getAmigos();
        this.desportos = m.getDesportos();
        this.rec = m.getRecordes();
    }
    
    //Métodos de instância
    
    public String getEmail(){return this.email;}
    
    public String getPass(){ return this.pass;}
    
    public String getNome(){ return this.Nome;}
    
    public String getGenero(){return this.genero;}
    
    public String getDesporto_favorito(){return this.desporto_favorito;}
    
    public double getAltura(){return this.altura;}
    
    public int getPeso(){return this.peso;}
    
    public Recordes getRecordes(){return this.rec.clone();} 
    
    public GregorianCalendar getData_nascimento() {return (GregorianCalendar) this.data_nascimento.clone();}
    
    public Map<String,Utilizador> getP_Amizade(){        
        Map<String,Utilizador> r = new HashMap<String,Utilizador>();
            
        Iterator<Map.Entry<String,Utilizador>> it = P_Amizade.entrySet().iterator();
        while(it.hasNext()){
            Map.Entry<String,Utilizador> entry = it.next();
            r.put(entry.getKey(),entry.getValue().clone());
        }
        return r;
    }
    
    public Map<String,Utilizador> getAmigos(){
        HashMap<String,Utilizador> r = new HashMap<String,Utilizador>();
        for(Map.Entry<String,Utilizador> entry : this.Amigos.entrySet())
            r.put(entry.getKey(),entry.getValue().clone());
        return r;
    }
    
    public Set<Desporto> getDesportos(){
        TreeSet<Desporto> r = new TreeSet<Desporto>(new DataComparator());
        for(Desporto p: desportos)
            r.add(p.clone());
        return r;
    }
    
    public void setEmail(String email){this.email = email;}
    public void setPass(String pass){this.pass = pass;}
    public void setNome(String nome){this.Nome = nome;}
    public void setGenero(String genero){this.genero = genero;}
    public void setDesporto_favorito(String desporto_favorito){this.desporto_favorito = desporto_favorito;}
    public void setAltura(double altura){this.altura = altura;}
    public void setPeso(int peso){this.peso = peso;}
    public void setData_nascimento(int ano, int mes, int dia) {GregorianCalendar data_nascimento = new GregorianCalendar(ano,mes,dia);}
    public void setData_nascimento(GregorianCalendar data) {this.data_nascimento = data;}
    public void setRecordes(Desporto novo){this.rec.addRecorde(novo);}
    
    public String toString() {
        StringBuilder s = new StringBuilder();
        s.append("Email: " + email + "\n");
        s.append("Pass: " + pass + "\n");
        s.append("Nome: " + Nome + "\n");
        s.append("Género: " + genero + "\n");
        s.append("Desporto favorito: " + desporto_favorito + "\n");
        s.append("Altura: " + altura + "\n");
        s.append("Peso: " + peso + "\n");
        s.append("Data de nascimento: "+data_nascimento.get(Calendar.DAY_OF_MONTH)+"-"+(data_nascimento.get(Calendar.MONTH) + 1)+"-"+data_nascimento.get(Calendar.YEAR)+"\n");
        for(Utilizador k : P_Amizade.values())
            k.toString();
        for(Utilizador k : Amigos.values())
            k.toString();
        for(Desporto k : desportos)
            k.toString();
        return s.toString();
    } 
    
    public boolean equals(Object o) {
     if (this == o) return true;
     if ((o == null) || (this.getClass() != o.getClass())) return false;
     Utilizador umUser = (Utilizador) o;
     return this.email.equals(umUser.getEmail()); 
    }
    
    public Utilizador clone(){return new Utilizador(this);}
    
    public boolean addP_Amizade(Utilizador m){
        if(!this.P_Amizade.containsKey(m.getEmail())){
            this.P_Amizade.put(m.getEmail(),m);
            return true;
        }
        else return false;
   
    }
   
    public boolean removeP_Amizade(String mail){
        return null!=this.P_Amizade.remove(mail);
    }
    
    public boolean addFriend(Utilizador m){
        if(!this.Amigos.containsKey(m.getEmail())){
            this.Amigos.put(m.getEmail(),m);
        }  
        else return false;
        
        return true;   
    }
    
    public Utilizador getFriend(String m){
        if(!this.Amigos.containsKey(m)){
            return null;
        }
        return this.Amigos.get(m);  
    }
    
    public boolean removeFriend(String mail){
        return null!=this.Amigos.remove(mail);
    }
    
    public boolean containsFriend(String mail){
        return this.Amigos.containsKey(mail);
    }
    
    public boolean add_Desporto(Desporto m){
        if(!this.desportos.contains(m)){
            this.desportos.add(m);
            setRecordes(m);
            return true;
        }
        else return false;
   
    }
    
    public Desporto getDesporto(String nome, GregorianCalendar data){
        Iterator<Desporto> it = this.desportos.iterator();
        while(it.hasNext()){
            Desporto entry = it.next();
            if(entry.getNome_desporto().equals(nome)){
                if(entry.getData().equals(data)){
                    return entry.clone();
                }
            }
        }
        return null;
    }
    
    public boolean removeDesporto(String nome, GregorianCalendar data){
        Desporto novo = getDesporto(nome,data);
        
        if(novo == null){
            return false;
        }
        else{
            return desportos.remove(novo);
        }
    }
    
    /* 
     * Retorna um Array que tem na posição 0 o total percorrido, na posição 1 a velocidade média, 
     * na 2 a velocidade máxima na 3 a velocidade minima e na 4 o número de vezes que praticou atividade
    */
    public ArrayList<Double> StatsDist_A(int ano){
        double totalP = 0.0;
        double velM = 0.0;
        double velMax = 0.0;
        double velMin = 999.9;
        int i = 0;
        Iterator<Desporto> it = this.desportos.iterator();
        while(it.hasNext()){
            Desporto entry = it.next();
            if(entry.getAno() == ano){
                if(entry instanceof ComDistancia){
                    i++;
                    totalP += ((ComDistancia)entry).getDistancia();
                    velM += ((ComDistancia)entry).getVelmed();
                    if(velMax < ((ComDistancia)entry).getVelmax()) velMax = ((ComDistancia)entry).getVelmax();
                    if(velMin > ((ComDistancia)entry).getVelmin()) velMin = ((ComDistancia)entry).getVelmin();
                }
            }
        }
        if (i!=0) velM = velM/i;
        ArrayList<Double> dados = new ArrayList<Double>();
        dados.add(0,totalP);
        dados.add(1,velM);      
        dados.add(2,velMax);
        dados.add(3,velMin);
        dados.add(4,(double)i);
        return dados;
    }
    
    /* 
     * Retorna um Array que tem na posição 0 o total percorrido, na posição 1 a velocidade média, 
     * na 2 a velocidade máxima na 3 a velocidade minima e na 4 o número de vezes que praticou atividade
    */
    public ArrayList<Double> StatsDist_M(int mes, int ano){
        double totalP = 0.0;
        double velM = 0.0;
        double velMax = 0.0;
        double velMin = 999.9;
        int i = 0;
        Iterator<Desporto> it = this.desportos.iterator();
        while(it.hasNext()){
            Desporto entry = it.next();
            if(entry.getMes() == mes && entry.getAno() == ano){
                if(entry instanceof ComDistancia){
                    i++;
                    totalP += ((ComDistancia)entry).getDistancia();
                    velM += ((ComDistancia)entry).getVelmed();
                    if(velMax < ((ComDistancia)entry).getVelmax()) velMax = ((ComDistancia)entry).getVelmax();
                    if(velMin > ((ComDistancia)entry).getVelmin()) velMin = ((ComDistancia)entry).getVelmin();
                }
            }
        }
        if(i!=0) velM = velM/i;
        ArrayList<Double> dados = new ArrayList<Double>();
        dados.add(0,totalP);
        dados.add(1,velM);      
        dados.add(2,velMax);
        dados.add(3,velMin);
        dados.add(4,(double)i);
        return dados;
    }
    
    /* 
     * Retorna um Array que tem na posição 0 o total dispendido, na posição 1 o tempo médio dispendido, 
     * na 2 o tempo máximo dispendido na 3 o tempo minimo dispendido e na 4 o número de vezes que praticou atividade
    */
    public ArrayList<Tempo> StatsTemp_A(int ano){
        Tempo total = new Tempo();
        Tempo max = new Tempo();
        Tempo min = new Tempo(999,0,0);
        Tempo med = new Tempo();
        int i = 0;
        Iterator<Desporto> it = this.desportos.iterator();
        while(it.hasNext()){
            Desporto entry = it.next();
            if(entry.getAno() == ano){
               i++;
               total.setHoras(total.getHoras() + entry.getTempo().getHoras());
               total.setMinutos(total.getMinutos() + entry.getTempo().getMinutos());
               total.setSegundos(total.getSegundos() + entry.getTempo().getSegundos());
               if(max.compare(entry.getTempo())) max = new Tempo(entry.getTempo());
               if(!(min.compare(entry.getTempo()))) min = new Tempo(entry.getTempo());
                }
            }
        if(i==0) return null;
        if(i!=0){
            med.setHoras(total.getHoras()/i);
            int seg = total.getMinutos() * 60;
            seg += total.getHoras()%i * 60 * 60;
            seg += total.getSegundos();
            med.setSegundos(seg/i);
        }
        ArrayList<Tempo> dados = new ArrayList<Tempo>();
        dados.add(0,total);
        dados.add(1,med);      
        dados.add(2,max);      
        dados.add(3,min);
        return dados;
    }
    
    /* 
     * Retorna um Array que tem na posição 0 o total dispendido, na posição 1 o tempo médio dispendido, 
     * na 2 o tempo máximo dispendido na 3 o tempo minimo dispendido e na 4 o número de vezes que praticou atividade
    */
    public ArrayList<Tempo> StatsTemp_M(int mes, int ano){
        Tempo total = new Tempo();
        Tempo max = new Tempo();
        Tempo min = new Tempo(999,0,0);
        Tempo med = new Tempo();
        int i = 0;
        Iterator<Desporto> it = this.desportos.iterator();
        while(it.hasNext()){
            Desporto entry = it.next();
            if(entry.getAno() == ano && entry.getMes() == mes){
               i++;
               total.setHoras(total.getHoras() + entry.getTempo().getHoras());
               total.setMinutos(total.getMinutos() + entry.getTempo().getMinutos());
               total.setSegundos(total.getSegundos() + entry.getTempo().getSegundos());
               if(max.compare(entry.getTempo())) max = new Tempo(entry.getTempo());
               if(!(min.compare(entry.getTempo()))) min = new Tempo(entry.getTempo());
                }
            }
        if(i==0) return null;
        if(i!=0){
            med.setHoras(total.getHoras()/i);
            int seg = total.getMinutos() * 60;
            seg += total.getHoras()%i * 60 * 60;
            seg += total.getSegundos();
            med.setSegundos(seg/i);
        }
        ArrayList<Tempo> dados = new ArrayList<Tempo>();
        dados.add(0,total);
        dados.add(1,med);      
        dados.add(2,max);      
        dados.add(3,min);
        return dados;
    }
    
    /* 
     * Retorna um Array que tem na posição 0 o total gasto, na posição 1 o gasto médio, 
     * na 2 o gasto máximo na 3 o gasto minimo e na 4 o número de vezes que praticou atividade
    */
    public ArrayList<Double> StatsCal_A(int ano){
        double totalC = 0.0;
        double Cmax = 0.0;
        double Cmin = 999.9;
        double CM = 0.0;
        int i = 0;
        Iterator<Desporto> it = this.desportos.iterator();
        while(it.hasNext()){
            Desporto entry = it.next();
            if(entry.getAno() == ano){
               i++;
               totalC += entry.getCalorias();
               if(Cmax < entry.getCalorias()) Cmax = entry.getCalorias();
               if(Cmin > entry.getCalorias()) Cmin = entry.getCalorias();
                }
            }
        if(i!=0) CM = totalC/i;
        ArrayList<Double> dados = new ArrayList<Double>();
        dados.add(0,totalC);
        dados.add(1,CM);      
        dados.add(2,Cmax);      
        dados.add(3,Cmin);
        dados.add(4,(double)i);
        return dados;
    }
    
    /* 
     * Retorna um Array que tem na posição 0 o total gasto, na posição 1 o gasto médio, 
     * na 2 o gasto máximo na 3 o gasto minimo e na 4 o número de vezes que praticou atividade
    */
    public ArrayList<Double> StatsCal_M(int mes, int ano){
        double totalC = 0.0;
        double Cmax = 0.0;
        double Cmin = 999.9;
        double CM = 0.0;
        int i = 0;
        Iterator<Desporto> it = this.desportos.iterator();
        while(it.hasNext()){
            Desporto entry = it.next();
            if(entry.getAno() == ano && entry.getMes() == mes){
               i++;
               totalC += entry.getCalorias();
               if(Cmax < entry.getCalorias()) Cmax = entry.getCalorias();
               if(Cmin > entry.getCalorias()) Cmin = entry.getCalorias();
                }
            }
        if (i!=0) CM = totalC/i;
        ArrayList<Double> dados = new ArrayList<Double>();
        dados.add(0,totalC);
        dados.add(1,CM);      
        dados.add(2,Cmax);      
        dados.add(3,Cmin);
        dados.add(4,(double)i);
        return dados;
    }

}
