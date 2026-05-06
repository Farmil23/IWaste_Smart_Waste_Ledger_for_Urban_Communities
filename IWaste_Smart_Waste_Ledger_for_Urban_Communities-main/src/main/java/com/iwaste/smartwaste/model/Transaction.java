package com.iwaste.smartwaste.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "transactions")
public class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @Column(name = "tanggal_setor", nullable = false, updatable = false)
    private LocalDateTime tanggalSetor;

    @Column(name = "total_poin_didapat", nullable = false)
    private int totalPoinDidapat = 0;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private TransactionStatus status = TransactionStatus.ACTIVE;

    @Column(name = "voided_at")
    private LocalDateTime voidedAt;

    @OneToMany(mappedBy = "transaction", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<TransactionDetail> details = new ArrayList<>();

    @PrePersist
    protected void onCreate() {
        tanggalSetor = LocalDateTime.now();
    }

    // Encapsulation - Getters and Setters

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public User getUser() { return user; }
    public void setUser(User user) { this.user = user; }

    public LocalDateTime getTanggalSetor() { return tanggalSetor; }
    public void setTanggalSetor(LocalDateTime tanggalSetor) { this.tanggalSetor = tanggalSetor; }

    public int getTotalPoinDidapat() { return totalPoinDidapat; }
    public void setTotalPoinDidapat(int totalPoinDidapat) { this.totalPoinDidapat = totalPoinDidapat; }

    public TransactionStatus getStatus() { return status; }
    
    public void setStatus(TransactionStatus status) {
        if (this.status == TransactionStatus.ACTIVE && status == TransactionStatus.VOID) {
            this.voidedAt = LocalDateTime.now();
        }
        this.status = status;
    }

    public LocalDateTime getVoidedAt() { return voidedAt; }
    public void setVoidedAt(LocalDateTime voidedAt) { this.voidedAt = voidedAt; }

    public List<TransactionDetail> getDetails() { return details; }
    public void setDetails(List<TransactionDetail> details) { this.details = details; }

    // Helper Method
    public void addDetail(TransactionDetail detail) {
        details.add(detail);
        detail.setTransaction(this);
    }
    
    public void calculateTotal() {
        this.totalPoinDidapat = details.stream().mapToInt(TransactionDetail::getSubPoin).sum();
    }
}
