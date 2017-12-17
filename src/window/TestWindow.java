package window;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;

import listener.ButtonActionListener;

public class TestWindow extends AbstractWindow {
	private static final long serialVersionUID = 1L;
	
	private JTextField field;
	private JButton button;

	@Override
	protected void addListener() {
		button.addActionListener(new ButtonActionListener());
	}

	@Override
	protected void regitstComponent() {
		_registerObject("field",field);
	}

	@Override
	protected void init() {
		field = new JTextField("文本框");
		button = new JButton("确定");
		
		add(field);
		add(button);
		
		field.setBounds(10, 10, 200, 100);
		button.setBounds(50, 250, 80, 40);
	}
	
	@Override
	protected void initWindow(){
		super.initWindow();
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(null);
	}

}
