package org.eda1.ejercicio05;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.border.BevelBorder;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JViewport;
import java.awt.Dimension;

public class HotelUI extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	public static int planta=0;
	private JComboBox<Integer> habitacion;
	private JComboBox<Integer> plan;


	/**
	 * Create the frame.
	 */
	public HotelUI(final Hotel h) {
		try {
			UIManager.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException
				| UnsupportedLookAndFeelException e1) {
			e1.printStackTrace();
		}
		setTitle("Hotel "+h.getNombre());
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 552, 357);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		setExtendedState(JFrame.MAXIMIZED_BOTH);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.getViewport().setScrollMode(JViewport.SIMPLE_SCROLL_MODE);
		scrollPane.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		contentPane.add(scrollPane, BorderLayout.CENTER);
		
		final JPanel panel_1 = new HotelGUI(h.getHabitaciones());
		panel_1.setPreferredSize(new Dimension(1170, 570));
		panel_1.setAutoscrolls(true);
		scrollPane.setViewportView(panel_1);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new LineBorder(new Color(0, 0, 0)));
		contentPane.add(panel_2, BorderLayout.NORTH);
		panel_2.setLayout(new BorderLayout(0, 0));
		
		JLabel lblHotel = new JLabel("Hotel "+h.getNombre());
		lblHotel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblHotel.setHorizontalAlignment(SwingConstants.CENTER);
		panel_2.add(lblHotel,BorderLayout.CENTER);
		
		JLabel lblNewLabel = new JLabel(h.getDireccion());
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Arial", Font.PLAIN, 9));
		panel_2.add(lblNewLabel, BorderLayout.SOUTH);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBorder(new LineBorder(new Color(0, 0, 0)));
		contentPane.add(panel_3, BorderLayout.SOUTH);
		panel_3.setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		panel_3.add(panel, BorderLayout.NORTH);
		
		final JButton btnAnterior = new JButton("Anterior");
		btnAnterior.setEnabled(false);
		panel.add(btnAnterior);
		
		final JButton btnSiguiente = new JButton("Siguiente");
		panel.add(btnSiguiente);
		
		JPanel panel_4 = new JPanel();
		panel_3.add(panel_4, BorderLayout.SOUTH);
		
		final JLabel lblPlanta = new JLabel("Planta 0");
		lblPlanta.setFont(new Font("Tahoma", Font.PLAIN, 14));
		panel_4.add(lblPlanta);
		
		JPanel panel_5 = new JPanel();
		panel_3.add(panel_5, BorderLayout.EAST);
		
		JButton buttonMas = new JButton("Agregar");
		panel_5.add(buttonMas);
		
		JButton buttonMenos = new JButton("Desalojar");
		panel_5.add(buttonMenos);
		
		final JLabel lblOcupacion = new JLabel("Ocupacion: "+h.porcentajeDeOcupacion());
		lblOcupacion.setHorizontalAlignment(SwingConstants.RIGHT);
		panel_3.add(lblOcupacion, BorderLayout.CENTER);
		
		btnAnterior.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(planta==0) return;
				if(planta>0){
					planta--;
					btnAnterior.setEnabled(planta!=0);
					btnAnterior.setText("Planta "+(planta==0?"-":planta-1));
					lblPlanta.setText("Planta "+planta);
					btnSiguiente.setText("Planta "+(planta+1));
					btnSiguiente.setEnabled(true);
					repaint();
				}
				
			}
		});
		
		btnSiguiente.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(planta==6) return;
				if(planta<6){
					planta++;
					btnAnterior.setEnabled(true);
					btnAnterior.setText("Planta "+(planta-1));
					lblPlanta.setText("Planta "+planta);
					btnSiguiente.setEnabled(planta!=6);
					btnSiguiente.setText("Planta "+(planta==6?"-":planta+1));
					repaint();
				}
				
			}
		});
		
		buttonMas.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				JTextField dni = new JTextField(10);
				JTextField nombre = new JTextField(10);
				JTextField apellido1 = new JTextField(10);
				JTextField apellido2 = new JTextField(10);
				plan = new JComboBox<Integer>(new Integer[]{0,1,2,3,4,5,6});
				habitacion = new JComboBox<Integer>();
				for (int i = 0; i < 30; i++) {
					habitacion.addItem(i);
				}
				plan.addItemListener(new ItemListener() {
			        public void itemStateChanged(ItemEvent arg0) {
			           	planta=plan.getSelectedIndex();
			           	repaint();
			        }
			    });
				
				Object[] array = {"Dni", dni, "Nombre", nombre, "Apellido1", apellido1, "Apellido2", apellido2, "Planta", plan, "Habitacion", habitacion};
				int option = JOptionPane.showConfirmDialog(null, array, "Ingreso...", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null);
				
				while(option==JOptionPane.YES_OPTION){
					if(!checkDni(dni.getText())){
						JOptionPane.showMessageDialog(null, "El dni introducido no es válido", "Datos incorrectos", JOptionPane.ERROR_MESSAGE);
						dni.setText("");
						option = JOptionPane.showConfirmDialog(null, array, "Ingreso...", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null);
					}else if(nombre.getText().trim().isEmpty() || apellido1.getText().trim().isEmpty() || apellido2.getText().trim().isEmpty()){
						JOptionPane.showMessageDialog(null, "Datos de huesped incompletos", "Datos incorrectos", JOptionPane.ERROR_MESSAGE);
						option = JOptionPane.showConfirmDialog(null, array, "Ingreso...", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null);
					}else{
						boolean insertado=h.add(new Huesped(dni.getText(), nombre.getText(), apellido1.getText(), apellido2.getText()), new Habitacion(Integer.parseInt(habitacion.getSelectedItem().toString())), plan.getSelectedIndex());
						if(insertado){
							lblOcupacion.setText("Ocupacion: "+h.porcentajeDeOcupacion());
							repaint();
							break;
						}else{
							JOptionPane.showMessageDialog(null, "El usuario con dni "+dni.getText()+" ya está hospedado en el hotel", "Cliente ya hospedado", JOptionPane.WARNING_MESSAGE);
							option = JOptionPane.showConfirmDialog(null, array, "Ingreso...", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null);
						}
					}
				}
			}

			private boolean checkDni(String text) {
				if(text.length()!=9) return false;
				char[] LETRAS_NIF = { 'T', 'R', 'W', 'A', 'G', 'M',
			            'Y', 'F', 'P', 'D', 'X', 'B', 'N', 'J', 'Z', 'S', 'Q', 'V', 'H',
			            'L', 'C', 'K', 'E' };
				char x = text.substring(8).charAt(0);
				List<Character> l = new ArrayList<Character>();
				for (char c : LETRAS_NIF) {
					l.add(c);
				}
				if(!l.contains(x)) return false;
				int n = -1;
				try{
					n=Integer.parseInt(text.substring(0, 8));
				}catch (NumberFormatException e) {
					return false;
				}
				return text.substring(8).charAt(0)==LETRAS_NIF[n%23];
			}
		});
		
		buttonMenos.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				plan = new JComboBox<Integer>(new Integer[]{0,1,2,3,4,5,6});
				habitacion = new JComboBox<Integer>();
				for (int i = 0; i < 30; i++) {
					if(h.getHabitaciones().get(plan.getSelectedIndex()).contains(new Habitacion(i))){
						habitacion.addItem(i);
					}
				}
				plan.addItemListener(new ItemListener() {
			        public void itemStateChanged(ItemEvent arg0) {
			        	habitacion.removeAllItems();
			        	for (int i = 0; i < 30; i++) {
							if(h.getHabitaciones().get(plan.getSelectedIndex()).contains(new Habitacion(i))){
								habitacion.addItem(i);
							}
						}
			           	planta=plan.getSelectedIndex();
			           	repaint();
			        }
			    });
				Object[] array = {"Planta", plan, "Habitacion", habitacion};
				int option = JOptionPane.showConfirmDialog(null, array, "Desalojar habitacion", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null);
				if(option==JOptionPane.YES_OPTION){
					option=JOptionPane.showConfirmDialog(null, "Desea eliminar a los huespedes alojados en esta habitacion?", "Atención", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
					if(option==JOptionPane.YES_OPTION){
						h.getHabitaciones().get(plan.getSelectedIndex()).remove(new Habitacion((int) habitacion.getSelectedItem()));
						lblOcupacion.setText("Ocupacion: "+h.porcentajeDeOcupacion());
						repaint();
					}
				}
			}
		});
		
		setVisible(true);
	}

}
