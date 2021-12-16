
class test2 {  
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

	public test2(){
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
	
	public static void main(String[]args) {
		String display[]= {
				"A .-","B -...","C -.-.","D -..","E .","F ..-.","G --.","H ....","I ..","J .---","K -.-","L .-..","M --","N -.",
				"O ---","P .--.","Q --.-","R .-.","S ...","T -","U ..-","V ...-","W .--","X -..-","Y -.--","Z --..",
				". .-.-.-",", --..--",": ---...","\" .-..-.","' .----.","! -.-.--","? ..--..",
				"@ .--.-.","- -....-","; -.-.-.","( -.--.",") -.--.-","= -...-",
				"1 .----","2 ..---","3 ...--","4 ....-","5 .....","6 -....","7 --...","8 ---..","9 ----.","0 -----"
				};
		String morse[]= {".-", "-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.",
				"---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--..",
				".-.-.-","--..--", "---...", ".-..-.", ".----.", "-.-.--", "..--.."	, ".--.-.", "-....-", "-.-.-."	, "-.--.", "-.--.-","-...-",
				".----","..---","...--","....-",".....","-....","--...","---..","----.","-----"
				};
		
		test2 tree=new test2();
		for(int i=0; i<display.length; i++) {
			tree.add(display[i], morse[i]);
		}
		tree.inorder();
	}
}
