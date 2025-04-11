import java.sql.Timestamp;
import java.util.Scanner;

public class Main {
private int idU;
private String nome;
private String email;

private int idT;
private String descricao;
private String setor;
private String prioridade;
private Timestamp data_cadastro;
private String estatus;

public static void Main (String args) {
Scanner scanner = new Scanner(System.in);

System.out.println("1- Cadastrar usuario");
System.out.println("2- Cadastrar tarefa");
System.out.println("3- Mostrar");

String escolha = scanner.nextLine();

}
}