package main.model;

import java.io.File;

import main.service.entry.EntryPersonalized;

public interface FileStocker {
	
	/**
	 * Se encarga de almacenar todos los archivos pasados por parametro.
	 * @param files Archivos a almacener.
	 */
	public void loadFiles(File[] files);
	
	/**
	 * Se encarga de calcular cuales son las 5 palabras mas utilizadas en todos los archivos analizados,
	 * junto con su porcentaje de aparicion respectivo.
	 * 
	 * @return Un arreglo de entradas<Palabra, Porcentaje> el cual contendra las 5 palabras mas utilizadas.
	 */
	public EntryPersonalized<String, Double>[] generalCalculation();
	
	/**
	 * Se encarga de calcular cuales son las 5 palabras mas utilizadas en el archivo seleccionado,
	 * junto con su porcentaje de aparicion respectivo.
	 * 
	 * @param file Archivo que se desea analizar.
	 * @return Un arreglo de entradas<Palabra, Porcentaje> el cual contendra las 5 palabras mas utilizadas.
	 */
	public EntryPersonalized<String, Double>[] individualCalculation(File file);
}
