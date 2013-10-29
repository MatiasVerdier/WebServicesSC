package ws;

import controladores.ControladorUsuarios;
import dominio.Usuario;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;

@WebService(serviceName = "ServicioUsuarios")
public class ServicioUsuarios {

    @WebMethod(operationName = "verInfoUsuario")
    public Usuario verInfoUsuario(@WebParam(name = "idUsuario") int idUsuario) throws SQLException {
        return ControladorUsuarios.getInstancia().verInfoUsuario(idUsuario);

    }

    @WebMethod(operationName = "listarUsuarios")
    public ArrayList listarUsuarios(@WebParam(name = "tipo") String tipo) throws SQLException {
        return ControladorUsuarios.getInstancia().listar(tipo);
    }
}
