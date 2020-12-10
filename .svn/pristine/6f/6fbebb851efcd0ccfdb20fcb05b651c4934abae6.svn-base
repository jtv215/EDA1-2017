package org.eda1.ejercicio08;

public class StartUp implements Comparable<Object>{
	
	private String nombre;
	private String pais;
	private String descripcion;
	private String video;
	private String link;
	private int votos;
	
	public StartUp(String nombre){
		this(nombre, "", "", "", "", 0);
	}
	
	public StartUp(String nombre, String link){
		this(nombre, "", "", "", link, 0);
	}
	public StartUp(String nombre, String pais, String descripcion, String video, String link, int votos) {
		this.nombre=nombre.toUpperCase();
		this.pais=pais.isEmpty()?null:pais;
		this.descripcion=descripcion.isEmpty()?null:descripcion;
		this.video=video.isEmpty()?null:video;
		this.link=link.isEmpty()?null:link;
		this.votos=votos;
	}
	
	public StartUp(StartUp otro){
		this(otro.nombre, otro.pais, otro.descripcion, otro.video, otro.link, otro.votos);
	}
	
	public String getNombre() {
		return nombre;
	}
	public String getPais() {
		return pais;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public String getVideo() {
		return video;
	}
	public String getLink() {
		return link;
	}
	public int getVotos() {
		return votos;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public void setPais(String pais) {
		this.pais = pais;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public void setVideo(String video) {
		this.video = video;
	}
	public void setLink(String link) {
		this.link = link;
	}
	public void setVotos(int votos) {
		this.votos = votos;
	}
	public int diferenciaVotos(StartUp otro){
		//TODO La diferencia absoluta en votos con la startUp pasada por parametro
		return Math.abs(this.votos - otro.votos);
	}
	
	public String toString(){
		return nombre;
	}
	
	public String toStringComplete(){
		return nombre+" ("+(pais==null?"Desconocido":pais)+"):\n"+(descripcion==null?"Sin descripcion":descripcion)+" link: "+(video==null?"-":video)+"\nVotos: "+votos;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		StartUp other = (StartUp) obj;
		if (link == null) {
			if (other.link != null)
				return false;
		} else if (!link.equals(other.link))
			return false;
		if (nombre == null) {
			if (other.nombre != null)
				return false;
		} else if (!nombre.equals(other.nombre))
			return false;
		return true;
	}

	@Override
	public int compareTo(Object obj) {
		//TODO Compara primer por nombre y en caso de coincidencia, por link
		//Atención, puede que algun parametro sea null, teniendo preferencia aquel que no lo sea
		if (this == obj)
			return 0;
		if (obj == null)
			throw new RuntimeException("...comparando con nulo...");
		if (getClass() != obj.getClass())
			throw new RuntimeException("...comparando con objeto de distinta clase...");
		StartUp other = (StartUp) obj;
		int comp = this.nombre.compareTo(other.nombre);
		if(comp==0){
			if(this.link==null && other.link==null){
				return 0;
			}
			if(this.link==null ^ other.link==null){
				return this.link==null?1:-1;
			}
			return this.link.compareTo(other.link);
		}
		return comp;
	}
	
}
