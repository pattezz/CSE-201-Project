import java.io.IOException;
import java.net.MalformedURLException;

import com.gargoylesoftware.htmlunit.FailingHttpStatusCodeException;

public class tester {
public static void main(String[] args) throws FailingHttpStatusCodeException, MalformedURLException, IOException  {
//	Alignable s = new Alignable();
//	Alignable.align("aaot","aaotcg");
	WebScrape w = new WebScrape();
	System.out.println(w.getFASTA("NM_000680.3"));
//	
}
}

