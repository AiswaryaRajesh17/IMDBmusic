package com.example.imdbmusic.service;

import com.example.imdbmusic.model.Music;
import com.example.imdbmusic.repository.MusicRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class MusicServiceTest {

    @Mock
    private MusicRepository musicRepository;

    @InjectMocks
    private MusicService musicService;

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
        when(musicRepository.save(any(Music.class))).thenReturn(music);

       Music savedMusic = musicService.addMusic(music);

        assertNotNull(savedMusic);
        assertEquals("Ed Sheeran", savedMusic.getSinger());
        verify(musicRepository, times(1)).save(any(Music.class));
    }

    @Test
    void updateMusic() {
        Integer id = 2;
        Music updatedMusic = Music.builder()
                .id(id)
                .musicName("Updated Music Name")
                .build();

        when(musicRepository.findById(id)).thenReturn(Optional.of(music));
        when(musicRepository.save(any(Music.class))).thenReturn(updatedMusic);


        Music result = musicService.updateMusic(id, updatedMusic);

        assertNotNull(result);
        assertEquals("Updated Music Name", result.getMusicName());
        verify(musicRepository, times(1)).findById(id);
        verify(musicRepository, times(1)).save(any(Music.class));
    }

    @Test
    void deleteMusic() {
        Integer id=3;

        musicService.deleteMusic(id);

        verify(musicRepository, times(1)).deleteById(id);
    }
    @Test
    void getAllMusic() {
        Music music2 =  Music.builder()
                .id(2)
                .musicName("Another Song")
                .build();

        List< Music> musics = Arrays.asList(music, music2);
        when(musicRepository.findAll()).thenReturn(musics);

        List< Music> result = musicService.getAllMusic();

        assertEquals(2, result.size());
        verify(musicRepository, times(1)).findAll();
    }
    @Test
    void getMusicById() {
        when(musicRepository.findById(1)).thenReturn(Optional.of(music));

        Optional<Music> result = musicService.getMusicById(1);

        Assertions.assertTrue(result.isPresent());
        assertEquals("Shape of You", result.get().getMusicName());
        verify(musicRepository, times(1)).findById(1);

    }
    @Test
    void getMusicBySinger() {
        when(musicRepository.findBySinger("Ed Sheeran"))
                .thenReturn(Arrays.asList(music));

        List<Music> result = musicService.getTracksBySinger("Ed Sheeran");

        assertNotNull(result);
        assertEquals(1, result.size());
        verify(musicRepository, times(1)).findBySinger("Ed Sheeran");
    }
}