package main.view;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import main.view.buttons.LoadDirectoryBtn;

@SuppressWarnings("serial")
public class GUI extends JFrame {
    private static GUI instance;
    private JPanel contentPane;
    
    private JButton loadDirectoryBtn;

    /**
     * Create the frame.
     */
    private GUI() {

        this.initComponents();

	}
	
	public static GUI getInstance() {
		if( instance == null ) {
			instance = new GUI();
		}
		
		return instance;
    }
	
	private void initComponents() {
		setTitle("got");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(300, 25, 755, 637);
        setResizable(false);

		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
        contentPane.setLayout(null);
        
        this.loadDirectoryBtn = new LoadDirectoryBtn();
        this.loadDirectoryBtn.setBounds(545, 50, 160, 23);
        this.contentPane.add(loadDirectoryBtn);
	}
}
