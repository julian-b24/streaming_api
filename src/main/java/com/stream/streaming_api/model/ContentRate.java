package com.stream.streaming_api.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@Entity
@Table(name = "content_rate")
@AllArgsConstructor
@NoArgsConstructor
public class ContentRate {

    @Id
    private UUID id;

    @Column(name = "rate")
    private float rate;

    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    @JoinColumn(name = "content_id", nullable = false)
    private Content content;

    @PrePersist
    public void generateId() { this.id = UUID.randomUUID();}
}
