import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Conexao {
	//usuario senha e url para conexao
	private String usuario = "root";
	private String senha = "root";
	private String url = "jdbc:mysql://localhost:3306/saep";
	private Connection idConexao;

	public Connection getIdConexao() {
		return idConexao;
	}
	public void setIdConexao(Connection idConexao) {
		this.idConexao = idConexao;
	}
	//conecta ao mysql
	public void conectar() throws ClassNotFoundException, SQLException {
		//carregar driver(biblioteca)
		Class.forName("com.mysql.jdbc.Driver");
		//fazer a conecção:
		this.idConexao = DriverManager.getConnection(url, usuario, senha);
		//testar coneção:
		if(this.idConexao != null) {
			System.out.println("Conectado.");
		}
	}
	//desconecta para evitar uso exessivo de recursos
	public void desConectar() throws SQLException {
		if(this.idConexao != null) {
			System.out.println("Desconectado.");
		this.idConexao.close();
		}
	}
	public boolean cadastrarUsuario(String nome, String email) throws SQLException, ClassNotFoundException {
		conectar();
		String sql = "insert into usuarios (nome,email) values (?,?)";
		try (PreparedStatement comando = getIdConexao().prepareStatement(sql)) {
	        comando.setString(1, nome);
	        comando.setString(2, email);
	        int rowsInserted = comando.executeUpdate();
	        comando.close();
	        desConectar();
	        return rowsInserted > 0;
	    }		
	}
	public boolean cadastrarTarefa(int id_usuario,String descricao, String setor, String prioridade, String estatus) throws ClassNotFoundException, SQLException {
		conectar();
		String sql = "insert into tarefas (id_usuario,descricao,setor,prioridade,estatus) values (?,?,?,?,?)";
		try (PreparedStatement comando = getIdConexao().prepareStatement(sql)) {
			comando.setInt(1, id_usuario);
	        comando.setString(2, descricao);
	        comando.setString(3, setor);
	        comando.setString(4, prioridade);
	        comando.setString(5, estatus);
	        int rowsInserted = comando.executeUpdate();
	        comando.close();
	        desConectar();
	        return rowsInserted > 0;
	    }		
	}
	public boolean atualizarTarefa(int id_usuario,String descricao,String setor,String prioridade,String estatus,int id) throws ClassNotFoundException, SQLException {
		conectar();
		String sql = "update tarefas set id_usuario=?,descricao=?,setor=?,prioridade=?,estatus=? where id=?";
		try (PreparedStatement comando = getIdConexao().prepareStatement(sql)) {
			comando.setInt(1, id_usuario);
	        comando.setString(2, descricao);
	        comando.setString(3, setor);
	        comando.setString(4, prioridade);
	        comando.setString(5, estatus);
	        comando.setInt(6, id);
	        int rowsInserted = comando.executeUpdate();
	        comando.close();
	        desConectar();
	        return rowsInserted > 0;
	    }		
	}
	public boolean excluirTarefa(int id) throws ClassNotFoundException, SQLException {
		conectar();
		String sql = "delete from tarefas where id=?";
		try (PreparedStatement comando = this.idConexao.prepareStatement(sql)){
			comando.setInt(1, id);	
			comando.executeUpdate();
			this.desConectar();
			
		}
		return false;
	}
}
