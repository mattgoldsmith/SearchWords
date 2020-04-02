package searchWord;

import java.util.ArrayList;

public class Controller {
	private SearchWords search;
	private GUI gui;
	private ButtonActions actions;
	private ArrayList<Integer> lengths;
	
	public Controller(){
		search = new SearchWords();
		gui = new GUI();
		actions = new ButtonActions();
	}
	

	public void startController(){
		//Start the GUI
		lengths = search.getLengths();
		gui.startGUI(lengths);
		
		//Add the Actions to the buttons
		actions.newWord(search, gui);
		actions.confirmLength(search, gui);
	}

}
