package org.eda1.ejercicio05;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class Main {

	private static String dir = System.getProperty("user.dir")+File.separator+
			"src"+File.separator+
			"org"+File.separator+
			"eda1"+File.separator+
			"ejercicio05"+File.separator;
	
	public static void main(String[] args) throws FileNotFoundException {
		Hotel hotel = new Hotel();
		hotel.cargarDatos(dir+"datos.txt");
		new HotelUI(hotel);
	}
}
