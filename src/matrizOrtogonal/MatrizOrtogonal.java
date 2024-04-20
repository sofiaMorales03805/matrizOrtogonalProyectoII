package matrizOrtogonal;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.util.regex.Pattern;

import javax.swing.SwingUtilities;

public class MatrizOrtogonal {
	int fila;
	int columna;
	private int tamanioMatriz;
	NodoFila primeraFila;
	NodoColumna primeraColumna;

	public int getFila() {
		return fila;
	}

	public void setFila(int fila) {
		this.fila = fila;
	}

	public int getColumna() {
		return columna;
	}

	public void setColumna(int columna) {
		this.columna = columna;
	}

	public NodoFila getPrimeraFila() {
		return primeraFila;
	}

	public void setPrimeraFila(NodoFila primeraFila) {
		this.primeraFila = primeraFila;
	}

	public NodoColumna getPrimeraColumna() {
		return primeraColumna;
	}

	public void setPrimeraColumna(NodoColumna primeraColumna) {
		this.primeraColumna = primeraColumna;
	}

	public int getTamanioMatriz() {
		return tamanioMatriz;
	}

	public void setTamanioMatriz(int tamanioMatriz) {
		this.tamanioMatriz = tamanioMatriz;
	}

	public MatrizOrtogonal(int fila, int columna, int tamanioMatriz) {
		this.primeraFila = null;
		this.primeraColumna = null;
		this.fila = fila;
		this.columna = columna;
		this.tamanioMatriz = tamanioMatriz;

	}

	public MatrizOrtogonal() {
		// TODO Auto-generated constructor stub
	}

	private Automovil[][] matriz;

	public void insertar(int fila, int columna, Automovil automovil, int tamanioMatriz) {
		System.out.println("Tamanio de matriz: " + tamanioMatriz);
		if (fila >= tamanioMatriz || columna >= tamanioMatriz || fila < 0 || columna < 0) {
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
		for (int i = 0; i < tamanioMatriz; i++) {
			NodoFila fila = obtenerNodoFila(i);
			NodoColumna actual = fila.getDerecha();
			for (int j = 0; j < tamanioMatriz; j++) {
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
	

	
	// Metodo para validar la placa que es un alfanumerico con 8 digitos maximo
	public static boolean esAlfanumerico(String cadena) {
		// Definir el patrón de expresión regular para validar alfanuméricos
		String patron = "^[a-zA-Z0-9]{1,8}$";
		// Compilar el patrón en un objeto Pattern
		Pattern pattern = Pattern.compile(patron);
		// Verificar si la cadena coincide con el patrón
		return pattern.matcher(cadena).matches();
	}

	// Metodo para validar numeros
	public static boolean esNumero(String cadena) {
		return cadena.matches("-?\\d+(\\.\\d+)?");
	}

	// Método para valida solo letras
	public static boolean sonSoloLetras(String cadena) {
		return cadena.matches("[a-zA-Z]+");
	}
	
	

	/**
	 * Método Buscar
	 * 
	 * @param atributo
	 * @param valor
	 * @return
	 */
	// Método para buscar un automóvil por un atributo específico en la matriz
	public Automovil buscarAutomovilAtributo(String atributo1, String valor1, String atributo2, String valor2) {
	    for (int i = 0; i < tamanioMatriz; i++) {
	        NodoFila nodoFila = obtenerNodoFila(i);
	        NodoColumna actual = nodoFila.getDerecha();
	        for (int j = 0; j < tamanioMatriz; j++) {
	            if (actual != null && actual.getColumna() == j) {
	                Automovil automovil = actual.getAutomovil();
	                switch (atributo1) {
	                    case "Placa":
	                        if (atributo2.equals("Color") && automovil.getPlaca().equals(valor1) && automovil.getColor().equals(valor2)) {
	                            return automovil;
	                        }
	                        if (atributo2.equals("Linea") && automovil.getPlaca().equals(valor1) && automovil.getLinea().equals(valor2)) {
	                            return automovil;
	                        }
	                        if (atributo2.equals("Modelo") && automovil.getPlaca().equals(valor1) && automovil.getModelo().equals(valor2)) {
	                            return automovil;
	                        }
	                        if (atributo2.equals("Propietario") && automovil.getPlaca().equals(valor1) && automovil.getPropietario().equals(valor2)) {
	                            return automovil;
	                        }
	                        break;
	                    case "Color":
	                    	  if (atributo2.equals("Placa") && automovil.getColor().equals(valor1) && automovil.getPlaca().equals(valor2)) {
	                              return automovil;
	                          }
	                          if (atributo2.equals("Linea") && automovil.getColor().equals(valor1) && automovil.getLinea().equals(valor2)) {
	                              return automovil;
	                          }
	                          if (atributo2.equals("Modelo") && automovil.getColor().equals(valor1) && automovil.getModelo().equals(valor2)) {
	                              return automovil;
	                          }
	                          if (atributo2.equals("Propietario") && automovil.getColor().equals(valor1) && automovil.getPropietario().equals(valor2)) {
	                              return automovil;
	                          }
	                          break;
	                    case "Linea":
	                    	 if (atributo2.equals("Placa") && automovil.getLinea().equals(valor1) && automovil.getPlaca().equals(valor2)) {
	                             return automovil;
	                         }
	                         if (atributo2.equals("Color") && automovil.getLinea().equals(valor1) && automovil.getColor().equals(valor2)) {
	                             return automovil;
	                         }
	                         if (atributo2.equals("Modelo") && automovil.getLinea().equals(valor1) && automovil.getModelo().equals(valor2)) {
	                             return automovil;
	                         }
	                         if (atributo2.equals("Propietario") && automovil.getLinea().equals(valor1) && automovil.getPropietario().equals(valor2)) {
	                             return automovil;
	                         }
	                        break;
	                    case "Modelo":
	                    	if (atributo2.equals("Placa") && automovil.getModelo().equals(valor1) && automovil.getPlaca().equals(valor2)) {
	                            return automovil;
	                        }
	                        if (atributo2.equals("Color") && automovil.getModelo().equals(valor1) && automovil.getColor().equals(valor2)) {
	                            return automovil;
	                        }
	                        if (atributo2.equals("Linea") && automovil.getModelo().equals(valor1) && automovil.getLinea().equals(valor2)) {
	                            return automovil;
	                        }
	                        if (atributo2.equals("Propietario") && automovil.getModelo().equals(valor1) && automovil.getPropietario().equals(valor2)) {
	                            return automovil;
	                        }
	                        break;
	                    case "Propietario":
	                    	if (atributo2.equals("Placa") && automovil.getModelo().equals(valor1) && automovil.getPlaca().equals(valor2)) {
	                            return automovil;
	                        }
	                        if (atributo2.equals("Color") && automovil.getModelo().equals(valor1) && automovil.getColor().equals(valor2)) {
	                            return automovil;
	                        }
	                        if (atributo2.equals("Linea") && automovil.getModelo().equals(valor1) && automovil.getLinea().equals(valor2)) {
	                            return automovil;
	                        }
	                        if (atributo2.equals("Modelo") && automovil.getLinea().equals(valor1) && automovil.getModelo().equals(valor2)) {
	                             return automovil;
	                         }
	                        break;
	                    default:
	                        System.out.println("Registro no válido");
	                        return null;
	                }
	                actual = actual.getSiguiente();
	            }
	        }
	    }
	    System.out.println("No se encontró ningún automóvil con esos atributos y valores");
	    return null;
	}

}
