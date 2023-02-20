package ejercicio1;

public class Funcionalidades {

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
