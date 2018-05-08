import java.util.ArrayList;

public class MultiSeq {
	
	public ArrayList<String> list = new ArrayList<String>();
	
	public String align() {
		if (list.size() == 3)
			return multiSeqAlign(list.get(0), list.get(1), list.get(2));
		if (list.size() == 4)
			return multiSeqAlign(list.get(0), list.get(1), list.get(2), list.get(3));
		if (list.size() == 5)
			return multiSeqAlign(list.get(0), list.get(1), list.get(2), list.get(3), list.get(4));
		else
			return "You must add 3-5 strands before aligning.";
	}

	public String multiSeqAlign(String str1, String str2, String str3) {
		Alignable al = new Alignable(); 		
		String[] alArray = {str1, str2, str3};
		
		
		int n = alArray.length;
        for (int i = 0; i < n-1; i++)
            for (int j = 0; j < n-i-1; j++)
                if (alArray[j].length() < alArray[j+1].length())
                {
                    // swap temp and alArray[i]
                    String temp = alArray[j];
                    alArray[j] = alArray[j+1];
                    alArray[j+1] = temp;
                }
        
        System.out.println(alArray[0] + " " + alArray[1] + " " + alArray[2]);
		
		String alFirst = al.align(alArray[0], alArray[1]);
		String result = alFirst;
		
		alFirst = alFirst.substring(0, (alFirst.length()/2) + 1);
		
		String alLast = al.align(alFirst, alArray[2]);
		
		System.out.println("alLast: \n" + alLast + "\n");
		
		alLast = alLast.substring((alLast.length() / 2 + 1), alLast.length());
		
		result += "\n" + alLast; 
		
		return result;
	}
	
	public String multiSeqAlign(String str1, String str2, String str3, String str4) {
		Alignable al = new Alignable(); 		
		String[] alArray = {str1, str2, str3, str4};
		
		
		int n = alArray.length;
        for (int i = 0; i < n-1; i++)
            for (int j = 0; j < n-i-1; j++)
                if (alArray[j].length() <  alArray[j+1].length())
                {
                    // swap temp and alArray[i]
                    String temp = alArray[j];
                    alArray[j] = alArray[j+1];
                    alArray[j+1] = temp;
                }
	
		System.out.println(alArray[0] + " " + alArray[1] + " " + alArray[2] + " " + alArray[3]);

		String alFirst = al.align(alArray[0], alArray[1]);
		String result = alFirst;
		
		alFirst = alFirst.substring(0, (alFirst.length()/2) + 1);
		
		String alSeccond = al.align(alFirst, alArray[2]);
//	   System.out.println("alSeccond: \n" + alSeccond + "\n");
		alSeccond = alSeccond.substring((alSeccond.length() / 2 + 1), alSeccond.length());
		
		String alLast = al.align(alFirst, alArray[3]);
		alLast = alLast.substring((alLast.length() / 2 + 1), alLast.length());
		
		result += "\n" + alSeccond + "\n" + alLast; 
		
		return result;
	}
	
	public String multiSeqAlign(String str1, String str2, String str3, String str4, String str5) {
		Alignable al = new Alignable(); 		
		String[] alArray = {str1, str2, str3, str4, str5};
		
		
		int n = alArray.length;
        for (int i = 0; i < n-1; i++)
            for (int j = 0; j < n-i-1; j++)
                if (alArray[j].length() < alArray[j+1].length())
                {
                    // swap temp and alArray[i]
                    String temp = alArray[j];
                    alArray[j] = alArray[j+1];
                    alArray[j+1] = temp;
                }
	
		System.out.println(alArray[0] + " " + alArray[1] + " " + alArray[2] + " " + alArray[3]);

		String alFirst = al.align(alArray[0], alArray[1]);
		String result = alFirst;
		
		alFirst = alFirst.substring(0, (alFirst.length()/2) + 1);
//		
//		String alSeccond = al.align(alFirst, alArray[2]);
////	   System.out.println("alSeccond: \n" + alSeccond + "\n");
//		alSeccond = alSeccond.substring((alSeccond.length() / 2 + 1), alSeccond.length());
//		
//		String alLast = al.align(alFirst, alArray[3]);
//		alLast = alLast.substring((alLast.length() / 2 + 1), alLast.length());
//		
//		result += "\n" + alSeccond + "\n" + alLast; 
		String alCurrent;
		
		for (int i = 1; i < 5; i++) {
			alCurrent =  al.align(alFirst, alArray[i]);
			alCurrent = alCurrent.substring((alCurrent.length() / 2 + 1), alCurrent.length());
			result += "\n" + alCurrent;
		}
		
		return result;
	}
	
	public void clear() {
		list.clear();
	}
	
	public void add(String str) {
		if (list.size() < 5)
			list.add(str);
	}
}
