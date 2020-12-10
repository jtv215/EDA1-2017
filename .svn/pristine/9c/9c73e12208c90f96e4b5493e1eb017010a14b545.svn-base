package org.eda1.practica01.ejercicio01;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;

/**
 * The Class Editor.
 */
public class Editor {

     /** The text. */
     private LinkedList<String> text;

     /** The current. */
     private ListIterator<String> current;

     /** The inserting. */
     private boolean inserting;

    /**
     * Contructor por defecto.
     */
     public Editor() {
         text = new LinkedList<String>();
         current = text.listIterator();
         inserting = false;
     }

/**
 * Cargar fichero.
 *
 * @param file the file
 */
     public void loadFile(String file) {

         Scanner fileScanner = null;//lo inicializas a null
         PrintWriter printWriter = null;

         try {
 			fileScanner = new Scanner(new File(file));
 			printWriter = new PrintWriter(new FileWriter (file + ".out"));
 		} catch (IOException e) {
 			e.printStackTrace();
 			System.exit(-1);
 		}
         editText(fileScanner, printWriter);//llamo a ese metodo edit text
         fileScanner.close();
         printWriter.close();

     }

     /**
      * Creates the output file by performing the input-file commands.
      *
      * @param fileScanner - the Scanner over the input file.
      * @param printWriter - the PrintWriter for the output file.
      *
      */
     private void editText(Scanner fileScanner, PrintWriter printWriter) {
    	    String line = "";
            String result = "";

            while (true) {
                try {
                    line = fileScanner.nextLine();
                    printWriter.println(line);
                    result = interpret(line);//interpret es un metodo
                    if ((result != null) && (!line.equals(Auxiliar.DONE_COMMAND)))
                    	printWriter.println(result);
                 }
                 catch (RuntimeException e) {
                     printWriter.println(e.getMessage());
                 }

                 if (line.equals(Auxiliar.DONE_COMMAND)) {
                     printWriter.println(Auxiliar.FINAL_MESSAGE + result);
                     break;
                 }
              }
     }

     /**
      *  Intreprets whether a specified line is a legal command, an illegal command
      *  or a line of text.
      *
      * @param s - the specified line to be interpreted.
      * @return the result of carrying out the command, if s is a legal command, and
      *                return null, if s is a line of text or a command that does
      *                not return a value.
      */
 	protected String interpret(String s) {

 	 		String result=null;
 	        if(s==null || s.length()==0)   //si la linea que me envia es null o vacia  devuelve null
 	        	return null;
 	       //hasta aqui nos aseguramos de que al menos contiene un caracter

 	        if(s.charAt(0) !=Auxiliar.COMMAND_START){//si el primer caracter  no es un dolar
 	        	//si estamos insertando
 	     	   if(inserting){//false
 	     		   insert(s);//llamo a l metodo insert ,inserta la linea
 	     	   }
 	     	   else{
 	     		   throw new RuntimeException(Auxiliar.BAD_LINE_MESSAGE);//si no lanza exception diciendo que no es un comando
 	     	   }
 	        	return null;
 	        }
 	        //si el primero es un $
 	        // si es el comando %insert

 	        if(s.equals(Auxiliar.INSERT_COMMAND)){
 	        inserting=true;
 	        return null;
 	 		}
 	        //si no es el comando $inser, entonces inserting es false
 	        inserting=false;
 	        //si  el string que me pasan contine el mismo comando que en la clase auxiliar, ejecuta el metodo.
 	        if(s.contains(Auxiliar.DELETE_COMMAND))
 	        	tryToDelete(s);
 	        else if(s.contains(Auxiliar.LINE_COMMAND))
 	        		tryToSetCurrentLineNumber(s);
 	        else if(s.contains(Auxiliar.DONE_COMMAND))
 	        		result=done();
 	        else if (s.contains(Auxiliar.LAST_COMMAND))
 	        	result=last();
 	        else if(s.contains(Auxiliar.GETLINES_COMMAND))
 	        	result=tryToGetLines(s);
 	        else{
 	        	throw new RuntimeException(Auxiliar.BAD_COMMAND_MESSAGE);//seria un comando incorrecto
 	        }

 	        return result;
 	 	}


     /**
      *  Deletes the lines specified by the given line numbers, unless what follows
      *  $Delete is something other than two integers in the correct range.
      *
      * @param s the s
      */
 	//El string que me pasan por parametro,  tiene que recibir dos numeros enteros para borrar las lineas x a y, sino es asi
 	// lanzame las excepciones.
     private void tryToDelete(String s) {
         int m = 0, n = 0;
         Scanner sc = new Scanner(s);
         sc.next();
         try {
             m = sc.nextInt();
             n = sc.nextInt();

         }
         catch (RuntimeException e) {
        	 sc.close();

             throw new RuntimeException(Auxiliar.TWO_INTEGERS_NEEDED);
         } // not enough integer tokens
         if(n>=text.size()){
        	 throw new RuntimeException(Auxiliar.SECOND_TOO_LARGE);
         }
         delete(m, n);
         sc.close();
     }

     /**
      *  Deletes a specified range of lines from the text, and sets the current line
      *  to be the line after the last line deleted.
      *
      * @param m - the beginning index of the range of lines to be deleted.
      * @param n - the ending index of the range of lines to be deleted.
      */
     private void delete(int m, int n) {
    	 if(m > n){
   			throw new RuntimeException(Auxiliar.FIRST_GREATER);
   		}
     	 if(m < 0){
   			throw new RuntimeException(Auxiliar.FIRST_LESS_THAN_ZERO);
   		}
     	 if(n >= text.size()){
    			throw new RuntimeException(Auxiliar.SECOND_TOO_LARGE);
    		}
    	 setCurrentLineNumber(m);//para decir que me voy a colocar en la linea m
    	 for(int i= m; i<=n;i++){
    		 current.next(); //ojo: la linea next es porque cuenta desde el cero
    		 current.remove();

    	 }
    	 //y finamente cambiamos la linea a numero m
    	 setCurrentLineNumber(m);
     }


     /**
      *  Sets the current line as specified by the given line number, unless what follows
      *  $Line is something other than an integer in the correct range.
      *
      * @param s the s
      */
     //el string que me pasan lo divido en con un split
     private void tryToSetCurrentLineNumber(String s) {

    	 String[] x=s.split(" ");//cosidera espacio entre limitadores
    	 try{
    		 int m=Integer.parseInt(x[1]);// el 0 es el string, el 1 sera el numero entero.
    		 if(m<0){
    			 throw new RuntimeException(Auxiliar.M_LESS_THAN_ZERO);
    		 }else if(m>=text.size()){
    			 throw new RuntimeException(Auxiliar.M_TOO_LARGE);

    		 }else{
    			 setCurrentLineNumber(m);

    		 }
    	 } catch (NumberFormatException e) {
    			 throw new RuntimeException(Auxiliar.INTEGER_NEEDED);

			}
    	 }



     /**
      *  Makes a specified index the index of the current line in the text.
      *
      * @param m - the specified index of the current line.
      */
     private void setCurrentLineNumber(int m) {

    	 if(m<0){
			 throw new RuntimeException(Auxiliar.M_LESS_THAN_ZERO);
		 }else if(m>=text.size()){
			 throw new RuntimeException(Auxiliar.M_TOO_LARGE);
    	 }
    	 //para decirle en que  posicion voy a estar
    	 current=text.listIterator(m);
     }

     /**
      *  Inserts a specified line in front of the current line.
      *
      * @param s - the line to be inserted.
      */
     //añade el string y si los caracteres son largos  lanzame una excepcion.
     private void insert(String s) {

    	 if(s.length()>Auxiliar.MAX_LINE_LENGTH){
	throw new RuntimeException(Auxiliar.LINE_TOO_LONG);

    	 }
    	 current.add(s);
     }


     /**
      *  Returns the final version of the text.
      *
      *  @return the final version of the text.
      *
      */
     private String done() {
         String s = "";

         for (String itr: text){
        	 s += itr + '\n';
         }

         return s;
     }

     /**
      * Last.
      *
      * @return the string
      */
     private String last() {
         return Integer.toString(text.size());
     }

     /**
      * Try to get lines.
      *
      * @param s the s
      * @return the string
      */
     private String tryToGetLines(String s) {

    	 String[] x=s.split(" ");//que me lo divide
    	 try {
			int m= Integer.parseInt(x[1]);//seleciono la posicion 1
    		 int n= Integer.parseInt(x[2]);
    		 if(m<0){
    			 throw new RuntimeException(Auxiliar.FIRST_LESS_THAN_ZERO);
    		 }
    		 if(m>n){
    			 throw new RuntimeException(Auxiliar.FIRST_GREATER);
    		 }if(n>=text.size()){
    			 throw new RuntimeException(Auxiliar.SECOND_TOO_LARGE);

    		 }
    		 return getLines(m,n);
		} catch (NumberFormatException e) {
			throw new RuntimeException(Auxiliar.TWO_INTEGERS_NEEDED);
		}
     }

/**
 * El método getLine devuelve en un texto la línea m a la  n. que me pasan por parámetro
 *
 * @param m the m
 * @param n the n
 * @return the lines
 */
     private String getLines(int m, int n) {
    	 String s="";
    	 for (int i = m; i <= n; i++) {
    		 s+=i +"\t"+text.get(i)+"\n";
      		 }

    	 return s;
     }

}
