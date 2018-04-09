import java.awt.Font;
import java.awt.Graphics;
//import java.awt.color;
//import java.awt.font;
import java.util.ArrayList;

import javax.swing.JPanel;



public class Screen extends JPanel{
	private static ArrayList<String> list = new ArrayList<String>();
	private static String top = " ";
	private static String left = " ";
	
	public Screen() {
		graph("agtctgtaaagtcccgttt", "agctaagtcctggtgctgaactga");	
		repaint();
	}

	public static void graph(String str1, String str2) {
		String str = " ";
		top = str1;
		left = str2;
		str += top;
		list.add(str);
		
		for (int i = 0; i < left.length(); i++) {
			str = "";
			str += left.charAt(i);
			for (int j = 0; j < top.length(); j++) {
				if (left.charAt(i) == top.charAt(j))
					str += "*";
				else
					str += " ";
			}
			list.add(str);
		}	
	}
	
	public void paint(Graphics g) {
		g.setFont(new Font("Courier New", Font.PLAIN, 40));
		
		int x = 15,y = 30;
		for (String s: list) {
		g.drawString(s, x, y);
		y += 30;
		}
		
		// horizontal lines
//		
//		int x1 = 30, x2 = 26 * top.length() -1, y1 = 35, y2 = 62;
//		for (int i = 0; i < left.length() - 1; i++) {
//			y1 += 30;
//			g.drawLine(x1, y1, x2, y1);
//		}
		
//		vertical lines
//		x1 = 30; 
//		y1 = 35;
//		y2 = 35 * left.length() - 1;
//		for (int i = 0; i < top.length() - 1; i++) {
//			x1 += 25;
//			g.drawLine(x1, y1, x1, y2);
//		}
//		
	}
}


