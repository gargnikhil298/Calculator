
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
public class Calculator implements ActionListener {

	
	JFrame frame;
	JTextField text;
	Font myFont = new Font("Times New Roman",Font.BOLD,30);
	JButton[] numberButton = new JButton[10];
	JButton[] operationButton = new JButton[8];
	JButton addButton,subButton,mulButton,divButton,decButton,equButton,delButton,clrButton;
	JPanel panel;
	
	double num1 = 0, num2 = 0, result = 0;
	char operator;
	
	Calculator(){
		frame = new JFrame("Calculator");
		frame.setBounds(400,150,420,520);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLayout(null);
		
		
		text = new JTextField();
		text.setBounds(50,25,300,50);
		text.setFont(myFont);
		text.setEditable(false);
		text.setBackground(Color.white);
		
		
		addButton = new JButton("+");		//addition Button
		subButton = new JButton("-");		//Subtration Button
		mulButton = new JButton("*");		//Multiplication Button
		divButton = new JButton("/");		//Division Button
		decButton = new JButton(".");		//Decimal Button
		equButton = new JButton("=");		//Equal Button
		delButton = new JButton("Delete");	//Delete Button
		clrButton = new JButton("clear");	//Clear Button
		
		operationButton[0] = addButton;
		operationButton[1] = subButton;
		operationButton[2] = mulButton;
		operationButton[3] = divButton;
		operationButton[4] = decButton;
		operationButton[5] = equButton;
		operationButton[6] = delButton;
		operationButton[7] = clrButton;
		for(int i=0; i<8; i++) {
			operationButton[i].addActionListener(this);
			operationButton[i].setFont(myFont);
			operationButton[i].setFocusable(false);
		}
		
		for(int i=0; i<10; i++) {
			numberButton[i] = new JButton(String.valueOf(i));
			numberButton[i].addActionListener(this);
			numberButton[i].setFont(myFont);
			numberButton[i].setFocusable(false);
		}
		
		delButton.setBounds(50,420,145,50);
		clrButton.setBounds(205,420,145,50);
		
		panel = new JPanel();
		panel.setBounds(50,100,300,300);
		panel.setLayout(new GridLayout(4,4,10,10));
		
		panel.add(numberButton[1]);
		panel.add(numberButton[2]);
		panel.add(numberButton[3]);
		panel.add(addButton);
		panel.add(numberButton[4]);
		panel.add(numberButton[5]);
		panel.add(numberButton[6]);
		panel.add(subButton);
		panel.add(numberButton[7]);
		panel.add(numberButton[8]);
		panel.add(numberButton[9]);
		panel.add(mulButton);
		panel.add(decButton);
		panel.add(numberButton[0]);
		panel.add(equButton);
		panel.add(divButton);
		
		
		frame.add(panel);
		frame.add(delButton);
		frame.add(clrButton);
		frame.add(text);
		frame.setVisible(true);
	}
	public static void main(String[] args) {
		Calculator cal = new Calculator();
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		for(int i=0; i<10; i++) {
			if(e.getSource() == numberButton[i]) {
				text.setText(text.getText().concat(String.valueOf(i)));
			}
		}
		
		if(e.getSource() == decButton) {
			text.setText(text.getText().concat(String.valueOf(".")));
		}
		if(e.getSource() == addButton) {
			num1 = Double.parseDouble(text.getText());
			operator = '+';
			text.setText("");
		}
		if(e.getSource() == subButton) {
			num1 = Double.parseDouble(text.getText());
			operator = '-';
			text.setText("");
		}
		if(e.getSource() == mulButton) {
			num1 = Double.parseDouble(text.getText());
			operator = '*';
			text.setText("");
		}
		if(e.getSource() == divButton) {
			num1 = Double.parseDouble(text.getText());
			operator = '/';
			text.setText("");
		}
		if(e.getSource() == equButton) {
			num2 = Double.parseDouble(text.getText()); 
			switch(operator) {
			case'+':
				result = num1 + num2;
				break;
				
			case'-':
				result = num1 - num2;
				break;
				
			case'*':
				result = num1 * num2;
				break;
				
			case'/':
				result = num1 / num2;
				break;
			}
			text.setText(String.valueOf(result));
			num1 = result;
		}
		if(e.getSource() == clrButton) {
			text.setText("");
		}
		if(e.getSource() == delButton) {
			String string = text.getText();
			text.setText(" ");
			
			for(int i=0; i<string.length()-1; i++) {
				text.setText(text.getText() + string.charAt(i)); 
			}
		}
	}
}




