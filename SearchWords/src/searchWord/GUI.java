package searchWord;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.GraphicsEnvironment;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class GUI {
	
	private JFrame frame;

	private GraphicsEnvironment ge;
	private Font f;
	private Font fb;
	
	private GridBagLayout gbl;
	private GridBagConstraints c;
	
	private JPanel topPanel;
	private JPanel bottomPanel;
	
	private JPanel wordLength;
	private JPanel lengthNumber;
	private JPanel confirm;
	
	private JPanel letters;
	private JPanel confirmLetters;
	
	private JLabel wordLengthLabel;
	private JLabel enterLettersTop;
	private JLabel enterLettersBottom;
	
	private JButton lengthConfirmButton;
	private JButton newWordButton;
	private JButton lettersConfirmButton;
	
	private JComboBox<Integer> lengthDD;
	
	private Dimension dim;
	private Dimension top;
	private Dimension button;
	private Dimension mid;
	private Dimension id;
	
	private HashMap<Integer,JTextField> hash;
	
	public GUI(){
		
	}
	
	public void startGUI(ArrayList<Integer> lengths){
		
		//Create Dimension
		Dimension td = new Dimension(); //Top panel dimension
		td.setSize(500, 400);
		
		Dimension bd = new Dimension(); //Bottom panel dimension
		bd.setSize(500, 100);
		
		button = new Dimension(); //New word button dimension
		button.setSize(200, 25);
		
		top = new Dimension();
		top.setSize(500,100);
		
		mid = new Dimension(); //Middle interior dimension
		mid.setSize(500, 250);
		
		id = new Dimension(); //Interior dimension
		id.setSize(500, 50);
		
		BorderFactory.createLineBorder(Color.BLACK);
		
		//Create Font
		try {
		     ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
		     ge.registerFont(Font.createFont(Font.TRUETYPE_FONT, new File("src/Dictionary/OpenSans-Regular.ttf")));
		} catch (IOException|FontFormatException e) {
		     //Handle exception
			e.printStackTrace();
		}
		
		f = new Font("Open Sans",Font.PLAIN,25);
		fb = new Font("Open Sans",Font.PLAIN,20);
		
		//Create Layout
		gbl = new GridBagLayout();
		c = new GridBagConstraints();
		
		//Configure the layout
		c.gridx = 0;
		c.gridy = 0;
		//c.anchor = GridBagConstraints.CENTER;
		
		//Create Frame
		frame = new JFrame("Word Searcher");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//frame.setPreferredSize(td);
		
		JFrame.setDefaultLookAndFeelDecorated(true);
		
		
		//Create Components		
		/**Create Panels**/
		topPanel = new JPanel();
		topPanel.setLayout(gbl);
		//topPanel.setBorder(border);
		topPanel.setPreferredSize(td);
		
		bottomPanel = new JPanel();
		bottomPanel.setLayout(gbl);
		//bottomPanel.setBorder(border);
		bottomPanel.setPreferredSize(bd);
		
		/**Create Buttons**/
		newWordButton = new JButton();
		newWordButton.setText("New Word");
		newWordButton.setPreferredSize(button);
		newWordButton.setFont(fb);
		
		//Add components to panels
		bottomPanel.add(newWordButton, c);
		
		newWord(lengths);
		
		//Add components to Frame
		frame.getContentPane().add(topPanel, BorderLayout.NORTH);
		
		c.gridy = 1;
		frame.getContentPane().add(bottomPanel, BorderLayout.SOUTH);
		
		//Pack and show the Frame
		frame.pack();
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
	}
	
	public void newWord(ArrayList<Integer> lengths){
		topPanel.removeAll();
		
		c.gridx = 0;
		c.gridy = 0;
		
		/**Create interior panels**/
		wordLength = new JPanel();
		wordLength.setPreferredSize(top);
		//wordLength.setBorder(border);
		wordLength.setLayout(gbl);
		 
		lengthNumber = new JPanel();
		lengthNumber.setPreferredSize(mid);
		//lengthNumber.setBorder(border);
		lengthNumber.setLayout(gbl);
		
		confirm = new JPanel();
		confirm.setPreferredSize(id);
		//confirm.setBorder(border);
		confirm.setLayout(gbl);
		
		/**Create Buttons**/
		/*newWordButton = new JButton();
		newWordButton.setText("New Word");
		newWordButton.setPreferredSize(button);*/
		
		lengthConfirmButton = new JButton();
		lengthConfirmButton.setText("Confirm");
		lengthConfirmButton.setPreferredSize(button);
		lengthConfirmButton.setFont(fb);
		
		/**Create Labels**/
		wordLengthLabel = new JLabel("Word Length:", SwingConstants.CENTER);
		wordLengthLabel.setPreferredSize(top);
		//wordLengthLabel.setBorder(border);
		wordLengthLabel.setFont(f);
		
		/**Create Drop-down**/
		Collections.sort(lengths);

		Integer[] lengthList = lengths.toArray(new Integer[lengths.size()]);
		
		lengthDD = new JComboBox<Integer>(lengthList);
		
		lengthDD.setPreferredSize(button);
		lengthDD.setFont(fb);
		
		/**Add interior panels to top panel**/
		topPanel.add(wordLength, c);
			c.gridy++;
		topPanel.add(lengthNumber, c);
			c.gridy++;
		topPanel.add(confirm, c);
		
		/**Add components to interior panels**/
		c.gridx = 0;
		c.gridy = 0;
		wordLength.add(wordLengthLabel, c);
		
		lengthNumber.add(lengthDD, c);
		
		confirm.add(lengthConfirmButton, c);
		
		topPanel.revalidate();
		topPanel.repaint();
	}
	
	public void chooseLetters(int length){
		/*lengthNumber.setVisible(false);
		confirm.setVisible(false);
		wordLengthLabel.setVisible(false);*/
		topPanel.removeAll();
		
		dim = new Dimension(); //Top and bottom interior panel dimension
		dim.setSize(500, 50);
		
		top = new Dimension();
		top.setSize(500, 100);
		
		Dimension label = new Dimension(); //label interior panel dimension
		label.setSize(500, 50);
		
		mid = new Dimension();
		mid.setSize(500, 250);
		
		button = new Dimension(); //New word button dimension
		button.setSize(200, 25);
		
		Dimension textBox = new Dimension(); //Textbox dimension
		textBox.setSize(40, 40);
		
		BorderFactory.createLineBorder(Color.BLACK); 
		
		enterLettersTop = new JLabel("Please enter known letters", SwingConstants.CENTER);
		enterLettersTop.setPreferredSize(label);
		//enterLettersTop.setBorder(border);
		enterLettersTop.setFont(f);
		
		enterLettersBottom = new JLabel("(leave unknown letters blank)", SwingConstants.CENTER);
		enterLettersBottom.setPreferredSize(label);
		//enterLettersBottom.setBorder(border);
		enterLettersBottom.setFont(f);
		
		letters = new JPanel();
		letters.setPreferredSize(mid);
		//letters.setBorder(border);
		letters.setLayout(gbl);
		
		confirmLetters = new JPanel();
		confirmLetters.setPreferredSize(dim);
		//confirmLetters.setBorder(border);
		confirmLetters.setLayout(gbl);
		
		lettersConfirmButton = new JButton();
		lettersConfirmButton.setText("Confirm");
		lettersConfirmButton.setPreferredSize(button);
		lettersConfirmButton.setFont(fb);
		
		/*JTextField text = new JTextField();
		text.setPreferredSize(textBox);*/
		
		hash = new HashMap<Integer,JTextField>();
		
		int i = 0;
		c.gridx = 0;
		c.gridy = 0;
		
		while(i < length){
			JLabel numLabel = new JLabel(Integer.toString(i + 1));
			numLabel.setSize(textBox);
			numLabel.setFont(f);
			
			letters.add(numLabel, c);
			
			c.gridy++;
			
			JTextField text = new JTextField();
			text.setPreferredSize(textBox);
			text.setFont(f);
			
			//Limit the number of letters to 1
			text.addKeyListener(new KeyAdapter() {
			    public void keyTyped(KeyEvent e) { 
			        if (text.getText().length() >= 1 ) // limit text field to 1 characters
			            e.consume(); 
			    }  
			});
			
			//Store the text boxes
			hash.put(i+1, text);
			
			letters.add(text,c);
			
			c.gridx++;
			c.gridy--;
			
			if(c.gridx % 10 == 0){
				c.gridy = c.gridy + 2;
				c.gridx = 0;
			}
			
			i++;
		}
		
		c.gridx = 0;
		c.gridy = 0;
		
		topPanel.add(enterLettersTop, c);
		confirmLetters.add(lettersConfirmButton,c);
		//letters.add(text,c);
		
		c.gridy++;
		
		topPanel.add(enterLettersBottom, c);
		
		c.gridy++;
		
		topPanel.add(letters, c);
		
		c.gridy++;
		
		topPanel.add(confirmLetters, c);
		
		topPanel.revalidate();
		topPanel.repaint();
		
	}
	
	public void showWords(ArrayList<String> words){
		topPanel.removeAll();
		
		//Create Dimension
		Dimension dimLabel = new Dimension(); //Top panel dimension
		dimLabel.setSize(500, 100);
		
		Dimension dimScroll = new Dimension(); //Top panel dimension
		dimScroll.setSize(500, 300);
		
		//Display the number of words found
		JLabel wordsNumberLabel = new JLabel("", SwingConstants.CENTER);
		wordsNumberLabel.setFont(f);
		if(words.size() != 1){
			wordsNumberLabel.setText(words.size() + " words found");
		}
		else{
			wordsNumberLabel.setText(words.size() + " word found");
		}
		wordsNumberLabel.setPreferredSize(dimLabel);
		//wordsNumberLabel.setBorder(border);
		
		//Add the list of words to a JLabel (first 100 only)
		JLabel wordList = new JLabel("<html>");
		wordList.setFont(f);
		if(words.size() > 100){
			wordList.setText(wordList.getText() + "Only the first 100 words will appear <br>");
		}
		int i = 0;
		for(String word : words){
			wordList.setText(wordList.getText() + word + "<br>");
			i++;
			if(i == 100 || i == words.size()){
				wordList.setText(wordList.getText() + "</html>");
			}
			if(i >= 100){
				break;
			}
		}
		
		System.out.println(wordList.getText());
		
		wordList.setPreferredSize(wordList.getPreferredSize());
		System.out.println(wordList.getPreferredSize());
		
		JScrollPane pane = new JScrollPane(wordList);
		pane.setPreferredSize(dimScroll);
		//pane.setBorder(border);
		
		c.gridx = 0;
		c.gridy = 0;
		
		topPanel.add(wordsNumberLabel, c);
		c.gridy++;
		topPanel.add(pane, c);
		
		topPanel.revalidate();
		topPanel.repaint();
	}
	
	//Get new word button
	public JButton getNewWordButton(){
		return newWordButton;
	}
	
	//Get length choices
	public JButton getLengthConfirmButton(){
		return lengthConfirmButton;
	}
	
	public int getSelectedLength(){
		int i = lengthDD.getItemAt(lengthDD.getSelectedIndex());
		return i;
	}
	
	//Get letter choices
	public HashMap<Integer,JTextField> getLettersHash(){
		return hash;
	}
	
	public JButton getLettersConfirmButton(){
		return lettersConfirmButton;
	}

}
