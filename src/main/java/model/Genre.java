package model;


public class Genre {
    private String name;
    private Long id_genre;

    public Genre(){}
    public Genre(String name){
        this.name=name;
    }

    public String getName() {
        return name;
    }

    public Long getId_genre() {
        return id_genre;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setId_genre(Long id_genre) {
        this.id_genre = id_genre;
    }
}
