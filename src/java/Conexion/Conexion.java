package Conexion;

import baseDatos.ManejadorBD;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import ws.ServicioCategorias;

public class Conexion {
    public static void conectarBD(){
        try {
            ManejadorBD mbd = ManejadorBD.getInstancia();
            if (mbd.estaDesconectado()){
                mbd.setHost("localhost");
                mbd.setPuerto("3306");
                mbd.setBd("market");
                mbd.setUsuario("root");
                mbd.setPassword("root");
                
                mbd.conectar();
            }
        } catch (SQLException ex) {
            Logger.getLogger(ServicioCategorias.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
