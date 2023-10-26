/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prueba;

import java.util.logging.Level;
import java.util.logging.Logger;
import org.lwjgl.LWJGLException;
import org.lwjgl.opengl.ContextAttribs;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;
import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.PixelFormat;

/**
 *
 * @author Sammy Guergachi <sguergachi at gmail.com>
 */
public class diaplayManager {

    private static final int WIDTH = 1280;
    private static final int HEIGHT = 720;
    private static final int FPS_CAP = 60;

    public static void createDisplay() {
        /*
       El objeto ContextAttribs se utiliza para especificar atributos del contexto OpenGL al crear una ventana en una aplicación
       Java que utiliza gráficos 3D o 2D acelerados por hardware. La clase ContextAttribs proporciona un medio para configurar características
       específicas del contexto OpenGL, como versiones de OpenGL, compatibilidad hacia adelante (forward compatibility), perfiles, entre otros.
         */

        ContextAttribs attribs = new ContextAttribs(3, 2);

        /*
       Establece el atributo "forward-compatible" del contexto OpenGL en true. Cuando esta opción está activada,
       el contexto OpenGL no proporcionará características obsoletas y se comportará de acuerdo con las especificaciones
       más recientes de OpenGL. Esto es útil para garantizar la compatibilidad con futuras versiones de OpenGL y evitar
       el uso de funciones obsoletas.
       
         */
        attribs.withForwardCompatible(true);
        /*
       Establece el atributo "core profile" del contexto OpenGL en true. Un perfil central
       (core profile) en OpenGL es un conjunto de características que representa la funcionalidad moderna y 
       coherente de OpenGL. Al habilitar el perfil central,
       se desactivan las funciones obsoletas y se utilizan únicamente las características modernas de OpenGL.
         */
        attribs.withProfileCore(true);
        try {
            Display.setDisplayMode(new DisplayMode(WIDTH, HEIGHT));
            //Este método create() se utiliza para crear una nueva ventana de visualización.
            // PixelFormat es un objeto que describe el formato de píxeles que se utilizará 
            //en la ventana. En este caso, se está utilizando un objeto PixelFormat vacío, lo que significa 
            //que se utilizará el formato de píxeles predeterminado del sistema.
            Display.create(new PixelFormat(), attribs);
        } catch (LWJGLException ex) {
            Logger.getLogger(diaplayManager.class.getName()).log(Level.SEVERE, null, ex);
        }
        /*
        se utiliza en el contexto de OpenGL para establecer el área de la ventana
        de visualización en la que se realizarán las operaciones de renderizado. 
         */
        GL11.glViewport(0, 0, WIDTH, HEIGHT);
    }
    public static void updateDisplay(){
        Display.sync(FPS_CAP);
        Display.update();
    }
    public static void closeDisplay(){
        Display.destroy();
    }

}
