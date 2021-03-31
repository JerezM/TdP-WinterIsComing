package main.controller;

import java.io.File;

public interface LoadBtnToFileStockerController {

	/**
	 * Se encarga de cargar todos los archivos pasados por parametro.
	 * @param files Archivos a cargar.
	 */
	public void loadFiles(File[] files);
	
}
