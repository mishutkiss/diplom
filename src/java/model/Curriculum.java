/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package model;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author butnick
 */
@Entity
@Table(name = "curriculum", catalog = "br", schema = "public")
@NamedQueries({
    @NamedQuery(name = "Curriculum.findAll", query = "SELECT c FROM Curriculum c"),
    @NamedQuery(name = "Curriculum.findById", query = "SELECT c FROM Curriculum c WHERE c.id = :id"),
    @NamedQuery(name = "Curriculum.findByStartYear", query = "SELECT c FROM Curriculum c WHERE c.startYear = :startYear"),
    @NamedQuery(name = "Curriculum.findByTuitionDurationYears", query = "SELECT c FROM Curriculum c WHERE c.tuitionDurationYears = :tuitionDurationYears"),
    @NamedQuery(name = "Curriculum.findByTuitionDurationMonths", query = "SELECT c FROM Curriculum c WHERE c.tuitionDurationMonths = :tuitionDurationMonths"),
    @NamedQuery(name = "Curriculum.findByDeleted", query = "SELECT c FROM Curriculum c WHERE c.deleted = :deleted")})
public class Curriculum implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Basic(optional = false)
    @Column(name = "id", nullable = false)
    private Long id;
    @Basic(optional = false)
    @Column(name = "start_year", nullable = false)
    private short startYear;
    @Basic(optional = false)
    @Column(name = "tuition_duration_years", nullable = false)
    private short tuitionDurationYears;
    @Basic(optional = false)
    @Column(name = "tuition_duration_months", nullable = false)
    private short tuitionDurationMonths;
    @Basic(optional = false)
    @Column(name = "deleted", nullable = false)
    private boolean deleted;
    @JoinColumn(name = "speciality_id", referencedColumnName = "id", nullable = false)
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Speciality specialityId;
    @JoinColumn(name = "education_form_id", referencedColumnName = "id", nullable = false)
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private EducationForm educationFormId;

    public Curriculum() {
    }

    public Curriculum(Long id) {
        this.id = id;
    }

    public Curriculum(Long id, short startYear, short tuitionDurationYears, short tuitionDurationMonths, boolean deleted) {
        this.id = id;
        this.startYear = startYear;
        this.tuitionDurationYears = tuitionDurationYears;
        this.tuitionDurationMonths = tuitionDurationMonths;
        this.deleted = deleted;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public short getStartYear() {
        return startYear;
    }

    public void setStartYear(short startYear) {
        this.startYear = startYear;
    }

    public short getTuitionDurationYears() {
        return tuitionDurationYears;
    }

    public void setTuitionDurationYears(short tuitionDurationYears) {
        this.tuitionDurationYears = tuitionDurationYears;
    }

    public short getTuitionDurationMonths() {
        return tuitionDurationMonths;
    }

    public void setTuitionDurationMonths(short tuitionDurationMonths) {
        this.tuitionDurationMonths = tuitionDurationMonths;
    }

    public boolean getDeleted() {
        return deleted;
    }

    public void setDeleted(boolean deleted) {
        this.deleted = deleted;
    }

    public Speciality getSpecialityId() {
        return specialityId;
    }

    public void setSpecialityId(Speciality specialityId) {
        this.specialityId = specialityId;
    }

    public EducationForm getEducationFormId() {
        return educationFormId;
    }

    public void setEducationFormId(EducationForm educationFormId) {
        this.educationFormId = educationFormId;
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
        if (!(object instanceof Curriculum)) {
            return false;
        }
        Curriculum other = (Curriculum) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Curriculum[id=" + id + "]";
    }

}
