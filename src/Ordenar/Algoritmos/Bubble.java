package Ordenar.Algoritmos;

import Ordenar.AdicionalesSorts;
import Ordenar.ISort;
import Principal.DibujarGraficos;
import Principal.MainAplicacion;

public class Bubble extends AdicionalesSorts implements ISort {

	public Bubble(MainAplicacion mainApp, int[] array) {
		this.mainApp = mainApp;
		sort(array);
	}

	// @Override
	public void sort(int[] array) {
		setInicio(System.currentTimeMillis());
		for (int i = 0; i < array.length; i++) {
			for (int j = 0; j < array.length - 1; j++) {
				if (array[j] > array[j + 1]) {
					int temp = array[j];
					array[j] = array[j + 1];
					array[j + 1] = temp;
					cambiosArray++;
				}
				accesoArray += 2;
				mainApp.updateAnimaciones();
			}
			mainApp.textos();
		}
		DibujarGraficos.finSort = true;
	}
}
