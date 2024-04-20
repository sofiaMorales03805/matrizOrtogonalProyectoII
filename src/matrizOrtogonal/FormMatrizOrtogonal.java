package matrizOrtogonal;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.GraphicsConfiguration;
import java.awt.HeadlessException;
import java.awt.Color;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class FormMatrizOrtogonal extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textTamanio;
	private JTextField textPropietario;
	private JTextField textPlaca;
	private JTextField textModelo;
	private JTextField textLinea;
	private JTextField textColor;
	private JTextField textFila;
	private JTextField textColumna;
	private JLabel lblMensajeModelo;
	private JLabel lblMensajeLinea;
	private JLabel lblMensajeProp;
	private JLabel lblMensajeFila;
	private JLabel lblMensajePlaca;
	private JLabel lblMensajeParqueos;
	private JLabel lblMensajeColor;
	private Automovil automovil;
	
	
	
	
	//Instancia de la clase matriz donde estan los metodos
		MatrizOrtogonal matrizOrtogonal = new MatrizOrtogonal();

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
	private JButton btnBuscarM;
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

		JLabel lblNewLabel_1 = new JLabel("Ingrese el tamaño de su parqueo: ");
		lblNewLabel_1.setFont(new Font("Lucida Sans Unicode", Font.PLAIN, 12));
		lblNewLabel_1.setForeground(new Color(0, 0, 0));
		lblNewLabel_1.setBounds(56, 92, 367, 13);
		contentPane.add(lblNewLabel_1);

		textTamanio = new JTextField();
		textTamanio.setBounds(56, 125, 50, 25);
		contentPane.add(textTamanio);
		textTamanio.setColumns(10);

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
		lblMensaje.setBounds(49, 564, 374, 18);
		contentPane.add(lblMensaje);

		JButton btnGuardar = new JButton("Guardar");
		btnGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
	
				String tamanio = textTamanio.getText();
				boolean tamanioIngresado = false;
				String fila = textFila.getText();
				String columna = textColumna.getText();
				String color = textColor.getText().toUpperCase();
				String linea = textLinea.getText().toUpperCase();
				String modelo = textModelo.getText().toUpperCase();
				String placa = textPlaca.getText().toUpperCase();
				String propietario = textPropietario.getText().toUpperCase();

				// Verifica si ya se ha ingresado el tamaño de la matriz
				if (!tamanioIngresado) {
					// Verifica que el tamaño sean número válido
					if (matrizOrtogonal.esNumero(tamanio)) {
						int tamanioMatriz = Integer.parseInt(tamanio);

						textTamanio.setEditable(false);
						matrizOrtogonal.setColumna(Integer.parseInt(columna));
						matrizOrtogonal.setFila(Integer.parseInt(fila));
						matrizOrtogonal.setTamanioMatriz(tamanioMatriz);
						tamanioIngresado = true; // Marca que ya se ha ingresado el tamaño de la matriz
							
						automovil = new Automovil(placa, color, linea, modelo, propietario);
						
						if(!matrizOrtogonal.esNumero(modelo)) {
							lblMensajeModelo.setText("Debe ingresar números");
						}
						
						if(!matrizOrtogonal.esAlfanumerico(placa)) {
							lblMensajePlaca.setText("Debe ingresar un alfanumérico y máximo de 8 dígitos");
						}
						if(!matrizOrtogonal.sonSoloLetras(color)) {
								lblMensajeColor.setText("Debe ingresar solo letras.");
						}
											
						if(!matrizOrtogonal.sonSoloLetras(linea)) {
							lblMensajeLinea.setText("Debe ingresar solo letras.");
						}
					
						
						if (tamanio.equals("") || color.equals("") || linea.equals("") || modelo.equals("")
								|| placa.equals("") || propietario.equals("") || fila.equals("")
								|| columna.equals("")) {
							lblMensaje.setText("Debe ingresar los datos del vehículo.");
						} else {
							lblMensaje.setText("");
							matrizOrtogonal.insertar(Integer.valueOf(fila), Integer.valueOf(columna), automovil,
									Integer.valueOf(tamanio));
							matrizOrtogonal.imprimirMatriz();
							textColor.setText("");
							textLinea.setText("");
							textModelo.setText("");
							textPlaca.setText("");
							textPropietario.setText("");
							textFila.setText("");
							textColumna.setText("");
						}
					} else {
						lblMensaje.setText("El tamaño deben ser número válido.");
					}
				}
				// Utiliza el tamaño de la matriz ingresado previamente
				matrizOrtogonal.setTamanioMatriz(Integer.parseInt(tamanio));
			}
		});

		btnGuardar.setBounds(47, 533, 106, 21);
		contentPane.add(btnGuardar);

		JButton btnSalir = new JButton("Salir");
		btnSalir.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		btnSalir.setForeground(new Color(0, 0, 0));
		btnSalir.setBounds(311, 533, 112, 21);
		contentPane.add(btnSalir);

		JButton btnLimpiar = new JButton("Limpiar");
		btnLimpiar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textColor.setText("");
				textLinea.setText("");
				textModelo.setText("");
				textPlaca.setText("");
				textPropietario.setText("");
				textFila.setText("");
				textColumna.setText("");
			}
		});
		btnLimpiar.setBounds(185, 533, 106, 21);
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
		
		
		btnBuscarM  = new JButton("Buscar en Matriz");
		btnBuscarM.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FormBuscarMatriz newframe = new FormBuscarMatriz();
				newframe.setMatriz(matrizOrtogonal);
				newframe.setVisible(true);
			}
			
		});btnBuscarM.setBounds(273, 471, 150, 23);
		contentPane.add(btnBuscarM);
		
		lblMensajeModelo = new JLabel("");
		lblMensajeModelo.setLabelFor(textModelo);
		lblMensajeModelo.setFont(new Font("Lucida Sans Unicode", Font.PLAIN, 10));
		lblMensajeModelo.setBounds(165, 331, 258, 13);
		contentPane.add(lblMensajeModelo);
		
		lblMensajePlaca = new JLabel("");
		lblMensajePlaca.setLabelFor(textPlaca);
		lblMensajePlaca.setFont(new Font("Lucida Sans Unicode", Font.PLAIN, 10));
		lblMensajePlaca.setBounds(165, 281, 258, 13);
		contentPane.add(lblMensajePlaca);
		
		lblMensajeLinea = new JLabel("");
		lblMensajeLinea.setLabelFor(textLinea);
		lblMensajeLinea.setFont(new Font("Lucida Sans Unicode", Font.PLAIN, 10));
		lblMensajeLinea.setBounds(165, 377, 258, 13);
		contentPane.add(lblMensajeLinea);
		
		lblMensajeColor = new JLabel("");
		lblMensajeColor.setLabelFor(textColor);
		lblMensajeColor.setBounds(165, 424, 258, 13);
		contentPane.add(lblMensajeColor);
		
		lblMensajeProp = new JLabel("");
		lblMensajeProp.setLabelFor(textPropietario);
		lblMensajeProp.setBounds(165, 244, 261, 13);
		contentPane.add(lblMensajeProp);
		
		lblMensajeParqueos = new JLabel("");
		lblMensajeParqueos.setLabelFor(textFila);
		lblMensajeParqueos.setEnabled(false);
		lblMensajeParqueos.setBounds(56, 505, 355, 13);
		contentPane.add(lblMensajeParqueos);
		
	}
}
