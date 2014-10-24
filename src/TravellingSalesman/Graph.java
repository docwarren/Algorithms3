package TravellingSalesman;

import java.util.ArrayList;
import java.util.HashMap;

public class Graph {
	ArrayList<Node> nodes = new ArrayList<Node>();
	
	@Override
	public String toString() {
		String result = "";
		for(Node n: this.nodes){
			result += n.toString();
		}
		return result;
	}

	public void addNode(Node node){
		this.nodes.add(node);
		node.edges.clear();
	}
	
	public ArrayList<Node> getNodes(){
		return this.nodes;
	}
	
	public void connect(Node node0, Node node1, int weight){
        Edge old = node0.getEdge(node0, node1);
        Edge old2 = node0.getEdge(node1, node0);
        if(old == null && old2 == null){
            Edge newEdge = new Edge(node0, node1, weight);
            node0.addEdge(newEdge);
            node1.addEdge(newEdge);
        }
	}
	
	public Node getNode(String name){
		for(Node n: this.nodes){
			if(n.getAttributes().get("name").equals(name)) return n;
		}
		return null;
	}

	public Boolean isOkPermutation(String[] nodeList) {
		// Must have all the nodes
		if(nodeList.length != this.nodes.size()) return false;
		
		HashMap<String, Integer> nodeHash = new HashMap<String, Integer>();
        for (String node : nodeList) {
            // Must not have duplicate nodes
            if (nodeHash.containsKey(node)) return false;
            nodeHash.put(node, 0);
            // Must have all nodes at least once
            if (getNode(node) == null) return false;
        }
		return true;
	}
	
	public int graphLength(String[] nodeList) throws Exception{
		int length = 0;
		for(int i = 0; i < nodeList.length -1; i++){
			Node left = getNode(nodeList[i]);
			Node right = getNode(nodeList[i+1]);
			Edge e = left.getEdge(left, right);
			if(e != null) length += e.getWeight();
			else throw new Exception("Graph does not contain given edge: " + left.getName() + ": " + right.getName());
		}
		return length;
	}
}
