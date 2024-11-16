package com.polstat.ploker.service;

import com.polstat.ploker.entity.User;
import com.polstat.ploker.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Collections;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        // Cari user berdasarkan email
        User user = userRepository.findByEmail(email);

        // Jika user tidak ditemukan, lempar exception
        if (user == null) {
            throw new UsernameNotFoundException("User not found with email: " + email);
        }

        // Menambahkan authorities atau roles (contoh: "ROLE_USER")
        return org.springframework.security.core.userdetails.User.builder()
                .username(user.getEmail())
                .password(user.getPassword())
                .authorities(getAuthorities(user)) // Ambil otoritas (roles)
                .build();
    }

    // Metode untuk mendapatkan authorities/roles dari user
    private Collection<SimpleGrantedAuthority> getAuthorities(User user) {
        // Misalkan user punya role dalam bentuk string, dan kita tambahkan prefix ROLE_
        return Collections.singletonList(new SimpleGrantedAuthority("ROLE_USER"));
        // Jika user memiliki lebih dari satu peran, Anda bisa mengembalikan lebih dari satu SimpleGrantedAuthority
        // Contoh:
        // return Arrays.asList(
        //    new SimpleGrantedAuthority("ROLE_USER"),
        //    new SimpleGrantedAuthority("ROLE_ADMIN")
        // );
    }
}