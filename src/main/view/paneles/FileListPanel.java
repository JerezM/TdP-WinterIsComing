package main.view.paneles;

import java.io.File;

public interface FileListPanel {

	/**
	 * Carga los archivos parametrizados en pantalla.
	 * @param files Archivos a cargar.
	 */
	public void loadFiles(File[] files);
}
