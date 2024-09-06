public class Turma {
    private String curso;
    private String serieSemestre;

    public Turma(String curso, String serieSemestre) {
        this.curso = curso;
        this.serieSemestre = serieSemestre;
    }

    public String getCurso() {
        return curso;
    }

    public String getSerieSemestre() {
        return serieSemestre;
    }
}
