package conversorMoneda;

import javax.swing.JOptionPane;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;

import conexion.Conexion;

public class Conversion {

	private static double arsXusd = conexionUSD();
	private static double eurXusd = conexionEUR();
	
	private static double conexionUSD() {
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
		return arsXusd;
	}
	
	private static double conexionEUR() {
		String respuesta = null;
		try (Conexion conexion = new Conexion("https://exchange-rates.abstractapi.com/v1/live/?api_key=cd0a504d10e1420ba90eaebe13f7f1db&base=USD&target=EUR")) {
			  respuesta = conexion.leerRespuesta();
			} catch (Exception e) {
				e.printStackTrace();
			}
		JSONObject array = (JSONObject) JSONValue.parse(respuesta);
		JSONObject eur = (JSONObject) array.get("exchange_rates");
		eurXusd = (Double) eur.get("EUR");
		return eurXusd;
	}
	
	public static void deUSDaARS(double input) {
		double arsAux = (double) input*arsXusd;
		double ars = (double) Math.round(arsAux*100)/100;
		JOptionPane.showMessageDialog(null, ars +" ARS");
	}

	public static void deARSaUSD(double input) {
		double usdAux = (double) input/arsXusd;
		double usd = (double)(Math.round(usdAux*100))/100;
		JOptionPane.showMessageDialog(null, usd +" USD");
	}
	
	public static void deUSDaEUR(double input) {
		double eurAux = (double) input*eurXusd;
		double eur = (double) Math.round(eurAux*100)/100;
		JOptionPane.showMessageDialog(null, eur +" EUR");
	}

	public static void deEURaUSD(double input) {
		double usdAux = (double) input/eurXusd;
		double usd = (double)(Math.round(usdAux*100))/100;
		JOptionPane.showMessageDialog(null, usd +" USD");
	}
	
	public static void deARSaEUR(double input) {
		double eurAux = (double)(input/arsXusd)*eurXusd;
		double eur = (double)(Math.round(eurAux*100))/100;
		JOptionPane.showMessageDialog(null, eur +" EUR");
	}
	
	public static void deEURaARS(double input) {
		double arsAux = (double) (input/eurXusd)*arsXusd;
		double ars = (double)(Math.round(arsAux*100))/100;
		JOptionPane.showMessageDialog(null, ars +" ARS");
	}

}
