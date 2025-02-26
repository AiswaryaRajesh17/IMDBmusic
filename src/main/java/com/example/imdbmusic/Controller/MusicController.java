package com.example.imdbmusic.Controller;


import com.example.imdbmusic.model.Music;
import com.example.imdbmusic.service.MusicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController

public class MusicController {
    @Autowired
    private MusicService musicService;

    @PostMapping("/musics")
    public ResponseEntity<Music> addMusic(@RequestBody Music music) {
      Music savedMusic = musicService.addMusic(music);
        return ResponseEntity.ok(savedMusic);
    }
    @PutMapping("/{id}")
    public ResponseEntity<Music> updateMusic(@PathVariable Integer id, @RequestBody Music music) {
       Music updatedMusic= musicService.updateMusic(id, music);
        return ResponseEntity.ok(updatedMusic);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteMusic(@PathVariable Integer id) {
        musicService.deleteMusic(id);
        return ResponseEntity.noContent().build();
    }
    @GetMapping("/singer/{singer}")
    public ResponseEntity<List<Music>> getMusicBySinger(@PathVariable String singer) {
        return ResponseEntity.ok(musicService.getTracksBySinger(singer));
    }
    @GetMapping
    public List<Music> getAllMusic() {
        return musicService.getAllMusic();
    }

    @GetMapping("/{id}")
    public Optional<Music> getMusicById(@PathVariable Integer id) {
        return musicService.getMusicById(id);
    }

    @GetMapping("/language/{language}")
    public ResponseEntity<List<Music>> getMusicByLanguage(@PathVariable String language) {
        return ResponseEntity.ok(musicService.getMusicByLanguage(language));
    }
    @GetMapping("/genre/{genre}")
    public ResponseEntity<List<Music>> getMusicByGenre(@PathVariable String genre) {
        return ResponseEntity.ok(musicService.getMusicByGenre(genre));
    }
    @GetMapping("/music-director/{musicDirector}")
    public ResponseEntity<List<Music>> getMusicByMusicDirector(@PathVariable String musicDirector) {
        return ResponseEntity.ok(musicService.getMusicByMusicDirector(musicDirector));
    }
    @GetMapping("/producer/{producer}")
    public ResponseEntity<List<Music>> getMusicByProducer(@PathVariable String producer) {
        return ResponseEntity.ok(musicService.getMusicByProducer(producer));
    }
    @GetMapping("/lyrics/{lyrics}")
    public ResponseEntity<List<Music>> getMusicByLyrics(@PathVariable String lyrics) {
        return ResponseEntity.ok(musicService.getMusicByLyrics(lyrics));
    }
    @GetMapping("/year/{year}")
    public ResponseEntity<List<Music>> getMusicByYearOfRelease(@PathVariable Integer year) {
        return ResponseEntity.ok(musicService.getMusicByYearOfRelease(year));
    }
    @GetMapping("/movieAlbum/{movieAlbum}")
    public ResponseEntity<List<Music>> getMusicByMovieAlbum(@PathVariable String movieAlbum) {
        return ResponseEntity.ok(musicService.getMusicByMovieAlbum(movieAlbum));
    }
}
