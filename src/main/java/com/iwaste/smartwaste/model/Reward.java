package com.iwaste.smartwaste.model;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "rewards")
public class Reward {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nama_reward", nullable = false, length = 100)
    private String namaReward;

    @Column(name = "poin_dibutuhkan", nullable = false)
    private int poinDibutuhkan;

    @Column(nullable = false)
    private int stok = 0;

    @OneToMany(mappedBy = "reward", cascade = CascadeType.ALL)
    private List<UserReward> userRewards;

    // Encapsulation - Getters and Setters

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getNamaReward() { return namaReward; }
    public void setNamaReward(String namaReward) { this.namaReward = namaReward; }

    public int getPoinDibutuhkan() { return poinDibutuhkan; }
    public void setPoinDibutuhkan(int poinDibutuhkan) { this.poinDibutuhkan = poinDibutuhkan; }

    public int getStok() { return stok; }
    public void setStok(int stok) { this.stok = stok; }

    public List<UserReward> getUserRewards() { return userRewards; }
    public void setUserRewards(List<UserReward> userRewards) { this.userRewards = userRewards; }
    
    // Helper method
    public void kurangiStok() {
        if (stok > 0) {
            stok--;
        } else {
            throw new IllegalArgumentException("Stok reward habis");
        }
    }
}
