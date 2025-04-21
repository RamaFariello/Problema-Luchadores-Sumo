package luchadores;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class testSumo {

	Luchador[] luchadores;

	@BeforeEach
	void setUp() {
		luchadores = new Luchador[] { new Luchador(300, 1500), new Luchador(320, 1500), new Luchador(299, 1580),
				new Luchador(330, 1690), new Luchador(330, 1540), new Luchador(339, 1500), new Luchador(298, 1700),
				new Luchador(344, 1570), new Luchador(276, 1678), new Luchador(289, 1499) };
	}

	@Test
	void testDominaLuchador1() {
		Luchador ganador = new Luchador(0,0);
		Luchador luchador1 = this.luchadores[0];
		int gano = 0;
		int cantDeLuchadores = luchadores.length;

		for (int i = 1; i < cantDeLuchadores; i++) {

			ganador = luchador1.versus(this.luchadores[i]);

		}
		if (ganador.equals(luchador1)) {

			gano++;

		}

		assertEquals(1, gano);
	}

	@Test
	void testMasivo() {
		int ganados [] = new int[luchadores.length];
		
		int cantLuchadores = luchadores.length; 
		
		for (int i = 0; i < cantLuchadores; i++) {

			Luchador luchadorActual = this.luchadores[i];

			for (int j = i; j < cantLuchadores; j++) {

				Luchador ganador = luchadorActual.versus(this.luchadores[j]);

				if (ganador.equals(luchadorActual)) {

					ganados[i]++;

				} else if (ganador.equals(this.luchadores[j])) {

					ganados[j]++;

				}
			}
		}

		int[] resultadoEsperado = new int[] { 1, 2, 1, 6, 3, 3, 2, 5, 0, 0 };
		for (int k = 0; k < resultadoEsperado.length; k++) {

			assertEquals(resultadoEsperado[k], ganados[k], "Falla en la posición " + k);

		}

	}

}
