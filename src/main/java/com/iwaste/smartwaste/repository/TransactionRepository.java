// Dikerjakan oleh: Najwa Hikmatyar
package com.iwaste.smartwaste.repository;

import com.iwaste.smartwaste.model.Transaction;
import com.iwaste.smartwaste.model.TransactionStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TransactionRepository extends JpaRepository<Transaction, Long> {

    List<Transaction> findByUserId(Long userId);

    List<Transaction> findByStatus(TransactionStatus status);

    List<Transaction> findByUserIdAndStatus(Long userId, TransactionStatus status);
}