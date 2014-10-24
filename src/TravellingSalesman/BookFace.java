package TravellingSalesman;

import java.util.ArrayList;
import java.util.HashMap;

public class BookFace extends Graph {
    public Person getNodeById(String id){
        for(Node p: this.getNodes()){
            if(p.getAttributes().get("id").equals(id)) return (Person) p;
        }
        return null;
    }

    public Person[] getFriends(Person p){
        HashMap<Person, Integer> friends = new HashMap<Person, Integer>();
        for(Edge c: p.getEdges()){
            friends.put((Person)c.left(), 0);
            friends.put((Person)c.right(), 0);
        }
        friends.remove(p);
        Person[] people = new Person[friends.size()];
        int count = 0;
        for(Person key: friends.keySet()){
            people[count] = key;
            count++;
        }
        return people;
    }

    public Person[] getFriendsById(String id){
        Person p = getNodeById(id);
        return getFriends(p);
    }

    public Person[] getNoFriends(){
        HashMap<Person, Integer> friends = new HashMap<Person, Integer>();
        for(Node p: getNodes()){
            if(p.getEdges().size() == 0) friends.put((Person)p, 0);
        }
        Person[] people = new Person[friends.size()];
        int count = 0;
        for(Person key: friends.keySet()){
            people[count] = key;
            count++;
        }
        return people;
    }

    public Person[] topUsers(int count){
        ArrayList<Person> people = new ArrayList<Person>();
        for(Node n: this.getNodes()){
            ((Person) n).setAttribute("nodeCount", n.getEdges().size());
            people.add((Person) n);
        }

        Person[] result = new Person[count];
        people.sort(new PersonComparator());
        int c = 0;
        for(Person p: people){
            result[c] = p;
            c++;
            if(c >= count)break;
        }
        return result;
    }


}
