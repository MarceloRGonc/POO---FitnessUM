
/**
 * 
 * @author Grupo 16
 */
import java.util.*;
import java.io.Serializable;

public class Utilizadores implements Serializable
{
    // variáveis de instância
    private Map<String,Utilizador> utilizadores;
   
    //Construtores
    public Utilizadores(){
        utilizadores = new HashMap<String,Utilizador>();
    }
    public Utilizadores(Map<String,Utilizador> utilizadores){
        for(Map.Entry<String,Utilizador> entry : utilizadores.entrySet())
           this.utilizadores.put(entry.getKey(),entry.getValue().clone());
    }
    public Utilizadores(Utilizadores u){
        this.utilizadores = u.getUtilizadores();
    }
    
    //Métodos de instância   
    /* Dado o endereço de utilizador retorna o utilizador se existir*/
    public Utilizador getUtilizador(String mail){
        return this.utilizadores.get(mail);
    }
    
    public Map<String,Utilizador> getUtilizadores(){
        Map<String,Utilizador> r = new HashMap<String,Utilizador>();
        
        Iterator<Map.Entry<String,Utilizador>> it = utilizadores.entrySet().iterator();
        while(it.hasNext()){
            Map.Entry<String,Utilizador> entry = it.next();
            r.put(entry.getKey(),entry.getValue().clone());
        }
        
        return r;
    }
    
    /* Regista um novo utilizador se não existir */
    public boolean registarUtilizador(Utilizador novoUtilizador){
 
        if(!this.utilizadores.containsKey(novoUtilizador.getEmail()))
            this.utilizadores.put(novoUtilizador.getEmail(),novoUtilizador);
            
        else return false;
        
        return true;
    }
    
    /**
     * Remover um utilizador se existente
     *  @param nome - nome do utilizador;
     *  @return false - se o utilizador não existe/true - se o utilizador for removido com sucesso
     */
    public boolean removerUtilizador(Utilizador nome){
        return null!=this.utilizadores.remove(nome.getEmail());
    }
    
    /**
     * Login na aplicação
     *  @param mail - endereço do utilizador;
     *  @param pass - pass do utilizador
     *  @return devolve o utilizador se os campos inseridos tiverem corretos, caso contrário devolve null
     */
    public Utilizador LogIn(String mail, String pass){
        if(this.utilizadores.containsKey(mail))
            if(this.utilizadores.get(mail).getPass().equals(pass))
                return this.getUtilizador(mail);
        return null;        
    }
    
    public int users_comuns(Utilizadores outros){
     Map<String,Utilizador> r = outros.getUtilizadores();
     for(Map.Entry<String,Utilizador> entry : utilizadores.entrySet())
        r.containsKey(entry.getKey());
      return r.size();
    } 
    
    public boolean containsUtilizador(String mail){
        return this.utilizadores.containsKey(mail);
    }   

    /** método equals() standard - recebe Object como parametro */
    public boolean equals(Object obj) {
      if(this == obj) return true;  // é o próprio
      if((obj == null) || (this.getClass() != obj.getClass())) return false;
      Utilizadores p = (Utilizadores) obj;
      return users_comuns(p) == this.utilizadores.size();
    } 
   
    /** Converte para uma representação textual  */   
    public String toString() {
       StringBuilder sb = new StringBuilder();
       
       for(Map.Entry<String,Utilizador> entry : utilizadores.entrySet()){
            sb.append(utilizadores.get(entry.getKey()).toString());
            sb.append("\n");
        }
     return sb.toString();
    }

    /** Cria e devolve uma cópia "deep" do ponto receptor */
    public Utilizadores clone() { return new Utilizadores(this); }
}
