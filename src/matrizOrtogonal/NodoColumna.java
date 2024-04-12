package matrizOrtogonal;

public class NodoColumna {

	private int columna;
    private Automovil automovil;
    private NodoColumna siguiente;
    private NodoFila abajo;

    public NodoColumna(int columna, Automovil automovil) {
        this.columna = columna;
        this.automovil = automovil;
        this.siguiente = null;
        this.abajo = null;
    }

	public int getColumna() {
		return columna;
	}

	public void setColumna(int columna) {
		this.columna = columna;
	}

    public Automovil getAutomovil() {
        return automovil;
    }

    public void setAutomovil(Automovil automovil) {
        this.automovil = automovil;
    }
    
	public NodoColumna getSiguiente() {
		return siguiente;
	}

	public void setSiguiente(NodoColumna siguiente) {
		this.siguiente = siguiente;
	}

	public NodoFila getAbajo() {
		return abajo;
	}

	public void setAbajo(NodoFila abajo) {
		this.abajo = abajo;
	}
 
    
}
