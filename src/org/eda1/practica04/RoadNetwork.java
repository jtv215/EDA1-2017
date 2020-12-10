package org.eda1.practica04;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import org.eda1.practica04.edaAuxiliar.Network;

/**
 * The Class RoadNetwork.
 */
public class RoadNetwork extends Network<String> {

	/**
	 * Load road network.
	 *
	 * @param filename the filename
	 */
	public void loadRoadNetwork(String filename){

		try {
			Scanner sc= new Scanner(new File(filename));
			boolean td=false;
			while(sc.hasNextLine()){
			String s= sc.nextLine();
			if(s.startsWith("%")||s.trim().isEmpty())continue;

			if(s.startsWith("@")){

				if(s.startsWith("@T")){
					setDirected((!sc.nextLine().equals("Not Directed")));//devuelve boolean

				}else if(s.startsWith("@V")){
					td=false;


				}else if(s.startsWith("@E")){
					td=true;
				}

				continue;
			}
			if(td==false){
				addVertex(s);
			}else{
				String []x=s.split(" ");
				addEdge(x[0], x[1], Double.parseDouble(x[2]));

			}
			}

			sc.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
