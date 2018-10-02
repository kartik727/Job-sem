package Digits;


public class digits {

	public static void main(String[] args) {
		int a = 5;
		int b = 11;
		
		int ans = digSum(a, b);
		
		System.out.println(ans);
	}
	
	public static int digSum(int a, int b){
		if(b < a)
			return 0;
		
		int sum = 0;
		
		for(int i = a; i <= b; i++){
			sum += dpp(i);
		}
		
		return sum;
	}
	
	public static int dpp(int x){
		int ds = 0;
		
		while(x != 0){
			ds += x%10;
			x = x/10;
		}
		
		return ds;
	}

}
