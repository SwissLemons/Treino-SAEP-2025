import java.sql.SQLException;
import java.util.Scanner;

public class Main {		
	private static int p = 1;

	public static void main(String[] args) throws SQLException, ClassNotFoundException {
		Conexao conexao = new Conexao();
		
		int id;
		String descricao;
		String setor;
		String prioridade;
		String estatus;
		int id_usuario;
			do{
				Scanner scanner = new Scanner(System.in);
				
				System.out.println("1- Cadastrar usuario");
				System.out.println("2- Cadastrar tarefa");
				System.out.println("3- Alterar tarefa");
				System.out.println("4- Excluir tarefa");
				System.out.println("5- Mostrar");
				System.out.println("0- Sair");
				
				int escolha = scanner.nextInt();
				scanner.nextLine();
				
				switch(escolha) {
				case 1:			
					System.out.println("+=-Cadastrar_Usuario-=+");
					System.out.println("|  Digite o nome:     |");
					String nome = scanner.nextLine();
					System.out.println("|  Digite o email:    |");
					String email = scanner.nextLine();
					System.out.println("+=====-----_-----=====+");
					
					if(conexao.cadastrarUsuario(nome,email)) {
						System.out.println("Usuario cadastrado.");
					}else {
						System.out.println("Falha ao cadastrar usuario.");
					}
					
					break;
				case 2:
					System.out.println("+====--Cadastrar_Tarefa--====+");
					System.out.println("|  Digite a descrição:       |");
					descricao = scanner.nextLine();
					System.out.println("|  Digite o setor:           |");
					setor = scanner.nextLine();
					System.out.println("|  Digite prioridade:        |");
					System.out.println("|  (baixa,media,alta)        |");
					prioridade = scanner.nextLine();
					System.out.println("|  Digite o status:       	 |");
					System.out.println("|  (fazer,fazendo,feito)     |");
					estatus = scanner.nextLine();
					System.out.println("|  Id do usuario responsavel:|");
					id_usuario = scanner.nextInt();
					scanner.nextLine();
					System.out.println("+======------____------======+");
					
					conexao.cadastrarTarefa(id_usuario,descricao,setor,prioridade,estatus);
					
					break;
				case 3:
					System.out.println("+====--Atualizar_Tarefa--====+");
					System.out.println("|  Digite o id da tarefa:    |");
					id = scanner.nextInt();
					scanner.nextLine();		
					System.out.println("|  Digite a descrição:       |");
					descricao = scanner.nextLine();
					System.out.println("|  Digite o setor:           |");
					setor = scanner.nextLine();
					System.out.println("|  Digite prioridade:        |");
					System.out.println("|  (baixa,media,alta)        |");
					prioridade = scanner.nextLine();
					System.out.println("|  Digite o status:       	 |");
					System.out.println("|  (fazer,fazendo,feito)     |");
					estatus = scanner.nextLine();
					System.out.println("|  Id do usuario responsavel:|");
					id_usuario = scanner.nextInt();
					scanner.nextLine();
					System.out.println("+======------____------======+");
					
					conexao.atualizarTarefa(id_usuario,descricao,setor,prioridade,estatus,id);
					
					break;
				case 4:
					System.out.println("+====--Deletar___Tarefa--====+");
					System.out.println("|  Digite o id da tarefa:    |");
					id = scanner.nextInt();
					scanner.nextLine();		
					
					conexao.excluirTarefa(id);
					break;
				default:
					System.out.println("Saindo.");
					p = 0;
					break;
				}
				
			}while(p == 1);
		}
	}