package acciones;

import enumeradores.AlmacenAlimentos;
import modelos.Mascota;

import java.time.LocalDateTime;

public class Morir {



    public static void chekStatusGral (Mascota mascota){
        if (mascota.getNivelEnergia() == 0){
            mascota.setLive (false);
            mascota.setFechaMuerte(LocalDateTime.now());
            if (mascota.getCausaDeMuerte ().isEmpty ()){
                determinarCausaDeMuerte (mascota);
            }

            System.out.println("Esta mascota ha fallecido en la fecha: " + mascota.getFechaMuerte().toLocalTime());
            System.out.println (("La causa de muerte fue: ") + mascota.getCausaDeMuerte());
        }

    }
    public static void determinarCausaDeMuerte(Mascota mascota){
        if (mascota.getNivelAburrimiento() ==100){
            mascota.setCausaDeMuerte("Aburrimiento");}

        //if (mascota.getNivelHambre()==100){
           // mascota.setCausaDeMuerte("Hambre");}

        if (mascota.getNivelCansancio() == 100){
            mascota.setCausaDeMuerte("Cansancio");}

        if (mascota.getNivelFelicidad() ==0){
            mascota.setCausaDeMuerte("Tristeza");}

        if (mascota.getComidasIngeridas() > 4){
            mascota.setCausaDeMuerte("Constipado");}

        System.out.println("esta mascota fallecio en la fecha: " + mascota.getFechaMuerte().toLocalTime());
        System.out.println("la causa de muerte ha sido: " + mascota.getCausaDeMuerte());

    }


}
