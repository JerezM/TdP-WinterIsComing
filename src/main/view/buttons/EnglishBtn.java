package main.view.buttons;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import main.service.language_changer.LanguageChanger;

@SuppressWarnings("serial")
public class EnglishBtn extends JButton implements ActionListener {
	
	private LanguageChanger languageChanger;
	
	public EnglishBtn(LanguageChanger lc) {
		this.setText("Ingles");
        this.addActionListener(this);
        
        this.languageChanger = lc;
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		languageChanger.changeToEnglish();
	} 
	
}
