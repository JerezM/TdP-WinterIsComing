package main.view.paneles;

import java.io.File;

import main.controller.FileListToFileStockerController;

public interface FileListPanel {

	/**
	 * Carga los archivos parametrizados en pantalla.
	 * @param files Archivos a cargar.
	 */
	public void loadFiles(File[] files);
	
	/**
	 * Se encarga de cargar el controller parametrizado a la clase.
	 * @param fileStockerController controller a cargar.
	 */
	public void loadController(FileListToFileStockerController fileStockerController);

}
