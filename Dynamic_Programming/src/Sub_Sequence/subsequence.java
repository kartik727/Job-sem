package Sub_Sequence;

public class subsequence {

	public static void main(String[] args) {
		String X = "ABCDEFZ";
		String Y = "ACDEFBZ";
		
		subs_calc sc = new subs_calc(X, Y);
		
		System.out.println(sc.get_maxLen());

	}

}

class subs_calc{
	private final char[] X;
	private final char[] Y;
	
	private int m;
	private int n;
	
	private int ans;
	
	public subs_calc(String x, String y){
		X = x.toCharArray();
		Y = y.toCharArray();
		
		m = X.length;
		n = Y.length;
		
		ans = longest_subs(m, n);
	}
	
	public int longest_subs(int m, int n){
		if(m == 0 || n == 0)
			return 0;
		
		if(X[m-1] == Y[n-1])
			return longest_subs(m-1, n-1) + 1;
		
		return max(longest_subs(m-1, n), longest_subs(m, n-1));
	}
	
	public int max(int a, int b){
		return (a>b) ? a : b;
	}
	
	public int get_maxLen(){
		return ans;
	}
}
