package com.samsolutions.dto.data;

import java.util.Objects;

public class HealthDataDTO {

    private Long id;

    private UserDataDTO patient;

    private Long height;

    private Long weight;

    private Long chest;

    private Long waist;

    private Long hips;

    private String nervous;

    private String constitution;

    private String musculature;

    private Float leye;

    private Float reye;

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

    public UserDataDTO getPatient() {
        return patient;
    }

    public void setPatient(UserDataDTO patient) {
        this.patient = patient;
    }

    public Long getHeight() {
        return height;
    }

    public void setHeight(Long height) {
        this.height = height;
    }

    public Long getWeight() {
        return weight;
    }

    public void setWeight(Long weight) {
        this.weight = weight;
    }

    public Long getChest() {
        return chest;
    }

    public void setChest(Long chest) {
        this.chest = chest;
    }

    public Long getWaist() {
        return waist;
    }

    public void setWaist(Long waist) {
        this.waist = waist;
    }

    public Long getHips() {
        return hips;
    }

    public void setHips(Long hips) {
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

    public Float getLeye() {
        return leye;
    }

    public void setLeye(Float leye) {
        this.leye = leye;
    }

    public Float getReye() {
        return reye;
    }

    public void setReye(Float reye) {
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
        HealthDataDTO that = (HealthDataDTO) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(patient, that.patient) &&
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
        return Objects.hash(id, patient, height, weight, chest, waist, hips, nervous, constitution,
                musculature, leye, reye, blood, alcohol, smoke, drugs);
    }
}
