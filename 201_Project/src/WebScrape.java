import java.util.List;

import com.jaunt.Element;
import com.jaunt.Elements;
import com.jaunt.JauntException;
import com.jaunt.Node;
import com.jaunt.UserAgent;

public class WebScrape {
	UserAgent useragent = new UserAgent();
	public void getFASTA(String accession) {
		try {

		useragent.visit("https://www.ncbi.nlm.nih.gov/nuccore/"+accession+"?report=fasta");
		Elements elements = useragent.doc.findEvery("<pre");             //find all divs in the document
		System.out.println("Count: " + elements.size() + " results");
//		 System.out.println( e.toString());
//		 System.out.println(e.innerHTML());
	
	} catch (JauntException e) {
		System.err.println(e);
	}
	
}
}
