/**
 * 
 * @author Grupo 16
 */
import java.io.*;
import java.util.*;
import java.text.DecimalFormat;

public class Teste
{
   public static void main() throws IOException {

        Utilizadores users = new Utilizadores();
        
        Utilizador u1 = new Utilizador("Jose.Sampaio@gmail.com","123","José Sampaio","Masculino","Futebol", 1.80,83,new GregorianCalendar(1985,07,30));
        Utilizador u2 = new Utilizador("Antonio_Silva@gmail.com","123","António Silva","Masculino", "Basebol", 1.74,76, new GregorianCalendar(1989,05,25));
        Utilizador u3 = new Utilizador("Joaquim1980@gmail.com","123","Joaquim Oliveira","Masculino","Basquetebol",1.93,80, new GregorianCalendar(1983,11,11));
        Utilizador u4 = new Utilizador("lurdes.trico@gmail.com","123","Lurdes Costa","Feminino","Natação",1.60,50, new GregorianCalendar(1990,12,15));
        Utilizador u5 = new Utilizador("carlson_790@gmail.com","123","Carlson Matos","Masculino","Karaté", 1.71, 65, new GregorianCalendar(1988,02,03));
        Utilizador u6 = new Utilizador("marcelo.rgonc@gmail.com","m","Marcelo Gonçalves","Masculino","Futebol", 1.69, 60, new GregorianCalendar(1994,07,02));
        Utilizador u7 = new Utilizador("r1994@gmail.com","r","Ricardo Silva","Masculino","Ciclismo", 1.78, 70, new GregorianCalendar(1994,06,28));
        Utilizador u8 = new Utilizador("mitch21@gmail.com","mitch","Miguel Angelo","Masculino","Futsal", 1.73, 70, new GregorianCalendar(19901,9,28));

        /* ------------------- */    
        
        u1.addP_Amizade(u2);u1.addP_Amizade(u3);u1.addP_Amizade(u4);u1.addP_Amizade(u5);
        
        u2.addP_Amizade(u3);u2.addP_Amizade(u4);u2.addP_Amizade(u5);

        u3.addP_Amizade(u5);u3.addP_Amizade(u4);
        
        u6.addP_Amizade(u7);u6.addP_Amizade(u8);

        u7.addP_Amizade(u8);
        
        users.registarUtilizador(u1); users.registarUtilizador(u2); users.registarUtilizador(u3); users.registarUtilizador(u4);
        users.registarUtilizador(u5); users.registarUtilizador(u6); users.registarUtilizador(u7); users.registarUtilizador(u8);
        
        /* ------------------- */
        Desporto d1 = new Zumba(75,new GregorianCalendar(2014,3,12), "Zumba","Sol",new Tempo(1,0,0));
        Desporto d2 = new Zumba(75,new GregorianCalendar(2014,2,15), "Zumba","Nublado",new Tempo(1,30,20));
        Desporto d3 = new Boxe(75,new GregorianCalendar(2014,4,16), "Boxe","Sol",new Tempo(0,50,38));
        Desporto d4 = new Boxe(75,new GregorianCalendar(2014,5,20), "Boxe","Nublado",new Tempo(1,10,10));
        Desporto d5 = new Musculacao(75,new GregorianCalendar(2014,1,16),"Musculação","Indoor",new Tempo(1,30,20));
        Desporto d6 = new Musculacao(75,new GregorianCalendar(2014,1,25),"Musculação","Indoor",new Tempo(2,10,20)); 
        /* ------------------- */
        Desporto d7 = new Futebol(75,new GregorianCalendar(2013,6,12),"Futebol","Sol",new Tempo(1,4,2),10.2,20,6);
        Desporto d8 = new Futebol(75,new GregorianCalendar(2013,12,22),"Futebol","Nublado", new Tempo(1,30,5),8.7,23,5);
        Desporto d9 = new Tenis(75,new GregorianCalendar(2013,7,20),"Tenis","Chuva", new Tempo(3,20,2),6.3,17,2);
        Desporto d10 = new Tenis(75,new GregorianCalendar(2013,9,12),"Tenis","Indoor", new Tempo(2,20,2),4.5,15,3);
        Desporto d11 = new Futsal(75,new GregorianCalendar(2013,4,22),"Futsal","Indoor",new Tempo(1,20,10),5.2,18,4);  
        Desporto d12 = new Futsal(75,new GregorianCalendar(2013,4,13),"Futsal","Sol",new Tempo(1,35,10),6.3,16,3.5);  
        Desporto d13 = new Basquetebol(75,new GregorianCalendar(2013,7,23),"Basquetebol","Sol",new Tempo(2,0,13),6.1,14,3);
        Desporto d14 = new Basquetebol(75,new GregorianCalendar(2013,8,14),"Basquetebol","Indoor",new Tempo(1,25,20),5.8,15,2);        
        /* ------------------- */
        Desporto d15 = new Running(75,new GregorianCalendar(2013,6,1), "Running","Sol",new Tempo(1,43,21),23.6,20,3,100,200,5,7);
        Desporto d16 = new Running(75,new GregorianCalendar(2014,5,28), "Running","Nublado",new Tempo(1,0,45),16.4,23,3,0,0,0,0);
        Desporto d17 = new Ciclismo(75,new GregorianCalendar(2013,7,17),"Ciclismo","Chuva",new Tempo(1,58,20),35.7,65,15,100,200,7,13);
        Desporto d18 = new Ciclismo(75,new GregorianCalendar(2014,5,8),"Ciclismo","Nublado",new Tempo(2,40,20),67.2,50,14,50,150,15,19);
        Desporto d19 = new Alpinismo(75,new GregorianCalendar(2013,7,10), "Alpinismo","Nublado",new Tempo(4,35,23),24.5,8,2, 150,600,320,400);
        Desporto d20 = new Alpinismo(75,new GregorianCalendar(2013,7,18), "Alpinismo","Nublado",new Tempo(3,40,20),19.6,6,1, 200,700,230,450);
        /* ------------------- */
        
        Desporto d21 = new Zumba(65,new GregorianCalendar(2012,3,12), "Zumba","Sol",new Tempo(1,0,0));
        Desporto d22 = new Zumba(65,new GregorianCalendar(2012,2,15), "Zumba","Nublado",new Tempo(1,30,20));
        Desporto d23 = new Boxe(65,new GregorianCalendar(2012,4,16), "Boxe","Sol",new Tempo(0,50,38));
        Desporto d24 = new Boxe(65,new GregorianCalendar(2012,5,20), "Boxe","Nublado",new Tempo(1,30,10));
        Desporto d25 = new Musculacao(65,new GregorianCalendar(2012,1,16),"Musculação","Indoor",new Tempo(1,50,20));
        Desporto d26 = new Musculacao(65,new GregorianCalendar(2012,1,25),"Musculação","Indoor",new Tempo(2,00,20)); 
        /* ------------------- */
        Desporto d27 = new Futebol(65,new GregorianCalendar(2011,6,12),"Futebol","Sol",new Tempo(1,40,2),10.2,20,6);
        Desporto d28 = new Futebol(65,new GregorianCalendar(2011,7,22),"Futebol","Nublado", new Tempo(1,30,5),8.7,23,5);
        Desporto d29 = new Tenis(65,new GregorianCalendar(2011,9,20),"Tenis","Chuva", new Tempo(4,20,2),6.3,17,2);
        Desporto d30 = new Tenis(65,new GregorianCalendar(2011,9,12),"Tenis","Indoor", new Tempo(3,20,2),4.5,15,3);
        Desporto d31 = new Futsal(65,new GregorianCalendar(2011,4,22),"Futsal","Indoor",new Tempo(2,00,10),5.2,18,4);  
        Desporto d32 = new Futsal(65,new GregorianCalendar(2011,4,13),"Futsal","Sol",new Tempo(2,30,10),6.3,16,3.5);  
        Desporto d33 = new Basquetebol(65,new GregorianCalendar(2011,8,23),"Basquetebol","Sol",new Tempo(2,26,13),6.1,14,3);
        Desporto d34 = new Basquetebol(65,new GregorianCalendar(2011,7,14),"Basquetebol","Indoor",new Tempo(2,25,20),5.8,15,2);        
        /* ------------------- */
        Desporto d35 = new Running(65,new GregorianCalendar(2011,6,1), "Running","Sol",new Tempo(2,43,21),23.6,20,3,100,200,5,7);
        Desporto d36 = new Running(65,new GregorianCalendar(2012,5,28), "Running","Nublado",new Tempo(0,45,45),16.4,23,3,0,0,0,0);
        Desporto d37 = new Ciclismo(65,new GregorianCalendar(2011,7,17),"Ciclismo","Chuva",new Tempo(0,58,20),35.7,65,15,100,200,7,13);
        Desporto d38 = new Ciclismo(65,new GregorianCalendar(2012,5,8),"Ciclismo","Nublado",new Tempo(1,40,20),67.2,50,14,50,150,15,19);
        Desporto d39 = new Alpinismo(65,new GregorianCalendar(2011,7,10), "Alpinismo","Nublado",new Tempo(4,35,23),24.5,8,2, 150,600,320,400);
        Desporto d40 = new Alpinismo(65,new GregorianCalendar(2011,7,18), "Alpinismo","Nublado",new Tempo(5,40,20),19.6,6,1, 200,700,230,450);
        
        /* ------------------- */
        Utilizador user = u1;
        user.add_Desporto(d1); user.add_Desporto(d2); user.add_Desporto(d3); user.add_Desporto(d4); user.add_Desporto(d5);
        user.add_Desporto(d6); user.add_Desporto(d7); user.add_Desporto(d8); user.add_Desporto(d9); user.add_Desporto(d10); 
        user.add_Desporto(d11); user.add_Desporto(d12); user.add_Desporto(d13); user.add_Desporto(d14); user.add_Desporto(d15); 
        user.add_Desporto(d16); user.add_Desporto(d17); user.add_Desporto(d18); user.add_Desporto(d19); user.add_Desporto(d20);
        
        user = u3;
        user.add_Desporto(d1); user.add_Desporto(d2); user.add_Desporto(d3); user.add_Desporto(d4); user.add_Desporto(d5);
        user.add_Desporto(d6); user.add_Desporto(d7); user.add_Desporto(d8); user.add_Desporto(d9); user.add_Desporto(d10); 
        user.add_Desporto(d11); user.add_Desporto(d12); user.add_Desporto(d13); user.add_Desporto(d14); user.add_Desporto(d15); 
        user.add_Desporto(d16); user.add_Desporto(d17); user.add_Desporto(d18); user.add_Desporto(d19); user.add_Desporto(d20);
        
        user = u5;
        user.add_Desporto(d1); user.add_Desporto(d2); user.add_Desporto(d3); user.add_Desporto(d4); user.add_Desporto(d5);
        user.add_Desporto(d6); user.add_Desporto(d7); user.add_Desporto(d8); user.add_Desporto(d9); user.add_Desporto(d10); 
        user.add_Desporto(d11); user.add_Desporto(d12); user.add_Desporto(d13); user.add_Desporto(d14); user.add_Desporto(d15); 
        user.add_Desporto(d16); user.add_Desporto(d17); user.add_Desporto(d18); user.add_Desporto(d19); user.add_Desporto(d20);
        
        user = u2;
        user.add_Desporto(d21); user.add_Desporto(d22); user.add_Desporto(d23); user.add_Desporto(d24); user.add_Desporto(d25);
        user.add_Desporto(d26); user.add_Desporto(d27); user.add_Desporto(d28); user.add_Desporto(d29); user.add_Desporto(d30); 
        user.add_Desporto(d31); user.add_Desporto(d32); user.add_Desporto(d13); user.add_Desporto(d34); user.add_Desporto(d35); 
        user.add_Desporto(d36); user.add_Desporto(d37); user.add_Desporto(d18); user.add_Desporto(d39); user.add_Desporto(d40);
        
        user = u4;
        user.add_Desporto(d21); user.add_Desporto(d22); user.add_Desporto(d23); user.add_Desporto(d24); user.add_Desporto(d25);
        user.add_Desporto(d26); user.add_Desporto(d27); user.add_Desporto(d28); user.add_Desporto(d29); user.add_Desporto(d30); 
        user.add_Desporto(d31); user.add_Desporto(d32); user.add_Desporto(d13); user.add_Desporto(d34); user.add_Desporto(d35); 
        user.add_Desporto(d36); user.add_Desporto(d37); user.add_Desporto(d18); user.add_Desporto(d39); user.add_Desporto(d40);
        
        user = u6;
        user.add_Desporto(d1); user.add_Desporto(d2); user.add_Desporto(d3); user.add_Desporto(d4); user.add_Desporto(d5);
        user.add_Desporto(d6); user.add_Desporto(d7); user.add_Desporto(d8); user.add_Desporto(d9); user.add_Desporto(d10); 
        user.add_Desporto(d11); user.add_Desporto(d12); user.add_Desporto(d13); user.add_Desporto(d14); user.add_Desporto(d15); 
        user.add_Desporto(d16); user.add_Desporto(d17); user.add_Desporto(d18); user.add_Desporto(d19); user.add_Desporto(d20);
        user.add_Desporto(d21); user.add_Desporto(d22); user.add_Desporto(d23); user.add_Desporto(d24); user.add_Desporto(d25);
        user.add_Desporto(d26); user.add_Desporto(d27); user.add_Desporto(d28); user.add_Desporto(d29); user.add_Desporto(d30); 
        user.add_Desporto(d31); user.add_Desporto(d32); user.add_Desporto(d13); user.add_Desporto(d34); user.add_Desporto(d35); 
        user.add_Desporto(d36); user.add_Desporto(d37); user.add_Desporto(d18); user.add_Desporto(d39); user.add_Desporto(d40);
        
        user = u7;
        user.add_Desporto(d1); user.add_Desporto(d2); user.add_Desporto(d3); user.add_Desporto(d4); user.add_Desporto(d5);
        user.add_Desporto(d6); user.add_Desporto(d7); user.add_Desporto(d8); user.add_Desporto(d9); user.add_Desporto(d10); 
        user.add_Desporto(d11); user.add_Desporto(d12); user.add_Desporto(d13); user.add_Desporto(d14); user.add_Desporto(d15); 
        user.add_Desporto(d16); user.add_Desporto(d17); user.add_Desporto(d18); user.add_Desporto(d19); user.add_Desporto(d20);
        user.add_Desporto(d21); user.add_Desporto(d22); user.add_Desporto(d23); user.add_Desporto(d24); user.add_Desporto(d25);
        user.add_Desporto(d26); user.add_Desporto(d27); user.add_Desporto(d28); user.add_Desporto(d29); user.add_Desporto(d30); 
        user.add_Desporto(d31); user.add_Desporto(d32); user.add_Desporto(d13); user.add_Desporto(d34); user.add_Desporto(d35); 
        user.add_Desporto(d36); user.add_Desporto(d37); user.add_Desporto(d18); user.add_Desporto(d39); user.add_Desporto(d40);
        
        user = u8;
        user.add_Desporto(d1); user.add_Desporto(d2); user.add_Desporto(d3); user.add_Desporto(d4); user.add_Desporto(d5);
        user.add_Desporto(d6); user.add_Desporto(d7); user.add_Desporto(d8); user.add_Desporto(d9); user.add_Desporto(d10); 
        user.add_Desporto(d11); user.add_Desporto(d12); user.add_Desporto(d13); user.add_Desporto(d14); user.add_Desporto(d15); 
        user.add_Desporto(d16); user.add_Desporto(d17); user.add_Desporto(d18); user.add_Desporto(d19); user.add_Desporto(d20);
        user.add_Desporto(d21); user.add_Desporto(d22); user.add_Desporto(d23); user.add_Desporto(d24); user.add_Desporto(d25);
        user.add_Desporto(d26); user.add_Desporto(d27); user.add_Desporto(d28); user.add_Desporto(d29); user.add_Desporto(d30); 
        user.add_Desporto(d31); user.add_Desporto(d32); user.add_Desporto(d13); user.add_Desporto(d34); user.add_Desporto(d35); 
        user.add_Desporto(d36); user.add_Desporto(d37); user.add_Desporto(d18); user.add_Desporto(d39); user.add_Desporto(d40);
        
        System.out.println("\nRecordes;");
        
        System.out.println(user.getRecordes().recordeAt(d1));
        System.out.println(user.getRecordes().recordeAt(d3));
        System.out.println(user.getRecordes().recordeAt(d5));
        System.out.println(user.getRecordes().recordeAt(d7));
        System.out.println(user.getRecordes().recordeAt(d9));
        System.out.println(user.getRecordes().recordeAt(d11));
        System.out.println(user.getRecordes().recordeAt(d13));
        System.out.println(user.getRecordes().recordeAt(d15));
        System.out.println(user.getRecordes().recordeAt(d17));
        System.out.println(user.getRecordes().recordeAt(d20));
        
        DecimalFormat decimal = new DecimalFormat( "0.00" );
        DecimalFormat i = new DecimalFormat( "0" );  
        
        System.out.println("\nEstatísticas Relativas ao mês de Julho;");
        
        ArrayList<Double> d = user.StatsDist_M(7,2013);
        if (d.get(4) == 0.0) System.out.println("\nNão realizou nenhuma atividade nesse período;");
        else{
           System.out.println("\nNúmero de atividades realizadas: " + i.format(d.get(4)) + ";");
           System.out.println("Distância total percorrida: " + decimal.format(d.get(0)) + " Km;");
           System.out.println("Distância média percorrida por atividade: " + decimal.format(d.get(1)) +" Km;");
           System.out.println("Velocidade máxima atingida numa atividade: " + decimal.format(d.get(2)) +" Km/h;");
           System.out.println("Velocidade mínima atingida numa atividade: " + decimal.format(d.get(3)) +" Km/h;");
        }
        
        ArrayList<Tempo> t = user.StatsTemp_M(7,2011);
        if (t == null) System.out.println("\nNão realizou nenhuma atividade nesse período;");
        else{
              System.out.print("\nTempo total dispendido a praticar desporto: " + t.get(0).toString());
              System.out.print("Tempo médio dispendido por atividade: " + t.get(1).toString());
              System.out.print("Tempo máximo dispendido numa atividade: " + t.get(2).toString());
              System.out.print("Tempo mínimo dispendido numa atividade: " + t.get(3).toString());
        }
        
        ArrayList<Double> c = user.StatsCal_M(7,2011);
        if (c.get(4) == 0.0) System.out.println("\nNão realizou nenhuma atividade nesse período;");
        else{
          System.out.println("\nNúmero de atividades realizadas: " + i.format(c.get(4)) + ";");
          System.out.println("Calorias totais despendidas: " + decimal.format(c.get(0)) + " kCal;");
          System.out.println("Média de calorias despendidas por atividade: " + decimal.format(c.get(1)) +" kCal;");
          System.out.println("Calorias Máximas despendidas numa atividade: " + decimal.format(c.get(2)) +" kCal;");
          System.out.println("Calorias Mínimas despendidas numa atividade: " + decimal.format(c.get(3)) +" kCal;");
        }
        
        System.out.println("\nEstatísticas Relativas ao ano de 2013;");
        
        d = user.StatsDist_A(2013);
        if (d.get(4) == 0.0) System.out.println("\nNão realizou nenhuma atividade nesse período;");
        else{
           System.out.println("\nNúmero de atividades realizadas: " + i.format(d.get(4)) + ";");
           System.out.println("Distância total percorrida: " + decimal.format(d.get(0)) + " Km;");
           System.out.println("Distância média percorrida por atividade: " + decimal.format(d.get(1)) +" Km;");
           System.out.println("Velocidade máxima atingida numa atividade: " + decimal.format(d.get(2)) +" Km/h;");
           System.out.println("Velocidade mínima atingida numa atividade: " + decimal.format(d.get(3)) +" Km/h;");
        }
        
        t = user.StatsTemp_A(2013);
        if (t == null) System.out.println("\nNão realizou nenhuma atividade nesse período;");
        else{
              System.out.print("\nTempo total dispendido a praticar desporto: " + t.get(0).toString());
              System.out.print("Tempo médio dispendido por atividade: " + t.get(1).toString());
              System.out.print("Tempo máximo dispendido numa atividade: " + t.get(2).toString());
              System.out.print("Tempo mínimo dispendido numa atividade: " + t.get(3).toString());
        }
        
        c = user.StatsCal_A(2013);
        if (c.get(4) == 0.0) System.out.println("\nNão realizou nenhuma atividade nesse período;");
        else{
          System.out.println("\nNúmero de atividades realizadas: " + i.format(c.get(4)) + ";");
          System.out.println("Calorias totais despendidas: " + decimal.format(c.get(0)) + " kCal;");
          System.out.println("Média de calorias despendidas por atividade: " + decimal.format(c.get(1)) +" kCal;");
          System.out.println("Calorias Máximas despendidas numa atividade: " + decimal.format(c.get(2)) +" kCal;");
          System.out.println("Calorias Mínimas despendidas numa atividade: " + decimal.format(c.get(3)) +" kCal;");
        }
        FitnessUM.save(users);
   }
}
