package by.topolev.dao;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;


public class GenericDaoImpl<T> implements GenericDao<T> {

	private EntityManager em = Persistence.createEntityManagerFactory("TOPOLEV").createEntityManager();
	public Class<T> type;
	
	GenericDaoImpl(Class<T> type){
		this.type = type;
	};

	public List<T> findAll() {
		em.getTransaction().begin();
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<T> cq = cb.createQuery(type);
		Root<T> from = cq.from(type);
		CriteriaQuery<T> select = cq.select(from);
		TypedQuery<T> q = em.createQuery(cq);
		List<T> allitems = q.getResultList();
		em.getTransaction().commit();
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
		System.out.println(em.contains(entity));
		em.remove(em.contains(entity) ? entity : em.merge(entity));
		em.getTransaction().commit();

	}

}
