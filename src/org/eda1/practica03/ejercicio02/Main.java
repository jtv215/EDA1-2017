package org.eda1.practica03.ejercicio02;

import java.io.File;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String directorioEntrada = System.getProperty("user.dir") + File.separator +
		"src" + File.separator +
		"org" + File.separator +
		"eda1" + File.separator +
		"practica03" + File.separator +
		"ejercicio02" + File.separator;
		ProcesarDatos proceso = new ProcesarDatos();
		proceso.cargarArchivo(directorioEntrada + "masNuevasEmpresasProyectosCiudades.txt");
		System.out.println("1)Devolver todas las empresas, todos los proyectos y todas las ciudades en tres funciones independientes.");
		System.out.println("2)Todas las Ciudades: \n" +proceso.devolverCiudades());
		System.out.println("3)Todos los Proyectos: \n" +proceso.devolverProyectos());
		System.out.println("4)Todas las Empresas: \n" +proceso.devolverEmpresas());
		System.out.println("5)Devolver las empresas que tienen su sede en la ciudad Miami:");
		System.out.println(proceso.devolverEmpresasCiudad("Miami"));
		System.out.println("6)Devolver los proyectos con sede en Washington:");
		System.out.println(proceso.devolverEmpresasCiudad("Washington"));
		System.out.println("7)¿En cuántas ciudades diferentes se desarrollan proyectos de Google?");
		System.out.println(proceso.numeroCiudadesProyecto("Google"));
		System.out.println("8)Devolver cuál es el proyecto con mayor número de sedes (ciudades):");
		System.out.println(proceso.devolverProyectoConMayorNumeroDeCiudades());
		System.out.println("9)Devolver cuál es la empresa con mayor número de proyectos.");
		System.out.println(proceso.devolverEmpresaConMayorNumeroDeProyectos());
		System.out.println("10)Devolver cuál es la ciudad con mayor número de proyectos");
		System.out.println(proceso.devolverCiudadConMayorNumeroDeProyectos());
	}
}
