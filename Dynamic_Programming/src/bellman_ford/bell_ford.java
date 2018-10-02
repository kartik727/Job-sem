package bellman_ford;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;

public class bell_ford {
	public static void main(String[] args) throws IOException{
		int num_nodes;
		int num_edges;
		int[][] graph;
		
		String file_path = "C:/Users/karti/workspace/Job-sem/Dynamic_Programming/src/bellman_ford/graph2.txt";
		Scanner sc = new Scanner(Paths.get(file_path));
		
		num_nodes = sc.nextInt();
		num_edges = sc.nextInt();
		graph = new int[num_edges][3];
		
		for(int i = 0; i < num_edges; i++){
			for(int j = 0; j < 3; j++){
				graph[i][j] = sc.nextInt();
			}
		}
		
		sc.close();
		
		System.out.println(graph.length);
		BellFord_search BMF = new BellFord_search(graph, 0, num_nodes);
		int[] min_dists = BMF.getMinDistances();
		
		for(int i = 0; i < min_dists.length; i++){
			System.out.print(min_dists[i] + " ");
		}
	}
}

class BellFord_search{
	private static int INF = 5000;
	
	private int[] distances;
	private ArrayList<edge> edges;
	private int num_nodes;
	private int src_node;
	
	public BellFord_search(int[][] graph, int src_node, int num_nodes){
		this.src_node = src_node;
		this.num_nodes = num_nodes;
		
		edges = new ArrayList<>();
		for(int i = 0; i < graph.length; i++){
			edges.add(new edge(graph[i][0], graph[i][1], graph[i][2]));
		}
		
		distances = new int[num_nodes];
		for(int i = 0; i < num_nodes; i++){
			if(i  == this.src_node)
				distances[i] = 0;
			else
				distances[i] = INF;
		}
		
		find_minDists();
	}
	
	public void find_minDists(){
		int E = edges.size();
		
		for(int i = 0; i < num_nodes-1; i++){
			for(int j = 0; j < E; j++){
				int u = edges.get(j).start_node;
				int v = edges.get(j).end_node;
				distances[v] = update(distances[u], distances[v], edges.get(j).distance);
			}
		}
	}
	
	public int update(int dist_u, int dist_v, int d){
		if(dist_u == INF)
			return dist_v;
		
		if(dist_u + d < dist_v)
			return dist_u + d;
		else
			return dist_v;
	}
	
	public int[] getMinDistances(){
		return distances;
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