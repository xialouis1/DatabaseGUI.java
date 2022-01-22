import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public abstract class UI extends JFrame {
	
	public UI () {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(400, 300);
		setLocationRelativeTo(null);
		
		JMenuBar menubar = new JMenuBar();
		setJMenuBar(menubar);
		
		JMenu menu1 = new JMenu("File");
		JMenuItem menuitem11 = new JMenuItem("Reconnect");
		menuitem11.addActionListener(new ActConnectionUI());
		menu1.add(menuitem11);
		menubar.add(menu1);
		
		addComponent();
		setVisible(true);
	}

	protected abstract void addComponent();
}
