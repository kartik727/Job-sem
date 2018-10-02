package pipes;

import java.util.ArrayList;

public class pipe_ques {
	
	static int VertexNumber = 0;

	public static void main(String[] args) {
		int H = 5;
		int W = 6;
		int R = 2;
		int C = 1;
		int L = 3;
		
		ArrayList<edge> edges = new ArrayList<>();
		
		int[][] Matrix = {
				{0, 0, 5, 3, 6, 0},
				{0, 0, 2, 0, 2, 0},
				{3, 3, 1, 3, 7, 0},
				{0, 0, 0, 0, 0, 0},
				{0, 0, 0, 0, 0, 0}
		};
		
		vertex[][] graph = new vertex[H][W];
		vertex[] lin_v = new vertex[H*W];
		
		for(int i = 0; i < H; i++){
			for(int j = 0; i < W; j++){
				vertex v = new vertex(i, j, Matrix[i][j]);
				graph[i][j] = v;
				lin_v[i*W+j] = v;
			}
		}
		
		for(int i = 0; i < H; i++){
			for(int j = 0; j < W; j++){
				if(j>0){
					if(graph[i][j].left && graph[i][j-1].right){
						edges.add(new edge(i*W+j, i*W+j-1));
					}
				}
			}
		}
		
		//int[] vertices = new int[count];
				

	}

}

class vertex{
	int x;
	int y;
	
	//int number;
	
	boolean up;
	boolean down;
	boolean left;
	boolean right;
	
	public vertex(int x, int y, int type){
		this.x = x;
		this.y = y;
		
		//number = pipe_ques.VertexNumber++;
		
		switch(type){
			case 0:
				up = false;
				down = false;
				left = false;
				right = false;
				break;
			
			case 1:
				up = true;
				down = true;
				left = true;
				right = true;
				break;
				
			case 2:
				up = true;
				down = true;
				left = false;
				right = false;
				break;
				
			case 3:
				up = false;
				down = false;
				left = true;
				right = true;
				break;
				
			case 4:
				up = true;
				down = false;
				left = false;
				right = true;
				break;
				
			case 5:
				up = false;
				down = true;
				left = false;
				right = true;
				break;
				
			case 6:
				up = false;
				down = true;
				left = true;
				right = false;
				break;
				
			case 7:
				up = true;
				down = false;
				left = true;
				right = false;
				break;
				
		}
	}
}

class edge{
	int start_node;
	int end_node;
	
	public edge(int start_node, int end_node){
		this.start_node = start_node;
		this.end_node = end_node;
	}
}