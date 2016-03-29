package common;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.Order;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

public class CriteriaBuilderPersonal {
	public static String DESC = "desc";
	public static String ASC = "asc";
	private Predicate predicates;
	private CriteriaBuilder criteriaBuilder;
	private Root<?> root;
	private List<Order> orders;

	public CriteriaBuilderPersonal(CriteriaBuilder cirteriaBuilder, Root<?> root) {
		this.criteriaBuilder = cirteriaBuilder;
		this.root = root;
		orders = new ArrayList<Order>();
	}

	public void and(String property, String value) {
		if (predicates == null) {
			predicates = criteriaBuilder.equal(root.get(property), value);
		} else {
			Predicate newP = criteriaBuilder.equal(root.get(property), value);
			predicates = criteriaBuilder.and(newP, predicates);
		}
	}

	public Predicate getPredicates() {
		return predicates;
	}

	public void and(String property, Object value) {
		if (predicates == null) {
			predicates = criteriaBuilder.equal(root.get(property), value);
		} else {
			Predicate newP = criteriaBuilder.equal(root.get(property), value);
			predicates = criteriaBuilder.and(newP, predicates);
		}
	}

	public void or(String property, Object value) {
		if (predicates == null) {
			predicates = criteriaBuilder.equal(root.get(property), value);
		} else {
			Predicate newP = criteriaBuilder.equal(root.get(property), value);
			predicates = criteriaBuilder.or(newP, predicates);
		}
	}
	
	public void notEqual(String property, Object value){
		if (predicates == null) {
			predicates = criteriaBuilder.notEqual(root.get(property), value);
		} else {
			Predicate newP = criteriaBuilder.notEqual(root.get(property), value);
			predicates = criteriaBuilder.and(newP, predicates);
		}
	}

	public void addOrder(String property, String order) {
		if (order.equals(this.ASC)) {
			this.orders.add(this.criteriaBuilder.asc(root.get(property)));
		} else if (order.equals(this.DESC)) {
			this.orders.add(this.criteriaBuilder.asc(root.get(property)));
		}
	}

	public List<Order> getOrders() {
		return orders;
	}

}
