package Principal;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;

import javax.swing.border.LineBorder;

import Algoritmos.*;
import Adicionales.*;

import java.awt.Color;

import javax.swing.SwingConstants;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JSlider;
import javax.swing.event.ChangeListener;

import javax.swing.event.ChangeEvent;
import java.awt.Panel;

public class Main extends Sorts {

	private JFrame frame;
	public JPanel panelMenu;
	JPanel panelOpcionesMenu;
	private JPanel panelBarras;
	JLabel lblTitleAlgoritmo;
	JComboBox<String> comboBoxTipoSort;
	JButton btnOrdenar;
	JButton btnDesordenar;
	JLabel lblTitle;
	JSlider sliderTamBarras;
	JLabel lblTamBarras;
	JLabel lblVelocidad;
	JSlider sliderVelocidad;
	Panel panelVisorMemoria;
	public static JLabel lblCambios;
	public static JLabel lblAccesos;

	// Tama�o de la ventana
	public final static int WIN_WIDTH = 1280;
	public final static int WIN_HEIGHT = 720;

	int seleccionAlgoritmo = -1;
	boolean puedeOrdenar = false;
	boolean puedeDesordenar = true;

//	Objetos de mis Clases
	Barras barras;
	Sorts sorts;
	Memoria memoria;

	static int BAR_WIDTH = 4;
	public static JLabel lblTiempo;
	public static JLabel lblMemoriaUsada;
	public static JLabel lblMemoriaMax;
	public static JLabel lblMemoriaLibre;
	public static JLabel lblMemoriaTotal;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//		public void run() {
//			try {
		Main window = new Main(accesoArray, cambiosArray, panel, n);
		window.frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
	}

	/**
	 * Create the application.
	 */
	public Main(long accesArr, long cambArr, JPanel panel, int[] n) {
		super(accesArr, cambArr, panel, n);
		initialize();
		panelBarras.setLayout(null);
		barras = new Barras();
		barras.setBounds(0, 0, 964, 681);

		panelBarras.add(barras);
		barras.setLayout(null);

		panelBarras.setVisible(true);

		frame.setVisible(true);

		sorting();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {

		frame = new JFrame();
		frame.setBounds(100, 100, WIN_WIDTH, WIN_HEIGHT);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		panelBarras = new JPanel();
		panelBarras.setBackground(Color.BLACK);
		panelBarras.setBounds(300, 0, 964, 681);
		frame.getContentPane().add(panelBarras);

		panelMenu = new JPanel();
		panelMenu.setBounds(0, 0, 300, 681);
		frame.getContentPane().add(panelMenu);
		panelMenu.setLayout(null);

		panelOpcionesMenu = new JPanel();
		panelOpcionesMenu.setBounds(10, 46, 280, 624);
		panelOpcionesMenu.setBorder(new LineBorder(Color.LIGHT_GRAY));
		panelMenu.add(panelOpcionesMenu);
		panelOpcionesMenu.setLayout(null);

		lblTitleAlgoritmo = new JLabel("Algoritmo de ordenacion");
		lblTitleAlgoritmo.setFont(new Font("Arial", Font.BOLD, 13));
		lblTitleAlgoritmo.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitleAlgoritmo.setBounds(47, 11, 186, 25);
		panelOpcionesMenu.add(lblTitleAlgoritmo);

		comboBoxTipoSort = new JComboBox<String>();
		comboBoxTipoSort.setFont(new Font("Arial", Font.BOLD, 13));
		comboBoxTipoSort
				.setModel(new DefaultComboBoxModel<String>(new String[] { "Burbuja", "Insercion", "Seleccion" }));
		comboBoxTipoSort.setBounds(80, 46, 120, 30);
		panelOpcionesMenu.add(comboBoxTipoSort);

		btnOrdenar = new JButton("Ordenar");
		btnOrdenar.setFont(new Font("Arial", Font.BOLD, 13));
		btnOrdenar.setBounds(24, 95, 110, 30);
		btnOrdenar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				puedeOrdenar = true;
				puedeDesordenar = false;
				seleccionAlgoritmo = comboBoxTipoSort.getSelectedIndex();
			}
		});
		panelOpcionesMenu.add(btnOrdenar);

		btnDesordenar = new JButton("Desordenar");
		btnDesordenar.setFont(new Font("Arial", Font.BOLD, 13));
		btnDesordenar.setBounds(153, 95, 110, 30);
		btnDesordenar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (puedeDesordenar) {
					puedeOrdenar = true;
					puedeDesordenar = false;
					seleccionAlgoritmo = comboBoxTipoSort.getWidth();
					cambioSizeBarras();
				}
			}
		});
		panelOpcionesMenu.add(btnDesordenar);

		lblCambios = new JLabel("Cambios en el Array:");
		lblCambios.setFont(new Font("Arial", Font.BOLD, 13));
		lblCambios.setBounds(10, 156, 250, 30);
		panelOpcionesMenu.add(lblCambios);

		lblAccesos = new JLabel("Accesos al Array:");
		lblAccesos.setFont(new Font("Arial", Font.BOLD, 13));
		lblAccesos.setBounds(10, 197, 237, 30);
		panelOpcionesMenu.add(lblAccesos);

		lblTamBarras = new JLabel("Tama\u00F1o de las barras: " + BAR_WIDTH + " px");
		lblTamBarras.setFont(new Font("Arial", Font.BOLD, 13));
		lblTamBarras.setBounds(10, 238, 191, 30);
		panelOpcionesMenu.add(lblTamBarras);

		sliderTamBarras = new JSlider();
		sliderTamBarras.setValue(BAR_WIDTH);
		sliderTamBarras.setMaximum(50);
		sliderTamBarras.setMinimum(2);
		sliderTamBarras.setPaintTicks(true);
		sliderTamBarras.setBounds(10, 283, 260, 30);
		sliderTamBarras.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				if (puedeDesordenar)
					cambioSizeBarras();
			}
		});
		panelOpcionesMenu.add(sliderTamBarras);

		lblVelocidad = new JLabel("Velocidad: " + Delay.n + " ms");
		lblVelocidad.setFont(new Font("Arial", Font.BOLD, 13));
		lblVelocidad.setBounds(10, 324, 190, 30);
		panelOpcionesMenu.add(lblVelocidad);

		sliderVelocidad = new JSlider();
		sliderVelocidad.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				cambioVelocidad();
			}
		});
		sliderVelocidad.setValue(1);
		sliderVelocidad.setPaintTicks(true);
		sliderVelocidad.setBounds(10, 365, 260, 30);
		panelOpcionesMenu.add(sliderVelocidad);

		lblTiempo = new JLabel("Tiempo: 0 ms");
		lblTiempo.setFont(new Font("Arial", Font.BOLD, 13));
		lblTiempo.setToolTipText("Tiempo mas la velocidad.");
		lblTiempo.setBounds(10, 405, 253, 30);
		panelOpcionesMenu.add(lblTiempo);

		panelVisorMemoria = new Panel();
		panelVisorMemoria.setBackground(Color.WHITE);
		panelVisorMemoria.setBounds(10, 441, 260, 140);
		panelOpcionesMenu.add(panelVisorMemoria);
		panelVisorMemoria.setLayout(null);

		lblMemoriaUsada = new JLabel("Memoria usada: 0 MB");
		lblMemoriaUsada.setFont(new Font("Arial", Font.PLAIN, 12));
		lblMemoriaUsada.setBounds(10, 12, 240, 20);
		panelVisorMemoria.add(lblMemoriaUsada);

		lblMemoriaMax = new JLabel("Memoria maxima: 0 MB");
		lblMemoriaMax.setFont(new Font("Arial", Font.PLAIN, 12));
		lblMemoriaMax.setBounds(10, 44, 240, 20);
		panelVisorMemoria.add(lblMemoriaMax);

		lblMemoriaLibre = new JLabel("Memoria libre: 0 MB");
		lblMemoriaLibre.setFont(new Font("Arial", Font.PLAIN, 12));
		lblMemoriaLibre.setBounds(10, 76, 240, 20);
		panelVisorMemoria.add(lblMemoriaLibre);

		lblMemoriaTotal = new JLabel("Memoria total: 0 MB");
		lblMemoriaTotal.setFont(new Font("Arial", Font.PLAIN, 12));
		lblMemoriaTotal.setBounds(10, 108, 240, 20);
		panelVisorMemoria.add(lblMemoriaTotal);

		lblTitle = new JLabel("Controles");
		lblTitle.setBounds(10, 11, 280, 24);
		panelMenu.add(lblTitle);
		lblTitle.setFont(new Font("Arial", Font.BOLD, 13));

	}

	public void sorting() {
		if (puedeOrdenar) {
			textos();
			switch (seleccionAlgoritmo) {
			case 0:
				sorts = new Bubble(seleccionAlgoritmo, seleccionAlgoritmo, panelBarras, Barras.getN());
				break;
			case 1:
				sorts = new Inserccion(seleccionAlgoritmo, seleccionAlgoritmo, panelBarras, Barras.getN());
				break;
			case 2:
				sorts = new Seleccion(seleccionAlgoritmo, seleccionAlgoritmo, panelBarras, Barras.getN());
				break;
			default:
				barras.shuffleArray(panelBarras);
				break;
			}
		}
		reinicio();
		pausa();
	}

	public void textos() {
		lblCambios.setText("Cambios en el Array: " + cambiosArray);
		lblAccesos.setText("Accesos al Array: " + accesoArray);
		lblTiempo.setText("Tiempo: " + tiempo + " ms");
		lblMemoriaMax.setText("Memoria maxima: " + Memoria.getMax() + " MB");
		lblMemoriaTotal.setText("Memoria total: " + Memoria.getTotal() + " MB");
		lblMemoriaLibre.setText("Memoria libre: " + Memoria.getLibre() + " MB");
		lblMemoriaUsada.setText("Memoria usada: " + Memoria.getUsada() + " MB");

	}

	// Reinicia algunas variables despues de terminar un sort
	public void reinicio() {
		puedeOrdenar = false;
		puedeDesordenar = true;
		sorts = new Sorts();
		memoria = new Memoria();
	}

	// mantiene un loop cerrado para la seleccion del Sort
	public void pausa() {
		for (; !puedeOrdenar;) {
			try {
				Thread.sleep(1);
			} catch (Exception e) {
			}
		}
		sorting();
	}

	public void cambioSizeBarras() {
		BAR_WIDTH = sliderTamBarras.getValue();
		Barras.NUM_BARS = Barras.WIN_WIDTH / BAR_WIDTH;
		Barras.BAR_HEIGHT = Barras.WIN_HEIGHT / Barras.NUM_BARS;
		barras.barras();
		barras.repaint();
		lblTamBarras.setText("Tama\u00F1o de las barras: " + BAR_WIDTH + " px");
	}

	public void cambioVelocidad() {
		Delay.n = sliderVelocidad.getValue();
		Delay.delay();
		lblVelocidad.setText("Velocidad: " + Delay.n + " ms");
	}

}
