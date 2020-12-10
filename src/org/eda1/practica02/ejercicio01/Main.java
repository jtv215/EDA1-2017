package org.eda1.practica02.ejercicio01;

import java.io.File;

public class Main {

	public static void main(String[] args) {
		String dir = System.getProperty("user.dir") + File.separator + "src" + File.separator + "org" + File.separator
				+ "eda1" + File.separator + "practica02" + File.separator + "ejercicio01" + File.separator;
		String archivo = dir + "entradas.txt";

		ProcesarDirecciones pd = new ProcesarDirecciones();
		pd.cargarArchivo(archivo);

		System.out.println("ejercicio punto 2: " + pd.getContador("192.146.1.234", "leo.ual.es"));
		System.out.println("ejercicio punto 3: " + pd.getSumaContadores("192.146.1.234"));

	}
}
