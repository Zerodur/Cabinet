package com.javarush.test.level32.lesson15.big01;

import javax.swing.text.html.HTMLDocument;
import javax.swing.text.html.HTMLEditorKit;
import java.io.File;
import java.io.StringReader;
import java.io.StringWriter;

/**
 * Created by Zerodur on 17.10.2016.
 */
public class Controller
{
    private View view;
    private File currentFile;
    private HTMLDocument document;

    public Controller(View view){
        this.view = view;
    }

    public void init(){

    }

    public void resetDocument(){
        if (document != null) {
            //Удалять у текущего документа document слушателя правок которые можно отменить/вернуть
            document.removeUndoableEditListener(view.getUndoListener());
        }
        //Создавать новый документ по умолчанию и присваивать его полю document
        document = (HTMLDocument) new HTMLEditorKit().createDefaultDocument();
        //Добавлять новому документу слушателя правок
        document.addUndoableEditListener(view.getUndoListener());
        //Вызывать у представления метод update()
        view.update();
    }

    public void setPlainText(String text) {
        //Сбрось документ
        resetDocument();
        //Создай новый реадер StringReader на базе переданного текста
        StringReader stringReader = new StringReader(text);

        try {
            //Вызови метод read() из класса HTMLEditorKit, который вычитает данные из реадера в документ document
            new HTMLEditorKit().read(stringReader, document, 0);

        } catch (Exception e) {
            //Проследи, чтобы метод не кидал исключения. Их необходимо просто логировать
            ExceptionHandler.log(e);
        }
    }

    public String getPlainText() {
        //Создай объект StringWriter
        StringWriter stringWriter = new StringWriter();
        try {
            //Перепиши все содержимое из документа document в созданный объект с помощью метода write класса HTMLEditorKit
            new HTMLEditorKit().write(stringWriter, document, 0, document.getLength());

        } catch (Exception e) {
            //Как обычно, метод не должен кидать исключений
            ExceptionHandler.log(e);
        }

        return stringWriter.toString();
    }

    public HTMLDocument getDocument()
    {
        return document;
    }

    public void exit(){
        System.exit(0);
    }

    public static void main(String[] args)
    {
        View view = new View();
        Controller controller = new Controller(view);
        view.setController(controller);
        view.init();
        controller.init();
    }

    public void createNewDocument()
    {

    }

    public void openDocument()
    {

    }

    public void saveDocument()
    {

    }

    public void saveDocumentAs()
    {

    }
}
