package org.eda1.practica03.ejercicio01;

import java.io.File;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String directorioEntrada = System.getProperty("user.dir") + File.separator +
		"src" + File.separator +
		"org" + File.separator +
		"eda1" + File.separator +
		"practica03" + File.separator +
		"ejercicio01" + File.separator;

		ProcesarDirecciones proceso = new ProcesarDirecciones();
		proceso.cargarArchivo(directorioEntrada + "entradas.txt");
		System.out.println("1)Devolver todas las máquinas que el contador sea mayor que 1:");
		System.out.println(proceso.maquinasConContadorMayorQue(1).toString());
		System.out.println("2)Devolver todas las máquinas que el contador sea mayor que 2:");
		System.out.println(proceso.maquinasConContadorMayorQue(2).toString());
		System.out.println("3)¿Cuántas máquinas que tiene un valor de contador igual a 2:");
		System.out.println(proceso.maquinasConContadorIgualA(2));
		System.out.println("4)¿Cuántas máquinas que tienen un valor de contador igual a 3:");
		System.out.println(proceso.maquinasConContadorIgualA(3));
		System.out.println("5)¿Cuál es el valor del contador del par (dirección, máquina) = (192.146.1.233, pascal.ual.es)?");
		System.out.println(proceso.getContador("192.146.1.233", "pascal.ual.es"));
		System.out.println("6)¿Cuál es el valor del contador del par (dirección, máquina) = (192.146.1.234, voltaire.ual.es)?");
		System.out.println(proceso.getContador("192.146.1.234", "voltaire.ual.es"));
		System.out.println("7)Devolver las incidencias que ha registrado la dirección 192.146.1.233 a nivel de máquinas?");
		System.out.println(proceso.incidenciasGeneradasPorIP("192.146.1.233"));
		System.out.println("8)Devolver las incidencias que ha registrado la dirección 192.146.1.234 a nivel de máquinas?");
		System.out.println(proceso.incidenciasGeneradasPorIP("192.146.1.234"));
		System.out.println("9)¿Cuántas incidencias ha registrado la direccion 113.213.12.1?");
		System.out.println(proceso.numeroDeIncidenciasGeneradasPorIP("113.213.12.1"));
		System.out.println("10)¿Cuántas incidencias ha registrado la direccion 192.146.1.234?");
		System.out.println(proceso.numeroDeIncidenciasGeneradasPorIP("192.146.1.234"));

	}
}