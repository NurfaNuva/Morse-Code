
public class A173823_MorseTree <E extends Comparable<E>>{
	int check;
	private Node root;
	private class Node<E>{

		private Node left;
		private Node right;
		private E value;

		private Node(Node left, Node right, E value){
			this.left = left;
			this.right = right;
			this.value = value;
		}
	}

	public A173823_MorseTree(){
		root = new Node(null, null, null);
	}

	public void add(String display, String code){
		Node current = root;
		for (int i=0; i<code.length(); i++){
			if (code.substring(i, i+1).equals(".")){
				if (current.left == null){
					current.left = new Node(null, null, null);
				}
				current = current.left;
			}
			else if (code.substring(i, i+1).equals("-")){
				if (current.right == null){
					current.right = new Node(null, null, null);
				}
				current = current.right;
			}
		}
		current.value = display;
	}
	
	void inorder() {	//method to call inOrderRec()
		inorderRec(root);
	}
	
	void inorderRec(Node root) {	//function to get inOrder form
		if(root==null) {
			return;}
		
		if(root!=null) {
			inorderRec(root.left);
			if(root.value!=null) {
				System.out.print(root.value+"      \t");
				check++;
				if(check%5==0&&check>0) {
					System.out.println();}
			}
			inorderRec(root.right);
		}
	}
}
