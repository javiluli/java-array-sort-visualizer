package Ordenar.Algoritmos;

import Ordenar.AdicionalesSorts;
import Ordenar.ISort;
import Principal.DibujarGraficos;
import Principal.MainAplicacion;

public class OddEven extends AdicionalesSorts implements ISort {
	public OddEven(MainAplicacion mainApp, int[] array) {
		this.mainApp = mainApp;
		sort(array);
	}

	@Override
	public void sort( int[] array) {
		boolean isSorted = false;
		setInicio(System.currentTimeMillis());
		while (!isSorted) {
			isSorted = true;
			int temp = 0;
			for (int i = 1; i <= array.length - 2; i = i + 2) {
				accesoArray++;
				if (array[i] > array[i + 1]) {
					temp = array[i];
					array[i] = array[i + 1];
					array[i + 1] = temp;
					isSorted = false;
					cambiosArray++;
				}
				mainApp.updateAnimaciones();
			}
			for (int i = 0; i <= array.length - 2; i = i + 2) {
				accesoArray++;
				if (array[i] > array[i + 1]) {
					temp = array[i];
					array[i] = array[i + 1];
					array[i + 1] = temp;
					isSorted = false;
					cambiosArray++;
				}
				mainApp.updateAnimaciones();
			}
			mainApp.textos();
		}
		DibujarGraficos.finSort = true;
	}
}
