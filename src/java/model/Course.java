/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package model;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author Miraxis
 */
@Entity
@Table(name = "course")
@NamedQueries({
    @NamedQuery(name = "Course.findAll", query = "SELECT c FROM Course c"),
    @NamedQuery(name = "Course.findById", query = "SELECT c FROM Course c WHERE c.id = :id"),
    @NamedQuery(name = "Course.findByName", query = "SELECT c FROM Course c WHERE c.name = :name"),
    @NamedQuery(name = "Course.findByCode", query = "SELECT c FROM Course c WHERE c.code = :code"),
    @NamedQuery(name = "Course.findByAbbr", query = "SELECT c FROM Course c WHERE c.abbr = :abbr")})
public class Course implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "id")
    private Long id;
    @Basic(optional = false)
    @Column(name = "name")
    private String name;
    @Column(name = "code")
    private String code;
    @Column(name = "abbr")
    private String abbr;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "course")
    private List<CurriculumCourse> curriculumCourseList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "course")
    private List<CurriculumCourseSemester> curriculumCourseSemesterList;

    public Course() {
    }

    public Course(Long id) {
        this.id = id;
    }

    public Course(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getAbbr() {
        return abbr;
    }

    public void setAbbr(String abbr) {
        this.abbr = abbr;
    }

    public List<CurriculumCourse> getCurriculumCourseList() {
        return curriculumCourseList;
    }

    public void setCurriculumCourseList(List<CurriculumCourse> curriculumCourseList) {
        this.curriculumCourseList = curriculumCourseList;
    }

    public List<CurriculumCourseSemester> getCurriculumCourseSemesterList() {
        return curriculumCourseSemesterList;
    }

    public void setCurriculumCourseSemesterList(List<CurriculumCourseSemester> curriculumCourseSemesterList) {
        this.curriculumCourseSemesterList = curriculumCourseSemesterList;
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
        if (!(object instanceof Course)) {
            return false;
        }
        Course other = (Course) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Course[id=" + id + "]";
    }

}
