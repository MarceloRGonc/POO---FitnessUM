
/**
 * 
 * @author Grupo 16 
 */
import java.util.*;
import java.io.Serializable;

public class DataComparator implements Comparator<Desporto>, Serializable
{
    public int compare(Desporto n1, Desporto n2){
        GregorianCalendar d1 = n1.getData();
        GregorianCalendar d2 = n2.getData();
            
        if(d1.get(Calendar.YEAR) > d2.get(Calendar.YEAR)) return -1;
        else if(d1.get(Calendar.YEAR) < d2.get(Calendar.YEAR)) return 1;
        else{
            if(d1.get(Calendar.MONTH) > d2.get(Calendar.MONTH)) return -1;
            else{
                 if(d1.get(Calendar.MONTH) == d2.get(Calendar.MONTH) && (d1.get(Calendar.DAY_OF_MONTH) > d2.get(Calendar.DAY_OF_MONTH))) return -1;
                 else{
                         if(n1.equals(n2)) return 0;
                         else return 1;
                 }
                }
            } 
        }
}

