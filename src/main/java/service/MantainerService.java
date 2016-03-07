package service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import common.ResponseInfo;
import constant.LoginConstant;
import dao.MantainerDAO;
import dto.LoginDTO;
import dto.MantainerDTO;
import dtoMapper.MantainerDTOMapper;
import entity.Mantainer;

@Service
public class MantainerService {

	@Autowired
	MantainerDAO mantainerDao;
	
	public MantainerDTO findById(int id){
		Mantainer mantainer = this.mantainerDao.findById(id);
		return MantainerDTOMapper.toDTO(new MantainerDTO(), mantainer);
	}
	
	public ResponseInfo login(LoginDTO dto) {
		ResponseInfo resp = new ResponseInfo();
		List<Mantainer> MTNList = this.mantainerDao.login(dto);
		if(MTNList.isEmpty()){
			resp.setStatus(false);
			resp.setMsg(LoginConstant.VERRIFY_ERRO);
			return resp;
		}else{
			resp.setData(MTNList.get(0).getName());
		}
		return resp;
	}
	
}
