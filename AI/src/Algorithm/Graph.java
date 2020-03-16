package Algorithm;

import java.util.ArrayList;

import Rules.Board;

class Node {
	int id;
	int weight;
	Board board;

	Node (int id, int w, Board b) {
		weight = w;
		board = b;
	}
	
	
}

public class Graph {

	private ArrayList<Node> graph;
	private ArrayList<ArrayList<Integer>> adj;
	
	public void createNode(int id, int w, Board b) {
		Node n = new Node (id, w, b);
		graph.add(n);

	}

	public void addEdge (Node a, Node b) {
		int i = graph.indexOf(a);
		int j = graph.indexOf(b);
		adj.get(i).add(j);
	}
	
	
	

}
