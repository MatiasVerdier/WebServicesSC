package ws;

import baseDatos.ManejadorBD;
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

    private void conectarBD(){
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

    
    @WebMethod(operationName = "nuevaCategoria")
    public int nuevaCategoria(@WebParam(name = "nombre") String nombre, @WebParam(name = "imagen") String imagen) throws SQLException {
        this.conectarBD();
        Categoria c = new Categoria();
        c.setNombre(nombre);
        c.setImagen(imagen);

        return ControladorCategorias.getInstancia().altaCategoria(c);
    }


    @WebMethod(operationName = "listarCategorias")
    public ArrayList listarCategorias() {
        this.conectarBD();
        return ControladorCategorias.getInstancia().listarCategorias();
    }


    @WebMethod(operationName = "listarCategoriasPorJuego")
    public ArrayList listarCategoriasPorJuego(@WebParam(name = "id_juego") int id_juego) {
        this.conectarBD();
        return ControladorCategorias.getInstancia().verCategoriasPorJuego(id_juego);
    }
}
