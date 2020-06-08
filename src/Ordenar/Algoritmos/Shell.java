package Ordenar.Algoritmos;

import Ordenar.AdicionalesSorts;
import Ordenar.ISort;
import Principal.DibujarGraficos;
import Principal.MainAplicacion;

public class Shell extends AdicionalesSorts implements ISort {

	public Shell(MainAplicacion m, int[] n) {
		this.m = m;
		sort(n);
	}

	@Override
	public void sort(int[] n) {
		setInicio(System.currentTimeMillis());
		int increment = n.length / 2;
		while (increment > 0) {
			for (int i = increment; i < n.length; i++) {
				int j = i;
				int temp = n[i];
				while (j >= increment && n[j - increment] > temp) {
					n[j] = n[j - increment];
					j = j - increment;
					cambiosArray++;
					m.updateAnimaciones();
				}
				n[j] = temp;
				accesoArray++;
			}
			if (increment == 2) {
				increment = 1;
			} else {
				increment *= (5.0 / 11);
			}
		}
		DibujarGraficos.finSort = true;
	}
}
