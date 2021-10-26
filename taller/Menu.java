package taller;

import java.awt.Color;
import java.awt.Font;
import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.Border;

public class Menu extends javax.swing.JFrame {
	private static final long serialVersionUID = 1L;
	JPanel miPanel;
	JLabel etiqueta;

	public Menu() {
		crearPanel();
	}

	public void crearPanel() {
		// creamos la ventana
		miPanel = new JPanel();
		// miPanel.setLayout(new java.awt.GridLayout(0, 1, 1, 1));
		miPanel.setLayout(null);
		Border blackline = BorderFactory.createLineBorder(Color.black);
		miPanel.setBorder(blackline);
		/* creamos los componentes de una ventana */

		etiqueta = new JLabel("Buenos dias", SwingConstants.CENTER);
		etiqueta.setFont(new Font("Arial", 1, 50));
		etiqueta.setBounds(150, 100, 400, 100);
		etiqueta.setBorder(blackline);

		// agregamos los componentes a la ventana

		miPanel.add(etiqueta);

		// actualizamos el panel
		miPanel.updateUI();
		this.setSize(700, 400);
		this.add(miPanel);
	}

	public static void main(String args[]) {
		Menu n1 = new Menu();

		n1.setVisible(true);
		n1.setLocationRelativeTo(null);
		n1.setDefaultCloseOperation(EXIT_ON_CLOSE);

	}
}
