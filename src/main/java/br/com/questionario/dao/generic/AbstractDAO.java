package br.com.questionario.dao.generic;

import java.io.Serializable; 
import java.lang.reflect.ParameterizedType; 
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.DetachedCriteria;
import org.springframework.beans.factory.annotation.Autowired;
 /**
 *
 * @author EudesSilva
 * @param <PK> key    : eg. Long
 * @param <T>  entity : eg. User
 * 
 */
public abstract class AbstractDAO< PK extends Serializable, T > implements IAbstractDAO<T, PK>{
     
    private final Class<T> persistentClass;
    
    @Autowired
    private SessionFactory sessionFactory;
    
    public AbstractDAO(){
       this.persistentClass =(Class<T>) ((ParameterizedType) this.getClass().getGenericSuperclass()).getActualTypeArguments()[1];
    }

    protected Session getSession(){  
        return sessionFactory.getCurrentSession();
    }
  
    
    @Override
    public T findById(PK key) {
        return (T) getSession().get(persistentClass, key);
    }
 
    @Override
    public void persist(T entity) {
        getSession().persist(entity);
    }
 
    @Override
    public void delete(T entity) {
        getSession().delete(entity);
    }
    
    @Override
    public void merge(T entity){
        getSession().merge(entity);
    } 
    
    @Override
    public void update(T entity){
        getSession().update(entity);
    } 
    
    @Override
    public void save(T entity){
        getSession().save(entity);
    }   
    
    @Override
    public void saveOrUpdate(T entity){
        getSession().saveOrUpdate(entity);
    }    
    
    @Override
    public T getBean(Serializable codigo) {
        T bean = (T)getSession().get(persistentClass, codigo); 
        return bean;
    }
    
    @Override
    public T getUnique(DetachedCriteria criteria) {
        T bean = (T)criteria.getExecutableCriteria(getSession()).uniqueResult();
        return bean;
    }
    
    @Override
    public List<T> getListCriteria(DetachedCriteria criteria){
      return criteria.getExecutableCriteria(getSession()).list();
    } 

    @Override
    public List<T> getAll() {
        List<T> beans = (List<T>)getSession().createCriteria(persistentClass).list(); 
        return beans;
    }
    
 
 
}
