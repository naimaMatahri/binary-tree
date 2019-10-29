// binary tree class
//to implement the adding, the depth, the longest word, the repeated words,
// how many words, search for specific words... 
public class BinaryTree {

	public Node root;
	private int count;

	// method to add words into the tree
	public void add(String data) {
		Node n = new Node(data);

		n.setData(data);

		if (root == null) {
			root = n;

			count = 1;
			return;
		} else {

			recursiveAdd(root, data);
			count++;

		}
		return;
	}

	// recursive method to add
	public Node recursiveAdd(Node node, String data) {

		if (node == null) {
			return new Node(data);
		}
		// add to the left or to the right depends on the alphabetical order
		if (data.compareTo(node.getData()) < 0) {
			node.setlChild(recursiveAdd(node.getlChild(), data));
		} else if (data.compareTo(node.getData()) > 0) {
			node.setrChild(recursiveAdd(node.getrChild(), data));
		} else {
			// id the word already exists increment its count
			node.increment();
			return node;
		}

		return node;
	}

	// search method to find a specific node
	public Node search(String data) {

		if (root != null) {

			return recSearch(root, data);

		} else {
			return null;
		}

	}

	// recursive search method to find a specific node based on the search
	private Node recSearch(Node root, String data) {

		if (root == null) {
			return null;
		}

		if (root.getData().equals(data)) {

			return root;
		}

		else {
			Node rtn = null;
			rtn = recSearch(root.getlChild(), data);

			if (rtn == null) {
				rtn = recSearch(root.getrChild(), data);

			}

			return rtn;

		}
	}

	// return the length of the tree
	public int length() {
		return count;
	}

	// find the max depth
	public int maxDepth() {
		return (maxDepth(root));
	}

	// method to find how many nodes the tree is deep
	private int maxDepth(Node node) {
		if (node == null) {
			return (0);
		} else {
			int lDepth = maxDepth(node.getlChild());
			int rDepth = maxDepth(node.getrChild());

			// use the larger + 1
			return (Math.max(lDepth, rDepth) + 1);
		}

	}

	public void deepest() {
		int h = maxDepth(root);
		findDeepestNode(root, h, 0);

	}

	// method to find the deepest node in the tree
	private void findDeepestNode(Node root, int h, int depth) {
		if (root == null)
			return;
		if (root.getlChild() == null && root.getrChild() == null) {
			if (depth + 1 == h)
				System.out.println("deepest node    :" + root.getData());
		}

		findDeepestNode(root.getlChild(), h, depth + 1);
		findDeepestNode(root.getrChild(), h, depth + 1);
	}

	// method to count how many words are in the tree

	public int count() {
		if (root != null) {
			return recursiveCount(root);
		}

		return 0;
	}

	// recursive method to return count of tree nodes

	private int recursiveCount(Node node) {
		count = 1;

		if (node.getlChild() != null) {
			count += recursiveCount(node.getlChild());
		}

		if (node.getrChild() != null) {
			count += recursiveCount(node.getrChild());
		}

		return count;
	}
	//

	// method to get the number of words that are repeated more than 20 times

	public String[] minOccurrence(int occurrence) {
		Node[] arrayTree = arrayedTree();
		String[] results = new String[0];

		for (int i = 0; i < arrayTree.length; i++) {
			Node node = arrayTree[i];
			if (node.getOccurency() >= occurrence) {
				String[] tempArray = new String[results.length + 1];
				tempArray[results.length] = node.getData();
				for (int j = 0; j < results.length; j++) {
					tempArray[j] = results[j];
				}

				results = tempArray;
			}
		}

		return results;
	}

	// method to get the most frequently appearing word

	public String mostFrequent() {
		Node[] arrayTree = arrayedTree();
		Node toReturn = arrayTree[0];

		for (int i = 1; i < arrayTree.length; i++) {
			Node node = arrayTree[i];
			if (node.getOccurency() > toReturn.getOccurency()) {
				toReturn = node;
			}
		}

		return toReturn.getData();
	}

	// method to get the longest word

	public String longestWord() {
		Node[] arrayTree = arrayedTree();
		Node toReturn = arrayTree[0];

		for (int i = 1; i < arrayTree.length; i++) {
			Node node = arrayTree[i];
			if (node.getData().length() > toReturn.getData().length()) {
				toReturn = node;
			}
		}

		return toReturn.getData();
	}

	// method to return the converted tree to array

	private Node[] arrayedTree() {
		Node[] tempArray = new Node[this.count];
		tempArray[0] = root;
		// put new items into array ahead by 1
		int start = 1;
		// check for child
		for (int i = 0; i < this.count; i++) {
			Node node = tempArray[i];
			if (node.getlChild() != null) {
				// get the new node place
				tempArray[start] = node.getlChild();
				start++;
			}

			if (node.getrChild() != null) {
				tempArray[start] = node.getrChild();
				start++;
			}
		}

		return tempArray;
	}

}
