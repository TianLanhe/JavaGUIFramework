package listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextField;

import r.R;

public class ButtonActionListener implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent arg0) {
		JTextField field = (JTextField)R.getInstance().getObject("field");
		
		System.out.println(field.getText());
	}

}
