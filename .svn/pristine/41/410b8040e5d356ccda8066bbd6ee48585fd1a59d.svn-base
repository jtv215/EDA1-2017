package org.eda1.prueba00.caso03;

import static org.junit.Assert.*;

import java.io.File;

import org.junit.Before;
import org.junit.Test;

public class GestionMaquinaTestJUnit4 {
	String directorioEntrada = "";
	GestionMaquina gestion = new GestionMaquina();

	@Before
	public void setUp() throws Exception {
		directorioEntrada = System.getProperty("user.dir") + File.separator +
						    "Prueba00" + File.separator +
						    "org" + File.separator +
						    "eda1" + File.separator +
						    "prueba00" + File.separator +
						    "caso03" + File.separator;
	}

	@Test
	public void testMaquina(){
		Maquina maq1 = null, maq2 = null, maq3 = null;

		maq1 = new Maquina("maquina1");
		maq2 = new Maquina(null);
		maq3 = new Maquina("maquina3");

		maq1.add("1");
		maq1.add("1");
		maq1.add("1");
		maq1.add("2");
		maq2.add("1");
		maq2.add("1");
		maq3.add("2");
		maq3.add("2");
		maq3.add("3");

		//toString()
		assertEquals(maq1.toString(), "maquina1 --> [<1,3>, <2,1>]");
		assertEquals(maq2.toString(), "maquina? --> [<1,2>]");
		assertEquals(maq3.toString(), "maquina3 --> [<2,2>, <3,1>]");

		//compareTo()
		assertTrue(maq1.compareTo(maq3) < 0);
		assertTrue(maq1.compareTo(maq1) == 0);
		assertTrue(maq2.compareTo(maq1) > 0);

		//toArray()
		assertEquals(maq1.toString(), "maquina1 --> " + maq1.toArray().toString());

	}

	@Test
	public void cargarArchivo(){
		String cadena = "";
		gestion.load(directorioEntrada + "archivo");
		cadena = "[ual.es --> [<1.1.2.2,3>, <1.2.1.1,1>], "
				+ "ugr.es --> [<1.1.2.2,2>, <1.3.1.1,2>], "
				+ "upo.es --> [<1.1.2.2,2>, <1.3.1.1,1>], "
				+ "use.es --> [<1.1.2.2,1>, <1.2.1.1,1>]]";

		assertTrue(gestion.size() == 4);
		assertEquals(gestion.toString(), cadena);

		//add --> nuevaMaquina
		gestion.add("nuevaMaquina", "1");
		gestion.add("ual.es", "1");
		assertTrue(gestion.size() == 5);
		assertTrue(gestion.toString().contains("[nuevaMaquina --> [<1,1>]") == true);

		//volvemos a cargar archivo...
		gestion.load(directorioEntrada + "archivo");
		System.out.println(gestion.size());
		assertTrue(gestion.size() == 4);
		assertEquals(gestion.toString(), cadena);

	}

	@Test
	public void testConsultas(){
		gestion.load(directorioEntrada + "archivo");

		assertEquals(gestion.maquinasConIp("1.1.2.2").toString(), "[ual.es, ugr.es, upo.es, use.es]");
		assertTrue(gestion.maquinasConIp("1.3.1.1").size() == 2);
		assertTrue(gestion.maquinasConIp("-1").size() == 0);
	}

	@Test
	public void testToArrayWithOrder(){
		String cadena = "";
		gestion.load(directorioEntrada + "archivo");

		cadena = "[ual.es --> [<1.1.2.2,3>, <1.2.1.1,1>], "
				+ "ugr.es --> [<1.1.2.2,2>, <1.3.1.1,2>], "
				+ "upo.es --> [<1.1.2.2,2>, <1.3.1.1,1>], "
				+ "use.es --> [<1.1.2.2,1>, <1.2.1.1,1>]]";

		assertEquals(gestion.toArrayWithOrder(new MaquinaComparatorLess()).toString(), cadena);

		cadena = "[use.es --> [<1.1.2.2,1>, <1.2.1.1,1>], "
				+ "upo.es --> [<1.1.2.2,2>, <1.3.1.1,1>], "
				+ "ugr.es --> [<1.1.2.2,2>, <1.3.1.1,2>], "
				+ "ual.es --> [<1.1.2.2,3>, <1.2.1.1,1>]]";

		assertEquals(gestion.toArrayWithOrder(new MaquinaComparatorGreater()).toString(), cadena);

		cadena = "[use.es --> [<1.1.2.2,1>, <1.2.1.1,1>], "
				+ "upo.es --> [<1.1.2.2,2>, <1.3.1.1,1>], "
				+ "ual.es --> [<1.1.2.2,3>, <1.2.1.1,1>], "
				+ "ugr.es --> [<1.1.2.2,2>, <1.3.1.1,2>]]";

		assertEquals(gestion.toArrayWithOrder(new IPContComparatorLess()).toString(), cadena);
	}
}