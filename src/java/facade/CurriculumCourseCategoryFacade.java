/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package facade;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import model.CurriculumCourseCategory;

/**
 *
 * @author Miraxis
 */
@Stateless
public class CurriculumCourseCategoryFacade extends AbstractFacade<CurriculumCourseCategory> {
    @PersistenceContext(unitName = "diplomprojectPU")
    private EntityManager em;

    protected EntityManager getEntityManager() {
        return em;
    }

    public CurriculumCourseCategoryFacade() {
        super(CurriculumCourseCategory.class);
    }

}
