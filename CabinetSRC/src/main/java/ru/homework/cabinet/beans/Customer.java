package ru.homework.cabinet.beans;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.homework.cabinet.entities.Document;
import ru.homework.cabinet.entities.User;
import ru.homework.cabinet.service.UserService;

import java.util.ArrayList;
import java.util.List;


@Component
public class Customer {

    @Autowired
    private UserService userService;
    private User currentUser;
    private List<Document> selectedDocuments = new ArrayList<Document>();
    private List<Document> currentList;

    public Customer(){}

    public String getPassword() {
        return currentUser.getPass();
    }

    public void setPassword(String pwd) {
        currentUser.setPass(pwd);
        userService.editUser(currentUser);
    }

    public User getCurrentUser() {
        return currentUser;
    }

    public void setCurrentUser(User currentUser) {
        this.currentUser = currentUser;
    }

    public List<Document> getCurrentList(){
        return currentList != null ? currentList : currentUser.getDocuments();
    }

    public String getName() {
        return currentUser.getName();
    }

    public void setName(String name) {
        currentUser.setName(name);
        userService.editUser(currentUser);
    }

    public List<Document> getSelectedDocuments() {
        return selectedDocuments;
    }

    public void setSelectedDocuments(List<Document> selectedDocuments) {
        this.selectedDocuments = selectedDocuments;
    }

    public void addDocument(Document document){
        if (currentList != null){
            currentList.add(document);
        }
        currentUser.getDocuments().add(document);
        userService.editUser(currentUser);
        selectedDocuments.clear();
    }

    public void deleteDocuments(){
        if (currentList != null){
            currentList.removeAll(selectedDocuments);
            currentUser.getDocuments().removeAll(selectedDocuments);
            userService.editUser(currentUser);
            selectedDocuments.clear();
        }else {
            currentUser.getDocuments().removeAll(selectedDocuments);
            userService.editUser(currentUser);
            selectedDocuments.clear();
        }
    }

    public boolean isManySelected(){
        return selectedDocuments.size() > 0 ? true : false;
    }

    public boolean isSingleSelected(){
        return selectedDocuments.size() == 1 ? true : false;
    }

    public Document getSelectedDocument(){
        if (selectedDocuments.isEmpty()) return null;
        return selectedDocuments.get(0);
    }

    public void editDocument(Document document) {
        Document selectedDoc = selectedDocuments.get(0);
        int idx = currentUser.getDocuments().indexOf(selectedDoc);
        Document docFromUser = currentUser.getDocuments().get(idx);
        docFromUser.setNumber(document.getNumber());
        docFromUser.setName(document.getName());
        docFromUser.setType(document.getType());
        docFromUser.setDateModify(document.getDateModify());
        userService.editUser(currentUser);
        selectedDocuments.clear();
    }

    public void setCurrentList(List<Document> currentList) {
        this.currentList = currentList;
    }
}
