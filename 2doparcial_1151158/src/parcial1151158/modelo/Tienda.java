package parcial1151158.modelo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Tienda {
	private Integer id;
	private String nombre, lema, descripcion, email, clave, propietario, facebook, web, imagen;
	
	
	public Tienda(String nombre, String lema, String descripcion, String email, String clave, String propietario,
			String facebook, String web, String imagen) {
	
		this.nombre = nombre;
		this.lema = lema;
		this.descripcion = descripcion;
		this.email = email;
		this.clave = clave;
		this.propietario = propietario;
		this.facebook = facebook;
		this.web = web;
		this.imagen = imagen;
	}
	
	
	
}
