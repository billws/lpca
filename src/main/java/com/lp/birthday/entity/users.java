package com.lp.birthday.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.sql.Date;

@Entity
public class users {
    @Id
    private Long id;
    private String firstName;
    private String lastName;
    private String gender;
    private Date dateOfBirth;
    private String email;

    public Long getId() {
        return id;
    }

    public void setID(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;

    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;

    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;

    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;

    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("id");
        sb.append('=');
        sb.append(((this.id == null) ? "<null>" : this.id));
        sb.append(',');
        sb.append("firstName");
        sb.append('=');
        sb.append(((this.firstName == null) ? "<null>" : this.firstName));
        sb.append(',');
        sb.append("lastName");
        sb.append('=');
        sb.append(((this.lastName == null) ? "<null>" : this.lastName));
        sb.append(',');
        sb.append("gneder");
        sb.append('=');
        sb.append(((this.gender == null) ? "<null>" : this.gender));
        sb.append(',');
        sb.append("email");
        sb.append('=');
        sb.append(((this.email == null) ? "<null>" : this.email));
        sb.append(',');
        sb.append("date");
        sb.append('=');
        sb.append(((this.dateOfBirth == null) ? "<null>" : this.dateOfBirth.getYear() + "" + (this.dateOfBirth.getMonth() + 1) + "" + this.dateOfBirth.getDate()));
        sb.append(',');
        if (sb.charAt((sb.length() - 1)) == ',') {
            sb.setCharAt((sb.length() - 1), ']');
        } else {
            sb.append(']');
        }
        return sb.toString();
    }

}
