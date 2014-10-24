package TravellingSalesman;
import org.junit.Test;

import java.io.FileNotFoundException;
import java.util.ArrayList;

import static java.lang.Integer.parseInt;
import static junit.framework.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Created by andrew on 24/10/14.
 */
public class BookTest {
    GraphMaker controller;
    BookFace g;

    public BookTest(){
        try {
            this.controller = new GraphMaker("people.csv", "connections.csv");
            this.g = controller.getGraph();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void idTest(){
            Person p = g.getNodeById("11");
            assertEquals(p.getName(), "Levi O. Terrell");
    }

    @Test
    public void nameTest(){
        Person p = (Person)g.getNode("Levi O. Terrell");
        assertEquals(p.getAttribute("id"), "11");
        assertEquals(p.getAttribute("email"), "varius.Nam.porttitor@vel.ca");
        assertEquals(p.getAttribute("address"), "Ap #358-738 Sed Av.");
        assertEquals(p.getAttribute("country"), "Serbia");
    }

    @Test
    public void friendIdTest(){
        Person[] peeps = this.g.getFriendsById("12");
        ArrayList<Integer> expFriends = new ArrayList<Integer>();
        expFriends.add(6);
        expFriends.add(42);
        expFriends.add(49);
        expFriends.add(50);

        assertEquals(peeps.length, 4);
        for (Person peep : peeps) {
            int id = parseInt(((String) peep.getAttribute("id")));
            assertTrue(expFriends.contains(id));
        }
    }

    @Test
    public void noFriendsTest(){
        Person[] peeps = this.g.getNoFriends();
        assertEquals(peeps.length, 0);
    }

    @Test
    public void topUsersTest(){
        Person[] peeps = this.g.topUsers(5);
        assertEquals(peeps.length, 5);
        for(int i = 0; i < peeps.length; i++){
            System.out.println(peeps[i].getName() + " friend count: " + peeps[i].getAttribute("nodeCount"));
        }
    }
}
