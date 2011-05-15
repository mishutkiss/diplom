package controller;

import model.Curriculum;
import controller.util.JsfUtil;
import controller.util.PaginationHelper;
import facade.CurriculumFacade;
import java.util.ResourceBundle;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;
import javax.faces.model.SelectItem;

@ManagedBean(name = "curriculumController")
@SessionScoped
public class CurriculumController {

    private Curriculum current;
    private DataModel items = null;
    @EJB
    private facade.CurriculumFacade ejbFacade;
    private PaginationHelper pagination;
    private int selectedItemIndex;
    private Long buffId;
   private Curriculum editCurr;

    public void setEditCurr(Curriculum editCurr) {
        this.editCurr = editCurr;
    }

   
    public Curriculum getEditCurr() {
        return editCurr;
    }

    public CurriculumController() {
    }

    public Curriculum getSelected() {
        if (current == null) {
            current = new Curriculum();
            selectedItemIndex = -1;
        }
        return current;
    }

    private CurriculumFacade getFacade() {
        return ejbFacade;
    }

    public PaginationHelper getPagination() {
        if (pagination == null) {
            pagination = new PaginationHelper(100) {

                @Override
                public int getItemsCount() {
                    return getFacade().count();
                }

                @Override
                public DataModel createPageDataModel() {
                    return new ListDataModel(getFacade().findRange(new int[]{getPageFirstItem(), getPageFirstItem() + getPageSize()}));
                }
            };
        }
        return pagination;
    }

    public String prepareList() {
        recreateModel();
        return "List";
    }

    public void prepareView() {
//        current = (Curriculum) getItems().getRowData();
//        selectedItemIndex = pagination.getPageFirstItem() + getItems().getRowIndex();
//        return "View";
    }

    public String prepareCreate() {
        current = new Curriculum();
        selectedItemIndex = -1;
        return "Create";
    }

    
    public void createGraphic() {
    
    CurriculumGraphicController graphicCont = new CurriculumGraphicController();
     graphicCont.createGraphic(editCurr);
    
    }
    public void create() {
        try {
//            if(getFacade().findAll().contains(current)){
//            System.out.println("another one!!!");
//            }
            getFacade().create(current);
            buffId = current.getId();
            current = null;
            recreateModel();
            JsfUtil.addSuccessMessage(ResourceBundle.getBundle("/Bundle").getString("CurriculumCreated"));
            System.out.println(buffId);
        } catch (Exception e) {
            JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("/Bundle").getString("PersistenceErrorOccured"));

        }
    }
//    public String create() {
//        try {
//            getFacade().create(current);
//            recreateModel();
//            JsfUtil.addSuccessMessage(ResourceBundle.getBundle("/Bundle").getString("CurriculumCreated"));
//            return prepareCreate();
//        } catch (Exception e) {
//            JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("/Bundle").getString("PersistenceErrorOccured"));
//            return null;
//        }
//    }

    public void prepareEdit() {
        current = (Curriculum) getItems().getRowData();
        selectedItemIndex = pagination.getPageFirstItem() + getItems().getRowIndex();
//        System.out.println(editCurr.toString());
//        System.out.println(selectedItemIndex);
        //  return "Edit";
    }

//    public String prepareEdit() {
//        current = (Curriculum)getItems().getRowData();
//        selectedItemIndex = pagination.getPageFirstItem() + getItems().getRowIndex();
//        return "Edit";
//    }
    public void update() {
        try {
            getFacade().edit(editCurr);
            JsfUtil.addSuccessMessage(ResourceBundle.getBundle("/Bundle").getString("CurriculumUpdated"));
        } catch (Exception e) {
            JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("/Bundle").getString("PersistenceErrorOccured"));
        }
    }
//    public String update() {
//        try {
//            getFacade().edit(current);
//            JsfUtil.addSuccessMessage(ResourceBundle.getBundle("/Bundle").getString("CurriculumUpdated"));
//            return "View";
//        } catch (Exception e) {
//            JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("/Bundle").getString("PersistenceErrorOccured"));
//            return null;
//        }
//    }

    public void destroy() {

//        current = (Curriculum) getItems().getRowData();
//        selectedItemIndex = pagination.getPageFirstItem() + getItems().getRowIndex();
        performDestroy();
        recreateModel();

    }
//    public String destroy() {
//        current = (Curriculum) getItems().getRowData();
//        selectedItemIndex = pagination.getPageFirstItem() + getItems().getRowIndex();
//        performDestroy();
//        recreateModel();
//        return "List";
//    }

    public String destroyAndView() {
        performDestroy();
        recreateModel();
        updateCurrentItem();
        if (selectedItemIndex >= 0) {
            return "View";
        } else {
            // all items were removed - go back to list
            recreateModel();
            return "List";
        }
    }

    private void performDestroy() {
        try {
            editCurr.setDeleted(true);
            getFacade().remove(editCurr);
//            current.setDeleted(true);
//            getFacade().remove(current);
            editCurr = null;
            JsfUtil.addSuccessMessage(ResourceBundle.getBundle("/Bundle").getString("CurriculumDeleted"));
        } catch (Exception e) {
            JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("/Bundle").getString("PersistenceErrorOccured"));
        }
    }

    private void updateCurrentItem() {
        int count = getFacade().count();
        if (selectedItemIndex >= count) {
            // selected index cannot be bigger than number of items:
            selectedItemIndex = count - 1;
            // go to previous page if last page disappeared:
            if (pagination.getPageFirstItem() >= count) {
                pagination.previousPage();
            }
        }
        if (selectedItemIndex >= 0) {
            current = getFacade().findRange(new int[]{selectedItemIndex, selectedItemIndex + 1}).get(0);
        }
    }

    public DataModel getItems() {
        if (items == null) {
            items = getPagination().createPageDataModel();
        }
        return items;
    }

    private void recreateModel() {
        items = null;
    }

    public String next() {
        getPagination().nextPage();
        recreateModel();
        return "List";
    }

    public String previous() {
        getPagination().previousPage();
        recreateModel();
        return "List";
    }

    public SelectItem[] getItemsAvailableSelectMany() {
        return JsfUtil.getSelectItems(ejbFacade.findAll(), false);
    }

    public SelectItem[] getItemsAvailableSelectOne() {
        return JsfUtil.getSelectItems(ejbFacade.findAll(), true);
    }

   

    @FacesConverter(forClass = Curriculum.class)
    public static class CurriculumControllerConverter implements Converter {

        public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
            if (value == null || value.length() == 0) {
                return null;
            }
            CurriculumController controller = (CurriculumController) facesContext.getApplication().getELResolver().
                    getValue(facesContext.getELContext(), null, "curriculumController");
            return controller.ejbFacade.find(getKey(value));
        }

        java.lang.Long getKey(String value) {
            java.lang.Long key;
            key = Long.valueOf(value);
            return key;
        }

        String getStringKey(java.lang.Long value) {
            StringBuffer sb = new StringBuffer();
            sb.append(value);
            return sb.toString();
        }

        public String getAsString(FacesContext facesContext, UIComponent component, Object object) {
            if (object == null) {
                return null;
            }
            if (object instanceof Curriculum) {
                Curriculum o = (Curriculum) object;
                return getStringKey(o.getId());
            } else {
                throw new IllegalArgumentException("object " + object + " is of type " + object.getClass().getName() + "; expected type: " + CurriculumController.class.getName());
            }
        }
    }
}
