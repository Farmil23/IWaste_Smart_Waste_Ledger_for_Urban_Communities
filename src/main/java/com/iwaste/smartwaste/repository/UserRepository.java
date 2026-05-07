// Dikerjakan oleh: Moch. Riezky Dwi Kuswanto
// Direvisi oleh: Farhan Kamil Hermansyah
package com.iwaste.smartwaste.repository;

import com.iwaste.smartwaste.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

// revisi
@Repository
public interface UserRepository extends JpaRepository<User, Long> {
}
