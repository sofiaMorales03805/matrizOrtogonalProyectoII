package matrizOrtogonal;

import java.util.regex.Pattern;

public class MatrizOrtogonal {
	    NodoFila primeraFila;
	    NodoColumna primeraColumna;
	    int filas;
	    int columnas;

	    public MatrizOrtogonal(int filas, int columnas) {
	        this.filas = filas;
	        this.columnas = columnas;
	        this.primeraFila = null;
	        this.primeraColumna = null;
	    }

	    public MatrizOrtogonal() {
			// TODO Auto-generated constructor stub
		}
	    
	    public void crearMatriz(int filas, int columnas) {
	    	//Crea la matriz con el numero ingresado por el usuario.
	    	MatrizOrtogonal matriz = new MatrizOrtogonal(filas, columnas);
	    }
	    
		public void insertar(int fila, int columna, Automovil automovil) {
	        if (fila >= filas || columna >= columnas || fila < 0 || columna < 0) {
	            System.out.println("Índices fuera de rango.");
	            return;
	        }

	        NodoFila nuevaFila = obtenerNodoFila(fila);
	        NodoColumna nuevaColumna = obtenerNodoColumna(columna);

	        NodoColumna nuevoNodoColumna = new NodoColumna(columna, automovil);

	        // Insertar en la fila
	        if (nuevaFila.getDerecha() == null || nuevaFila.getDerecha().getColumna() > columna) {
	            nuevoNodoColumna.setSiguiente(nuevaFila.getDerecha());
	            nuevaFila.setDerecha(nuevoNodoColumna);
	        } else {
	            NodoColumna actual = nuevaFila.getDerecha();
	            while (actual.getSiguiente() != null && actual.getSiguiente().getColumna() < columna) {
	                actual = actual.getSiguiente();
	            }
	            nuevoNodoColumna.setSiguiente(actual.getSiguiente());
	            actual.setSiguiente(nuevoNodoColumna);
	        }

	        NodoFila nuevoNodoFila = new NodoFila(fila);
	        
	        // Insertar en la columna
	        if (nuevaColumna.getAbajo() == null || nuevaColumna.getAbajo().getFila() > fila) {
	            nuevoNodoFila.setSiguiente(nuevaColumna.getAbajo());
	            nuevaColumna.setAbajo(nuevoNodoFila);
	        } else {
	            NodoFila actual = nuevaColumna.getAbajo();
	            while (actual.getSiguiente() != null && actual.getSiguiente().getFila() < fila) {
	                actual = actual.getSiguiente();
	            }
	            nuevoNodoFila.setSiguiente(actual.getSiguiente());
	            actual.setSiguiente(nuevoNodoFila);
	        }
	    }

	    private NodoFila obtenerNodoFila(int fila) {
	        if (primeraFila == null) {
	            primeraFila = new NodoFila(fila);
	            return primeraFila;
	        }

	        NodoFila actual = primeraFila;
	        while (actual != null && actual.getFila() != fila) {
	            if (actual.getSiguiente() == null || actual.getSiguiente().getFila() > fila) {
	                NodoFila nueva = new NodoFila(fila);
	                nueva.setSiguiente(actual.getSiguiente());
	                actual.setSiguiente(nueva);
	                return nueva;
	            }
	            actual = actual.getSiguiente();
	        }

	        return actual;
	    }

	    private NodoColumna obtenerNodoColumna(int columna) {
	        if (primeraColumna == null) {
	            primeraColumna = new NodoColumna(columna, null);
	            return primeraColumna;
	        }

	        NodoColumna actual = primeraColumna;
	        while (actual != null && actual.getColumna() != columna) {
	            if (actual.getSiguiente() == null || actual.getSiguiente().getColumna() > columna) {
	                NodoColumna nueva = new NodoColumna(columna, null);
	                nueva.setSiguiente(actual.getSiguiente()); 
	                actual.setSiguiente(nueva);
	                return nueva;
	            }
	            actual = actual.getSiguiente();
	        }

	        return actual;
	    }

	    public void imprimirMatriz() {
	        for (int i = 0; i < filas; i++) {
	            NodoFila fila = obtenerNodoFila(i);
	            NodoColumna actual = fila.getDerecha();
	            for (int j = 0; j < columnas; j++) {
	                if (actual != null && actual.getColumna() == j) {
	                    System.out.print(actual.getAutomovil() + " | ");
	                    actual = actual.getSiguiente();
	                } else {
	                    System.out.print("0 ");
	                }
	            }
	            System.out.println();
	        }
	    }

	    public static boolean esAlfanumerico(String cadena) {
	        // Definir el patrón de expresión regular para validar alfanuméricos
	        String patron = "^[a-zA-Z0-9]*$";
	        // Compilar el patrón en un objeto Pattern
	        Pattern pattern = Pattern.compile(patron);
	        // Verificar si la cadena coincide con el patrón
	        return pattern.matcher(cadena).matches();
	    }
	    
	    //Función para validar numeros
	    public static boolean esNumero(String cadena) {
	        return cadena.matches("-?\\d+(\\.\\d+)?");
	    }
	    
	    //Función para valida solo letras
	    public static boolean sonSoloLetras(String cadena) {
	        return cadena.matches("[a-zA-Z]+");
	    }
	    
	  	    
	    /*public static void main(String[] args) {
	        MatrizOrtogonal matriz = new MatrizOrtogonal(3, 3);
	        matriz.insertar(0, 0, new Automovil("ABC123", "Rojo", "Sedán", "2022", "Juan Pérez"));
	        matriz.insertar(1, 1, new Automovil("DEF456", "Azul", "SUV", "2023", "María Gómez"));
	        matriz.insertar(2, 2, new Automovil("GHI789", "Negro", "Camioneta", "2021", "Luis García"));
	        matriz.insertar(0, 1, new Automovil("GHI799", "Gris", "Sedán", "2010", "Fernando Coyoy"));	
	        matriz.imprimirMatriz();
	    }*/
}
