package conversorTemperatura;

import javax.swing.JOptionPane;

public class ConversionTemp {

	
	public static void deCaF(double input) {
		double cAux = (double) input*9/5+32;
		double c = (double) Math.round(cAux*100)/100;
		JOptionPane.showMessageDialog(null, c +" ºF");
	}

	public static void deFaC(double input) {
		double fAux = (double) (input-32)*5/9;
		double f = (double) Math.round(fAux*100)/100;
		JOptionPane.showMessageDialog(null, f +" ºF");
	}
	
	public static void deCaK(double input) {
		double fAux = (double) (input+273.15);
		double f = (double) Math.round(fAux*100)/100;
		JOptionPane.showMessageDialog(null, f +" K");
	}
	
	public static void deFaK(double input) {
		double fAux = (double) (input-32)*5/9+273.15;
		double f = (double) Math.round(fAux*100)/100;
		JOptionPane.showMessageDialog(null, f +" ºF");
	}
	
	public static void deKaC(double input) {
		double fAux = (double) (input-273.15);
		double f = (double) Math.round(fAux*100)/100;
		JOptionPane.showMessageDialog(null, f +" ºC");
	}
	
	public static void deKaF(double input) {
		double fAux = (double) (input-273.15)*5/9+32;
		double f = (double) Math.round(fAux*100)/100;
		JOptionPane.showMessageDialog(null, f +" ºF");
	}
	
	
}
