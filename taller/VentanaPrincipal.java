package taller;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;

public class VentanaPrincipal extends javax.swing.JFrame {
	private static final long serialVersionUID = 1L;
	JButton boton;
	JButton boton1;
	JPanel miPanel;
	JLabel etiqueta;

	public VentanaPrincipal() {
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
		boton = new JButton("Iniciar Sesion");
		boton.setFont(new Font("Arial", 3, 20));
		boton.setBounds(450, 300, 200, 50);
		boton.setBorder(blackline);
		boton1 = new JButton("Crear Usuario");
		boton1.setFont(new Font("Arial", 3, 20));
		boton1.setBounds(50, 300, 200, 50);
		boton1.setBorder(blackline);
		etiqueta = new JLabel("Inicio");
		etiqueta.setFont(new Font("Arial", 1, 50));
		etiqueta.setBounds(270, 50, 400, 100);

		// agregamos los componentes a la ventana
		miPanel.add(boton);
		miPanel.add(boton1);
		miPanel.add(etiqueta);
		addAccion(boton);
		boton1.addActionListener((ActionEvent e) -> {
			Registro i1 = new Registro();
			i1.setVisible(true);
			i1.setLocationRelativeTo(null);
			i1.setDefaultCloseOperation(EXIT_ON_CLOSE);
			i1.setResizable(false);
			this.dispose();
		});
		// actualizamos el panel
		miPanel.updateUI();
		this.setSize(700, 400);
		this.add(miPanel);
	}

	public void addAccion(JButton boton) {
		boton.addActionListener((ActionEvent e) -> {
			Inicio i1 = new Inicio();
			i1.setVisible(true);
			i1.setLocationRelativeTo(null);
			i1.setDefaultCloseOperation(EXIT_ON_CLOSE);
			i1.setResizable(false);
			this.dispose();
		});
	}

	public static void main(String args[]) {
		VentanaPrincipal n1 = new VentanaPrincipal();
		n1.setVisible(true);
		n1.setLocationRelativeTo(null);
		n1.setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
}
