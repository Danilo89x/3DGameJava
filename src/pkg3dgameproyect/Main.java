/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg3dgameproyect;

import org.lwjgl.opengl.Display;
import prueba.diaplayManager;

/**
 *
 * @author Sammy Guergachi <sguergachi at gmail.com>
 */
public class Main {

   
    public static void main(String[] args) {
        diaplayManager.createDisplay();
        while (!Display.isCloseRequested()) {            
            diaplayManager.updateDisplay();
        }
       diaplayManager.closeDisplay();
    }
    
}
