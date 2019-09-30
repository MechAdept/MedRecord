package com.samsolutions.entity;

import javax.persistence.*;

/**
 * Health Entity.
 *
 * @author Vladislav Brazovskij <u.brazouski@sam-solutions.com>
 * @package com.samsolutions.entity
 * @link http ://sam-solutions.com/
 * @copyright 2019 SaM
 */

@Entity
@Table(name = "health")
public class Health {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @OneToOne(cascade = CascadeType.MERGE, fetch = FetchType.EAGER)
    @JoinColumn(name="patient_id")
    private User patient;

    @Column(name = "height")
    private Long height;

    @Column(name = "weight")
    private Long weight;

    @Column(name = "skin")
    private String skin;

    @Column(name = "race")
    private String race;

    @Column(name = "chest")
    private Long chest;

    @Column(name = "waist")
    private Long waist;

    @Column(name = "hips")
    private Long hips;

    @Column(name = "nervous")
    private String nervous;

    @Column(name = "constitution")
    private String constitution;

    @Column(name = "musculature")
    private String musculature;

    @Column(name = "leye")
    private Float leye;

    @Column(name = "reye")
    private Float reye;

    @Column(name = "blood")
    private String blood;

    @Column(name = "alcohol")
    private Boolean alcohol;

    @Column(name = "smoke")
    private Boolean smoke;

    @Column(name = "drugs")
    private Boolean drugs;

    /**
     * Returns id.
     *
     * @return Long.
     */

    public Long getId() {
        return id;
    }

    /**
     * Sets id.
     *
     * @param id Long to be set.
     */
    public void setId(final Long id) {
        this.id = id;
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

    public String getSkin() {
        return skin;
    }

    public void setSkin(String skin) {
        this.skin = skin;
    }

    public String getRace() {
        return race;
    }

    public void setRace(String race) {
        this.race = race;
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

    public User getPatient() {
        return patient;
    }

    public void setPatient(User patient) {
        this.patient = patient;
    }


}
