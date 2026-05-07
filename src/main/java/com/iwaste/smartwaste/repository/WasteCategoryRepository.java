
package com.iwaste.smartwaste.repository;

import com.iwaste.smartwaste.model.WasteCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WasteCategoryRepository extends JpaRepository<WasteCategory, Long> {
    // JpaRepository sudah menyediakan metode dasar seperti save(), findAll(), findById(), deleteById()
}

