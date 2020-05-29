package principal;

import javax.swing.JPanel;

public abstract class Sort {
	JPanel panel;
	int[] n;

	public Sort(JPanel panel, int[] n) {
		this.panel = panel;
		this.n = n;
	}

}
