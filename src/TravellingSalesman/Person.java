package TravellingSalesman;

/**
 * Created by andrew on 24/10/14.
 */
public class Person extends Node {

    public Person(String[] attr){
        setAttribute("id", attr[0]);
        setAttribute("name", attr[2].trim() + " " + attr[1].trim());
        setAttribute("email", attr[3]);
        setAttribute("address", attr[4]);
        setAttribute("city", attr[5]);
        setAttribute("country", attr[6]);
        setAttribute("friendCount", 0);
    }

    public void setAttribute(String key, Object o){
        this.attributes.put(key, o);
    }

    public Object getAttribute(String key){
        return this.attributes.get(key);
    }
}
