
import java.util.ArrayList;

public class Solution {
	
	public static void main(String[] args) {
		
		ArrayList<Integer> arrayList = new ArrayList<Integer>();
		
		arrayList.add(0,3);
		arrayList.add(1,4);
		arrayList.add(2,2);
		
		Tree tree = new Tree();
		
		for(int i = 0; i < arrayList.size() ; i++) {
			tree.insert(arrayList.get(i));
		}
		tree.postOrderTraversal();
		tree.preOrderTraversal();
		tree.inOrderTraversal();
		if(tree.find(2) == true) {
			System.out.println("Found");
		}
		if(tree.find(10) == false) {
			System.out.println("Not found");
		}
		
	}
	
	static class Tree {
		
		private Node root;
		
		void postOrderTraversal() {
			postOrderTraversal(root);
		}
		
		void postOrderTraversal (Node root) {
			if(root == null) {
				return;
			}
			
			postOrderTraversal(root.left);
			postOrderTraversal(root.right);
			System.out.println(root.value);
			
		}
		void preOrderTraversal() {
			preOrderTraversal(root);
		}
		
		void preOrderTraversal (Node root) {
			if(root == null) {
				return;
			}
			System.out.println(root.value);
			preOrderTraversal(root.left);
			preOrderTraversal(root.right);
			
		}
		
		void inOrderTraversal () {
			
			inOrderTraversal(root);
			
		}
		public boolean find(Integer val) {
			return find(val,root);
		}
		private boolean find(Integer val,Node root) {
			
			if(root == null) {
				return false;
			}
			else if(root.value == val) {
				return true;
			}
			else if(val < root.value) {
				return find(val,root.left);
			}
			else {
				return find(val,root.right);
			}
		}
		private void inOrderTraversal(Node root) {
			
			if(root == null) {
				return;
			}
			inOrderTraversal(root.left);
			System.out.println(root.value);
			inOrderTraversal(root.right);
			
		}
		void insert(Integer val) {
			
			root = insert(val,root);
		}
		private Node insert (Integer val, Node root) {
			
			if(root == null) {
				root = new Node(val);
				return root;
			}
			if(val <= root.value) {
				root.left = insert(val,root.left);
				
			}
			else {
				root.right = insert(val,root.right);
			}
			return root;
			
		}		
			
		static class Node {
			Integer value;
			Node left;
			Node right;
			
			public Node (Integer val) {
				value = val;
				left = null;
				right = null;
			}
		}
		
	
		
	}
	
}
