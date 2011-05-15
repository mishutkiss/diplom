/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package model;

import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author Miraxis
 */
@Entity
@Table(name = "curriculum_course")
@NamedQueries({
    @NamedQuery(name = "CurriculumCourse.findAll", query = "SELECT c FROM CurriculumCourse c"),
    @NamedQuery(name = "CurriculumCourse.findById", query = "SELECT c FROM CurriculumCourse c WHERE c.id = :id"),
    @NamedQuery(name = "CurriculumCourse.findByEctsCredits", query = "SELECT c FROM CurriculumCourse c WHERE c.ectsCredits = :ectsCredits"),
    @NamedQuery(name = "CurriculumCourse.findByTotalHours", query = "SELECT c FROM CurriculumCourse c WHERE c.totalHours = :totalHours"),
    @NamedQuery(name = "CurriculumCourse.findByInclassHours", query = "SELECT c FROM CurriculumCourse c WHERE c.inclassHours = :inclassHours"),
    @NamedQuery(name = "CurriculumCourse.findByLectureHours", query = "SELECT c FROM CurriculumCourse c WHERE c.lectureHours = :lectureHours"),
    @NamedQuery(name = "CurriculumCourse.findByLaboratoryClassHours", query = "SELECT c FROM CurriculumCourse c WHERE c.laboratoryClassHours = :laboratoryClassHours"),
    @NamedQuery(name = "CurriculumCourse.findByPracticalClassHours", query = "SELECT c FROM CurriculumCourse c WHERE c.practicalClassHours = :practicalClassHours"),
    @NamedQuery(name = "CurriculumCourse.findBySelfStudyHours", query = "SELECT c FROM CurriculumCourse c WHERE c.selfStudyHours = :selfStudyHours")})
public class CurriculumCourse implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "id")
    private Long id;
    @Basic(optional = false)
    @Column(name = "ects_credits")
    private BigDecimal ectsCredits;
    @Basic(optional = false)
    @Column(name = "total_hours")
    private short totalHours;
    @Basic(optional = false)
    @Column(name = "inclass_hours")
    private short inclassHours;
    @Basic(optional = false)
    @Column(name = "lecture_hours")
    private short lectureHours;
    @Basic(optional = false)
    @Column(name = "laboratory_class_hours")
    private short laboratoryClassHours;
    @Basic(optional = false)
    @Column(name = "practical_class_hours")
    private short practicalClassHours;
    @Basic(optional = false)
    @Column(name = "self_study_hours")
    private short selfStudyHours;
    @JoinColumn(name = "course_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Course course;

    public CurriculumCourse() {
    }

    public CurriculumCourse(Long id) {
        this.id = id;
    }

    public CurriculumCourse(Long id, BigDecimal ectsCredits, short totalHours, short inclassHours, short lectureHours, short laboratoryClassHours, short practicalClassHours, short selfStudyHours) {
        this.id = id;
        this.ectsCredits = ectsCredits;
        this.totalHours = totalHours;
        this.inclassHours = inclassHours;
        this.lectureHours = lectureHours;
        this.laboratoryClassHours = laboratoryClassHours;
        this.practicalClassHours = practicalClassHours;
        this.selfStudyHours = selfStudyHours;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public BigDecimal getEctsCredits() {
        return ectsCredits;
    }

    public void setEctsCredits(BigDecimal ectsCredits) {
        this.ectsCredits = ectsCredits;
    }

    public short getTotalHours() {
        return totalHours;
    }

    public void setTotalHours(short totalHours) {
        this.totalHours = totalHours;
    }

    public short getInclassHours() {
        return inclassHours;
    }

    public void setInclassHours(short inclassHours) {
        this.inclassHours = inclassHours;
    }

    public short getLectureHours() {
        return lectureHours;
    }

    public void setLectureHours(short lectureHours) {
        this.lectureHours = lectureHours;
    }

    public short getLaboratoryClassHours() {
        return laboratoryClassHours;
    }

    public void setLaboratoryClassHours(short laboratoryClassHours) {
        this.laboratoryClassHours = laboratoryClassHours;
    }

    public short getPracticalClassHours() {
        return practicalClassHours;
    }

    public void setPracticalClassHours(short practicalClassHours) {
        this.practicalClassHours = practicalClassHours;
    }

    public short getSelfStudyHours() {
        return selfStudyHours;
    }

    public void setSelfStudyHours(short selfStudyHours) {
        this.selfStudyHours = selfStudyHours;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
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
        if (!(object instanceof CurriculumCourse)) {
            return false;
        }
        CurriculumCourse other = (CurriculumCourse) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.CurriculumCourse[id=" + id + "]";
    }

}
