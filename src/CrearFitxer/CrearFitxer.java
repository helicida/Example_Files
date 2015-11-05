package CrearFitxer;

import java.io.IOException;
import java.io.File;

/**
* Aquesta clase comrpoba si el arxiu al que apunta un File existeix. Si no, el crea
* Created by 46465442z on 01/10/15.
* @author Sergi Barjola
*/
public class CrearFitxer{

    /**
    * Metode auxiliar que comproba si un File existeix. Si no existeix, crea un arxiu.
    * @param fitxer  aquest parametre es el fitxer del que es comprobar� la seva existencia, en cas de no existir, es crear� un al seu path
    */
    public static void crea(File fitxer){

        if(!fitxer.exists()){   //Si el fitxer no existeix
            System.out.println("----------------------------------------------------------");
            System.out.println("El arxiu especificat no existeix, es creara automaticament");

            try {
                // A partir del objecte file creem el fitxer fisicament
                if (fitxer.createNewFile()){
                    System.out.println("El fitxer file s'ha creat correctament");
                }
                else{
                    System.out.println("N'ho s'ha pogut crear el fitxer");
                }
            }
            catch (IOException ioe){    //Excepci�
                ioe.printStackTrace();
            }
            System.out.println("---------------------------------------------");
        }
    }
}

// M'ha sembalt bona idea fer-la perque pot ser �til mes endevant i perque
// No ho he implementat com a m�tode perque necessito cridarla desde dues clases diferents
