/**
 * 
 * @author Grupo 16
 */
import java.io.*;
import java.util.*;
import java.text.DecimalFormat;
import java.io.Serializable;

public class FitnessUM 
{
    public static void main(String[] args) throws IOException {
        
        Utilizadores users;
        users = open();
        
        Utilizador user;
        Utilizador admin = new Utilizador("Admin","admin"," "," "," ", 0.0,0,new GregorianCalendar(0,00,00));
        users.registarUtilizador(admin);
            
        int Op = 1;
        
        while(Op!=0){
            /*Menu inicial*/
            Menus.printMenuP();
            Op = Input.lerInt();
            
            /* Entrar na conta de um Utilizador */ 
            switch(Op){
                case 0 : { System.out.println("Ate Breve!"); break; }
                case 1 : {
                    String email = new String();
                    String password = new String();
               
                    System.out.print("\nInsira o seu email: ");
                    email = Input.lerString();
                              
                    System.out.print("Password: ");
                    password = Input.lerString();
                    
                    user = new Utilizador();
                    user = users.LogIn(email,password);
               
                    if(user==null){
                        System.out.println("Utilizador não existe ou os dados inseridos estão incorretos. Registe-se na aplicação ou tente novamente.");
                    }               
                    else{
                        login(email, users);
                        Op=-1;
                    }
                    break;       
                  }
                /* Registar um novo utilizador */
                case 2 : {
                    RegistarUser(users);
                    break;
                }
            }
        }
    }
    
    public static int RegistarUser(Utilizadores users){
        String email, password, Nome, genero = "", desporto_favorito;
        double altura;
        int peso;
                 
        System.out.println("\nOla Bem-Vindo ao registo da aplicação FitnessUM por favor siga os passos para se registar...\n");
              
        System.out.print("Por favor insira um email: ");
        email = Input.lerString();         
        /* Verifica se email já existe */
        while(users.containsUtilizador(email)){
           System.out.println("Email já existente. Por favor insira outro email:");
           email = Input.lerString();
        }
        System.out.print("Por favor insira a sua password: ");
        password = Input.lerString();
        System.out.print("Por favor insira o seu nome: ");
        Nome = Input.lerString();
              
        while(genero.equals("")){
           System.out.println("Por favor indique o seu sexo:");
           System.out.println("\t1 - Masculino");
           System.out.println("\t2 - Feminino");
           int e = Input.lerInt();
           if(e == 1) {
              genero = "Masculino";
           }
           else{
              if(e == 2){
                 genero = "Feminino";
              }
              else{
                 System.out.print("A opção escohida não é válida;\n");
              }
           }
        }
        System.out.print("Por favor insira o seu desporto favorito: ");
        desporto_favorito = Input.lerString();
        System.out.print("Por favor insira a sua altura: ");
        altura = Input.lerDouble();                
        System.out.print("Por favor insira o seu peso: ");
        peso = Input.lerInt();
        System.out.print("Por favor insira a sua data de nascimento (dd mm aaaa): ");
        GregorianCalendar data_nascimento = Input.LerData();
        
        Utilizador novo = new Utilizador(email,password,Nome,genero,desporto_favorito, altura, peso, data_nascimento);
        if(users.registarUtilizador(novo)){
            System.out.print('\u000C');
            System.out.println("\nBem-vindo á aplicação FitnessUm faça Log in para aceder á sua conta.");
        } 
        return 0;
    } 
    
    /*Aqui é o espaço onde o utilizador gere a sua conta*/
     public static void login(String email, Utilizadores users) throws IOException{
      int Op = -1;
      System.out.print('\u000C');
      Utilizador user = users.getUtilizador(email);
       if(user.getEmail().equals("Admin")){ Admin(users);}
       else{
       /* Log in na aplicação */
       while(Op!=0){ 
          System.out.println("\nBem Vindo "+ user.getNome() +"!\n");
          Menus.PrintMenuU();
          Op = Input.lerInt();
          switch(Op){
              case 0 : { System.out.println("\nLogout com Sucesso\n\n"); break;}
              /* Envia Pedido de Amizade */
              case 1 : {
                  System.out.print('\u000C');
                  String destino = new String();                            
                  System.out.print("Insira o email do destinatario do pedido de Amizade: ");
                  destino = Input.lerString();
                  if (email.equals(destino)){
                     System.out.println("Inseriu o seu próprio email;");
                  } else if(!users.containsUtilizador(destino)){
                     System.out.println("O email que inseriu não corresponde a nenhum utilizador desta aplicação. Por favor verifique o email introduzido;"); 
                  } else if(user.containsFriend(destino)){
                     System.out.println("Já é amigo deste utilizador;");
                  } else if(users.getUtilizador(destino).addP_Amizade(user)){ 
                     System.out.println("O seu pedido foi enviado.");                   
                  } else{ System.out.println("O seu pedido não foi enviado."); }
                 break;
               }
              /* Ver Lista de Amigos */
              case 2 : {
                 System.out.print('\u000C');
                 Map<String,Utilizador> m = user.getAmigos();
                 Iterator<Map.Entry<String,Utilizador>> it = m.entrySet().iterator();
                 if(!it.hasNext()) System.out.println("Não possui nenhum Amigo, adicione algum.");
                 else{
                    System.out.println("\tNome - Email\n");
                    while(it.hasNext()){        
                       Map.Entry<String,Utilizador> entry = it.next();
                       System.out.println("\t" + entry.getValue().getNome() + " - " + entry.getKey() + ";");
                    }
                 }
                break;
               }
              /* Ver Pedidos de amizade pendentes */
              case 3 : {
                System.out.print('\u000C');
                Map<String,Utilizador> m = user.getP_Amizade();
                Iterator<Map.Entry<String,Utilizador>> it = m.entrySet().iterator();
                int p=1;
                while(it.hasNext()){        
                   Map.Entry<String,Utilizador> entry = it.next();
                   System.out.println("Recebeu um pedido de amizade do/a: " + entry.getValue().getNome() + " - " + entry.getKey() + ";\n");
                   System.out.println("\t1 - Para aceitar");
                   System.out.println("\t2 - Para recusar");
                   System.out.println("\t0 - Voltar para o menu anterior");
                   p = Input.lerInt();
                         
                   if (p==1){
                      users.getUtilizador(entry.getKey()).addFriend(users.getUtilizador(email));
                      user.addFriend(entry.getValue());
                      user.removeP_Amizade(entry.getKey());
                   }
                   else if (p==2){
                      user.removeP_Amizade(entry.getKey());
                   }
                         
                   if(p == 0) break;
                      
                }
                if(p != 0) System.out.println("Não possui nenhum pedido de Amizade por responder.\n");
                break;
               }
              /* Apagar Amigo */
              case 4 : {
                System.out.print('\u000C');
                String destino = new String();                            
                System.out.println("Insira o email do amigo que deseja remover: ");
                destino = Input.lerString();
                if(!users.containsUtilizador(destino)){
                   System.out.println("O email que inseriu não corresponde a nenhum utilizador desta aplicação. Por favor verifique o email introduzido;");
                }
                else if(user.removeFriend(destino)){ 
                   users.getUtilizador(destino).removeFriend(user.getEmail());
                   System.out.println("O utilizador foi removido dos seus Amigos.");                   
                }
                else{System.out.println("Não é amigo desse utilizador.");}
                break;
               }
              /* Alterar dados de Utilizador */
              case 5 : { System.out.print('\u000C'); AltDados(users,user); break; }
              /* Ver últimas atividades */
              case 6 : { System.out.print('\u000C'); VerAtividades(user); break; }
              /* Adicionar Atividades */
              case 7 : { System.out.print('\u000C'); addAtividade(user); break; }
              /* Ver Atividades de um amigo */
              case 8 : {
                  System.out.print('\u000C');
                  System.out.print("Indique o email do amigo que pertende consultar: ");                
                  String m = Input.lerString();
                  Utilizador amigo = user.getFriend(m);
                  if (amigo != null) VerAtividadesA(amigo);
                  else System.out.print("Esse email não corresponde a nenhum dos seus amigos;");  
                  break;
                }
              /* Ver Dados de um amigo */
              case 9 : {
                  System.out.print('\u000C');
                  System.out.print("Indique o email do amigo que pretende consultar: ");                
                  String m = Input.lerString();
                  Utilizador amigo = user.getFriend(m);
                  if (amigo != null) System.out.print(amigo.toString());
                  else System.out.print("Esse email não corresponde a nenhum dos seus amigos;");                
                  break;
                }
              case 10 : {
                  System.out.print('\u000C');
                  Stats(user);
                  break;
                }
              case 11 : {
                  System.out.print('\u000C');
                  Records(user);
                  break;
                }
             }
          }
      }
    }
    
    public static void AltDados(Utilizadores users, Utilizador user){
       int ans = 1;
       while(ans!=0){
         System.out.println(user.toString());
         Menus.printMenuAlt();
         ans = Input.lerInt();
         switch(ans){
            case 1 : {
              System.out.print('\u000C');
              System.out.println("Indique o novo email:");
              String e = Input.lerString();
              while(users.containsUtilizador(e)){
                 System.out.println("Email já existente. Por favor insira outro email, ou 0 para voltar ao menu: ");
                 e = Input.lerString();
                 if (e.equals("0")){
                     ans=0;
                     break;
                 }
              }         
              if(ans == 0) break;
              users.removerUtilizador(user);
              user.setEmail(e);
              users.registarUtilizador(user);
              System.out.println("O seu email foi alterado");
              break;
            }    
            case 2 : {
                System.out.print('\u000C');
                System.out.println("Indique a nova password:");
                String e = Input.lerString();
                user.setPass(e);
                System.out.println("A sua password foi alterada");
                break;
            }
            case 3 : {
                System.out.print('\u000C');
                System.out.println("Indique o seu novo nome para a aplicação:");
                String e = Input.lerString();
                user.setNome(e);
                System.out.println("O seu nome foi alterado");
                break;
            }
            case 4 : {
                 System.out.print('\u000C');
                 System.out.println("Pretende atlterar o seu género?");
                 System.out.println("\t1 - Sim");
                 System.out.println("\t2 - Não");
                 int e = Input.lerInt();
                 if(e==1){
                    String g = user.getGenero();
                    if(g.equals("Masculino")){
                        user.setGenero("Feminino");
                        System.out.println("O seu genero foi alterado");
                    }
                    else{
                        user.setGenero("Masculino");
                        System.out.println("O seu genero foi alterado");
                    }
                 }
                 break;
            }
            case 5 : {
                System.out.print('\u000C');
                System.out.println("Indique o seu novo desporto favorito:");
                String e = Input.lerString();
                user.setDesporto_favorito(e);
                System.out.println("O seu desporto favorito foi alterado");
                break;
            }
            case 6 : {
                System.out.print('\u000C');
                System.out.println("Indique a sua nova altura:");
                double e = Input.lerDouble();
                user.setAltura(e);
                System.out.println("A sua altura foi alterada");
                break;
            }
            case 7 : {
                System.out.print('\u000C');
                System.out.println("Indique o seu novo peso:");
                int e = Input.lerInt();
                user.setPeso(e);
                System.out.println("O seu email foi alterado");
                break;
            }
            case 8 : {
                System.out.print('\u000C');
                System.out.println("Indique a sua nova data de nascimento (dd mm aaaa):");
                GregorianCalendar e = Input.LerData();
                user.setData_nascimento(e);
                System.out.println("A sua data de nascimento foi alterada");
                break;
            }
            case 0 : { System.out.print('\u000C'); ans=0; }     
         }
       }
    }
    
    public static void VerAtividades(Utilizador user){
        TreeSet<Desporto> r = (TreeSet<Desporto>) user.getDesportos();
        Iterator<Desporto> it = r.iterator();
        int i=0;
        if(!it.hasNext())  System.out.println("Não possui atividades recentes.");
        System.out.println("");
        while (i<10 && it.hasNext()){
            Desporto entry = it.next().clone();
            System.out.println("Atividade: " + entry.getNome_desporto() + " Data: " + entry.getData().get(Calendar.DAY_OF_MONTH) + "/" +
                                  (entry.getData().get(Calendar.MONTH)+1) + "/" + entry.getData().get(Calendar.YEAR));
            i++;
            if(i==10 && it.hasNext()){
                Menus.printMenuVerAt();
                int ans = Input.lerInt();
                System.out.print("");
                switch(ans){
                   case 1 : { i=0; break; }
                   case 2 : {
                       Desporto novo = VerAt(user);
                       System.out.print('\u000C');
                       System.out.println(novo.toString());
                       break;
                   }
                   case 3 : {
                    System.out.println("Indique o nome da atividade que pertende remover");
                    String atividade = Input.lerString();
                    System.out.println("Quando foi praticada essa atividade (dd mm aaaa)?");
                    GregorianCalendar data = Input.LerData();
                    System.out.print('\u000C');
                    if (user.removeDesporto(atividade,data)){
                        System.out.println("Atividade removida com sucesso");
                    }
                    else{
                        System.out.println("A sua atividade não foi removida, verifique os dados da atividade");
                    }
                    break;
                    }
                }
            }
        }
        if(!it.hasNext() && (i!=0)){
            Menus.printMenuVerAt2();
            int ans = Input.lerInt();
            System.out.print("");
            switch(ans){
                case 1 : {
                    Desporto novo = VerAt(user);
                    System.out.print('\u000C');
                    System.out.println(novo.toString());
                    break;
                }
                case 2 : {
                    System.out.println("Indique o nome da atividade que pertende remover");
                    String atividade = Input.lerString();
                    System.out.println("Quando foi praticada essa atividade (dd mm aaaa)?");
                    GregorianCalendar data = Input.LerData();
                    System.out.print('\u000C');
                    if (user.removeDesporto(atividade,data)){
                        System.out.println("Atividade removida com sucesso");
                    }
                    else{
                        System.out.println("A sua atividade não foi removida, verifique os dados da atividade");
                    }
                    break;
                }
            }
        }
    }
    
    public static void VerAtividadesA(Utilizador amigo){
        TreeSet<Desporto> r = (TreeSet<Desporto>) amigo.getDesportos();
        Iterator<Desporto> it = r.iterator();
        int i=0;
        if(!it.hasNext())  System.out.println("O seu amigo não possui atividades recentes.");
        System.out.println("");
        while (i<10 && it.hasNext()){
            Desporto entry = it.next().clone();
            System.out.println("Atividade: " + entry.getNome_desporto() + " Data: " + entry.getData().get(Calendar.DAY_OF_MONTH) + "/" +
                                (entry.getData().get(Calendar.MONTH)+1) + "/" + entry.getData().get(Calendar.YEAR));
            i++;
            if(i==10){
                Menus.printMenuVerAtA();
                int ans = Input.lerInt();
                System.out.print("");
                switch(ans){
                    case 1 : {
                        i=0;
                        System.out.print('\u000C');
                        break;
                    }
                    case 2 : {
                        Desporto novo = VerAt(amigo);
                        System.out.print('\u000C');
                        System.out.println(novo.toString());
                        break;
                    }
                }
            }
        }
        if(!it.hasNext() && (i!=0)){
            Menus.printMenuVerAtA2();
            int ans = Input.lerInt();
            System.out.print("");
            switch(ans){
               case 1 : {
                   Desporto novo = VerAt(amigo);
                   System.out.print('\u000C');
                   System.out.println(novo.toString());
                   break;
               } 
            }
        }
    }
    
    public static void addAtividade(Utilizador user){
          int ans = 1;
          String atividade; 
          while(ans!=0){
              Menus.printMenuDesp();
              ans = Input.lerInt();
              switch(ans){
                    case 1 : {
                        while(ans!=0){ 
                            Menus.printMenuDespC();
                            ans = Input.lerInt();
                            switch(ans){
                                case 1 : {
                                    atividade = "Futebol";
                                    Desporto novo = AddDesporto.atSAltimetria(atividade, user.clone());
                                    user.add_Desporto(novo);
                                    System.out.print('\u000C');
                                    System.out.println("Atividade adicionada com sucesso\n");
                                    break;
                                }
                                case 2 : {
                                    atividade="Basquetebol";
                                    Desporto novo = AddDesporto.atSAltimetria(atividade, user.clone());
                                    user.add_Desporto(novo);
                                    System.out.print('\u000C');
                                    System.out.println("Atividade adicionada com sucesso\n");
                                    break;
                                }
                                case 3 : {
                                    atividade="Futsal";
                                    Desporto novo = AddDesporto.atSAltimetria(atividade, user.clone());
                                    user.add_Desporto(novo);
                                    System.out.print('\u000C');
                                    System.out.println("Atividade adicionada com sucesso\n");
                                    break;
                                }
                                case 0 : { break; }
                            }
                        }
                        break;
                    }
                    case 2 : {
                        while(ans!=0){
                            Menus.printMenuDespI();
                            ans = Input.lerInt();
                            switch(ans){
                                case 1 : {
                                    atividade = "Tenis";
                                    Desporto novo = AddDesporto.atSAltimetria(atividade, user.clone());
                                    user.add_Desporto(novo);
                                    System.out.print('\u000C');
                                    System.out.println("Atividade adicionada com sucesso\n");
                                    break;
                                }
                                case 2 : {
                                    atividade="Ciclismo";
                                    Desporto novo = AddDesporto.atCAltimetria(atividade, user.clone());
                                    user.add_Desporto(novo);
                                    System.out.print('\u000C');
                                    System.out.println("Atividade adicionada com sucesso\n");
                                    break;
                                }
                                case 3 : {
                                    atividade="Boxe";
                                    Desporto novo = AddDesporto.atSDistancia(atividade, user.clone());
                                    user.add_Desporto(novo);
                                    System.out.print('\u000C');
                                    System.out.println("Atividade adicionada com sucesso\n");
                                    break;
                                }
                                case 4 : {
                                    atividade="Running";
                                    Desporto novo = AddDesporto.atSAltimetria(atividade, user.clone());
                                    user.add_Desporto(novo);
                                    System.out.print('\u000C');
                                    System.out.println("Atividade adicionada com sucesso\n");
                                    break;
                                }
                                case 0 : { break; }
                            }
                        }
                        break;
                    }
                    case 3 : {
                        while(ans!=0){
                            Menus.printMenuDespG();
                            ans = Input.lerInt();
                            switch(ans){
                                case 1 : {
                                    atividade="Musculação";
                                    Desporto novo = AddDesporto.atSAltimetria(atividade, user.clone());
                                    user.add_Desporto(novo);
                                    System.out.print('\u000C');
                                    System.out.println("Atividade adicionada com sucesso\n");
                                    break;
                                }
                                case 2 : {
                                    atividade="Zumba";
                                    Desporto novo = AddDesporto.atCAltimetria(atividade, user.clone());
                                    user.add_Desporto(novo);
                                    System.out.print('\u000C');
                                    System.out.println("Atividade adicionada com sucesso\n");
                                    break;
                                }
                                case 0 : { break; }
                            }
                        }
                        break;
                    }
                    case 0 : { System.out.print('\u000C'); break; }
                }
            }
    } 
    
    public static Desporto VerAt(Utilizador user){
         System.out.println("Indique o nome da atividade");
         String atividade = Input.lerString();
         System.out.println("Quando foi praticada essa atividade (dd mm aaaa)?");
         GregorianCalendar data = Input.LerData();
         Desporto novo = user.getDesporto(atividade, data);                           
         return novo;
    }
    
    public static void Admin(Utilizadores users) throws IOException{
        int Op = 1;
        while(Op!=0){ 
             System.out.println("O número de utilizadores da aplicação é: " + ((users.getUtilizadores().size())-1));
             Menus.printMenuA();
             Op = Input.lerInt();
             
             switch(Op){
                case 1 : {
                  save(users);
                  break;
                }
                case 2 : {
                  System.out.println("Indique o nome do utilizador que pertende remover");
                  String nome = Input.lerString();
                  if(users.containsUtilizador(nome)){
                      if(users.removerUtilizador(users.getUtilizador(nome))) System.out.println("Utilizador removido com sucesso");
                  }
                  else System.out.println("Esse utilizador não existe");
                  break;
                }
                case 0 : { break; }
             }
        }
    }
    
    public static void Stats(Utilizador user){
         Menus.printMenuStats();
         int Op = Input.lerInt();
         System.out.println("Relativo a que ano pertende consultar?");
         int ano = Input.lerInt();
         switch(Op){
            case 1 : {
              Menus.printMenuMes();
              Op = Input.lerInt();
              if (Op > 12 || Op == 0) break;
              ImprimeStatsM(Op,ano,user);
              break;
            }
            case 2 : {
              ImprimeStatsA(ano,user);
              break;
            }
            case 0 : { break; }
         }
    }
    
    public static void ImprimeStatsA(int ano, Utilizador user){
         Menus.printMenuStatsP();
         int Op = Input.lerInt();
         System.out.println("Estatísticas do ano " + ano);
         DecimalFormat decimal = new DecimalFormat( "0.00" );
         DecimalFormat i = new DecimalFormat( "0" );  
         switch(Op){
            case 1 : {
              ArrayList<Double> dados = user.StatsDist_A(ano);
              if (dados.get(4) == 0) System.out.println("\nNão realizou nenhuma atividade nesse período;");
              else{
                  System.out.println("\nNúmero de atividades realizadas: " + i.format(dados.get(4)) + ";");
                  System.out.println("Distância total percorrida: " + decimal.format(dados.get(0)) + " Km;");
                  System.out.println("Distância média percorrida por atividade: " + decimal.format(dados.get(1)) +" Km;");
                  System.out.println("Velocidade máxima atingida numa atividade: " + decimal.format(dados.get(2)) +" Km/h;");
                  System.out.println("Velocidade mínima atingida numa atividade: " + decimal.format(dados.get(3)) +" Km/h;");
              }
              break;
            }
            case 2 : {
              ArrayList<Tempo> dados = user.StatsTemp_A(ano);
              if (dados == null) System.out.println("Não realizou nenhuma atividade nesse período;");
              else{
              System.out.print("\nTempo total dispendido a praticar desporto: " + dados.get(0).toString());
              System.out.print("Tempo médio dispendido por atividade: " + dados.get(1).toString());
              System.out.print("Tempo máximo dispendido numa atividade: " + dados.get(2).toString());
              System.out.print("Tempo mínimo dispendido numa atividade: " + dados.get(3).toString());
             }
             break;
            }
            case 3 : {
              ArrayList<Double> dados = user.StatsCal_A(ano);
              if (dados.get(4) == 0.0) System.out.println("\nNão realizou nenhuma atividade nesse período;");
              else{
                  System.out.println("\nNúmero de atividades realizadas: " + i.format(dados.get(4)) + ";");
                  System.out.println("Calorias totais despendidas: " + decimal.format(dados.get(0)) + " kCal;");
                  System.out.println("Média de calorias despendidas por atividade: " + decimal.format(dados.get(1)) +" kCal;");
                  System.out.println("Calorias Máximas despendidas numa atividade: " + decimal.format(dados.get(2)) +" kCal;");
                  System.out.println("Calorias Mínimas despendidas numa atividade: " + decimal.format(dados.get(3)) +" kCal;");
              }
              break;
            }
            case 0 : { break; }
         } 
    }
    
    public static void ImprimeStatsM(int mes,int ano, Utilizador user){
         String m;
         if(mes == 1) m = "Janeiro";
         else if(mes == 2) m = "Fevereiro";
         else if(mes == 3) m = "Março";
         else if(mes == 4) m = "Abril";
         else if(mes == 5) m = "Maio";
         else if(mes == 6) m = "Junho";
         else if(mes == 7) m = "Julho";
         else if(mes == 8) m = "Agosto";
         else if(mes == 9) m = "Setembro";
         else if(mes == 10) m = "Outubro";
         else if(mes == 11) m = "Novembro";
         else  m = "Dezembro";
         Menus.printMenuStatsP();
         int Op = Input.lerInt();
         System.out.print('\u000C');
         System.out.println("Estatísticas mês de " + m + " do ano " + ano);
         DecimalFormat decimal = new DecimalFormat( "0.00" );
         DecimalFormat i = new DecimalFormat( "0" );  
         switch(Op){
            case 1 : {
              ArrayList<Double> dados = user.StatsDist_M(mes,ano);
              if (dados.get(4) == 0.0) System.out.println("\nNão realizou nenhuma atividade nesse período;");
              else{
                  System.out.println("\nNúmero de atividades realizadas: " + i.format(dados.get(4)) + ";");
                  System.out.println("Distância total percorrida: " + decimal.format(dados.get(0)) + " Km;");
                  System.out.println("Distância média percorrida por atividade: " + decimal.format(dados.get(1)) +" Km;");
                  System.out.println("Velocidade máxima atingida numa atividade: " + decimal.format(dados.get(2)) +" Km/h;");
                  System.out.println("Velocidade mínima atingida numa atividade: " + decimal.format(dados.get(3)) +" Km/h;");
              }
            break;
            }
            case 2 : {
              ArrayList<Tempo> dados = user.StatsTemp_M(mes,ano);
              if (dados == null) System.out.println("Não realizou nenhuma atividade nesse período;");
              else{
              System.out.print("\nTempo total dispendido a praticar desporto: " + dados.get(0).toString());
              System.out.print("Tempo médio dispendido por atividade: " + dados.get(1).toString());
              System.out.print("Tempo máximo dispendido numa atividade: " + dados.get(2).toString());
              System.out.print("Tempo mínimo dispendido numa atividade: " + dados.get(3).toString());
             }
             break;
            }
            case 3 : {
              ArrayList<Double> dados = user.StatsCal_M(mes,ano);
              if (dados.get(4) == 0.0) System.out.println("\nNão realizou nenhuma atividade nesse período;");
              else{
                  System.out.println("\nNúmero de atividades realizadas: " + i.format(dados.get(4)) + ";");
                  System.out.println("Calorias totais despendidas: " + decimal.format(dados.get(0)) + " kCal;");
                  System.out.println("Média de calorias despendidas por atividade: " + decimal.format(dados.get(1)) +" kCal;");
                  System.out.println("Calorias Máximas despendidas numa atividade: " + decimal.format(dados.get(2)) +" kCal;");
                  System.out.println("Calorias Mínimas despendidas numa atividade: " + decimal.format(dados.get(3)) +" kCal;");
              }
              break;
            }
            case 0 : { break; }
         } 
    }
    
    public static void Records(Utilizador user){
         System.out.println("De que desporto pretende ver o recorde?");
         Menus.PrintMenuDesportos();
         int Op = Input.lerInt();
         System.out.print('\u000C');
         Desporto d;
         switch(Op){
            case 1 : {
                d = new Boxe();
                System.out.println(user.getRecordes().recordeAt(d));
                break; 
            }            
            case 2 : {
                d = new Zumba();
                System.out.println(user.getRecordes().recordeAt(d));
                break; 
            }
            case 3 : { 
                d = new Musculacao();
                System.out.println(user.getRecordes().recordeAt(d));
                break; 
            }
            case 4 : { 
                d = new Futsal();
                System.out.println(user.getRecordes().recordeAt(d));
                break; 
            }
            case 5 : { 
                d = new Tenis();
                System.out.println(user.getRecordes().recordeAt(d));
                break; 
            }
            case 6 : { 
                d = new Futebol();
                System.out.println(user.getRecordes().recordeAt(d));
                break; 
            }
            case 7 : { 
                d = new Basquetebol();
                System.out.println(user.getRecordes().recordeAt(d));
                break; 
            }
            case 8 : { 
                d = new Running();
                System.out.println(user.getRecordes().recordeAt(d));
                break; 
            }
            case 9 : { 
                d = new Ciclismo();
                System.out.println(user.getRecordes().recordeAt(d));
                break; 
            }
            case 10 : { 
                d = new Alpinismo();
                System.out.println(user.getRecordes().recordeAt(d));
                break; 
            }
            default : { break; }
         } 

    }
    
    /* Abre um ficheiro com Utilizadores se existir */
    public static Utilizadores open() throws IOException{
        try{
            String workingDir = System.getProperty("user.dir");
            FileInputStream fin = new FileInputStream(workingDir + "FitnessUM.ser");
            ObjectInputStream oin = new ObjectInputStream(fin);
            System.out.println("Ficheiro carregado com sucesso.");
            return (Utilizadores)oin.readObject();
        }
        catch (IOException | ClassNotFoundException e){
            //System.out.println("Ficheiro não carregado.");
            Utilizadores users = new Utilizadores();
            return users;
        }  
    }
    
    /* Guarda um ficheiro com os atuais Utilizadores da aplicação */
    public static void save(Utilizadores users) throws IOException{
        try{        
            String workingDir = System.getProperty("user.dir");
            FileOutputStream fos = new FileOutputStream(workingDir + "FitnessUM.ser");
            try (ObjectOutputStream oos = new ObjectOutputStream(fos)) {
                oos.writeObject(users);
                oos.close();
                System.out.println("Ficheiro guardado com successo.");
            }
        }
        catch (IOException e){
            System.out.println("Erro a guardar o ficheiro");
        }
    }                 
}
