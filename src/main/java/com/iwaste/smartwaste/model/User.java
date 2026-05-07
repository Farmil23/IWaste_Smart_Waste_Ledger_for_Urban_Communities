// Dikerjakan oleh: Moch. Riezky Dwi Kuswanto
package com.iwaste.smartwaste.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 100)
    private String nama;

    @Column(nullable = false, unique = true, length = 50)
    private String username;

    @Column(nullable = false, length = 255)
    private String password;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Role role = Role.WARGA;

    @Column(name = "saldo_poin", nullable = false)
    private int saldoPoin = 0;

    @Column(name = "no_hp", length = 20)
    private String noHp;

    @Column(name = "created_at", nullable = false, updatable = false)
    private LocalDateTime createdAt;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<Transaction> transactions;

    @PrePersist
    protected void onCreate() {
        createdAt = LocalDateTime.now();
    }

    // Encapsulation - Getters and Setters

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getNama() { return nama; }
    public void setNama(String nama) { this.nama = nama; }

    public String getUsername() { return username; }
    public void setUsername(String username) { this.username = username; }

    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }

    public Role getRole() { return role; }
    public void setRole(Role role) { this.role = role; }

    public int getSaldoPoin() { return saldoPoin; }
    public void setSaldoPoin(int saldoPoin) { this.saldoPoin = saldoPoin; }

    public String getNoHp() { return noHp; }
    public void setNoHp(String noHp) { this.noHp = noHp; }

    public LocalDateTime getCreatedAt() { return createdAt; }
    public void setCreatedAt(LocalDateTime createdAt) { this.createdAt = createdAt; }

    public List<Transaction> getTransactions() { return transactions; }
    public void setTransactions(List<Transaction> transactions) { this.transactions = transactions; }

   
    public void addPoin(int poin) {
        if (poin > 0) {
            this.saldoPoin += poin;
        }
    }

    public void subtractPoin(int poin) {
        if (poin > 0 && this.saldoPoin >= poin) {
            this.saldoPoin -= poin;
        } else if (poin > this.saldoPoin) {
            throw new IllegalArgumentException("Saldo poin tidak mencukupi");
        }
    }
}
