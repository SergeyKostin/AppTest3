package model;


public class Producer {
    private String name;
    private String surname;
    private String patronymic;
    private Long id_film;

    public Producer(){}
    public Producer(String name, String surname, String patronymic){
        this.name=name;
        this.surname=surname;
        this.patronymic=patronymic;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setPatronymic(String patronymic) {
        this.patronymic = patronymic;
    }

    public Long getId_film() {
        return id_film;
    }

    public void setId_film(Long id_film) {
        this.id_film = id_film;
    }
}
