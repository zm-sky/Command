/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prueba;

import commands.C_Pierde;
import java.util.Scanner;
import network.Peer;
import patron.Command;
import patron.CommandManager;

/**
 *
 * @author zippy
 */
public class Prueba {

    public static void main(String[] args) throws Exception {
        Peer destino = new Peer();
        destino.inicializar("localhost", 405);
        destino.conectarServidor("localhost", 6000);

        CommandManager manager = new CommandManager(destino); 

        simular(manager);
    }

    public static void simular(CommandManager manager) throws Exception {
        Scanner in = new Scanner(System.in);

        System.out.println("Indique el comando a mandar:");
        String comando = in.nextLine();

        if (comando.equalsIgnoreCase("Perder")) {
            C_Pierde pierdeJuego = new C_Pierde("Ganador");

            manager.mandarComando(pierdeJuego);
            System.out.println("Haz ganado el juego!");
        }
    }
}
