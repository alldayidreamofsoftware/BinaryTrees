
public class Driver {
	
	static Integer[] inOrderData = { 4,8,9,10,12};
	static Integer[] preOrderData = {8,4,10,9,12};
	
	public static void main(String[] args) {
		
		System.out.println("length of inOrderData array"+inOrderData.length);
		Tree tree = new Tree();
		
		tree.setInorderTraversalData(inOrderData);
		tree.setPreorderTraversalData(preOrderData);
		tree=tree.buildTreeFromInorderPreorderData();
	    tree.printInorderTraversal(tree);
	    
	}
}

