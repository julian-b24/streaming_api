package com.stream.streaming_api.model;

import com.stream.streaming_api.constants.ContentType;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.Type;

import java.util.UUID;

@Data
@Table(name = "`content`")
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Content {

    @Id
    @NonNull
    private UUID id;

    @Column(name = "name")
    private String name;

    @Column(name = "genre")
    private String genre;

    @Enumerated(EnumType.STRING)
    @Column(name = "type")
    private ContentType type;

    @Column(name = "num_views")
    private int views;

    @Column(name = "rate")
    private float rate;

    @PrePersist
    public void generateId() { this.id = UUID.randomUUID();}
}
