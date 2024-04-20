package matrizOrtogonal;
import javax.swing.table.DefaultTableModel;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.HeadlessException;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;

import javax.swing.JScrollPane;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class FormBuscarMatriz extends JFrame {
	
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable table;
	private JTextField textPopiedad1;
	private JTextField textPropiedad2;
	private MatrizOrtogonal matriz;
	JComboBox comboBoxPropiedad1;
	JComboBox comboBoxPropiedad2;

	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FormBuscarMatriz frame = new FormBuscarMatriz();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	public void setMatriz(MatrizOrtogonal matriz) {
		this.matriz = matriz;
	}
	
	/**
	 * Create the frame.
	 * @param matrizOrtogonal 
	 */
	
	public FormBuscarMatriz() {
		
			
		setTitle("Buscar en Matriz");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 584, 392);
		contentPane = new JPanel();
		contentPane.setForeground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
		
		setContentPane(contentPane);
		
		JButton btnRegresarInicio = new JButton("Regresar");
		btnRegresarInicio.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FormMatrizOrtogonal newframe = new FormMatrizOrtogonal();
				newframe.setVisible(true);
				dispose(); 
			}
		});
		btnRegresarInicio.setBounds(409, 25, 89, 23);
		contentPane.add(btnRegresarInicio);
		
		JLabel lblNewLabel = new JLabel("Vehiculo Registrado");
		lblNewLabel.setForeground(new Color(0, 128, 192));
		lblNewLabel.setBackground(new Color(255, 255, 255));
		lblNewLabel.setFont(new Font("Lucida Sans Unicode", Font.BOLD, 17));
		lblNewLabel.setBounds(174, 11, 194, 46);
		contentPane.add(lblNewLabel);
		
        
        /*
		table.setColumnSelectionAllowed(true);
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
			},
			
        
			new String[] {
				"Placa", "color", "Linea", "Modelo", "Propietario"
			}
		));
		table.setBounds(54, 223, 353, 194);
		contentPane.add(table);
		*/
		table = new JTable();
        table.setModel(new DefaultTableModel(
                new Object[][]{},
                new String[]{"Placa", "Color", "Linea", "Modelo", "Propietario"}
        ));
        table.setBounds(54, 147, 483, 121);
        contentPane.add(table);
		
		textPopiedad1 = new JTextField();
		textPopiedad1.setBounds(197, 56, 86, 20);
		contentPane.add(textPopiedad1);
		textPopiedad1.setColumns(10);
		
		textPropiedad2 = new JTextField();
		textPropiedad2.setColumns(10);
		textPropiedad2.setBounds(197, 82, 86, 20);
		contentPane.add(textPropiedad2);
		
		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Automovil automovil;
				String propiedad1 = comboBoxPropiedad1.getSelectedItem().toString();
				String propiedad2 = comboBoxPropiedad2.getSelectedItem().toString();
				String prop1 = textPopiedad1.getText().toUpperCase();
                String prop2 = textPropiedad2.getText().toUpperCase();
                
                automovil = matriz.buscarAutomovilAtributo(propiedad1, prop1, propiedad2, prop2 );
                if (automovil != null) {
                    DefaultTableModel model = (DefaultTableModel) table.getModel();
                    model.setRowCount(0); // Limpia la tabla antes de agregar los resultados
                    model.addRow(new Object[]{automovil.getPlaca(), automovil.getColor(), automovil.getLinea(), automovil.getModelo(), automovil.getPropietario()});
                } else {
                    JOptionPane.showMessageDialog(null, "No se encontró ningún automóvil con esa placa");
                }
            }
        });
        btnBuscar.setBounds(409, 80, 89, 23);
        contentPane.add(btnBuscar);		
		
		//Agregar la tabla a un JScrollPane para hacerla desplazable
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(54, 182, 86, 23);
		contentPane.add(scrollPane);
		
		comboBoxPropiedad1 = new JComboBox();
		comboBoxPropiedad1.setModel(new DefaultComboBoxModel(new String[] {"Color", "Linea", "Modelo", "Placa", "Propietario"}));
		comboBoxPropiedad1.setFont(new Font("Lucida Sans Unicode", Font.PLAIN, 11));
		comboBoxPropiedad1.setMaximumRowCount(5);
		comboBoxPropiedad1.setBounds(54, 55, 120, 21);
		contentPane.add(comboBoxPropiedad1);
		
		comboBoxPropiedad2 = new JComboBox();
		comboBoxPropiedad2.setFont(new Font("Lucida Sans Unicode", Font.PLAIN, 11));
		comboBoxPropiedad2.setModel(new DefaultComboBoxModel(new String[] {"Color", "Linea", "Modelo", "Placa", "Propietario"}));
		comboBoxPropiedad2.setMaximumRowCount(5);
		comboBoxPropiedad2.setBounds(54, 80, 120, 21);
		contentPane.add(comboBoxPropiedad2);
		
		setVisible(true);
		
	}

}

