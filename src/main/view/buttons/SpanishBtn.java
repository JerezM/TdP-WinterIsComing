package main.view.buttons;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import main.service.language_changer.LanguageChanger;

@SuppressWarnings("serial")
public class SpanishBtn extends JButton implements ActionListener {
	
	private LanguageChanger languageChanger;
	
	public SpanishBtn(LanguageChanger lc) {
		this.setText("Español");
        this.addActionListener(this);
        this.languageChanger = lc;
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		languageChanger.changeToSpanish();
	}

}
