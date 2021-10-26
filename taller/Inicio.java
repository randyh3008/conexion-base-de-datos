package taller;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextArea;
import javax.swing.border.Border;

/**
 *
 * @author User
 */
public class Inicio extends javax.swing.JFrame {
	private static final long serialVersionUID = 1L;
	JPanel miPanel;
	JButton boton;
	JButton volver;
	JTextArea area;
	JPasswordField label;
	JLabel etiqueta;
	JLabel etiqueta1;
	JLabel etiqueta2;

	public Inicio() {

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
		boton = new JButton("Iniciar");
		boton.setFont(new Font("Arial", 3, 20));
		boton.setBounds(250, 400, 200, 50);
		volver = new JButton("Regresar");
		volver.setFont(new Font("Arial", 3, 10));
		volver.setBounds(10, 10, 100, 25);
		etiqueta = new JLabel("Iniciar Sesion");
		etiqueta.setFont(new Font("Arial", 1, 30));
		etiqueta.setBounds(150, 50, 200, 25);
		etiqueta1 = new JLabel("Usuario");
		etiqueta2 = new JLabel("Contrase�a");
		boton.setBorder(blackline);
		area = new JTextArea();
		area.setFont(new Font("Arial", 1, 15));
		area.setBounds(70, 150, 200, 25);
		etiqueta1.setBounds(70, 100, 200, 25);
		etiqueta1.setFont(new Font("Arial", 1, 18));
		area.setBorder(blackline);
		label = new JPasswordField();
		label.setFont(new Font("Arial", 1, 18));
		label.setBounds(70, 250, 200, 25);
		etiqueta2.setBounds(70, 200, 200, 25);
		etiqueta2.setFont(new Font("Arial", 1, 18));
		label.setBorder(blackline);

		// agregamos los componentes a la ventana
		miPanel.add(boton);
		miPanel.add(label);
		miPanel.add(area);
		miPanel.add(volver);
		miPanel.add(etiqueta1);
		miPanel.add(etiqueta2);
		miPanel.add(etiqueta);
		addAccion(volver);
		addAccion2(boton);
		// actualizamos el panel
		miPanel.updateUI();
		this.setSize(500, 500);
		this.add(miPanel);
	}

	public void addAccion2(JButton boton) {
		boton.addActionListener((ActionEvent e) -> {
			String passText = new String(label.getPassword());
			if (!area.getText().isEmpty()) {
				if (!passText.isEmpty()) {
					Conexion p1 = new Conexion();

					if (p1.buscarUsuario("SELECT buscarUsuario('" + area.getText() + "','" + passText + "');")) {
						JOptionPane.showMessageDialog(null, "Inicio de sesion Exitoso");
						Menu f1 = new Menu();
						abrirVentana(f1);

					} else {
						JOptionPane.showMessageDialog(null, "Usuario no encontrado " + area.getText(), "Alert",
								JOptionPane.WARNING_MESSAGE);
					}
				} else {
					JOptionPane.showMessageDialog(null, "necesita llenar todos los campos", "Alert",
							JOptionPane.WARNING_MESSAGE);
				}

			} else {
				JOptionPane.showMessageDialog(null, "necesita poner un nombre de usuario ", "Alert",
						JOptionPane.WARNING_MESSAGE);
			}
		});
	}

	public void addAccion(JButton boton) {

		boton.addActionListener((ActionEvent e) -> {
			/* Add action */
			VentanaPrincipal i1 = new VentanaPrincipal();
			i1.setVisible(true);
			i1.setLocationRelativeTo(null);
			i1.setDefaultCloseOperation(EXIT_ON_CLOSE);
			i1.setResizable(false);
			this.dispose();
		});
	}

	public void abrirVentana(JFrame f1) {
		f1.setVisible(true);
		f1.setLocationRelativeTo(null);
		f1.setDefaultCloseOperation(EXIT_ON_CLOSE);
		f1.setResizable(false);
		this.dispose();
	}

	public void pintarPantalla(String importancias) {
		switch (importancias) {
		case "Media":
			miPanel.setBackground(Color.decode("#ffa48d"));
			boton.setBackground(Color.decode("#ff6741"));
			break;
		case "Alta":
			miPanel.setBackground(Color.decode("#3a9fbf"));
			boton.setBackground(Color.decode("#3a7ebf"));
			break;
		default:
			miPanel.setBackground(Color.lightGray);
			break;
		}
	}

}