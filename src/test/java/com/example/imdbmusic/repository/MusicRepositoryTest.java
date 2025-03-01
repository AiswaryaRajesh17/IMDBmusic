package com.example.imdbmusic.repository;

import com.example.imdbmusic.model.Music;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@ExtendWith(SpringExtension.class)

@DataJpaTest
@Import(MusicRepository.class)
class MusicRepositoryTest {

    @Autowired
    private MusicRepository musicRepository;

    @BeforeEach
    void setup() {
        Music music1 = Music.builder()
                .musicName("Shape of You")
                .singer("Ed Sheeran")
                .producer("Steve Mac")
                .musicDirector("Ed Sheeran")
                .lyrics("Ed Sheeran & Johnny McDaid")
                .yearOfRelease(2017)
                .language("English")
                .genre("Pop")
                .movieAlbum("Divide")
                .build();

        Music music2 = Music.builder()
                .musicName("Blinding Lights")
                .singer("The Weeknd")
                .producer("Max Martin")
                .musicDirector("The Weeknd")
                .lyrics("Abel Tesfaye & Max Martin")
                .yearOfRelease(2020)
                .language("English")
                .genre("Synthwave")
                .movieAlbum("After Hours")
                .build();

        musicRepository.save(music1);
        musicRepository.save(music2);
    }

    @Test
    void findBySinger() {
        List<Music> results = musicRepository.findBySinger("Ed Sheeran");
        assertFalse(results.isEmpty());
        assertEquals(1, results.size());
        assertEquals("Shape of You", results.get(0).getMusicName());
    }


    @Test
    void findByProducer() {
    }

    @Test
    void findByLanguage() {
    }

    @Test
    void findByMusicDirector() {
    }

    @Test
    void findByLyrics() {
    }

    @Test
    void findByGenre() {
    }

    @Test
    void findByMovieAlbum() {
    }

    @Test
    void findByYearOfRelease() {
    }
}