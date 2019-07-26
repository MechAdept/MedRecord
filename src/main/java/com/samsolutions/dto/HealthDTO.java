package com.samsolutions.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.util.Objects;

/**
 * DataTransferObject for Health entity.
 *
 * @author Vladislav Brazovskij <u.brazouski@sam-solutions.com>
 * @package com.samsolutions.dto
 * @link http ://sam-solutions.com/
 * @copyright 2019 SaM
 */

public class HealthDTO {
    @JsonProperty(value = "id")
    private Long id;

    @JsonProperty(value = "patient")
    private UserDTO patient;

    @JsonProperty(value = "photo")
    private String photo;

    @DateTimeFormat(pattern = "yyyy-dd-MM")
    @JsonProperty(value = "birth")
    private LocalDate birth;

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

    /**
     * Returns patient.
     *
     * @return UserDTO.
     */
    public UserDTO getPatient() {
        return patient;
    }

    /**
     * Sets patient.
     *
     * @param patient UserDTO to be set.
     */
    public void setPatient(final UserDTO patient) {
        this.patient = patient;
    }

    /**
     * Returns link to photo.
     *
     * @return String.
     */
    public String getPhoto() {
        return photo;
    }

    /**
     * Sets photo.
     *
     * @param photo String (link to photo) to be set.
     */
    public void setPhoto(final String photo) {
        this.photo = photo;
    }

    /**
     * Returns date of birth.
     *
     * @return LocalDate.
     */
    public LocalDate getBirth() {
        return birth;
    }

    /**
     * Sets date of birth.
     *
     * @param birth LocaleDate to be set.
     */
    public void setBirth(final LocalDate birth) {
        this.birth = birth;
    }

//    public void setBirth(String birth){
//        DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd'T'hh:mm");
//        try {
//            this.birth = (Date)formatter.parse(birth);
//        } catch (ParseException e) {
//            System.out.println("DATE FORMAT EXCEPTION");
//        } //todo: add logger
//    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        HealthDTO healthDTO = (HealthDTO) o;
        return Objects.equals(id, healthDTO.id) &&
                Objects.equals(patient, healthDTO.patient) &&
                Objects.equals(photo, healthDTO.photo) &&
                Objects.equals(birth, healthDTO.birth);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, patient, photo, birth);
    }
}