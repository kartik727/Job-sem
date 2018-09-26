package bellman_ford;

import java.util.ArrayList;

public class bell_ford {
	public static void main(String[] args){
		int num_nodes = 9;
		int[][] graph = {{1, 2, 1}, {3, 2, 5}, {0, 1, 2}, {0, 3, 3}, {0, 5, 7}, {0, 4, 8}, {0, 7, 2}, {6, 0, 9}, {7, 6, 6}, {7, 8, 5}};
		
		System.out.println(graph.length);
	}
}

class BellFord_search{
	private int[] nodes;
	private ArrayList<edge> edges;
	private int src_node;
	public BellFord_search(int[][] graph, int src_node){
		this.src_node = src_node;
		
		edges = new ArrayList<>();
		for(int i = 0; i < graph.length; i++){
			edges.add(new edge(graph[i][0], graph[i][1], graph[i][2]));
		}
	}
}

class edge{
	int start_node;
	int end_node;
	int distance;
	
	public edge(int start_node, int end_node, int distance){
		this.start_node = start_node;
		this.end_node = end_node;
		this.distance = distance;
	}
}