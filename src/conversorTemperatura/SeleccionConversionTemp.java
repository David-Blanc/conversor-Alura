package conversorTemperatura;

import javax.swing.JOptionPane;

public class SeleccionConversionTemp {

	public static void seleccion(String input) {
		if (input == null) {
			return;
		}

		Double valorDouble = null;
		while (valorDouble == null) {
			String valor = (String) JOptionPane.showInputDialog(null,
					"Ingrese el valor",
					"Input",
					JOptionPane.PLAIN_MESSAGE,
					null,
					null,
					"");
			try {
				if (valor == null) {
					return;
				}
				valorDouble = Double.valueOf(valor);

			} catch (NumberFormatException e) {
				JOptionPane.showMessageDialog(null, "El formato cargado no es correcto", "Error", JOptionPane.ERROR_MESSAGE);
			}

		}
		
		switch (input) {
		case "De ºC a ºF":
			ConversionTemp.deCaF(valorDouble);
			break;
		case "De ºC a K":
			ConversionTemp.deCaK(valorDouble);
			break;
		case "De ºF a ºC":
			ConversionTemp.deFaC(valorDouble);
			break;
		case "De ºF a K":
			ConversionTemp.deFaK(valorDouble);
			break;
		case "De K a ºC":
			ConversionTemp.deKaC(valorDouble);
			break;
		case "De K a ºF":
			ConversionTemp.deKaF(valorDouble);
			break;
		default:
			break;
		}
	}
	
	
}
