package Ordenar.Algoritmos;

import Ordenar.AdicionalesSorts;
import Ordenar.ISort;
import Principal.DibujarGraficos;
import Principal.MainAplicacion;

public class Quick extends AdicionalesSorts implements ISort {

	public Quick(MainAplicacion mainApp, int[] array) {
		this.mainApp = mainApp;
		setInicio(System.currentTimeMillis());
		sort(array);
	}

	@Override
	public void sort(int[] array) {
		quickSort(array, 0, array.length - 1);
		DibujarGraficos.finSort = true;
	}

	public void quickSort(int array[], int izq, int der) {
		int pivote = array[izq];
		int i = izq;
		int j = der;
		int aux;
		while (i < j) {
			while (array[i] <= pivote && i < j)
				i++;
			while (array[j] > pivote)
				j--;
			if (i < j) {
				aux = array[i];
				array[i] = array[j];
				array[j] = aux;
				cambiosArray++;
			}
			accesoArray++;
			mainApp.updateAnimaciones();
		}

		array[izq] = array[j];
		array[j] = pivote;
		if (izq < j - 1)
			quickSort(array, izq, j - 1);
		if (j + 1 < der)
			quickSort(array, j + 1, der);
		mainApp.updateAnimaciones();
	}
}
