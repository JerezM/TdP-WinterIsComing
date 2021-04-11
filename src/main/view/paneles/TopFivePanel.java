package main.view.paneles;

public interface TopFivePanel {

	/**
	 * Muestra el top 5 de palabras mas utilizadas pasadas por parametro en pantalla.
	 * @param words Arreglo con las palabras elegidas.
	 */
	public void loadTopFive(String[] words);
	
	/**
	 * Se encarga de cambiar el texto del label contenido en este panel.
	 * @param str nueva texto del label.
	 */
	public void changeLabelLanguage(String str);
	
}
