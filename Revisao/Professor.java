public class Professor extends Pessoa{
    private int IdProfessor;

    public Professor(){
        this("", 0, 0l, 0);
    }

    public Professor(String nome, int idade){
        this(nome, idade, 0l, 0);
    }

    public Professor(String nome, int idade, long cpf, int IdProfessor){
        super(nome, idade, cpf);
        this.IdProfessor = IdProfessor;
    }

    public void setIdProfessor(int IdProfessor){
        this.IdProfessor = (IdProfessor);
    }

    public int getIdProfessor(){
        return this.IdProfessor;
    }

    @Override
    public String toString(){
        return "Professor{" + super.toString() + 
            ", IdProfessor=" + getIdProfessor() + "}";
    }
}