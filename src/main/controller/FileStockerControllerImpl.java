package main.controller;

import java.io.File;

import main.model.FileStocker;
import main.model.FileStockerImpl;

public class FileStockerControllerImpl implements 
			 LoadBtnToFileStockerController, StartBtnToFileStockerController, FileListToFileStockerController {
	
	private static FileStockerControllerImpl instance;
	
	private FileStocker fileStocker;
	
	private FileStockerControllerImpl() {
		this.fileStocker = FileStockerImpl.getInstance();
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
		this.fileStocker.generalCalculation();
		//Consultar la lista de archivos
		//Comunicarse con el JPanel para mostrar los resultados
		//Comunicarse con el FileListPanel para pasarle los archivos que se analizaron
	}

	@Override
	public void individualCalculation(File file) {
		this.fileStocker.individualCalculation(file);
		//Comunicarse con el JPanel para mostrar los resultados del archivo seleccionado
	}

}
