package model;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean
@SessionScoped
public class TableBean {
private String week[];


public TableBean() {
    week=new String[9];
        for(int i = 0; i<8; i++){
            week[i]=null;
        }
   }
    public String[] getWeek() {
        return week;
    }
        
    public void setWeek(String []week) {
        this.week = week;
    }

}
