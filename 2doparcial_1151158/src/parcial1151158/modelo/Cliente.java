package parcial1151158.modelo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Cliente {
	private Integer id;
	private String nombre,email,clave;
	
	public Cliente(String nombre, String email, String clave) {
		
		this.nombre=nombre;
		this.email=email;
		this.clave= clave;
		}
	
}
