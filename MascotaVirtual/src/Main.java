import enumeradores.AlmacenAlimentos;
import enumeradores.EntretenimientosEnum;
import modelos.DukeMascota;
import modelos.DukeDraco;
import modelos.DukeMascota;
import modelos.Mascota;
import persistencia.IMascotaPersistence;
import persistencia.mysql.MySQLConnection;
import persistencia.persistenceCollections.MascotaPersistenceUseList;
import persistencia.persistenceCollections.MascotaPersistenceUseList;
import utils.RegistroCivilMascotas;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.sql.Connection;
import java.time.LocalDateTime;
import java.time.LocalTime;


public class Main {

    public static void main (String [] args) throws SQLException {

        MascotaPersistenceUseList persistence = new MascotaPersistenceUseList();

        DukeMascota duke = new DukeMascota("Duke-Nina", "Alex");

        DukeDraco draco = new DukeDraco("Dog-Draco", "Alexandra");

        persistence.guardar(duke);

        persistence.guardar(draco);

        for (Mascota mascota: persistence.getAllMascotas()) {
            System.out.println(mascota.getNombre());
        }

        System.out.println("Antes de comer " + duke.getNivelEnergia());

        duke.comer(AlmacenAlimentos.ASADO);

        System.out.println("Despues de comer " + duke.getNivelEnergia() );

        duke.jugar(EntretenimientosEnum.JUGAR);
        duke.jugar(EntretenimientosEnum.LEER);
        duke.jugar(EntretenimientosEnum.MORDER);
        duke.jugar(EntretenimientosEnum.BAILAR);

        System.out.println(duke.getNivelAburrimiento());

        System.out.println("Antes de dormir " + duke.getNivelEnergia());

        duke.dormir(LocalTime.of (0, 25));

        duke.comer(AlmacenAlimentos.ASADO);
        duke.comer(AlmacenAlimentos.PORORO);
        duke.comer(AlmacenAlimentos.CHORIPAN);
        duke.comer(AlmacenAlimentos.ASADO);
        duke.comer(AlmacenAlimentos.ASADO);
        duke.comer(AlmacenAlimentos.ASADO);
        duke.comer(AlmacenAlimentos.ASADO);
        duke.comer(AlmacenAlimentos.ASADO);
        duke.comer(AlmacenAlimentos.ASADO);
        duke.comer(AlmacenAlimentos.ASADO);

        RegistroCivilMascotas.guardarActa(duke);

        MySQLConnection conexion = new MySQLConnection();

        Connection connection = conexion.establecerConeccion();

        String sql = "INSERT INTO `mascotas`.`personas` (id , nombre , apellido, fecha_nacimiento) VALUES (? , ? , ? , ?)";
        PreparedStatement stmt = connection.prepareStatement(sql);
        stmt.setInt(1, 1);
        stmt.setString(2, "Andrea");
        stmt.setString(3, "Garcia");
        stmt.setDate(4, Date.valueOf("1990-01-01"));

        stmt.executeUpdate();

        stmt.close();
        connection.close();

        System.out.println("conexión cerrada");

        //ArrayList collecciones = new ArrayList();

       // collecciones.add(duke);
       // collecciones.add(draco);
       // collecciones.remove(draco);

        //for (int i=0 ; i < collecciones.size(); i++){
           //System.out.println(collecciones.get(i));
        //}

        //for (Object animales : collecciones){
        //    System.out.println(collecciones);
        //}

    }
}
