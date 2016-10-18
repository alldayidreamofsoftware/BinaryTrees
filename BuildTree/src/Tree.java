
public class Tree {
	private int element;
	private Tree left;
	private Tree right;
	private Integer[] inOrderData;
	private Integer[] preOrderData;
	private int preOrderIndex;
	
	public void setInorderTraversalData(Integer[] orderData) {
		inOrderData = new Integer[orderData.length];
		for(int i=0; i<orderData.length;i++) {
			inOrderData[i]=orderData[i];
			
		}
		
	}
	public void setPreorderTraversalData(Integer[] orderData) {
		preOrderData = new Integer[orderData.length];
		for(int i=0; i<orderData.length;i++) {
			preOrderData[i]=orderData[i];
			
		}
		
	}
	public Tree buildTreeFromInorderPreorderData() {
		
		Tree root=null;
		int startIndex = 0;
		int endIndex = inOrderData.length-1;
		preOrderIndex = 0;
		
		
		root=buildTree(startIndex,endIndex);
		return root;
	}
	public void printInorderTraversal(Tree root) {
		
		if(root == null)
			return;
		
		printInorderTraversal(root.left);
		System.out.println(root.element);
		
		printInorderTraversal(root.right);
		

		
	}
	public Tree buildTree(int startIndex , int endIndex) {
		
		Tree tree=null;
		int index;
		
		
		if(startIndex > endIndex)
			return null;
		
		tree = new Tree();
		tree.element = preOrderData[preOrderIndex];
		tree.left=null;
		tree.right=null;
		preOrderIndex ++;
		
		if(startIndex == endIndex)
			return tree;
		
				
		index = lookElementInorderData(tree.element);
		if(index == -1) {
			return null;
		}
		tree.left = buildTree(startIndex,index-1);
		tree.right = buildTree(index+1,endIndex);
		return tree;
				
	}
	private int lookElementInorderData(int element) {
		
		for(int i=0; i<inOrderData.length;i++) {
			if(element == inOrderData[i]) {
				return i;
			}
		}
		return -1;
		
	}
	
	
}
