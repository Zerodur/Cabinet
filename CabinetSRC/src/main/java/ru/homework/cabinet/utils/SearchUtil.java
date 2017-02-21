package ru.homework.cabinet.utils;

import ru.homework.cabinet.beans.SearchBean;
import ru.homework.cabinet.entities.Document;

import java.util.ArrayList;
import java.util.List;

public class SearchUtil {
    public static List<Document> searchProcees(SearchBean searchBean, List<Document> userList){
        List<Document> resultList = new ArrayList<Document>();
        for (Document document : userList){
            if (searchBean.getName().equals("") || searchBean.getName().equals(document.getName()))
                if (searchBean.getNumber() == null || searchBean.getNumber().equals(document.getNumber()))
                    if (searchBean.getType().equals("") || searchBean.getType().equals((document.getType())))
                        if (searchBean.getDateCreateStart() == null || searchBean.getDateCreateStart().getTime() <= document.getDateCreate().getTime())
                            if (searchBean.getDateCreateEnd() == null || searchBean.getDateCreateEnd().getTime() >= document.getDateCreate().getTime())
                                if (searchBean.getDateModifyStart() == null && searchBean.getDateModifyEnd() == null){
                                    resultList.add(document);
                                }else if (document.getDateModify() != null){
                                        if (searchBean.getDateModifyStart() != null){
                                            if(searchBean.getDateModifyStart().getTime() <= document.getDateModify().getTime())
                                                if (searchBean.getDateModifyEnd() != null) {
                                                    if (searchBean.getDateModifyEnd().getTime() >= document.getDateModify().getTime()) resultList.add(document);
                                                }else resultList.add(document);
                                        }else if (searchBean.getDateModifyEnd() != null)
                                                if (searchBean.getDateModifyEnd().getTime() >= document.getDateModify().getTime()) resultList.add(document);
                                }
            }
        return resultList;
    }
}