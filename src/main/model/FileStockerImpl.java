package main.model;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;

import main.service.entry.EntryImpl;
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
		Map<String, Integer> wordsMap = new HashMap<String, Integer>();
		int totalWords = 0;
		EntryPersonalized<String, Double>[] topWords;
		
			
		for (int i = 0; i < files.length; i++) {//Recorro el arreglo de archivos
        	File actualFile = files[i]; 
        	
			if ( actualFile != null ) {
				totalWords = this.parseFile(actualFile, wordsMap);
			}
					
		}
		
		topWords = this.traverseMap(wordsMap, totalWords);
		
		return topWords;
	}

	@Override
	public EntryPersonalized<String, Double>[] individualCalculation(File file) {
		Map<String, Integer> wordsMap = new HashMap<String, Integer>();
		int totalWords = 0;
		EntryPersonalized<String, Double>[] topWords;
		
		if ( file != null ) {
			totalWords = this.parseFile(file, wordsMap);
		}
		
		topWords = this.traverseMap(wordsMap, totalWords);
		
		return topWords;
	}
	
	/**
	 * Parsea el archivo parametrizado guardando en el mapeo parametrizado las palabras registradas y su cantidad de apariciones. 
	 * A su vez tambien calcula la cantidad de palabras analizadas.
	 * @param file Archivo a parsear.
	 * @param wordsMap Mapeo donde se almacenaran las palabras.
	 * @return Cantidad de palabras analizadas.
	 */
	private int parseFile(File file, Map<String, Integer> wordsMap) {
		int totalWords = 0;
		
		try {
			
			InputStream in = new FileInputStream(file);
			Scanner scn = new Scanner(in);
		
			while( scn.hasNext() ) {//Mientras no haya terminado de leer el archivo.
        	
				if (! scn.hasNext("[[0-9]-[^\\dA-Za-z]]")) {//Si no es un numero o un simbolo
			
					String actualWord = scn.next().toLowerCase().replaceAll("\\p{Punct}", "");
					totalWords++;
					
					Integer wordNumber = wordsMap.get(actualWord);
					wordNumber = (wordNumber == null) ? 1 : (wordNumber +1); 
					
					wordsMap.put(actualWord, wordNumber);
				}
			}
        
			scn.close();
        
		} catch (FileNotFoundException e) {
			 e.printStackTrace();
		}
		
		return totalWords;
	}
	
	/**
	 * Se encarga de recorrer el mapeo y extrar las 5 palabras con mas repeticiones del mismo, para
	 * luego colocarlas en un arreglo para facilitar su lectura.
	 * @param wordsMap Mapeo a recorrer.
	 * @param totalWords cantidad de repeticiones de todas las palabras.
	 * @return Un arreglo de entradas<Palabra, PorcentajeAparicion> con las 5 palabras mas usadas.
	 */
	private EntryPersonalized<String, Double>[] traverseMap(Map<String, Integer> wordsMap, int totalWords) {
		
		@SuppressWarnings("unchecked")
		EntryPersonalized<String, Double>[] topWords =(EntryPersonalized<String, Double>[]) new EntryPersonalized[5];
		
		Iterator<Entry<String, Integer>> mapIterator = wordsMap.entrySet().iterator();
		DecimalFormat df = new DecimalFormat("###.##");
		
		while ( mapIterator.hasNext() ) {
			Entry<String, Integer> actualEntry = mapIterator.next();
			String actualWord = actualEntry.getKey();
			int wordNumber = actualEntry.getValue();
			
			double appearancePercentage = (wordNumber * 100) / totalWords;
			
			appearancePercentage = Double.parseDouble( df.format(appearancePercentage) );//aplica formato al porcentaje
			
			this.checkArray(topWords, actualWord, appearancePercentage);
		}
		
		return topWords;
	}
	
	/**
	 * Recorre el arreglo parametrizado y checkea si la palabra parametrizada puede ser insertada en el arreglo.
	 * De ser asi la misma es insertada, removiendo del arreglo la palabra con menor porcentaje de aparicion.
	 * Obs: De no estar el arreglo lleno, simplemente inserta la palabra en orden descendiente.
	 * @param topWords Arreglo a checkear.
	 * @param word Posible palabra a insertar.
	 * @param appearancePercentage Porcentaje de aparicion de la palabra en/los archivos analizados.
	 */
	private void checkArray(EntryPersonalized<String, Double>[] topWords, String word, double appearancePercentage) {
		
		
		
		boolean wasInserted = false;
		int minorReference = 999;
		for (int i = 0; (i < topWords.length) && (!wasInserted); i++) {
			
			if ( topWords[i] == null) {
				EntryPersonalized<String, Double> entry = new EntryImpl<String, Double>(word, appearancePercentage);
				topWords[i] = entry;
				wasInserted = true;
			}
			else {
				double actualEntryPercentage = topWords[i].getValue();
				
				boolean isTheLast = ( i == (topWords.length -1) );
				
				if (!isTheLast) {//Si no es el ultimo elemento del arreglo
					
					if( topWords[(i +1)] != null ) {//Si la celda siguiente esta llena
						minorReference = this.comparatePercentage(topWords, i, minorReference, 
																 appearancePercentage, actualEntryPercentage);
					}
					
				} else {
					minorReference = this.comparatePercentage(topWords, i, minorReference, 
							 appearancePercentage, actualEntryPercentage);
				}
			}
		}
		
		if (!wasInserted && (minorReference < topWords.length) ) {//Si no se inserto por espacios vacios y es mayor a alguno de los que estan
			EntryPersonalized<String, Double> entry = new EntryImpl<String, Double>(word, appearancePercentage);
			topWords[minorReference] = entry;
		}
	}
	
	/**
	 * Se encarga de analizar si la palabra con el porcentaje de aparicion parametrizado debe ser insertada en el arreglo 
	 * o no, de tener que insertarse, se retornara la referencia a la celda correspondiente.
	 * @param topWords Arreglo en verificacion.
	 * @param index Index actual en el arreglo.
	 * @param minorRef Referencia al menor elemento del arreglo(si no existe el mismo sera mayor a topWords.length)
	 * @param appearancePercentage Porcentaje de aparicion de la palabra analizada en los archivos.
	 * @param entryPercentage Porcentaje de aparicion de la palabra ya ubicada en el arreglo.
	 * @return Referencia al menor elemento del arreglo.
	 */
	private int comparatePercentage(EntryPersonalized<String, Double>[] topWords, int index, int minorRef,
									double appearancePercentage, double entryPercentage) {
		
		if (appearancePercentage > entryPercentage) {
			
			if ( minorRef < topWords.length ) {//Si se uso el minorRef alguna vez
				
				if(entryPercentage < topWords[minorRef].getValue() ) {//Si es la menor de las apariciones
					minorRef = index;
				}
				
			}
			else {
				minorRef = index;
			}
			
		}
		
		return minorRef;
	}
	
	
}
