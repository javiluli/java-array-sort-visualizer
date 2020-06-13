package Ordenar.Algoritmos;

import Ordenar.AdicionalesSorts;
import Ordenar.ISort;
import Principal.DibujarGraficos;
import Principal.MainAplicacion;

public class Cocktail extends AdicionalesSorts implements ISort {

	public Cocktail(MainAplicacion mainApp, int[] array) {
		this.mainApp = mainApp;
		sort(array);
	}

	@Override
	public void sort(int[] array) {
		boolean cambiar = true;
		int inicio = 0;
		int fin = array.length;

		setInicio(System.currentTimeMillis());
		while (cambiar == true) {
			cambiar = false;
			for (int i = inicio; i < fin - 1; ++i) {
				accesoArray++;
				if (array[i] > array[i + 1]) {
					int temp = array[i];
					array[i] = array[i + 1];
					array[i + 1] = temp;
					cambiar = true;
					cambiosArray++;
				}
				mainApp.updateAnimaciones();
			}

			if (cambiar == false)
				break;

			cambiar = false;
			fin = fin - 1;

			for (int i = fin - 1; i >= inicio; i--) {
				accesoArray++;
				if (array[i] > array[i + 1]) {
					int temp = array[i];
					array[i] = array[i + 1];
					array[i + 1] = temp;
					cambiar = true;
					cambiosArray++;
				}
				mainApp.updateAnimaciones();
			}
			inicio = inicio + 1;
		}
		DibujarGraficos.finSort = true;
	}
}
