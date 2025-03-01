package com.example.imdbmusic.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "track")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Music {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
   private String musicName;
   private String singer;
   private String producer;
   private String musicDirector;
   private String lyrics;
   private Integer yearOfRelease;
   private String language;
   private String genre;
   private String movieAlbum;
}
