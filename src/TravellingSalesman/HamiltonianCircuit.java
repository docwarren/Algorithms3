package TravellingSalesman;

import java.util.Scanner;

public class HamiltonianCircuit {
	
	public static void main(String[] args) {
		// Create the graph
		Graph ham = new Graph();
		
		// Create the nodes
		String[] nodeNames = {"A","B","C","D","E","F","G","H"};
		for(int i = 0; i < nodeNames.length; i++){
			Node a = new Node(nodeNames[i]);
			ham.addNode(a);
		}
		
		// Do the joins
		ham.connect(ham.getNode("A"), ham.getNode("B"), 5);
		ham.connect(ham.getNode("A"), ham.getNode("C"), 10);
		ham.connect(ham.getNode("A"), ham.getNode("F"), 4);
		ham.connect(ham.getNode("D"), ham.getNode("B"), 8);
		ham.connect(ham.getNode("D"), ham.getNode("E"), 2);
		ham.connect(ham.getNode("E"), ham.getNode("C"), 9);
		ham.connect(ham.getNode("E"), ham.getNode("H"), 4);
		ham.connect(ham.getNode("C"), ham.getNode("F"), 3);
		ham.connect(ham.getNode("C"), ham.getNode("G"), 5);
		ham.connect(ham.getNode("G"), ham.getNode("H"), 3);
		ham.connect(ham.getNode("G"), ham.getNode("F"), 6);
		
		System.out.println(ham.toString());
		@SuppressWarnings("resource")
		Scanner inputReader = new Scanner(System.in);
		String input;
		System.out.println("Enter a Hamiltonian circuit: \n");
		input = inputReader.nextLine();
		String[] nodeList = input.split("");
		if(ham.isOkPermutation(nodeList)){
			System.out.println("Permutation is OK");
		}
		else System.out.println("Circuit is not valid");
		int hamLength;
		try {
			hamLength = ham.graphLength(nodeList);
			System.out.println("This valid Hamiltonian circuit has a length of " + hamLength);
		} catch (Exception e) {
			System.out.println(e);
		}
		
		Kruskals k = new Kruskals(ham);
		String x = k.getShortestPath().toString();
        System.out.println(x);
	}
}
