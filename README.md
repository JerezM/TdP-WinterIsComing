# Winter is Coming

La aplicación “Winter is Coming” calcula cuales son las 5 palabras más usadas de un conjunto de archivos de texto.
La aplicación cuanta con un botón “Cargar Directorio” el cual permite indicar el directorio donde se encuentran los archivos de texto.
Luego, al clickear un botón con la etiqueta “Comenzar”, calculará las 5 palabras más usadas y las mostrará en pantalla. Junto a cada palabra se mostrará que
porcentaje, de todas las palabras contadas, representa esa palabra. La aplicación mostrará una lista de todos los archivos de textos encontrados y el usuario
va a poder seleccionar un archivo de esa listas y en ese caso se mostrarán las 5 palabras más usadas de ese archivo solamente. Tambien se permite poder volver a ver
las 5 palabras más usadas del conjunto de archivos.

La aplicación “Winter is Coming” también posee una opción para elegir el idioma de los textos que aparezcan en pantalla, las opciones son “Español” e “Inglés”.
Si el usuario selecciona “Inglés” todos los textos de los botones, pantalla, etc, aparecerán en inglés. Si el usuario selecciona “Español” todos los textos
aparecerán en español. Los cambios se veran reflejados luego de la selección del idioma.


## Consideraciones:
* La lista de archivos analizados se visualizara una vez se presione el boton comenzar.
* Dos palabras, cuya única diferencia sea el uso de mayúsculas, se tratarán como la misma palabra. Esto es, si se encuentra “Tecnología” y “tecnología”, se contará
como 2 apariciones de la palabra “tecnología”. Sin embargo, si la diferencia está en el uso de los acentos (o no uso), se tratarán como palabras diferentes. 
Por ejemplo, si se tiene “Tecnología” y “tecnologia”, esto contará como 1 aparición de “Tecnología” y 1 aparición de “tecnología”. Sólo se deberán tener en cuenta
archivos con extensión.txt.
