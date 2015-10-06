package br.com.test;

import java.net.URI;
import java.util.LinkedHashMap;
import java.util.List;
import org.springframework.web.client.RestTemplate;
/**
 *
 * @author EudesSilva
 * 
 */
 
public class SpringRestFullTestClient {

    public static class Person { 
        private long id; 
        private String name; 
        private int age; 
        private double salary; 
       public Person(long id, String name, int age, double salary){
        this.id = id;
        this.name = name;
        this.age = age;
        this.salary = salary;
    }
    }
    
    
    private static final String TAG = "REST FULL TEST::::::::::: ";
    private static final String ACCEPT = "ACCEPT::::::::::: ";
    public static final String URI_REST = "http://localhost:8080/questionario";
     
    
    
    
    
    /* GET */
    private static void listAll(){
        System.out.println(ACCEPT+" listAll()");
         
        RestTemplate restTemplate = new RestTemplate();
        List<LinkedHashMap<String, Object>> usersMap = restTemplate.getForObject(URI_REST+"/user/", List.class);
         
        if(usersMap!=null){
            for(LinkedHashMap<String, Object> map : usersMap){
                System.out.println("Person : id="+map.get("id")+", Name="+map.get("name")+", Age="+map.get("age")+", Salary="+map.get("salary"));;
            }
        }else{
            System.out.println(TAG+" NOT FOUND ");
        }
    }
     
    /* GET */
    private static void getSingle(){
        System.out.println(ACCEPT+" getSingle()"); 
        RestTemplate restTemplate = new RestTemplate();
        Person user = restTemplate.getForObject(URI_REST+"/person/1", Person.class);
        System.out.println(user);
    }
     
    /* POST */
    private static void create() {
        System.out.println(ACCEPT+" create()"); 
        RestTemplate restTemplate = new RestTemplate();
        Person person = new Person(0, "Barth", 19, 2900);
        URI uri = restTemplate.postForLocation(URI_REST+"/person/", person, Person.class);
        System.out.println("Location : "+uri.toASCIIString());
    }
 
    /* PUT */
    private static void update() { 
        System.out.println(ACCEPT+" update()"); 
        RestTemplate restTemplate = new RestTemplate();
        Person user  = new Person(1, "Mart", 54, 39222);
        restTemplate.put(URI_REST+"/user/1", user);
        System.out.println(user);
    }
 
    /* DELETE */
    private static void delete() {
        System.out.println(ACCEPT+" delete()");  
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.delete(URI_REST+"/person/3");
    }
 
 
    /* DELETE */
    private static void deleteAll() {
         System.out.println(ACCEPT+" deleteAll()"); 
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.delete(URI_REST+"/person/");
    }
 
    public static void main(String args[]){
        listAll();
        getSingle();
        create();
        listAll();
        update();
        listAll();
        delete();
        listAll();
        deleteAll();
        listAll();
    }
    
    
} 