package Ordenar.Algoritmos;

import Ordenar.AdicionalesSorts;
import Ordenar.ISort;
import Principal.DibujarGraficos;
import Principal.MainAplicacion;

public class Selection extends AdicionalesSorts implements ISort {

	public Selection(MainAplicacion mainApp, int[] array) {
		this.mainApp = mainApp;
		sort(array);
	}

	@Override
	public void sort( int[] array) {
		mainApp = new MainAplicacion();
		setInicio(System.currentTimeMillis());
		for (int i = 0; i < array.length; i++) {
			int min = i;

			for (int j = i + 1; j < array.length; j++) {
				if (array[j] < array[min]) {
					min = j;
					cambiosArray++;
				}
				accesoArray += 2;
			}
			int aux = array[i];
			array[i] = array[min];
			array[min] = aux;

			mainApp.updateAnimaciones();
		}
		DibujarGraficos.finSort = true;
	}
}
