package com.iwaste.smartwaste.model;

import com.iwaste.smartwaste.exception.InvalidWeightException;
import jakarta.persistence.*;

@Entity
@Table(name = "transaction_details")
public class TransactionDetail {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "transaction_id", nullable = false)
    private Transaction transaction;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "category_id", nullable = false)
    private WasteCategory category;

    @Column(name = "berat_kg", nullable = false)
    private double beratKg;

    @Column(name = "sub_poin", nullable = false)
    private int subPoin;

    // Encapsulation - Getters and Setters

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public Transaction getTransaction() { return transaction; }
    public void setTransaction(Transaction transaction) { this.transaction = transaction; }

    public WasteCategory getCategory() { return category; }
    public void setCategory(WasteCategory category) { this.category = category; }

    public double getBeratKg() { return beratKg; }
    
    public void setBeratKg(double beratKg) {
        if (beratKg <= 0) {
            throw new InvalidWeightException("Berat sampah harus bernilai lebih dari 0 kg.");
        }
        this.beratKg = beratKg;
    }

    public int getSubPoin() { return subPoin; }
    public void setSubPoin(int subPoin) { this.subPoin = subPoin; }
}
