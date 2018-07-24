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
public class AddClickListener implements ActionListener {
    private JList list;
    private JButton button;
    private JTextField text;
    private JFrame frame;
    private DefaultListModel model;
    
    public AddClickListener(JList list, JTextField text, JButton button, JFrame frame, DefaultListModel model) {
        this.list = list;
        this.button = button;
        this.text = text;
        this.frame = frame;
        this.model = model;
    }
    
    @Override
    public void actionPerformed(ActionEvent ae) {
        list.setModel(model);
        model.addElement(text.getText());
        frame.dispose(); 
    }
}
