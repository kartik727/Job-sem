package Knapsack;

public class knapsack {
	public static void main (String[] args){
		int[] wts = {10, 20, 30};
		int[] vals = {60, 100, 120};
		int W = 50;
		
		int n = wts.length;
		
		int ans = kpsk.findKpsk(wts, vals, n, W);
		
		System.out.println(ans);
	}

}

class kpsk{
	public static int max (int a, int b){
		return (a > b)? a: b;
	}
	
	public static int findKpsk(int[] wts, int[] vals, int n, int W){
		if((n == 0) || (W == 0))
			return 0;
		
		if(wts[n-1] > W)
			return findKpsk(wts, vals, n-1, W);
		
		return max(findKpsk(wts, vals, n-1, W-wts[n-1])+vals[n-1], findKpsk(wts, vals, n-1, W));
	}
}

