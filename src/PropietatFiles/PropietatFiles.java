/* Alumne Sergi Barjola*/

package PropietatFiles;

import java.io.File;
import java.util.Scanner;
import java.util.Date;

public class PropietatFiles {

    public static void main(String[] args){

        Scanner teclat = new Scanner(System.in); // Obrim teclat

        String rutaFitxer = "C:\\Users\\46465442z\\Desktop\\arxiu.txt";     //Ruta del fitxer

        System.out.println("Introdueix la ruta del arixu");      //Demanem la ruta del fitxer
        rutaFitxer = teclat.nextLine();

        File Fitxer = new File (rutaFitxer);        //Creem un file amb la ruta demanada

        Date date = new Date(Fitxer.lastModified());

        System.out.println("El nom del arxiu o directori, és: " + Fitxer.getName());       //Imprimim el nom del arxiu
        //System.out.println("Ruta relativa " + Fitxer.getPath()); --Aquest no es pot fer
        System.out.println("Ruta absoluta " + Fitxer.getAbsolutePath() );   //Imprimim la rota absoluta
        System.out.println("Directory pare " + Fitxer.getParent());     //Imprimim el directori pare

        if(Fitxer.isDirectory()){
            System.out.println("És un directori y conté els següents fitxers:");    //Imprimim si es directory i els arxius que conte

            File[] array = Fitxer.listFiles();

            for(int iterador = 0; iterador < array.length; iterador++){
                if(array[iterador].isFile()){
                    System.out.println(" - " + array[iterador].getName());
                }
            }

        }
        else{
            System.out.println("És un arxiu");      //Imprimim si es arixu i si està ocult

            if(Fitxer.isHidden()){
                System.out.println("Està ocult");
            }
            else{
                System.out.println("No està ocult");
            }
        }

        //System.out.println("Data creació:"); No he pogut :(
        System.out.println("Ultima data de modificació: " + date);  //Imprimim la ultima data de modificacio

        teclat.close();
    }
}