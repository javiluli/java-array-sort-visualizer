package Ordenar.Algoritmos;

import Ordenar.AdicionalesSorts;
import Ordenar.ISort;
import Principal.DibujarGraficos;
import Principal.MainAplicacion;

public class Inserccion extends AdicionalesSorts implements ISort {

	public Inserccion(MainAplicacion mainApp,int[] array) {
		this.mainApp = mainApp;
		sort(array);
	}

	@Override
	public void sort(int[] array) {
		setInicio(System.currentTimeMillis());
		for (int i = 0; i < array.length; i++) {
			int pos = i;
			int aux = array[i];

			while ((pos > 0) && (array[pos - 1] > aux)) {
				array[pos] = array[pos - 1];
				pos--;
				cambiosArray++;
				accesoArray += 2;
				array[pos] = aux;
				mainApp.updateAnimaciones();
			}
		}
		DibujarGraficos.finSort = true;
	}
}