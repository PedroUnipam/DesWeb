package aplicativo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import dominio.Cliente;
import dominio.Produto;
import dominio.Venda;

public class Principal {

    public static void main(String[] args) {
        
        EntityManagerFactory emf = null;
        EntityManager em = null;
        
        try {
            emf = Persistence.createEntityManagerFactory("aula-jpa"); 
            em = emf.createEntityManager(); 
            
            em.getTransaction().begin();
    
            Produto produto1 = new Produto("Mouse", 800.00);
            Produto produto2 = new Produto("Smartphone", 4700.00);
            Produto produto3 = new Produto("Headphone", 950.00);
            Produto produto4 = new Produto("Teclado", 630.00);
            
            em.persist(produto1);
            em.persist(produto2);
            em.persist(produto3);
            em.persist(produto4);
            
            Cliente cliente1 = new Cliente("Carlos Verri");
            Cliente cliente2 = new Cliente("Romário Faria");
            Cliente cliente3 = new Cliente("José Roberto"); 
            Cliente cliente4 = new Cliente("Pedro Sousa");
            
            em.persist(cliente1);
            em.persist(cliente2);
            em.persist(cliente3);
            em.persist(cliente4);
            
            Venda venda1 = new Venda();
            venda1.setCliente(cliente1);
            venda1.setProdutos(Arrays.asList(produto3, produto2));
            venda1.setValorTotal(produto3.getPreco() + produto2.getPreco());
            
            Venda venda2 = new Venda();
            venda2.setCliente(cliente2);
            venda2.setProdutos(Arrays.asList(produto4));
            venda2.setValorTotal(produto4.getPreco());
            
            Venda venda3 = new Venda();
            venda3.setCliente(cliente3);
            venda3.setProdutos(Arrays.asList(produto1, produto2));
            venda3.setValorTotal(produto1.getPreco() + produto2.getPreco());
            
            Venda venda4 = new Venda();
            venda4.setCliente(cliente4);
            venda4.setProdutos(Arrays.asList(produto2, produto1, produto4));
            venda4.setValorTotal(produto2.getPreco() + produto1.getPreco() + produto4.getPreco());
            
            em.persist(venda1);
            em.persist(venda2);
            em.persist(venda3);
            em.persist(venda4);
            
            em.getTransaction().commit(); 
            
            System.out.println("\n--- SELECT * FROM cliente ---");
            List<Cliente> clientes = em.createQuery("SELECT c FROM Cliente c", Cliente.class).getResultList();
            for (Cliente c : clientes) {
                System.out.println(c);
            }
            
            System.out.println("\n--- SELECT * FROM produto ---");
            List<Produto> produtos = em.createQuery("SELECT p FROM Produto p", Produto.class).getResultList();
            for (Produto p : produtos) {
                System.out.println(p);
            }
            
            System.out.println("\n--- SELECT * FROM venda ---");
            List<Venda> vendas = em.createQuery("SELECT v FROM Venda v", Venda.class).getResultList();
            for (Venda v : vendas) {
                System.out.println(v);
            }
            
            System.out.println("\n--- SELECT * FROM venda_produto ---");
            List<Object[]> vendaProdutos = em.createNativeQuery("SELECT * FROM venda_produto").getResultList();
            for (Object[] vp : vendaProdutos) {
                System.out.println("Venda ID: " + vp[0] + ", Produto ID: " + vp[1]);
            }
            
        } catch (Exception e) {
            if (em != null && em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
            e.printStackTrace();
        } finally {
            if (em != null) {
                em.close();
            }
            if (emf != null) {
                emf.close();
            }
        }
    }            
}