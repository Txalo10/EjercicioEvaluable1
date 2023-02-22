package ejercicio1;

public class Funcionalidades {

	/*@author: Gonzalo Alejándrez Andión
	 * @param palabra: define el dato, string en este caso, que se va a buscar 
	 * @param arrayPalabras: define el array en el que se va a buscar el string
	 * @return resultado: nos va a dar la posición dentro del array que ocupa el string que hemos buscado
	 * @version: 22.02.2023
	 */
	
	public static int buscarPalabra(String palabra, String[] arrayPalabras) {

		int resultado = -1;
		boolean encontrado = false;
		int contador = 0;

		do {
			if (arrayPalabras[contador].equals(palabra)) {
				encontrado = true;
				resultado = contador;
			}
			contador++;
		} while (contador < arrayPalabras.length && !encontrado);
		return resultado;
	}

	
	/*@author: Gonzalo Alejándrez Andión
	 * @param numero: define el dato, int en este caso, que se va a buscar 
	 * @param arrayNumeros: define el array en el que se va a buscar el número
	 * @return resultado: nos va a dar la posición dentro del array que ocupa el número que hemos buscado
	 * @version: 22.02.2023
	 */
	
	public static int buscarNumero(int numero, int[] arrayNumeros) {
		int resultado = -1;
		boolean encontrado = false;
		int contador = 0;

		do {
			if (arrayNumeros[contador] == (numero)) {
				encontrado = true;
				resultado = contador;
			}
			contador++;
		} while (contador < arrayNumeros.length && !encontrado);
		return resultado;

	}
	
	

	
	
	
	
	
	
}
