package conversorMoneda;

import javax.swing.JOptionPane;

public class SeleccionConversion {


	public static void seleccion(String input) {
		if (input == null) {
			return;
		}

		Double valorDouble = null;
		while (valorDouble == null) {
			String valor = (String) JOptionPane.showInputDialog(null,
					"Ingrese el monto",
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
		case "De ARS a USD":
			Conversion.deARSaUSD(valorDouble);
			break;
		case "De USD a ARS":
			Conversion.deUSDaARS(valorDouble);
			break;
		case "De ARS a EUR":
			Conversion.deARSaEUR(valorDouble);
			break;
		case "De USD a EUR":
			Conversion.deUSDaEUR(valorDouble);
			break;
		case "De EUR a ARS":
			Conversion.deEURaARS(valorDouble);
			break;
		case "De EUR a USD":
			Conversion.deEURaUSD(valorDouble);
			break;
		default:
			break;
		}
	}
	
}
