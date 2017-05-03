/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package commands;

import com.google.gson.Gson;
import command.Context;
import patron.Command;

/**
 *
 * @author zippy
 */
public class C_SiguienteTurno implements Command{
    String nombreComando;
    
    public C_SiguienteTurno(){
        nombreComando = "C_SiguienteTurno";
    }
    
    @Override
    public void Execute() {
        Context c = Context.getContext();
        c.avanzarTurno();
    }

    @Override
    public String convertToJSON() {
        Gson gson = new Gson();
        return gson.toJson(this);
    }
    
}
