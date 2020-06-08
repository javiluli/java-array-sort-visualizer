package Ordenar;

import Principal.DibujarGraficos;
import Principal.Main;

public class FinSort extends AdicionalesSorts implements ISort {

	public FinSort(Main m, int[] n) {
		this.m = m;
		sort(n);
	}

	@Override
	public void sort(int[] n) {
		for (int i = 0; i < n.length; i++) {
			DibujarGraficos.mismo = i + 1;
			DibujarGraficos.anterioresMismo = i;
			m.updateAnimacionesSoloDelaFijo();
		}
		DibujarGraficos.finSort = false;
	}
}
