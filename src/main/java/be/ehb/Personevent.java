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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author davy.van.belle
 */
@Entity
@Table(name = "personevent")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Personevent.findAll", query = "SELECT p FROM Personevent p"),
    @NamedQuery(name = "Personevent.findByID", query = "SELECT p FROM Personevent p WHERE p.ID = :ID"),
    @NamedQuery(name = "Personevent.findByP_ID", query = "SELECT p FROM Personevent p WHERE p.pID = :P_ID"),
    @NamedQuery(name = "Personevent.findByE_ID" , query = "SELECT p FROM Personevent p WHERE p.eID = :E_ID")
    })
public class Personevent implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer ID;

    @Column(name = "P_ID")
    private Integer pID;

    @Column(name = "E_ID")
    private Integer eID;

    public Personevent() {
    }

    public Personevent(Integer ID) {
        this.ID = ID;
    }

    public Integer getID() {
        return ID;
    }

    public void setID(Integer ID) {
        this.ID = ID;
    }

    public Integer getPID() {
        return pID;
    }

    public void setPID(Integer pID) {
        this.pID = pID;
    }

    public Integer getEID() {
        return eID;
    }

    public void setEID(Integer eID) {
        this.eID = eID;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (ID != null ? ID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Personevent)) {
            return false;
        }
        Personevent other = (Personevent) object;
        if ((this.ID == null && other.ID != null) || (this.ID != null && !this.ID.equals(other.ID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "be.ehb.Personevent[ ID=" + ID + " ]";
    }
    
}
