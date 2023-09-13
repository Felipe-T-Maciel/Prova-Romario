import java.util.ArrayList;

public class Professor extends Usuario{

    private Disciplina disciplina;

    public Professor(String nome, String endereco, long matricula, int idade, String senha, Disciplina disciplina) {
        super(nome, endereco, matricula, idade, senha);
        this.disciplina = disciplina;
        usuarios.add(this);

    }

    public Disciplina getDisciplina() {
        return disciplina;
    }
}
