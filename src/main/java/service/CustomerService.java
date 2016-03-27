package service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import common.ImgAssistant;
import common.ResponseInfo;
import constant.ComConstant;
import constant.CustomerConstant;
import constant.ImgConstant;
import constant.LoginConstant;
import constant.RegisterConstant;
import dao.CustomerCollectionDao;
import dao.CustomerDao;
import dao.MantainerDAO;
import dto.CustomerDTO;
import dto.LoginDTO;
import dto.MantainerDTO;
import dto.RegisterDTO;
import dto.SimpleDTO;
import dtoMapper.CustomerDTOMapper;
import dtoMapper.MantainerDTOMapper;
import entity.Customer;
import entity.CustomerCollection;
import entity.Mantainer;

@Service
public class CustomerService extends BaseService{

	@Autowired
	CustomerDao customerDao;
	@Autowired
	CustomerCollectionDao customerCollectionDao;
	@Autowired
	MantainerDAO mtnDao;
	ObjectMapper mapper = new ObjectMapper();

	public ResponseInfo login(LoginDTO dto) throws JsonProcessingException {
		ResponseInfo resp = new ResponseInfo();
		List<Customer> customerList = this.customerDao.login(dto);
		if (customerList.isEmpty()) {
			resp.setStatus(false);
			resp.setMsg(LoginConstant.VERRIFY_ERRO);
			return resp;
		} else {
			SimpleDTO simpleDTO = new SimpleDTO(customerList.get(0).getId(),
					customerList.get(0).getName());
			resp.setData(this.mapper.writeValueAsString(simpleDTO));
		}
		return resp;
	}

	public String register(String registerDTOStr) throws Exception {
		ResponseInfo resp = new ResponseInfo();
		RegisterDTO registerDTO = this.mapper.readValue(registerDTOStr,
				RegisterDTO.class);
		try {
			List<Customer> customerList = this.customerDao
					.findByPhone(registerDTO.getPhone());
			if (customerList.isEmpty() || customerList == null) {
				this.customerDao.persist(CustomerDTOMapper
						.toEntityFromRegisterDTO(registerDTO));
			} else {
				resp.setStatus(false);
				resp.setMsg(RegisterConstant.DUPLICATE_REGISTER);
			}
		} catch (Exception e) {
			resp.setStatus(false);
			resp.setMsg(ComConstant.SYS_ERRO);
			e.printStackTrace();
		}
		return this.mapper.writeValueAsString(resp);
	}

	public String findById(int id) throws JsonProcessingException {
		Customer customer = this.customerDao.findById(id);
		return this.mapper.writeValueAsString(customer);
	}

	// public String modifyPersonalInfo(String customerDtoStr, MultipartFile
	// img)
	// throws Exception {
	// ResponseInfo resp = new ResponseInfo();
	// CustomerDTO customerDTO = this.mapper.readValue(customerDtoStr,
	// CustomerDTO.class);
	// Customer customer = CustomerDTOMapper.toEntity(customerDTO);
	// String catalogPath = ImgConstant.ROOT + ImgConstant.TYPE_HEAD
	// + customerDTO.getId();
	// String oldPath = this.customerDao.findById(customerDTO.getId())
	// .getHeadPortrait();
	// String newPath = ImgAssistant.updateImg(img, catalogPath, oldPath);
	// customer.setHeadPortrait(newPath);
	// try {
	// this.customerDao.persist(customer);
	// } catch (Exception e) {
	// resp.setStatus(false);
	// resp.setMsg(ComConstant.SYS_ERRO);
	// }
	// return this.mapper.writeValueAsString(resp);
	// }

	public String modifyPersonalInfo(String customerDtoStr) throws Exception {
		ResponseInfo resp = new ResponseInfo();
		CustomerDTO customerDTO = this.mapper.readValue(customerDtoStr,
				CustomerDTO.class);
		Customer customer = CustomerDTOMapper.toEntity(customerDTO);
		List<Customer> customerList = this.customerDao.findByName(customer
				.getName());
		if (customerList == null && customerList.isEmpty()) {
			resp.setStatus(false);
			resp.setMsg(CustomerConstant.DUPLICATE_NAME);
			return this.mapper.writeValueAsString(resp);
		}
		try {
			this.customerDao.persist(customer);
		} catch (Exception e) {
			resp.setMsg(ComConstant.SYS_ERRO);
			resp.setStatus(false);
		}
		return this.mapper.writeValueAsString(resp);
	}

	public String modifyHeadPortrait(int id, MultipartFile img)
			throws IOException {
		ResponseInfo resp = new ResponseInfo();
		Customer customer = this.customerDao.findById(id);
		String catalogPath = ImgConstant.ROOT + ImgConstant.TYPE_HEAD + id;
		String oldPath = customer.getHeadPortrait();
		try {
			String newPath = ImgAssistant.updateImg(img, catalogPath, oldPath);
			customer.setHeadPortrait(newPath);
		} catch (Exception e) {
			resp.setStatus(false);
			resp.setMsg(ComConstant.SYS_ERRO);
		}
		return this.mapper.writeValueAsString(resp);
	}

	public String changePsw(int id, String psw) throws JsonProcessingException {
		ResponseInfo resp = new ResponseInfo();
		Customer customer = this.customerDao.findById(id);
		customer.setPsw(psw);
		try {
			this.customerDao.persist(customer);
		} catch (Exception e) {
			resp.setStatus(false);
			resp.setMsg(ComConstant.SYS_ERRO);
		}
		return this.mapper.writeValueAsString(resp);
	}

	public String collectMtn(int customerId, int mtnId)
			throws JsonProcessingException {
		ResponseInfo resp = new ResponseInfo();
		CustomerCollection customerCollection = new CustomerCollection();
		customerCollection.setCustomerId(customerId);
		customerCollection.setMantainerId(mtnId);
		try {
			this.customerCollectionDao.persist(customerCollection);
		} catch (Exception e) {
			resp.setStatus(false);
			resp.setMsg(ComConstant.SYS_ERRO);
		}
		return this.mapper.writeValueAsString(customerCollection);
	}

	public String findMtnByLngLat(double longitude, double latitude,
			double distance) throws JsonProcessingException {
		List<Mantainer> mantainerList = this.mtnDao.findAll();
		List<MantainerDTO> usefulMantainerDTO = new ArrayList<MantainerDTO>();
		MantainerDTO mantainerDTO = null;
		double realDistance;
		for (Mantainer mantainer : mantainerList) {
			if (Double.compare((double) 0, mantainer.getLongitude()) != 0
					&& Double.compare((double) 0, mantainer.getLongitude()) != 0) {
				realDistance = calculateDistance(longitude, latitude,
						mantainer.getLongitude(), mantainer.getLatitude());
				if (Double.compare(realDistance, distance) <= 0) {
					mantainerDTO = MantainerDTOMapper.toMtnShowList(mantainer);
					mantainerDTO.setDistance(realDistance);
					usefulMantainerDTO.add(mantainerDTO);
				}
			}
		}
		return super.buildRespJson(true, EMPTY, super.getMapper().writeValueAsString(usefulMantainerDTO));
	}

	public double calculateDistance(double lat1, double lng1, double lat2,
			double lng2) {
		double EARTH_RADIUS = 6378.137;
		double radLat1 = rad(lat1);
		double radLat2 = rad(lat2);
		double radLng1 = rad(lng1);
		double radLng2 = rad(lng2);
		double radLat1RadLat2 = radLat1 - radLat2;
		double radLng1RadLng2 = radLng1 - radLng2;
		double s = 2 * Math.asin(Math.sqrt(Math.pow(
				Math.sin(radLat1RadLat2 / 2), 2)
				+ Math.cos(radLat1)
				* Math.cos(radLat2)
				* Math.pow(Math.sin(radLng1RadLng2 / 2), 2)));
		s = s * EARTH_RADIUS;
		s = Math.round(s * 10000) / 10000;
		return s;
	}

	private static double rad(double d) {
		return d * Math.PI / 180.0;
	}

}
