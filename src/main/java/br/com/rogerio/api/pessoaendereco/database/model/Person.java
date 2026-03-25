package br.com.rogerio.api.pessoaendereco.database.model;

import jakarta.persistence.*;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "person")
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;


    @NotBlank(message = "Name is required")
    private String name;

    @NotBlank(message = "CPF is required")
    @Column(unique = true)
    private String cpf;

    private String email;

    private LocalDate birthDate;

    @ElementCollection
    private List<String> phones;

    @OneToMany(mappedBy = "person", cascade = CascadeType.ALL)
    @Valid
    private List<Address> addresses;

    public Person() {
    }

    public Person(Integer id, String name, String cpf, String email, LocalDate birthDate, List<String> phones, List<Address> addresses) {
        this.id = id;
        this.name = name;
        this.cpf = cpf;
        this.email = email;
        this.birthDate = birthDate;
        this.phones = phones;
        this.addresses = addresses;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public List<String> getPhones() {
        return phones;
    }

    public void setPhones(List<String> phones) {
        this.phones = phones;
    }

    public List<Address> getAddresses() {
        return addresses;
    }

    public void setAddresses(List<Address> addresses) {
        this.addresses = addresses;
    }
}