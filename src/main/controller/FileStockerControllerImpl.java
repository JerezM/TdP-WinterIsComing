package main.controller;

import java.io.File;

import main.model.FileStocker;
import main.model.FileStockerImpl;
import main.service.entry.EntryPersonalized;
import main.view.paneles.FileListPanelImpl;
import main.view.paneles.FileListPanel;
import main.view.paneles.TopFivePanel;
import main.view.paneles.TopFivePanelImpl;

public class FileStockerControllerImpl implements 
			 LoadBtnToFileStockerController, StartBtnToFileStockerController, FileListToFileStockerController {
	
	private static FileStockerControllerImpl instance;
	
	private FileStocker fileStocker;
	private TopFivePanel topFivePanel;
	//private FileListPanel fileListPanel; 
	
	private FileStockerControllerImpl() {
		this.fileStocker = FileStockerImpl.getInstance();
		
		this.topFivePanel = TopFivePanelImpl.getInstance();
		//this.fileListPanel = (FileListPanel) FileListPanelImpl.getInstance();
	}
	
	public static FileStockerControllerImpl getInstance() {
		if( instance == null ) {
			instance = new FileStockerControllerImpl();
		}
		
		return instance;
	}

	@Override
	public void loadFiles(File[] files) {
		this.fileStocker.loadFiles(files);
	}

	@Override
	public void generalCalculation() {
		EntryPersonalized<String, Double>[] topWords = this.fileStocker.generalCalculation();
		
		String[] topWordsString = new String[5];
		for (int i = 0; i < topWords.length; i++) {
			EntryPersonalized<String, Double> entry = topWords[i];
			topWordsString[i] = (entry.getKey()+": "+entry.getValue()+"%");
		}
		
		this.topFivePanel.loadTopFive(topWordsString);
		
		//File[] files = this.fileStocker.getFiles();
		//fileListPanel.loadFiles(files);
	}

	@Override
	public void individualCalculation(File file) {
		EntryPersonalized<String, Double>[] topWords = this.fileStocker.individualCalculation(file);
		
		String[] topWordsString = new String[5];
		for (int i = 0; i < topWords.length; i++) {
			EntryPersonalized<String, Double> entry = topWords[i];
			topWordsString[i] = (entry.getKey()+": "+entry.getValue()+"%");
		}
		
		this.topFivePanel.loadTopFive(topWordsString);
	}

}
