package main.view.buttons;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.io.File;
import java.io.FilenameFilter;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

import main.controller.FileStockerControllerImpl;
import main.controller.LoadBtnToFileStockerController;
import main.view.GUI;

@SuppressWarnings("serial")
public class LoadDirectoryBtn extends JButton implements ActionListener {
	
	private GUI gui;
	private LoadBtnToFileStockerController fileStockerController;
	
	public LoadDirectoryBtn(GUI gui) {
        this.setText("Cargar Directorio");
        this.addActionListener(this);
        this.gui = gui;
        
        fileStockerController = FileStockerControllerImpl.getInstance();
    }
	
	@Override
	public void actionPerformed(ActionEvent e) {
		this.openFileChooser();
	}
	
	private void openFileChooser() {
		JFileChooser fileChooser = new JFileChooser(".");
        fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        fileChooser.setAcceptAllFileFilterUsed(false);
        int returnVal = fileChooser.showOpenDialog( gui );
        
        if( returnVal == JFileChooser.APPROVE_OPTION) {
        	
        	File directorySelected = fileChooser.getSelectedFile();//devolvera el directorio seleccionado
        	
        	FilenameFilter filter = (dir, name) -> name.endsWith(".txt");//Filtro para seleccionar solo los .txt
        	File[] listOfFiles = directorySelected.listFiles(filter);
        	
        	if ( (listOfFiles.length > 0) && (listOfFiles != null) ) {//Si el directorio seleccionado contenia archivos
        		this.fileStockerController.loadFiles(listOfFiles);
        	}
        	else {
        		System.out.println("El directorio seleccionado no posee archivos de texto.");
        		//this.showMessage("El directorio seleccionado no posee archivos de texto.");
        	}
        	
        }
        else {
        	System.out.println("Ningun directorio seleccionado.");
        }

	}
	
	private void showMessage(String msg) {
		JOptionPane.showInternalMessageDialog(null, msg);
        gui.dispatchEvent( new WindowEvent(gui, WindowEvent.WINDOW_CLOSING) );
	}
}
