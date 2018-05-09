import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.HeadlessException;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.MalformedURLException;

import javax.management.InvalidApplicationException;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
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
		frame.setSize(400, 300);
		frame.setTitle("Bioinformatic Toolkit");
		JPanel panelDNA = new JPanel();

		JButton DNA = new JButton("DNA");
		DNA.setFont(new Font("Arial", Font.PLAIN, 20));
		DNA.addActionListener(this);
		panelDNA.setLayout(new GridLayout(1, 3));
		panelDNA.add(DNA);

		JPanel panelRNA = new JPanel();

		JButton RNA = new JButton("RNA");
		RNA.setFont(new Font("Arial", Font.PLAIN, 20));
		
		RNA.addActionListener(this);
		panelRNA.setLayout(new GridLayout(1, 3));
		panelRNA.add(RNA);

		JPanel panelProtein = new JPanel();

		JButton Protein = new JButton("Protein");
		Protein.setFont(new Font("Arial", Font.PLAIN, 20));
		Protein.addActionListener(this);
		panelProtein.setLayout(new GridLayout(1, 3));
		panelProtein.add(Protein);

		// sum panel
		JPanel sumPanel = new JPanel();
		sumPanel.setLayout(new BoxLayout(sumPanel, BoxLayout.X_AXIS));
		ButtonGroup DRPGroup = new ButtonGroup();
		DRPGroup.add(DNA);
		DRPGroup.add(RNA);
		DRPGroup.add(Protein);
		sumPanel.add(panelDNA);
		sumPanel.add(panelRNA);
		sumPanel.add(panelProtein);
		sumPanel.setBorder(BorderFactory.createTitledBorder("DRP"));

		// multisequence
		JPanel muliPanel = new JPanel();
		muliPanel.setLayout(new BoxLayout(muliPanel, BoxLayout.Y_AXIS));
		JButton muliSequence = new JButton("Multisequence");
		muliSequence.setFont(new Font("Arial", Font.PLAIN, 20));
		muliSequence.addActionListener(this);
		muliPanel.add(muliSequence);

		
		JButton SearchB = new JButton("Search");
		SearchB.setFont(new Font("Arial", Font.PLAIN, 20));
		SearchB.addActionListener(this);
		

		JPanel Close = new JPanel();
		Close.setLayout(new FlowLayout());
		JButton CloseB = new JButton("Close");
		CloseB.addActionListener(this);
		
		JButton help = new JButton("Help");
		help.addActionListener(this);
		Close.add(help);
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
		if (e.getActionCommand().equals("Protein")) {
			frame.setVisible(false);
			Protienmethod();
		}
		if (e.getActionCommand().equals("Multisequence")) {
			frame.setVisible(false);
			MultiMethod();
		}
		if (e.getActionCommand().equals("Search")) {
			SearchMethod();
		}
		if (e.getActionCommand().equals("Close")) {
			frame.setVisible(false);
			System.exit(0);
		}
		if (e.getActionCommand().equals("Help")) {
			HelpMethod();
		}

	}

	private void HelpMethod() {
		JFrame Help = new JFrame("Help");
		Help.setSize(750, 400);
		Help.setLocation(450, 150);
		Help.setLayout(new FlowLayout());
		Help.setVisible(true);
		
		JTextArea He = new JTextArea();
		JScrollPane jsp = new JScrollPane(He);
		He.append(  "Align: Input two strings and you will get the Needleman Wunsch Alignment of the strings. \r\n" + 
					"\r\n" + 
					"Save: Saves the alignment of the two inputted strings. \r\n" + 
					"\r\n" + 
					"Graph: Creates a dot matrix graph of the relationship between the two inputted strings.\r\n" + 
					"\r\n" + 
					"Setting: Allows you to change the criteria by which the best alignment is found.\r\n"+
					"\r\n" +
					"Blosum80matrix: Allows you to view the relationship between two strings of the same length in the Blosum80matrix. \r\n" + 
					"\r\n" +
					"Blosum62matrix: Allows you to view the relationship between two strings of the same length in the Blosum62matrix. \r\n" + 
					"\r\n" +
					"Search NCBI: Search the NCBI website for the FASTA sequence related to the accession number entered.\r\n" + 
					"\r\n" + 
					"Search Saved alignments: Searches saved alignments for alignments where you used the entered sequence.\r\n"
					);
		Help.add(jsp);

	private void SearchMethod() {
		JFrame SearchFrame = new JFrame("Search");
		// DNAFrame.getContentPane().setBackground(new Color(0, 65, 32));
		SearchFrame.setSize(500, 500);
		SearchFrame.setLayout(new FlowLayout());
		SearchFrame.setVisible(true);
		// DNAFrame.getContentPane();
		// Container conPaneD = getContentPane();

		JLabel inputD = new JLabel("Accession Number");
		JTextField searchable = new JTextField(13);
		JButton Return = new JButton("Return");
		// Return.setBackground(new Color(0, 65, 32));
		// Return.setForeground(Color.white);
		Return.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (e.getActionCommand().equals("Return")) {
					frame.setVisible(true);
					SearchFrame.setVisible(false);
				}
			}
		});
		JButton searchSaved = new JButton("Search Saved Alignments");
		searchSaved.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String s = searchable.getText();
				if (e.getActionCommand().equals("Search Saved Alignments")) {
					JFrame searcha = new JFrame("Seach Result result");
					String result =mem.Search(s).getAlignable();
					JLabel sl= new JLabel(result);
					searcha.add(sl);
					searcha.setSize(500, 500);
					searcha.setLocation(300, 300);
					searcha.setLayout(new FlowLayout());
					searcha.setVisible(true);
					//searcha.add(seq);
				}
			}
		}
	);
		WebScrape wscrape= new WebScrape();
		JButton ws = new JButton("Search NCBI");
		ws.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String s = searchable.getText();
				if (e.getActionCommand().equals("Search NCBI")) {
					JFrame searcha = new JFrame("Alignment result");
					JLabel seq = null;

					searcha.setSize(500, 500);
					searcha.setLocation(300, 300);
					searcha.setLayout(new FlowLayout());
					searcha.setVisible(true);
					try {
						searcha.add(new TextField(wscrape.getFASTA(searchable.getText())));
					} catch (HeadlessException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (FailingHttpStatusCodeException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (MalformedURLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					
					
					JButton close = new JButton("Close");
					close.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							if (e.getActionCommand().equals("Close")) {
								searcha.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

							}

						}

					});

				}
			}
		});
		SearchFrame.add(searchable);
		SearchFrame.add(inputD);
		SearchFrame.add(ws);
		SearchFrame.add(Return);
		SearchFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JPanel re = new JPanel();
		SearchFrame.add(searchSaved);
		re.setLayout(new FlowLayout());
		JButton Return1 = new JButton("Return");
		Return.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (e.getActionCommand().equals("Return")) {
					frame.setVisible(true);
					SearchFrame.setVisible(false);
				}
			}
		});
	}

	private void MultiMethod() {
		MultiSeq multiSeq = new MultiSeq();
		JFrame MultiFrame = new JFrame("Multisequence");
		MultiFrame.setSize(500, 200);
		MultiFrame.setLayout(new FlowLayout());
		MultiFrame.setVisible(true);

		JLabel inputM = new JLabel("Multisequence");
		MultiFrame.add(inputM);
		TextField ProtiesInput = new TextField(50);
		MultiFrame.add(ProtiesInput);

		JButton add = new JButton("Add");
		add.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				multiSeq.add(ProtiesInput.getText());
				ProtiesInput.setText("");
							}
						});
		
		JButton alignButton = new JButton("Align");
		alignButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
		JTextArea align = new JTextArea(multiSeq.align());
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
					multiSeq.clear();

				}
			}
		});
			}
		});
		add.addActionListener(this);
		MultiFrame.add(add);
		MultiFrame.add(alignButton);

		JButton Return = new JButton("Return");
		Return.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (e.getActionCommand().equals("Return")) {
					frame.setVisible(true);
					MultiFrame.setVisible(false);
				}
			}
		});
		MultiFrame.add(Return);
	}

	private void Protienmethod() {
		JFrame ProtienFrame = new JFrame("Protein");
		// ProtienFrame.getContentPane().setBackground(new Color(0, 65, 32));
		ProtienFrame.setSize(500, 200);
		ProtienFrame.setLayout(new FlowLayout());
		ProtienFrame.setVisible(true);

		
		JPanel Sequence = new JPanel();
		Sequence.setLayout(new GridLayout(2,2));
		JLabel inputP = new JLabel("Protein Sequence 1");
		// inputP.setForeground(Color.white);
		Sequence.add(inputP);
		TextField ProtiesInput = new TextField(13);
		Sequence.add(ProtiesInput);
		// ProtiesInput.setForeground(Color.black);

		JLabel inputP2 = new JLabel("Protein Sequence 2");
		Sequence.add(inputP2);
		TextField ProtiesInput2 = new TextField(13);
		Sequence.add(ProtiesInput2);
		ProtienFrame.add(Sequence);
		JPanel ButtonG = new JPanel();
		ButtonG.setLayout(new FlowLayout());
		
		
		JPanel re = new JPanel();
		JButton Return = new JButton("Return");
		Return.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (e.getActionCommand().equals("Return")) {
					frame.setVisible(true);
					ProtienFrame.setVisible(false);
				}
			}
		});
		re.add(Return);
		
		JButton score80 = new JButton("Blosum80matrix score");
		ButtonG.add(score80);
		JButton score62 = new JButton("Blosum62matrix score");
		ButtonG.add(score62);
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
						e1.printStackTrace();
					}
				}
			}

			private String scoreMatrix80() throws InvalidApplicationException {
				String a = ProtiesInput.getText();
				String b = ProtiesInput2.getText();
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
						e1.printStackTrace();
					}
				}
			}

			private String scoreMatrix62() throws InvalidApplicationException {
				String a = ProtiesInput.getText();
				String b = ProtiesInput2.getText();
				diffMatrix test = new diffMatrix();
				System.out.println(test.calculate62(a, b));
				return test.calculate62(a, b);

			}
		});
		re.add(Return);
		ProtienFrame.add(ButtonG);
		ProtienFrame.add(re);
		ProtienFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public void DNAmethod() {
		Settings setingObject = new Settings(-2, 1, -1);
		JFrame DNAFrame = new JFrame("DNA");
		DNAFrame.setSize(510, 150);
		DNAFrame.setLayout(new FlowLayout());
		DNAFrame.setVisible(true);

		JLabel inputD = new JLabel("DNA Sequence 1");
		DNAFrame.add(inputD);

		TextField DNAInput = new TextField(13);
		DNAFrame.add(DNAInput);

		JLabel input2 = new JLabel("DNA Sequence 2");
		DNAFrame.add(input2);

		TextField DNAInput2 = new TextField(13);
		DNAFrame.add(DNAInput2);

		JButton Align = new JButton("Align");
		Align.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (e.getActionCommand().equals("Align")) {
					JTextArea align = new JTextArea();
					align.setText(alignMethod());
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
				return Alignable.align(a, b,setingObject.gap,setingObject.match,setingObject.mismatch);

			}
		});

		

		JButton Graph = new JButton("Graph");
		Graph.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (e.getActionCommand().equals("Graph")) {
					String a = DNAInput.getText();
					String b = DNAInput2.getText();
					Frame f = new Frame();
					f.s.graph(a, b);
					JPanel clo = new JPanel();
					JButton close = new JButton("Close");
					clo.add(close);
					f.add(clo);
					close.addActionListener(new ActionListener() {
						@Override
						public void actionPerformed(ActionEvent e) {
							if (e.getActionCommand().equals("Close")) {
								f.s.clear();
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
					JFrame set = new JFrame("Setting");
					set.setSize(300, 150);
					set.setLocation(300, 300);
					set.setLayout(new FlowLayout());
					set.setVisible(true);
					
					JPanel setG = new JPanel();
					setG.setLayout(new GridLayout(3, 2));
					JLabel gap = new JLabel("Gap");
					setG.add(gap);
					TextField gapInput = new TextField(6);
					setG.add(gapInput);
					
					JLabel match = new JLabel("Match");
					setG.add(match);
					TextField matchInput = new TextField(6);
					setG.add(matchInput);
					
					JLabel misMatch = new JLabel("Mismatch");
					setG.add(misMatch);
					TextField misMatchInput = new TextField(13);
					setG.add(misMatchInput);
					set.add(setG);
					
					JPanel YoN = new JPanel();
					YoN.setLayout(new FlowLayout());
					JButton Yes = new JButton("Yes");
					Yes.addActionListener(new ActionListener() {

						@Override
						public void actionPerformed(ActionEvent e) {
							if(e.getActionCommand().equals("Yes")) {
								setingObject.gap=Integer.parseInt(gapInput.getText());
								setingObject.mismatch=Integer.parseInt(misMatchInput.getText());
								setingObject.match=Integer.parseInt(matchInput.getText());
							}
							
						}
						
					});
					JButton No = new JButton("No");
					No.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							if (e.getActionCommand().equals("No")) {
								set.setVisible(false);
							}
						}
					});
					YoN.add(Yes);
					YoN.add(No);
					set.add(YoN);
					
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
					AlignSave a1 = new AlignSave(savedAlignable.align(a, b), a, b);
					mem.add(a1);
				}
			}
		});

		JButton Return = new JButton("Return");
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
		Settings setingObject = new Settings(-2, 1, -1);
		JFrame RNAFrame = new JFrame("RNA Align");
		RNAFrame.setSize(530, 150);
		RNAFrame.setLayout(new FlowLayout());
		RNAFrame.setVisible(true);
		

		JLabel inputR = new JLabel("RNA Sequence 1 ");
		RNAFrame.add(inputR);
		JTextField RNAInput = new JTextField(13);
		RNAFrame.add(RNAInput);


		JLabel inputR2 = new JLabel("RNA Sequence 2");
		JTextField RNAInput2 = new JTextField(13);
		RNAFrame.add(inputR2);
		RNAFrame.add(RNAInput2);
		

		JButton Align = new JButton("Align");
		Align.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (e.getActionCommand().equals("Align")) {

					JTextArea align = new JTextArea();
					align.setText(alignMethod());
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
				return Alignable.align(a, b,setingObject.gap,setingObject.match,setingObject.mismatch);
			}
		});

		JButton Graph = new JButton("Graph");
		Graph.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (e.getActionCommand().equals("Graph")) {
					String a = RNAInput.getText();
					String b = RNAInput2.getText();
					Frame f = new Frame();
					f.s.graph(a, b);
					JPanel clo = new JPanel();
					JButton close = new JButton("Close");
					clo.add(close);
					f.add(clo);
					close.addActionListener(new ActionListener() {
						@Override
						public void actionPerformed(ActionEvent e) {
							if (e.getActionCommand().equals("Close")) {
								f.s.clear();
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
					JFrame set = new JFrame("Setting");
					set.setSize(300, 150);
					set.setLocation(300, 300);
					set.setLayout(new FlowLayout());
					set.setVisible(true);
					
					JPanel setG = new JPanel();
					setG.setLayout(new GridLayout(3, 2));
					JLabel gap = new JLabel("Gap");
					setG.add(gap);
					TextField gapInput = new TextField(6);
					setG.add(gapInput);
					
					JLabel match = new JLabel("Match");
					setG.add(match);
					TextField matchInput = new TextField(6);
					setG.add(matchInput);
					
					JLabel misMatch = new JLabel("Mismatch");
					setG.add(misMatch);
					TextField misMatchInput = new TextField(13);
					setG.add(misMatchInput);
					set.add(setG);
					
					JPanel YoN = new JPanel();
					YoN.setLayout(new FlowLayout());
					JButton Yes = new JButton("Yes");
					Yes.addActionListener(new ActionListener() {

						@Override
						public void actionPerformed(ActionEvent e) {
							if(e.getActionCommand().equals("Yes")) {
								setingObject.gap=Integer.parseInt(gapInput.getText());
								setingObject.mismatch=Integer.parseInt(misMatchInput.getText());
								setingObject.match=Integer.parseInt(matchInput.getText());
							}
							
						}
						
					});
					JButton No = new JButton("No");
					No.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							if (e.getActionCommand().equals("No")) {
								set.setVisible(false);
							}
						}
					});
							
					
					YoN.add(Yes);
					YoN.add(No);
					set.add(YoN);
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
					AlignSave a1 = new AlignSave(savedAlignable.align(a, b), a, b);
					mem.add(a1);
				}
			}
		});

		JButton Return = new JButton("Return");
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
class Settings{
	int gap, match, mismatch;
	public Settings(int i, int j, int v) {
		gap=i;
		match =j;
		mismatch=v;
	}
}
