package com.iwaste.smartwaste.repository;

import com.iwaste.smartwaste.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Repository untuk entitas User.
 * Menangani operasi CRUD otomatis ke tabel users.
 */
@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    // Kamu juga bisa menambahkan query custom di sini jika nanti dibutuhkan, 
    // misalnya mencari user berdasarkan username:
    // Optional<User> findByUsername(String username);
}