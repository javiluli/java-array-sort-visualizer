package Ordenar;

import Principal.DibujarGraficos;
import Principal.MainAplicacion;

public class FinSort extends AdicionalesSorts implements ISort {

	public FinSort(MainAplicacion m, int[] n) {
		this.mainApp = m;
		sort(n);
	}

	@Override
	public void sort(int[] n) {
		for (int i = 0; i < n.length; i++) {
			DibujarGraficos.mismo = i + 1;
			DibujarGraficos.anterioresMismo = i;
			mainApp.updateAnimacionesSoloDelayFijo();
		}
		DibujarGraficos.finSort = false;
	}
}
