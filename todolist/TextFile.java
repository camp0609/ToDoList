/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package todolist;


import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;
import javax.swing.DefaultListModel;
import javax.swing.JList;

/**
 *
 * @author collincampbell
 */
public class TextFile {
    private JList list;
    private File fileList;
    private int listSize;
    private DefaultListModel model;
    private boolean exists;
    
    
    public TextFile(JList list, DefaultListModel model) throws IOException {
        this.list = list;       // list and model to save and load data from. 
        this.model = model;
        listSize = list.getModel().getSize();
        //exists = fileList.exists();     // boolean if file exists, use this in load method as well.
        fileList = new File("toDoList.txt");
        if (!fileList.exists()) {          // check if file exists and if not create it. 
            fileList.createNewFile();
        } 
    }
    public void save() {
        try {
          PrintWriter pw = new PrintWriter(fileList);
           for (int i = 0; i < listSize; i++) {
               pw.println(list.getModel().getElementAt(i).toString());  // save each item from list to its own line
           }
           pw.close();
        } catch(Exception e) {
            System.out.println(e);
        }
    }
    
    public void load() {
        if(fileList.exists()) {  // if file exists load each string from file to model.
            try {
            Scanner reader = new Scanner(fileList);
            while(reader.hasNextLine()) {
                String item = reader.nextLine();
                model.addElement(item);
            }
            reader.close();
            list.setModel(model);
            }catch(Exception e) {
                System.out.println(e);
            }
        }
        
    }
}
