package Adicionales;

/**
 *
 * @author Javier Delgado Rodriguez
 */
import java.awt.Desktop;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

/**
 * Class Social para el uso de redes socuales en la apliacion.
 */
public class Social {
	/** The github. */
	private static final String GITHUB = "https://github.com/javiluli";
	/** The codepen. */
	private static final String CODEPEN = "https://codepen.io/javiluli_js";

	/**
	 * Redes sociales asociadas con el uso de botones en el JFrame.
	 *
	 * @param url_web the url web
	 */
	public static void redes(String url_web) {
		if (Desktop.isDesktopSupported()) {
			Desktop escritorio = Desktop.getDesktop();
			if (escritorio.isSupported(Desktop.Action.BROWSE))
				try {
					URI uir = new URI(url_web);
					escritorio.browse(uir);
				} catch (URISyntaxException | IOException e) {
				}
		}
	}

	public static String getGithub() {
		return GITHUB;
	}

	public static String getCodepen() {
		return CODEPEN;
	}
}
