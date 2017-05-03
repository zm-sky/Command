/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package patron;

import java.io.Serializable;

/**
 *
 * @author zippy
 */
public interface Command extends Serializable{
//    /**
//     * Contiene cada uno de los parametros que ocupa
//     * el comando.
//     */
//    protected Object[] parametros;
//    
//    /**
//     * Indica cada uno de los parametros que usara el comando
//     * al momento de ejecutarse.
//     * @param o 
//     */
//    public void setParametros(Object...o){
//        this.parametros = o;
//    }
//    /**
//     * Indica el identificador del comando.
//     * @return 
//     */
//    public abstract String getID();
//    
    /**
     * Ejecuta el comando junto con sus debidos parametros.
     */
    public void Execute(); 
    
    public String convertToJSON();
}
