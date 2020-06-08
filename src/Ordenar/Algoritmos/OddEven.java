package Ordenar.Algoritmos;

import Ordenar.AdicionalesSorts;
import Ordenar.ISort;
import Principal.DibujarGraficos;
import Principal.MainAplicacion;

public class OddEven extends AdicionalesSorts implements ISort {
	public OddEven(MainAplicacion m, int[] n) {
		this.m = m;
		sort(n);
	}

	@Override
	public void sort( int[] n) {
		boolean isSorted = false;
		setInicio(System.currentTimeMillis());
		while (!isSorted) {
			isSorted = true;
			int temp = 0;
			for (int i = 1; i <= n.length - 2; i = i + 2) {
				accesoArray++;
				if (n[i] > n[i + 1]) {
					temp = n[i];
					n[i] = n[i + 1];
					n[i + 1] = temp;
					isSorted = false;
					cambiosArray++;
				}
				m.updateAnimaciones();
			}
			for (int i = 0; i <= n.length - 2; i = i + 2) {
				accesoArray++;
				if (n[i] > n[i + 1]) {
					temp = n[i];
					n[i] = n[i + 1];
					n[i + 1] = temp;
					isSorted = false;
					cambiosArray++;
				}
				m.updateAnimaciones();
			}
			m.textos();
		}
		DibujarGraficos.finSort = true;
	}
}
