package br.edu.ifam.dra.taskmanager.backendapp.model;

import javax.persistence.*;

@Entity
public class Tarefa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String titulo;

    private String descricao;

    private String dataPrevista;

    private String dataConclusao;

    private Boolean confirmada;

    @ManyToOne
    private Categoria categoria;

    @OneToOne
    private Status status;

    @OneToOne
    private Prioridade prioridade;

    public Tarefa() {
    }

    public Tarefa(String titulo) {
        this.titulo = titulo;
    }

    public Tarefa(Long id, String titulo, String descricao, String dataPrevista, String dataConclusao, Boolean confirmada, Categoria categoria, Status status, Prioridade prioridade) {
        this.id = id;
        this.titulo = titulo;
        this.descricao = descricao;
        this.dataPrevista = dataPrevista;
        this.dataConclusao = dataConclusao;
        this.confirmada = confirmada;
        this.categoria = categoria;
        this.status = status;
        this.prioridade = prioridade;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescricao() {
        return descricao;
    }

    public Prioridade getPrioridade() {
        return prioridade;
    }

    public void setPrioridade(Prioridade prioridade) {
        this.prioridade = prioridade;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getDataPrevista() {
        return dataPrevista;
    }

    public void setDataPrevista(String dataPrevista) {
        this.dataPrevista = dataPrevista;
    }

    public String getDataConclusao() {
        return dataConclusao;
    }

    public void setDataConclusao(String dataConclusao) {
        this.dataConclusao = dataConclusao;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Boolean getConfirmada() {
        return confirmada;
    }

    public void setConfirmada(Boolean confirmada) {
        this.confirmada = confirmada;
    }

    @Override
    public String toString() {
        return "Tarefa{" +
                "id=" + id +
                ", titulo='" + titulo + '\'' +
                ", descricao='" + descricao + '\'' +
                ", dataPrevista='" + dataPrevista + '\'' +
                ", dataConclusao='" + dataConclusao + '\'' +
                ", confirmada=" + confirmada +
                ", categoria=" + categoria +
                ", status=" + status +
                ", prioridade=" + prioridade +
                '}';
    }
}
