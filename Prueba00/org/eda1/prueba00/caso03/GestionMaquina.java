package org.eda1.prueba00.caso03;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

import javax.naming.spi.DirStateFactory.Result;

import org.eda1.practica02.edaAuxiliar.AVLTree;

public class GestionMaquina {
	private AVLTree<Maquina> arbol = new AVLTree<Maquina>();

	public void load(String nombreArchivo){
		//TODO
		 arbol.clear();
		try {

			Scanner sc=new Scanner(new File(nombreArchivo));
			Maquina m=null;
			while(sc.hasNextLine()){
				String s= sc.nextLine();
				if(s.startsWith("@"))continue;

				String []x=s.split(" ");
				String nombre= x[0];
				String ip=x[1];

				Maquina aux= arbol.find(new Maquina(nombre));

				if( aux!=null)
				aux.add(ip);
				else
				this.add(nombre, ip);
			}

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}



	}

	public void add(String maquina, String ip){
		//TODO
		Maquina m=this.arbol.find(new Maquina(maquina));

			if(m!=null){
				m.add(ip);
			}else {
					Maquina insertar= new Maquina(maquina);
				this.arbol.add(insertar);

				insertar.add(ip);
			}
	}

	public int size(){
		return this.arbol.size();
	}

	public ArrayList<String> maquinasConIp(String ip){
		//TODO
		ArrayList<String> resul=new ArrayList<String>(); //creo el array
		for (Maquina auxMaq : arbol) {//recorro el arbol
			if(auxMaq.contains(ip)){//si en ese arbol contiene esa ip
				resul.add(auxMaq.getNombre());//Añadame el nombre
			}
		}
				return resul;
	}

	public ArrayList<Maquina> toArrayWithOrder(Comparator<Maquina> comp){
		//TODO
		ArrayList<Maquina> al=new ArrayList<Maquina>();
		for(Maquina auMaquina:arbol)
			al.add(auMaquina);

		al.sort(comp);
	return al;
	}

	@Override
	public String toString(){
		return this.arbol.toString();
	}
}
