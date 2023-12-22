package com.appagendamento.appagendamento.domain.session;

import jakarta.persistence.*;
import lombok.*;

@Table(name="session")
@Entity(name="session")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class Session {
    @Id @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    private String name;

    private String date;
}

