/* Alumne Sergi Barjola*/

package MiniParser;

import java.io.*;
import java.util.Scanner;

public class MiniParser{

    public static boolean netejat = false;                              //Boleà que estableix si el arxiu del log s'ha netejat o no
    public static String ruta = "C:\\Users\\46465442z\\Desktop\\";	    //Ruta del arxiu a modificar i on s'escriurà
    public static String rutaEscriptura = "C:\\Users\\46465442z\\Desktop\\resum.txt"; //Ruta on s'escriurà el arixu resum.txt

    public static void main(String[] args)	{
        canviaRuta();		//Cridem al mètode per canviar la ruta
        executar(ruta);		//Cridem al mètode que extreu les dades
    }

    public static void canviaRuta(){

        Scanner teclat = new Scanner(System.in); // Obrim teclat

        System.out.println("Introdueix la ruta del XML");	//Demanem al usuari que introdueixi la ruta
        ruta = teclat.nextLine();

        teclat.close();
    }

    public static void executar(String fitxer){

        try{
            BufferedReader in = new BufferedReader(new FileReader(fitxer));	//Buffer de lectura
            String linia, text = "";
            //String de linea i de text. En aquest cas tenen el mateix valor, però es una bona
            //pràctica de programació que pot ser ùtil en altres casos

            while((linia = in.readLine()) != null){
                text = linia;
                if (in.ready()){											//Quan acabi de llegir
                    if (text.contains("titulo")){							//Comproba si llegeix el titol
                        String[] parts = text.split(">");					//L'extreu mitjançant dos splits
                        String titol = parts[1].split("<")[0];
                        escriu("'" + titol + "' té com autor '", false);	//Imprimeix la part corresponent al títol
                    }
                    if (text.contains("autor")){							//Comproba si llegeix el autor
                        String[] parts = text.split(">");					//L' extreu mitjançant dos splits
                        String autor = parts[1].split("<")[0];
                        escriu( autor + "' i va ser publicat l'any ", false);	//Imprimeix la part corresponent al autor
                    }
                    if (text.contains("fecha")){							//Comproba si llegeix la data
                        String[] parts = text.split(">");					//L'extreu mitjançant dos splits
                        String fecha = parts[1].split("<")[0];
                        escriu(fecha, true);	                            //Imprimeix la part corresponent a la data
                    }
                }
            }
            in.close();	// Tanquem teclat
        }
        catch(Exception e){	//Excepció del buffer
            System.out.println("Error de fitxer: " + e.getMessage());
        }
    }

    public static void escriu(String text, boolean salt){ //Funcio que escriura la quantitat de paraules llegides. Si salt és true, fa un salt de linea

        File resum =  new File (rutaEscriptura);

        if(resum.exists() == true && netejat == false){
            resum.delete();	//Netejem el arxiu anterior per no solapar dades
            netejat = true;
        }

        try{
            if (resum.createNewFile()){
                System.out.println("El archivo se ha creado correctamente");
            }
            else{
                System.out.println("El archivo no ha podido ser creado");
            }
        }
        catch (IOException ioe){
            ioe.printStackTrace();
        }

        //Començem a escriure

        try{
            BufferedWriter out = new BufferedWriter(new FileWriter(resum, true)); //Creem el bufer
            System.out.println(text);
            out.write(text); //escribim el string
            if(salt == true){ //controla el parametre de salt de linea
                out.newLine(); //saltem de linea
            }
            out.close(); //tanquem el buffer
        }
        catch(Exception e){
            System.out.println("Error de fitxer: " + e.getMessage());
        }
    }
}