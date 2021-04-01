package main.view.paneles;

import java.io.File;

import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

@SuppressWarnings("serial")
public class FileListPanelImpl extends JPanel implements ListSelectionListener, FileListPanel {
	private static FileListPanelImpl instance;
	
	private JList<File> fileList;
	
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
		DefaultListModel<File> model = new DefaultListModel<File>();
		for (int i = 0; i < files.length; i++) {
			model.addElement(files[i]);
		}
		
		this.fileList = new JList<File>(model);
		this.add(fileList);
	}
	
	@Override
	public void valueChanged(ListSelectionEvent e) {
		// TODO Auto-generated method stub
		
	}

}
