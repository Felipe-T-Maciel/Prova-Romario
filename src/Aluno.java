import java.util.ArrayList;

public class Aluno extends Usuario{

    private Turma turma;
    private ArrayList<Prova> notas = new ArrayList<>();

    public Aluno(String nome, String endereco, long matricula, int idade, String senha) {
        super(nome, endereco, matricula, idade, senha);
        usuarios.add(this);
    }

    public ArrayList<Prova> getNotas() {
        return notas;
    }

    public double gerarMedia(Aluno aluno){
        double soma = 0;
        for (Prova nota:
                aluno.getNotas()) {
            soma += nota.getNota();
        }
        return soma/aluno.getNotas().size();
    }

    public void setTurma(Turma turma) {
        this.turma = turma;
    }
}
