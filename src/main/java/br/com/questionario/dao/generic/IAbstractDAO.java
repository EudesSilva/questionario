 package br.com.questionario.dao.generic;

import java.io.Serializable;
import java.util.List;
import org.hibernate.criterion.DetachedCriteria;
/**
 *
 * @author EudesSilva
 * 
 */
 
/**
 *
 * @author EudesSilva
 * @param <T> entity eg. User
 * @param <PK>   key eg. Long
 */
public interface IAbstractDAO<T, PK extends Serializable> {
    
    public  T findById(PK key);

    public void persist(T entity);
    
    public void delete(T entity);
    
    public void merge(T entity);
    
    public void update(T entity);
    
    public void save(T entity);
    
    public void saveOrUpdate(T entity);
    
    public  T getBean(Serializable codigo);

    public  T getUnique(DetachedCriteria criteria);
    
    public  List<T> getListCriteria( DetachedCriteria criteria);
    
    public  List<T> getAll();
    
    
}
