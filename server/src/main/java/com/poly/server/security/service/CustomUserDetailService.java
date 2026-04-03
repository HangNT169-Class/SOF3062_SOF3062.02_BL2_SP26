package com.poly.server.security.service;

import com.poly.server.entity.TaiKhoan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomUserDetailService implements UserDetailsService {
    /**
     * Spring security:
     * Authen -> Author:
     * 401    -> 403
     * Tai khoan/ User: SELECT * FROM User WHERE username & password => repo (Entity)
     * Security => UserDetails: convert Entity to UserDetails
     * password => Bcrypt.. => Luu trong CSDL => luu duoi dang da ma hoa mk
     */

    @Autowired
    private PasswordEncoder passwordEncoder;

    // Fake data
    private final List<TaiKhoan> listTaiKhoan = List.of(
            new TaiKhoan("admin", "12345678", "ADMIN"),
            new TaiKhoan("user", "123456", "USER")
    );

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        // B1: Lay ra doi tuong tai khoan
        // Neu dung CSDl => lay ham trong repository
        TaiKhoan tk = listTaiKhoan.stream()
                .filter(s -> s.getUsername().equalsIgnoreCase(username))
                .findFirst()
                .orElseThrow(() -> new UsernameNotFoundException("Tai khoan khong ton tai"));
        // B2: Custom tu Tai khoan -> UserDetails
        UserDetails userDetails = User.withUsername(tk.getUsername())
                .password(passwordEncoder.encode(tk.getPassword()))
                .roles(tk.getRole())
                .build();
        return userDetails;
    }
}
