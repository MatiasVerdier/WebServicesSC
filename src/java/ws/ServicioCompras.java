package ws;

import controladores.ControladorCompras;
import controladores.ControladorUsuarios;
import controladores.Controladorjuegos;
import dominio.Compra;
import dominio.Juego;
import dominio.Usuario;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.jws.Oneway;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;

@WebService(serviceName = "ServicioCompras")
public class ServicioCompras {

    @WebMethod(operationName = "verComprasJuego")
    public ArrayList verComprasJuego(@WebParam(name = "idJuego") int idJuego) {
        return ControladorCompras.getInstancia().verComprasPorJuego(idJuego);
    }

    @WebMethod(operationName = "altaCompra")
    @Oneway
    public void altaCompra(@WebParam(name = "nickUsuario") String nickUsuario, @WebParam(name = "idJuego") int idJuego) {
        try {
            Usuario u = ControladorUsuarios.getInstancia().find(nickUsuario);
            Juego j = Controladorjuegos.getInstancia().buscarJuegoPorID(idJuego);
            Date hoy = new Date();
            
            Compra c = new Compra(j, u, hoy);
            
            ControladorCompras.getInstancia().altaCompra(c);
        } catch (SQLException ex) {
            Logger.getLogger(ServicioCompras.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @WebMethod(operationName = "comproJuego")
    public boolean comproJuego(@WebParam(name = "idUsuario") int idUsuario, @WebParam(name = "idJuego") int idJuego) {
        return ControladorCompras.getInstancia().comproJuego(idUsuario, idJuego);
    }
}
