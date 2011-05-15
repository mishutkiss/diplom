/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package facade;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import model.Speciality;

/**
 *
 * @author butnick
 */
@Stateless
public class SpecialityFacade extends AbstractFacade<Speciality> {
    @PersistenceContext(unitName = "diplomprojectPU")
    private EntityManager em;

    protected EntityManager getEntityManager() {
        return em;
    }

    public SpecialityFacade() {
        super(Speciality.class);
    }

}
