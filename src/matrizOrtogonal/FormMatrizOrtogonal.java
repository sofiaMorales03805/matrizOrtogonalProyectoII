package matrizOrtogonal;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class FormMatrizOrtogonal extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textBase;
	private JTextField textAltura;
	private JTextField textPropietario;
	private JTextField textPlaca;
	private JTextField textModelo;
	private JTextField textLinea;
	private JTextField textColor;
	private JTextField textFila;
	private JTextField textColumna;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FormMatrizOrtogonal frame = new FormMatrizOrtogonal();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public FormMatrizOrtogonal() {
		setTitle("Matriz Ortogonal");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 488, 622);
		contentPane = new JPanel();
		contentPane.setForeground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);

		setContentPane(contentPane);

		JLabel lblNewLabel = new JLabel("PARQUEO ORTOGONAL");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setForeground(new Color(0, 112, 166));
		lblNewLabel.setFont(new Font("Lucida Console", Font.PLAIN, 25));
		lblNewLabel.setBounds(99, 25, 261, 45);
		contentPane.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("Ingrese el tamaño de su parqueo, A x B");
		lblNewLabel_1.setFont(new Font("Lucida Sans Unicode", Font.PLAIN, 12));
		lblNewLabel_1.setForeground(new Color(0, 0, 0));
		lblNewLabel_1.setBounds(56, 92, 367, 13);
		contentPane.add(lblNewLabel_1);

		textBase = new JTextField();
		textBase.setBounds(56, 125, 50, 25);
		contentPane.add(textBase);
		textBase.setColumns(10);

		textAltura = new JTextField();
		textAltura.setBounds(116, 125, 50, 25);
		contentPane.add(textAltura);
		textAltura.setColumns(10);

		JLabel lblNewLabel_2 = new JLabel("Ingrese los datos del vehículo:");
		lblNewLabel_2.setForeground(new Color(0, 0, 0));
		lblNewLabel_2.setFont(new Font("Lucida Sans Unicode", Font.PLAIN, 12));
		lblNewLabel_2.setBounds(56, 176, 367, 13);
		contentPane.add(lblNewLabel_2);

		JLabel lblNewLabel_3 = new JLabel("Propietario:");
		lblNewLabel_3.setFont(new Font("Lucida Sans Unicode", Font.PLAIN, 12));
		lblNewLabel_3.setForeground(new Color(0, 0, 0));
		lblNewLabel_3.setBounds(56, 221, 76, 13);
		contentPane.add(lblNewLabel_3);

		textPropietario = new JTextField();
		lblNewLabel_3.setLabelFor(textPropietario);
		textPropietario.setBounds(165, 218, 260, 25);
		contentPane.add(textPropietario);
		textPropietario.setColumns(10);

		JLabel lblNewLabel_4 = new JLabel("Placa:");
		lblNewLabel_4.setFont(new Font("Lucida Sans Unicode", Font.PLAIN, 12));
		lblNewLabel_4.setBounds(56, 263, 76, 13);
		contentPane.add(lblNewLabel_4);

		textPlaca = new JTextField();
		textPlaca.setBounds(165, 257, 260, 25);
		contentPane.add(textPlaca);
		textPlaca.setColumns(10);

		JLabel lblNewLabel_5 = new JLabel("Modelo: ");
		lblNewLabel_5.setFont(new Font("Lucida Sans Unicode", Font.PLAIN, 12));
		lblNewLabel_5.setBounds(56, 310, 60, 13);
		contentPane.add(lblNewLabel_5);

		textModelo = new JTextField();
		lblNewLabel_5.setLabelFor(textModelo);
		textModelo.setBounds(165, 304, 260, 25);
		contentPane.add(textModelo);
		textModelo.setColumns(10);

		JLabel lblNewLabel_6 = new JLabel("Línea:");
		lblNewLabel_6.setFont(new Font("Lucida Sans Unicode", Font.PLAIN, 12));
		lblNewLabel_6.setBounds(56, 360, 45, 13);
		contentPane.add(lblNewLabel_6);

		textLinea = new JTextField();
		textLinea.setBounds(165, 354, 260, 25);
		contentPane.add(textLinea);
		textLinea.setColumns(10);

		JLabel lblNewLabel_7 = new JLabel("Color:");
		lblNewLabel_7.setFont(new Font("Lucida Sans Unicode", Font.PLAIN, 12));
		lblNewLabel_7.setBounds(56, 406, 45, 13);
		contentPane.add(lblNewLabel_7);

		textColor = new JTextField();
		textColor.setBounds(163, 400, 260, 25);
		contentPane.add(textColor);
		textColor.setColumns(10);

		JLabel lblMensaje = new JLabel("");
		lblMensaje.setForeground(new Color(128, 0, 64));
		lblMensaje.setFont(new Font("Lucida Sans Unicode", Font.PLAIN, 11));
		lblMensaje.setBounds(56, 505, 386, 18);
		contentPane.add(lblMensaje);

		JButton btnGuardar = new JButton("Guardar");
		btnGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MatrizOrtogonal matrizOrtogonal = new MatrizOrtogonal();

				String fila = textFila.getText();
				String columna = textColumna.getText();
				String altura = textAltura.getText();
				String base = textBase.getText();
				String color = textColor.getText();
				String linea = textLinea.getText();
				String modelo = textModelo.getText();
				String placa = textPlaca.getText();
				String propietario = textPropietario.getText();

				if (matrizOrtogonal.esAlfanumerico(placa) || matrizOrtogonal.esNumero(altura) || matrizOrtogonal.esNumero(fila) || matrizOrtogonal.esNumero(columna) || matrizOrtogonal.esNumero(base)  || matrizOrtogonal.esNumero(modelo) || matrizOrtogonal.sonSoloLetras(color) ) {
					lblMensaje.setText("No es un formato permitido para este campo.");
				}
				
				Automovil automovil = new Automovil(color, linea, modelo, placa, propietario);

				if (altura.equals("") || base.equals("") || color.equals("") || linea.equals("") || modelo.equals("")
						|| placa.equals("") || propietario.equals("") || fila.equals("") || columna.equals("")) {
					lblMensaje.setText("Debe ingresar los datos del vehículo.");
				} else {
					lblMensaje.setText("");
					System.out.println("Fila :" + fila);
					System.out.println("columna :" + columna);
					System.out.println("base :" + base);
					System.out.println("linea :" + linea);
					System.out.println("propietario :" + propietario);
					matrizOrtogonal.crearMatriz(Integer.valueOf(base),Integer.valueOf(altura));
					matrizOrtogonal.insertar(0, 0, automovil);
					
				}
			}
		});

		btnGuardar.setBounds(66, 533, 85, 21);
		contentPane.add(btnGuardar);

		JButton btnSalir = new JButton("Salir");
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		btnSalir.setForeground(new Color(0, 0, 0));
		btnSalir.setBounds(324, 533, 85, 21);
		contentPane.add(btnSalir);

		JButton btnLimpiar = new JButton("Limpiar");
		btnLimpiar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textAltura.setText("");
				textBase.setText("");
				textColor.setText("");
				textLinea.setText("");
				textModelo.setText("");
				textPlaca.setText("");
				textPropietario.setText("");
			}
		});
		btnLimpiar.setBounds(194, 533, 85, 21);
		contentPane.add(btnLimpiar);

		JLabel lblNewLabel_8 = new JLabel("Ingrese lugar de parqueo:");
		lblNewLabel_8.setFont(new Font("Lucida Sans Unicode", Font.PLAIN, 12));
		lblNewLabel_8.setBounds(56, 447, 367, 13);
		contentPane.add(lblNewLabel_8);

		textFila = new JTextField();
		textFila.setBounds(56, 470, 40, 25);
		contentPane.add(textFila);
		textFila.setColumns(10);

		textColumna = new JTextField();
		textColumna.setBounds(113, 470, 40, 25);
		contentPane.add(textColumna);
		textColumna.setColumns(10);
	}
}
