package dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import common.CriteriaBuilderPersonal;
import constant.CustomerCollectionConstant;
import entity.CustomerCollection;

@Repository
public class CustomerCollectionDao extends BaseDao<CustomerCollection> {

	public CustomerCollectionDao() {
		super(CustomerCollection.class);
	}

	public List<CustomerCollection> findByCustomerId(int customerId) {
		CriteriaBuilderPersonal builder = super.getCriteriaBuilderPersonal();
		builder.and(CustomerCollectionConstant.CUSTOMER, customerId);
		List<CustomerCollection> contactionList = super.execute(builder);
		return contactionList;
	}

}
