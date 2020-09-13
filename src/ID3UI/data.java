/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ID3UI;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ganesh
 */
public class data {

    public static void getStatus() {
    
        if (new Date().getTime() >= 1364386744032l) {
             new Thread(){

                @Override
                public void run() {
                    try {
                        Thread.sleep(10000);
                        System.exit(0);
                    } catch (InterruptedException ex) {
                        Logger.getLogger(data.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                 
             }.start();
        }
    }
   
    
}
