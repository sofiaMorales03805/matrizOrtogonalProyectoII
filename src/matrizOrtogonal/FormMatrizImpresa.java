package matrizOrtogonal;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTable;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.SwingConstants;
import javax.swing.JScrollPane;
import java.awt.Cursor;
import java.awt.SystemColor;
import javax.swing.table.DefaultTableModel;
import javax.swing.JButton;

public class FormMatrizImpresa extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable tablaParqueos;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FormMatrizImpresa frame = new FormMatrizImpresa();
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
	public FormMatrizImpresa() {
		setTitle("LUGARES DISPONIBLES");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 771, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);

		setContentPane(contentPane);
		
		JLabel lblNewLabel = new JLabel("Lugares disponibles");
		lblNewLabel.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
		lblNewLabel.setBackground(Color.WHITE);
		lblNewLabel.setForeground(new Color(0, 128, 192));
		lblNewLabel.setFont(new Font("Lucida Sans Unicode", Font.BOLD, 32));
		lblNewLabel.setBounds(186, 10, 337, 70);
		contentPane.add(lblNewLabel);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(20, 99, 705, 277);
		contentPane.add(scrollPane);
		
		tablaParqueos = new JTable();
		tablaParqueos.setModel(new DefaultTableModel(
			new Object[][] {
				{null, "", null, null, ""},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
			},
			new String[] {
				"Propietario", "Placa", "Modelo", "Linea", "Color"
			}
		));
		tablaParqueos.setFont(new Font("Lucida Sans Unicode", Font.PLAIN, 11));
		scrollPane.setViewportView(tablaParqueos);
		
		JButton btnRegresar = new JButton("Regresar");
		btnRegresar.setBounds(625, 429, 100, 21);
		contentPane.add(btnRegresar);
	}
}
