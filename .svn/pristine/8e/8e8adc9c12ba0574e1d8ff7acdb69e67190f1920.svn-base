package org.eda1.ejercicio05;

import java.awt.BasicStroke;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.util.TreeMap;
import java.util.TreeSet;

import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class HotelGUI extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private Graphics2D g2;
	final static BasicStroke lightStroke = new BasicStroke(1.0f);
	final static BasicStroke stroke = new BasicStroke(2.0f);
    final static BasicStroke wideStroke = new BasicStroke(4.0f);
 
    final static float dash1[] = {10.0f};
    final static BasicStroke dashed = new BasicStroke(1.0f, 
                                                      BasicStroke.CAP_BUTT, 
                                                      BasicStroke.JOIN_MITER, 
                                                      10.0f, dash1, 0.0f);
    private TreeMap<Integer, TreeSet<Habitacion>> habitaciones;

	/**
	 * Create the frame.
	 */
	public HotelGUI(TreeMap<Integer, TreeSet<Habitacion>> habitaciones) {
//		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1050, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		this.habitaciones=habitaciones;
		add(contentPane);
		setVisible(true);
		
	}
	
	public void paint(Graphics g) {
        g2 = (Graphics2D) g;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2.setColor(Color.GRAY);
        g2.fillRect(7, 32, 1093, 538);
        g2.setColor(Color.BLACK);
        g2.drawRect(7, 32, 1093, 538);
        for (int i = 0; i < 30; i++) {
			drawRoom(i);
		}
        
        fillStairs();
        drawStairs();
	}
	
	public void drawStairs(){
		g2.setColor(Color.BLACK);
		for (int i = 0; i < 10; i++) {
			drawStep(i);
		}
		g2.drawRect(1015, 35, 75, 32);
		for (int i = 0; i < 10; i++) {
			drawStep2(i);
		}
		g2.drawLine(1032, 50, 1032, 167);
		g2.drawLine(1032, 50, 1072, 50);
		g2.drawLine(1072, 50, 1072, 167);
		g2.drawLine(1032, 50, 1022, 60);
		g2.drawLine(1032, 50, 1042, 60);
		g2.drawLine(1072, 167, 1062, 157);
		g2.drawLine(1072, 167, 1082, 157);
		g2.drawLine(1072, 50, 1062, 40);
		g2.drawLine(1072, 50, 1062, 60);
		
		g2.setColor(new Color(171, 149, 132));
		g2.fillRect(1100, 225, 70, 110);
		g2.setColor(Color.BLACK);
		g2.drawRect(1100, 225, 70, 110);
		g2.drawString("Ascensor", 1109, 285);
	}
	
	private void drawStep(int i) {
		g2.drawRect(1015, 67+i*10, 35, 10);
	}
	
	private void drawStep2(int i) {
		g2.drawRect(1055, 67+i*10, 35, 10);
	}
	
	public void fillStairs(){
		g2.setColor(Color.LIGHT_GRAY);
		for (int i = 0; i < 10; i++) {
			fillStep(i);
		}
		g2.fillRect(1015, 35, 75, 32);
		for (int i = 0; i < 10; i++) {
			fillStep2(i);
		}
		g2.setColor(Color.BLACK);
	}
	
	private void fillStep(int i) {
		g2.fillRect(1015, 67+i*10, 35, 10);
	}
	
	private void fillStep2(int i) {
		g2.fillRect(1055, 67+i*10, 35, 10);
	}

	public void drawRoom(int n){
		g2.setStroke(wideStroke);
		int x = 10+(n*100)%1000;
		int y = 35+(n/10)*130+(n/10)*50;
		g2.setColor(Color.WHITE);
		g2.fillRect(x, y, 100, 130);
		g2.setColor(Color.BLACK);
		g2.drawRect(x, y, 100, 130);
		
		g2.setStroke(stroke);
		if(habitaciones.get(HotelUI.planta).contains(new Habitacion(n))){
			Habitacion h = habitaciones.get(HotelUI.planta).ceiling(new Habitacion(n));
			int i = 0;
			Font font = g2.getFont();
			g2.setColor(Color.BLACK);
			for (Huesped f : h.getHuespedes()) {
				g2.setFont(new Font("Arial", Font.PLAIN, 8));
				g2.drawString(f.getNombre()+" "+f.getApellido1()+" "+f.getApellido2(), x+4, y+70+(i*10));
				i++;
			}
			g2.setFont(font);
			g2.setColor(Color.RED);
		}else{
			g2.setColor(Color.GREEN);
		}
		g2.fillRoundRect(x+14, y+4, 40, 50, 10, 10);
		g2.setColor(Color.BLACK);
		g2.drawRoundRect(x+14, y+4, 40, 50, 10, 10);
		g2.drawLine(x+90, y+130, x+90, y+100);
		g2.setStroke(dashed);
		g2.drawArc(x+60, y+100, 60, 60, 90, 90);
		
		g2.setStroke(lightStroke);
		g2.drawRoundRect(x+19, y+6, 30, 10, 10, 10);
		g2.drawLine(x+30, y+20, x+52, y+20);
		g2.drawLine(x+30, y+30, x+52, y+20);
		g2.drawLine(x+30, y+20, x+30, y+30);
		g2.drawRect(x+58, y+4, 10, 10);
		g2.drawRect(x+2, y+4, 10, 10);
		
		g2.drawString(HotelUI.planta+fillNumber(n, 3), x+20, y+50);
		
	}
	
	public String fillNumber(int number, int numberOfZeros){
		String s=""+number;
		while (s.length()<numberOfZeros) {
			s="0"+s;
		}
		return s;
	}
	
}
