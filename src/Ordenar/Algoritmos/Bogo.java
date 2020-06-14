package Ordenar.Algoritmos;

import Ordenar.AdicionalesSorts;
import Ordenar.ISort;
import Principal.MainAplicacion;

public class Bogo extends AdicionalesSorts implements ISort {

	public Bogo(MainAplicacion mainApp, int[] array) {
		this.mainApp = mainApp;
		sort(array);
	}

	@Override
	public void sort(int[] array) {
		setInicio(System.currentTimeMillis());

		while (isSorted(array) == false) {
			shuffle(array);
			mainApp.updateAnimaciones();
		}
	}

	void shuffle(int[] array) {
		for (int i = 0; i < array.length; i++)
			swap(array, i, (int) (Math.random() * i));
	}

	void swap(int[] array, int i, int j) {
		int temp = array[i];
		array[i] = array[j];
		array[j] = temp;
	}

	boolean isSorted(int[] a) {
		for (int i = 1; i < a.length; i++)
			if (a[i] < a[i - 1])
				return false;
		return true;
	}

}
