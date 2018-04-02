
public class Alignable {
	public String alignableString;
	public Alignable(String alignable) {
		this.alignableString=alignable;
	}
	
	public String align(String string2) {
		int gap=-2, match=1, mismatch=-1;
		int scorevert, scorehor, scorediag;
		String string1= alignableString;
		String output1 = "", output2="";
		int[][] scoreMatrix= new int[string1.length()][string2.length()];
		char[][] directionMatrix = new char[string1.length()][string2.length()];
		for(int i =0; i<string1.length();i++) {
			scoreMatrix[i][0]=0;
		}
		for(int i =0; i<string2.length();i++) {
			scoreMatrix[0][i]=0;
		}
		for(int i = 1; i<string1.length(); i++) {
			for(int j = 1; j<string2.length(); j++) {
				scorediag = scoreMatrix[i - 1][j - 1] +
		                (string1.charAt(i-1) == string2.charAt(j-1) ? match : mismatch);
		         scorehor = scoreMatrix[i][j-1] + gap;
		         scorevert = scoreMatrix[i-1][j] + gap;
		         scoreMatrix[i][j]= Math.max(scorediag, Math.max(scorehor, scorevert));
		         if(scorediag>=scorehor&& scorediag>= scorevert) directionMatrix[i][j]= 'd';
		         if(scorehor>=scorediag&& scorehor>= scorevert) directionMatrix[i][j]= 'h';
		         if(scorevert>=scorehor&& scorevert>= scorediag) directionMatrix[i][j]= 'd';
			}
		}
		
//		for (int i = 0; i < scoreMatrix.length; i++) {
//		    for (int j = 0; j < scoreMatrix[i].length; j++) {
//		        System.out.print(scoreMatrix[i][j] + "  ");
//		    }
//		    System.out.println();
//		    }
//		for (int i = 0; i < directionMatrix.length; i++) {
//		    for (int j = 0; j < directionMatrix[i].length; j++) {
//		        System.out.print(directionMatrix[i][j] + "  ");
//		    }
//		    System.out.println();
//}
		int maxScore =0;
		int maxI=0,maxJ=0;
		for(int i = 1; i<string1.length(); i++) {
			for(int j = 1; j<string2.length(); j++) {
			if (scoreMatrix[i][j] > maxScore) {
			    maxScore = scoreMatrix[i][j];
			    maxI =i;
			    maxJ=j;
			}
	    }
	}
		for(int i=0; i< Math.max(string1.length(), string2.length()); i++) {
			if(directionMatrix[maxI][maxJ]=='d') {
				output1= output1+string1.charAt(i);
				output2= output2+string2.charAt(i);
				}
			if(directionMatrix[maxI][maxJ]=='h') {
				output1= output1+"-";
				output2=  output2+string2.charAt(i);
				}
			if(directionMatrix[maxI][maxJ]=='h') {
				output1= output1+string1.charAt(i);
				output2=  output2+"-";
				}
		}
		//System.out.println(output1+"\n"+output2);
		return output1+"\n"+output2;
}
	
}