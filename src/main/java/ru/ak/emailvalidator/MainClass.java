package ru.ak.emailvalidator;

import ru.ak.info.InfoService;

import javax.xml.ws.Endpoint;
import java.io.File;
import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Handler;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Основной класс
 * @author akakushin
 */
public class MainClass {

    private static Logger logger;
    
    public static Logger getInstanceLogger() {
        if (logger == null) {
            logger = Logger.getLogger("ru.ak.emailvalidator");
        }
        return logger;
    }
    
    public static void main(String[] args) throws IOException {
        
        if (System.getProperty("java.util.logging.config.class") == null
            && System.getProperty("java.util.logging.config.file") == null) {
            
            logger = getInstanceLogger();            
            try {                
                if (!existLogDir()) {
                    createLogDir();
                }                
                logger.setLevel(Level.ALL);
                final int LOG_ROTATION_COUNT = 10;
                Handler handler = new FileHandler("%h/logs/emailvalidator/emailvalidator.log", 0, LOG_ROTATION_COUNT);
                logger.addHandler(handler);
            } catch (IOException ex) {
                logger.log(Level.SEVERE, "Can't create log file handler", ex);
            }            
        }
               
        String port = "48800"; // default
        if (args.length == 2) {
            if (args[0].equalsIgnoreCase("-p")) {
            	port = args[1];
            }
        }
                        
        StringBuilder sbUriInfo = new StringBuilder();
        sbUriInfo.append("http://0.0.0.0:").append(port).append("/Info");
        
        try {        	
            Endpoint.publish(sbUriInfo.toString(), new InfoService());
            logger.log(Level.INFO, "Info : ok; port: {0}", port);
        
        } catch (Exception ex) {
            logger.log(Level.WARNING, "Error; {0}", ex.getLocalizedMessage());
        } 
                        
    }
    
    private static boolean createLogDir() { 
        String userHome = System.getProperty("user.home");
        File logDir = new File(userHome + "/logs/emailvalidator");
        
        return logDir.mkdirs();
    }
    
    private static boolean existLogDir() {
        File logDir = new File(System.getProperty("user.home") + "/logs/emailvalidator/");
        return logDir.isDirectory();
    }
}
