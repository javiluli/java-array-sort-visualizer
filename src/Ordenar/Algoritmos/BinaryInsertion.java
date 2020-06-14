package Ordenar.Algoritmos;

import java.util.Arrays;

import Ordenar.AdicionalesSorts;
import Ordenar.ISort;
import Principal.DibujarGraficos;
import Principal.MainAplicacion;

public class BinaryInsertion extends AdicionalesSorts implements ISort {

	public BinaryInsertion(MainAplicacion mainApp, int[] array) {
		this.mainApp = mainApp;
		sort(array);
	}

	@Override
	public void sort(int[] array) {
		setInicio(System.currentTimeMillis());
		mainApp.updateAnimaciones();

		for (int i = 1; i < array.length; i++) {
			int x = array[i];
			int j = Math.abs(Arrays.binarySearch(array, 0, i, x) + 1);
			System.arraycopy(array, j, array, j + 1, i - j);
			array[j] = x;
			mainApp.updateAnimaciones();
		}
		DibujarGraficos.finSort = true;
	}
}
