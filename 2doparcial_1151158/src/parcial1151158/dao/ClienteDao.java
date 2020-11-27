package parcial1151158.dao;


import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import parcial1151158.modelo.Cliente;
import parcial1151158.util.Conexion;
public class ClienteDao {

	private Conexion conexion;
	
	private static final String INSERT_CLIENTE_SQL="INSERT INTO cliente(nombre,email,pais) VALUES (?,?,?);";
	private static final String DELETE_CLIENTE_SQL="DELETE FROM cliente where id=?;";
	private static final String UPDATE_CLIENTE_SQL="UPDATE cliente SET nombre=?,email=?,pais=? WHERE id=?;";
	private static final String SELECT_CLIENTE_BY_ID="SELECT * FROM cliente WHERE id=?;";
	private static final String SELECT_ALL_CLIENTES="SELECT * FROM cliente;";
	
	public ClienteDao() {
		this.conexion = conexion.getConexion();
	}
	
	public void insert (Cliente cliente) throws SQLException{
		try {
			PreparedStatement preparedStatement=(PreparedStatement) conexion.setPreparedStatement(INSERT_CLIENTE_SQL);
			preparedStatement.setString(1, cliente.getNombre());
			preparedStatement.setString(2, cliente.getEmail());
			preparedStatement.setString(3, cliente.getClave());
			
			conexion.execute();
		}catch(SQLException e) {
			
		}
	}
	
	public void delete(int id) throws SQLException{
		try {
			PreparedStatement preparedStatement = (PreparedStatement) conexion.setPreparedStatement(DELETE_CLIENTE_SQL);
			preparedStatement.setInt(1, id);
		} catch (SQLException e) {

		}
	}
	
	public void update (Cliente cliente)throws SQLException {
		try {
			PreparedStatement preparedStatement=(PreparedStatement) conexion.setPreparedStatement(UPDATE_CLIENTE_SQL);
			preparedStatement.setString(1, cliente.getNombre());
			preparedStatement.setString(2, cliente.getEmail());
			preparedStatement.setString(3, cliente.getClave());
			preparedStatement.setInt(4, cliente.getId());
			conexion.execute();
		}catch(SQLException e) {
			
		}
	}
	
	public List<Cliente> selectAll() {

		List<Cliente> clientes = new ArrayList<>();

		try {
			PreparedStatement preparedStatement = (PreparedStatement) conexion.setPreparedStatement(SELECT_ALL_CLIENTES);
			ResultSet rs = conexion.query();

			while (rs.next()) {
				int id = rs.getInt("id");
				String nombre = rs.getString("nombre");
				String email = rs.getString("email");
				String clave = rs.getString("clave");
				clientes.add(new Cliente(id, nombre, email, clave));
			}
		} catch (SQLException e) {

		}
		return clientes;
	}
	
	
	public Cliente select(int id) {

		Cliente cliente = null;

		try {
			PreparedStatement preparedStatement = (PreparedStatement) conexion
					.setPreparedStatement(SELECT_CLIENTE_BY_ID);
			preparedStatement.setInt(1, id);
			ResultSet rs = conexion.query();

			while (rs.next()) {
				
				String nombre = rs.getString("nombre");
				String email = rs.getString("email");
				String clave = rs.getString("clave");
				cliente= new Cliente(id, nombre, email, clave);
			}
		} catch (SQLException e) {

		}
		return cliente;
	}
	

}
