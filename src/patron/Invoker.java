
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package patron;

/**
 *
 * @author zippy
 */
public class Invoker {
    private Command command;
    
    public Invoker(Command command){
        this.command = command;
    }
    
    public void run(){
        new Thread(new Runnable(){
            public void run(){
                command.Execute();
            }
        }).start();
    }
}
