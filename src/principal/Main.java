package Principal;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;

import javax.swing.border.LineBorder;

import Adicionales.*;
import Sorts.*;
import Sorts.Algoritmos.Bubble;
import Sorts.Algoritmos.Inserccion;
import Sorts.Algoritmos.Seleccion;

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
	private JPanel panelMenu;
	private JPanel panelOpcionesMenu;
	private static JPanel panelBarras;
	private Panel panelVisorMemoria;
	private JComboBox<String> comboBoxTipoSort;
	private JLabel lblTitleAlgoritmo;
	private JLabel lblTitle;
	private JLabel lblTamBarras;
	private JLabel lblVelocidad;
	private static JLabel lblTiempo;
	private static JLabel lblMemoriaUsada;
	private static JLabel lblMemoriaMax;
	private static JLabel lblMemoriaLibre;
	private static JLabel lblMemoriaTotal;
	private static JLabel lblCambios;
	private static JLabel lblAccesos;
	private JButton btnOrdenar;
	private JButton btnDesordenar;
	private JSlider sliderTamBarras;
	private JSlider sliderVelocidad;

	// Tamaño de la ventana
	public final static int WIN_WIDTH = 1280;
	public final static int WIN_HEIGHT = 720;

	private int seleccionAlgoritmo = -1;
	private boolean puedeOrdenar = false;
	private boolean puedeDesordenar = true;

//	Objetos de mis Clases
	Barras barras;
	Sorts sorts;
	Memoria memoria;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			Main window = new Main();
			window.frame.setVisible(true);
		} catch (Exception e) {
		}
	}

	/**
	 * Create the application.
	 */

	/**
	 * Create the application.
	 */
	public Main() {
		initialize();
		getPanelBarras().setLayout(null);
		barras = new Barras();
		barras.setBounds(0, 0, 964, 681);
		getPanelBarras().add(barras);
		barras.setLayout(null);
		getPanelBarras().setVisible(true);
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

		setPanelBarras(new JPanel());
		getPanelBarras().setBackground(Color.BLACK);
		getPanelBarras().setBounds(300, 0, 964, 681);
		frame.getContentPane().add(getPanelBarras());

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

		setLblCambios(new JLabel("Cambios en el Array:"));
		getLblCambios().setFont(new Font("Arial", Font.BOLD, 13));
		getLblCambios().setBounds(10, 156, 250, 30);
		panelOpcionesMenu.add(getLblCambios());

		setLblAccesos(new JLabel("Accesos al Array:"));
		getLblAccesos().setFont(new Font("Arial", Font.BOLD, 13));
		getLblAccesos().setBounds(10, 197, 237, 30);
		panelOpcionesMenu.add(getLblAccesos());

		lblTamBarras = new JLabel("Tama\u00F1o de las barras: " + Barras.BAR_WIDTH + " px");
		lblTamBarras.setFont(new Font("Arial", Font.BOLD, 13));
		lblTamBarras.setBounds(10, 238, 191, 30);
		panelOpcionesMenu.add(lblTamBarras);

		sliderTamBarras = new JSlider();
		sliderTamBarras.setValue(Barras.BAR_WIDTH);
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

		setLblTiempo(new JLabel("Tiempo: 0 ms"));
		getLblTiempo().setFont(new Font("Arial", Font.BOLD, 13));
		getLblTiempo().setBounds(10, 405, 253, 30);
		panelOpcionesMenu.add(getLblTiempo());

		panelVisorMemoria = new Panel();
		panelVisorMemoria.setBackground(Color.WHITE);
		panelVisorMemoria.setBounds(10, 441, 260, 140);
		panelOpcionesMenu.add(panelVisorMemoria);
		panelVisorMemoria.setLayout(null);

		setLblMemoriaUsada(new JLabel("Memoria usada: 0 MB"));
		getLblMemoriaUsada().setFont(new Font("Arial", Font.PLAIN, 12));
		getLblMemoriaUsada().setBounds(10, 12, 240, 20);
		panelVisorMemoria.add(getLblMemoriaUsada());

		setLblMemoriaMax(new JLabel("Memoria maxima: 0 MB"));
		getLblMemoriaMax().setFont(new Font("Arial", Font.PLAIN, 12));
		getLblMemoriaMax().setBounds(10, 44, 240, 20);
		panelVisorMemoria.add(getLblMemoriaMax());

		setLblMemoriaLibre(new JLabel("Memoria libre: 0 MB"));
		getLblMemoriaLibre().setFont(new Font("Arial", Font.PLAIN, 12));
		getLblMemoriaLibre().setBounds(10, 76, 240, 20);
		panelVisorMemoria.add(getLblMemoriaLibre());

		setLblMemoriaTotal(new JLabel("Memoria total: 0 MB"));
		getLblMemoriaTotal().setFont(new Font("Arial", Font.PLAIN, 12));
		getLblMemoriaTotal().setBounds(10, 108, 240, 20);
		panelVisorMemoria.add(getLblMemoriaTotal());

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
				sorts = new Bubble();
				break;
			case 1:
				sorts = new Inserccion();
				break;
			case 2:
				sorts = new Seleccion();
				break;
			default:
				barras.shuffleArray();
				break;
			}
		}
		reinicio();
		pausa();
	}

	public void textos() {
//		lblCambios.setText("Cambios en el Array: " + cambiosArray);
		getLblAccesos().setText("Accesos al Array: " + accesoArray);
		getLblTiempo().setText("Tiempo: " + getTiempo() + " ms");
		getLblMemoriaMax().setText("Memoria maxima: " + Memoria.getMax() + " MB");
		getLblMemoriaTotal().setText("Memoria total: " + Memoria.getTotal() + " MB");
		getLblMemoriaLibre().setText("Memoria libre: " + Memoria.getLibre() + " MB");
		getLblMemoriaUsada().setText("Memoria usada: " + Memoria.getUsada() + " MB");

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
		Barras.BAR_WIDTH = sliderTamBarras.getValue();
		Barras.NUM_BARS = Barras.WIN_WIDTH / Barras.BAR_WIDTH;
		Barras.BAR_HEIGHT = Barras.WIN_HEIGHT / Barras.NUM_BARS;
		barras.barras();
		barras.repaint();
		lblTamBarras.setText("Tama\u00F1o de las barras: " + Barras.BAR_WIDTH + " px");
	}

	public void cambioVelocidad() {
		Delay.n = sliderVelocidad.getValue();
		Delay.delay();
		lblVelocidad.setText("Velocidad: " + Delay.n + " ms");
	}

	public static JLabel getLblCambios() {
		return lblCambios;
	}

	public static void setLblCambios(JLabel lblCambios) {
		Main.lblCambios = lblCambios;
	}

	public static JLabel getLblAccesos() {
		return lblAccesos;
	}

	public static void setLblAccesos(JLabel lblAccesos) {
		Main.lblAccesos = lblAccesos;
	}

	public static JLabel getLblMemoriaMax() {
		return lblMemoriaMax;
	}

	public static void setLblMemoriaMax(JLabel lblMemoriaMax) {
		Main.lblMemoriaMax = lblMemoriaMax;
	}

	public static JLabel getLblMemoriaTotal() {
		return lblMemoriaTotal;
	}

	public static void setLblMemoriaTotal(JLabel lblMemoriaTotal) {
		Main.lblMemoriaTotal = lblMemoriaTotal;
	}

	public static JLabel getLblMemoriaLibre() {
		return lblMemoriaLibre;
	}

	public static void setLblMemoriaLibre(JLabel lblMemoriaLibre) {
		Main.lblMemoriaLibre = lblMemoriaLibre;
	}

	public static JLabel getLblMemoriaUsada() {
		return lblMemoriaUsada;
	}

	public static void setLblMemoriaUsada(JLabel lblMemoriaUsada) {
		Main.lblMemoriaUsada = lblMemoriaUsada;
	}

	public static JLabel getLblTiempo() {
		return lblTiempo;
	}

	public static void setLblTiempo(JLabel lblTiempo) {
		Main.lblTiempo = lblTiempo;
	}

	public static JPanel getPanelBarras() {
		return panelBarras;
	}

	public void setPanelBarras(JPanel panelBarras) {
		Main.panelBarras = panelBarras;
	}

}
