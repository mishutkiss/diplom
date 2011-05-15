/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package facade;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import model.CurriculumCourseSemester;

/**
 *
 * @author Miraxis
 */
@Stateless
public class CurriculumCourseSemesterFacade extends AbstractFacade<CurriculumCourseSemester> {
    @PersistenceContext(unitName = "diplomprojectPU")
    private EntityManager em;

    protected EntityManager getEntityManager() {
        return em;
    }

    public CurriculumCourseSemesterFacade() {
        super(CurriculumCourseSemester.class);
    }

}
