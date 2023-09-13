import java.util.ArrayList;

public class Turma {

    static ArrayList<Turma> turmas = new ArrayList<>();

    private String nome;

    private ArrayList<Aluno> alunos = new ArrayList<>();
    private ArrayList<Professor> professores = new ArrayList<>();

    public Turma(String nome) {
        this.nome = nome;
        turmas.add(this);
    }

    static void escolhaTurma() {
        System.out.println("Qual turma deseja escolher: ");
        for (Turma turma:
               turmas ) {
            System.out.println("["+turmas.indexOf(turma)+"] "+turma.nome);
        }
    }

    public String getNome() {
        return nome;
    }

    public ArrayList<Aluno> getAlunos() {
        return alunos;
    }

    public ArrayList<Turma> getTurmas() {
        return turmas;
    }

    public ArrayList<Professor> getProfessores() {
        return professores;
    }

    public void gerarBoletim() {
        for (Aluno aluno:
             getAlunos()) {
            System.out.print("_________________________");
            System.out.println("Aluno: "+aluno.getNome());
            for (Prova nota:
                 aluno.getNotas()) {

                System.out.print(" - - - - - -");
                System.out.println(nota.toString());
                System.out.print(" - - - - - -");

            }
            System.out.println("Media notas: "+aluno.gerarMedia(aluno));
        }
    }
}
