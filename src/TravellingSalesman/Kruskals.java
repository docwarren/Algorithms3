package TravellingSalesman;

import java.util.ArrayList;
import java.util.Random;

public class Kruskals {
	Graph graph;
	Graph result = new Graph();
	ArrayList<Edge> edges = new ArrayList<Edge>();
	Edge shortest;
	
	// Constructor fills the Edges set and creates a set of graphs ( one for each Node )
	public Kruskals(Graph g){
		this.graph = g;
		fillEdges();
		this.edges.sort(new EdgeComparator());
	}
	
	// Gets the shortest path in the graph
	public Graph getShortestPath(){
		while(this.edges.size() > 0 && this.result.getNodes().size() < this.graph.getNodes().size() + 1){
			Edge e = nextShortest();
			System.out.println(e.toString());
			System.out.println(this.edges.size());
			this.edges.remove(this.edges.indexOf(e));
			noLoops(e);
			//System.out.println(this.edges.size());
		}
		return result;
	}
	
	// Gets the next shortest edge in the edge set. If more than one are present picks one at random
	public Edge nextShortest(){
		ArrayList<Edge> shorts = new ArrayList<Edge>();
		for(Edge e: this.edges){
			if(shorts.size() == 0 || e.getWeight() < shorts.get(0).getWeight()) shorts.add(e);
			else break;
		}
		if(shorts.size() == 1){
			return shorts.get(0);
		}
		else{
			Random r = new Random();
			int index = r.nextInt(shorts.size());
			return shorts.get(index);
		}
	}

	public void noLoops(Edge e){
		// No duplicates
		String nameLeft = e.left().getName();
		String nameRight = e.right().getName();
		Node nl = this.result.getNode(nameLeft);
		Node nr = this.result.getNode(nameRight);
		
		if(nl != null && nr != null){
			if(nl.countEdges() > 1 || nr.countEdges() > 1) return;
		}
		
		// Add the nodes for this edge and connect them
		if(nl == null) this.result.addNode(e.left());
		if(nr == null) this.result.addNode(e.right());
		
		nl = this.result.getNode(nameLeft);
		nr = this.result.getNode(nameRight);
		this.result.connect(nl, nr, e.getWeight());
	}

	// Getters and Setters and constructors========================================
	public Graph getGraph() {
		return this.graph;
	}

	private void fillEdges() {
		for(Node n: this.graph.getNodes()){
			for(Edge e: n.getEdges()) {
				if(!this.edges.contains(e))this.edges.add(e);
			}
		}
	}
}
