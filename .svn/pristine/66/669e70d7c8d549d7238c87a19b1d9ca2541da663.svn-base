package org.eda1.prueba00.caso03;

import java.lang.reflect.Array;
import java.util.ArrayList;

import org.eda1.practica02.edaAuxiliar.AVLTree;

import javafx.scene.control.Alert;




public class Maquina implements Comparable<Maquina>{
	private String nombre;
	private AVLTree<IpMaquina> ips;

	public Maquina (String nombre){
		this.nombre = nombre==null ? "maquina?" : nombre;
		this.ips = new AVLTree<IpMaquina>();
	}

	public void add(String ip){
		//TODO

		IpMaquina aux1=new IpMaquina(ip);
		IpMaquina aux2= ips.find(aux1);

		if(aux2==null){
		ips.add(aux1);
		}else{
		aux2.incrementaContador();
		}
	}

	public ArrayList<IpMaquina> toArray(){
	//TODO
		ArrayList<IpMaquina> al=new ArrayList<IpMaquina>();
		for (IpMaquina ipMaquina : ips) {
			al.add(ipMaquina);
		}
	return al;
	}

	public boolean contains(String ip){
		return this.ips.contains(new IpMaquina(ip));
	}

	public String getNombre(){
		return this.nombre;
	}

	public int getNumIps(){
		//TODO

		int cont=0;
		for (IpMaquina ip : ips) {
			cont+=ip.getContador();//ojo es llamar a get contador para que te los cuente.
		}
		return cont;
	}

	@Override
	public String toString(){
		return this.nombre + " --> " + this.ips.toString();

	}

	@Override
	public int compareTo(Maquina otro){
		return this.nombre.compareTo(otro.nombre);
	}
}