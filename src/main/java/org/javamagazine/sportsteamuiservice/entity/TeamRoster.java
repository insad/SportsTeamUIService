package org.javamagazine.sportsteamuiservice.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Container for <code>TeamRoster</code> entity objects.
 * 
 * @author juneau
 */
@XmlRootElement
public class TeamRoster implements Serializable {

    private static final long serialVersionUID = 1L;

    private BigDecimal id;

    private String firstName;

    private String lastName;

    private String position;

    private Date registrationDate;

    public TeamRoster() {
    }

    public TeamRoster(BigDecimal id) {
        this.id = id;
    }

    public BigDecimal getId() {
        return id;
    }

    public void setId(BigDecimal id) {
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

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public Date getRegistrationDate() {
        return registrationDate;
    }

    public void setRegistrationDate(Date registrationDate) {
        this.registrationDate = registrationDate;
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
        if (!(object instanceof TeamRoster)) {
            return false;
        }
        TeamRoster other = (TeamRoster) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.javamagazine.sportsteamqueryservice.entity.TeamRoster[ id=" + id + " ]";
    }
    
}
