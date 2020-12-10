package org.eda1.prueba00.caso01;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

import org.eda1.practica02.edaAuxiliar.AVLTree;


public class GestionTexto {
	private AVLTree<Palabra> arbolPalabra = new AVLTree<Palabra>();

//	public void cargarTexto(String nombreArchivo) throws FileNotFoundException {
//		// AtenciÃ³n a los comentarios (@) y caracteres no deseados... "[+-.,(
//		// )[ ]Â¡?!Â¿^]+"
//
//		//el s.trim().length==0 quita los espacios del primero y del ultimo
//		Scanner sc=new Scanner(new File(nombreArchivo));
//		this.arbolPalabra.clear();
//		while(sc.hasNextLine()){
//			String st=sc.nextLine();
//			if(st.isEmpty())continue;//si la linea esta vacía continua el bucle
//
//			String [] s=st.split("[ +-.,( )[ ]¡?!¿^]+"); //la cadena la parto
//			for(int i=0;i<s.length;i++){//recorro toda la frase
//				if(s[i].contains("@")){// si contiene @
//					break;
//				}
//
//				Palabra pl=this.arbolPalabra.find(new Palabra(s[i]));
//				if(pl!=null){
//					pl.incrementaFrecuencia();
//				}
//				if(pl==null){
//					this.arbolPalabra.add(new Palabra(s[i]));
//				}
//			}
//		}
//		sc.close();
//
//	}


	public void cargarTexto(String nombreArchivo) throws FileNotFoundException {
		File f= new File (nombreArchivo);
		Scanner sc=new Scanner(f);
		
	this.arbolPalabra.clear();
		while(sc.hasNextLine()){
			String s=sc.nextLine();

			if(s.startsWith("@") || s.trim().length()==0)continue;

			String []x= s.split("@");
			String []x2=x[0].split("[ +-.,( )[ ]¡?!¿^]+");
			for (String p : x2) {
				Palabra b=new Palabra(p);
				Palabra aux= arbolPalabra.find(b);
				if(aux==null){
					arbolPalabra.add(b);
				}else{
					aux.incrementaFrecuencia();
				}
			}
		}
		sc.close();
	}

	public int size(){
		return arbolPalabra.size();
	}

	public ArrayList<Palabra> toArray(){
		// Siguiendo el orden natural --> palabra
				ArrayList<Palabra> al = new ArrayList<Palabra>();
				for (Palabra p : arbolPalabra) {
					al.add(p);
				}
				return al;
			}


	public ArrayList<Palabra> toArrayWithOrder(Comparator<Palabra> comp){
		ArrayList<Palabra> al = toArray();
		if(comp==null)return null;
		Collections.sort(al, comp);
		return al;
	}

	@Override
	public String toString(){
		// Orden natural//[p1,p2,..p3
				// "[a <1,1>, ejemplo <7,3>,
		return this.toArray().toString();
	}
}