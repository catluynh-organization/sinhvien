package com.sinhvien.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sinhvien.entity.SinhVien;
import com.sinhvien.service.SinhVienService;
import com.sinhvien.vo.SinhVien_Khoa_VO;

@RestController
@RequestMapping("/sinhvien")
public class SinhVienRestController {
	@Autowired
	private SinhVienService sinhVienService;
	
	@GetMapping("")
	public List<SinhVien_Khoa_VO> findAll(){
		return sinhVienService.findAllVo();
	}
	
	@GetMapping("{id}")
	public SinhVien_Khoa_VO findAll(@PathVariable int id){
		return sinhVienService.findVoById(id);
	}
	
	@PostMapping("")
	public void saveSinhVien(@RequestBody SinhVien sv) {
		sinhVienService.saveSinhVien(sv);
	}
	
	@PutMapping("")
	public void updateSinhVien(@RequestBody SinhVien sv) {
		sinhVienService.saveSinhVien(sv);
	}
	
	@DeleteMapping("{id}")
	public void delete(@PathVariable int id) {
		sinhVienService.deleteById(id);
	}
	
}
