public class Prova {
    private Disciplina disciplina;
    private double nota;

    public Prova(Disciplina disciplina, double nota) {
        this.disciplina = disciplina;
        this.nota = nota;
    }

    @Override
    public String toString() {
        return "Prova{" +
                "disciplina=" + disciplina.getNome() +
                ", nota=" + nota +
                '}';
    }

    public double getNota() {
        return nota;
    }
}
