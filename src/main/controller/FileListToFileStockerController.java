package main.controller;

import java.io.File;

public interface FileListToFileStockerController {

	/**
	 * Se encarga de calcular cuales son las 5 palabras mas utilizadas en el archivo seleccionado,
	 * junto con su porcentaje de aparicion respectivo.
	 * 
	 * @param file Archivo que se desea analizar.
	 */
	public void individualCalculation(File file);
}
