package com.sinhvien.service;

import java.util.List;

import com.sinhvien.entity.SinhVien;
import com.sinhvien.vo.SinhVien_Khoa_VO;

public interface SinhVienService {
	public List<SinhVien_Khoa_VO> findAllVo();
	public void saveSinhVien(SinhVien sv);
	public SinhVien_Khoa_VO findVoById(int id);
	public void deleteById(int id);
	public List<SinhVien> findAllSv();
	public SinhVien findById(int id);
}
