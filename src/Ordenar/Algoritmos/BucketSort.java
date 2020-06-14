package Ordenar.Algoritmos;

//Bucket sort in Java

import java.util.ArrayList;
import java.util.Collections;

import Ordenar.AdicionalesSorts;
import Ordenar.ISort;
import Principal.DibujarGraficos;
import Principal.MainAplicacion;

public class BucketSort extends AdicionalesSorts implements ISort {

	public BucketSort(MainAplicacion mainApp, int[] array) {
		this.mainApp = mainApp;
		sort(array);
	}

	@Override
	public void sort(int[] array) {
		int len = array.length;
		setInicio(System.currentTimeMillis());
		if (len <= 0)
			return;

		@SuppressWarnings("unchecked")
		ArrayList<Integer>[] bucket = new ArrayList[len];

		for (int i = 0; i < len; i++)
			bucket[i] = new ArrayList<Integer>();

		for (int i = 0; i < len; i++) {
			int bucketIndex = array[i];
			bucket[bucketIndex].add(array[i]);
		}

		for (int i = 0; i < len; i++) {
			Collections.sort((bucket[i]));
		}

		int index = 0;
		for (int i = 0; i < len; i++) {
			for (int j = 0, size = bucket[i].size(); j < size; j++) {
				array[index++] = bucket[i].get(j);
			}
			mainApp.updateAnimaciones();
		}
		DibujarGraficos.finSort = true;
	}
}