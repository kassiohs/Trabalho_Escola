public class Tecnico extends Funcionario {
    public Tecnico(String nome, String cpf, double salario) {
        super(nome, cpf, salario);
    }

    @Override
    public double calcularBonificacao() {
        return getSalario() * 0.10;
    }
}

public class Professor extends Funcionario {
    private int cargaHoraria;

    public Professor(String nome, String cpf, double salario, int cargaHoraria) {
        super(nome, cpf, salario);
        this.cargaHoraria = cargaHoraria;
    }

    @Override
    public double calcularBonificacao() {
        return getSalario() * 0.15;
    }
}

public class Coordenador extends Professor {
    public Coordenador(String nome, String cpf, double salario, int cargaHoraria) {
        super(nome, cpf, salario, cargaHoraria);
    }

    @Override
    public double calcularBonificacao() {
        return super.calcularBonificacao() + 500;
    }
}

public class Diretor extends Funcionario {
    public Diretor(String nome, String cpf, double salario) {
        super(nome, cpf, salario);
    }

    @Override
    public double calcularBonificacao() {
        return getSalario() * 0.20;
    }
}
