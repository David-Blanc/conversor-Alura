package conversor;

import javax.swing.JOptionPane;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;

public class Conversor {

	public static void main(String[] args) {
		
		double arsXusd = 300;
		
		String respuesta = null;
		try (Conexion conexion = new Conexion("https://www.dolarsi.com/api/api.php?type=valoresprincipales")) {
			  respuesta = conexion.leerRespuesta();
			} catch (Exception e) {
				e.printStackTrace();
			}
		JSONArray array = (JSONArray) JSONValue.parse(respuesta);

		for (Object obj : array) {
			JSONObject c = (JSONObject) obj;
			JSONObject casa = (JSONObject) c.get("casa");

			if (casa.get("nombre") != null && casa.get("nombre").equals("Dolar Blue")) {
				String com = (String) casa.get("compra");
				String ven = (String) casa.get("venta");
				Double compra = Double.valueOf(com.replace(",", "."));
				Double venta = Double.valueOf(ven.replace(",", "."));
				arsXusd = (compra+venta)/2;
			}
		}
		
		
		int opcion;

		do {
			String[] opciones = {"Temperatura", "Moneda"};
			String cuadroOpciones = (String) JOptionPane.showInputDialog(null,
					"Seleccione una opción de conversión",
					"Menú",
					JOptionPane.PLAIN_MESSAGE,
					null,
					opciones,
					"Moneda");

			switch (cuadroOpciones) {
			case "Temperatura": {
				String opcionesTemperatura = (String) JOptionPane.showInputDialog(null,
						"Escoja una opción",
						"Temperatura",
						JOptionPane.PLAIN_MESSAGE,
						null,
						new Object[] {"De ºC a ºF", "De ºF a ºC"},
						"De ºC a ºF");

				switch (opcionesTemperatura) {
				case "De ºC a ºF":
					String valor1 = (String) JOptionPane.showInputDialog(null,
							"Ingrese valor en ºC",
							"De ºC a ºF",
							JOptionPane.PLAIN_MESSAGE,
							null,
							null,
							"");
					Double valorConvertido1 = Double.valueOf(valor1)*9/5+32;
					JOptionPane.showMessageDialog(null, valorConvertido1+" ºF");
					break;
				case "De ºF a ºC":
					String valor2 = (String) JOptionPane.showInputDialog(null,
							"Ingrese valor en ºF",
							"De ºF a ºC",
							JOptionPane.PLAIN_MESSAGE,
							null,
							null,
							"");
					Double valorConvertido2 = (Double.valueOf(valor2)-32)*5/9;
					JOptionPane.showMessageDialog(null, valorConvertido2+" ºC");
					break;
				default:
					break;
				}
				break;
			}
			case "Moneda": {
				String opcionesMoneda = (String) JOptionPane.showInputDialog(null,
						"Seleccione una opción de conversión",
						"Menú",
						JOptionPane.PLAIN_MESSAGE,
						null,
						new Object[] {"De ARS a USD", "De USD a ARS"},
						"De ARS a USD");

				switch (opcionesMoneda) {
				case "De ARS a USD":
					String valor1 = (String) JOptionPane.showInputDialog(null,
							"Ingrese monto en ARS",
							"De ARS a USD",
							JOptionPane.PLAIN_MESSAGE,
							null,
							null,
							"");
					Double valorConvertido1 = Double.valueOf(valor1)/arsXusd;//obtener valor con api
					JOptionPane.showMessageDialog(null, valorConvertido1+" USD");
					break;
				case "De USD a ARS":
					String valor2 = (String) JOptionPane.showInputDialog(null,
							"Ingrese monto en USD",
							"De USD a ARS",
							JOptionPane.PLAIN_MESSAGE,
							null,
							null,
							"");
					Double valorConvertido2 = Double.valueOf(valor2)*arsXusd;//obtener valor con api
					JOptionPane.showMessageDialog(null, valorConvertido2+" ARS");
					break;
				default:
					break;
				}
				break;
			}
			default:
				throw new IllegalArgumentException("Unexpected value: " + cuadroOpciones);
			}


			opcion = JOptionPane.showConfirmDialog(null,"¿Desea continuar?", "Pregunta", 
					JOptionPane.YES_NO_OPTION);
		} while (opcion == 0);
	}

}
