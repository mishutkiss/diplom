/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package facade;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import model.Course;

/**
 *
 * @author Miraxis
 */
@Stateless
public class CourseFacade extends AbstractFacade<Course> {
    @PersistenceContext(unitName = "diplomprojectPU")
    private EntityManager em;

    protected EntityManager getEntityManager() {
        return em;
    }

    public CourseFacade() {
        super(Course.class);
    }

}
