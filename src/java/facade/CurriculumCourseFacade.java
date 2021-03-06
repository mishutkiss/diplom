/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package facade;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import model.CurriculumCourse;

/**
 *
 * @author Miraxis
 */
@Stateless
public class CurriculumCourseFacade extends AbstractFacade<CurriculumCourse> {
    @PersistenceContext(unitName = "diplomprojectPU")
    private EntityManager em;

    protected EntityManager getEntityManager() {
        return em;
    }

    public CurriculumCourseFacade() {
        super(CurriculumCourse.class);
    }

}
