package principal;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.SwingConstants;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;

public class Main {

	private JFrame frame;
	JPanel panelMenu;
	JPanel panelOpcionesMenu;
	JLabel lblTitleAlgoritmo;
	JComboBox<String> comboBoxTipoSort;
	JButton btnOrdenar;
	JButton btnDesordenar;
	JLabel lblTitle;
	JPanel panelVisualSort;
	public final static int WIN_WIDTH = 1280;
	public final static int WIN_HEIGHT = 720;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Main window = new Main();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Main() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, WIN_WIDTH, WIN_HEIGHT);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		panelMenu = new JPanel();
		panelMenu.setBounds(0, 0, 300, 681);
		frame.getContentPane().add(panelMenu);
		panelMenu.setLayout(null);

		panelOpcionesMenu = new JPanel();
		panelOpcionesMenu.setBorder(new LineBorder(Color.LIGHT_GRAY));
		panelOpcionesMenu.setBounds(10, 50, 280, 620);
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
		comboBoxTipoSort.setBounds(80, 46, 120, 25);
		panelOpcionesMenu.add(comboBoxTipoSort);

		btnOrdenar = new JButton("Ordenar");
		btnOrdenar.setFont(new Font("Arial", Font.BOLD, 13));
		btnOrdenar.setBounds(24, 95, 110, 25);
		panelOpcionesMenu.add(btnOrdenar);

		btnDesordenar = new JButton("Desordenar");
		btnDesordenar.setFont(new Font("Arial", Font.BOLD, 13));
		btnDesordenar.setBounds(153, 95, 110, 25);
		panelOpcionesMenu.add(btnDesordenar);

		lblTitle = new JLabel("Controles");
		lblTitle.setFont(new Font("Arial", Font.BOLD, 13));
		lblTitle.setBounds(10, 15, 280, 24);
		panelMenu.add(lblTitle);

		panelVisualSort = new JPanel();
		panelVisualSort.setBackground(Color.BLACK);
		panelVisualSort.setBounds(300, 0, Barras.WIN_WIDTH, Barras.WIN_HEIGHT);
		frame.getContentPane().add(panelVisualSort);
	}
}
