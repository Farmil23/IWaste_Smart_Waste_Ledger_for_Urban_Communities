package com.iwaste.smartwaste.model;

import jakarta.persistence.*;

@Entity
@Table(name = "waste_categories")
public class WasteCategory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private WasteType tipe;

    @Column(name = "nama_sampah", nullable = false, length = 100)
    private String namaSampah;

    @Column(name = "poin_per_kg", nullable = false)
    private int poinPerKg;

    @Column(columnDefinition = "TEXT")
    private String deskripsi;

    // Encapsulation - Getters and Setters

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public WasteType getTipe() { return tipe; }
    public void setTipe(WasteType tipe) { this.tipe = tipe; }

    public String getNamaSampah() { return namaSampah; }
    public void setNamaSampah(String namaSampah) { this.namaSampah = namaSampah; }

    public int getPoinPerKg() { return poinPerKg; }
    
    public void setPoinPerKg(int poinPerKg) {
        if (poinPerKg < 0) {
            throw new IllegalArgumentException("Poin per kg tidak boleh bernilai negatif.");
        }
        this.poinPerKg = poinPerKg;
    }

    public String getDeskripsi() { return deskripsi; }
    public void setDeskripsi(String deskripsi) { this.deskripsi = deskripsi; }
}
