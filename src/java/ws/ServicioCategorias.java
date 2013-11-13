package ws;

import Conexion.Conexion;
import controladores.ControladorCategorias;
import dominio.Categoria;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;

@WebService(serviceName = "ServicioCategorias")
public class ServicioCategorias {

    @WebMethod(operationName = "listarCategorias")
    public ArrayList<Categoria> listarCategorias() {
        Conexion.conectarBD();
        return ControladorCategorias.getInstancia().listarCategorias();
    }


    @WebMethod(operationName = "listarCategoriasPorJuego")
    public ArrayList<Categoria> listarCategoriasPorJuego(@WebParam(name = "id_juego") int id_juego) {
        Conexion.conectarBD();
        return ControladorCategorias.getInstancia().verCategoriasPorJuego(id_juego);
    }
}
