package Algorithm;

import java.util.ArrayList;

import Rules.Coordinate;

public class Graph {

    // A ArrayList vai ser uma ArrayList de Graph
	private ArrayList<Graph>[] graphConnections;
	private int[] graphWeights;
	private Coordinate[] graphAttributes;
	
	@SuppressWarnings("unchecked")
	public Graph(int nodes) {
		this.graphConnections = new ArrayList[nodes];
		this.graphWeights = new int[nodes];
		this.graphAttributes = new Coordinate[nodes];
		
		for (int i = 0; i < graphConnections.length; i++) {
			this.graphConnections[i] = new ArrayList<Graph>();
		}
	}
	
	public void addElements(int node, Graph ... elements) {
		for (Graph i : elements) {
			this.graphConnections[node].add(i);
		}
	}
	
	public ArrayList<Graph>[] getGraphConnections(){
		return this.graphConnections;
	}
	
	public void putWeight(int node, int weight) {
		this.graphWeights[node] = weight;
	}
	
	public int getWeight(int node) {
		return this.graphWeights[node];
	}
	
	public int[] getAllWeights() {
		return this.graphWeights;
	}
	
	public void putMoviment(int node, Coordinate c) {
		this.graphAttributes[node] = c;
	}
	
	public Coordinate getMoviment(int node) {
		return this.graphAttributes[node];
	}
	
	public int getAllDepth() {
		
		boolean[] visited = new boolean[this.graphConnections.length];
		
		for (int i = 0; i < visited.length; i++) 
			visited[i] = false;
		
		DFS dfs = new DFS(this.graphConnections, this.graphConnections.length);
		dfs.Search(0, this.graphConnections.length - 1);
		
		return dfs.getPath().size();
	}
	public int getDepth(int node) {
		
		boolean[] visited = new boolean[this.graphConnections.length];
		
		for (int i = 0; i < visited.length; i++) 
			visited[i] = false;
		
		DFS dfs = new DFS(this.graphConnections, this.graphConnections.length);
		dfs.Search(0, node);
		
		return dfs.getPath().size();
	}

	public static void main(String[] args) {
        // Implementando o segundo grafo que Felipe desenhou no Whats.
		Graph g_0 = new Graph(3);
        // Como só o nó 1 é um subgrafo, só ele precisa ser adicionado. Os outros nó terão cada um seu peso dentro de g_0, mas não terão um objeto equivalente na ArrayList
        Graph sub_graph_1 = new Graph(2);
        Graph sub_graph_5 = new Graph(1);
        
		g_0.addElements(0, sub_graph_1);
        sub_graph_1.addElements(1, sub_graph_5);
        /*
		ArrayList<Integer>[] graph = g.graph();
		for (int i = 0; i < graph.length; i++) {
			for (int j = 0; j < graph[i].size(); j++) {
				System.out.print(graph[i].get(j));
			}
			System.out.println();
		}*/
	}
}
