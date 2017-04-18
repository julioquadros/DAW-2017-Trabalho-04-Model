/*
 * @Author: Julio Sergio Quadros dos Santos.
 * @Email: julioquadros@hotmail.com
 * @2017 - Todos os Direitos Reservados
 */
package br.edu.ifsul.junit;

import br.edu.ifsul.modelo.LivroBasico;
import java.util.Calendar;
import java.util.GregorianCalendar;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class TestePersistirLivroBasicoJunit {
    
    EntityManagerFactory emf;
    EntityManager em;

    public TestePersistirLivroBasicoJunit() {
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
            LivroBasico lb = new LivroBasico();
            lb.setIsbn("978316148415");
            lb.setTitulo("Livro de Programação Java");
            lb.setResumo("Livro de Java com exemplos e explicações");
            lb.setEditora("Editora IfElse");
            lb.setDataPublicacao(new GregorianCalendar(2004, Calendar.JULY, 14));
            em.getTransaction().begin();
            em.persist(lb);
            em.getTransaction().commit();
        } catch (Exception e) {
            exception = true;
            e.printStackTrace();
        }
        Assert.assertEquals(false, exception);
    }
}
