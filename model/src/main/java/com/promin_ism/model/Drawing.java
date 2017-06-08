package com.promin_ism.model;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "drawing")
public class Drawing {
    @Id
    @SequenceGenerator(name = "sequence", sequenceName = "SEQ_Drawing_ID", allocationSize = 1, initialValue = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequence")
    private Long id;

    @Column(name = "image")
    @Lob
    private byte[] image;

    @Column(name = "lastDate")
    private LocalDateTime lastDate;

    @Column(name = "info")
    private String info;

    @Column(name = "isDeleted")
    private boolean isDeleted;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }

    public LocalDateTime getLastDate() {
        return lastDate;
    }

    public void setLastDate(LocalDateTime lastDate) {
        this.lastDate = lastDate;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public boolean isDeleted() {
        return isDeleted;
    }

    public void setDeleted(boolean deleted) {
        isDeleted = deleted;
    }
}
