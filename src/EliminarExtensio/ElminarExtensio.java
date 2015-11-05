package EliminarExtensio;

import java.util.Scanner;
import java.io.*;

public class ElminarExtensio {
		
	public static void main(String[] args){
		
		Scanner teclat = new Scanner(System.in); // Obrim teclat
		
		String ruta = "C:\\Users\\46465442z\\Desktop\\";	 // Ruta base
		String rutaFinal; // ruta del primer file
		
		// Demanem el nom del arxiu
		
		System.out.println("Introdueix el nom del arxiu amb la extensi� corresponent (extensi� incluida)");
			 String nomArxiu = teclat.nextLine();
		
		rutaFinal = ruta + nomArxiu; //Concateno els dos strings
			 				
		// Creem el file del arxiu
			
		File Fitxer = new File (rutaFinal);
		
		// Treiem el nom del File i el separem pel punt
		
		String nom = Fitxer.getName();	// Nom		
		String[] separado = nom.split(".");	// Separem el nom de l'arxiu desde el punt que marca l'extensi�
		
		File Fitxer2 = new File (ruta); // Nou arxiu amb la nova ruta sense l'extensi�
		boolean correcte = Fitxer.renameTo(Fitxer2); // creem un bole� que determina si el canvi de nom s'ha produ�t correctament
		
		//Renombrem el file		
		if (correcte){
		    System.out.println("El renombrado ha sido correcto");
		}
		else{
			System.out.println("El renombrado no se ha podido realizar");
		}
		
		// Imprimir
		
		System.out.println("Nom del fitxer original = " + Fitxer.getName());
		System.out.println("Nom del fitxer nou = " + Fitxer2.getName());
		
		teclat.close();
		
	}
}
