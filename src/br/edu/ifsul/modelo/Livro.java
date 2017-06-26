/*
 * @Author: Julio Sergio Quadros dos Santos.
 * @Email: julioquadros@hotmail.com
 * @2017 - Todos os Direitos Reservados
 */
package br.edu.ifsul.modelo;

import java.io.Serializable;
import java.util.Calendar;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import org.hibernate.annotations.ForeignKey;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

@Entity
@Table(name = "livro")
public class Livro extends LivroBasico implements Serializable {
    
    @NotNull(message = "O Código de Barras não pode ser nulo")
    @Length(max = 20, message = "O Código de Barras não pode ter mais de {max} caracteres")
    @NotBlank(message = "O Código de Barras não pode ser em branco")
    @Column(name = "codigo_barras", length = 20, nullable = false)  
    private String codigoBarras;@NotNull(message = "O Código de Barras não pode ser nulo")
    @Column(name = "numero_paginas", length = 10, nullable = false)
    private Integer numeroPaginas;
    @NotNull(message = "A definição se esta ativo não pode ser nula")
    @Column(name = "ativo", nullable = false)
    private Boolean ativo;
    @Temporal(TemporalType.DATE)
    @Column(name = "data_cadastro")
    private Calendar dataCadastro;
    @NotNull(message = "O valor do livro não pode ser nulo")
    @Min(value = 0, message = "O valor do livro não pode ser negativo")
    @Column(name = "valor", nullable = false, columnDefinition = "numeric(12,2)")
    private double valor;
    @NotNull(message = "O idioma não pode ser nulo")
    @ManyToOne
    @JoinColumn(name = "idioma", referencedColumnName = "id", nullable = false)
    @ForeignKey(name = "fk_livro_idioma_id")
    private Idioma idioma;
    @NotNull(message = "O formato não pode ser nulo")
    @ManyToOne
    @JoinColumn(name = "formato", referencedColumnName = "id", nullable = false)
    @ForeignKey(name = "fk_livro_formato_id")
    private Formato formato;
    @NotNull(message = "O catalogo não pode ser nulo")
    @ManyToOne
    @JoinColumn(name = "catalogo", referencedColumnName = "id", nullable = false)
    @ForeignKey(name = "fk_livro_catalogo_id")
    private Catalogo catalogo;
    
    public Livro() {
    }
    
    
    
    public String getCodigoBarras() {
        return codigoBarras;
    }

    public void setCodigoBarras(String codigoBarras) {
        this.codigoBarras = codigoBarras;
    }

    public Integer getNumeroPaginas() {
        return numeroPaginas;
    }

    public void setNumeroPaginas(Integer numeroPaginas) {
        this.numeroPaginas = numeroPaginas;
    }

    public Boolean getAtivo() {
        return ativo;
    }

    public void setAtivo(Boolean ativo) {
        this.ativo = ativo;
    }

    public Calendar getDataCadastro() {
        return dataCadastro;
    }

    public void setDataCadastro(Calendar dataCadastro) {
        this.dataCadastro = dataCadastro;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public Idioma getIdioma() {
        return idioma;
    }

    public void setIdioma(Idioma idioma) {
        this.idioma = idioma;
    }

    public Formato getFormato() {
        return formato;
    }

    public void setFormato(Formato formato) {
        this.formato = formato;
    }

    public Catalogo getCatalogo() {
        return catalogo;
    }

    public void setCatalogo(Catalogo catalogo) {
        this.catalogo = catalogo;
    }

}
