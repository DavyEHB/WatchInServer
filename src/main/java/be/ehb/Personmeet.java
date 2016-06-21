/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package be.ehb;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author davy.van.belle
 */
@Entity
@Table(name = "personmeet")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Personmeet.findAll", query = "SELECT p FROM Personmeet p"),
    @NamedQuery(name = "Personmeet.findByID", query = "SELECT p FROM Personmeet p WHERE p.ID = :ID"),
    @NamedQuery(name = "Personmeet.findByP_ID", query = "SELECT p FROM Personmeet p WHERE p.pID = :P_ID")
    })
public class Personmeet implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer ID;
    
    @Column(name = "P_ID")
    private Integer pID;
    
    @Column(name = "M_ID")
    private Integer mID;

    public Personmeet() {
    }

    public Personmeet(Integer ID) {
        this.ID = ID;
    }

    public Integer getID() {
        return ID;
    }

    public void setID(Integer ID) {
        this.ID = ID;
    }
    
    public Integer getpID() {
        return pID;
    }

    public void setpID(Integer pID) {
        this.pID = pID;
    }

    public Integer getmID() {
        return mID;
    }

    public void setmID(Integer mID) {
        this.mID = mID;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (ID != null ? ID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the ID fields are not set
        if (!(object instanceof Personmeet)) {
            return false;
        }
        Personmeet other = (Personmeet) object;
        if ((this.ID == null && other.ID != null) || (this.ID != null && !this.ID.equals(other.ID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "be.ehb.Personmeet[ ID=" + ID + " ]";
    }


    
}
