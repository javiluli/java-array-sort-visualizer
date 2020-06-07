package Ordenar.Algoritmos;

import Ordenar.AdicionalesSorts;
import Ordenar.ISort;
import Principal.DibujarGraficos;
import Principal.Main;

public class Pigeonhole extends AdicionalesSorts implements ISort {
	public Pigeonhole(Main m, int[] n) {
		this.m = m;
		sort(n);
	}

	@Override
	public void sort(int[] n) {
		setInicio(System.currentTimeMillis());
		int min = n[0], max = n[0];
		for (int i : n) {
			min = Math.min(i, min);
			max = Math.max(i, max);
		}
		final int size = max - min + 1;

		int[] holes = new int[size];

		for (int i : n)
			holes[i - min]++;

		int i = 0;
		for (int count = 0; count < size; count++) {
			while (holes[count]-- > 0) {
				n[i++] = count + min;
				accesoArray++;
				m.updateAnimaciones();
			}
		}
		DibujarGraficos.finSort = true;
	}
}
