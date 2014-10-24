package TravellingSalesman;

import java.util.Comparator;

public class PersonComparator implements Comparator<Person> {

    public int compare(Person left, Person right) {
        if((Integer)left.getAttribute("nodeCount") < (Integer)right.getAttribute("nodeCount")) return 1;
        if((Integer)left.getAttribute("nodeCount") > (Integer)right.getAttribute("nodeCount")) return -1;
        return 0;
    }
}
