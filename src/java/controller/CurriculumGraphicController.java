package controller;

import model.CurriculumGraphic;
import controller.util.JsfUtil;
import controller.util.PaginationHelper;
import facade.CurriculumGraphicFacade;
import java.util.ArrayList;
import java.util.List;

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
import model.Curriculum;
import model.TableBean;

@ManagedBean (name="curriculumGraphicController")
@SessionScoped
public class CurriculumGraphicController {

    private CurriculumGraphic current;
    private TableBean tb;
    private List<TableBean> tableList;

    public List<TableBean> getTableList() {
        return tableList;
    }

    public void setTableList(List<TableBean> tableList) {
        this.tableList = tableList;
    }
    
    public void setTb(TableBean tb) {
        this.tb = tb;
    }

    public TableBean getTb() {
        return tb;
    }
    private DataModel items = null;
    @EJB private facade.CurriculumGraphicFacade ejbFacade;
    private PaginationHelper pagination;
    private int selectedItemIndex;

    public CurriculumGraphicController() {
    }

    public CurriculumGraphic getSelected() {
        if (current == null) {
            current = new CurriculumGraphic();
            selectedItemIndex = -1;
        }
        return current;
    }

    private CurriculumGraphicFacade getFacade() {
        return ejbFacade;
    }

    public PaginationHelper getPagination() {
        if (pagination == null) {
            pagination = new PaginationHelper(10) {

                @Override
                public int getItemsCount() {
                    return getFacade().count();
                }

                @Override
                public DataModel createPageDataModel() {
                    return new ListDataModel(getFacade().findRange(new int[]{getPageFirstItem(), getPageFirstItem()+getPageSize()}));
                }
            };
        }
        return pagination;
    }

    public String prepareList() {
        recreateModel();
        return "List";
        
    }
    public String prepareView() {
        current = (CurriculumGraphic)getItems().getRowData();
        selectedItemIndex = pagination.getPageFirstItem() + getItems().getRowIndex();
        return "View";
    }

    public String prepareCreate() {
        current = new CurriculumGraphic();
        selectedItemIndex = -1;
        return "Create";
    }

 public void createGraphic(Curriculum curr ) {

        
        try {
            tableList = new ArrayList<TableBean>();
            System.out.println("list");
            for(int i = 0;i< curr.getTuitionDurationYears(); i++){
                tableList.add(new TableBean());
                 System.out.println("new");
            }

            JsfUtil.addSuccessMessage(ResourceBundle.getBundle("/Bundle").getString("CurriculumUpdated"));
        } catch (Exception e) {
            JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("/Bundle").getString("PersistenceErrorOccured"));
        }

    }
    public String saveGraphic() {
        int size = tableList.size();

        System.out.println("size " + size);

        for (int i = 0; i < size; i++) {

            String[] buff = new String[8];
            buff = tableList.get(i).getWeek();
            for (int j = 0; j < 8; j++) {

                System.out.println(buff[j]);
            }
            System.out.println("--------------");
        }

      JsfUtil.addSuccessMessage(ResourceBundle.getBundle("/Bundle").getString("CurriculumUpdated"));
      return "Update";
    }

    public String create() {
        try {
            getFacade().create(current);
            JsfUtil.addSuccessMessage(ResourceBundle.getBundle("/Bundle").getString("CurriculumGraphicCreated"));
            return prepareCreate();
        } catch (Exception e) {
            JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("/Bundle").getString("PersistenceErrorOccured"));
            return null;
        }
    }

    public String prepareEdit() {
        current = (CurriculumGraphic)getItems().getRowData();
        selectedItemIndex = pagination.getPageFirstItem() + getItems().getRowIndex();
        return "Edit";
    }

    public String update() {
        try {
            getFacade().edit(current);
            JsfUtil.addSuccessMessage(ResourceBundle.getBundle("/Bundle").getString("CurriculumGraphicUpdated"));
            return "View";
        } catch (Exception e) {
            JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("/Bundle").getString("PersistenceErrorOccured"));
            return null;
        }
    }

    public String destroy() {
        current = (CurriculumGraphic)getItems().getRowData();
        selectedItemIndex = pagination.getPageFirstItem() + getItems().getRowIndex();
        performDestroy();
        recreateModel();
        return "List";
    }

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
            getFacade().remove(current);
            JsfUtil.addSuccessMessage(ResourceBundle.getBundle("/Bundle").getString("CurriculumGraphicDeleted"));
        } catch (Exception e) {
            JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("/Bundle").getString("PersistenceErrorOccured"));
        }
    }

    private void updateCurrentItem() {
        int count = getFacade().count();
        if (selectedItemIndex >= count) {
            // selected index cannot be bigger than number of items:
            selectedItemIndex = count-1;
            // go to previous page if last page disappeared:
            if (pagination.getPageFirstItem() >= count) {
                pagination.previousPage();
            }
        }
        if (selectedItemIndex >= 0) {
            current = getFacade().findRange(new int[]{selectedItemIndex, selectedItemIndex+1}).get(0);
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

    @FacesConverter(forClass=CurriculumGraphic.class)
    public static class CurriculumGraphicControllerConverter implements Converter {

        public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
            if (value == null || value.length() == 0) {
                return null;
            }
            CurriculumGraphicController controller = (CurriculumGraphicController)facesContext.getApplication().getELResolver().
                    getValue(facesContext.getELContext(), null, "curriculumGraphicController");
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
            if (object instanceof CurriculumGraphic) {
                CurriculumGraphic o = (CurriculumGraphic) object;
                return getStringKey(o.getId());
            } else {
                throw new IllegalArgumentException("object " + object + " is of type " + object.getClass().getName() + "; expected type: "+CurriculumGraphicController.class.getName());
            }
        }

    }

}
