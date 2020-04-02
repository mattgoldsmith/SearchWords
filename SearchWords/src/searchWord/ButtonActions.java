package searchWord;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ButtonActions {
	
	public ButtonActions(){
		
	}
	
	//Add the action for the new word button
	public void newWord(SearchWords search, GUI gui){
		gui.getNewWordButton().addActionListener(new ActionListener() { 
			public void actionPerformed(ActionEvent e) {
				  gui.newWord(search.getLengths());
				  confirmLength(search,gui);
			} 
		} );
	}
	
	//Add the action for the confirm length button
	public void confirmLength(SearchWords search, GUI gui){
		gui.getLengthConfirmButton().addActionListener(new ActionListener() { 
			  public void actionPerformed(ActionEvent e) {
				  search.filterByLength(gui.getSelectedLength());
				  gui.chooseLetters(gui.getSelectedLength());
				  confirmLetters(search,gui);
			  } 
			} );
	}
	
	//Add the action for the confirm letters button
	public void confirmLetters(SearchWords search, GUI gui){
		gui.getLettersConfirmButton().addActionListener(new ActionListener() { 
			  public void actionPerformed(ActionEvent e) {
				  search.filterByLetters(gui.getLettersHash());
				  gui.showWords(search.getFilteredWords());
			  } 
			} );
	}

}
