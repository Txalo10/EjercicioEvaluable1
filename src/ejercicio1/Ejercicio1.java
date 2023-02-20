package ejercicio1;
import java.awt.Menu;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Scanner;


public class Ejercicio1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		//*INICIO PROGRAMA
		String[] equipos = {"Almería", "Athletic de Bilbao", "Atlético de Madrid", "Barcelona", "Betis", "Cádiz", "Celta", "Elche", "Espanyol", "Getafe", "Girona", "Mallorca", "Osasuna", "Real Sociedad", "Rayo Vallecano", "Real Madrid", "Valladolid", "Sevilla", "Valencia", "Villarreal"};
		String[] entrenadores = {"Rubi", "Ernesto Valverde", "Simeone", "Xavi", "Pellegrini", "Sergio González", "Carlos Carvahal", "Machín", "Diego Martínez", "Quique Sánchez Flores", "Míchel", "Javier Aguirre", "Jagoba Arrasate", "Imanol Alguacil", "Andoni Iraola", "Ancelotti", "Pacheta", "Sampaoli", "Voro", "Quique Setién"};
		int [] posiciones = {15, 7, 4, 1, 5, 16, 14, 20, 17, 19, 11, 10, 9, 3, 6, 2, 13, 12, 18, 8};
		int[] posicionesOrdenadas=new int[20];
		
		Scanner scanner=new Scanner(System.in);
		
				
		//variables búsqueda de posición
		String equipo;
		String entrenador;
		int contador, posicionPalabra, posicionNumero;
		int longitud=equipos.length;
		Scanner lector=new Scanner(System.in);
		//fin variables busqueda posición
		int opcion=0;
		int cambios=0;
		boolean modificado;
		String modPosicion;
		int newPosicion;
	
		do {
			
			System.out.println("Elige una opción: ");
			System.out.println("1. Buscar un equipo");
			System.out.println("2. Buscar un entrenador");
			System.out.println("3. Ver la clasificación");
			System.out.println("4. Modificar los datos");//dentro de este metemos las opciones de añadir, borrar, editar
			System.out.println("5. Salir");
			System.out.println("Marque el número que corresponda: ");
			
			opcion=scanner.nextInt();
			
			switch (opcion) {
			case 1:
				
				System.out.println("Elige un equipo: ");
				equipo = lector.nextLine();
				
				posicionPalabra=Funcionalidades.buscarPalabra(equipo, equipos);
				if (posicionPalabra==-1) {
					System.out.println("Introduce un equipo de La Liga Santander.");
				}else {
					System.out.println("El " + equipo + " está en la posición " + posiciones[posicionPalabra] + "º.");

				}

				break;
			
			case 2:
				System.out.println("Elige un entrenador: ");
				entrenador = lector.nextLine();
				
				posicionPalabra=Funcionalidades.buscarPalabra(entrenador, entrenadores);
				if (posicionPalabra==-1) {
					System.out.println("Introduce un entrenador de un equipo de La Liga Santander.");
				}else {
					System.out.println(entrenador + " es el entrenador del " + equipos[posicionPalabra] + ", que va " + posiciones[posicionPalabra] + "º de la Liga Santander.");

				}
				
				break;
			
			case 3: 
				System.out.println("La Liga está así: ");
				/*hemos quitado el .sort porque no nos hace falta ordenar el array
				 * seguimos el orden a través del bucle for
				 * entramos en el bucle en la posición 0, pero como nunca vamos a buscar esa posición ponemos i+1
				 */

				for(int i=0; i<posicionesOrdenadas.length; i++) {
					
					posicionNumero=Funcionalidades.buscarNumero(i+1, posiciones);
					
					System.out.println(i+1 + "º - " + equipos[posicionNumero]);
				}

				
				break;
				
			case 4:
				
				System.out.println("¿Qué cambios quieres hacer? ");
				System.out.println("1. Cambiar un entrenador cesado.");
				System.out.println("2. Cambiar la posición de un equipo.");
				System.out.println("3. Salir.");
				
				cambios=scanner.nextInt();
				scanner.nextLine();//siempre que tengamos un nextInt hay que meter un nextLine para que lo pare
				
				switch (cambios) {
				case 1: 
			
					System.out.println("¿Qué entrenador cesado quieres cambiar?");
					entrenador=scanner.nextLine();
					
					posicionPalabra=Funcionalidades.buscarPalabra(entrenador, entrenadores);
					if (posicionPalabra==-1) {
						System.out.println("Introduce un entrenador de La Liga Santander.");
					}else {
						System.out.println("¿Qué entrenador va a sustituirle?");
						entrenador=scanner.nextLine();//utilizamos la misma variable todo el rato así optimizamos mucho mejor la memoria
						entrenadores[posicionPalabra]=entrenador;
						System.out.println("Entrenador actualizado correctamente");

					}
					break;
					
				case 2:
					/*contador=0;
					modificado=false;
					System.out.println("¿Qué equipo quieres cambiar de posición?");
					modPosicion=lector.nextLine();

					do {
						if (equipos[contador].equals(modPosicion)) {
							System.out.println("Ingrese la nueva posición del " + equipos[contador] + ":");
							newPosicion=lector.nextInt();
							posiciones[contador]=newPosicion;							
							modificado = true;
						}
						contador++;
					} while (contador < longitud && !modificado);*/
					System.out.println("¿Qué equipo quieres cambiar de posición?");
					equipo=scanner.nextLine();
					
					posicionPalabra=Funcionalidades.buscarPalabra(equipo, equipos);
					if (posicionPalabra==-1) {
						System.out.println("Introduce un equipo de La Liga Santander");
					}else {
						System.out.println("¿En qué nuevo puesto va el " + equipo + "?");
						newPosicion=scanner.nextInt();//utilizamos la misma variable todo el rato así optimizamos mucho mejor la memoria
						posiciones[posicionPalabra]=newPosicion;
						System.out.println("Posición actualizada correctamente");

					}
					break;
					
				case 3: 
					
					break;

				}//fin switch cambios
				
				
				break;
				
			case 5:
				break;
			
			default:
				System.out.println("Introduce un número entre el 1 y el 5 para realizar una acción:");
				break;
			}//final del switch
			
		}while(opcion!=5);
		
		System.out.println("Saliste del programa");
		
	
		
		
	}//final


}
