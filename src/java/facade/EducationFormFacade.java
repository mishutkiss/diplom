/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package facade;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import model.EducationForm;

/**
 *
 * @author butnick
 */
@Stateless
public class EducationFormFacade extends AbstractFacade<EducationForm> {
    @PersistenceContext(unitName = "diplomprojectPU")
    private EntityManager em;

    protected EntityManager getEntityManager() {
        return em;
    }

    public EducationFormFacade() {
        super(EducationForm.class);
    }

}
