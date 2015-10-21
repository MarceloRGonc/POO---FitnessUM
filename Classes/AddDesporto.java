/**
 * 
 * @author Grupo 16 
 */
import java.util.*;
import java.io.Serializable;

public class AddDesporto implements Serializable
{ 
    public static Desporto atSAltimetria(String atividade, Utilizador user){
         Desporto novo;
         System.out.println("Quando foi praticada essa atividade (dd mm aaaa)?");
         GregorianCalendar data = Input.LerData();
                                    
         System.out.println("Quanto tempo durou a atividade física (hh mm ss)");
         Tempo t = Input.lerTempo();
         
         String weather = Input.lerClima();
         System.out.println("Quantos quilómetros percorreu?");
         double distancia = Input.lerDouble();
         System.out.println("Qual foi a velocidade máxima atingida?");
         double vel_max = Input.lerDouble();
         System.out.println("Qual foi a velocidade mínima atingida?");
         double vel_min = Input.lerDouble();
         
         if(atividade.equals("Futsal")){
             novo = new Futsal(user.getPeso(),data,atividade,weather,t,distancia,vel_max,vel_min);
             return novo;
         }
         else if(atividade.equals("Tenis")){
             novo = new Tenis(user.getPeso(),data,atividade,weather,t,distancia,vel_max,vel_min);
             return novo;
         }
         else if(atividade.equals("Futebol")){
             novo = new Futebol(user.getPeso(),data,atividade,weather,t,distancia,vel_max,vel_min);
             return novo;
         }
         else if(atividade.equals("Basquetebol")){
             novo = new Basquetebol(user.getPeso(),data,atividade,weather,t,distancia,vel_max,vel_min);
             return novo;
         }
         return null;
    }
    
    public static Desporto atCAltimetria(String atividade, Utilizador user){
         Desporto novo;
         System.out.println("Quando foi praticada essa atividade (dd mm aaaa)?");
         GregorianCalendar data = Input.LerData();
                                    
         System.out.println("Quanto tempo durou a atividade física (hh mm ss)");
         Tempo t = Input.lerTempo();
         
         String weather = Input.lerClima();
         System.out.println("Quantos quilómetros percorreu?");
         double distancia = Input.lerDouble();
         System.out.println("Qual foi a velocidade máxima atingida?");
         double vel_max = Input.lerDouble();
         System.out.println("Qual foi a velocidade mínima atingida?");
         double vel_min = Input.lerDouble();
         
         System.out.println("Qual foi a altitude máxima atingida?");
         double alt_max = Input.lerDouble();
         System.out.println("Qual foi a altitude mínima atingida?");
         double alt_min = Input.lerDouble();
         System.out.println("Quantos quilómetros percorreu de forma ascendente?");
         double t_asc = Input.lerDouble();
         System.out.println("Quantos quilómetros percorreu de forma descendente?");
         double t_desc = Input.lerDouble();
                  
         if(atividade.equals("Running")){
             novo = new Running(user.getPeso(),data,atividade,weather,t,distancia,vel_max,vel_min,alt_min,alt_max,t_desc,t_asc);
             return novo;
         }
         if(atividade.equals("Ciclismo")){
             novo = new Ciclismo(user.getPeso(),data,atividade,weather,t,distancia,vel_max,vel_min,alt_min,alt_max,t_desc,t_asc);
             return novo;
         }
         if(atividade.equals("Alpinismo")){
             novo = new Alpinismo(user.getPeso(),data,atividade,weather,t,distancia,vel_max,vel_min,alt_min,alt_max,t_desc,t_asc);
             return novo;
         }
         return null;
     }
     
    public static Desporto atSDistancia(String atividade, Utilizador user){
         Desporto novo;
         System.out.println("Quando foi praticada essa atividade (dd mm aaaa)?");
         GregorianCalendar data = Input.LerData();
         
         String weather = Input.lerClima();
         System.out.println("Quanto tempo durou a atividade física (hh mm ss)");
         Tempo t = Input.lerTempo();

         if(atividade.equals("Musculacao")){
             novo = new Musculacao(user.getPeso(),data,atividade,weather,t);
             return novo;
            }
         if(atividade.equals("Zumba")){
             novo = new Zumba(user.getPeso(),data,atividade,weather,t);
             return novo;
            }
         if(atividade.equals("Boxe")){
             novo = new Boxe(user.getPeso(),data,atividade,weather,t);
             return novo;
            }           
         return null;
    }

}
