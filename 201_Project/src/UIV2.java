import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class UIV2 {
	
public static void main(String[] args) {
	CreateGui GUI2 = new CreateGui();
}
}

class CreateGui extends JFrame implements ActionListener {
	private JFrame frame = new JFrame();
	JMenuBar jmb;   //菜单条组件  
    JMenu menu1, menu2, menu3, menu4, menu5;//菜单  
    JMenuItem item1, item2, item3, item4, item5, item6;//菜单项  
    JMenu build;    //二级菜单  
    JMenuItem file, project;  
    JTextArea jta;  
      
    JToolBar jtb;//工具条  
    JButton jb1, jb2, jb3, jb4, jb5, jb6, jb7;
    
	CreateGui(){
		frame.setSize(800,800);
		frame.setTitle("Bioinformatic Toolkit");
		
		//Container conPane = getContentPane();
		frame.setLayout(new FlowLayout());
		frame.getContentPane().setBackground(Color.green);
		
        toolbar();
        menubar();
        
		JButton DNA = new JButton("DNA");
		DNA.addActionListener(this);
		frame.add(DNA);
		
		JButton RNA = new JButton("RNA");
        RNA.addActionListener(this);
        frame.add(RNA);
        
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(e.getActionCommand().equals("RNA")) {
			frame.setVisible(false);
			RNAmethod();
		}
		if(e.getActionCommand().equals("DNA")) {
			frame.setVisible(false);
			DNAmethod();
		}
		
	}
	public void DNAmethod() {
		JFrame DNAFrame = new JFrame("DNA Align");
		DNAFrame.setSize(500,500);
		DNAFrame.setLayout(new FlowLayout());
		DNAFrame.setVisible(true);
		//DNAFrame.getContentPane();
		//Container conPaneD = getContentPane();
		JLabel inputD = new JLabel("Enter your DNA Align");
		DNAFrame.add(inputD);
		TextField DNAInput = new TextField(13);
		DNAFrame.add(DNAInput);
		JButton submit = new JButton("Submit");
		DNAFrame.add(submit);
		JLabel outputD = new JLabel("Align for your DNA");
		DNAFrame.add(outputD);
		//JTextField showR = new JTextField(13);
		//conPane.add(showR);
		System.out.println("1");
		DNAFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	public void RNAmethod() {
		JFrame RNAFrame = new JFrame("RNA Align");
		RNAFrame.setSize(500,500);
		RNAFrame.setLayout(new FlowLayout());
		RNAFrame.setVisible(true);
		//DNAFrame.getContentPane();
		//Container conPaneD = getContentPane();
		JLabel inputR = new JLabel("Enter your RNA Align");
		RNAFrame.add(inputR);
		TextField RNAInput = new TextField(13);
		RNAFrame.add(RNAInput);
		JButton submit = new JButton("Submit");
		RNAFrame.add(submit);
		JLabel outputR = new JLabel("An align for your RNA");
		RNAFrame.add(outputR);
		//JTextField showR = new JTextField(13);
		//conPane.add(showR);
		System.out.println("2");
		RNAFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	public void toolbar() {
		//创建工具条  
        jtb = new JToolBar();  
        jb1 = new JButton("New");  
        jb1.setToolTipText("New");//鼠标悬停提示信息  
        jb2 = new JButton("Open");  
        jb3 = new JButton("Copy");  
        jb4 = new JButton("Cut");  
        jb5 = new JButton("Print");  
        jtb.add(jb1);  
        jtb.add(jb2);  
        jtb.add(jb3);  
        jtb.add(jb4);  
        jtb.add(jb5);  
        jta = new JTextArea();  
            //加入滚动条  
        JScrollPane jsp = new JScrollPane(jta);  
        jsp.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        frame.add(jtb, BorderLayout.NORTH);  //添加工具条
	}
	public void menubar() {
		jmb = new JMenuBar();  
        menu1 = new JMenu("File(F)");  
        menu1.setMnemonic('f'); //助记符  
        menu2 = new JMenu("Edit");  
        menu2.setMnemonic('E');  
        menu3 = new JMenu("Format");  
        menu4 = new JMenu("View");  
        menu5 = new JMenu("Help");  
        build = new JMenu("New");  
          
        file = new JMenuItem("File");  
        project = new JMenuItem("Project");  
        item1 = new JMenuItem("Open");  
        item2 = new JMenuItem("Save(S)");  
        item3 = new JMenuItem("Save as");  
        item4 = new JMenuItem("Page settings");  
        item5 = new JMenuItem("Print");  
        item6 = new JMenuItem("Exit");  
          
        jta = new JTextArea();  
          
            //添加菜单项至菜单上  
        build.add(file);  
        build.add(project);  
          
        menu1.add(build);  
        menu1.add(item1);  
        menu1.add(item2);  
        menu1.add(item3);  
        menu1.addSeparator();  
        menu1.add(item4);  
        menu1.add(item5);  
        menu1.add(item6);  
            //将菜单加入至菜单栏  
        jmb.add(menu1);  
        jmb.add(menu2);  
        jmb.add(menu3);  
        jmb.add(menu4);  
        jmb.add(menu5);  
        frame.setJMenuBar(jmb);  //添加菜单栏，不能设定位置，会自动放在最上部
	}
	
}

