import static java.lang.System.out;
import static java.lang.System.in;
import java.util.*;
import java.io.Serializable;

public class Input implements Serializable
{
 
 public static String lerString() {
     Scanner input = new Scanner(in);
     boolean ok = false; 
     String txt = "";
     while(!ok) {
         try {
             txt = input.nextLine();
             ok = true;
         }
         catch(InputMismatchException e) 
             { out.println("Texto Inválido"); 
               out.print("Novo valor: ");
               input.nextLine(); 
             }
     }
     input.close();
     return txt;
 } 
  
 public static int lerInt() {
     Scanner input = new Scanner(in);
     boolean ok = false; 
     int i = 0; 
     while(!ok) {
         try {
             i = input.nextInt();
             ok = true;
         }
         catch(InputMismatchException e) 
             { out.println("Inteiro Inválido"); 
               out.print("Novo valor: ");
               input.nextLine(); 
             }
     }
     input.close();
     return i;
  } 
  
  public static double lerDouble() {
     Scanner input = new Scanner(in);
     boolean ok = false; 
     double d = 0.0; 
     while(!ok) {
         try {
             d = input.nextDouble();
             ok = true;
         }
         catch(InputMismatchException e) 
             { out.println("Valor real Inválido"); 
               out.print("Novo valor: ");
               input.nextLine(); 
             }
     }
     input.close();
     return d;
  }  
  
   public static float lerFloat() {
     Scanner input = new Scanner(in);
     boolean ok = false; 
     float f = 0.0f; 
     while(!ok) {
         try {
             f = input.nextFloat();
             ok = true;
         }
         catch(InputMismatchException e) 
             { out.println("Valor real Inválido"); 
               out.print("Novo valor: ");
               input.nextLine(); 
             }
     }
     input.close();
     return f;
  }  
  
   public static boolean lerBoolean() {
     Scanner input = new Scanner(in);
     boolean ok = false; 
     boolean b = false; 
     while(!ok) {
         try {
             b = input.nextBoolean();
             ok = true;
         }
         catch(InputMismatchException e) 
             { out.println("Booleano Inválido"); 
               out.print("Novo valor: ");
               input.nextLine(); 
             }
     }
     input.close();
     return b;
  } 
  
  public static short lerShort() {
     Scanner input = new Scanner(in);
     boolean ok = false; 
     short s = 0; 
     while(!ok) {
         try {
             s = input.nextShort();
             ok = true;
         }
         catch(InputMismatchException e) 
             { out.println("Short Inválido"); 
               out.print("Novo valor: ");
               input.nextLine(); 
             }
     }
     input.close();
     return s;
  }  
  
  public static String lerClima(){
         int ans = 1;
         String weather = "";
         do {
             System.out.println("Como estava o clima quando realizou a atividade?");
             System.out.println("\t1 - Sol");
             System.out.println("\t2 - Chuva");
             System.out.println("\t3 - Nublado");
             System.out.println("\t4 - Indoor");
             Scanner p = new Scanner(System.in);
             System.out.println("Escolha uma opção:");
             ans = lerInt();
             p.close();
             
             if(ans==1){
                 weather = "Sol";
                 ans=0;
             }
             if(ans==2){
                 weather = "Chuva";
                 ans=0;
             }
             if(ans==3){
                 weather = "Nublado";
                 ans=0;
             }
             if(ans==4){
                 weather = "Indoor";
                 ans=0;
             }
                               
             if (ans!=0)  System.out.println("Escolha uma opção válida.");
            } while(ans != 0);
         return weather;
     }
     
  public static GregorianCalendar LerData(){
       boolean i = true;
       int dia=0;
       int mes=0; 
       int ano=1900;
       do {
           Scanner p = new Scanner(System.in);
           do{ 
                try{
                     dia = p.nextInt();
                     mes = p.nextInt();
                     ano = p.nextInt();
                     i = true;
                }
                catch(InputMismatchException e){
                    System.out.println(e + ":" + "\nNúmero inválido. Insira um número válido");
                    p = new Scanner(System.in);
                    i = false;
                }
                catch(NoSuchElementException e){
                    System.out.println(e + ":" + "\nNúmero inválido. Insira um número válido");
                    p = new Scanner(System.in);
                    i = false;
                }
                catch(IllegalStateException e){
                    System.out.println(e + ":" + "\nNúmero inválido. Insira um número válido");
                    p = new Scanner(System.in);
                    i = false;
                }
            }while(!i);
           i = false;
           if (dia > 31 && dia < 0) i=true;
           else if (mes < 0 && mes > 12) i=true;
           else if (ano < 1900 && ano > 2016) i=true;
           mes = mes-1;
           if (i) System.out.println("Por favor insira uma data válida.");
        } while(i);
       GregorianCalendar data = new GregorianCalendar(ano,mes,dia);
       return data;
  }
  
  public static Tempo lerTempo(){
       int h=0;
       int m=0; 
       int s=1900;
       boolean ok = false;
       Scanner p = new Scanner(System.in);
       do{
           try{
               h = p.nextInt();
               m = p.nextInt();
               s = p.nextInt();
               ok = true;
           }
           catch(InputMismatchException e){
               System.out.println(e + ":" + "\nNúmero inválido. Insira um números válidos");
               out.print("Novos valores: ");
               p = new Scanner(System.in);
           }
           catch(NoSuchElementException e){
               System.out.println(e + ":" + "\nNúmero inválido. Insira um números válidos");
               out.print("Novos valores: ");
               p = new Scanner(System.in);
           }
           catch(IllegalStateException e){
               System.out.println(e + ":" + "\nNúmero inválido. Insira um números válidos");
               out.print("Novos valores: ");
               p = new Scanner(System.in);
           }
       }while(!ok);
       Tempo t = new Tempo(h,m,s);
       return t;
  }
}
