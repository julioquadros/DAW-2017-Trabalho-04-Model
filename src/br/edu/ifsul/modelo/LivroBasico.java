/*
 * @Author: Julio Sergio Quadros dos Santos.
 * @Email: julioquadros@hotmail.com
 * @2017 - Todos os Direitos Reservados
 */
package br.edu.ifsul.modelo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Objects;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

@Entity
@Table(name = "livro_basico")
@Inheritance(strategy = InheritanceType.JOINED)
public class LivroBasico implements Serializable {

    @Id
    @NotNull(message = "O ISBN não pode ser nulo")
    @Column(name = "isbn", length = 20, nullable = false, unique = true)
    private String isbn;
    @NotNull(message = "O título não pode ser nulo")
    @Length(max = 200, message = "O título não pode ter mais de {max} caracteres")
    @NotBlank(message = "O título não pode ser em branco")
    @Column(name = "titulo", length = 200, nullable = false)
    private String titulo;
    @NotBlank(message = "O resumo não pode ser em branco")
    @Column(name = "resumo", columnDefinition = "text")
    private String resumo;
    @NotNull(message = "O nome da editora não pode ser nulo")
    @Length(max = 50, message = "O da editora não pode ter mais de {max} caracteres")
    @NotBlank(message = "O da editora não pode ser em branco")
    @Column(name = "editora", length = 50, nullable = false)
    private String editora;
    @Temporal(TemporalType.DATE)
    @Column(name = "data_publicacao")
    private Calendar dataPublicacao;    
    @ManyToMany
    @JoinTable(name = "livros_autores",
            joinColumns
            = @JoinColumn(name = "livro_basico", referencedColumnName = "isbn", nullable = false),
            inverseJoinColumns
            = @JoinColumn(name = "autor", referencedColumnName = "id", nullable = false))
    private List<Autor> autores_do_livro = new ArrayList<>();

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + Objects.hashCode(this.isbn);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final LivroBasico other = (LivroBasico) obj;
        if (!Objects.equals(this.isbn, other.isbn)) {
            return false;
        }
        return true;
    }

    

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getResumo() {
        return resumo;
    }

    public void setResumo(String resumo) {
        this.resumo = resumo;
    }

    public String getEditora() {
        return editora;
    }

    public void setEditora(String editora) {
        this.editora = editora;
    }

    public Calendar getDataPublicacao() {
        return dataPublicacao;
    }

    public void setDataPublicacao(Calendar dataPublicacao) {
        this.dataPublicacao = dataPublicacao;
    }

    public List<Autor> getAutores_do_livro() {
        return autores_do_livro;
    }

    public void setAutores_do_livro(List<Autor> autores_do_livro) {
        this.autores_do_livro = autores_do_livro;
    }

}
