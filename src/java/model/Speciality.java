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
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author butnick
 */
@Entity
@Table(name = "speciality", catalog = "br", schema = "public")
@NamedQueries({
    @NamedQuery(name = "Speciality.findAll", query = "SELECT s FROM Speciality s"),
    @NamedQuery(name = "Speciality.findById", query = "SELECT s FROM Speciality s WHERE s.id = :id"),
    @NamedQuery(name = "Speciality.findByRefCode", query = "SELECT s FROM Speciality s WHERE s.refCode = :refCode"),
    @NamedQuery(name = "Speciality.findByName", query = "SELECT s FROM Speciality s WHERE s.name = :name"),
    @NamedQuery(name = "Speciality.findByFacultyId", query = "SELECT s FROM Speciality s WHERE s.facultyId = :facultyId"),
    @NamedQuery(name = "Speciality.findByDepartmentId", query = "SELECT s FROM Speciality s WHERE s.departmentId = :departmentId"),
    @NamedQuery(name = "Speciality.findByQualification", query = "SELECT s FROM Speciality s WHERE s.qualification = :qualification"),
    @NamedQuery(name = "Speciality.findByActive1", query = "SELECT s FROM Speciality s WHERE s.active1 = :active1"),
    @NamedQuery(name = "Speciality.findByQualificationLevelId", query = "SELECT s FROM Speciality s WHERE s.qualificationLevelId = :qualificationLevelId"),
    @NamedQuery(name = "Speciality.findByQualificationCode", query = "SELECT s FROM Speciality s WHERE s.qualificationCode = :qualificationCode")})
public class Speciality implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "id", nullable = false)
    private Long id;
    @Basic(optional = false)
    @Column(name = "ref_code", nullable = false, length = 15)
    private String refCode;
    @Basic(optional = false)
    @Column(name = "name", nullable = false, length = 100)
    private String name;
    @Basic(optional = false)
    @Column(name = "faculty_id", nullable = false)
    private int facultyId;
    @Basic(optional = false)
    @Column(name = "department_id", nullable = false)
    private int departmentId;
    @Basic(optional = false)
    @Column(name = "qualification", nullable = false, length = 100)
    private String qualification;
    @Basic(optional = false)
    @Column(name = "active1", nullable = false)
    private boolean active1;
    @Basic(optional = false)
    @Column(name = "qualification_level_id", nullable = false)
    private int qualificationLevelId;
    @Column(name = "qualification_code", length = 15)
    private String qualificationCode;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "specialityId", fetch = FetchType.EAGER)
    private List<Curriculum> curriculumList;

    public Speciality() {
    }

    public Speciality(Long id) {
        this.id = id;
    }

    public Speciality(Long id, String refCode, String name, int facultyId, int departmentId, String qualification, boolean active1, int qualificationLevelId) {
        this.id = id;
        this.refCode = refCode;
        this.name = name;
        this.facultyId = facultyId;
        this.departmentId = departmentId;
        this.qualification = qualification;
        this.active1 = active1;
        this.qualificationLevelId = qualificationLevelId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRefCode() {
        return refCode;
    }

    public void setRefCode(String refCode) {
        this.refCode = refCode;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getFacultyId() {
        return facultyId;
    }

    public void setFacultyId(int facultyId) {
        this.facultyId = facultyId;
    }

    public int getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(int departmentId) {
        this.departmentId = departmentId;
    }

    public String getQualification() {
        return qualification;
    }

    public void setQualification(String qualification) {
        this.qualification = qualification;
    }

    public boolean getActive1() {
        return active1;
    }

    public void setActive1(boolean active1) {
        this.active1 = active1;
    }

    public int getQualificationLevelId() {
        return qualificationLevelId;
    }

    public void setQualificationLevelId(int qualificationLevelId) {
        this.qualificationLevelId = qualificationLevelId;
    }

    public String getQualificationCode() {
        return qualificationCode;
    }

    public void setQualificationCode(String qualificationCode) {
        this.qualificationCode = qualificationCode;
    }

    public List<Curriculum> getCurriculumList() {
        return curriculumList;
    }

    public void setCurriculumList(List<Curriculum> curriculumList) {
        this.curriculumList = curriculumList;
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
        if (!(object instanceof Speciality)) {
            return false;
        }
        Speciality other = (Speciality) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return name;
    }

}
