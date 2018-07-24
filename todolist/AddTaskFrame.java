/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package todolist;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Container;
import javax.swing.*;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import static javax.swing.WindowConstants.DISPOSE_ON_CLOSE;


/**
 *
 * @author collincampbell
 */
public class AddTaskFrame implements Runnable {
    private JList list;
    private JFrame frame;
    private DefaultListModel model;
    
    public AddTaskFrame(JList list, DefaultListModel model) {
        this.list = list;
        this.model = model;
        
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
        JTextField text = new JTextField(20);
        JButton addButton = new JButton("Add Task");
        AddClickListener action = new AddClickListener(list, text, addButton, frame, model);
        addButton.addActionListener(action);
        container.add(text);
        container.add(addButton);
        
        
    }
    
    
    
}
