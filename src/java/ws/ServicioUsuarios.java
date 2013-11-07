package ws;

import Conexion.Conexion;
import controladores.ControladorUsuarios;
import dominio.Usuario;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;

@WebService(serviceName = "ServicioUsuarios")
public class ServicioUsuarios {

    @WebMethod(operationName = "verInfoUsuario")
    public Usuario verInfoUsuario(@WebParam(name = "idUsuario") int idUsuario) {
        try {
            Conexion.conectarBD();
            return ControladorUsuarios.getInstancia().verInfoUsuario(idUsuario);
        } catch (SQLException ex) {
            Logger.getLogger(ServicioUsuarios.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }

    }

    @WebMethod(operationName = "listarUsuarios")
    public ArrayList listarUsuarios(@WebParam(name = "tipo") String tipo){
        try {
            Conexion.conectarBD();
            return ControladorUsuarios.getInstancia().listar(tipo);
        } catch (SQLException ex) {
            Logger.getLogger(ServicioUsuarios.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
}
