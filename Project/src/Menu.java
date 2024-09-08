import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Menu {
    private Scanner scanner = new Scanner(System.in);
    private List<Aluno> alunos = new ArrayList<>();
    private List<Funcionario> funcionarios = new ArrayList<>();
    private List<Turma> turmas = new ArrayList<>();

    public void exibirMenu() {
        String opcao = "";

        while (!opcao.equals("10")) {
            System.out.println("1. Inserir um novo aluno");
            System.out.println("2. Inserir um novo funcionario");
            System.out.println("3. Inserir uma nova turma");
            System.out.println("4. Imprimir relatorio de aluno");
            System.out.println("5. Imprimir relatorio de funcionario");
            System.out.println("6. Listar todos os funcionarios pelo nome");
            System.out.println("7. Mostrar total de gastos com funcionarios");
            System.out.println("8. Listar todas as turmas");
            System.out.println("9. Mudar aluno de turma");
            System.out.println("10. Sair");
            System.out.print("Escolha uma opcao: ");
            opcao = scanner.nextLine();
            
            executarOpcao(opcao);
        }
    }

    private void executarOpcao(String opcao) {
        switch (opcao) {
            case "1":
                incluirNovoAluno();
                break;
            case "2":
                incluirNovoFuncionario();
                break;
            case "3":
                incluirNovaTurma();
                break;
            case "4":
                emitirRelatorioAluno();
                break;
            case "5":
                emitirRelatorioFuncionario();
                break;
            case "6":
                listarFuncionarios();
                break;
            case "7":
                mostrarGastosFuncionarios();
                break;
            case "8":
                listarTurmas();
                break;
            case "9":
                mudarAlunoDeTurma();
                break;
            case "10":
                System.out.println("Saindo...");
                break;
            default:
                System.out.println("Opcaoo invalida, tente novamente.");
        }
    }

    // Método para incluir um novo aluno
    private void incluirNovoAluno() {
        System.out.print("Digite o nome do aluno: ");
        String nome = scanner.nextLine();

        System.out.print("Digite a matricula do aluno: ");
        String matricula = scanner.nextLine();

        System.out.print("Digite a data de nascimento do aluno (dd/mm/aaaa): ");
        String dataNascimento = scanner.nextLine();

        Aluno aluno = new Aluno(nome, matricula, dataNascimento);
        alunos.add(aluno);

        System.out.println("Aluno cadastrado com sucesso!");
    }

    // Método para incluir um novo funcionário
    private void incluirNovoFuncionario() {
        System.out.print("Digite o nome do funcionario: ");
        String nome = scanner.nextLine();

        System.out.print("Digite o CPF do funcionario: ");
        String cpf = scanner.nextLine();

        System.out.print("Digite o salario do funcionario: ");
        double salario = Double.parseDouble(scanner.nextLine());

        Funcionario funcionario = new Funcionario(nome, cpf, salario);
        funcionarios.add(funcionario);

        System.out.println("Funcionario cadastrado com sucesso!");
    }

    // Método para incluir uma nova turma
    private void incluirNovaTurma() {
        System.out.print("Digite o nome do curso da turma: ");
        String curso = scanner.nextLine();

        System.out.print("Digite a seie/semestre da turma: ");
        String serieSemestre = scanner.nextLine();

        Turma turma = new Turma(curso, serieSemestre);
        turmas.add(turma);

        System.out.println("Turma cadastrada com sucesso!");
    }

    // Método para emitir relatório de aluno
    private void emitirRelatorioAluno() {
        if (alunos.isEmpty()) {
            System.out.println("Nenhum aluno cadastrado.");
        } else {
            System.out.println("Relatorio de Alunos:");
            for (Aluno aluno : alunos) {
                System.out.println("Nome: " + aluno.getNome());
                System.out.println("Matricula: " + aluno.getMatricula());
                System.out.println("Data de Nascimento: " + aluno.getDataNascimento());
                System.out.println("---------------------------");
            }
        }
    }

    // Método para emitir relatório de funcionário
    private void emitirRelatorioFuncionario() {
        if (funcionarios.isEmpty()) {
            System.out.println("Nenhum funcionario cadastrado.");
        } else {
            System.out.println("Relatorio de Funcionarios:");
            for (Funcionario funcionario : funcionarios) {
                System.out.println("Nome: " + funcionario.getNome());
                System.out.println("CPF: " + funcionario.getCpf());
                System.out.println("Salario: " + funcionario.getSalario());
                System.out.println("---------------------------");
            }
        }
    }

    // Método para listar todos os funcionários pelo nome
    private void listarFuncionarios() {
        if (funcionarios.isEmpty()) {
            System.out.println("Nenhum funcionario cadastrado.");
        } else {
            System.out.println("Funcionarios cadastrados:");
            for (Funcionario funcionario : funcionarios) {
                System.out.println("Nome: " + funcionario.getNome());
            }
        }
    }

    // Método para mostrar total de gastos com funcionários
    private void mostrarGastosFuncionarios() {
        double totalGastos = 0;
        for (Funcionario funcionario : funcionarios) {
            totalGastos += funcionario.getSalario();
        }
        System.out.println("Total de gastos com funcionários: " + totalGastos);
    }

    // Método para listar todas as turmas
    private void listarTurmas() {
        if (turmas.isEmpty()) {
            System.out.println("Nenhuma turma cadastrada.");
        } else {
            System.out.println("Turmas cadastradas:");
            for (Turma turma : turmas) {
                System.out.println("Curso: " + turma.getCurso() + " - Série/Semestre: " + turma.getSerieSemestre());
            }
        }
    }

    // Método para mudar aluno de turma
    private void mudarAlunoDeTurma() {
        System.out.print("Digite a matrícula do aluno que deseja mudar de turma: ");
        String matricula = scanner.nextLine();

        Aluno alunoEncontrado = null;
        for (Aluno aluno : alunos) {
            if (aluno.getMatricula().equals(matricula)) {
                alunoEncontrado = aluno;
                break;
            }
        }

        if (alunoEncontrado != null) {
            System.out.print("Digite a nova turma (curso): ");
            String novaTurma = scanner.nextLine();
            alunoEncontrado.setTurma(novaTurma);
            System.out.println("Aluno " + alunoEncontrado.getNome() + " mudou para a turma: " + novaTurma);
        } else {
            System.out.println("Aluno não encontrado.");
        }
    }
}
