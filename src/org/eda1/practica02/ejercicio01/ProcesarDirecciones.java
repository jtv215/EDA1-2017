package org.eda1.practica02.ejercicio01;

import java.util.List;
import java.util.Scanner;
import java.util.concurrent.SynchronousQueue;

import javax.swing.tree.TreeNode;

import org.eda1.practica02.edaAuxiliar.BSTree;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * The Class ProcesarDirecciones.
 */
public class ProcesarDirecciones {

	/** The tree direcciones. */
	private BSTree<DireccionMaquinas> treeDirecciones;

	/**
	 * Instantiates a new procesar direcciones.
	 */
	public ProcesarDirecciones() {
		this.treeDirecciones = new BSTree<DireccionMaquinas>();
	}

	/**
	 * Instantiates a new procesar direcciones.
	 *
	 * @param treeDirecciones
	 *            the tree direcciones
	 */
	public ProcesarDirecciones(BSTree<DireccionMaquinas> treeDirecciones) {
		this.treeDirecciones = treeDirecciones.clone();
	}

	/**
	 * Cargar archivo.
	 *
	 * @param archivo
	 *            the archivo
	 */
	public void cargarArchivo(String archivo) {
		Scanner scan = null;
		String linea = "";
		String[] items = null;

		this.treeDirecciones.clear();

		try {
			scan = new Scanner(new File(archivo));
			while (scan.hasNextLine()) {
				linea = scan.nextLine();
				if (linea.isEmpty())
					continue;
				items = linea.split(" ");
				this.add(items[0], items[1]); // ????
			}
		} catch (IOException e) {
			System.out.println(e.getMessage());
			System.exit(-1);
		}
		scan.close();
	}

	// public boolean add(String direccion, String maquina) {
	//
	// //creamos una Direccion maquina con la direccion pasada por parametro
	// //para poder comprobar si la contiene
	// DireccionMaquinas dm=new DireccionMaquinas(direccion);
	// //En el caso de que no la tenga, agregamos a esa DireccionMaquina un
	// nuevo
	// //maquina contador.
	// //y esa DireccionMaquina la agregamos al Bstree TReeDirecciones
	// if(treeDirecciones.find(dm)==null){//agrega una nueva direcciona maquina
	// dm.add(new MaquinaContador(maquina));
	// treeDirecciones.add(dm);
	// //En el caso de que si la contenga obtemos esa direccione
	// maquina(mediante el metodo find)...
	//
	// }else{
	//
	// DireccionMaquinas dm2=treeDirecciones.find(dm);//
	//
	// //y creamos una nueva maquina contador con la maquina pasada por
	// parametro
	// //para comprobar si esa dirreccionMaquina contiene la maquina Contador
	// MaquinaContador mc=new MaquinaContador(maquina);
	// //En el caso de que no la contenga,simplemente agregamos la
	// maquinaContador (tendrá el contador a 1)
	//
	// if(!dm2.getMaquinas().contains(mc)){
	// dm2.add(mc);
	// //En el caso de que si la contenga, la obtenemos (metodo find) y le
	// incrementamos el contador.
	// }else{
	// dm2.getMaquinas().find(mc).incrementarContador();
	// }
	// }
	// return true;
	// }

	/**
	 * Adds the. Si en el árbol treeDireeciones está a null, añada direción y la
	 * maquina
	 *
	 * @param direccion
	 *            the direccion
	 * @param maquina
	 *            the maquina
	 * @return true, if successful
	 */
	public boolean add(String direccion, String maquina) {

		DireccionMaquinas dm = new DireccionMaquinas(direccion);
		DireccionMaquinas auxDirecc = treeDirecciones.find(dm);
		if (auxDirecc == null) {
			dm.add(new MaquinaContador(maquina));
			treeDirecciones.add(dm);
		} else {
			MaquinaContador mc = new MaquinaContador(maquina);// creo la máquina
																// contador
			MaquinaContador auxMaqCont = auxDirecc.find(maquina);// busco la
																	// maquina
																	// contador
			if (auxMaqCont == null) {
				auxDirecc.add(mc);
			} else {
				auxMaqCont.incrementarContador();
			}
		}
		return true;
	}

	/**
	 * Size.
	 *
	 * @return the int
	 */
	public int size() {
		return this.treeDirecciones.size();
	}

	/**
	 * Gets the suma contadores.
	 *
	 * @return the suma contadores
	 */
	public int getSumaContadores() {
		int contador = 0;
		for (DireccionMaquinas dm : treeDirecciones) {
			for (MaquinaContador mc : dm.getMaquinas()) {
				contador += mc.getContador();
			}
		}

		return contador;
	}

	/**
	 * Gets the suma contadores.
	 *
	 * @param direccion
	 *            the direccion
	 * @return the suma contadores
	 */
	// dame aquella maquina que tenga esa direccion
	public int getSumaContadores(String direccion) {
		int contador = 0;
		DireccionMaquinas dm = treeDirecciones.find(new DireccionMaquinas(direccion));
		if (dm != null) {
			for (MaquinaContador mc : dm.getMaquinas()) {
				contador += mc.getContador();
			}
			return contador;
		} else {

			return -1;
		}
	}

	/**
	 * Gets the contador.
	 *
	 * @param direccion
	 *            the direccion
	 * @param maquina
	 *            the maquina
	 * @return the contador
	 */
	public int getContador(String direccion, String maquina) {
		DireccionMaquinas dm = treeDirecciones.find(new DireccionMaquinas(direccion));
		int contador = 0;
		if (dm != null) {
			MaquinaContador mc = dm.find(maquina);
			if (mc != null) {
				contador += mc.getContador();
			}
		}

		return contador;

	}


	/**
	 * Te paso como parametro el numero de un contador,
	 * y a ese número devuelveme la direccion.Direccion maquinas con contador.
	 *
	 * @param contador
	 *            the contador
	 * @return the string
	 */
	public String direccionMaquinasConContador(int contador) {
		String salida = "";
		for (DireccionMaquinas dm : treeDirecciones) {
			for (MaquinaContador mc : dm.getMaquinas()) {
				if (mc.getContador() == contador) {
					salida += "(" + dm.getDireccion() + ", " + mc.getMaquina() + ")\n";
				}
			}
		}

		return salida;

	}

	/**
	 * Guardar arbol.
	 *
	 * @param archivo
	 *            the archivo
	 */
	public void guardarArbol(String archivo) {
		try {
			PrintWriter out = new PrintWriter(archivo);
			out.print(treeDirecciones.toString());
			out.close();
		} catch (IOException e) {
			System.out.println(e.getMessage());
			System.exit(-1);
		}
	}

	@Override
	public String toString() {
		return treeDirecciones.toString();
	}



}
