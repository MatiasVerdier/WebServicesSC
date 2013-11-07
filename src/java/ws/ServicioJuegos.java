package ws;

import Conexion.Conexion;
import dominio.Juego;
import controladores.Controladorjuegos;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.jws.Oneway;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;

@WebService(serviceName = "ServicioJuegos")
public class ServicioJuegos {

    @WebMethod(operationName = "Buscar")
    public ArrayList Buscar(@WebParam(name = "busqueda") String busqueda) {
        try {
            Conexion.conectarBD();
            return Controladorjuegos.getInstancia().buscar(busqueda);
        } catch (SQLException ex) {
            Logger.getLogger(ServicioJuegos.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    @WebMethod(operationName = "buscarJuegoPorId")
    public Juego buscarJuegoPorId(@WebParam(name = "id_juego") int id_juego)  {
        try {
            Conexion.conectarBD();
            return Controladorjuegos.getInstancia().buscarJuegoPorID(id_juego);
        } catch (SQLException ex) {
            Logger.getLogger(ServicioJuegos.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    @WebMethod(operationName = "listarJuegosPorCategoria")
    public ArrayList listarJuegosPorCategoria(@WebParam(name = "id_cat") int id_cat)  {
        try {
            Conexion.conectarBD();
            return Controladorjuegos.getInstancia().listarJuegosPorCategoria(id_cat);
        } catch (SQLException ex) {
            Logger.getLogger(ServicioJuegos.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    @WebMethod(operationName = "verInfoJuego")
    public Juego verInfoJuego(@WebParam(name = "id_juego") int id_juego)  {
        try {
            Conexion.conectarBD();
            return Controladorjuegos.getInstancia().verInfoJuego(id_juego);
        } catch (SQLException ex) {
            Logger.getLogger(ServicioJuegos.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    @WebMethod(operationName = "listarJuegos")
    public ArrayList listarJuegos() {
        try {
            Conexion.conectarBD();
            return Controladorjuegos.getInstancia().listarJuegos();
        } catch (SQLException ex) {
            Logger.getLogger(ServicioJuegos.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    @WebMethod(operationName = "listarJuegosConCompras")
    public ArrayList listarJuegosConCompras() {
        try {
            Conexion.conectarBD();
            return Controladorjuegos.getInstancia().listarJuegosConCompras();
        } catch (SQLException ex) {
            Logger.getLogger(ServicioJuegos.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    @WebMethod(operationName = "listarJuegosPorCliente")
    public ArrayList listarJuegosPorCliente(@WebParam(name = "id_usuario") int id_usuario) {
        try {
            Conexion.conectarBD();
            return Controladorjuegos.getInstancia().listarJuegosPorCliente(id_usuario);
        } catch (SQLException ex) {
            Logger.getLogger(ServicioJuegos.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    @WebMethod(operationName = "listarJuegosPorDesarrollador")
    public ArrayList listarJuegosPorDesarrollador(@WebParam(name = "id_usuario") int id_usuario) {
        try {
            Conexion.conectarBD();
            return Controladorjuegos.getInstancia().listarJuegosPorDesarrollador(id_usuario);
        } catch (SQLException ex) {
            Logger.getLogger(ServicioJuegos.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    @WebMethod(operationName = "bajaJuego")
    @Oneway
    public void bajaJuego(@WebParam(name = "id_juego") int id_juego) {
        try {
            Conexion.conectarBD();
            Controladorjuegos.getInstancia().bajaJuego(id_juego);
        } catch (SQLException ex) {
            Logger.getLogger(ServicioJuegos.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @WebMethod(operationName = "listarJuegosPorDesarrolladorVersionAprobada")
    public ArrayList listarJuegosPorDesarrolladorVersionAprobada(@WebParam(name = "id_usuario") int id_usuario) {
        try {
            Conexion.conectarBD();
            return Controladorjuegos.getInstancia().listarJuegosPorDesarrolladorVersionAprobada(id_usuario);
        } catch (SQLException ex) {
            Logger.getLogger(ServicioJuegos.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

}
