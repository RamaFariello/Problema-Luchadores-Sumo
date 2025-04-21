package luchadores;

import java.util.Objects;

public class Luchador {
	private double peso;
	private double altura;

	public Luchador(double peso, double altura) {
		this.peso = peso;
		this.altura = altura;
	}

	public Luchador versus(Luchador otro) {

		if ((this.peso > otro.peso && this.altura > otro.altura)
				|| (this.peso == otro.peso && this.altura > otro.altura)
				|| (this.peso > otro.peso && this.altura == otro.altura)) {
			
			return this; //ganador este luchador
			
		} else if ((this.peso == otro.peso && this.altura == otro.altura)
				|| (this.peso > otro.peso && this.altura < otro.altura)
				|| (this.peso < otro.peso && this.altura > otro.altura)) {
			
			return new Luchador(-1,-1); //no hay ganador
		}
		
		return otro; //ganador el otro luchador
	}

	@Override
	public int hashCode() {
		return Objects.hash(altura, peso);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Luchador other = (Luchador) obj;
		return Double.doubleToLongBits(altura) == Double.doubleToLongBits(other.altura)
				&& Double.doubleToLongBits(peso) == Double.doubleToLongBits(other.peso);
	}
	
	

}
