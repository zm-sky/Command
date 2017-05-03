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
public class C_Pierde implements Command{
    
    String nombreComando;
    String ganador;
    
    public C_Pierde(String ganador){
        this.nombreComando="C_Pierde";
        this.ganador=ganador;
    }
    @Override
    public void Execute() {
        Context c = Context.getContext();
        c.setGanador(ganador);
    }

    @Override
    public String convertToJSON() {
        Gson gson = new Gson();
        return gson.toJson(this);
    }
}
