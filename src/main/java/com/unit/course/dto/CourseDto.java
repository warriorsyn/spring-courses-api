package com.unit.course.dto;

import java.util.Date;

import com.unit.course.model.Course;

public class CourseDto {

    private Long id;

    private String nome;

    private String descricao;

    private String ementa;

    private Date dataCadastro;

    private Date dataInicio;

    private float valor;

    public CourseDto() {
    }

    public CourseDto(Course entity) {
        this.id = entity.getid();
        this.nome = entity.getNome();
        this.descricao = entity.getDescricao();
        this.ementa = entity.getEmenta();
        this.dataCadastro = entity.getDataCadastro();
        this.dataInicio = entity.getDataInicio();
        this.valor = entity.getValor();
    }

    public Course toEntity() {
        Course entity = new Course();

        entity.setNome(this.nome);
        entity.setDescricao(this.descricao);
        entity.setEmenta(this.ementa);
        entity.setDataCadastro(this.dataCadastro);
        entity.setDataInicio(this.dataInicio);
        entity.setValor(this.valor);

        return entity;
    }

    /**
     * @return int return the id
     */
    public Long getid() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setid(Long id) {
        this.id = id;
    }

    /**
     * @return String return the nome
     */
    public String getNome() {
        return nome;
    }

    /**
     * @param nome the nome to set
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * @return String return the descricao
     */
    public String getDescricao() {
        return descricao;
    }

    /**
     * @param descricao the descricao to set
     */
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    /**
     * @return String return the ementa
     */
    public String getEmenta() {
        return ementa;
    }

    /**
     * @param ementa the ementa to set
     */
    public void setEmenta(String ementa) {
        this.ementa = ementa;
    }

    /**
     * @return Date return the dataCadastro
     */
    public Date getDataCadastro() {
        return dataCadastro;
    }

    /**
     * @param dataCadastro the dataCadastro to set
     */
    public void setDataCadastro(Date dataCadastro) {
        this.dataCadastro = dataCadastro;
    }

    /**
     * @return Date return the dataInicio
     */
    public Date getDataInicio() {
        return dataInicio;
    }

    /**
     * @param dataInicio the dataInicio to set
     */
    public void setDataInicio(Date dataInicio) {
        this.dataInicio = dataInicio;
    }

    /**
     * @return float return the valor
     */
    public float getValor() {
        return valor;
    }

    /**
     * @param valor the valor to set
     */
    public void setValor(float valor) {
        this.valor = valor;
    }

}
