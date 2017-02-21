package ru.homework.cabinet.beans;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.homework.cabinet.entities.Document;

import java.util.Date;

/**
 * Created by Zerodur on 10.02.2017.
 */
@Component
public class DocumentBean {

    @Autowired
    private Customer customer;
    private Integer number;
    private String name;
    private String type;
    private Date modifyDate;

    public DocumentBean(){ }

    public DocumentBean(Integer number, String name, String type){
        this.number = number;
        this.name = name;
        this.type = type;
        this.modifyDate = new Date();
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

    public Date getCreateDate() {
        return modifyDate;
    }

    public void setCreateDate(Date createDate) {
        this.modifyDate = createDate;
    }

    public void createDocument(){
        Document newDoc = new Document(number, name, type);
        customer.getSelectedDocuments().clear();
        customer.addDocument(newDoc);
    }

    public void editDocument(){
        Document newDoc = new Document();
        newDoc.setNumber(this.number);
        newDoc.setName(this.name);
        newDoc.setType(this.type);
        newDoc.setDateModify(new Date());
        customer.editDocument(newDoc);
    }

}
