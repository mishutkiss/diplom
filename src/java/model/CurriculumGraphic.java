/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package model;

import model.CurriculumPhase;
import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
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
@Table(name = "curriculum_graphic", catalog = "br", schema = "public")
@NamedQueries({
    @NamedQuery(name = "CurriculumGraphic.findAll", query = "SELECT c FROM CurriculumGraphic c"),
    @NamedQuery(name = "CurriculumGraphic.findById", query = "SELECT c FROM CurriculumGraphic c WHERE c.id = :id"),
    @NamedQuery(name = "CurriculumGraphic.findBySemester", query = "SELECT c FROM CurriculumGraphic c WHERE c.semester = :semester"),
    @NamedQuery(name = "CurriculumGraphic.findByWeeks", query = "SELECT c FROM CurriculumGraphic c WHERE c.weeks = :weeks"),
    @NamedQuery(name = "CurriculumGraphic.findByOrdinalNumber", query = "SELECT c FROM CurriculumGraphic c WHERE c.ordinalNumber = :ordinalNumber")})
public class CurriculumGraphic implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "id", nullable = false)
    private Long id;
    @Basic(optional = false)
    @Column(name = "semester", nullable = false)
    private short semester;
    @Basic(optional = false)
    @Column(name = "weeks", nullable = false)
    private short weeks;
    @Basic(optional = false)
    @Column(name = "ordinal_number", nullable = false)
    private short ordinalNumber;
    @JoinColumn(name = "curriculum_phase_id", referencedColumnName = "id", nullable = false)
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private CurriculumPhase curriculumPhaseId;

    public CurriculumGraphic() {
    }

    public CurriculumGraphic(Long id) {
        this.id = id;
    }

    public CurriculumGraphic(Long id, short semester, short weeks, short ordinalNumber) {
        this.id = id;
        this.semester = semester;
        this.weeks = weeks;
        this.ordinalNumber = ordinalNumber;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public short getSemester() {
        return semester;
    }

    public void setSemester(short semester) {
        this.semester = semester;
    }

    public short getWeeks() {
        return weeks;
    }

    public void setWeeks(short weeks) {
        this.weeks = weeks;
    }

    public short getOrdinalNumber() {
        return ordinalNumber;
    }

    public void setOrdinalNumber(short ordinalNumber) {
        this.ordinalNumber = ordinalNumber;
    }

    public CurriculumPhase getCurriculumPhaseId() {
        return curriculumPhaseId;
    }

    public void setCurriculumPhaseId(CurriculumPhase curriculumPhaseId) {
        this.curriculumPhaseId = curriculumPhaseId;
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
        if (!(object instanceof CurriculumGraphic)) {
            return false;
        }
        CurriculumGraphic other = (CurriculumGraphic) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "controller.CurriculumGraphic[id=" + id + "]";
    }

}
