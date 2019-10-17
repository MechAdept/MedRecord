package com.samsolutions.dto.form;

import com.samsolutions.entity.Health;

import java.util.Objects;

public class HealthFormDTO {

    private Long id;

    private Long patientId;

    private String height;

    private String weight;

    private String chest;

    private String waist;

    private String hips;

    private String nervous;

    private String constitution;

    private String musculature;

    private String leye;

    private String reye;

    private String blood;

    private Boolean alcohol;

    private Boolean smoke;

    private Boolean drugs;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getPatientId() {
        return patientId;
    }

    public void setPatientId(Long patientId) {
        this.patientId = patientId;
    }

    public String getHeight() {
        return height;
    }

    public void setHeight(String height) {
        this.height = height;
    }

    public String getWeight() {
        return weight;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }

    public String getChest() {
        return chest;
    }

    public void setChest(String chest) {
        this.chest = chest;
    }

    public String getWaist() {
        return waist;
    }

    public void setWaist(String waist) {
        this.waist = waist;
    }

    public String getHips() {
        return hips;
    }

    public void setHips(String hips) {
        this.hips = hips;
    }

    public String getNervous() {
        return nervous;
    }

    public void setNervous(String nervous) {
        this.nervous = nervous;
    }

    public String getConstitution() {
        return constitution;
    }

    public void setConstitution(String constitution) {
        this.constitution = constitution;
    }

    public String getMusculature() {
        return musculature;
    }

    public void setMusculature(String musculature) {
        this.musculature = musculature;
    }

    public String getLeye() {
        return leye;
    }

    public void setLeye(String leye) {
        this.leye = leye;
    }

    public String getReye() {
        return reye;
    }

    public void setReye(String reye) {
        this.reye = reye;
    }

    public String getBlood() {
        return blood;
    }

    public void setBlood(String blood) {
        this.blood = blood;
    }

    public Boolean getAlcohol() {
        return alcohol;
    }

    public void setAlcohol(Boolean alcohol) {
        this.alcohol = alcohol;
    }

    public Boolean getSmoke() {
        return smoke;
    }

    public void setSmoke(Boolean smoke) {
        this.smoke = smoke;
    }

    public Boolean getDrugs() {
        return drugs;
    }

    public void setDrugs(Boolean drugs) {
        this.drugs = drugs;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        HealthFormDTO that = (HealthFormDTO) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(patientId, that.patientId) &&
                Objects.equals(height, that.height) &&
                Objects.equals(weight, that.weight) &&
                Objects.equals(chest, that.chest) &&
                Objects.equals(waist, that.waist) &&
                Objects.equals(hips, that.hips) &&
                Objects.equals(nervous, that.nervous) &&
                Objects.equals(constitution, that.constitution) &&
                Objects.equals(musculature, that.musculature) &&
                Objects.equals(leye, that.leye) &&
                Objects.equals(reye, that.reye) &&
                Objects.equals(blood, that.blood) &&
                Objects.equals(alcohol, that.alcohol) &&
                Objects.equals(smoke, that.smoke) &&
                Objects.equals(drugs, that.drugs);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, patientId, height, weight, chest, waist, hips, nervous, constitution, musculature, leye, reye, blood, alcohol, smoke, drugs);
    }
}
