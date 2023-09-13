import java.util.ArrayList;

public class Disciplina {
    static ArrayList<Disciplina> disciplinas = new ArrayList<>();

    private String nome;
    private int codigo = 0;
    private double cargaHoraria;

    public Disciplina(String nome, double cargaHoraria) {
        this.nome = nome;
        this.codigo++;
        this.cargaHoraria = cargaHoraria;
        disciplinas.add(this);
    }

    public String getNome() {
        return nome;
    }

    public int getCodigo() {
        return codigo;
    }
}
