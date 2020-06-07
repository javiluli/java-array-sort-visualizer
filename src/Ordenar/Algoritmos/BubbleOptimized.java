package Ordenar.Algoritmos;

import Ordenar.AdicionalesSorts;
import Ordenar.ISort;
import Principal.DibujarGraficos;
import Principal.Main;

public class BubbleOptimized extends AdicionalesSorts implements ISort {

	public BubbleOptimized(Main m,int[] n) {
		this.m = m;
		sort(n);
	}

	// @Override
	public void sort(int[] n) {
		setInicio(System.currentTimeMillis());
		boolean needNextPass = true;
		for (int i = 1; i < n.length && needNextPass; i++) {
			needNextPass = false;
			for (int j = 0; j < n.length - i; j++) {
				if (n[j] > n[j + 1]) {
					int temp = n[j];
					n[j] = n[j + 1];
					n[j + 1] = temp;
					cambiosArray++;
					needNextPass = true;
				}
				accesoArray += 2;
				m.updateAnimaciones();
			}
			m.textos();
		}
		DibujarGraficos.finSort = true;
	}
}
