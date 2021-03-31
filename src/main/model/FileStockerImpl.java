package main.model;

import java.io.File;

import main.service.entry.EntryPersonalized;

public class FileStockerImpl implements FileStocker {

	private static FileStockerImpl instance;
	
	private File[] files;
	
	private FileStockerImpl() {
		
	}
	
	public static FileStocker getInstance() {
		if( instance == null ) {
			instance = new FileStockerImpl();
		}
		
		return instance;
	}
	
	@Override
	public void loadFiles(File[] files) {
		this.files = files;
	}

	@Override
	public EntryPersonalized<String, Double>[] generalCalculation() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public EntryPersonalized<String, Double>[] individualCalculation(File file) {
		// TODO Auto-generated method stub
		return null;
	}

}
