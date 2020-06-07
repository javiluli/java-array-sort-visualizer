package Ordenar.Algoritmos;

import Ordenar.AdicionalesSorts;
import Ordenar.ISort;
import Principal.DibujarGraficos;
import Principal.Main;

public class Cocktail extends AdicionalesSorts implements ISort {

	public Cocktail(Main m, int[] n) {
		this.m = m;
		sort(n);
	}

	@Override
	public void sort(int[] n) {
		boolean cambiar = true;
		int inicio = 0;
		int fin = n.length;

		setInicio(System.currentTimeMillis());
		while (cambiar == true) {
			cambiar = false;
			for (int i = inicio; i < fin - 1; ++i) {
				accesoArray++;
				if (n[i] > n[i + 1]) {
					int temp = n[i];
					n[i] = n[i + 1];
					n[i + 1] = temp;
					cambiar = true;
					cambiosArray++;
				}
				m.updateAnimaciones();
			}

			if (cambiar == false)
				break;

			cambiar = false;
			fin = fin - 1;

			for (int i = fin - 1; i >= inicio; i--) {
				accesoArray++;
				if (n[i] > n[i + 1]) {
					int temp = n[i];
					n[i] = n[i + 1];
					n[i + 1] = temp;
					cambiar = true;
					cambiosArray++;
				}
				m.updateAnimaciones();
			}
			inicio = inicio + 1;
		}
		DibujarGraficos.finSort = true;
	}
}
