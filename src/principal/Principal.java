package principal;

import javax.swing.JOptionPane;
import conversorMoneda.SeleccionConversion;
import conversorTemperatura.SeleccionConversionTemp;

public class Principal {

	public static void main(String[] args) {
		
		int opcion;


		do {
			String[] opciones = {"Temperatura", "Moneda"};
			String cuadroOpciones = (String) JOptionPane.showInputDialog(null,
					"Seleccione una opción de conversión",
					"Menú",
					JOptionPane.PLAIN_MESSAGE,
					null,
					opciones,
					"Temperatura");
			if (cuadroOpciones != null) {
				switch (cuadroOpciones) {
				case "Temperatura": {
					String opcionesTemperatura = (String) JOptionPane.showInputDialog(null,
							"Escoja una opción",
							"Temperatura",
							JOptionPane.PLAIN_MESSAGE,
							null,
							new Object[] {"De ºC a ºF", "De ºC a K", "De ºF a ºC", "De ºF a K", "De K a ºC", "De K a ºF"},
							"De ºC a ºF");
					SeleccionConversionTemp.seleccion(opcionesTemperatura);
					
					break;
				}
				case "Moneda": {
					String opcionesMoneda = (String) JOptionPane.showInputDialog(null,
							"Seleccione una opción de conversión",
							"Menú",
							JOptionPane.PLAIN_MESSAGE,
							null,
							new Object[] {"De ARS a USD", "De ARS a EUR", "De USD a ARS", "De USD a EUR", "De EUR a ARS", "De EUR a USD"},
							"De ARS a USD");
					SeleccionConversion.seleccion(opcionesMoneda);
					
					break;
				}
				default:
					break;
				}

			} else {
				break;
			}
			

			opcion = JOptionPane.showConfirmDialog(null,"¿Desea continuar?", "Pregunta", 
					JOptionPane.YES_NO_OPTION);
		} while (opcion == 0);
	}

}
