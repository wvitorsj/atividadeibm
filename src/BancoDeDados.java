import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;

public class BancoDeDados {
	private Connection connection = null;
	private java.sql.Statement statement = null;
	private ResultSet resultset = null;

	// PASSAGEM DE PARÂMETROS PARA A CONEXÃO DO NOSSO BANCO DE DADOS
	public void conectar() {

		// CRIANDO A VARIÁVEL DE CONEXÃO DO DATABASE
		String servidor = "jdbc:mysql://localhost/ibm";
		// USUÁRIO DO BANCO DE DADOS
		String usuario = "root";
		// SENHA DO USUÁRIO DO BANCO DE DADOS
		String senha = "mysql";
		// VINCULANDO O DRIVER DE CONEXÃO
		String driver = "com.mysql.cj.jdbc.Driver";

		// CRIAÇÃO DO NOSSO TRY CATCH, PARA TRATAMENTO DE EXECUÇÃO DO BANCO DE DADOS
		try {
			Class.forName(driver);
			this.connection = DriverManager.getConnection(servidor, usuario, senha);
			this.statement = this.connection.createStatement();

		} catch (Exception e) {
			System.out.println("Erro:" + e.getMessage());
		}

	}

	// RETORNO DO MÉTODO DE CONEXÃO
	public boolean estaConectado() {
		if (this.connection != null) {
			return true;
		} else {
			return false;
		}
	}

	// CRIANDO MÉTODO PARA VISUALIZAR OS REGISTROS DO BANCO DE DADOS
	public void listaContatos() {

		// CRIANDO O PROCESSO DE TRATAMENTO DOS COMANDO NO BANCO DE DADOS
		try {
			// CRIANDO UMA VARIÁVEL PARA A SINTAXE EM SQL
			String sintaxe = "select * from contato";
			// System.out.println(sintaxe); //COMANDO UTILIZADO PARA TENTAR ENCONTRAR ERRO
			this.resultset = this.statement.executeQuery(sintaxe);
			this.statement = this.connection.createStatement();
			// CRIANDO UM LAÇO DE REPETIÇÃO PARA RETORNAR OS REGISTROS DA NOSSA TABELA
			while (this.resultset.next()) {
				// CRIANDO AS VARIÁVEIS PARA RECEBER OS REGISTROS DO BANCO DE DADOS
				String meuID = resultset.getString("id");
				String meuNome = resultset.getString("nome");
				// MOSTRANDO NO CONSOLE OS REGISTROS ENCONTRADOS
				System.out.println("id: " + meuID);
				System.out.println("nome: " + meuNome);
			}

		} catch (Exception e) {
			System.out.println("Erro: " + e.getMessage());
		}
	}

	// CRIANDO MÉTODO DE INSERÇÃO DE REGISTROS
	public void inserirContatos(String nome) {
		// FAZENDO VALIDAÇÃO DOS COMANDOS COM TRY/CATCH
		try {
			// LINHA DE COMANDO DA SINTAXE PARA FAZER O INSERT
			String sintaxe = "insert into contato (nome) values('" + nome + "');"; // AS ' ' MOSTRA QUE VEM DADOS DE
																					// CIMA
			System.out.println(sintaxe);
			this.statement.executeUpdate(sintaxe);

		} catch (Exception e) {
			System.out.println("Erro: " + e.getMessage());
		}
	}

	// CRIANDO MÉTODO DE ATUALIZAÇÃO DE REGISTROS
	public void editarContato(String id, String nome) {
		try {
			// LINHA DE COMANDO DA SINTAXE PARA FAZER A ATUALIZAÇÃO
			String sintaxe = "update contato set nome=('" + nome + "') where id=('" + id + "');";
			this.statement.executeUpdate(sintaxe);
		} catch (Exception e) {
			System.out.println("Error" + e.getMessage());
		}
	}

	// CRIANDO MÉTODO DE DELETAR REGISTROS
	public void deletarContato(String id) {
		try {
			// LINHA DE COMANDO DA SINTAXE PARA FAZER A ATUALIZAÇÃO
			String sintaxe = "delete from contato where id=('" + id + "');";
			this.statement.executeUpdate(sintaxe);
		} catch (Exception e) {
			System.out.println("Error" + e.getMessage());
		}
	}

}
