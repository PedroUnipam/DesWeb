package aplicativo;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import dominio.Passaporte;

public class Principal{
    public static void main(String[] args) {

        EntityManagerFactory emf = null;
        EntityManager em = null;
    
        try {
            emf = Persistence.createEnityManagerFactory("aula-jpa");
            em = emf.createEnityManager();

            em.getTransaction().begin();

            Pessoa pessoa1 = new Pessoa("Rafael");
            Passaporte passaporte1 = new Passaporte(111111111L);

            Pessoa pessoa2 = new Pessoa("Gabriel");
            Passaporte passaporte2 = new Passaporte(222222222L);

            pessoa1.setPassaporte(passaporte1);
            passaporte1.setPessoa(pessoa1);

            pessoa2.setPassaporte(passaporte2);
            passaporte2.setPessoa(pessoa2);

        } catch (Exception e) {
            
        }

    }
}