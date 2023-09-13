public class Secretario extends Usuario{

    private int qtdBoletinsGerados;

    public Secretario(String nome, String endereco, long matricula, int idade, String senha) {
        super(nome, endereco, matricula, idade, senha);
        this.qtdBoletinsGerados = 0;
        usuarios.add(this);

    }

    public void setQtdBoletinsGerados(int qtdBoletinsGerados) {
        this.qtdBoletinsGerados = qtdBoletinsGerados;
    }

    public int getQtdBoletinsGerados() {
        return qtdBoletinsGerados;
    }
}
