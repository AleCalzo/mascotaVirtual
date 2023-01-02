package persistencia.mysql;

import modelos.Mascota;
import persistencia.IMascotaPersistence;

import java.sql.Connection;
import java.util.List;

public class MascotaPersistenceUseMySQL implements IMascotaPersistence {

    MySQLConnection mySQLConnection;

    Connection connection;

    public MascotaPersistenceUseMySQL (){
        this.mySQLConnection = new MySQLConnection();
        this.connection = mySQLConnection.establecerConeccion();
    }

    @Override
    public void guardar(Mascota mascota) {

    }

    @Override
    public Mascota getMascota(int id) {
        return null;
    }

    @Override
    public Mascota getMascota(String nombre) {
        return null;
    }

    @Override
    public List<Mascota> getAllMascotas() {
        return null;
    }

    @Override
    public void updateMascota(int id, Mascota mascota) {

    }

    @Override
    public void deleteMascota(int id) {

    }
}
