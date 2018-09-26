package attempt1;

import java.util.ArrayList;

public class goodClass {
	public ArrayList<Integer> inorderTraversal(TreeNode A) {
		
        my_stack s = new my_stack();
        ArrayList<Integer> trav = new ArrayList<>();
        
        TreeNode current = A;
        
        do {        	
        	while(current != null){
        		s.push(current);
        		current = current.left;       		
        	}
        	current = s.pop();
        	trav.add(current.val);
        	current = current.right;
        } while(s.size() != 0);
		
		return trav;
    }
}

class my_stack {
    public ArrayList<TreeNode> nodeList = new ArrayList<>();
    
    public void push (TreeNode t){
        nodeList.add(t);
    }
    
    public TreeNode pop (){
        TreeNode t = nodeList.get(nodeList.size() - 1);
        nodeList.remove(nodeList.size() - 1);
        return t;
    }
    
    public int size (){
    	return nodeList.size();
    }
}


class TreeNode {
  	int val;
  	TreeNode left;
   	TreeNode right;
	TreeNode(int x) {
    	val = x;
    	left=null;
    	right=null;
   	}
 }