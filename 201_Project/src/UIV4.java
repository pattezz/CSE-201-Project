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

import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class UIV4 extends JFrame implements ActionListener {
	private JFrame frame = new JFrame();
	save mem = new save();
	public static void main(String[] args) {
		UIV4 GUI4 = new UIV4();
	}

	public UIV4() {
		frame.setSize(500, 500);
		frame.setTitle("Bioinformatic Toolkit");
		//frame.getContentPane().setBackground(new Color(0, 65, 32));
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
			
			
		}
		if (e.getActionCommand().equals("Close")) {
			frame.setVisible(false);
			
		}

	}

	

	private void MuliMethod() {
		JFrame MuliFrame = new JFrame("Mulisequence");
		//MuliFrame.getContentPane().setBackground(new Color(0, 65, 32));
		MuliFrame.setSize(500, 500);
		MuliFrame.setLayout(new FlowLayout());
		MuliFrame.setVisible(true);

		JLabel inputM = new JLabel("Mulisequence");
		//inputM.setForeground(Color.white);
		MuliFrame.add(inputM);
		TextField ProtiesInput = new TextField(100);
		MuliFrame.add(ProtiesInput);

		JButton add = new JButton("Add");
		//add.setForeground(Color.black);
		//add.setBackground(new Color(175, 175, 175));
		add.addActionListener(this);
		MuliFrame.add(add);

		JButton Return = new JButton("Return");
		//Return.setBackground(new Color(0, 65, 32));
		//Return.setForeground(Color.BLACK);
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
		// ProtienFrame.getContentPane().setBackground(new Color(0, 65, 32));
		ProtienFrame.setSize(580, 580);
		ProtienFrame.setLayout(new FlowLayout());
		ProtienFrame.setVisible(true);

		
		JPanel Sequence = new JPanel();
		Sequence.setLayout(new GridLayout(2,2));
		JLabel inputP = new JLabel("Protien Sequence 1");
		// inputP.setForeground(Color.white);
		Sequence.add(inputP);
		TextField ProtiesInput = new TextField(13);
		Sequence.add(ProtiesInput);
		// ProtiesInput.setForeground(Color.black);

		JLabel inputP2 = new JLabel("Protien Sequence 2");
		// inputP2.setForeground(Color.white);
		Sequence.add(inputP2);
		TextField ProtiesInput2 = new TextField(13);
		Sequence.add(ProtiesInput2);
		// ProtiesInput2.setForeground(Color.black);
		
		ProtienFrame.add(Sequence);

		JButton submit = new JButton("Submit");
		// submit.setForeground(Color.black);
		// submit.setBackground(new Color(175, 175, 175));
		ProtienFrame.add(submit);

		JButton score = new JButton("Scoring matrix");
		ProtienFrame.add(score);
		score.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (e.getActionCommand().equals("scoring matrix")) {
					try {
						JLabel score = new JLabel(scoreMatrixi());
					} catch (InvalidApplicationException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			}

			private String scoreMatrixi() throws InvalidApplicationException {
				String a = ProtiesInput.getText();
				String b = ProtiesInput2.getText();
				diffMatrix test = new diffMatrix();
				System.out.println(test.calculate80(a, b));
				return test.calculate80(a, b);

			}
		});

		JButton Return = new JButton("Return");
		// Return.setBackground(new Color(0, 65, 32));
		// Return.setForeground(Color.black);
		Return.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (e.getActionCommand().equals("Return")) {
					frame.setVisible(true);
					ProtienFrame.setVisible(false);
				}
			}
		});
		ProtienFrame.add(Return);
		ProtienFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public void DNAmethod() {
		JFrame DNAFrame = new JFrame("DNA");
		// DNAFrame.getContentPane().setBackground(new Color(0, 65, 32));
		DNAFrame.setSize(500, 500);
		DNAFrame.setLayout(new FlowLayout());
		DNAFrame.setVisible(true);
		// DNAFrame.getContentPane();
		// Container conPaneD = getContentPane();

		JLabel inputD = new JLabel("DNA Sequence 1");
		// inputD.setForeground(Color.white);
		DNAFrame.add(inputD);

		TextField DNAInput = new TextField(13);
		// DNAInput.setForeground(Color.black);
		DNAFrame.add(DNAInput);

		JLabel input2 = new JLabel("DNA Sequence 2");
		DNAFrame.add(input2);
		// inputD2.setForeground(Color.white);

		TextField DNAInput2 = new TextField(13);
		// DNAInput2.setForeground(Color.black);
		DNAFrame.add(DNAInput2);
		// RNAFrame.add(inputR2);

		JButton Align = new JButton("Align");
		Align.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (e.getActionCommand().equals("Align")) {
					JLabel align = new JLabel(alignMethod(),
							SwingConstants.CENTER);
					JFrame align1 = new JFrame("Alignment result");
					align1.setSize(500, 500);
					align1.setLocation(300, 300);
					align1.setLayout(new FlowLayout());
					align1.setVisible(true);
					align1.add(align);

					JButton close = new JButton("Close");
					align1.add(close);
					close.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							if (e.getActionCommand().equals("Close")) {
								align1.setVisible(false);

							}
						}
					});
				}
			}

			private String alignMethod() {
				String a = DNAInput.getText();
				String b = DNAInput2.getText();
				Alignable s = new Alignable();
				//System.out.println(Alignable.align(a, b));
				return Alignable.align(a, b);

			}
		});

		JButton score80 = new JButton("Blosum80matrix score");
		DNAFrame.add(score80);
		JButton score62 = new JButton("Blosum62matrix score");
		DNAFrame.add(score62);
		score80.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (e.getActionCommand().equals("Blosum80matrix score")) {
					try {
						JLabel score = new JLabel(scoreMatrix80());
						JFrame score80 = new JFrame("Blosum80 score");
						score80.setSize(200, 200);
						score80.setLocation(300, 300);
						score80.setLayout(new FlowLayout());
						score80.setVisible(true);
						score80.add(score);

						JButton close = new JButton("Close");
						score80.add(close);
						close.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent e) {
								if (e.getActionCommand().equals("Close")) {
									score80.setVisible(false);
									score80.dispose();

								}
							}
						});
					} catch (InvalidApplicationException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			}

			private String scoreMatrix80() throws InvalidApplicationException {
				String a = DNAInput.getText();
				String b = DNAInput2.getText();
				diffMatrix test = new diffMatrix();
				System.out.println(test.calculate80(a, b));
				return test.calculate80(a, b);

			}
		});
		score62.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (e.getActionCommand().equals("Blosum62matrix score")) {
					try {
						JLabel score = new JLabel(scoreMatrix62());
						JFrame score62 = new JFrame("Blosum62 score");
						score62.setSize(200, 200);
						score62.setLocation(300, 300);
						score62.setLayout(new FlowLayout());
						score62.setVisible(true);
						score62.add(score);
						JButton close = new JButton("Close");
						score62.add(close);
						close.addActionListener(new ActionListener() {

							public void actionPerformed(ActionEvent e) {
								if (e.getActionCommand().equals("Close")) {
									score62.setVisible(false);
									score62.dispose();
								}
							}
						});
					} catch (InvalidApplicationException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			}

			private String scoreMatrix62() throws InvalidApplicationException {
				String a = DNAInput.getText();
				String b = DNAInput2.getText();
				diffMatrix test = new diffMatrix();
				System.out.println(test.calculate62(a, b));
				return test.calculate62(a, b);

			}
		});

		JButton Graph = new JButton("Graph");
		Graph.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (e.getActionCommand().equals("Graph")) {
					String a = DNAInput.getText();
					String b = DNAInput2.getText();
					Frame f = new Frame();
					if (e.getActionCommand().equals("Graph")) {
						f.s.graph(a, b);
					}	
						JButton close = new JButton("Close");
						f.add(close);
						close.addActionListener(new ActionListener() {
							@Override
							public void actionPerformed(ActionEvent e) {
								if (e.getActionCommand().equals("Close")) {
									f.dispose();
									f.setVisible(false);
									
								}
							}
						});
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
					String a = DNAInput.getText();
					String b = DNAInput2.getText();
					
					Alignable savedAlignable = new Alignable();
					savedAlignable.align(a, b);
					mem.add(savedAlignable);
					mem.export(savedAlignable);
				}
			}
		});

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
		DNAFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}

	public void RNAmethod() {
		JFrame RNAFrame = new JFrame("RNA Align");
		// RNAFrame.getContentPane().setBackground(new Color(0, 65, 32));
		RNAFrame.setSize(500, 500);
		RNAFrame.setLayout(new FlowLayout());
		RNAFrame.setVisible(true);
		// DNAFrame.getContentPane();
		// Container conPaneD = getContentPane();

		JLabel inputR = new JLabel("RNA Sequence 1 ");
		// inputR.setForeground(Color.white);
		RNAFrame.add(inputR);
		JTextField RNAInput = new JTextField(13);
		// RNAInput.setForeground(Color.black);

		RNAFrame.add(RNAInput);


		JLabel inputR2 = new JLabel("RNA Sequence 2");
		JTextField RNAInput2 = new JTextField(13);
		// inputD2.setForeground(Color.white);
		RNAFrame.add(inputR2);

		// RNAInput2.setForeground(Color.black);
		RNAFrame.add(RNAInput2);
		// RNAFrame.add(inputR2);

		JButton score80 = new JButton("Blosum80matrix score");
		RNAFrame.add(score80);
		JButton score62 = new JButton("Blosum62matrix score");
		RNAFrame.add(score62);
		score80.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (e.getActionCommand().equals("Blosum80matrix score")) {
					try {
						JLabel score = new JLabel(scoreMatrix80());
						JFrame score80 = new JFrame("Blosum80 score");
						score80.setSize(200, 200);
						score80.setLocation(300, 300);
						score80.setLayout(new FlowLayout());
						score80.setVisible(true);
						score80.add(score);

						JButton close = new JButton("Close");
						score80.add(close);
						close.addActionListener(new ActionListener() {

							public void actionPerformed(ActionEvent e) {
								if (e.getActionCommand().equals("Close")) {
									score80.setVisible(false);

								}

							}

						});

					} catch (InvalidApplicationException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			}

			private String scoreMatrix80() throws InvalidApplicationException {
				String a = RNAInput.getText();
				String b = RNAInput2.getText();
				diffMatrix test = new diffMatrix();
				System.out.println(test.calculate80(a, b));
				return test.calculate80(a, b);

			}
		});
		score62.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (e.getActionCommand().equals("Blosum62matrix score")) {
					try {
						JLabel score = new JLabel(scoreMatrix62());
						JFrame score62 = new JFrame("Blosum62 score");
						score62.setSize(200, 200);
						score62.setLocation(300, 300);
						score62.setLayout(new FlowLayout());
						score62.setVisible(true);
						score62.add(score);
						JButton close = new JButton("Close");
						score62.add(close);
						close.addActionListener(new ActionListener() {

							@Override
							public void actionPerformed(ActionEvent e) {
								if (e.getActionCommand().equals("Close")) {
									score62.setVisible(false);

								}

							}

						});

					} catch (InvalidApplicationException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}

			}

			private String scoreMatrix62() throws InvalidApplicationException {
				String a = RNAInput.getText();
				String b = RNAInput2.getText();
				diffMatrix test = new diffMatrix();
				System.out.println(test.calculate62(a, b));
				return test.calculate62(a, b);

			}
		});
		JButton Align = new JButton("Align");
		Align.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (e.getActionCommand().equals("Align")) {

					JLabel align = new JLabel(alignMethod(),
							SwingConstants.CENTER);
					JFrame align1 = new JFrame("Alignment result");
					align1.setSize(500, 500);
					align1.setLocation(300, 300);
					align1.setLayout(new FlowLayout());
					align1.setVisible(true);
					align1.add(align);

					JButton close = new JButton("Close");
					align1.add(close);
					close.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							if (e.getActionCommand().equals("Close")) {
								align1.setVisible(false);

							}
						}
					});
				}
			}

			private String alignMethod() {
				String a = RNAInput.getText();
				String b = RNAInput2.getText();
				Alignable s = new Alignable();

				return Alignable.align(a, b);

			}
		});

		JButton Graph = new JButton("Graph");
		Graph.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String a = RNAInput.getText();
				String b = RNAInput2.getText();
				if (e.getActionCommand().equals("Graph")) {
					Frame f = new Frame();
					f.s.graph(a, b);
					JButton close = new JButton("Close");
					close.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							if (e.getActionCommand().equals("Close")) {
								f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

							}

						}

					});

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
					String a = RNAInput.getText();
					String b = RNAInput2.getText();
					
					Alignable savedAlignable = new Alignable();
					savedAlignable.align(a, b);
					mem.add(savedAlignable);
					mem.export(savedAlignable);
				}
			}
		});

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


}
