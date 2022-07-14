import javax.swing.*;

import java.awt.Font;
import java.awt.event.*;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.sql.SQLException;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;

public class Swing implements ActionListener{	
	JFrame frame;
	static JTextArea bigTextField;
	JTextArea stringField, patternField;
    JLabel patternLabel,stringLabel;
    JButton checkButton;  
    Swing() throws FileNotFoundException, UnsupportedEncodingException, SQLException
    {
        frame=new JFrame("FirstApplication");
        stringLabel = new JLabel("Search in string:");
		patternLabel = new JLabel("Searched pattern:   ");
		stringField = new JTextArea();
		patternField = new JTextArea();
		checkButton = new JButton("Check");       
        bigTextField = new JTextArea();       
        this.setBounds();
        this.setLayout();
        this.addActionListener();
        this.addToFrame();
   
    }   
	public void setBounds() {
		patternLabel.setBounds(30,50,100,30);
    	stringLabel.setBounds(30,50,100,600);
    	
    	patternField.setBounds(100,55,400,300);
    	stringField.setBounds(100,400,400,400);	
    	
    	bigTextField.setBounds(600,0,500,1000);	
        checkButton.setBounds(100,850,100,40);
        
        Font font = new Font("Arial", Font.BOLD, 20);
        stringField.setLineWrap(true);       
        stringField.setFont(font);
        patternField.setLineWrap(true);
        patternField.setFont(font);
        bigTextField.setFont(font);
        bigTextField.setLineWrap(true);
    }   
    public void addToFrame() {
    	 frame.add(stringLabel);
    	 frame.add(patternLabel);
    	 frame.add(stringField);
    	 frame.add(patternField);
    	 frame.add(bigTextField);
    	 frame.add(checkButton);
    }
    public void setLayout() {
    	frame.setLayout(null);
        frame.setVisible(true);
        frame.setSize(1000,1000);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
    }
    public void addActionListener() {
    	checkButton.addActionListener(this);

    }
    public void actionPerformed(ActionEvent e)
    {	   
        if(e.getSource()==checkButton)
	        {
        	  bigTextField.setText("");
        	  RegEx regEx = new RegEx();
        	  String pattern = patternField.getText();
        	  String line = stringField.getText();
              bigTextField.setText(regEx.getResult(pattern, line));    
              
	        }

    }

	 public static void main(String args[]) throws SQLException, ParserConfigurationException, TransformerException, IOException  {
	     new Swing();
	 }	 
}
