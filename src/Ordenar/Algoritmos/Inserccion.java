package Ordenar.Algoritmos;

import Ordenar.AdicionalesSorts;
import Ordenar.ISort;
import Principal.DibujarGraficos;
import Principal.Main;

public class Inserccion extends AdicionalesSorts implements ISort {

	public Inserccion(Main m,int[] n) {
		this.m = m;
		sort(n);
	}

	@Override
	public void sort(int[] n) {
		setInicio(System.currentTimeMillis());
		for (int i = 0; i < n.length; i++) {
			int pos = i;
			int aux = n[i];

			while ((pos > 0) && (n[pos - 1] > aux)) {
				n[pos] = n[pos - 1];
				pos--;
				cambiosArray++;
				accesoArray += 2;
				n[pos] = aux;
				m.updateAnimaciones();
			}
		}
		DibujarGraficos.finSort = true;
	}
}