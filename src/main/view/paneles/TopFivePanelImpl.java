package main.view.paneles;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;


@SuppressWarnings("serial")
public class TopFivePanelImpl extends JPanel implements TopFivePanel {
	private static TopFivePanelImpl instance;
	
	private JLabel lblTitulo, label_1, label_2, label_3, label_4, label_5;
	private JTextArea textArea_1, textArea_2, textArea_3, textArea_4, textArea_5;
	
	private TopFivePanelImpl() {
		this.setBounds(180, 10, 450, 223);
		this.setLayout(null);
		
		this.initComponents();
	}
	
	public static TopFivePanel getInstance() {
		if( instance == null ) {
			instance = new TopFivePanelImpl();
		}
		
		return instance;
	}
	
	@Override
	public void loadTopFive(String[] words) {
		textArea_1.setText(words[0]);
		textArea_2.setText(words[1]);
		textArea_3.setText(words[2]);
		textArea_4.setText(words[3]);
		textArea_5.setText(words[4]);
	}
	
	private void initComponents() {
		//Etiqueta del titulo sobre las palabras
     	lblTitulo = new JLabel("Palabras mas utilizadas:");
     	lblTitulo.setBounds(5, 11, 311, 14);
     	this.add(lblTitulo);

     	// Etiquetas de posiciones
     	label_1 = new JLabel("1");
     	label_1.setBounds(10, 60, 12, 14);
     	this.add(label_1);

     	label_2 = new JLabel("2");
     	label_2.setBounds(10, 95, 12, 14);
     	this.add(label_2);

     	label_3 = new JLabel("3");
     	label_3.setBounds(10, 130, 12, 14);
     	this.add(label_3);

     	label_4 = new JLabel("4");
     	label_4.setBounds(10, 165, 12, 14);
     	this.add(label_4);

     	label_5 = new JLabel("5");
     	label_5.setBounds(10, 200, 21, 14);
     	this.add(label_5);

     	// Palabras con mas apariciones

     	textArea_1 = new JTextArea();
     	textArea_1.setEditable(false);
     	textArea_1.setBounds(30, 60, 264, 22);
     	this.add(textArea_1);

     	textArea_2 = new JTextArea();
     	textArea_2.setEditable(false);
     	textArea_2.setBounds(30, 95, 264, 22);
     	this.add(textArea_2);

     	textArea_3 = new JTextArea();
     	textArea_3.setEditable(false);
     	textArea_3.setBounds(30, 130, 264, 22);
     	this.add(textArea_3);

     	textArea_4 = new JTextArea();
     	textArea_4.setEditable(false);
     	textArea_4.setBounds(30, 165, 264, 22);
     	this.add(textArea_4);
     	
     	textArea_5 = new JTextArea();
     	textArea_5.setEditable(false);
     	textArea_5.setBounds(30, 200, 264, 22);
     	this.add(textArea_5);
	}

	@Override
	public void changeLabelLanguage(String str) {
		this.lblTitulo.setText(str);
	}

}
