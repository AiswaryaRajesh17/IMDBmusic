package com.example.imdbmusic.service;

import com.example.imdbmusic.model.Music;
import com.example.imdbmusic.repository.MusicRepository;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;

@Service
public class MusicService {
    @Autowired
    private MusicRepository musicRepository;

    private Music music;

    public Music addMusic(Music music) {
        return musicRepository.save(music);
    }

    public Music updateMusic(Integer id, Music updatedMusic) {
        return musicRepository.findById(id).map(music -> {
            music.setMusicName(updatedMusic.getMusicName());
            music.setSinger(updatedMusic.getSinger());
            music.setGenre(updatedMusic.getGenre());
            music.setYearOfRelease(updatedMusic.getYearOfRelease());
            music.setProducer(updatedMusic.getProducer());
            music.setMusicDirector(updatedMusic.getMusicDirector());
            music.setLyrics(updatedMusic.getLyrics());
            music.setMovieAlbum(updatedMusic.getMovieAlbum());
            return musicRepository.save(music);
        }).orElseThrow(() -> new RuntimeException("Track not found"));
    }

    public void deleteMusic(Integer id) {
        musicRepository.deleteById(id);
    }


    public List<Music> getAllMusic() {
        return musicRepository.findAll();
    }

    public Optional<Music> getMusicById(Integer id) {
        return musicRepository.findById(id);
    }

    public List<Music> getTracksBySinger(String singer) {
        return musicRepository.findBySinger(singer);
    }

    public List<Music> getMusicByLanguage(String language) {
        return musicRepository.findByLanguage(language);
    }

    public List<Music> getMusicByGenre(String genre) {
        return musicRepository.findByGenre(genre);
    }

    public List<Music> getMusicByMusicDirector(String musicDirector) {
        return musicRepository.findByMusicDirector(musicDirector);
    }

    public List<Music> getMusicByProducer(String producer) {
        return musicRepository.findByProducer(producer);
    }
    public List<Music> getMusicByMovieAlbum(String movieAlbum) {
        return musicRepository.findByMovieAlbum(movieAlbum);
    }
    public List<Music> getMusicByLyrics(String lyrics) {
        return musicRepository.findByLyrics(lyrics);
    }
    public List<Music> getMusicByYearOfRelease(Integer year) {
        return musicRepository.findByYearOfRelease(year);
    }
}