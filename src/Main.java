import java.util.Scanner;

public class Main {

    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        preCadastrarDisciplinas();
        int opcao = 0;
        do{
            System.out.println("""
                ___ Sistema ___
                ___ Opções ____
               
                [1] Login
                [2] register
                [3] Logout""");
            System.out.print("> ");
            opcao = sc.nextInt();

            switch (opcao){
                case 1 -> {
                    System.out.println("Matricula: ");
                    long matricula = sc.nextLong();

                    System.out.println("Senha: ");
                    String senha = sc.next();
                    Usuario logado = Usuario.verificaLogin(matricula, senha);
                    if(logado != null){
                        if(logado instanceof Secretario){
                            menuSecretario((Secretario) logado);
                        }
                        else if(logado instanceof Professor){
                            menuProfessor((Professor) logado);
                        }else {
                            menuAluno((Aluno) logado);
                        }
                    }
                }

                case 2 ->{
                    System.out.println("""
                            --- Quem pretende se registrar? ---
                            [1] Secretario
                            [2] Professor
                            [3] Aluno
                            [4] Voltar""");
                    System.out.print("> ");
                    int escolha = sc.nextInt();
                    String nome = "";
                    int idade = 0;
                    String endereco = "";
                    long matricula = 0;
                    String senha = "";
                    if(escolha>=1 && escolha<=3){
                        System.out.print("Seu nome: ");
                        nome = sc.next();

                        System.out.print("Sua idade: ");
                        idade = sc.nextInt();

                        System.out.print("Seu endereco: ");
                        endereco = sc.next();

                        System.out.print("Sua matricula: ");
                        matricula = sc.nextLong();

                        System.out.print("Sua senha: ");
                        senha = sc.next();
                    }
                    switch (escolha){
                        case 1 -> {
                            Usuario secretario = new Secretario(nome,endereco,matricula,idade,senha);
                        }
                        case 2 -> {
                            System.out.println("Qual a sua disciplina?");
                            for (Disciplina disciplina:
                                 Disciplina.disciplinas) {
                                System.out.println("["+Disciplina.disciplinas.indexOf(disciplina)+"] Disciplina: "+disciplina.getNome());
                            }
                            int escolhaDisciplina = sc.nextInt();
                            if(Disciplina.disciplinas.get(escolhaDisciplina) != null){
                                Usuario professor = new Professor(nome,endereco,matricula,idade,senha,
                                        Disciplina.disciplinas.get(escolhaDisciplina));
                            }
                        }

                        case 3 -> {
                            Usuario aluno = new Aluno(nome,endereco,matricula,idade,senha);
                        }

                        case 4 -> {}

                        default -> {
                            System.out.println("Valor invalido");
                        }
                    }
                }

                default -> {
                    System.out.println("Valor invalido");
                }
            }
        }while (opcao != 3);
    }

    private static void preCadastrarDisciplinas() {
        Disciplina disciplina = new Disciplina("Programação Java" ,340);
        Disciplina disciplina2 = new Disciplina("Programação o Orientada a Objetos" ,100);
        Disciplina disciplina3 = new Disciplina("Programação Lógica de Programação" ,160);

    }

    private static void menuAluno(Aluno aluno) {
        int opcao = 0;
        do {
            System.out.println("""
                    -- Bem vindo --
                    O que pretende fazer?
                                    
                    [1] Listar suas notas
                    [2] Voltar
                    """);
            System.out.print("> ");
            opcao = sc.nextInt();

            switch (opcao) {
                case 1 -> {
                    for (Prova nota :
                         aluno.getNotas()) {
                        System.out.println("_______________");
                        System.out.println(nota.toString());
                        System.out.println("_______________");
                    }
                }
                case 2 -> {
                    return;
                }

                default -> {
                    System.out.println("Valor invalido");
                }
            }
        }while (true);
    }

    private static void menuProfessor(Professor professor) {
        int opcao = 0;
        do {
            System.out.println("""
                    -- Bem vindo --
                    O que pretende fazer?
                                    
                    [1] Cadastrar uma nova prova e notas de cada aluno
                    [2] Listar media dos alunos de sua disciplina por turma
                    [3] Voltar
                    """);
            System.out.print("> ");
            opcao = sc.nextInt();

            switch (opcao) {
                case 1 -> {
                    Turma.escolhaTurma();
                    int escolha = sc.nextInt();

                    Turma turma = Turma.turmas.get(escolha);

                    for (Aluno aluno:
                            turma.getAlunos()) {
                        System.out.println("Que nota o aluno: "+aluno.getNome()+" tirou? ");
                        System.out.print("> ");
                        aluno.getNotas().add(new Prova(professor.getDisciplina(),sc.nextDouble()));
                    }
                }

                case 2 -> {
                    Turma.escolhaTurma();
                    int escolha = sc.nextInt();

                    Turma turma = Turma.turmas.get(escolha);

                    for (Usuario aluno:
                            Usuario.usuarios) {
                        if(aluno instanceof Aluno){
                            if(turma.getAlunos().contains((Aluno) aluno) && turma.getProfessores().contains(professor)){
                                System.out.print("_________________________");
                                System.out.println("Aluno: "+aluno.getNome());
                                System.out.println("Media notas: "+((Aluno) aluno).gerarMedia((Aluno) aluno));
                            }
                        }
                    }

                }

                case 3 -> {
                    return;
                }

                default -> {
                    System.out.println("Valor invalido");
                }
            }
        }while (true);
    }

    private static void menuSecretario(Secretario secretario) {
        int opcao = 0;
        do{
            System.out.println("""
                -- Bem vindo --
                O que pretende fazer?
                
                [1] Cadastrar uma nova turma
                [2] Adicionar alunos ou professores a uma turma existente
                [3] Gerar boletim de uma turma
                [4] Voltar
                """);
            System.out.print("> ");
            opcao = sc.nextInt();

            switch (opcao){
                case 1 -> {
                    System.out.println("Nome da turma: ");
                    String turmaNome = sc.next();

                    Turma turma = new Turma(turmaNome);
                    System.out.println("Turma cadastrada!!");
                }

                case 2 ->{
                    Turma.escolhaTurma();
                    int escolha = sc.nextInt();
                    Turma turma = Turma.turmas.get(escolha);
                    int escolhaAlunosOuProfessores = 0;
                    do{
                        System.out.println("""
                                Adicionar novo: 
                                [1] Aluno
                                [2] Professor
                                [3] Sair""");
                        System.out.print("> ");
                        escolhaAlunosOuProfessores = sc.nextInt();
                        if(escolhaAlunosOuProfessores!=3){
                            Usuario.listaUsers(escolhaAlunosOuProfessores);
                            int user = sc.nextInt();
                            if(Usuario.usuarios.get(user) instanceof  Aluno &&
                                    !turma.getAlunos().contains((Aluno) Usuario.usuarios.get(user))){
                                turma.getAlunos().add((Aluno) Usuario.usuarios.get(user));
                                ((Aluno) Usuario.usuarios.get(user)).setTurma(turma);
                            }
                            if(Usuario.usuarios.get(user) instanceof  Professor &&
                                    !turma.getProfessores().contains((Professor) Usuario.usuarios.get(user))){
                                turma.getProfessores().add((Professor) Usuario.usuarios.get(user));
                            }
                        }
                    }while(escolhaAlunosOuProfessores!=3);
                }

                case 3 -> {
                    Turma.escolhaTurma();
                    int escolha = sc.nextInt();

                    Turma turma = Turma.turmas.get(escolha);
                    int somaQtdBoletimGerado = secretario.getQtdBoletinsGerados() + 1;
                    secretario.setQtdBoletinsGerados(somaQtdBoletimGerado);
                    turma.gerarBoletim();
                }

                case 4 -> {
                    return;
                }

                default -> {
                    System.out.println("Valor invalido");
                }
            }
        }while (true);
    }
}
