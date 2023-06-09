package ayudadoc.helpers;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class AyudocLog {

    public static AyudocLog registro;
    private static Logger logger = null;

    public static synchronized AyudocLog getInstance()  {

        if (registro == null)    {
            registro = new AyudocLog();
        }
        return registro;
    }

    private AyudocLog()    {

        logger = LogManager.getLogger(AyudocLog.class);
    }
    
    public void log (String level, String mensaje)    {

        if (level!=null && level.toLowerCase().equals("debug"))
            logger.debug(mensaje);
        else if (level!=null && level.toLowerCase().equals("info"))
            logger.info(mensaje);
        else if (level!=null && level.toLowerCase().equals("warn"))
            logger.warn(mensaje);
        else if (level!=null && level.toLowerCase().equals("error"))
            logger.error(mensaje);
        else if (level!=null && level.toLowerCase().equals("fatal"))
            logger.fatal(mensaje);
        else
            logger.info(mensaje);
        
    }
}
