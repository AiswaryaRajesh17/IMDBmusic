package com.example.imdbmusic.Controller;

import com.example.imdbmusic.model.Music;
import com.example.imdbmusic.repository.MusicRepository;
import com.example.imdbmusic.service.MusicService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class MusicControllerTest {
    @Mock
    private MusicService musicService;

    @InjectMocks
    private MusicController musicController;

    private Music music;

    @BeforeEach
    void setup(){
        music = Music.builder()
                .id(1)
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
    }

    @Test
    void addMusic() {
        when(musicService.addMusic(any(Music.class))).thenReturn(music);

        ResponseEntity<Music> response = musicController.addMusic(music);

        assertNotNull(response);
        Assertions.assertEquals(200, response.getStatusCode().value());
        Assertions.assertEquals("Shape of You", Objects.requireNonNull(response.getBody()).getMusicName());

        verify(musicService, times(1)).addMusic(any(Music.class));
    }

    @Test
    void updateMusic() {
        Integer id = 4;
        Music updatedMusic = Music.builder().id(id).musicName("Updated Music").build();

        when(musicService.updateMusic(eq(id), any(Music.class))).thenReturn(updatedMusic);

        ResponseEntity<Music> response = musicController.updateMusic(id, updatedMusic);

        assertNotNull(response);
        Assertions.assertEquals(HttpStatus.OK, response.getStatusCode());
        assertNotNull(response.getBody());
        Assertions.assertEquals("Updated Music", response.getBody().getMusicName());

        verify(musicService, times(1)).updateMusic(eq(id), any(Music.class));
    }

    @Test
    void deleteMusic() {
        Integer id = 1;

        ResponseEntity<Void> response = musicController.deleteMusic(id);

        Assertions.assertEquals(204, response.getStatusCode().value());
        verify(musicService, times(1)).deleteMusic(id);
    }

    @Test
    void getAllMusic() {
        List<Music> musicList = Arrays.asList(
                music, Music.builder().id(2).musicName("Another Track").build()
        );

        when(musicService.getAllMusic()).thenReturn(musicList);

        List<Music> response = musicController.getAllMusic();

        assertNotNull(response);
        Assertions.assertEquals(2, response.size());

        verify(musicService, times(1)).getAllMusic();
    }
    @Test
    void getMusicById() {
        Integer id = 1;
        Music music = Music.builder().id(id).musicName("Test Track").build();

        when(musicService.getMusicById(id)).thenReturn(Optional.of(music));

        Optional<Music> response = musicController.getMusicById(id);

        Assertions.assertTrue(response.isPresent());
        Assertions.assertEquals(id, response.get().getId());
        Assertions.assertEquals("Test Track", response.get().getMusicName());

        verify(musicService, times(1)).getMusicById(id);

    }

}