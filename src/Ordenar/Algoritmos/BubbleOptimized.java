package Ordenar.Algoritmos;

import Ordenar.AdicionalesSorts;
import Ordenar.ISort;
import Principal.DibujarGraficos;
import Principal.MainAplicacion;

public class BubbleOptimized extends AdicionalesSorts implements ISort {

	public BubbleOptimized(MainAplicacion mainApp, int[] array) {
		this.mainApp = mainApp;
		sort(array);
	}

	// @Override
	public void sort(int[] array) {
		setInicio(System.currentTimeMillis());
		boolean needNextPass = true;
		for (int i = 1; i < array.length && needNextPass; i++) {
			needNextPass = false;
			for (int j = 0; j < array.length - i; j++) {
				if (array[j] > array[j + 1]) {
					int temp = array[j];
					array[j] = array[j + 1];
					array[j + 1] = temp;
					cambiosArray++;
					needNextPass = true;
				}
				accesoArray += 2;
				mainApp.updateAnimaciones();
			}
			mainApp.textos();
		}
		DibujarGraficos.finSort = true;
	}
}
