package BitMasking;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;

public class bitmasking {
	public static void main(String[] args) throws IOException{
		String file_path = "C:/Users/karti/workspace/Job-sem/Dynamic_Programming/src/BitMasking/input.txt";
		Scanner sc = new Scanner(Paths.get(file_path));
		
		//int n = sc.nextInt();
		
		ArrayList<collection> people = new ArrayList<>();
		
		while(sc.hasNextLine()){
			collection c = new collection(sc.nextLine());
			people.add(c);
		}
		
		sc.close();
		
		
	}
}


class collection{
	ArrayList<Integer> collectionList;
	
	public collection(String s){
		collectionList = new ArrayList<>();
		String[] ss = s.split(" ");
		for(int i = 0; i < ss.length; i++)
			collectionList.add(Integer.parseInt(ss[i]));
	}
	
}