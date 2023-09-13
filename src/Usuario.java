import java.util.ArrayList;

public class Usuario {
    private String nome;
    private String endereco;
    private int idade;
    private long matricula;
    private String senha;

    static ArrayList<Usuario> usuarios = new ArrayList<>();

    public Usuario(
            String nome, String endereco,long matricula, int idade, String senha
    ){
        this.nome = nome;
        this.idade = idade;
        this.endereco = endereco;
        this.matricula = matricula;
        this.senha = senha;
        usuarios.add(this);
    }

    public static void listaUsers(int escolha) {
        if(escolha == 1){
            for (Usuario aluno:
                    Usuario.usuarios) {
                if(aluno instanceof Aluno){
                    System.out.println("["+usuarios.indexOf(aluno)+"] Aluno "+aluno.nome);
                }
            }
        }else if(escolha == 2){
            for (Usuario prof:
                    Usuario.usuarios) {
                if(prof instanceof Professor){
                    System.out.println("["+usuarios.indexOf(prof)+"] Professor "+prof.nome);
                }
            }
        }else {
            System.out.println("valor incorreto!");
        }
    }

    public long getMatricula() {
        return matricula;
    }

    public String getSenha() {
        return senha;
    }

    public String getNome() {
        return nome;
    }

    public static Usuario verificaLogin(long matricula, String senha) {
        for (Usuario user:
                Usuario.usuarios) {
            if(user.getMatricula() == matricula && user.getSenha().equals(senha)){
                return user;
            }
        }
        return null;
    }
}
