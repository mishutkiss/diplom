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
import javax.persistence.UniqueConstraint;

/**
 *
 * @author butnick
 */
@Entity
@Table(name = "curriculum_phase", catalog = "br", schema = "public", uniqueConstraints = {
    @UniqueConstraint(columnNames = {"name"})})
@NamedQueries({
    @NamedQuery(name = "CurriculumPhase.findAll", query = "SELECT c FROM CurriculumPhase c"),
    @NamedQuery(name = "CurriculumPhase.findById", query = "SELECT c FROM CurriculumPhase c WHERE c.id = :id"),
    @NamedQuery(name = "CurriculumPhase.findByName", query = "SELECT c FROM CurriculumPhase c WHERE c.name = :name"),
    @NamedQuery(name = "CurriculumPhase.findByAbbr", query = "SELECT c FROM CurriculumPhase c WHERE c.abbr = :abbr")})
public class CurriculumPhase implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "id", nullable = false)
    private Long id;
    @Basic(optional = false)
    @Column(name = "name", nullable = false, length = 50)
    private String name;
    @Column(name = "abbr", length = 5)
    private String abbr;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "curriculumPhaseId", fetch = FetchType.EAGER)
    private List<CurriculumGraphic> curriculumGraphicList;

    public CurriculumPhase() {
    }

    public CurriculumPhase(Long id) {
        this.id = id;
    }

    public CurriculumPhase(Long id, String name) {
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

    public String getAbbr() {
        return abbr;
    }

    public void setAbbr(String abbr) {
        this.abbr = abbr;
    }

    public List<CurriculumGraphic> getCurriculumGraphicList() {
        return curriculumGraphicList;
    }

    public void setCurriculumGraphicList(List<CurriculumGraphic> curriculumGraphicList) {
        this.curriculumGraphicList = curriculumGraphicList;
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
        if (!(object instanceof CurriculumPhase)) {
            return false;
        }
        CurriculumPhase other = (CurriculumPhase) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return abbr;
    }

}
