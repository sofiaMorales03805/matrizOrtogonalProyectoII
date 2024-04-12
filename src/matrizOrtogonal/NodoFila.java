package matrizOrtogonal;

public class NodoFila {
	private int fila;
    private NodoFila siguiente;
    private NodoColumna derecha;

    public NodoFila(int fila) {
        this.fila = fila;
        this.siguiente = null;
        this.derecha = null;
    }

	public int getFila() {
		return fila;
	}

	public void setFila(int fila) {
		this.fila = fila;
	}

	public NodoFila getSiguiente() {
		return siguiente;
	}

	public void setSiguiente(NodoFila siguiente) {
		this.siguiente = siguiente;
	}

	public NodoColumna getDerecha() {
		return derecha;
	}

	public void setDerecha(NodoColumna derecha) {
		this.derecha = derecha;
	}
    
    
}
