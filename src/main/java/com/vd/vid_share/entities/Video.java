package com.vd.vid_share.entities;

import java.time.LocalDateTime;
import java.util.UUID;

import jakarta.persistence.*;
import lombok.*;


@Entity
@Table(name = "videos")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Video {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false, length = 1021)
    private String description;

    @Column(nullable = false)
    private String fileName;

    private LocalDateTime uploadDate;


    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;
}