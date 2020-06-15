package Ordenar.Algoritmos;

import Ordenar.AdicionalesSorts;
import Ordenar.ISort;
import Principal.DibujarGraficos;
import Principal.MainAplicacion;

public class DoubleSelection extends AdicionalesSorts implements ISort {

	public DoubleSelection(MainAplicacion mainApp, int[] array) {
		this.mainApp = mainApp;
		sort(array);
	}

	// @Override
	public void sort(int[] array) {
		setInicio(System.currentTimeMillis());
		int left = 0;
		int right = array.length - 1;
		int smallest = 0;
		int biggest = 0;
		
		while (left <= right) {
			for (int i = left; i <= right; i++) {
				if (array[i] > array[biggest])
					biggest = i;
				if (array[i] < array[smallest])
					smallest = i;
				cambiosArray += 2;
			}

			if (biggest == left)
				biggest = smallest;

			int temp = array[left];
			array[left] = array[smallest];
			array[smallest] = temp;
			mainApp.updateAnimaciones();

			temp = array[right];
			array[right] = array[biggest];
			array[biggest] = temp;
			mainApp.updateAnimaciones();

			left++;
			right--;
			smallest = left;
			biggest = right;
		}
		mainApp.textos();
		DibujarGraficos.finSort = true;
	}
}
