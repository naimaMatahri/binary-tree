


public class Node {

	private String data;
	private Node lChild;
	private Node rChild;
    private int occurency;
	
	
	public Node( String data) {
		lChild = rChild = null;
		this.data = data;
		occurency =1;
	
	}

	public int getOccurency() {
		return occurency;
	}

	public void setOccurency(int occurency) {
		
		this.occurency = occurency; 
	}
	 public void increment (){
	        occurency++;
	    }
	
	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}


	public Node getlChild() {
		return lChild;
	}

	public void setlChild(Node lChild) {
		this.lChild = lChild;
	}

	public Node getrChild() {
		return rChild;
	}

	public void setrChild(Node rChild) {
		this.rChild = rChild;
	}

	public String toString() {

		return data + " " ;

	}
}