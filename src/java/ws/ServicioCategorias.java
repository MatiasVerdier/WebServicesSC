package ws;

import Conexion.Conexion;
import controladores.ControladorCategorias;
import dominio.Categoria;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;

@WebService(serviceName = "ServicioCategorias")
public class ServicioCategorias {

    @WebMethod(operationName = "nuevaCategoria")
    public int nuevaCategoria(@WebParam(name = "nombre") String nombre, @WebParam(name = "imagen") String imagen) throws SQLException {
        Conexion.conectarBD();
        Categoria c = new Categoria();
        c.setNombre(nombre);
        c.setImagen(imagen);

        return ControladorCategorias.getInstancia().altaCategoria(c);
    }


    @WebMethod(operationName = "listarCategorias")
    public ArrayList listarCategorias() {
        Conexion.conectarBD();
        return ControladorCategorias.getInstancia().listarCategorias();
    }


    @WebMethod(operationName = "listarCategoriasPorJuego")
    public ArrayList listarCategoriasPorJuego(@WebParam(name = "id_juego") int id_juego) {
        Conexion.conectarBD();
        return ControladorCategorias.getInstancia().verCategoriasPorJuego(id_juego);
    }
}
