
import javax.management.InvalidApplicationException;

public class diffMatrix {

	int[][] BLOSUM80Matrix = {
			{ 5, -2, -2, -2, -1, -1, -1, 0, -2, -2, -2, -1, -1, -3, -1, 1, 0,
					-3, -2, 0, -2, -2, -1, -1, -6 },
			{ -2, 6, -1, -2, -4, 1, -1, -3, 0, -3, -3, 2, -2, -4, -2, -1, -1,
					-4, -3, -3, -1, -3, 0, -1, -6 },
			{ -2, -1, 6, 1, -3, 0, -1, -1, 0, -4, -4, 0, -3, -4, -3, 0, 0, -4,
					-3, -4, 5, -4, 0, -1, -6 },
			{ -2, -2, 1, 6, -4, -1, 1, -2, -2, -4, -5, -1, -4, -4, -2, -1, -1,
					-6, -4, -4, 5, -5, 1, -1, -6 },
			{ -1, -4, -3, -4, 9, -4, -5, -4, -4, -2, -2, -4, -2, -3, -4, -2,
					-1, -3, -3, -1, -4, -2, -4, -1, -6 },
			{ -1, 1, 0, -1, -4, 6, 2, -2, 1, -3, -3, 1, 0, -4, -2, 0, -1, -3,
					-2, -3, 0, -3, 4, -1, -6 },
			{ -1, -1, -1, 1, -5, 2, 6, -3, 0, -4, -4, 1, -2, -4, -2, 0, -1, -4,
					-3, -3, 1, -4, 5, -1, -6 },
			{ 0, -3, -1, -2, -4, -2, -3, 6, -3, -5, -4, -2, -4, -4, -3, -1, -2,
					-4, -4, -4, -1, -5, -3, -1, -6 },
			{ -2, 0, 0, -2, -4, 1, 0, -3, 8, -4, -3, -1, -2, -2, -3, -1, -2,
					-3, 2, -4, -1, -4, 0, -1, -6 },
			{ -2, -3, -4, -4, -2, -3, -4, -5, -4, 5, 1, -3, 1, -1, -4, -3, -1,
					-3, -2, 3, -4, 3, -4, -1, -6 },
			{ -2, -3, -4, -5, -2, -3, -4, -4, -3, 1, 4, -3, 2, 0, -3, -3, -2,
					-2, -2, 1, -4, 3, -3, -1, -6 },
			{ -1, 2, 0, -1, -4, 1, 1, -2, -1, -3, -3, 5, -2, -4, -1, -1, -1,
					-4, -3, -3, -1, -3, 1, -1, -6 },
			{ -1, -2, -3, -4, -2, 0, -2, -4, -2, 1, 2, -2, 6, 0, -3, -2, -1,
					-2, -2, 1, -3, 2, -1, -1, -6 },
			{ -3, -4, -4, -4, -3, -4, -4, -4, -2, -1, 0, -4, 0, 6, -4, -3, -2,
					0, 3, -1, -4, 0, -4, -1, -6 },
			{ -1, -2, -3, -2, -4, -2, -2, -3, -3, -4, -3, -1, -3, -4, 8, -1,
					-2, -5, -4, -3, -2, -4, -2, -1, -6 },
			{ 1, -1, 0, -1, -2, 0, 0, -1, -1, -3, -3, -1, -2, -3, -1, 5, 1, -4,
					-2, -2, 0, -3, 0, -1, -6 },
			{ 0, -1, 0, -1, -1, -1, -1, -2, -2, -1, -2, -1, -1, -2, -2, 1, 5,
					-4, -2, 0, -1, -1, -1, -1, -6 },
			{ -3, -4, -4, -6, -3, -3, -4, -4, -3, -3, -2, -4, -2, 0, -5, -4,
					-4, 11, 2, -3, -5, -3, -3, -1, -6 },
			{ -2, -3, -3, -4, -3, -2, -3, -4, 2, -2, -2, -3, -2, 3, -4, -2, -2,
					2, 7, -2, -3, -2, -3, -1, -6 },
			{ 0, -3, -4, -4, -1, -3, -3, -4, -4, 3, 1, -3, 1, -1, -3, -2, 0,
					-3, -2, 4, -4, 2, -3, -1, -6 },
			{ -2, -1, 5, 5, -4, 0, 1, -1, -1, -4, -4, -1, -3, -4, -2, 0, -1,
					-5, -3, -4, 5, -4, 0, -1, -6 },
			{ -2, -3, -4, -5, -2, -3, -4, -5, -4, 3, 3, -3, 2, 0, -4, -3, -1,
					-3, -2, 2, -4, 3, -3, -1, -6 },
			{ -1, 0, 0, 1, -4, 4, 5, -3, 0, -4, -3, 1, -1, -4, -2, 0, -1, -3,
					-3, -3, 0, -3, 5, -1, -6 },
			{ -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1,
					-1, -1, -1, -1, -1, -1, -1, -1, -6 },
			{ -6, -6, -6, -6, -6, -6, -6, -6, -6, -6, -6, -6, -6, -6, -6, -6,
					-6, -6, -6, -6, -6, -6, -6, -6, 1 } };
	
	int [][] Blosum62Matrix ={
		      /*A  B  C  D  E  F  G  H  I  J  K  L  M  N  O  P  Q  R  S  T  U  V  W  X  Y  Z  *  -*/
			/*A*/ { 4,-2, 0,-2,-1,-2, 0,-2,-1,-4,-1,-1,-1,-2,-4,-1,-1,-1, 1, 0, 0, 0,-3, 0,-2,-1,-4,-4},
			/*B*/ {-2, 4,-3, 4, 1,-3,-1, 0,-3,-4, 0,-4,-3, 3,-4,-2, 0,-1, 0,-1,-3,-3,-4,-1,-3, 1,-4,-4},
			/*C*/ { 0,-3, 9,-3,-4,-2,-3,-3,-1,-4,-3,-1,-1,-3,-4,-3,-3,-3,-1,-1, 9,-1,-2,-2,-2,-3,-4,-4},
			/*D*/ {-2, 4,-3, 6, 2,-3,-1,-1,-3,-4,-1,-4,-3, 1,-4,-1, 0,-2, 0,-1,-3,-3,-4,-1,-3, 1,-4,-4},
			/*E*/ {-1, 1,-4, 2, 5,-3,-2, 0,-3,-4, 1,-3,-2, 0,-4,-1, 2, 0, 0,-1,-4,-2,-3,-1,-2, 4,-4,-4},
			/*F*/ {-2,-3,-2,-3,-3, 6,-3,-1, 0,-4,-3, 0, 0,-3,-4,-4,-3,-3,-2,-2,-2,-1, 1,-1, 3,-3,-4,-4},
			/*G*/ { 0,-1,-3,-1,-2,-3, 6,-2,-4,-4,-2,-4,-3, 0,-4,-2,-2,-2, 0,-2,-3,-3,-2,-1,-3,-2,-4,-4},
			/*H*/ {-2, 0,-3,-1, 0,-1,-2, 8,-3,-4,-1,-3,-2, 1,-4,-2, 0, 0,-1,-2,-3,-3,-2,-1, 2, 0,-4,-4},
			/*I*/ {-1,-3,-1,-3,-3, 0,-4,-3, 4,-4,-3, 2, 1,-3,-4,-3,-3,-3,-2,-1,-1, 3,-3,-1,-1,-3,-4,-4},
			/*J*/ {-4,-4,-4,-4,-4,-4,-4,-4,-4, 1,-4,-4,-4,-4,-4,-4,-4,-4,-4,-4,-4,-4,-4,-4,-4,-4,-4,-4},
			/*K*/ {-1, 0,-3,-1, 1,-3,-2,-1,-3,-4, 5,-2,-1, 0,-4,-1, 1, 2, 0,-1,-3,-2,-3,-1,-2, 1,-4,-4},
			/*L*/ {-1,-4,-1,-4,-3, 0,-4,-3, 2,-4,-2, 4, 2,-3,-4,-3,-2,-2,-2,-1,-1, 1,-2,-1,-1,-3,-4,-4},
			/*M*/ {-1,-3,-1,-3,-2, 0,-3,-2, 1,-4,-1, 2, 5,-2,-4,-2, 0,-1,-1,-1,-1, 1,-1,-1,-1,-1,-4,-4},
			/*N*/ {-2, 3,-3, 1, 0,-3, 0, 1,-3,-4, 0,-3,-2, 6,-4,-2, 0, 0, 1, 0,-3,-3,-4,-1,-2, 0,-4,-4},
			/*O*/ {-4,-4,-4,-4,-4,-4,-4,-4,-4,-4,-4,-4,-4,-4, 1,-4,-4,-4,-4,-4,-4,-4,-4,-4,-4,-4,-4,-4},
			/*P*/ {-1,-2,-3,-1,-1,-4,-2,-2,-3,-4,-1,-3,-2,-2,-4, 7,-1,-2,-1,-1,-3,-2,-4,-2,-3,-1,-4,-4},
			/*Q*/ {-1, 0,-3, 0, 2,-3,-2, 0,-3,-4, 1,-2, 0, 0,-4,-1, 5, 1, 0,-1,-3,-2,-2,-1,-1, 3,-4,-4},
			/*R*/ {-1,-1,-3,-2, 0,-3,-2, 0,-3,-4, 2,-2,-1, 0,-4,-2, 1, 5,-1,-1,-3,-3,-3,-1,-2, 0,-4,-4},
			/*S*/ { 1, 0,-1, 0, 0,-2, 0,-1,-2,-4, 0,-2,-1, 1,-4,-1, 0,-1, 4, 1,-1,-2,-3, 0,-2, 0,-4,-4},
			/*T*/ { 0,-1,-1,-1,-1,-2,-2,-2,-1,-4,-1,-1,-1, 0,-4,-1,-1,-1, 1, 5,-1, 0,-2, 0,-2,-1,-4,-4},
			/*U*/ { 0,-3, 9,-3,-4,-2,-3,-3,-1,-4,-3,-1,-1,-3,-4,-3,-3,-3,-1,-1, 9,-1,-2,-2,-2,-3,-4,-4},
			/*V*/ { 0,-3,-1,-3,-2,-1,-3,-3, 3,-4,-2, 1, 1,-3,-4,-2,-2,-3,-2, 0,-1, 4,-3,-1,-1,-2,-4,-4},
			/*W*/ {-3,-4,-2,-4,-3, 1,-2,-2,-3,-4,-3,-2,-1,-4,-4,-4,-2,-3,-3,-2,-2,-3,11,-2, 2,-3,-4,-4},
			/*X*/ { 0,-1,-2,-1,-1,-1,-1,-1,-1,-4,-1,-1,-1,-1,-4,-2,-1,-1, 0, 0,-2,-1,-2,-1,-1,-1,-4,-4},
			/*Y*/ {-2,-3,-2,-3,-2, 3,-3, 2,-1,-4,-2,-1,-1,-2,-4,-3,-1,-2,-2,-2,-2,-1, 2,-1, 7,-2,-4,-4},
			/*Z*/ {-1, 1,-3, 1, 4,-3,-2, 0,-3,-4, 1,-3,-1, 0,-4,-1, 3, 0, 0,-1,-3,-2,-3,-1,-2, 4,-4,-4},
			/***/ {-4,-4,-4,-4,-4,-4,-4,-4,-4,-4,-4,-4,-4,-4,-4,-4,-4,-4,-4,-4,-4,-4,-4,-4,-4,-4, 1,-4},
			/*-*/ {-4,-4,-4,-4,-4,-4,-4,-4,-4,-4,-4,-4,-4,-4,-4,-4,-4,-4,-4,-4,-4,-4,-4,-4,-4,-4,-4, 1},
			        };

			    


	public diffMatrix() throws InvalidApplicationException{
		
	}
	  public String calculate80(String sequence1, String sequence2) throws InvalidApplicationException{
		  int result;
		  String result1="";
		  for(int i =0; i< sequence1.length();i++){
			 result = BLOSUM80Matrix[getIndex(sequence1.charAt(i))][getIndex(sequence2.charAt(i))];
			 result1 += result;
		  }
		return  result1;
    	
    }
	  public String calculate62(String sequence1, String sequence2) throws InvalidApplicationException{
		  int result;
		  String result1="";
		  for(int i =0; i< sequence1.length();i++){
			 result = Blosum62Matrix[get(sequence1.charAt(i))][get(sequence2.charAt(i))];
			 result1 += result;
		  }
		return  result1;
    	
    }

	public static int getIndex(char a) throws InvalidApplicationException {

		// check for upper and lowercase characters
		switch ((String.valueOf(a)).toUpperCase().charAt(0)) {
		case 'A':
			return 0;
		case 'R':
			return 1;
		case 'N':
			return 2;
		case 'D':
			return 3;
		case 'C':
			return 4;
		case 'Q':
			return 5;
		case 'E':
			return 6;
		case 'G':
			return 7;
		case 'H':
			return 8;
		case 'I':
			return 9;
		case 'L':
			return 10;
		case 'K':
			return 11;
		case 'M':
			return 12;
		case 'F':
			return 13;
		case 'P':
			return 14;
		case 'S':
			return 15;
		case 'T':
			return 16;
		case 'W':
			return 17;
		case 'Y':
			return 18;
		case 'V':
			return 19;
		case 'B':
			return 20;
		case 'J':
			return 21;
		case 'Z':
			return 22;
		case 'X':
			return 23;
		case '*':
			return 24;

		default:
			throw new InvalidApplicationException(a);
		}
	}

	   public int get(char c) throws InvalidApplicationException {
	    switch ((String.valueOf(c)).toUpperCase().charAt(0)) {
	      case 'A': return 0 ;
	      case 'B': return 1 ;
	      case 'C': return 2 ;
	      case 'D': return 3 ;
	      case 'E': return 4 ;
	      case 'F': return 5 ;
	      case 'G': return 6 ;
	      case 'H': return 7 ;
	      case 'I': return 8 ;
	      case 'J': return 9 ;
	      case 'K': return 10;
	      case 'L': return 11;
	      case 'M': return 12;
	      case 'N': return 13;
	      case 'O': return 14;
	      case 'P': return 15;
	      case 'Q': return 16;
	      case 'R': return 17;
	      case 'S': return 18;
	      case 'T': return 19;
	      case 'U': return 20;
	      case 'V': return 21;
	      case 'W': return 22;
	      case 'X': return 23;
	      case 'Y': return 24;
	      case 'Z': return 25;
	      default :
	    	  throw new InvalidApplicationException(c);
	    }
	  }
}

   
