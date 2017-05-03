/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package commands;

import com.google.gson.Gson;
import command.Context;
import java.io.Serializable;
import patron.Command;

/**
 *
 * @author Roberto Pedraza
 */
public class C_MovimientoIncorrecto implements Command {

    String nombreComando;
    Character letraElegida;

    public C_MovimientoIncorrecto(Character letraElegida) {
        this.nombreComando = "C_MovimientoIncorrecto";
        this.letraElegida = letraElegida;
    }

    @Override
    public void Execute() {
        Context c = Context.getContext();
        c.agregarLetra(letraElegida);
        c.avanzarTurno();
    }

    @Override
    public String convertToJSON() {
        Gson gson = new Gson();
        return gson.toJson(this);
    }

}
