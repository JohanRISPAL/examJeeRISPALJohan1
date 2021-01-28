/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.humanbooster.repertoire.models;

import java.util.Date;
import java.util.Objects;

/**
 *
 * @author HB
 */
public class Users {
    
    private Integer id;
    private String image_link;
    private String name;
    private String firstName;
    private String date_hire;
    private String cellphone_number;
    private boolean isAdmin;

    public Users(String image_link, String name, String firstName, String date_hire, String cellphone_number, boolean isAdmin) {
        this.image_link = image_link;
        this.name = name;
        this.firstName = firstName;
        this.date_hire = date_hire;
        this.cellphone_number = cellphone_number;
        this.isAdmin = isAdmin;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getImage_link() {
        return image_link;
    }

    public void setImage_link(String image_link) {
        this.image_link = image_link;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getDate_hire() {
        return date_hire;
    }

    public void setDate_hire(String date_hire) {
        this.date_hire = date_hire;
    }

    public String getCellphone_number() {
        return cellphone_number;
    }

    public void setCellphone_number(String cellphone_number) {
        this.cellphone_number = cellphone_number;
    }

    public boolean isIsAdmin() {
        return isAdmin;
    }

    public void setIsAdmin(boolean isAdmin) {
        this.isAdmin = isAdmin;
    }

    @Override
    public String toString() {
        return "Users{" + "id=" + id + ", image_link=" + image_link + ", name=" + name + ", firstName=" + firstName + ", date_hire=" + date_hire + ", cellphone_number=" + cellphone_number + ", isAdmin=" + isAdmin + '}';
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 59 * hash + Objects.hashCode(this.id);
        hash = 59 * hash + Objects.hashCode(this.image_link);
        hash = 59 * hash + Objects.hashCode(this.name);
        hash = 59 * hash + Objects.hashCode(this.firstName);
        hash = 59 * hash + Objects.hashCode(this.date_hire);
        hash = 59 * hash + Objects.hashCode(this.cellphone_number);
        hash = 59 * hash + (this.isAdmin ? 1 : 0);
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
        final Users other = (Users) obj;
        if (this.isAdmin != other.isAdmin) {
            return false;
        }
        if (!Objects.equals(this.image_link, other.image_link)) {
            return false;
        }
        if (!Objects.equals(this.name, other.name)) {
            return false;
        }
        if (!Objects.equals(this.firstName, other.firstName)) {
            return false;
        }
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        if (!Objects.equals(this.date_hire, other.date_hire)) {
            return false;
        }
        if (!Objects.equals(this.cellphone_number, other.cellphone_number)) {
            return false;
        }
        return true;
    }
    
    
}
