/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package commands;

import com.google.gson.Gson;
import java.io.Serializable;
import patron.Command;

/**
 *
 * @author Roberto Pedraza
 */
public class C_MovimientoCorrecto implements Command{
    String nombreComando;
    String letraElegida;
    
    public C_MovimientoCorrecto(String letraElegida){
        this.nombreComando="C_MovimientoCorrecto";
        this.letraElegida=letraElegida;
    }

    @Override
    public void Execute() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String convertToJSON() {
        Gson gson = new Gson();
        return gson.toJson(this);
    }
}
