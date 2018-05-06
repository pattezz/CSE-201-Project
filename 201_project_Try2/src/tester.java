import java.io.IOException;
import java.net.MalformedURLException;

import com.gargoylesoftware.htmlunit.FailingHttpStatusCodeException;

public class tester {
public static void main(String[] args) throws FailingHttpStatusCodeException, MalformedURLException, IOException  {
	Alignable s = new Alignable();
	System.out.println(Alignable.align("aattt","aaotcg"));
	save sl = new save();
	AlignSave a = new AlignSave(s.align("aattt","aaotcg"), "aattt", "aaotcg");
	sl.add(a);
	String sv=sl.Search("aattt").getAlignable();
	System.out.println(sv);
	
//	WebScrape w = new WebScrape();
//	System.out.println(w.getFASTA("NM_000680.3"));
//	
}
}

