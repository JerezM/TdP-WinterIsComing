package main.view.paneles;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import main.controller.FileListToFileStockerController;

@SuppressWarnings("serial")
public class FileListPanelImpl extends JPanel implements ListSelectionListener, FileListPanel {
	private static FileListPanelImpl instance;
	
	private FileListToFileStockerController fileStockerController;
	
	private JList<String> fileList;
	private Map<String, File> fileMap;
	
	private FileListPanelImpl() {
	
	}
	
	public static FileListPanelImpl getInstance() {
		if( instance == null ) {
			instance = new FileListPanelImpl();
		}
		
		return instance;
    }
	
	@Override
	public void loadFiles(File[] files) {
		this.fileMap = new HashMap<String, File>();
		String[] fileNameArray = new String[ files.length ];
		
		for (int i = 0; i < files.length; i++) {
			
			File actualFile = files[i];
			String fileName = actualFile.getName();
			
			this.fileMap.put(fileName, actualFile);
			fileNameArray[i] = fileName;
			
		}
		
		this.fileList = new JList<String>(fileNameArray);
		this.fileList.setBounds(10, 70, 100, 300);
		this.fileList.addListSelectionListener(this);
		this.add( this.fileList );
	}
	
	@Override
	public void valueChanged(ListSelectionEvent e) {
		
		if (!e.getValueIsAdjusting()) {
            String fileNameSelected = this.fileList.getSelectedValue().toString();
            
            File fileSelected = this.fileMap.get(fileNameSelected);
            this.fileStockerController.individualCalculation(fileSelected);
        }
		
	}

	@Override
	public void loadController(FileListToFileStockerController fileStockerController) {
		this.fileStockerController = fileStockerController;
	}

}
