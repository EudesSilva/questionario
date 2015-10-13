package br.com.tool;

import br.com.questionario.model.AuthorityType;
import br.com.questionario.model.Destinatario;
import br.com.questionario.model.Gabarito;
import br.com.questionario.model.Pergunta;
import br.com.questionario.model.Questionario;
import br.com.questionario.model.Resposta;
import br.com.questionario.model.Usuario;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;
import org.hibernate.tool.hbm2ddl.SchemaExport;
/**
 *
 * @author EudesSilva
 * 
 */


public class HibernateDDLGenerator {
 
 private final static String PASSWD = "root";
 private final static String USER = ""; 
 private final static String SCHEMA = "question"; 
    
     
 private final static String MYSQL = "org.hibernate.dialect.MySQLInnoDBDialect";
 private final static String ORACLE = "org.unhcr.omss.db.oracle.OracleDialectDeferredFK"; 
 private final static String SYBASE = "org.hibernate.dialect.SybaseAnywhereDialect"; 
 

  
    public static void main(String[] args) { 
        
        new HibernateDDLGenerator().execute( MYSQL, Resposta.class, Gabarito.class,
                Destinatario.class, Pergunta.class, Questionario.class, Usuario.class, AuthorityType.class );
    }
 
 
  private void execute(String className, Class<?>... classes) {
 	 //AnnotationConfiguration configuration = new AnnotationConfiguration();
         Configuration configuration = new Configuration();
	 configuration.setProperty(Environment.DIALECT, className )
        .setProperty("hibernate.connection.username", PASSWD)
        .setProperty("hibernate.connection.password", USER)
        .setProperty("hibernate.connection.url", "jdbc:mysql://localhost:3306/"+SCHEMA+"?zeroDateTimeBehavior=convertToNull")
        .setProperty("hibernate.connection.driver_class", "com.mysql.jdbc.Driver") 
        .setProperty("hibernate.dialect", "org.hibernate.dialect.MySQLInnoDBDialect")       
        .setProperty("hibernate.order_updates", "true")
        .setProperty("hibernate.format_sql", "true")
        .setProperty("hibernate.show_sql", "true")
        .setProperty("hibernate.hbm2ddl.auto", "create"); 
         
         
	 for (Class<?> entityClass : classes) {
	    configuration.addAnnotatedClass(entityClass);
	 }
	SchemaExport schemaExport = new SchemaExport(configuration);
	//schemaExport.setDelimiter(";");
       // schemaExport.setOutputFile(String.format("%s_%s.%s ", new Object[] {"ddl",className.toLowerCase(), "sql" }));
        
	boolean consolePrint = true;
	boolean exportInDatabase = true;
	schemaExport.create(consolePrint, exportInDatabase);
   }
  
}
