/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTO;

public class PacienteDTO {
    private int id;
    private String nome;
    private String cpfDoDono;
    private String dataNascimento;
    private String telefoneDoDono;
    private String emailDoDono;
    private String sexo;
    private String especie;
    private String raca;

    public PacienteDTO(int id, String nome, String cpfDoDono, String dataNascimento, String telefoneDoDono, String emailDoDono, String sexo, String especie, String raca) {
        this.id = id;
        this.nome = nome;
        this.cpfDoDono = cpfDoDono;
        this.dataNascimento = dataNascimento;
        this.telefoneDoDono = telefoneDoDono;
        this.emailDoDono = emailDoDono;
        this.sexo = sexo;
        this.especie = especie;
        this.raca = raca;
    }

    // Getters e Setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }

    public String getCpfDoDono() { return cpfDoDono; }
    public void setCpfDoDono(String cpfDoDono) { this.cpfDoDono = cpfDoDono; }

    public String getDataNascimento() { return dataNascimento; }
    public void setDataNascimento(String dataNascimento) { this.dataNascimento = dataNascimento; }

    public String getTelefoneDoDono() { return telefoneDoDono; }
    public void setTelefoneDoDono(String telefoneDoDono) { this.telefoneDoDono = telefoneDoDono; }

    public String getEmailDoDono() { return emailDoDono; }
    public void setEmailDoDono(String emailDoDono) { this.emailDoDono = emailDoDono; }

    public String getSexo() { return sexo; }
    public void setEndereco(String sexo) { this.sexo = sexo; }

    public String getEspecie() { return especie; }
    public void setEspecie(String especie) { this.especie = especie; }

    public String getRaca() { return raca; }
    public void setRaca(String raca) { this.raca = raca; }
}

