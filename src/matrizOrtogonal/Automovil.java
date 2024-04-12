package matrizOrtogonal;

/**
 * @author JennyMorales 7690-08-6790
 */
public class Automovil {
	 String placa;
	 String color;
	 String linea;
	 String modelo;
	 String propietario;

	 
	    public Automovil(String placa, String color, String linea,String modelo, String propietario ) {
	        this.placa = placa;
	        this.color = color;
	        this.linea = linea;
	        this.modelo = modelo;
	        this.propietario = propietario;
	    }
	    


		public String getPlaca() {
			return placa;
		}

		public void setPlaca(String placa) {
			this.placa = placa;
		}

		public String getColor() {
			return color;
		}

		public void setColor(String color) {
			this.color = color;
		}

		public String getLinea() {
			return linea;
		}

		public void setLinea(String linea) {
			this.linea = linea;
		}

		public String getModelo() {
			return modelo;
		}

		public void setModelo(String modelo) {
			this.modelo = modelo;
		}

		public String getPropietario() {
			return propietario;
		}

		public void setPropietario(String propietario) {
			this.propietario = propietario;
		}
		
		 @Override
		    public String toString() {
		        return "Placa: " + placa + ", Color: " + color + ", Línea: " + linea + ", Modelo: " + modelo + ", Propietario: " + propietario;
		    }
	    
	    
}
