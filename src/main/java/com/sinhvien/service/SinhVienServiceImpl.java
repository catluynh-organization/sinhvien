package com.sinhvien.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.sinhvien.entity.SinhVien;
import com.sinhvien.repository.SinhVienRepository;
import com.sinhvien.vo.Khoa;
import com.sinhvien.vo.SinhVien_Khoa_VO;

@Service
public class SinhVienServiceImpl implements SinhVienService {
	@Autowired
	private SinhVienRepository sinhVienRepository;

	private RestTemplate restTemplate;
	private String crmRestUrl;

	@Autowired
	public SinhVienServiceImpl(RestTemplate RestTemplate, @Value("${crm.rest.url}") String RestUrl) {
		restTemplate = RestTemplate;
		crmRestUrl = RestUrl;
	}

	@Transactional
	@Override
	public List<SinhVien_Khoa_VO> findAllVo() {
		// TODO Auto-generated method stub
		List<SinhVien_Khoa_VO> listVo = new ArrayList<SinhVien_Khoa_VO>();
		
		List<SinhVien> listSV = findAllSv();
		for (SinhVien sv : listSV) {
		}
		ResponseEntity<List<Khoa>> responseEntity = restTemplate.exchange(crmRestUrl, HttpMethod.GET, null,
				new ParameterizedTypeReference<List<Khoa>>() {
				});
		List<Khoa> listKhoa = responseEntity.getBody();
		for (Khoa khoa : listKhoa) {
	
		}
	
		return listVo;
	}

	@Override
	public void saveSinhVien(SinhVien sv) {
		// TODO Auto-generated method stub
		sinhVienRepository.save(sv);
	}

	@Transactional
	@Override
	public SinhVien_Khoa_VO findVoById(int id) {
		// TODO Auto-generated method stub
		SinhVien_Khoa_VO vo = new SinhVien_Khoa_VO();
		SinhVien sv = findById(id);
		vo.setSinhVien(sv);
		Khoa khoa = restTemplate.getForObject(crmRestUrl + "/" + sv.getIdKhoa(), Khoa.class);
		vo.setKhoa(khoa);
		return vo;
	}

	@Override
	public void deleteById(int id) {
		// TODO Auto-generated method stub
		sinhVienRepository.deleteById(id);

	}

	@Override
	public List<SinhVien> findAllSv() {
		// TODO Auto-generated method stub
		return sinhVienRepository.findAll();
	}

	@Override
	public SinhVien findById(int id) {
		// TODO Auto-generated method stub
		Optional<SinhVien> rs = sinhVienRepository.findById(id);
		SinhVien sv = null;
		if (rs.isPresent()) {
			sv = rs.get();
		}
		return sv;
	}

}
