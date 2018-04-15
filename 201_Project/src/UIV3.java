import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.management.InvalidApplicationException;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class UIV3 extends JFrame implements ActionListener {
	private JFrame frame = new JFrame();
	JMenuBar jmb;
	JMenu menu1, menu2, menu3, menu4, menu5;
	JMenuItem item1, item2, item3, item4, item5, item6;
	JMenu build;
	JMenuItem file, project;
	JTextArea jta;

	public static void main(String[] args) {
		UIV3 GUI3 = new UIV3();
	}

	public UIV3() {
		frame.setSize(400, 400);
		frame.setTitle("Bioinformatic Toolkit");
		// frame.getContentPane().setBackground(new Color(0, 65, 32));
		menubar();
		JPanel panelDNA = new JPanel();
		// panelDNA.setBackground(new Color(0, 65, 32));

		JButton DNA = new JButton("DNA");
		// DNA.setBackground(new Color(0, 65, 32));
		DNA.setFont(new Font("Arial", Font.PLAIN, 20));
		// DNA.setForeground(Color.white);
		DNA.addActionListener(this);
		panelDNA.setLayout(new GridLayout(1, 3));
		panelDNA.add(DNA);

		JPanel panelRNA = new JPanel();
		// panelRNA.setBackground(new Color(0, 65, 32));

		JButton RNA = new JButton("RNA");
		// RNA.setBackground(new Color(0, 65, 32));
		// RNA.setForeground(Color.white);
		// RNA.setPreferredSize(new Dimension(300, 100));
		RNA.setFont(new Font("Arial", Font.PLAIN, 20));
		// RNA.setLayout(new GridLayout(2, 3));
		RNA.addActionListener(this);
		panelRNA.setLayout(new GridLayout(1, 3));
		panelRNA.add(RNA);

		JPanel panelProties = new JPanel();
		// panelProties.setBackground(new Color(0, 65, 32));

		JButton Proties = new JButton("Protien");
		// Proties.setBackground(new Color(0, 65, 32));
		// Proties.setForeground(Color.white);
		// RNA.setPreferredSize(new Dimension(300, 100));
		Proties.setFont(new Font("Arial", Font.PLAIN, 20));
		Proties.addActionListener(this);
		panelProties.setLayout(new GridLayout(1, 3));
		panelProties.add(Proties);

		// sum panel
		JPanel sumPanel = new JPanel();
		// sumPanel.setBackground(new Color(0, 65, 32));
		sumPanel.setLayout(new BoxLayout(sumPanel, BoxLayout.X_AXIS));
		ButtonGroup DRPGroup = new ButtonGroup();
		DRPGroup.add(DNA);
		DRPGroup.add(RNA);
		DRPGroup.add(Proties);
		sumPanel.add(panelDNA);
		sumPanel.add(panelRNA);
		sumPanel.add(panelProties);
		sumPanel.setBorder(BorderFactory.createTitledBorder("DRP"));

		// mulisequence
		JPanel muliPanel = new JPanel();
		muliPanel.setLayout(new BoxLayout(muliPanel, BoxLayout.Y_AXIS));
		JButton muliSequence = new JButton("Mulisequence");
		muliSequence.setFont(new Font("Arial", Font.PLAIN, 20));
		muliSequence.addActionListener(this);
		muliPanel.add(muliSequence);

		// JPanel search = new JPanel();
		// search.setLayout(new BoxLayout(search, BoxLayout.Y_AXIS));
		JButton SearchB = new JButton("Search");
		SearchB.setFont(new Font("Arial", Font.PLAIN, 20));
		SearchB.addActionListener(this);
		// search.add(SearchB);

		JPanel Close = new JPanel();
		Close.setLayout(new BoxLayout(Close, BoxLayout.Y_AXIS));
		JButton CloseB = new JButton("Close");
		// CloseB.setFont(new Font("Arial", Font.PLAIN, 20));
		CloseB.addActionListener(this);
		Close.add(CloseB);

		JPanel southPanel = new JPanel();
		southPanel.setLayout(new FlowLayout());
		southPanel.add(Close);

		JPanel northPanel = new JPanel();
		northPanel.setLayout(new GridLayout(3, 1));
		northPanel.add(sumPanel);
		northPanel.add(muliSequence);
		northPanel.add(SearchB);

		frame.setLayout(new BorderLayout());
		frame.add(northPanel, BorderLayout.NORTH);
		frame.add(southPanel, BorderLayout.SOUTH);

		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand().equals("RNA")) {
			frame.setVisible(false);
			RNAmethod();
		}
		if (e.getActionCommand().equals("DNA")) {
			frame.setVisible(false);
			DNAmethod();
		}
		if (e.getActionCommand().equals("Protien")) {
			frame.setVisible(false);
			Protienmethod();
		}
		if (e.getActionCommand().equals("Mulisequence")) {
			frame.setVisible(false);
			MuliMethod();
		}
		if (e.getActionCommand().equals("Search")) {
			frame.setVisible(false);
			SearchMethod();
		}
		if (e.getActionCommand().equals("Close")) {
			frame.setVisible(false);
			CloseMethod();
		}

	}

	private void CloseMethod() {
		// TODO Auto-generated method stub

	}

	private void SearchMethod() {
		// TODO Auto-generated method stub

	}

	private void MuliMethod() {
		JFrame MuliFrame = new JFrame("Mulisequence");
		MuliFrame.getContentPane().setBackground(new Color(0, 65, 32));
		MuliFrame.setSize(500, 500);
		MuliFrame.setLayout(new FlowLayout());
		MuliFrame.setVisible(true);

		JLabel inputM = new JLabel("Mulisequence");
		inputM.setForeground(Color.white);
		MuliFrame.add(inputM);
		TextField ProtiesInput = new TextField(100);
		MuliFrame.add(ProtiesInput);

		JButton add = new JButton("Add");
		add.setForeground(Color.black);
		add.setBackground(new Color(175, 175, 175));
		add.addActionListener(this);
		MuliFrame.add(add);

		JButton Return = new JButton("Return");
		Return.setBackground(new Color(0, 65, 32));
		Return.setForeground(Color.BLACK);
		Return.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (e.getActionCommand().equals("Return")) {
					frame.setVisible(true);
					MuliFrame.setVisible(false);
				}
			}
		});
		MuliFrame.add(Return);

	}

	private void Protienmethod() {
		JFrame ProtienFrame = new JFrame("Protien");
		ProtienFrame.getContentPane().setBackground(new Color(0, 65, 32));
		ProtienFrame.setSize(500, 500);
		ProtienFrame.setLayout(new FlowLayout());
		ProtienFrame.setVisible(true);

		JLabel inputP = new JLabel("Protien Sequence 1");
		inputP.setForeground(Color.white);
		ProtienFrame.add(inputP);
		TextField ProtiesInput = new TextField(100);
		ProtienFrame.add(ProtiesInput);

		JLabel inputP2 = new JLabel("Protien Sequence 2");
		inputP.setForeground(Color.white);
		ProtienFrame.add(inputP2);
		TextField ProtiesInput2 = new TextField(100);
		ProtienFrame.add(ProtiesInput2);

		JButton submit = new JButton("Submit");
		submit.setForeground(Color.white);
		submit.setBackground(new Color(175, 175, 175));
		ProtienFrame.add(submit);

		JButton score = new JButton("Scoring matrix");
		ProtienFrame.add(score);
		score.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (e.getActionCommand().equals("score")) {
					try {
						scoreMatrixi();
					} catch (InvalidApplicationException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			}

			private void scoreMatrixi() throws InvalidApplicationException {
				String a = ProtiesInput.getText();
				String b = ProtiesInput2.getText();
				diffMatrix test = new diffMatrix();
				System.out.println(test.calculate80(a, b));

			}
		});
		JLabel outputP = new JLabel("blank");
		outputP.setForeground(Color.white);
		ProtienFrame.add(outputP);
		// JTextField showR = new JTextField(13);
		// conPane.add(showR);
		System.out.println("1");
		ProtienFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JButton Return = new JButton("Return");
		Return.setBackground(new Color(0, 65, 32));
		Return.setForeground(Color.white);
		Return.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (e.getActionCommand().equals("Return")) {
					frame.setVisible(true);
					ProtienFrame.setVisible(false);
				}
			}
		});
		ProtienFrame.add(Return);

	}

	public void DNAmethod() {
		JFrame DNAFrame = new JFrame("DNA Align");
		DNAFrame.getContentPane().setBackground(new Color(0, 65, 32));
		DNAFrame.setSize(500, 500);
		DNAFrame.setLayout(new FlowLayout());
		DNAFrame.setVisible(true);
		// DNAFrame.getContentPane();
		// Container conPaneD = getContentPane();

		JLabel inputD = new JLabel("DNA Sequence ");
		inputD.setForeground(Color.white);
		DNAFrame.add(inputD);
		TextField DNAInput = new TextField(13);
		DNAInput.setForeground(Color.white);
		DNAFrame.add(DNAInput);

		// JLabel outputR = new JLabel("RNA Sequence 2");
		// outputR.setForeground(Color.white);
		// RNAFrame.add(outputR);
		// JTextField showR = new JTextField(13);
		// conPane.add(showR);
		// System.out.println("2");

		// JLabel inputR2 = new JLabel("DNA Sequence 2");
		// inputD2.setForeground(Color.white);
		TextField DNAInput2 = new TextField(13);
		DNAFrame.add(DNAInput2);
		// RNAFrame.add(inputR2);

		JButton submit = new JButton("Submit");
		// submit.setForeground(Color.white);
		// submit.setBackground(new Color(175, 175, 175));
		DNAFrame.add(submit);

		JButton Align = new JButton("Align");
		Align.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (e.getActionCommand().equals("Align")) {
					System.out.println("1");
				}
			}
		});
		JButton score = new JButton("Scoring matrix");
		DNAFrame.add(score);
		score.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (e.getActionCommand().equals("score")) {
					try {
						scoreMatrixi();
					} catch (InvalidApplicationException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			}

			private void scoreMatrixi() throws InvalidApplicationException {
				String a = DNAInput.getText();
				String b = DNAInput2.getText();
				diffMatrix test = new diffMatrix();
				System.out.println(test.calculate80(a, b));

			}
		});
		JButton Graph = new JButton("Graph");
		Graph.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (e.getActionCommand().equals("Graph")) {
					System.out.println("1");
				}
			}
		});
		JButton Setting = new JButton("Setting");
		Setting.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (e.getActionCommand().equals("Setting")) {
					System.out.println("1");
				}
			}
		});
		JButton Save = new JButton("Save");
		Save.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (e.getActionCommand().equals("Save")) {
					System.out.println("1");
				}
			}
		});

		// JLabel outputD = new JLabel("Align for your DNA");
		// outputD.setForeground(Color.white);
		// DNAFrame.add(outputD);
		// JTextField showR = new JTextField(13);
		// conPane.add(showR);
		// System.out.println("1");
		DNAFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JButton Return = new JButton("Return");
		// Return.setBackground(new Color(0, 65, 32));
		// Return.setForeground(Color.white);
		Return.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (e.getActionCommand().equals("Return")) {
					frame.setVisible(true);
					DNAFrame.setVisible(false);
				}
			}
		});
		DNAFrame.add(Align);
		DNAFrame.add(Graph);
		DNAFrame.add(Setting);
		DNAFrame.add(Save);
		DNAFrame.add(Return);
	}

	public void RNAmethod() {
		JFrame RNAFrame = new JFrame("RNA Align");
		RNAFrame.getContentPane().setBackground(new Color(0, 65, 32));
		RNAFrame.setSize(500, 500);
		RNAFrame.setLayout(new FlowLayout());
		RNAFrame.setVisible(true);
		// DNAFrame.getContentPane();
		// Container conPaneD = getContentPane();

		JLabel inputR = new JLabel("RNA Sequence ");
		inputR.setForeground(Color.white);
		RNAFrame.add(inputR);
		TextField RNAInput = new TextField(13);
		RNAInput.setForeground(Color.black);

		RNAFrame.add(RNAInput);

		// JLabel outputR = new JLabel("RNA Sequence 2");
		// outputR.setForeground(Color.white);
		// RNAFrame.add(outputR);
		// JTextField showR = new JTextField(13);
		// conPane.add(showR);
		// System.out.println("2");

		// JLabel inputR2 = new JLabel("DNA Sequence 2");
		// inputD2.setForeground(Color.white);
		TextField RNAInput2 = new TextField(13);
		RNAInput2.setForeground(Color.black);
		RNAFrame.add(RNAInput2);
		// RNAFrame.add(inputR2);

		JButton submit = new JButton("Submit");
		// submit.setForeground(Color.white);
		// submit.setBackground(new Color(175, 175, 175));
		RNAFrame.add(submit);

		JButton score = new JButton("Scoring matrix");
		RNAFrame.add(score);
		score.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (e.getActionCommand().equals("score")) {
					try {
						scoreMatrixi();
					} catch (InvalidApplicationException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			}

			private void scoreMatrixi() throws InvalidApplicationException {
				String a = RNAInput.getText();
				String b = RNAInput2.getText();
				diffMatrix test = new diffMatrix();
				System.out.println(test.calculate80(a, b));

			}
		});
		JButton Align = new JButton("Align");
		Align.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (e.getActionCommand().equals("Align")) {

				}
			}
		});
		JButton Graph = new JButton("Graph");
		Graph.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (e.getActionCommand().equals("Graph")) {
					System.out.println("1");
				}
			}
		});
		JButton Setting = new JButton("Setting");
		Setting.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (e.getActionCommand().equals("Setting")) {
					System.out.println("1");
				}
			}
		});
		JButton Save = new JButton("Save");
		Save.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (e.getActionCommand().equals("Save")) {
					System.out.println("1");
				}
			}
		});

		// JLabel outputD = new JLabel("Align for your DNA");
		// outputD.setForeground(Color.white);
		// DNAFrame.add(outputD);
		// JTextField showR = new JTextField(13);
		// conPane.add(showR);
		// System.out.println("1");
		RNAFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JButton Return = new JButton("Return");
		// Return.setBackground(new Color(0, 65, 32));
		// Return.setForeground(Color.white);
		Return.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (e.getActionCommand().equals("Return")) {
					frame.setVisible(true);
					RNAFrame.setVisible(false);
				}
			}
		});
		RNAFrame.add(Align);
		RNAFrame.add(Graph);
		RNAFrame.add(Setting);
		RNAFrame.add(Save);
		RNAFrame.add(Return);
		RNAFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public void menubar() {
		jmb = new JMenuBar();
		menu1 = new JMenu("File(F)");
		menu1.setMnemonic('f');
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

		jmb.add(menu1);
		jmb.add(menu2);
		jmb.add(menu3);
		jmb.add(menu4);
		jmb.add(menu5);
		frame.setJMenuBar(jmb);
	}
}
	
