package conexion;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

import javax.swing.JOptionPane;

public class Conexion implements AutoCloseable {
	
	  private URLConnection connection;

	  public Conexion(String direccion) {
	    URL url = null;
	    try {
	      url = new URL(direccion);
	    } catch (MalformedURLException e) {

	      JOptionPane.showMessageDialog(null, "Error al crear la URL: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
	    }

	    try {
	      connection = url.openConnection();
	    } catch (IOException e) {
	      JOptionPane.showMessageDialog(null, "Error al abrir la conexión: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
	    }

	    try {
	      connection.connect();
	    } catch (IOException e) {
	      JOptionPane.showMessageDialog(null, "Error al establecer la conexión: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
	    }
	  }
	
	public String leerRespuesta() {

		  StringBuilder contenido = new StringBuilder();

		  BufferedReader reader = null;
		  try {
		    reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
		    String line;
		    while ((line = reader.readLine()) != null) {
		      contenido.append(line);
		      contenido.append("\n");
		    }
		  } catch (IOException e) {
		    JOptionPane.showMessageDialog(null, "Error al leer la respuesta: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
		  } finally {
		    if (reader != null) {
		      try {
		        reader.close();
		      } catch (IOException e) {
		        JOptionPane.showMessageDialog(null, "Error al cerrar el lector: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
		      }
		    }
		  }

		  return contenido.toString();
		}

	@Override
	public void close() throws Exception {
		if (connection != null) {
			((java.net.HttpURLConnection) connection).disconnect();
		}
	}

}
