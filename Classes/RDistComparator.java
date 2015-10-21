/**
 * 
 * @author Grupo 16 
 */
import java.util.*;
import java.io.Serializable;

public class RDistComparator implements Comparator<ComDistancia>, Serializable
{
    public int compare(ComDistancia d1, ComDistancia d2) {
		if (d1.getVelmed() > d2.getVelmed())
			return -1;
		else if (d1.getVelmed() < d2.getVelmed())
			return 1;
		else if (d1.getTempoM() > d2.getTempoM())
			return -1;
		else if (d1.getTempoM() < d2.getTempoM())
			return 1;
		else
			return 0;
	}
}
