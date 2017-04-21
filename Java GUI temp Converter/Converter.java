import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class Converter extends JFrame{

    JPanel panel = new JPanel();
    JButton button = new JButton("Convert");

    public static void main (String [] args){
        new Converter();
    }

    public Converter(){
        super("Temperature Converter");
        setSize(300, 300);
        setResizable(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        
        button.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent event){
                System.out.println("hello");
            }
        });
        //panel
        panel.add(button);
        
        add(panel);

        setVisible(true);
    }
}