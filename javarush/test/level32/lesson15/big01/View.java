package com.javarush.test.level32.lesson15.big01;

import com.javarush.test.level32.lesson15.big01.listeners.FrameListener;
import com.javarush.test.level32.lesson15.big01.listeners.TabbedPaneChangeListener;
import com.javarush.test.level32.lesson15.big01.listeners.UndoListener;

import javax.swing.*;
import javax.swing.undo.UndoManager;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Zerodur on 17.10.2016.
 */
public class View extends JFrame implements ActionListener
{
    private Controller controller;
    private JTabbedPane tabbedPane = new JTabbedPane();
    private JTextPane htmlTextPane = new JTextPane();
    private JEditorPane plainTextPane = new JEditorPane();
    private UndoManager undoManager = new UndoManager();
    private UndoListener undoListener = new UndoListener(undoManager);

    public View(){
        try
        {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        }
        catch (ClassNotFoundException e)
        {
            ExceptionHandler.log(e);
        }
        catch (InstantiationException e)
        {
            ExceptionHandler.log(e);
        }
        catch (IllegalAccessException e)
        {
            ExceptionHandler.log(e);
        }
        catch (UnsupportedLookAndFeelException e)
        {
            ExceptionHandler.log(e);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        //Получи из события команду с помощью метода getActionCommand(). Это будет обычная строка.
        //По этой строке ты можешь понять какой пункт меню создал данное событие.
        String command = e.getActionCommand();

        switch (command) {

            case "Новый":
                controller.createNewDocument();
                break;
            case "Открыть":
                controller.openDocument();
                break;
            case "Сохранить":
                controller.saveDocument();
                break;
            case "Сохранить как...":
                controller.saveDocumentAs();
                break;
            case "Выход":
                controller.exit();
                break;
            case "О программе":
                showAbout();
                break;
        }
    }

    public void exit(){
        controller.exit();
    }

    public void init(){
        initGui();
        addWindowListener(new FrameListener(this));
        setVisible(true);
    }

    public Controller getController()
    {
        return controller;
    }

    public void setController(Controller controller)
    {
        this.controller = controller;
    }

    public UndoListener getUndoListener()
    {
        return undoListener;
    }

    public void initMenuBar(){
        JMenuBar bar = new JMenuBar();
        MenuHelper.initFileMenu(this, bar);
        MenuHelper.initEditMenu(this, bar);
        MenuHelper.initStyleMenu(this, bar);
        MenuHelper.initAlignMenu(this, bar);
        MenuHelper.initColorMenu(this, bar);
        MenuHelper.initFontMenu(this, bar);
        MenuHelper.initHelpMenu(this, bar);
        getContentPane().add(bar, BorderLayout.NORTH);

    }

    public void initEditor(){
        htmlTextPane.setContentType("text/html");
        tabbedPane.addTab("HTML", new JScrollPane(htmlTextPane));
        tabbedPane.addTab("Текст", new JScrollPane(plainTextPane));
        tabbedPane.setPreferredSize(new Dimension(500, 500));
        tabbedPane.addChangeListener(new TabbedPaneChangeListener(this));
        getContentPane().add(tabbedPane,BorderLayout.CENTER);
    }

    public void initGui(){
        initMenuBar();
        initEditor();
        pack();
    }

    public void selectedTabChanged() {
        //Метод должен проверить, какая вкладка сейчас оказалась выбранной
        //Если выбрана вкладка с индексом 0 (html вкладка)
        if (isHtmlTabSelected()) {
            //значит нам нужно получить текст из plainTextPane и установить его в контроллер с помощью метода setPlainText
            controller.setPlainText(plainTextPane.getText());
        }
        //сли выбрана вкладка с индексом 1 (вкладка с html текстом)
        else {
            //необходимо получить текст у контроллера с помощью метода getPlainText() и установить его в панель plainTextPane
            plainTextPane.setText(controller.getPlainText());
        }
        //Сбросить правки
        resetUndo();
    }

    public boolean isHtmlTabSelected(){
        if (tabbedPane.getSelectedIndex() == 0) return true;
        return false;
    }

    public void undo(){
        try
        {
            undoManager.undo();
        }catch (Exception e){
            ExceptionHandler.log(e);
        }
    }

    public void redo(){
        try{
            undoManager.redo();
        }catch (Exception e){

        }
    }

    public void selectHtmlTab(){
        tabbedPane.setSelectedIndex(0);
        resetUndo();
    }

    public void update(){
        htmlTextPane.setDocument(controller.getDocument());
    }

    public void showAbout(){
        JOptionPane.showMessageDialog(this, "HTML Editor", "About", JOptionPane.INFORMATION_MESSAGE);
    }

    public boolean canUndo()
    {
        return undoManager.canUndo();
    }

    public boolean canRedo()
    {
        return undoManager.canRedo();
    }

    public void resetUndo(){
        undoManager.discardAllEdits();
    }
}
