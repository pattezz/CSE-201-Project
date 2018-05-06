
public class AlignSave {
private String alignable;
private String seq1;
private String seq2;



public AlignSave(String alignable, String seq1, String seq2) {
	this.alignable = alignable;
	this.seq1 = seq1;
	this.seq2 = seq2;
}
public String getAlignable() {
	return alignable;
}
public void setAlignable(String alignable) {
	this.alignable = alignable;
}
public String getSeq1() {
	return seq1;
}
public void setSeq1(String seq1) {
	this.seq1 = seq1;
}
public String getSeq2() {
	return seq2;
}
public void setSeq2(String seq2) {
	this.seq2 = seq2;
}

}
