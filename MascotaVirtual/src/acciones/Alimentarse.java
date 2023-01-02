package acciones;

import enumeradores.AlmacenAlimentos;
import modelos.Mascota;

public class Alimentarse {

    private AlmacenAlimentos comida;

    public void ingerirAlimento(AlmacenAlimentos comida, Mascota mascota) {

        if (mascota.isLive()) {
            mascota.setNivelEnergia(mascota.getNivelEnergia() + comida.getEnergiaAportada());
            contabilizarComida(mascota);
            if (mascota.getPopo().tieneQueEvacuar(mascota)) {
                mascota.setNivelEnergia(mascota.getNivelEnergia() - 15);
                Morir.chekStatusGral(mascota);

                if (mascota.isLive()) {
                    System.out.println("esta mascota necesita ir al baño");
                }
            }else {
                System.out.println("esta mascota necesita ir al baño");
            }

        }else {
            Morir.chekStatusGral(mascota);
            System.out.println("lo siento, esta mas cota no esta operativa desde: " + mascota.getFechaMuerte().toLocalTime());
        }



}

    private void contabilizarComida (Mascota mascota){
        mascota.setComidasIngeridas(mascota.getComidasIngeridas()+1);} // se podria haber puesto ++?
    }





