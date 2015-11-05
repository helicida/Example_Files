package BorrarCarpeta_Recursivitat;

import java.util.Scanner;
import java.io.*;

public class BorrarCarpeta{
	
	// Archivos y Strings fijos de la Biblioteca
		public static String pathname = "C:/Users/46465442z/Desktop/Biblioteca";	 	// Ruta de la carpeta de la biblioteca (La pots modificar aqu� o en un petit men� dins el programa)
		
	// Main
		public static void main(String[] args){
			menu();
		}
	
	// Funciones
		public static void menu(){
			
			Scanner teclat = new Scanner(System.in); // Teclado de entrada
			
			System.out.println("Introdueix la ruta en la qual vols eliminar un arxiu");		//Introduim la ruta
				pathname = teclat.nextLine();
				
			File carpetaBiblioteca = new File (pathname); 			// Carpeta de la qual volem borrar tot
			File[] array = carpetaBiblioteca.listFiles();			// Almacenamos en un array de Files los archivos de arrayBiblioteca con la funci�n listFiles();	
	
			indexarDirectori(array);		//Recorremos los directorios y sus archivos de la Biblioteca
			carpetaBiblioteca.delete();		//Eliminem la carpeta
	
			System.out.println("Has sortit del programa.");
		}
		
		public static void indexarDirectori(File [] arrayBiblioteca){
					
			try{					
				for (int iterador = 0; iterador < arrayBiblioteca.length; iterador++){		//Recorremos el array de files
					if (arrayBiblioteca[iterador].isDirectory() == true){ 					//Si es un diretorio
						indexarDirectori(arrayBiblioteca[iterador].listFiles());			//La funci�n se llama a si misma y elimina todos los archivos de dentro
						
					//Despu�s eliminamos la carpeta leida si es un directorio
						if (arrayBiblioteca[iterador].delete()){							
							   System.out.println("El directorio " + arrayBiblioteca[iterador].getName() + " ha sido borrado satisfactoriamente");
						}
						else{
							   System.out.println("El directorio "  + arrayBiblioteca[iterador].getName() + "no puede ser borrado");
						}
					}
				
					//Si no es un directorio 
					else if(arrayBiblioteca[iterador].isFile()){
						if (arrayBiblioteca[iterador].delete()){	//eliminamos el archivo					
							 System.out.println("El fichero" + arrayBiblioteca[iterador].getName() + " ha sido borrado satisfactoriamente");
						}
						else{
							 System.out.println("El fichero"  + arrayBiblioteca[iterador].getName() + "no puede ser borrado");
						}
					}
				}
			}
			catch(Exception e){
				System.out.println("Error de fitxer: " + e.getMessage());						// Missatge de error
			}
		}
}