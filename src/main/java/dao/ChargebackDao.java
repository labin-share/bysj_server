package dao;

import org.springframework.stereotype.Repository;

import entity.Chargeback;

@Repository
public class ChargebackDao extends BaseDao<Chargeback>{

	public ChargebackDao() {
		super(Chargeback.class);
	}

}
