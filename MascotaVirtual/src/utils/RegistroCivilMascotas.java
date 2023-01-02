package utils;

import modelos.Mascota;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class RegistroCivilMascotas {

    static FileInputStream input;

    static FileOutputStream output;

    private static final String RUTA= "src/main/utils/actas/";

    public static void confeccionarActa (Mascota mascota){
        if (!mascota.isLive()){
            String actaDefuncion = "ACTA DE DEFUNCION DE " + mascota.getNombre()
                    + "\n FECHA DE FALLECIMIENTO : " + mascota.getFechaMuerte().toLocalDate()
                    + "\n A LA HORA: " + mascota.getFechaMuerte().toLocalTime().getHour()
                    + " : " + mascota.getFechaMuerte().toLocalTime().getMinute()
                    + "\n CAUSA DE MUERTE : " + mascota.getCausaDeMuerte().toString();
            mascota.setActaDefuncion(actaDefuncion);
        }
        String actaNacimiento = "ACTA DE NACIMIENTO DE " + mascota.getNombre()
                + "\n FECHA DE NACIMIENTO : " + mascota.getFechaNacimiento().toLocalDate()
                + "\n A LA HORA: " + mascota.getFechaNacimiento().toLocalTime().getHour()
                + " : " + mascota.getFechaNacimiento().toLocalTime().getMinute()
                + "\n SU FAMILIAR MAS CERCANO ES : " + mascota.getPropietario();
        mascota.setActaNacimiento(actaNacimiento);
    }

    public static void guardarActa (Mascota mascota){
        System.out.println();
        if (!mascota.isLive() && mascota.getActaDefuncion() != null){
            try{
                output = new FileOutputStream(RUTA + mascota.getNombre() + "DEFUNCION " + ".txt");
                output.write(mascota.getActaDefuncion().getBytes());
                System.out.println("Acta de Defuncion Archivada");
                output.close();
            }catch (IOException e){
                throw new RuntimeException(e);
            }
        }try {
            output = new FileOutputStream(RUTA + mascota.getNombre() + "NACIMIENTO " + ".txt");
            output.write(mascota.getActaNacimiento().getBytes());
            System.out.println("Acta de Nacimiento Archivada");
            output.close();
        }catch (IOException e){
            throw new RuntimeException(e);
        }finally {
            System.out.println("");
        }
    }

    public static void leerActaNacimiento (Mascota mascota){
        try {
            input = new FileInputStream( RUTA + mascota.getNombre() + "Nacimiento " + "txt");
            int contenido = input.read();
            while (contenido != -1){
                System.out.println(contenido);
                contenido = input.read();
            }input.close();
        }catch (FileNotFoundException e){
            System.out.println("No existe el acta de Nacimiento de la mascota: " + mascota.getNombre());
        }catch (IOException e){
            System.out.println("No se ha podido leer");
        }finally {
            System.out.println("");
        }
    }

    public static void leerActaDefuncion (Mascota mascota){

        if (!mascota.isLive()) {
            try {
                input = new FileInputStream(RUTA + mascota.getNombre() + "Defuncion " + "txt");
                int contenido = input.read();
                while (contenido != -1) {
                    System.out.println((char) contenido);
                    contenido = input.read();
                }
                input.close();
            } catch (FileNotFoundException e) {
                System.out.println("No existe el acta de Defuncion de la mascota: " + mascota.getNombre());
            } catch (IOException e) {
                System.out.println("No se ha podido leer");
            } finally {
                System.out.println("");
            }
        }
    }





}
