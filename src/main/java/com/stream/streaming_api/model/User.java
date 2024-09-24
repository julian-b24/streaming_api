package com.stream.streaming_api.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.UUID;

@Data
@Table(name = "`users`")
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class User {

    @Id
    private UUID id;

    @Column(unique = true)
    private String nickname;

    private String email;

    private String password;


    @PrePersist
    public void generateData() {
        this.id = UUID.randomUUID();
    }
}
