package model;


public class Films {
    private Film film;
    private Genre genre;
    private Producer producer;
    public Films(){}
    public Films(Film film, Genre genre, Producer producer){
        this.film=film;
        this.genre=genre;
        this.producer=producer;
    }

    public Film getFilm() {
        return film;
    }

    public Genre getGenre() {
        return genre;
    }

    public Producer getProducer() {
        return producer;
    }

    public void setFilm(Film film) {
        this.film = film;
    }

    public void setGenre(Genre genre) {
        this.genre = genre;
    }

    public void setProducer(Producer producer) {
        this.producer = producer;
    }
}
