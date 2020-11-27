package parcial1151158.modelo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Servicio {
	private Integer id;
	private String nombre, descripcion;

	public Servicio(String nombre, String descripcion) {

		this.nombre = nombre;
		this.descripcion = descripcion;
	}

}
