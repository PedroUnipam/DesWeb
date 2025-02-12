import java.util.List;
import java.util.ArrayList;

public class Curso{
    private String nomeCurso;
    private List<Disciplina> disciplinas;

    public Curso(String nomeCurso){
        this.nomeCurso = nomeCurso;
        this.disciplinas = new ArrayList<Disciplina>();
    }

    public void setNomeCurso(String nomeCurso){
        this.nomeCurso = nomeCurso;
    }

    public String getNomeCurso(){
        return this.nomeCurso;
    }

    public void setDisciplinas(List<Disciplina> disciplinas){
        this.disciplinas = disciplinas;
    }

    public List<Disciplina> getDisciplinas(){
        return this.disciplinas;
    }

    public void addDisciplina(Disciplina disciplina){
        this.disciplinas.add(disciplina);
    }

    public int cargaHorariaCurso(){
        int cargaHorariaTotal = 0;
        for (Disciplina n : disciplinas) {
            cargaHorariaTotal += n.getCargaHoraria();
        }

        return cargaHorariaTotal;
    }

    @Override
    public String toString(){
        return "Curso{}" + 
        "nomeCurso=" + getNomeCurso() + 
        "\nDisciplinas" + getDisciplinas() + 
        "\nCarga Horaria:" + cargaHorariaCurso() +
        "}";
    }
    
}