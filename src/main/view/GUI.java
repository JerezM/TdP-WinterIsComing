package main.view;

import java.util.Locale;
import java.util.ResourceBundle;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import main.service.language_changer.LanguageChanger;
import main.view.buttons.EnglishBtn;
import main.view.buttons.LoadDirectoryBtn;
import main.view.buttons.SpanishBtn;
import main.view.buttons.StartBtn;
import main.view.paneles.TopFivePanel;
//import main.view.paneles.FileListPanelImpl;
import main.view.paneles.TopFivePanelImpl;

@SuppressWarnings("serial")
public class GUI extends JFrame implements LanguageChanger {
    private JPanel contentPane;
    
    private JButton loadDirectoryBtn, startBtn, enBtn, esBtn;
    private JLabel lblCambiarLenguaje;
    private TopFivePanel topFivePanel;
    
    /**
     * Create the frame.
     */
    public GUI() {

        this.initComponents();

	}
	
	private void initComponents() {
		setTitle("got");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(200, 100, 800, 350);
        setResizable(false);

		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
        contentPane.setLayout(null);
        
        this.loadDirectoryBtn = new LoadDirectoryBtn(this);
        this.loadDirectoryBtn.setBounds(10, 72, 150, 23);
        this.contentPane.add(loadDirectoryBtn);
        
        this.startBtn = new StartBtn();
        this.startBtn.setBounds(10, 126, 150, 23);
        this.contentPane.add(startBtn);
        
        this.esBtn = new SpanishBtn(this);
        this.esBtn.setBounds(37, 225, 90, 23);
        this.contentPane.add(esBtn);
        
        this.enBtn = new EnglishBtn(this);
        this.enBtn.setBounds(37, 196, 90, 23);
        this.contentPane.add(enBtn);
        
        this.topFivePanel = TopFivePanelImpl.getInstance();
        this.contentPane.add((JPanel) topFivePanel);

     	this.lblCambiarLenguaje = new JLabel("Cambiar idioma:");
     	this.lblCambiarLenguaje.setBounds(37, 173, 150, 14);
     	this.getContentPane().add(lblCambiarLenguaje);
     	
     	/*this.fileListPanel = FileListPanelImpl.getInstance();
     	this.fileListPanel.setBounds(480, 10, 200, 222);
     	this.getContentPane().add(fileListPanel);*/
	}

	@Override
	public void changeToSpanish() {
		Locale locale = new Locale("es", "AR");
		this.changeLanguage(locale);
	}

	@Override
	public void changeToEnglish() {
		Locale locale = new Locale("en", "US");
		this.changeLanguage(locale);
	}
	
	/**
	 * Se encarga de cambiar el idioma de todos los btn.
	 * @param locale Idioma seleccionado.
	 */
	private void changeLanguage(Locale locale) {
		ResourceBundle propertiesBundle = ResourceBundle.getBundle("resources.properties.GOTBundle", locale);
		
		//Buttons
		this.loadDirectoryBtn.setText( propertiesBundle.getString("load.directory.btn") );
		this.startBtn.setText( propertiesBundle.getString("start.btn") );
		this.enBtn.setText( propertiesBundle.getString("english.btn") );
		this.esBtn.setText( propertiesBundle.getString("spanish.btn") );
		
		//Labels
		this.lblCambiarLenguaje.setText( propertiesBundle.getString("change.language") );
		this.topFivePanel.changeLabelLanguage( propertiesBundle.getString("more.used.words") );
		
		System.out.println("idioma cambiado al:" + locale.getLanguage());
		
	}
	
}
