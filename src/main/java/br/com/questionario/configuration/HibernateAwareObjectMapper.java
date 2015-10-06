 
package br.com.questionario.configuration;

import com.fasterxml.jackson.databind.ObjectMapper;
//import com.fasterxml.jackson.datatype.hibernate4.Hibernate4Module; 
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
 

//@Configuration
public class HibernateAwareObjectMapper extends ObjectMapper {

 
//    @Bean
//    public ObjectMapper HibernateAwareObjectMapper(){
//      return registerModule(new Hibernate4Module());   
//    }
}