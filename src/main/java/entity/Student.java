/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

/**
 *
 * @author basan
 */

@Entity(name = "Student")
public class Student implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column
    private String name;

    @Column
    private String Last_Name;

    @Column
    private String birthday;
    @ManyToOne(fetch = FetchType.EAGER, cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH})
    private SGroup sgroup;


    public Student(){}

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

    public String getLast_Name() {
        return Last_Name;
    }

    public void setLast_Name(String last_Name) {
        this.Last_Name = last_Name;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public SGroup getSGroup() {
        return sgroup;
    }

    public void setSGroup(SGroup sGroup) {
        this.sgroup = sGroup;
    }

    @Override
    public String toString() {
        return "Student{" + "id=" + id + ", name=" + name + ", last name=" + Last_Name + ", berthday=" + birthday+
                ", sGroup=" + sgroup + '}';
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 29 * hash + this.id;
        hash = 29 * hash + Objects.hashCode(this.name);
        hash = 29 * hash + Objects.hashCode(this.Last_Name);
        hash = 29 * hash + Objects.hashCode(this.birthday);
        hash = 29 * hash + Objects.hashCode(this.sgroup);
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
        final Student other = (Student) obj;
        if (this.id != other.id) {
            return false;
        }
        if (this.birthday != other.birthday) {
            return false;
        }

        if (!Objects.equals(this.name, other.name)) {
            return false;
        }
        if (!Objects.equals(this.Last_Name, other.Last_Name)) {
            return false;
        }
        if (!Objects.equals(this.sgroup, other.sgroup)) {
            return false;
        }
        return true;
    }



}
