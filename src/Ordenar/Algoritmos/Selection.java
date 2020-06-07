package Ordenar.Algoritmos;

import Ordenar.AdicionalesSorts;
import Ordenar.ISort;
import Principal.DibujarGraficos;
import Principal.Main;

public class Selection extends AdicionalesSorts implements ISort {

	public Selection(Main m, int[] n) {
		this.m = m;
		sort(n);
	}

	@Override
	public void sort( int[] n) {
		m = new Main();
		setInicio(System.currentTimeMillis());
		for (int i = 0; i < n.length; i++) {
			int min = i;

			for (int j = i + 1; j < n.length; j++) {
				if (n[j] < n[min]) {
					min = j;
					cambiosArray++;
				}
				accesoArray += 2;
			}
			int aux = n[i];
			n[i] = n[min];
			n[min] = aux;

			m.updateAnimaciones();
		}
		DibujarGraficos.finSort = true;
	}
}
