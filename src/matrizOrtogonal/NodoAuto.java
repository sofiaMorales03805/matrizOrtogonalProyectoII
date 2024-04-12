package matrizOrtogonal;
/**
 * @author JennyMorales 7690-08-6790
 */
public class NodoAuto {
	private Automovil datosAutomovil;
	private NodoAuto arriba;
	private NodoAuto abajo;
	private NodoAuto derecha;
	private NodoAuto izquierda;
	private int fila;
	private int columna;

    public NodoAuto(Automovil datosAutomovil) {
        this.datosAutomovil = datosAutomovil;
        this.arriba = null;
        this.abajo = null;
        this.derecha = null;
        this.izquierda = null;
        this.fila = 0;
        this.columna = 0;
    }
    
    
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


	public Automovil getDatosAutomovil() {
		return datosAutomovil;
	}

	public void setDatosAutomovil(Automovil datosAutomovil) {
		this.datosAutomovil = datosAutomovil;
	}

	public NodoAuto getArriba() {
		return arriba;
	}

	public void setArriba(NodoAuto arriba) {
		this.arriba = arriba;
	}

	public NodoAuto getAbajo() {
		return abajo;
	}

	public void setAbajo(NodoAuto abajo) {
		this.abajo = abajo;
	}

	public NodoAuto getDerecha() {
		return derecha;
	}

	public void setDerecha(NodoAuto derecha) {
		this.derecha = derecha;
	}

	public NodoAuto getIzquierda() {
		return izquierda;
	}

	public void setIzquierda(NodoAuto izquierda) {
		this.izquierda = izquierda;
	}
    
    
}
