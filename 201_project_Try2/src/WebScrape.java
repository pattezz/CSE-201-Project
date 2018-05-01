import java.io.IOException;
import java.net.MalformedURLException;
import java.util.List;
import java.util.logging.Level;

import javax.swing.text.html.HTML.Tag;

import org.apache.commons.logging.LogFactory;

import com.gargoylesoftware.htmlunit.BrowserVersion;
import com.gargoylesoftware.htmlunit.FailingHttpStatusCodeException;
import com.gargoylesoftware.htmlunit.TextPage;
import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.DomElement;
import com.gargoylesoftware.htmlunit.html.HtmlElement;
import com.gargoylesoftware.htmlunit.html.HtmlPage;
import com.gargoylesoftware.htmlunit.javascript.host.Element;



public class WebScrape {
//	UserAgent useragent = new UserAgent();
	public String getFASTA(String accession) throws FailingHttpStatusCodeException, MalformedURLException, IOException {
//		try {
// JAUNT Implmentaion
//		useragent.visit("https://www.ncbi.nlm.nih.gov/nuccore/"+accession+"?report=fasta");
//		Elements elements = useragent.doc.findEvery("<pre");             //find all divs in the document
//		System.out.println("Count: " + elements.size() + " results");
//		 System.out.println( e.toString());
//		 System.out.println(e.innerHTML());
//	
//	} catch (JauntException e) {
//		System.err.println(e);
//	}
		LogFactory.getFactory().setAttribute("org.apache.commons.logging.Log", "org.apache.commons.logging.impl.NoOpLog");

		java.util.logging.Logger.getLogger("com.gargoylesoftware").setLevel(Level.OFF); 
		java.util.logging.Logger.getLogger("org.apache.commons.httpclient").setLevel(Level.OFF);
		WebClient web = new WebClient(BrowserVersion.CHROME);
	    web.getOptions().setJavaScriptEnabled(true);
	    web.getOptions().setThrowExceptionOnScriptError(false);
	    web.getOptions().setThrowExceptionOnFailingStatusCode(false);
		HtmlPage page = web.getPage("https://www.ncbi.nlm.nih.gov/nuccore/"+accession+"?report=fasta");
		HtmlElement e = page.getFirstByXPath("/html/head/meta[14]");
		String gi =e.getAttribute("content");
		TextPage secondPage=web.getPage("https://www.ncbi.nlm.nih.gov/sviewer/viewer.fcgi?id="+gi+"&db=nuccore&report=fasta&extrafeat=0&fmt_mask=0&retmode=html&withmarkup=on&tool=portal&log");
		return secondPage.getContent();
}
}
