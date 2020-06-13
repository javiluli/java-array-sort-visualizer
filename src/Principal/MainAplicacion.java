package Principal;

import java.awt.Color;
import java.awt.Font;
import java.awt.Panel;
import java.awt.SystemColor;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Hashtable;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.JToggleButton;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import Adicionales.Delay;
import Adicionales.Memoria;
import Adicionales.Social;
import Ordenar.AdicionalesSorts;
import Ordenar.FinSort;
import Ordenar.Algoritmos.*;

/**
 * @author Javier Delgado Rodriguez
 */
public class MainAplicacion extends AdicionalesSorts {
	// NOMBRES DE LOS ALGORITMOS DE ORDENACION
	final String[] nombreAlgoritmos = { 
			"Bitonic", 
			"Bubble", 
			"Bubble Optimized", 
			"Cocktail", 
			"Cycle", 
			"Gnome", 
			"Heap",
			"Insertion", 
			"Iterative Quick", 
			"Merge", 
			"Odd Even", 
			"Pancake", 
			"Pigeonhole", 
			"Quick", 
			"Radix",
			"Recursive Bubble", 
			"Recursive Insertion", 
			"Recursive Selection", 
			"Selection", 
			"Shell", 
			"Stooge", 
			"Tim" };
	// DISEÑO GRAFICO DE LAS ANIMACIONES
	final static String[] nombreEstilosGraficos = { 
			"Barras clasicas", 
			"Piramide horizontal", 
			"Piramide vertical",
			"Pixel", 
			"Circulo con barras", 
			"Circunferencia", 
			"Espiral con barras" };

	// JFRAME PRINCIPAL
	private JFrame frame = new JFrame();
	
	// JPANEL
	JPanel panelMenu = new JPanel();
	JPanel panelOpcionesMenu = new JPanel();
	static JPanel panelBarras = new JPanel();
	
	// PANEL
	Panel panelVisorMemoria = new Panel();
	
	// COMBOBOX
	JComboBox<String> comboBoxTipoSort = new JComboBox<String>(nombreAlgoritmos);
	static JComboBox<Object> comboBoxTiposGraficos = new JComboBox<Object>(nombreEstilosGraficos);
	
	// JLABEL
	JLabel lblTitleAlgoritmo = new JLabel("Seleccionar algoritmo de ordenacion");
	JLabel lblTitle = new JLabel("Panel de control");
	JLabel lblNumeroBarras = new JLabel("Numero de elementos");
	JLabel lblRetardo = new JLabel("Retardo: 1 ms");
	JLabel lblTituloGraficos = new JLabel("Dise\u00F1o grafico");
	static JLabel lblTiempo = new JLabel("Tiempo: 0 m 0 s 0 ms");
	static JLabel lblMemoriaUsada = new JLabel("Memoria usada: 0 MB");
	static JLabel lblMemoriaMax = new JLabel("Memoria maxima: 0 MB");
	static JLabel lblMemoriaLibre = new JLabel("Memoria libre: 0 MB");
	static JLabel lblMemoriaTotal = new JLabel("Memoria total: 0 MB");
	static JLabel lblCambios = new JLabel("Cambios en el Array: 0");
	static JLabel lblAccesos = new JLabel("Accesos al Array: 0");
	
	// JBUTTON
	JButton btnOrdenar = new JButton("Ordenar");
	JButton btnDesordenar = new JButton("Desordenar");
	JButton btnSaltarSort = new JButton("Saltar Sort");
	JButton btnInformacion = new JButton("Informacion");
	JButton btnGithub = new JButton();
	JButton btnCodepen = new JButton();
	
	// JTOGGLE BUTTON
	static JToggleButton tglbtnMulticolor = new JToggleButton("Ver multicolor");
	
	// JSLIDER
	JSlider sliderRetardo = new JSlider();
	static JSlider sliderTamBarras = new JSlider();
	
	// Tamaño de la ventana.
	static final int WIN_WIDTH = 1330;
	static final int WIN_HEIGHT = 1053;
	
	// Variables antes y despues de la ejecucion de una ordenacion.
	private int seleccionAlgoritmo = -1;
	private boolean accederOrdenacion = true;

	/**
	 * Main para el inicio de la aplicacion.
	 */
	public static void main(String[] args) {
		try {
			MainAplicacion window = new MainAplicacion();
			window.main();
		} catch (Exception e) {
		}
	}

	// ---------------------------------------------------------------------------------------------
	// Objetos de mis Clases
	DibujarGraficos barras;
	SliderPersonalizado sliderPersonal = new SliderPersonalizado();

	public MainAplicacion() {
	}

	Memoria memoria = new Memoria();

	MainAplicacion(Memoria memoria) {
		this.memoria = memoria;
	}

	AdicionalesSorts sorts = new AdicionalesSorts();

	MainAplicacion(AdicionalesSorts sorts) {
		this.sorts = sorts;
	}
	// ---------------------------------------------------------------------------------------------

	public void main() {
		initialize();
		panelBarras.setLayout(null);
		barras = new DibujarGraficos();
		barras.setBounds(0, 0, DibujarGraficos.WIN_WIDTH, DibujarGraficos.WIN_HEIGHT);
		panelBarras.add(barras);

		panelBarras.setVisible(true);
		frame.setResizable(false);
		frame.setTitle("Visualizador de ordenacion de matrices");
		frame.setVisible(true);
		menuSorting();
	}
	// ---------------------------------------------------------------------------------------------

	private void initialize() {
		final Color BLACK_SECUNDARIO = new Color(15, 15, 15);
		// Frame principal.
		frame.setBounds(100, 100, WIN_WIDTH, WIN_HEIGHT);
		frame.setIconImage(Toolkit.getDefaultToolkit().getImage("data\\media\\img\\icon.jpg"));
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.setLayout(null);

		// Panel donde se dibujan las barras.
		panelBarras.setBackground(SystemColor.desktop);
		panelBarras.setBounds(300, 0, DibujarGraficos.WIN_WIDTH, DibujarGraficos.WIN_HEIGHT);
		frame.add(panelBarras);

		// Panel para el menu de occiones.
		panelMenu.setBackground(SystemColor.activeCaptionText);
		panelMenu.setBounds(0, 0, 300, 1024);
		panelMenu.setLayout(null);
		frame.add(panelMenu);

		// Panel hijo para las ocopnes.
		panelOpcionesMenu.setBackground(BLACK_SECUNDARIO);
		panelOpcionesMenu.setBorder(new LineBorder(SystemColor.textInactiveText));
		panelOpcionesMenu.setBounds(10, 46, 280, 967);
		panelOpcionesMenu.setLayout(null);
		panelMenu.add(panelOpcionesMenu);

		// Titulo para seleccion del algoritmo de ordenacion.
		lblTitleAlgoritmo.setBounds(10, 11, 260, 25);
		lblTitleAlgoritmo.setFont(new Font("Arial", Font.BOLD, 13));
		lblTitleAlgoritmo.setForeground(Color.WHITE);
		panelOpcionesMenu.add(lblTitleAlgoritmo);

		// Menu desplegable para la seleccion de algoritmo.
		comboBoxTipoSort.setFont(new Font("Arial", Font.BOLD, 20));
		comboBoxTipoSort.setForeground(Color.WHITE);
		comboBoxTipoSort.setBackground(Color.DARK_GRAY);
		comboBoxTipoSort.setBounds(10, 47, 260, 30);
		panelOpcionesMenu.add(comboBoxTipoSort);

		// Boton para iniciar la ordenacion.
		btnOrdenar.setFont(new Font("Arial", Font.BOLD, 13));
		btnOrdenar.setBackground(Color.BLACK);
		btnOrdenar.setForeground(Color.WHITE);
		btnOrdenar.setBounds(160, 88, 110, 30);
		btnOrdenar.addActionListener(new ActionListener() {
			/*
			 * Este obtiene la posicion en la lista de algorimos para su seleccion, y una
			 * vez iniciada la orneacion evita que se pueda desordenar o reiniciar la
			 * ordenacion.
			 */
			public void actionPerformed(ActionEvent e) {
				if (accederOrdenacion) {
					accederOrdenacion = false;
					seleccionAlgoritmo = comboBoxTipoSort.getSelectedIndex();
				}
			}
		});
		panelOpcionesMenu.add(btnOrdenar);

		// Boton para desordenar el array.
		btnDesordenar.setBackground(Color.BLACK);
		btnDesordenar.setForeground(Color.WHITE);
		btnDesordenar.setFont(new Font("Arial", Font.BOLD, 13));
		btnDesordenar.setBounds(160, 129, 110, 30);
		btnDesordenar.addActionListener(new ActionListener() {
			/*
			 * Evitar que durante la desordenacion se pueda volver a marcar y se pueda
			 * ordenar durante la desordenacion. Este obtiene la longitud del comboBox donde
			 * se almacenan el nombre de los algoritmos, permitiendo que en la seleccion
			 * salte la opcion por defecto en metodo sorting(), siendo esta la desordenacion
			 * del array.
			 */
			public void actionPerformed(ActionEvent e) {
				if (accederOrdenacion) {
					accederOrdenacion = false;
					seleccionAlgoritmo = comboBoxTipoSort.getWidth();
				}
			}
		});
		panelOpcionesMenu.add(btnDesordenar);

		// Label para el recuento de cambios realizados en el array.
		lblCambios.setForeground(Color.WHITE);
		lblCambios.setFont(new Font("Arial", Font.BOLD, 13));
		lblCambios.setBounds(10, 211, 250, 30);
		panelOpcionesMenu.add(lblCambios);

		// Label para el recuento de accesos realizados en el array.
		lblAccesos.setFont(new Font("Arial", Font.BOLD, 13));
		lblAccesos.setForeground(Color.WHITE);
		lblAccesos.setBounds(10, 252, 237, 30);
		panelOpcionesMenu.add(lblAccesos);

		// Label para el tamaño de las barras pintadas en pantalla.
		lblNumeroBarras.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNumeroBarras.setForeground(Color.WHITE);
		lblNumeroBarras.setFont(new Font("Arial", Font.BOLD, 13));
		lblNumeroBarras.setBounds(123, 334, 147, 30);
		panelOpcionesMenu.add(lblNumeroBarras);

		// Slider para seleccionar el tamaño de las barras pintadas en pantalla.
		int NUM_MAX_ELEMENTOS = 10, NUM_MIN_ELEMENTOS = 1;
		sliderTamBarras.setOrientation(SwingConstants.VERTICAL);
		sliderTamBarras.setMajorTickSpacing(1);
		sliderTamBarras.setForeground(Color.WHITE);
		sliderTamBarras.setBackground(BLACK_SECUNDARIO);
		sliderTamBarras.setMinimum(NUM_MIN_ELEMENTOS);
		sliderTamBarras.setMaximum(NUM_MAX_ELEMENTOS);
		sliderTamBarras.setLabelTable(sliderPersonal.establecerValoresSlider(NUM_MAX_ELEMENTOS));
		sliderTamBarras.setFont(new Font("Arial", Font.BOLD, 13));
		sliderTamBarras.setMinorTickSpacing(1);
		sliderTamBarras.setSnapToTicks(true);
		sliderTamBarras.setPaintLabels(true);
		sliderTamBarras.setValue(5);
		sliderTamBarras.setPaintTicks(true);
		sliderTamBarras.setBounds(173, 375, 90, 360);
		sliderTamBarras.addChangeListener(new ChangeListener() {
			/*
			 * Este realizara el cambio de tamaño siempre que no se este ejecutando la
			 * ordenacion o desordenacion de un array.
			 */
			public void stateChanged(ChangeEvent e) {
				if (accederOrdenacion)
					cambioNumBarras();
			}
		});
		panelOpcionesMenu.add(sliderTamBarras);

		// Label para el retardo en la que se ordena.
		lblRetardo.setForeground(Color.WHITE);
		lblRetardo.setFont(new Font("Arial", Font.BOLD, 13));
		lblRetardo.setBounds(10, 334, 120, 30);
		panelOpcionesMenu.add(lblRetardo);

		// Slider para la seleccion del retardo.
		sliderRetardo.setOrientation(SwingConstants.VERTICAL);
		sliderRetardo.setBackground(BLACK_SECUNDARIO);
		sliderRetardo.setForeground(Color.WHITE);
		sliderRetardo.setMinorTickSpacing(1);
		sliderRetardo.setMajorTickSpacing(10);
		sliderRetardo.setPaintLabels(true);
		sliderRetardo.setFont(new Font("Arial", Font.BOLD, 13));
		sliderRetardo.setValue(1);
		sliderRetardo.setPaintTicks(true);
		sliderRetardo.setBounds(10, 375, 90, 360);
		sliderRetardo.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				if (sliderRetardo.getValue() == 0)
					sliderRetardo.setValue(1);
				cambioRetardo();
			}
		});
		panelOpcionesMenu.add(sliderRetardo);

		// Tiempo de ejecucion de un Sort/
		lblTiempo.setForeground(Color.WHITE);
		lblTiempo.setFont(new Font("Arial", Font.BOLD, 13));
		lblTiempo.setBounds(10, 293, 253, 30);
		panelOpcionesMenu.add(lblTiempo);

		// Panel para visualizar la memoria.
		panelVisorMemoria.setBackground(SystemColor.desktop);
		panelVisorMemoria.setBounds(10, 790, 260, 130);
		panelVisorMemoria.setLayout(null);
		panelOpcionesMenu.add(panelVisorMemoria);

		// Label para visualizar la memoria utilizada.
		lblMemoriaUsada.setForeground(SystemColor.text);
		lblMemoriaUsada.setFont(new Font("Monospaced", Font.PLAIN, 12));
		lblMemoriaUsada.setBounds(10, 10, 240, 20);
		panelVisorMemoria.add(lblMemoriaUsada);

		// Label para visualizar la memoria maxima.
		lblMemoriaMax.setForeground(SystemColor.text);
		lblMemoriaMax.setFont(new Font("Monospaced", Font.PLAIN, 12));
		lblMemoriaMax.setBounds(10, 40, 240, 20);
		panelVisorMemoria.add(lblMemoriaMax);

		// Label para visualizar la memoria libre.
		lblMemoriaLibre.setForeground(SystemColor.text);
		lblMemoriaLibre.setFont(new Font("Monospaced", Font.PLAIN, 12));
		lblMemoriaLibre.setBounds(10, 70, 240, 20);
		panelVisorMemoria.add(lblMemoriaLibre);

		// Label para visualizar la memoria total.
		lblMemoriaTotal.setForeground(SystemColor.text);
		lblMemoriaTotal.setFont(new Font("Monospaced", Font.PLAIN, 12));
		lblMemoriaTotal.setBounds(10, 100, 240, 20);
		panelVisorMemoria.add(lblMemoriaTotal);

		// Boton para saltar o salir de la animacion
		btnSaltarSort.setBackground(Color.BLACK);
		btnSaltarSort.setForeground(Color.WHITE);
		btnSaltarSort.setFont(new Font("Arial", Font.BOLD, 13));
		btnSaltarSort.setBounds(160, 170, 110, 30);
		btnSaltarSort.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Delay.n = 0;
			}
		});
		panelOpcionesMenu.add(btnSaltarSort);

		// Boton para ver informacion sobre la aplicacion
		btnInformacion.setForeground(Color.WHITE);
		btnInformacion.setBackground(Color.BLACK);
		btnInformacion.setFont(new Font("Arial", Font.BOLD, 13));
		btnInformacion.setBounds(10, 926, 110, 30);
		btnInformacion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(frame,
						"Visualizador de ordenacion de matrices\n" + "                      Copyleft 2020\n"
								+ "                            Javiluli\n" + "       Fecha de creacion: Julio 1, 2020");
			}
		});
		panelOpcionesMenu.add(btnInformacion);

		// Boton de red social para GitHub
		btnGithub.setBounds(200, 926, 30, 30);
		btnGithub.setContentAreaFilled(false);
		btnGithub.setIcon(new ImageIcon("data\\media\\img\\github.jpg"));
		btnGithub.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Social.redes(Social.getGithub());
			}
		});
		panelOpcionesMenu.add(btnGithub);

		// Boton de red social para Codepen
		btnCodepen.setBounds(240, 926, 30, 30);
		btnCodepen.setContentAreaFilled(false);
		btnCodepen.setIcon(new ImageIcon("data\\media\\img\\codepen.jpg"));
		btnCodepen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Social.redes(Social.getCodepen());
			}
		});
		panelOpcionesMenu.add(btnCodepen);

		// CombooBox para los diseños graficos de la animacion de ordenacion.
		comboBoxTiposGraficos.setFont(new Font("Arial", Font.BOLD, 13));
		comboBoxTiposGraficos.setBounds(10, 129, 140, 30);
		comboBoxTiposGraficos.setForeground(Color.WHITE);
		comboBoxTiposGraficos.setBackground(Color.DARK_GRAY);
		panelOpcionesMenu.add(comboBoxTiposGraficos);

		// JLabel para titulo en la seleccion del diseño grafico.
		lblTituloGraficos.setFont(new Font("Arial", Font.BOLD, 13));
		lblTituloGraficos.setForeground(Color.WHITE);
		lblTituloGraficos.setBounds(10, 88, 120, 30);
		panelOpcionesMenu.add(lblTituloGraficos);

		// Boton de activacion para el modo multicolor.
		tglbtnMulticolor.setBackground(Color.BLACK);
		tglbtnMulticolor.setForeground(Color.WHITE);
		tglbtnMulticolor.setFont(new Font("Arial", Font.BOLD, 13));
		tglbtnMulticolor.setBounds(10, 170, 140, 30);
		tglbtnMulticolor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (tglbtnMulticolor.isSelected()) {
					barras.activarMulticolor = true;
				} else if (!tglbtnMulticolor.isSelected()) {
					barras.activarMulticolor = false;
				}
				panelBarras.repaint();
			}
		});
		panelOpcionesMenu.add(tglbtnMulticolor);

		// Label para el titulo de los controles.
		lblTitle.setBounds(10, 11, 280, 24);
		lblTitle.setForeground(Color.WHITE);
		lblTitle.setFont(new Font("Arial", Font.BOLD, 18));
		panelMenu.add(lblTitle);
	}

	// ---------------------------------------------------------------------------------------------

	/**
	 * Seleccion se cada uno de los metodos de ordenacion.
	 */
	public void menuSorting() {
		MainAplicacion mainApp = new MainAplicacion();
		if (!accederOrdenacion) {
			textos();
			switch (seleccionAlgoritmo) {
			case 0:
				sorts = new Bitonic(mainApp, barras.arrayPrincipal);
				break;
			case 1:
				sorts = new Bubble(mainApp, barras.arrayPrincipal);
				break;
			case 2:
				sorts = new BubbleOptimized(mainApp, barras.arrayPrincipal);
				break;
			case 3:
				sorts = new Cocktail(mainApp, barras.arrayPrincipal);
				break;
			case 4:
				sorts = new Cycle(mainApp, barras.arrayPrincipal);
				break;
			case 5:
				sorts = new Gnome(mainApp, barras.arrayPrincipal);
				break;
			case 6:
				sorts = new Heap(mainApp, barras.arrayPrincipal);
				break;
			case 7:
				sorts = new Inserccion(mainApp, barras.arrayPrincipal);
				break;
			case 8:
				sorts = new IterativeQuick(mainApp, barras.arrayPrincipal);
				break;
			case 9:
				sorts = new Merge(mainApp, barras.arrayPrincipal);
				break;
			case 10:
				sorts = new OddEven(mainApp, barras.arrayPrincipal);
				break;
			case 11:
				sorts = new Pancake(mainApp, barras.arrayPrincipal);
				break;
			case 12:
				sorts = new Pigeonhole(mainApp, barras.arrayPrincipal);
				break;
			case 13:
				sorts = new Quick(mainApp, barras.arrayPrincipal);
				break;
			case 14:
				sorts = new Radix(mainApp, barras.arrayPrincipal);
				break;
			case 15:
				sorts = new RecursiveBubble(mainApp, barras.arrayPrincipal);
				break;
			case 16:
				sorts = new RecursiveInsertion(mainApp, barras.arrayPrincipal);
				break;
			case 17:
				sorts = new RecursiveSelection(mainApp, barras.arrayPrincipal);
				break;
			case 18:
				sorts = new Selection(mainApp, barras.arrayPrincipal);
				break;
			case 19:
				sorts = new Shell(mainApp, barras.arrayPrincipal);
				break;
			case 20:
				sorts = new Stooge(mainApp, barras.arrayPrincipal);
				break;
			case 21:
				sorts = new Tim(mainApp, barras.arrayPrincipal);
				break;
			default:
				barras.desordenarArray();
				break;
			}

			if (DibujarGraficos.finSort)
				sorts = new FinSort(mainApp, barras.arrayPrincipal);
		}
		reinicio();
		pausa();
	}
	// ---------------------------------------------------------------------------------------------

	/**
	 * Pinta los textos debidamente actualizados en funcion del metodo de
	 * ordenacion.
	 */
	public void textos() {
		lblCambios.setText("Cambios en el Array: " + cambiosArray);
		lblAccesos.setText("Accesos al Array: " + accesoArray);
		calcularTiempo();
		calcularMemoria();
	}

	/**
	 * Actualiza los textos, el tiempo final, los graficos y pone Delay fijo a 1 ms
	 * desde su clase.
	 */
	public void updateAnimaciones() {
		textos();
		fin = System.currentTimeMillis();
		panelBarras.repaint();
		Delay.delay();
	}

	/**
	 * Actualiza los textos, el tiempo final, los graficos y pone Delay editable.
	 *
	 * @param delay the delay
	 */
	public void updateAnimaciones(int delay) {
		textos();
		fin = System.currentTimeMillis();
		panelBarras.repaint();
		Delay.delay(delay);
	}

	/**
	 * Actualiza los textos, los graficos y pone Delay. No cuenta el tiempo final.
	 */
	public void updateAnimacionesSinTiempo() {
		textos();
		panelBarras.repaint();
		Delay.delay();
	}

	/**
	 * Actualiza los graficos y pone Delay fijo a 1 ms.
	 */
	public void updateAnimacionesSoloDelayFijo() {
		panelBarras.repaint();
		Delay.delay(1);
	}
	// ---------------------------------------------------------------------------------------------

	/**
	 * Calcula la memoria y cambia los labels correspondientes.
	 */
	public void calcularMemoria() {
		lblMemoriaTotal.setText("Memoria total: " + memoria.total + " MB");
		lblMemoriaMax.setText("Memoria maxima: " + memoria.max + " MB");
		lblMemoriaLibre.setText("Memoria libre: " + memoria.libre + " MB");
		lblMemoriaUsada.setText("Memoria usada: " + memoria.usada + " MB");
	}
	// ---------------------------------------------------------------------------------------------

	/**
	 * Tiempo usado para en la ejecucion entre el inicio y final de un algoritmo de
	 * ordenacion.
	 */
	private int calcMin(int tiempo) {
		int min = tiempo;
		min = (min / 1000) / 60;
		return min;

	}

	private int calcSeg(int tiempo) {
		int seg = tiempo;
		seg = (seg / 1000) - (60 * calcMin(seg));
		return seg;
	}

	private int calcMil(int tiempo) {
		int mil = tiempo;
		mil = mil - (1000 * (mil / 1000));
		return mil;
	}

	public void calcularTiempo() {
		tiempo = fin - inicio;
		lblTiempo.setText("Tiempo: " + calcMin((int) tiempo) + " m " + calcSeg((int) tiempo) + " s "
				+ calcMil((int) tiempo) + " ms");
	}
	// ---------------------------------------------------------------------------------------------

	/**
	 * Reinicia algunas variables y textos despues de terminar un sort.
	 */
	public void reinicio() {
		accederOrdenacion = true;
		sorts = new AdicionalesSorts(0);
		memoria = new Memoria(0);
		Delay.n = sliderRetardo.getValue();
	}
	// ---------------------------------------------------------------------------------------------

	/**
	 * Mantiene un cicuito cerrado para la seleccion del Sort evitando que el
	 * programa termine despues de una ejecicion.
	 */
	public void pausa() {
		for (; accederOrdenacion;) {
			try {
				Thread.sleep(1);
			} catch (Exception e) {
			}
		}
		menuSorting();
	}
	// ---------------------------------------------------------------------------------------------

	/**
	 * Obtiene el tamaño seleccionado en el menu y cambia el tamaño de las barras
	 * pintandolas en patanlla.
	 */
	public void cambioNumBarras() {
		DibujarGraficos.NUM_BARS = (int) Math.pow(2, sliderTamBarras.getValue());
		DibujarGraficos.BAR_WIDTH = DibujarGraficos.WIN_WIDTH / DibujarGraficos.NUM_BARS;
		DibujarGraficos.BAR_HEIGHT = DibujarGraficos.WIN_HEIGHT / DibujarGraficos.NUM_BARS;

		barras.barras();
		barras.repaint();
	}
	// ---------------------------------------------------------------------------------------------

	/**
	 * Cambio el retardo o lentitud con la que se sejecuta la animacion de la
	 * ordenacion;
	 */
	public void cambioRetardo() {
		Delay.n = sliderRetardo.getValue();
		Delay.delay();
		lblRetardo.setText("Retardo: " + Delay.n + " ms");
	}
	// ---------------------------------------------------------------------------------------------

	/**
	 * La clase SliderNumBarasPersonalizado agrega valores a un Slider para
	 * personalizar la forma de mostrar los distintos valores. En concreto agrega
	 * valores en base 2 del binario.
	 */
	class SliderPersonalizado {

		/**
		 * Convierte un numero entero en un String.
		 *
		 * @param n la n indica el exponente por el cual se calcula.
		 * @return the string
		 */
		private String convertirIntToString(int n) {
			final int base = 2;
			String valor = String.valueOf((int) Math.pow(base, n));
			return valor;
		}

		/**
		 * Establece los valores em funcion de la cantidad recividad por parametro.
		 *
		 * @param n la n es el numero de valores agreados.
		 * @return un hashtable con los valores agregados en base 2.
		 */
		public Hashtable<Integer, JLabel> establecerValoresSlider(int n) {
			Hashtable<Integer, JLabel> posiciones = new Hashtable<Integer, JLabel>();
			JLabel lblLabel;
			for (int i = 0; i <= n; i++) {
				posiciones.put(i, lblLabel = new JLabel(convertirIntToString(i)));
				lblLabel.setForeground(Color.WHITE);
			}
			return posiciones;
		}
	}
}
