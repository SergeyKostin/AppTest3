package model;


public class Film {
    private String name;
    private Long id_film;
    private Long id_genre;
    public Film(){}
    public Film(String name){
        this.name=name;
    }

    public String getName() {
        return name;
    }

    public Long getId_film() {
        return id_film;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setId_film(Long id_film) {
        this.id_film = id_film;
    }

    public Long getId_genre() {
        return id_genre;
    }

    public void setId_genre(Long id_genre) {
        this.id_genre = id_genre;
    }
}
