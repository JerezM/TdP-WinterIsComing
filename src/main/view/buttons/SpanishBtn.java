package main.view.buttons;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import main.service.language_changer.LanguageChanger;
import main.view.GUI;

@SuppressWarnings("serial")
public class SpanishBtn extends JButton implements ActionListener {
	
	private static final LanguageChanger languageChanger = GUI.getInstance();
	
	public SpanishBtn() {
		this.setText("Español");
        this.addActionListener(this);
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		languageChanger.changeToSpanish();
	}

}
