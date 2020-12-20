package com.example.intern.service.impl;

import java.util.Set;
import java.util.HashSet;

import com.example.intern.model.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.example.intern.exception.ResourceNotFoundException;
import com.example.intern.model.TaiKhoan;
import com.example.intern.repository.TaiKhoanRepository;
import com.example.intern.service.ITaiKhoanService;

@Service(value = "userService")
public class TaiKhoanService implements UserDetailsService, ITaiKhoanService {
	
	@Autowired
	private TaiKhoanRepository taikhoanRepository;
	
//	@Override
//	public List<TaiKhoan> queryByUsernameAndSdt(String email, String sdt) throws ResourceNotFoundException{
//		if(email == null && sdt == null) return taikhoanRepository.findAll();
//		if(email == null ) {
//			List<TaiKhoan> taikhoan = taikhoanRepository.findBySdtContaining(sdt);
//			if( taikhoan.size() ==0 ) throw new ResourceNotFoundException("TaiKhoan","sdt",sdt);
//			return taikhoan;
//		}
//		if(sdt == null) {
//			List<TaiKhoan> taikhoan = taikhoanRepository.findByUsernameContaining(email);
//			if( taikhoan.size() ==0 ) throw new ResourceNotFoundException("TaiKhoan", "email",email);
//			return taikhoan;
//		}
//		List<TaiKhoan> taikhoan = taikhoanRepository.findByUsernameContainingAndSdtContaining(email,sdt);
//		if( taikhoan.size() ==0 ) throw new ResourceNotFoundException("TaiKhoan");
//		return taikhoan;
//	}
	
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        TaiKhoan user = taikhoanRepository.findByUsername(username);
        if (user == null) {
            throw new UsernameNotFoundException("Invalid username or password.");
        }
        Set<GrantedAuthority> grantedAuthorities = new HashSet<>();
        Set<Role> roles = user.getRoles();
        for (Role role : roles) {
            grantedAuthorities.add(new SimpleGrantedAuthority(role.getName().name()));
        }
        return new org.springframework.security.core.userdetails.User(String.valueOf(user.getId()), user.getPassword(), grantedAuthorities);
    }
	
	
	@Override
	public TaiKhoan getOneById(Long id) throws ResourceNotFoundException{
		TaiKhoan taikhoan = taikhoanRepository.findOne(id);
		if(taikhoan == null) throw new ResourceNotFoundException("TaiKhoan", "id", id);
		return taikhoan;
	}
	
	@Override
	public TaiKhoan save(TaiKhoan taikhoan) {
		return taikhoanRepository.save(taikhoan);
	}
	
	@Override
	public void delete(Long id) {
		taikhoanRepository.delete(id);
	}

}
