/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package todolist;

import javax.swing.JList;
import javax.swing.JButton;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 *
 * @author collincampbell
 */
public class EditClickListener implements ActionListener {
    private JList list;
    private JButton button;
    private JTextField text;
    private JFrame frame;
    private DefaultListModel model;
    private int index;
    
    
    public EditClickListener(JList list, JTextField text, JButton button, JFrame frame, DefaultListModel model, int index) {
        this.list = list;
        this.button = button;
        this.text = text;
        this.frame = frame;
        this.model = model;
        this.index = index;
        
    }
    
    @Override
    public void actionPerformed(ActionEvent ae) {
        list.setModel(model);
        model.setElementAt(text.getText(), index); 
        frame.dispose();     // similar to AddClickListener butt need to replace selected index text with edited text
    }
}
