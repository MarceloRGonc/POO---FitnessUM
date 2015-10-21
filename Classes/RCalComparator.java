/**
 * 
 * @author Grupo 16
 */
import java.io.Serializable;
import java.util.*;

public class RCalComparator implements Comparator<SemDistancia>, Serializable
{
    public int compare(SemDistancia d1, SemDistancia d2) {
		if (d1.getCaloriasH() > d2.getCaloriasH()) return -1;
		else if (d1.getCaloriasH() < d2.getCaloriasH()) return 1;
		else if (d1.getTempoM() > d2.getTempoM()) return -1;
		else if (d1.getTempoM() < d2.getTempoM()) return 1;
		else return 0;
	}
}
