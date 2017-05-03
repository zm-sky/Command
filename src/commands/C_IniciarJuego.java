/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package commands;

import com.google.gson.Gson;
import command.CommandContext;
import command.Context;
import java.util.List;
import patron.Command;

/**
 *
 * @author Roberto Pedraza Coello
 */
public class C_IniciarJuego implements Command{

    String nombreComando;
    String fraseDelJuego;
    
    public C_IniciarJuego(String fraseDelJuego){
        this.nombreComando="C_IniciarJuego";
        this.fraseDelJuego=fraseDelJuego;
    }
    
    @Override
    public void Execute() {
        CommandContext c = Context.getContext();
        
        c.iniciarJuego(fraseDelJuego);
    }

    @Override
    public String convertToJSON() {
        Gson gson = new Gson();
        return gson.toJson(this);
    }

}
