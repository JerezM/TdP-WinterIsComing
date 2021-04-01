package main.view.buttons;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import main.service.language_changer.LanguageChanger;
import main.view.GUI;

@SuppressWarnings("serial")
public class EnglishBtn extends JButton implements ActionListener {
	
	private static final LanguageChanger languageChanger = GUI.getInstance();
	
	public EnglishBtn() {
		this.setText("Ingles");
        this.addActionListener(this);
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		languageChanger.changeToEnglish();
	} 
	
}
