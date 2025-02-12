public class Principal{

    public static void main(String args[]){

        Aluno aluno1 = new Aluno("Rafael", 34, 12345678910l, 1001);

        Aluno aluno2 = new Aluno("Gabriel", 28, 12345678910l, 2001);

        Professor professor1 = new Professor("Cecilia", 2, 45612378910l, 2002);

        Professor professor2 = new Professor("Clara", 1, 45612378910l, 3002);


        Disciplina disciplina1 = new Disciplina("Web II", 80);

        Disciplina disciplina2 = new Disciplina("Paradigmnas", 120);

        Curso curso1 = new Curso("Sistemas");

        curso1.addDisciplina(disciplina2);
        curso1.addDisciplina(disciplina1);

        disciplina1.addAluno(aluno1);
        disciplina2.addAluno(aluno2);

        disciplina1.addProfessor(professor1);
        disciplina2.addProfessor(professor2);

        System.out.println(curso1.toString());

    }
}