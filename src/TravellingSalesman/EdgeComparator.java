package TravellingSalesman;

import java.util.Comparator;

public class EdgeComparator implements Comparator<Edge>{

	public int compare(Edge left, Edge right) {
		if(left.getWeight() > right.getWeight()) return 1;
		if(left.getWeight() < right.getWeight()) return -1;
		return 0;
	}
}

