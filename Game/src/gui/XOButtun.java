package gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;

public class XOButtun extends JButton implements ActionListener {
	ImageIcon X ,O;
	byte value =0;
	
	
	public XOButtun() {
		X = new ImageIcon(this.getClass().getResource("x.png"));
		O = new ImageIcon(this.getClass().getResource("o.png"));
		this.addActionListener(this);
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		value++;
		value%=3;
		switch (value) {
		case 0:
			setIcon(null);
			break;
		case 1:
			setIcon(X);
			break;
		case 2:
			setIcon(O);
			break;
			
		
		}
		
		
		
	}
	
	
	
}


/*
JPanel p = new JPanel();
XOButtun buttons [] = new XOButtun [9];

public gui_board() {
	super("TicTacToe");
	setSize(500,500);
	setResizable(false);
	p.setLayout(new GridLayout(3,3));
	for (int i = 0; i < 9; i++) {
		buttons[i] = new XOButtun();
		p.add(buttons[i]);
	}
	add(p);
	setVisible(true);
}

public static void main(String[] args) {
	gui_board g = new gui_board();
	
}
*/
