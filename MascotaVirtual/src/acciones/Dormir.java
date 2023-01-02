package acciones;
import java.time.LocalDateTime;
import java.time.LocalTime;

import modelos.Mascota;

public class Dormir {

    private int horasDormidas;

    private int minutosDormidos;

    public void hacerDormir (LocalTime tiempoAdormir, Mascota mascota) {
        if (mascota.isLive()){
            horasDormidas = tiempoAdormir.getHour();
            minutosDormidos = tiempoAdormir.getMinute();
            modificarEstado(horasDormidas, minutosDormidos, mascota);
            Mascota.ultimoDescanso = LocalTime.now();
        }else {
            System.out.println("Lo siento, esta mascota no se encuentra operativa desde: " + mascota.getFechaMuerte());
        }
    }

    public void modificarEstado (int horasDormidas, int minutosDormidos, Mascota mascota){

        // por cada 10 min dormido el nivel de energia aumenta 5 puntos

        int minutosTotales = (horasDormidas * 60) + minutosDormidos;
        mascota.setNivelEnergia(mascota.getNivelEnergia() + ((minutosTotales * 5)/10));

    }


}
