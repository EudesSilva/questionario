package br.com.questionario.util;

 
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author EudesSilva
 * 
 */
public class LoggerQuestionario{

     // http://www.slf4j.org/manual.html
    // http://saltnlight5.blogspot.com.br/2013/08/how-to-configure-slf4j-with-different.html
    
   
  public static Logger logger;
    
  public LoggerQuestionario(Class<?> clazz){
     logger = LoggerFactory.getLogger( clazz );   
    
  } 
   
   
   
    
}