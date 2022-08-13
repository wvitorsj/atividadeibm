
public class Agenda {

	public static void main(String[] args) {
		//CHAMANDO A NOSSA CLASSE DO BANCO DE DADOS E OS MÉTODOS
		BancoDeDados sintaxeBanco = new BancoDeDados();
		sintaxeBanco.conectar();
		
		//CRAINDO O IF PARA VERIFICAR SE O BANCO ESTÁ OU NÃO CONECTANDO
		if(sintaxeBanco.estaConectado()) {			
			//CHAMANDO A CLASSE E O MÉTODO PARA INSERIR OS REGISTROS
			sintaxeBanco.inserirContatos("Kathlenn Ferreira");
			
			//CHAMANDO A CLASSE E O MÉTODO PARA LISTAR OS REGISTROS SELECT COM CRUD
			sintaxeBanco.listaContatos();
			
			//CHAMANDO A CLASSE E O MÉTODO PARA ALTERAR OS REGISTROS SELECT COM CRUD
			sintaxeBanco.editarContato("7", "Daniela Mello");
			System.out.println("-------------------------------------");
			sintaxeBanco.listaContatos();
			System.out.println("-----------------DELETAR--------------------");
			
			//CHAMANDO A CLASSE E O MÉTODO PARA DELETAR OS REGISTROS SELECT COM CRUD
			sintaxeBanco.deletarContato("3");
			System.out.println("-------------------------------------");
			sintaxeBanco.listaContatos();
			
			System.out.println("Conexão com o banco de dados foi com êxito");
		}else {
			System.out.println("Não foi possível conectar ao banco de dados");
		}
	}	
	
	
}





















