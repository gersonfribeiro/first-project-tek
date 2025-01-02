package com.example.demo.domain.tasks;

import lombok.*;

import java.util.Date;
import java.util.UUID;

// Essas marcações são do lombok e evitam o boilerplate no código
@Getter // Gera todos os métodos get dos atributos
@Setter // Gera todos os métodos set dos atributos
@AllArgsConstructor // Gera um construtor com todos os atributos
@NoArgsConstructor // Gera um construtor sem os atributos
public class Tasks {

    //  Atributos do objeto
    private UUID id_task;
    private String title;
    private String description;
    private StatusTask status;
    private Date createdDate;

    //    Construtor para a criação desse objeto com o endpoint POST, onde a id é gerada e a data é a obtida pelo sistema
    public Tasks(String title, String description, StatusTask status) {
        this.id_task = UUID.randomUUID();
        this.title = title;
        this.description = description;
        this.status = status;

//      Aqui é usado uma métodoo para receber a data atual e setar sempre que esse métodoo construtor for usado
        this.createdDate = java.util.Date.from(java.time.LocalDate.now()
                .atStartOfDay(java.time.ZoneId.of("UTC"))
                .toInstant());
    }
}
