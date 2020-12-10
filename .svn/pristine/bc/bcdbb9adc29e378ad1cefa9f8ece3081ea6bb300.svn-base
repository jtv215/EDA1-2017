package org.eda1.prueba00.caso03;

public class IpMaquina implements Comparable<IpMaquina>{
	private String ip;
	private int cont;
	
	IpMaquina(String ip){
		this.ip = ip;
		this.cont = 1;
	}
	
	public void incrementaContador(){
		this.cont++;
	}
	
	public int getContador(){
		return this.cont;
	}
	
	@Override
	public String toString(){
		return "<" + this.ip + "," + this.cont + ">";
	}
	
	@Override
	public int compareTo(IpMaquina otro){
		return this.ip.compareTo(otro.ip);
	}
}
