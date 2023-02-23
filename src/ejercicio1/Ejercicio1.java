package ejercicio1;

import java.util.Scanner;

public class Ejercicio1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String[] equipos = { "Almería", "Athletic de Bilbao", "Atlético de Madrid", "Barcelona", "Betis", "Cádiz",
				"Celta", "Elche", "Espanyol", "Getafe", "Girona", "Mallorca", "Osasuna", "Real Sociedad",
				"Rayo Vallecano", "Real Madrid", "Valladolid", "Sevilla", "Valencia", "Villarreal" };
		String[] entrenadores = { "Rubi", "Ernesto Valverde", "Simeone", "Xavi", "Pellegrini", "Sergio González",
				"Carlos Carvahal", "Machín", "Diego Martínez", "Quique Sánchez Flores", "Míchel", "Javier Aguirre",
				"Jagoba Arrasate", "Imanol Alguacil", "Andoni Iraola", "Ancelotti", "Pacheta", "Sampaoli", "Voro",
				"Quique Setién" };
		int[] posiciones = { 15, 7, 4, 1, 5, 16, 14, 20, 17, 19, 11, 10, 9, 3, 6, 2, 13, 12, 18, 8 };
		int[] posicionesOrdenadas = new int[20];
		Scanner scanner = new Scanner(System.in);

		String equipo;
		String entrenador;
		int posicionPalabra, posicionNumero;
		Scanner lector = new Scanner(System.in);
		int opcion = 0;
		int cambios = 0;
		int newPosicion;

		do {

			System.out.println("*****************************************");
			System.out.println("*****    Elige una opción:          *****");
			System.out.println("*****    1. Buscar un equipo        *****");
			System.out.println("*****    2. Buscar un entrenador    *****");
			System.out.println("*****    3. Ver la clasificación    *****");
			System.out.println("*****    4. Modificar los datos     *****");
			System.out.println("*****    5. Salir                   *****");
			System.out.println("*****************************************");
			System.out.println("***  Marca el número que corresponda: ***");

			opcion = scanner.nextInt();
			scanner.nextLine();

			switch (opcion) {
			case 1: // buscar la posición de un equipo

				System.out.println("Elige un equipo: ");
				equipo = lector.nextLine();

				posicionPalabra = Funcionalidades.buscarPalabra(equipo, equipos);
				if (posicionPalabra == -1) {
					System.out.println("Introduce un equipo de La Liga Santander.");
				} else {
					System.out.println("El " + equipo + " está en la posición " + posiciones[posicionPalabra] + "º.");
				}
				break;

			case 2: // buscar un entrenador
				System.out.println("Elige un entrenador: ");
				entrenador = lector.nextLine();

				posicionPalabra = Funcionalidades.buscarPalabra(entrenador, entrenadores);
				if (posicionPalabra == -1) {
					System.out.println("Introduce un entrenador de un equipo de La Liga Santander.");
				} else {
					System.out.println(entrenador + " es el entrenador del " + equipos[posicionPalabra] + ", que va "
							+ posiciones[posicionPalabra] + "º de la Liga Santander.");
				}
				break;

			case 3: // consultar la clasificación general
				System.out.println("La Liga está así: ");

				for (int i = 0; i < posicionesOrdenadas.length; i++) {

					posicionNumero = Funcionalidades.buscarNumero(i + 1, posiciones);

					System.out.println(i + 1 + "º - " + equipos[posicionNumero]);
				}
				break;

			case 4: // menú para realizar cambios
				do {
					System.out.println("**************************************************");
					System.out.println("*****  ¿Qué cambios quieres hacer?           *****");
					System.out.println("*****  1. Cambiar un entrenador cesado.      *****");
					System.out.println("*****  2. Cambiar la posición de un equipo.  *****");
					System.out.println("*****  3. Cambiar a un equipo descendido.    *****");
					System.out.println("*****            4. Salir.                   *****");
					System.out.println("**************************************************");
					System.out.println("*****  Marca el número que corresponda:      *****");

					cambios = scanner.nextInt();
					scanner.nextLine();

					switch (cambios) {
					case 1:// cambiar un entrenador

						System.out.println("¿Qué entrenador cesado quieres cambiar?");
						entrenador = scanner.nextLine();

						posicionPalabra = Funcionalidades.buscarPalabra(entrenador, entrenadores);
						if (posicionPalabra == -1) {
							System.out.println("Introduce un entrenador de La Liga Santander.");
						} else {
							System.out.println("¿Qué entrenador va a sustituirle?");
							entrenador = scanner.nextLine();
							entrenadores[posicionPalabra] = entrenador;
							System.out.println("Entrenador actualizado correctamente");
						}
						break;

					case 2:// cambiar de posición un equipo

						System.out.println("¿Qué equipo quieres cambiar de posición?");
						equipo = scanner.nextLine();

						posicionPalabra = Funcionalidades.buscarPalabra(equipo, equipos);
						if (posicionPalabra == -1) {
							System.out.println("Introduce un equipo de La Liga Santander");
						} else {
							System.out.println("¿En qué nuevo puesto va el " + equipo + "?");
							newPosicion = scanner.nextInt();
							posiciones[posicionPalabra] = newPosicion;
							System.out.println("Posición actualizada correctamente");
						}
						break;

					case 3:// cambiar los tres equipos descendidos
						System.out.println("Estos son los equipos que descendieron el año pasado: ");
						for (int i = 17; i < posicionesOrdenadas.length; i++) {

							posicionNumero = Funcionalidades.buscarNumero(i + 1, posiciones);
							System.out.println(i + 1 + "º - " + equipos[posicionNumero]);
						}
						System.out.println("¿Qué equipo quieres sustituir?");
						equipo = scanner.nextLine();

						posicionPalabra = Funcionalidades.buscarPalabra(equipo, equipos);
						if (posicionPalabra == -1) {
							System.out.println("Introduce un equipo de La Liga Santander.");
						} else {
							System.out.println("¿Qué equipo va a sustituir a " + equipo + "?");
							equipo = scanner.nextLine();
							equipos[posicionPalabra] = equipo;
							System.out.println("Equipo actualizado correctamente");
						}
						break;

					case 4:
						break;

					}
				} while (opcion != 4);

			case 5:
				break;

			default:
				System.out.println("Introduce un número entre el 1 y el 5 para realizar una acción:");
				break;
			}

		} while (opcion != 5);

		System.out.println("Saliste del programa");
		scanner.close();
		lector.close();
	}

}
