package com.lourdes.hibernate.StudentCRUD.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "marks")
public class Marks {

	 @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    @Column(name = "id")
	    private int id;
    @OneToOne
    @JoinColumn(name = "regNo")
    private Student student;

    @Column(name = "subject1")
    private int subject1;

    @Column(name = "subject2")
    private int subject2;

    @Column(name = "subject3")
    private int subject3;

    public Marks() {
    }

    public Marks(Student student, int subject1, int subject2, int subject3) {
        this.student = student;
        this.subject1 = subject1;
        this.subject2 = subject2;
        this.subject3 = subject3;
    }


    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public int getSubject1() {
        return subject1;
    }

    public void setSubject1(int subject1) {
        this.subject1 = subject1;
    }

    public int getSubject2() {
        return subject2;
    }

    public void setSubject2(int subject2) {
        this.subject2 = subject2;
    }

    public int getSubject3() {
        return subject3;
    }

    public void setSubject3(int subject3) {
        this.subject3 = subject3;
    }

    @Override
    public String toString() {
        return "Marks{" +
                ", student=" + student +
                ", subject1=" + subject1 +
                ", subject2=" + subject2 +
                ", subject3=" + subject3 +
                '}';
    }
}
 