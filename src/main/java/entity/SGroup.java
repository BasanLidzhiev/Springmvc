/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;
import java.util.Objects;

/**
 *
 * @author basan
 */
@Entity(name = "SGroup")
public class SGroup implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column
    private String name;

//    private List<entity.Student> students;

    public SGroup(){}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

//    public List<entity.Student> getStudents() {
//        return students;
//    }
//
//    public void setStudents(List<entity.Student> students) {
//        this.students = students;
//    }

    @Override
    public String toString() {
        return "SGroup{" + "id=" + id + ", name=" + name + /*", students=" + students + */'}';
    }

    @Override
    public int hashCode() {

        int hash = 7;
        hash = 31 * hash + this.id;
        hash = 31 * hash + Objects.hashCode(this.name);
//        hash = 31 * hash + Objects.hashCode(this.students);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final SGroup other = (SGroup) obj;
        if (this.id != other.id) {
            return false;
        }
        if (!Objects.equals(this.name, other.name)) {
            return false;
        }
//        if (!Objects.equals(this.students, other.students)) {
//            return false;
//        }
        return true;
    }



}
