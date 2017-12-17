package window;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;

import r.R;

public abstract class AbstractWindow extends JFrame {
	private static final long serialVersionUID = 1L;

	private R r;
	private List<String> keys;

	public AbstractWindow() {
		r = R.getInstance();
		keys = new ArrayList<String>();
	}

	public final void run() {
		initWindow(); // �Դ��ڵĳ�ʼ������
		init(); // ��ʼ������
		regitstComponent(); // ע�����
		addListener(); // ��Ӽ�����
	}

	protected abstract void addListener();

	protected abstract void regitstComponent();

	protected abstract void init();

	protected void initWindow() {
		setSize(1000, 600);
		setLocationRelativeTo(null); // ���þ�����ʾ
		setVisible(true);// Ĭ�Ͽɼ�
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);// �رյ�Ĭ�ϲ������رմ���
	}

	protected void _registerObject(String key, Object value) {
		try {
			r.register(key, value);
			keys.add(key);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void _removeObjects() {
		try {
			for (String key : keys)
				r.unregister(key);
		} catch (Exception e) {
			e.printStackTrace();
		}
		keys.clear();
	}

	@Override
	public void dispose() {
		_removeObjects();

		super.dispose();
	}
}
