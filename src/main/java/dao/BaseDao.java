package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Order;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import common.CriteriaBuilderPersonal;

public class BaseDao<T> {
	private EntityManagerFactory emfactory;
	private EntityManager entitymanager;
	private CriteriaBuilder criteriaBuilder;
	private CriteriaQuery<T> criteriaQuery;
	private Root<T> root;
	private String TABLE_NAME;
	private Class<T> cls;

	public BaseDao(Class<T> cls) {
		emfactory = Persistence.createEntityManagerFactory("eclipselink");
		entitymanager = emfactory.createEntityManager();
		criteriaBuilder = entitymanager.getCriteriaBuilder();
		criteriaQuery = criteriaBuilder.createQuery(cls);
		root = criteriaQuery.from(cls);
		TABLE_NAME = cls.getSimpleName();
		this.cls = cls; // ��ȡ�����cls
	}

	public EntityManagerFactory getEmfactory() {
		return emfactory;
	}

	public EntityManager getEntitymanager() {
		return entitymanager;
	}

	public CriteriaBuilder getCriteriaBuilder() {
		return criteriaBuilder;
	}

	public CriteriaBuilderPersonal getCriteriaBuilderPersonal() {
		return new CriteriaBuilderPersonal(criteriaBuilder, root);
	}

	public CriteriaQuery<T> getCriteriaQuery() {
		return criteriaQuery;
	}

	public Root<T> getRoot() {
		return root;
	}

	public List<T> execute(CriteriaBuilderPersonal criteriaBuilderPersonal) {
		criteriaQuery.where(criteriaBuilderPersonal.getPredicates());
		List<Order> orders = criteriaBuilderPersonal.getOrders();
		if(orders!=null && !orders.isEmpty()){
			criteriaQuery.orderBy(orders);
		}
		TypedQuery typedQuery = entitymanager.createQuery(criteriaQuery);
		return (List<T>) typedQuery.getResultList();
	}

	public T persist(T t) {
		entitymanager.getTransaction().begin();
		// entitymanager.persist(t);
		T r = entitymanager.merge(t);
		entitymanager.getTransaction().commit();
		// entitymanager.close();
		return r;
	}

	public void remove(T t) {
		entitymanager.getTransaction().begin();
		// entitymanager.persist(t);
		entitymanager.remove(t);
		entitymanager.getTransaction().commit();
		// entitymanager.close();
	}

	public void persistAll(List<T> tList) {
		for (T t : tList) {
			this.persist(t);
		}
	}

	public void update(T t) throws Exception {
		entitymanager.getTransaction().begin();
		entitymanager.merge(t); // �����db�в����ڵļ�¼��merge����Ϊ����persistһ��������¼�¼����������Ǵ��ڵģ����Ǹ���db�е����ݡ�
		entitymanager.getTransaction().commit();
	}

	public T findById(int id) {
		return (T) entitymanager.find(cls, id);
	}

	public List<T> findAll() {
		// ʹ��jpql��䣬ע�ⲻ��sql��䣬������ܻ����
		Query query = entitymanager.createQuery("SELECT t" + " FROM "
				+ TABLE_NAME + " t");
		return query.getResultList();
	}

}
