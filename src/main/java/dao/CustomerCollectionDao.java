package dao;

import org.springframework.stereotype.Repository;

import entity.CustomerCollection;

@Repository
public class CustomerCollectionDao extends BaseDao<CustomerCollection> {

	public CustomerCollectionDao() {
		super(CustomerCollection.class);
	}

}
