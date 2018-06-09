/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package todolist;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import static javax.swing.WindowConstants.DISPOSE_ON_CLOSE;

/**
 *
 * @author collincampbell
 */
public class EditTaskFrame implements Runnable { // similar to addtaskframe but changes to buttons and how the actionevent works.
    private JList list;
    private JFrame frame;
    private DefaultListModel model;
    private JTextField text;
    private int index;
    
    
    public EditTaskFrame(JList list, DefaultListModel model, int index) {
        this.list = list;
        this.model = model;
        this.text = new JTextField(20);
        this.index = index;
        
    }
    
    @Override
    public void run() {
        frame = new JFrame();
        frame.setPreferredSize(new Dimension(300, 200));
        frame.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        
        createCompenents(frame.getContentPane());
        frame.pack();
        frame.setVisible(true);
    }
    
    public void createCompenents(Container container) {
        container.setLayout(new FlowLayout());
        String editedTask = list.getSelectedValue().toString();
        text.setText(editedTask);
        JButton addButton = new JButton("Edit Task");
        EditClickListener action = new EditClickListener(list, text, addButton, frame, model, index);
        addButton.addActionListener(action);
        container.add(text);
        container.add(addButton);
        
        
    }
    
    
    
}