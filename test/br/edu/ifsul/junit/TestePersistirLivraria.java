/*
 * @Author: Julio Sergio Quadros dos Santos.
 * @Email: julioquadros@hotmail.com
 * @2017 - Todos os Direitos Reservados
 */
package br.edu.ifsul.junit;

import br.edu.ifsul.modelo.Catalogo;
import br.edu.ifsul.modelo.Livraria;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class TestePersistirLivraria {
    
    EntityManagerFactory emf;
    EntityManager em;

    public TestePersistirLivraria() {
    }
    
    @Before
    public void setUp() {
        emf = Persistence.createEntityManagerFactory("DAW-2017-Trabalho04-ModelPU");
        em = emf.createEntityManager();
    }

    @After
    public void tearDown() {
        em.close();
        emf.close();
    }

    @Test
    public void testar() {
        boolean exception = false;
        try {
            Livraria l = new Livraria();
            l.setNome("Teste Livraria");
            l.setSite("http://www.livraria.com.br");
            Catalogo c = new Catalogo();
            c.setDescricao("Catalogo de Livros do Google");
            c.setNome("Google Scholar");
            c.setLivraria(l);
            l.getCatalogos().add(c);
            em.getTransaction().begin();
            em.persist(l);
            em.getTransaction().commit();
        } catch (Exception e) {
            exception = true;
            e.printStackTrace();
        }
        Assert.assertEquals(false, exception);
    }
}
