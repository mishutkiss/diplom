/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package facade;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import model.CurriculumGraphic;

/**
 *
 * @author butnick
 */
@Stateless
public class CurriculumGraphicFacade extends AbstractFacade<CurriculumGraphic> {
    @PersistenceContext(unitName = "diplomprojectPU")
    private EntityManager em;

    protected EntityManager getEntityManager() {
        return em;
    }

    public CurriculumGraphicFacade() {
        super(CurriculumGraphic.class);
    }

}
