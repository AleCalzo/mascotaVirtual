package modelos;

public class DukeMascota extends Mascota{
    public DukeMascota(String nombre, String propietario) {
        super(nombre, propietario);
    }

    private static int count;

    @Override
    public String toString() {
        return "La mascota de nombre : " + nombre + '\n' + "nació el día : " + fechaNacimiento.getDayOfWeek()+ ","
                + fechaNacimiento.getDayOfMonth() + " de " + getFechaNacimiento().getMonth() + " del año "
                + fechaNacimiento.getYear() + '\n'+ " a la hora : " + getFechaNacimiento().getHour() + ":"
                + fechaNacimiento.getMinute() + '\n'+ "actualmente se encuentra " + ((isLive()) ? "vivo \n ": "muerto \n" )
                + "su nivel de energia se encuentra en : " + nivelEnergia + "% \n"
                + "el nivel de hambre en : " + nivelHambre + "% \n"
                + "nivel de cansancio : " + nivelCansancio + "% \n"
                + "nivel de felicidad : " + nivelFelicidad + "% \n"
                + "nivel de aburrimiento : " + nivelAburrimiento + "% \n"
                + "y su actual propietario es : " + propietario + "% \n";
    }
}
