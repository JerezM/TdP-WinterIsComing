package main.view.paneles;

public interface TopFivePanel {

	/**
	 * Muestra el top 5 de palabras mas utilizadas pasadas por parametro en pantalla.
	 * @param words Arreglo con las palabras elegidas.
	 */
	public void loadTopFive(String[] words);
}
