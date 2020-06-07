package EstilosGraficos;

public abstract class Transfomaciones extends EstiloGrafico {
	private static final long serialVersionUID = 1L;
	
	// Traslada todos los graficos al centro.
	public int translateX = WIN_WIDTH / 2, translateY = WIN_WIDTH / 2;
}
