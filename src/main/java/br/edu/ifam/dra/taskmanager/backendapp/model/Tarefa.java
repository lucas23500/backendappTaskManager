package br.edu.ifam.dra.taskmanager.backendapp.model;

import br.edu.ifam.dra.taskmanager.backendapp.controller.CategoriaController;
import org.springframework.lang.Nullable;

import javax.persistence.*;
import java.time.LocalDateTime;

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

    @ManyToOne
    private Categoria categoria;

    @OneToOne
    private Status status;

    public Tarefa() {
    }

    public Tarefa(String titulo) {
        this.titulo = titulo;
    }

    public Tarefa(String titulo, String descricao, String dataPrevista, String dataConclusao, Categoria categoria, Status status) {
        this.titulo = titulo;
        this.descricao = descricao;
        this.dataPrevista = dataPrevista;
        this.dataConclusao = dataConclusao;
        this.categoria = categoria;
        this.status = status;
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

    public void setCategoria(Long categoria) {
        CategoriaController cc = new CategoriaController();
        this.categoria = cc.find(categoria);
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Tarefa{" +
                "id=" + id +
                ", titulo='" + titulo + '\'' +
                ", descricao='" + descricao + '\'' +
                ", dataPrevista='" + dataPrevista + '\'' +
                ", dataConclusao='" + dataConclusao + '\'' +
                ", categoria=" + categoria +
                ", status=" + status +
                '}';
    }
}
