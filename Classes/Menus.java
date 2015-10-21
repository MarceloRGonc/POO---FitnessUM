
/**
 * 
 * @author Grupo 16 
 */
public class Menus
{
    public static void printMenuP(){
       System.out.println("\nBem vindo á aplicação FitnessUM\n\n");
       System.out.println("\t1 - Fazer Login");
       System.out.println("\t2 - Criar nova conta de Utilizador\n");
       System.out.println("\t0 - Sair");
       System.out.print("\nInsira a opção: ");
    }
    
    public static void PrintMenuU(){
       System.out.println("1 - Enviar Pedido de amizade");
       System.out.println("2 - Ver Lista de Amigos");
       System.out.println("3 - Ver Pedidos de amizade pendentes");
       System.out.println("4 - Apagar Amigo");
       System.out.println("5 - Alterar Dados");
       System.out.println("6 - Ver atividades realizadas");
       System.out.println("7 - Adicionar atividades");
       System.out.println("8 - Ver Atividades de um amigo");
       System.out.println("9 - Ver Dados de um amigo");
       System.out.println("10 - Visualizar estatísticas");
       System.out.println("11 - Verificar Recordes Pessoais");
       System.out.println("0 - Logout");
       System.out.print("\nInsira a opção: ");
    }
    
    public static void printMenuA(){
       System.out.println("\nBem vindo Admin\n\n");
       System.out.println("\t1 - Gravar Estado");
       System.out.println("\t2 - Apagar determinado utilizador");
       System.out.println("\t0 - Sair.");
       System.out.print("\nInsira a opção: ");
    }
    
    public static void printMenuAlt(){
         System.out.println("Indique os dados que quer alterar");
         System.out.println("\t1 - Para alterar o seu email");
         System.out.println("\t2 - Para alterar a password");
         System.out.println("\t3 - Para alterar o seu nome");
         System.out.println("\t4 - Para alterar o seu género");
         System.out.println("\t5 - Para alterar o seu desporto favorito");
         System.out.println("\t6 - Para alterar a sua altura");
         System.out.println("\t7 - Para alterar o seu peso");
         System.out.println("\t8 - Para alterar a sua data de nascimento");
         System.out.println("\t0 - Para regressar ao menu anterior");
         System.out.print("\nInsira a opção: ");
    }
    
    public static void printMenuVerAt(){
         System.out.println("\nEscolha uma opção");
         System.out.println("\t1 - Para ver mais atividades");
         System.out.println("\t2 - Para ver uma atividade com mais detalhe");
         System.out.println("\t3 - Para remover uma atividade");
         System.out.println("\tQualquer número para voltar ao menu");
         System.out.print("\nInsira a opção: ");
    }
    
    public static void printMenuVerAt2(){
         System.out.println("\nNão possui mais atividades;");
         System.out.println("\nEscolha uma opção");
         System.out.println("\t1 - Para ver uma atividade com mais detalhe");
         System.out.println("\t2 - Para remover uma atividade");
         System.out.println("\tQualquer número para voltar ao menu\n");
         System.out.print("\nInsira a opção: ");
    }
    
    public static void printMenuVerAtA(){
         System.out.println("\nEscolha uma opção");
         System.out.println("\t1 - Para ver mais atividades");
         System.out.println("\t2 - Para ver uma atividade com mais detalhe");
         System.out.println("\tQualquer número para voltar ao menu");
         System.out.print("\nInsira a opção: ");
    }
    
    public static void printMenuVerAtA2(){
         System.out.println("\nNão possui mais atividades;");
         System.out.println("\nEscolha uma opção");
         System.out.println("\t1 - Para ver uma atividade com mais detalhe");
         System.out.println("\tQualquer número para voltar ao menu\n");
         System.out.print("\nInsira a opção: ");
    }
    
    public static void printMenuDesp(){
         System.out.println("Que tipo de atividade física deseja adicionar?");
         System.out.println("\t1 - Desporto Coletivo");
         System.out.println("\t2 - Desporto Individual");
         System.out.println("\t3 - Desportos de Ginásio");
         System.out.println("\t0 - Voltar ao menu anterior");
         System.out.print("\nInsira a opção: ");
    }
    
    public static void printMenuDespI(){
         System.out.println("Que desporto deseja adicionar?");
         System.out.println("\t1 - Ténis");                
         System.out.println("\t2 - Ciclismo");
         System.out.println("\t3 - Boxe");
         System.out.println("\t4 - Running");
         System.out.println("\t5 - Musculação");
         System.out.println("\t0 - Voltar ao menu anterior");
         System.out.print("\nInsira a opção: ");
    }

    public static void printMenuDespC(){
         System.out.println("Que desporto deseja adicionar?");
         System.out.println("\t1 - Futebol");
         System.out.println("\t2 - Basquetebl");
         System.out.println("\t3 - Futsal");
         System.out.println("\t0 - Voltar ao menu anterior");
         System.out.print("\nInsira a opção: ");
    }
    
    public static void printMenuDespG(){
         System.out.println("Que desporto deseja adicionar?");
         System.out.println("\t1 - Musculação");
         System.out.println("\t2 - Zumba");
         System.out.println("\t0 - Voltar ao menu anterior");
         System.out.print("\nInsira a opção: ");
    }
    
    public static void printMenuStats(){
         System.out.println("Que periodo pretende abranger?");
         System.out.println("\t1 - Mensal");
         System.out.println("\t2 - Anual");
         System.out.println("\t0 - Voltar ao menu anterior");
         System.out.print("\nInsira a opção: ");
    }
    
    public static void printMenuStatsP(){
         System.out.println("Em função de que parâmetro pretende consultar?");
         System.out.println("\t1 - Distância");
         System.out.println("\t2 - Tempo");
         System.out.println("\t3 - Calorias");
         System.out.println("\t0 - Voltar ao menu anterior");
         System.out.print("\nInsira a opção: ");
    }
    
    public static void printMenuMes(){
         System.out.println("Que mês pretende consultar?");
         System.out.println("\t1 - Janeiro");
         System.out.println("\t2 - Fevereiro");
         System.out.println("\t3 - Março");
         System.out.println("\t4 - Abril");
         System.out.println("\t5 - Maio");
         System.out.println("\t6 - Junho");
         System.out.println("\t7 - Julho");
         System.out.println("\t8 - Agosto");
         System.out.println("\t9 - Setembro");
         System.out.println("\t10 - Outubro");
         System.out.println("\t11 - Novembro");
         System.out.println("\t12 - Dezembro");
         System.out.println("\tQualquer um para voltar atrás");
         System.out.print("\nInsira a opção: ");
    }
    
    public static void PrintMenuDesportos(){
       System.out.println("\t1 - Boxe");
       System.out.println("\t2 - Zumba");
       System.out.println("\t3 - Musculação");
       System.out.println("\t4 - Futsal");
       System.out.println("\t5 - Tenis");
       System.out.println("\t6 - Futebol");
       System.out.println("\t7 - Basquetebol");
       System.out.println("\t8 - Running");
       System.out.println("\t9 - Ciclismo");
       System.out.println("\t10 - Alpinismo");
       System.out.println("\tQualquer um para voltar atrás");
       System.out.print("\nInsira a opção: ");
    }
    
}
