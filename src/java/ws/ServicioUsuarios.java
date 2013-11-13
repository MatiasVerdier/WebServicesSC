package ws;

import Conexion.Conexion;
import controladores.ControladorUsuarios;
import dominio.Desarrollador;
import dominio.Usuario;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
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

    @WebMethod(operationName = "find")
    public Usuario find(@WebParam(name = "nick") String nick) {
        try {
            return ControladorUsuarios.getInstancia().find(nick);
        } catch (SQLException ex) {
            Logger.getLogger(ServicioUsuarios.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    @WebMethod(operationName = "altaUsuario")
    public int altaUsuario(@WebParam(name = "nom") String nom, @WebParam(name = "ape") String ape, @WebParam(name = "nick") String nick, @WebParam(name = "email") String email, @WebParam(name = "fnac") String fnac, @WebParam(name = "pass") String pass, @WebParam(name = "img") String img, @WebParam(name = "tipo") String tipo, @WebParam(name = "sitio") String sitio) {
        try {
            Usuario u = new Usuario();
            
            if (tipo.equals("d")){
                Desarrollador d = new Desarrollador();
                d.setWeb(sitio);
                u = d;
            }
            
            u.setNombre(nom);
            u.setApellido(ape);
            u.setEmail(email);
            u.setImg(img);
            u.setTipo(tipo);
            u.setPass(pass);
            u.setNick(nick);
            
            Calendar c = new GregorianCalendar();
            String [] datos = fnac.split("-");
            int year = Integer.valueOf(datos[0]);
            int mes = Integer.valueOf(datos[1]);
            int dia = Integer.valueOf(datos[2]);
            c.set(year, mes-1, dia);
            Date f = c.getTime();
            
            u.setFecha_nac(f);

            return ControladorUsuarios.getInstancia().altaUsuario(u);
        } catch (SQLException ex) {
            Logger.getLogger(ServicioUsuarios.class.getName()).log(Level.SEVERE, null, ex);
            return 0;
        }
    }
}
