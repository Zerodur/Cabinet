package ru.homework.cabinet.beans;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import ru.homework.cabinet.utils.SearchUtil;

import java.util.Date;

@Component
@Scope("request")
public class SearchBean {

    @Autowired
    private Customer customer;
    private Integer number;
    private String name;
    private String type;
    private Date dateModifyStart;
    private Date dateModifyEnd;
    private Date dateCreateStart;
    private Date dateCreateEnd;

    public SearchBean(){}

    public void execute(){
        customer.setCurrentList(SearchUtil.searchProcees(this, customer.getCurrentUser().getDocuments()));
        customer.getSelectedDocuments().clear();
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Date getDateModifyStart() {
        return dateModifyStart;
    }

    public void setDateModifyStart(Date dateModifyStart) {
        this.dateModifyStart = dateModifyStart;
    }

    public Date getDateModifyEnd() {
        return dateModifyEnd;
    }

    public void setDateModifyEnd(Date dateModifyEnd) {
        this.dateModifyEnd = dateModifyEnd;
    }

    public Date getDateCreateStart() {
        return dateCreateStart;
    }

    public void setDateCreateStart(Date dateCreateStart) {
        this.dateCreateStart = dateCreateStart;
    }

    public Date getDateCreateEnd() {
        return dateCreateEnd;
    }

    public void setDateCreateEnd(Date dateCreateEnd) {
        this.dateCreateEnd = dateCreateEnd;
    }
}
