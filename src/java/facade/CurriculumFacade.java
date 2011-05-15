package facade;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import model.Curriculum;


@Stateless
public class CurriculumFacade extends CurrAbstractFacade<Curriculum> {
    @PersistenceContext(unitName = "diplomprojectPU")
    private EntityManager em;

    protected EntityManager getEntityManager() {
        return em;
    }

    public CurriculumFacade() {
        super(Curriculum.class);
    }

}
