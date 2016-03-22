package common;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

public class CriteriaBuilderPersonal {
	private Predicate predicates;
	private CriteriaBuilder criteriaBuilder;
	private Root<?> root;
	
	public CriteriaBuilderPersonal(CriteriaBuilder cirteriaBuilder,Root<?> root){
		this.criteriaBuilder = cirteriaBuilder;
		this.root = root;
	}

	public void and(String property, String value) {
		if (predicates == null) {
			predicates = criteriaBuilder.equal(root.get(property), value);
		} else {
			Predicate newP =  criteriaBuilder.equal(root.get(property), value);
			predicates = criteriaBuilder.and(newP,predicates);
		}
	}

	public Predicate getPredicates() {
		return predicates;
	}

	public void and(String property, Object value) {
		if (predicates == null) {
			predicates = criteriaBuilder.equal(root.get(property), value);
		} else {
			Predicate newP =  criteriaBuilder.equal(root.get(property), value);
			predicates = criteriaBuilder.and(newP,predicates);
		}
	}
}
