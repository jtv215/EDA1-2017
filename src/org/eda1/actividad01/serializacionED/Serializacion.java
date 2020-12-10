package org.eda1.actividad01.serializacionED;

import java.io.*;
import java.util.Scanner;

import org.eda1.actividad01.edaAuxiliar.ArrayList;

/**
 * The Class Serializacion.
 */
public class Serializacion {

	/** The ciud barr. */
	private ArrayList<CiudadBarrios> ciudBarr = new ArrayList<CiudadBarrios>();

	/**
	 * El m�todo cargar archivo ,lee el archivo que nos pasan por parametro
	 * va de fila en fila,y en cada fila, se hace uso del metodo split para separar
	 * esa linea y guardarla en un array, donde luego separamos la ciudad, y lo guardamos
	 * en un arraylist.
	 *
	 * @param archivo the archivo
	 */
	public void  cargarArchivo(String archivo) {
		//TODO
	try {

		Scanner sc=new Scanner(new File(archivo));
		while(sc.hasNextLine()){

			String []x= sc.nextLine().split(" ");
			if(x.length==0){
				continue;//pasa al while, y en el texto como no hay siguiente linea termina.
			}
			CiudadBarrios cb=new CiudadBarrios(x[0], Double.parseDouble(x[1]), Double.parseDouble(x[2]));//hago un objeto con ciudad barrios
			for (int i = 4; i < x.length; i++) {//empezamos de la posicion 4 en adelante
				cb.addBarrio(x[i]);
			}
			ciudBarr.add(cb);
		}
		sc.close();
	} catch (FileNotFoundException e) {
		e.printStackTrace();
	}



	}

	/**
	 * Adds the Arraylist.
	 *
	 * @param cB the c b
	 */
	public void add(CiudadBarrios cB){
		this.ciudBarr.add(cB);
	}

	/**
	 * Write object.
	 *
	 * @param archivoOut the archivo out
	 * @throws FileNotFoundException the file not found exception
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	public void writeObject(String archivoOut) throws FileNotFoundException, IOException{
		// object stream connected to file "archivoOut" for output
		ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(archivoOut));

		// send object and close down the output stream
		oos.writeObject(this.ciudBarr); //Habría que implementar el metodo writeObject de ArrayList<> (nuestra versión)
		oos.flush();
		oos.close();
	}

	/**
	 * Read object.
	 *
	 * @param archivoIn the archivo in
	 * @throws FileNotFoundException the file not found exception
	 * @throws IOException Signals that an I/O exception has occurred.
	 * @throws ClassNotFoundException the class not found exception
	 */
	@SuppressWarnings("unchecked")
	public void readObject(String archivoIn) throws FileNotFoundException, IOException, ClassNotFoundException{
		// object stream connected to file "archivoIn" for input
		ObjectInputStream ois = new ObjectInputStream(new FileInputStream(archivoIn));

		//reconstruct object and allocate new current object

		this.ciudBarr = (ArrayList<CiudadBarrios>) ois.readObject();
		ois.close();
	}

	public String toString() {
		String salida = "";
		for (CiudadBarrios cu: this.ciudBarr)
			salida += cu.toString() + "\n";
		return salida;
	}

}
