package by.topolev.dao;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;


public class GenericDaoImpl<T> implements GenericDao<T> {

	protected EntityManager em = Persistence.createEntityManagerFactory("TOPOLEV").createEntityManager();
	public Class<T> type;
	
	GenericDaoImpl(Class<T> type){
		this.type = type;
	};

	public List<T> findAll() {
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<T> cq = cb.createQuery(type);
		Root<T> from = cq.from(type);
		CriteriaQuery<T> select = cq.select(from);
		TypedQuery<T> q = em.createQuery(cq);
		List<T> allitems = q.getResultList();
		return allitems;
	}



	public T create (T entity){
		em.getTransaction().begin();
		em.persist(entity);
		em.getTransaction().commit();
		return entity;
	}

	public void delete (T entity){

		//em.merge(entity);
		em.getTransaction().begin();
		em.remove(em.contains(entity) ? entity : em.merge(entity));
		em.getTransaction().commit();

	}

}
