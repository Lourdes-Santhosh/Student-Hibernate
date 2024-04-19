package com.lourdes.hibernate.StudentCRUD.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "student")
public class Student {

    @Id
    @Column(name = "regNo")
    private int regNo;

    @Column(name = "name")
    private String name;

    @Column(name = "emailId")
    private String emailId;

    public Student() {
    }

    public Student(int regNo, String name, String emailId) {
        this.regNo = regNo;
        this.name = name;
        this.emailId = emailId;
    }

    // Getters and setters
    public int getRegNo() {
        return regNo;
    }

    public void setRegNo(int regNo) {
        this.regNo = regNo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    @Override
    public String toString() {
        return "Student{" +
                "regNo=" + regNo +
                ", name='" + name + '\'' +
                ", emailId='" + emailId + '\'' +
                '}';
    }
}
