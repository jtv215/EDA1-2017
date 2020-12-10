package org.eda1.actividad01.serializacionED;

import static org.junit.Assert.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.junit.Before;
import org.junit.Test;

public class SerializacionEDTestJUnit4 {
	
	String directorioEntrada = "";
	Serializacion serializacion = null;
	@Before
	public void setUp() throws Exception {
		directorioEntrada = System.getProperty("user.dir") + File.separator +
						    "src" + File.separator + 
						    "org" + File.separator +
						    "eda1" + File.separator + 
						    "actividad01" + File.separator + 
						    "serializacionED" + File.separator;
	}
	
	@Test
	public void testLoad() {
		String inputFile = directorioEntrada + "ciudadBarrios.txt";
		String inputFileEmpty = directorioEntrada + "ciudadBarriosVacia.txt";

		serializacion = new Serializacion();
		
		
		assertEquals(serializacion.toString(), "");

		serializacion.cargarArchivo(inputFileEmpty);
		
		assertEquals(serializacion.toString(), "");

		serializacion.cargarArchivo(inputFile);
		
		String salida = "";
		salida += "[Almeria, 36.5, -2.28, {Regiones, Nueva_Andalucia, Cruz_Caravaca, Araceli, Villablanca, Barrio_Alto, Paseo_Almeria, Zapillo}]" + "\n";
		salida += "[Granada, 37.11, -3.35, {Albaicin, Sacromonte, Los_Pajaritos, Chana, Cartuja, Zaidin}]" + "\n";
		salida += "[Malaga, 36.43, -4.25, {La_Goleta, El_Palo, La_Trinidad, La_Malagueta, La_Merced}]" + "\n";
		salida += "[Jaen, 37.46, -3.47, {La_Gloria, San_Ildefonso, Juderia, Las_Fuentezuelas}]"	+ "\n";
		salida += "[Cordoba, 37.53, -4.47, {Del_Carmen, Arenal, San_Francisco, Fuensanta}]"	+ "\n";
		salida += "[Sevilla, 37.23, -5.59, {Triana, Pineda, San_Pablo, Nervion, Macarena}]"	+ "\n";
		salida += "[Cadiz, 36.32, -6.18, {San_Juan, Mentidero, Santa_Maria}]" + "\n";
		salida += "[Huelva, 37.16, -6.57, {Reina_Victoria, Moret, Principe_Felipe}]" + "\n";

		assertEquals(serializacion.toString(), salida);

	}
	
	@Test
	public void testStore() throws FileNotFoundException, ClassNotFoundException, IOException{
		String inputFile = directorioEntrada + "ciudadBarrios.txt";
		String storeFile = directorioEntrada + "andalucia.dat";
		String salida1 = "", salida2 = "";
		serializacion = new Serializacion();

		serializacion.cargarArchivo(inputFile);
	
		serializacion.writeObject(storeFile);
		
		salida1 = "[Almeria, 36.5, -2.28, {Regiones, Nueva_Andalucia, Cruz_Caravaca, Araceli, Villablanca, Barrio_Alto, Paseo_Almeria, Zapillo}]" + "\n"
				+ "[Granada, 37.11, -3.35, {Albaicin, Sacromonte, Los_Pajaritos, Chana, Cartuja, Zaidin}]" + "\n"
				+ "[Malaga, 36.43, -4.25, {La_Goleta, El_Palo, La_Trinidad, La_Malagueta, La_Merced}]" + "\n"
				+ "[Jaen, 37.46, -3.47, {La_Gloria, San_Ildefonso, Juderia, Las_Fuentezuelas}]"	+ "\n"
				+ "[Cordoba, 37.53, -4.47, {Del_Carmen, Arenal, San_Francisco, Fuensanta}]"	+ "\n"
				+ "[Sevilla, 37.23, -5.59, {Triana, Pineda, San_Pablo, Nervion, Macarena}]"	+ "\n"
				+ "[Cadiz, 36.32, -6.18, {San_Juan, Mentidero, Santa_Maria}]" + "\n"
				+ "[Huelva, 37.16, -6.57, {Reina_Victoria, Moret, Principe_Felipe}]" + "\n";
		
		
		serializacion.add(new CiudadBarrios("Murcia", 37.59, -1.07));
		serializacion.add(new CiudadBarrios("Albacete", 39.00, -1.52));

		salida2 = salida1 + "[Murcia, 37.59, -1.07, {}]" + "\n"
						  + "[Albacete, 39.0, -1.52, {}]" + "\n";

		
		assertEquals(serializacion.toString(), salida2);

		serializacion.readObject(storeFile); //restauramos la estructura con los datos almacenados en archivo

		assertEquals(serializacion.toString(), salida1);

		

	}

}
