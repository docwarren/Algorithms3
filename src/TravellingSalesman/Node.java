package TravellingSalesman;

import java.util.ArrayList;
import java.util.HashMap;

public class Node {
	HashMap<String, Object> attributes = new HashMap<String, Object>();
	ArrayList<Edge> edges = new ArrayList<Edge>();
	Edge shortest;

    public Node() {
    }

    public int countEdges(){
		return this.edges.size();
	}

	public Node(String name) {
		this.attributes.put("name", name);
	}
	
	public String getName(){
		return ((String) this.attributes.get("name")).trim();
	}
	
	public void addEdge(Edge edge){
		if(getEdge(edge.left(), edge.right()) == null &&
                getEdge(edge.right(), edge.left()) == null){
            this.edges.add(edge);
            if(this.shortest == null || edge.getWeight() < this.shortest.getWeight())
                this.shortest = edge;
        }
	}
	
	public ArrayList<Edge> getEdges(){
        if(this.edges == null) return new ArrayList<Edge>();
		return this.edges;
	}
	
	public HashMap<String, Object> getAttributes(){
		return this.attributes;
	}
	
	public Edge getEdge(Node left, Node right){
		for(Edge e: this.edges){
			if(e.left().getName().equals(left.getName()) && e.right().getName().equals(right.getName())) return e;
			if(e.right().getName().equals(left.getName()) && e.left().getName().equals(right.getName())) return e;
		}
		return null;
	}

	@Override
	public String toString() {
		String result = "Node: " + this.attributes.get("name") + "\n";
		for(Edge e: this.edges){
			result += e.toString() + "\n";
		}
		return result + "\n";
	}
	
	
}
