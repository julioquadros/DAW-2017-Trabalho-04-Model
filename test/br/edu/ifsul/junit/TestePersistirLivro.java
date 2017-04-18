/*
 * @Author: Julio Sergio Quadros dos Santos.
 * @Email: julioquadros@hotmail.com
 * @2017 - Todos os Direitos Reservados
 */
package br.edu.ifsul.junit;

import br.edu.ifsul.modelo.Formato;
import br.edu.ifsul.modelo.Idioma;
import br.edu.ifsul.modelo.Livro;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class TestePersistirLivro {
    
    EntityManagerFactory emf;
    EntityManager em;

    public TestePersistirLivro() {
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
            Livro l = new Livro();
            l.setIsbn("9788576055631");
            l.setTitulo("Java Como Programar");
            l.setResumo("A oitava edição de Java - como programar, lançada pela Pearson Education, chega ao mercado com novo design e um traço inovador: preocupados em aguçar o raciocínio e o pensamento crítico dos estudantes, Paul J. Deitel e Dr. Harvey M. Deitel incluíram na obra exercícios que estimulam o leitor a associar a Internet e o computador à solução de problemas reais da sociedade. Além dessa novidade, a obra traz um estudo de caso opcional sobre a montagem de um caixa eletrônico (ATM), o que reforça a possibilidade de atrelar a teoria à realidade, e oferece ao estudante a chance de praticar um conceito-chave da programação orientada a objetos: a interação entre vários objetos.");
            l.setEditora("Pearson");
            l.setDataPublicacao(new GregorianCalendar(2009, Calendar.DECEMBER, 16));
            l.setAtivo(true);
            l.setCodigoBarras("9788576055631");
            l.setDataCadastro(Calendar.getInstance());
            l.setNumeroPaginas(1079);
            l.setFormato(em.find(Formato.class, 1));
            l.setIdioma(em.find(Idioma.class, 1));
            //l.setAutores_do_livro(List<Autor>, );
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
