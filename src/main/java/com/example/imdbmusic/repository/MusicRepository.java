package com.example.imdbmusic.repository;

import com.example.imdbmusic.model.Music;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface MusicRepository extends JpaRepository<Music, Integer> {

     List<Music> findBySinger(String singer);
     List<Music> findByProducer(String producer);
     List<Music> findByLanguage(String language);
     List<Music> findByMusicDirector(String musicDirector);
     List<Music> findByLyrics(String language);
     List<Music> findByGenre(String genre);
     List<Music> findByMovieAlbum(String movieAlbum);
     List<Music> findByYearOfRelease(Integer year);


}
