import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class save {
	private Node head;
	private int size;
	
	
	public save(){
		head= null;
		size=0;
	}
	
	public boolean add(AlignSave newEntry) {
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
	public void export(AlignSave a) {
		try {
			PrintWriter out = new PrintWriter("output.txt");
			out.println(a.getAlignable());
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		}
	public AlignSave Search(String s) {
		if(size==0)return null;
		Node temp = this.head;
		if(size==1)return temp.data;
		while(temp.next!= null) {
			if(s.equals(temp.data.getSeq1())|| s.equals(temp.data.getSeq2())) return temp.data;
			temp = temp.next;
		}
		return null;
	}
		

}

