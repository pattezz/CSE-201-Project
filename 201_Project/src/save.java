import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class save {
	private Node head;
	private int size;
	
	
	public save(){
		head= null;
		size=0;
	}
	
	public boolean add(Alignable newEntry) {
		Node newNode = new Node(newEntry);
		 if(head==null){// when list is empty 
			 head= newNode;
			 size++;
			 return true; 
		 }
		 else if (size==1) {
			 head.next= newNode;
			 size++;
			 return true;
		 }
		 else {
			 Node temp= head;
			 head= newNode;
			 head.next= temp;
			 size++;
			 return true;
		 }
	}
	public void export(Alignable a) {
		try {
			PrintWriter out = new PrintWriter("output.txt");
			out.println(a.alignedSequence);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
		
	class Node {
		private Alignable data;
		Node next;	
		Node(Alignable newEntry) {
			this.data = newEntry;
		}
}
}

