package br.com.questionario.util;

 
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author EudesSilva 
 * 
 */
public class MyLogger{

     // http://www.slf4j.org/manual.html
    // http://saltnlight5.blogspot.com.br/2013/08/how-to-configure-slf4j-with-different.html
    
  
  public static Class<?> classLogger;
  private static Logger logger; 
  
  
  private MyLogger(Class<?> clazz){
     MyLogger.classLogger = clazz;
     logger = LoggerFactory.getLogger( clazz );   
    
  } 
   
  public static MyLogger configLog(Class<?> classLogger){  
    return new MyLogger(classLogger);
  }
  
  
  public final void myLog(String infoLog){
    logger.info(""); 
    logger.info("---------------------" + classLogger.getName() +"--------------------");
    logger.info( infoLog );  
    logger.info("");   
  }
   
   
    
}