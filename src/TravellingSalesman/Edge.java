package TravellingSalesman;

public class Edge extends Object{
	private Node left;
	private Node right;
	private int weight;		// could be anything e.g. streetname
	
	// Given the node at one end of and edge return the other end's node
	public Node navigate(Node node) throws Exception{
		if(this.left == node) return this.right;
		else if(this.right == node) return this.left;
		else throw new Exception("The node supplied does not belong to this edge");
	}
	
	// Constructors, getters and setters==================================
	public int getWeight() {
		return weight;
	}

	public void setWeight(int weight) {
		this.weight = weight;
	}

	public Node left() {
		return this.left;
	}

	public void setLeft(Node node0) {
		this.left = node0;
	}

	public Node right() {
		return this.right;
	}

	public void setRight(Node node1) {
		this.right = node1;
	}

	public Edge(Node node0, Node node1){
		this.left = node0;
		this.right = node1;
	}
	
	public Edge(Node node0, Node node1, int weight){
		this.left = node0;
		this.right = node1;
		this.weight = weight;
	}
	
	public String toString(){
		return "Edge: " + (String) this.left.attributes.get("name") + ": " + (String) this.right.attributes.get("name");
	}
}
