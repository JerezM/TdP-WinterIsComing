package main.view.buttons;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import main.controller.FileStockerControllerImpl;
import main.controller.StartBtnToFileStockerController;

@SuppressWarnings("serial")
public class StartBtn extends JButton implements ActionListener {

	private StartBtnToFileStockerController fileStockerController;
	
	public StartBtn() {
		this.setText("Comenzar");
        this.addActionListener(this);
		
		fileStockerController = FileStockerControllerImpl.getInstance();
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		fileStockerController.generalCalculation();
	}

}
