package com.challengue.clients.models;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UuidGenerator;

import java.time.LocalDateTime;
import java.util.UUID;
@Entity
@ToString
@Getter
@Setter
@EqualsAndHashCode
public class Client {
    @Id
    @UuidGenerator
    private UUID id;
    @NotNull
    @NotEmpty
    private String name;
    @NotNull
    @NotEmpty
    private String lastName;
    @NotNull
    @NotEmpty
    private String motherLastName;
    @CreationTimestamp
    private LocalDateTime createdAt;
    private boolean status;
}
