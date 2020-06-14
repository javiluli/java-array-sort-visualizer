package Ordenar.Algoritmos;

import Ordenar.AdicionalesSorts;
import Ordenar.ISort;
import Principal.DibujarGraficos;
import Principal.MainAplicacion;

public class Gravity extends AdicionalesSorts implements ISort {

	public Gravity(MainAplicacion mainApp, int[] array) {
		this.mainApp = mainApp;
		sort(array);
	}

	// @Override
	public void sort(int[] array) {
		setInicio(System.currentTimeMillis());

		int max = max(array);
		int[][] abacus = new int[array.length][max];
		for (int i = 0; i < array.length; i++) {
			for (int j = 0; j < array[i]; j++)
				abacus[i][abacus[0].length - j - 1] = 1;
		}

		// apply gravity
		for (int i = 0; i < abacus[0].length; i++) {
			for (int j = 0; j < abacus.length; j++) {
				if (abacus[j][i] == 1) {
					int droppos = j;
					while (droppos + 1 < abacus.length && abacus[droppos][i] == 1)
						droppos++;
					if (abacus[droppos][i] == 0) {
						abacus[j][i] = 0;
						abacus[droppos][i] = 1;
						accesoArray += 2;
					}
				}
			}

			int count = 0;
			for (int x = 0; x < abacus.length; x++) {
				count = 0;
				for (int y = 0; y < abacus[0].length; y++)
					count += abacus[x][y];
				array[x] = count;
			}
			mainApp.updateAnimaciones();
		}
		DibujarGraficos.finSort = true;
	}

	public int max(int[] array) {
		int a = 0;
		for (int i = 0; i < array.length; i++) {
			if (array[i] > a)
				a = array[i];
		}
		return a;
	}
}
