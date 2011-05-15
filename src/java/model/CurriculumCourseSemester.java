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
@Table(name = "curriculum_course_semester")
@NamedQueries({
    @NamedQuery(name = "CurriculumCourseSemester.findAll", query = "SELECT c FROM CurriculumCourseSemester c"),
    @NamedQuery(name = "CurriculumCourseSemester.findById", query = "SELECT c FROM CurriculumCourseSemester c WHERE c.id = :id"),
    @NamedQuery(name = "CurriculumCourseSemester.findBySemester", query = "SELECT c FROM CurriculumCourseSemester c WHERE c.semester = :semester"),
    @NamedQuery(name = "CurriculumCourseSemester.findByExam", query = "SELECT c FROM CurriculumCourseSemester c WHERE c.exam = :exam"),
    @NamedQuery(name = "CurriculumCourseSemester.findByCredit", query = "SELECT c FROM CurriculumCourseSemester c WHERE c.credit = :credit"),
    @NamedQuery(name = "CurriculumCourseSemester.findByCalculationGraphicalWork", query = "SELECT c FROM CurriculumCourseSemester c WHERE c.calculationGraphicalWork = :calculationGraphicalWork"),
    @NamedQuery(name = "CurriculumCourseSemester.findByCoursePaper", query = "SELECT c FROM CurriculumCourseSemester c WHERE c.coursePaper = :coursePaper"),
    @NamedQuery(name = "CurriculumCourseSemester.findByCourseProject", query = "SELECT c FROM CurriculumCourseSemester c WHERE c.courseProject = :courseProject"),
    @NamedQuery(name = "CurriculumCourseSemester.findByHoursPerWeek", query = "SELECT c FROM CurriculumCourseSemester c WHERE c.hoursPerWeek = :hoursPerWeek")})
public class CurriculumCourseSemester implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "id")
    private Long id;
    @Basic(optional = false)
    @Column(name = "semester")
    private short semester;
    @Column(name = "exam")
    private Boolean exam;
    @Column(name = "credit")
    private Boolean credit;
    @Column(name = "calculation_graphical_work")
    private Boolean calculationGraphicalWork;
    @Column(name = "course_paper")
    private Boolean coursePaper;
    @Column(name = "course_project")
    private Boolean courseProject;
    @Basic(optional = false)
    @Column(name = "hours_per_week")
    private BigDecimal hoursPerWeek;
    @JoinColumn(name = "curriculum_course_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Course course;

    public CurriculumCourseSemester() {
    }

    public CurriculumCourseSemester(Long id) {
        this.id = id;
    }

    public CurriculumCourseSemester(Long id, short semester, BigDecimal hoursPerWeek) {
        this.id = id;
        this.semester = semester;
        this.hoursPerWeek = hoursPerWeek;
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

    public Boolean getExam() {
        return exam;
    }

    public void setExam(Boolean exam) {
        this.exam = exam;
    }

    public Boolean getCredit() {
        return credit;
    }

    public void setCredit(Boolean credit) {
        this.credit = credit;
    }

    public Boolean getCalculationGraphicalWork() {
        return calculationGraphicalWork;
    }

    public void setCalculationGraphicalWork(Boolean calculationGraphicalWork) {
        this.calculationGraphicalWork = calculationGraphicalWork;
    }

    public Boolean getCoursePaper() {
        return coursePaper;
    }

    public void setCoursePaper(Boolean coursePaper) {
        this.coursePaper = coursePaper;
    }

    public Boolean getCourseProject() {
        return courseProject;
    }

    public void setCourseProject(Boolean courseProject) {
        this.courseProject = courseProject;
    }

    public BigDecimal getHoursPerWeek() {
        return hoursPerWeek;
    }

    public void setHoursPerWeek(BigDecimal hoursPerWeek) {
        this.hoursPerWeek = hoursPerWeek;
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
        if (!(object instanceof CurriculumCourseSemester)) {
            return false;
        }
        CurriculumCourseSemester other = (CurriculumCourseSemester) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.CurriculumCourseSemester[id=" + id + "]";
    }

}
