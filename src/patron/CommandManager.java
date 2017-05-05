package patron;

import com.google.gson.Gson;
import commands.C_IniciarJuego;
import commands.C_MovimientoCorrecto;
import commands.C_MovimientoIncorrecto;
import commands.C_RegistrarTurno;
import commands.C_SiguienteTurno;
import commands.C_TerminarJuego;
import network.Peer;
import network.PeerListener;

/**
 * 
 * @author Roberto Pedraza Coello
 */
public class CommandManager implements PeerListener {

    /**
     * Contiene la conexion hacia todos los demas peers que esten conectados.
     * Ocupamos esto para recibir y mandar commandos concretos a traves de la
     * red.
     */
    private Peer peer;

    /**
     * Crea una instancia de la clase CommandManager que se encarga de mandar y
     * recibir comandos a traves de la red.
     *
     * @param destinatario El peer al cual vamos a mandar y recibir comandos.
     */
    public CommandManager(Peer destinatario) {
        peer = destinatario;
        peer.addPeerListener(this);
    }

    /**
     * Usualmente lo unico que se enviara son comandos. Este metodo sera
     * invocado cada vez que un peer mande algo a este mismo.
     *
     * @param c El peer responsable que mando el objeto.
     * @param o El objeto que ha sido mandado.
     */
    @Override
    public void objetoRecibido(Object o) {
        if (o instanceof String) {
            Command comando = obtenerComando((String) o);
            
            if (comando != null) {
                Invoker invoker = new Invoker(comando);
                invoker.run();
            }
        }
    }

    /**
     * Este metodo recibe un String, el cual es el comando en formato JSON. El
     * metodo saca del String que tipo de comando es y regresa el comando del
     * tipo que debe ser.
     *
     * @param comandoJSON
     * @return Objeto tipo comando
     */
    private Command obtenerComando(String comandoJSON) {
        Gson gson = new Gson();
        
        String clase = comandoJSON.substring(18, comandoJSON.indexOf("\"", 18));
        
        if (clase.equals("C_MovimientoCorrecto")) {
            return gson.fromJson(comandoJSON, C_MovimientoCorrecto.class);
        }

        if (clase.equals("C_RegistrarTurno")) {
            return gson.fromJson(comandoJSON, C_RegistrarTurno.class);
        }
        
        if (clase.equals("C_SiguienteTurno")) {
            return gson.fromJson(comandoJSON, C_SiguienteTurno.class);
        }
        
        if (clase.equals("C_MovimientoIncorrecto")) {
            return gson.fromJson(comandoJSON, C_MovimientoIncorrecto.class);
        }

        if (clase.equals("C_IniciarJuego")) {
            return gson.fromJson(comandoJSON, C_IniciarJuego.class);
        }

        if (clase.equals("C_TerminarJuego")) {
            return gson.fromJson(comandoJSON, C_TerminarJuego.class);
        }
        
        
        return null;
    }

    /**
     * Cierra todas las conexiones asociadas al peer y deja de recibir comandos
     * a traves de la red.
     */
    public void pararDeRecibir() throws Exception {
        peer.cerrar();
    }

    /**
     * Envia un comando a traves de la red con destino a cada peer que este
     * activo.
     *
     * @param command El comando a mandarse.
     * @throws Exception
     */
    public void mandarComando(Command command) throws Exception {
        String comandoJSON = command.convertToJSON();
        peer.enviarObjeto(comandoJSON);
    }
}
