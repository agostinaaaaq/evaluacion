package evaluacion;

import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class evaluacion {
	
	public static void main(String[] args) {
		
		Scanner entrada = new Scanner(System.in);
	
		String palabras[] = {"arreglo", "funcion", "variable"};
		String palabra_secreta, palabra_ingresada;
		int intentos = 10;
		
		Random random = new Random();
        
		int posicion = random.nextInt(3) + 1;
		
		palabra_secreta = palabras[posicion];
		
		System.out.println(palabra_secreta);
		
		try {
			
			do {
				
				System.out.println("\nIngrese una palabra:");
				palabra_ingresada = entrada.next();
				
				intentos -= 1;
				
				if (palabra_ingresada.equalsIgnoreCase(palabra_secreta)) {
					System.out.println("\nGanaste!!!1!");
					System.out.println("Cantidad de intentos restantes: " + intentos);
				}
				
				else if (!palabra_ingresada.equalsIgnoreCase(palabra_secreta)) {
					
					int comparacion = palabra_ingresada.compareToIgnoreCase(palabra_secreta);
					
					if (comparacion < 0) {
						System.out.println("\\nLa palabra es alfabeticamente anterior a la palabra secreta");
					}
					
					else if (comparacion > 0) {
						System.out.println("\nLa palabra es alfabeticamente posterior a la palabra secreta");
					}
				}
							
			} while (intentos >= 1 && !palabra_ingresada.equalsIgnoreCase(palabra_secreta));
			
			if (!palabra_ingresada.equalsIgnoreCase(palabra_secreta)) {
				System.out.println("Perdiste. Palabra secreta: " + palabra_secreta);
			}
			
		} catch (InputMismatchException e) {
			System.out.println("\nError: Debes ingresar un dato valido.");
			entrada.nextLine();
		}
	}
}
