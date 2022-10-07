/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ex7;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Tinip
 */
@Entity
@Table(name = "STUDENT")
@XmlRootElement
@NamedQueries({
@NamedQuery(name = "Student.findAll", query = "SELECT s FROM Student s"),
@NamedQuery(name = "Student.findById", query = "SELECT s FROM Student s WHERE s.id = :id"),
@NamedQuery(name = "Student.findByName", query = "SELECT s FROM Student s WHERE s.name = :name"),
@NamedQuery(name = "Student.findByGpa", query = "SELECT s FROM Student s WHERE s.gpa = :gpa")})
public class Student implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "ID")
    private int id;
    @Column(name = "NAME")
    private String name;
    @Column(name = "GPA")
    private double gpa;

    public Student() {
    }
    
    public Student(Integer id) {
        this.id = id;
    }
    
    public Student(int id, String name, double gpa) {
        this.id = id;
        this.name = name;
        this.gpa = gpa;
    }
    
    
    public double getGpa() {
        return gpa;
    }

    public void setGpa(double gpa) {
        this.gpa = gpa;
    }
 
    public String getName() {
        return name;
    }
  
    public void setName(String name) {
        this.name = name;
    }
   
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Student)) {
            return false;
        }
        Student other = (Student) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "studentdatabasejpa.Student[ id=" + id + " ]";
    }

}
