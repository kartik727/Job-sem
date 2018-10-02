package DFS;

public class graph_dfs {

	public static void main(String[] args) {
		int V = 5;
		int E[] = {1, 2, 1, 3, 2, 4, 2, 5};
		int x = 0;
		
		graph g = new graph(V, E);
		
		System.out.println("Recursive starting from " + x + ":");
		g.dfs_recursive(0);
		System.out.println();
		
		System.out.println("Iterative starting from " + x + ":");
		g.dfs_iterative(0);
		System.out.println();

	}

}

class graph{
	int V;
	//int[] search_order;
	int[][] V_nbrs;
	boolean[] visited;
	public graph(int V, int[] E){
		this.V = V;
		//search_order = new int[V];
		V_nbrs = new int[V][];
		visited = new boolean[V];
		refresh();
		for(int i = 0; i < V; i++){
			//visited[i] = false;
			int Vi = count(E, i+1);
			V_nbrs[i] = new int[Vi];
			int V_idx = 0;
			for(int j = 0; j < E.length-1; j+=2){
				if(E[j] == i+1){
					V_nbrs[i][V_idx] = E[j+1]-1;
					V_idx++;
				}
				if(E[j+1] == i+1){
					V_nbrs[i][V_idx] = E[j]-1;
					V_idx++;
				}
			}
		}
		
	}
	
	public int count(int[] E, int Vnum){
		int ret = 0;
		for(int i = 0; i < E.length; i++){
			if(E[i] == Vnum)
				ret++;
		}
		return ret;
	}
	
	public void dfs_recursive(int idx){
		refresh();
		_dfs_recursive(idx);
	}
	
	public void _dfs_recursive(int idx){
		System.out.print(idx+1 + " ");
		visited[idx] = true;
		for(int i = 0; i < V_nbrs[idx].length; i++){
			if(!visited[V_nbrs[idx][i]]){
				_dfs_recursive(V_nbrs[idx][i]);
			}
		}
	}
	
	public void dfs_iterative(int e1){
		refresh();
		int[] stack = new int[V];
		
		int end_idx = -1;
		push(stack, e1, ++end_idx);
		
		visited[e1] = true;
		
		int curr_e;
		
		while(end_idx >= 0){
			curr_e = pop(stack, end_idx--);
			for(int i =0; i < V_nbrs[curr_e].length; i++){
				if(!visited[V_nbrs[curr_e][i]]){
					push(stack, V_nbrs[curr_e][i], ++end_idx);
					visited[V_nbrs[curr_e][i]] = true;
				}
			}
		}
	}
	
	public void push(int[] stack, int e, int end_idx){
		stack[end_idx] = e;
	}
	
	public int pop(int[] stack, int end_idx){
		int e = stack[end_idx];
		System.out.print(e+1 + " ");
		return e;
	}
	
	public void refresh(){
		for(int i = 0; i < V; i++){
			visited[i] = false;
		}
	}
}
