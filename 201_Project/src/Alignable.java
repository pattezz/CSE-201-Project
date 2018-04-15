
	public class Alignable {
		public String alignableString;
		public Alignable(String alignable) {
			this.alignableString=alignable;
		}
		public static void align(String string1, String string2) {
			 align(string1, string2, -2,1,-1);
		}
		public static void align(String string11,String string2, int gap1, int match1, int mismatch1) {
			int gap=gap1, match= match1, mismatch=  mismatch1;
			int scorevert, scorehor, scorediag;
			String string1= string11;
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
			
			for (int i = 0; i < scoreMatrix.length; i++) {
			    for (int j = 0; j < scoreMatrix[i].length; j++) {
			        System.out.print(scoreMatrix[i][j] + "  ");
			    }
			    System.out.println();
			    }
			for (int i = 0; i < directionMatrix.length; i++) {
			    for (int j = 0; j < directionMatrix[i].length; j++) {
			        System.out.print(directionMatrix[i][j] + "  ");
			    }
			    System.out.println();
	}
			int maxScore =-1000;
			int maxI=0,maxJ=0;
			for(int i=0; i<string1.length(); i++) {
				if(scoreMatrix[i][string2.length()-1]>maxScore) {
					maxI=i; maxJ=string2.length()-1;
				}
		}
			for(int j=0; j<string2.length(); j++) {
				if(scoreMatrix[string1.length()-1][j]>maxScore) {
					maxI=string1.length()-1; maxJ=j;
				}
		}
	 
		
			//int i=string1.length()-1; int j= string2.length()-1;
			char a1=' ';
			char a2=' ';
			while(maxI>=1&& maxJ>=1) {
				if(directionMatrix[maxI][maxJ]=='d') {
					a1= string1.charAt(maxI-1);
					a2= string2.charAt(maxJ-1);
					maxI--;
					maxJ--;
					}
				else if(directionMatrix[maxI][maxJ]=='h') {
					a1='-';
					a2= string2.charAt(maxJ-1);
					maxJ--;
					}
				else if(directionMatrix[maxI][maxJ]=='h') {
					a1=string1.charAt(maxI-1);
					a2=  '-';
					maxI--;
					}
				output1=a1+output1;
				output2=a2+output2;
			}
			
			System.out.println(output1+"\n"+output2);
			//return output1+"\n"+output2;
	}
}
