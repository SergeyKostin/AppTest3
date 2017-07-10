package connect;


import com.mongodb.*;
import model.Film;
import model.Films;
import model.Genre;
import model.Producer;

import java.net.UnknownHostException;
import java.util.Properties;

public class ConnectMongoDB {
    private MongoClient mongoClient;
    private DB db;
    private boolean authenticate;
    private DBCollection table_producer;
    private DBCollection table_genre;
    private DBCollection table_film;

    public ConnectMongoDB(Properties properties){
        try{
            mongoClient=new MongoClient(properties.getProperty("host"),Integer.valueOf(properties.getProperty("port")));
            db=mongoClient.getDB(properties.getProperty("dbname"));
            authenticate=db.authenticate(properties.getProperty("login"),properties.getProperty("password").toCharArray());
            table_producer=db.getCollection(properties.getProperty("producer"));
            table_genre=db.getCollection(properties.getProperty("genre"));
            table_film=db.getCollection(properties.getProperty("film"));

        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
    }
    public void addProducer(Producer producer){
        BasicDBObject document=new BasicDBObject();
        document.put("name",producer.getName());
        document.put("surname",producer.getSurname());
        document.put("patronymic",producer.getPatronymic());
        this.table_producer.insert(document);
    }
    public void addGenre(Genre genre){
        BasicDBObject document=new BasicDBObject();
        document.put("name",genre.getName());
        this.table_genre.insert(document);

    }
    public void addFilm(Film film){
        BasicDBObject document=new BasicDBObject();
        document.put("name",film.getName());
        this.table_film.insert(document);
    }
    public Films getFilms(Long id_film){
        BasicDBObject query=new BasicDBObject();
        query.put("id_film",id_film);

        DBObject film_rez=this.table_film.findOne(query);
        Film film=new Film();
        film.setId_film(Long.valueOf((String) film_rez.get("id_film")));
        film.setName(String.valueOf(film_rez.get("name")));
        film.setId_genre(Long.valueOf((String) film_rez.get("id_genre")));

        DBObject producer_rez=this.table_producer.findOne(query);
        Producer producer=new Producer();
        producer.setName(String.valueOf(producer_rez.get("name")));
        producer.setSurname(String.valueOf(producer_rez.get("surname")));
        producer.setPatronymic(String.valueOf(producer_rez.get("patronymic")));
        producer.setId_film(Long.valueOf((String) producer_rez.get("id_film")));

        Long id_genre=film.getId_genre();
        BasicDBObject query_genre=new BasicDBObject();
        query_genre.put("id_film",id_film);
        DBObject genre_rez=this.table_genre.findOne(query_genre);
        Genre genre=new Genre();
        genre.setId_genre(id_genre);
        genre.setName(String.valueOf(genre_rez.get("name")));

        Films films=new Films();
        films.setProducer(producer);
        films.setGenre(genre);
        films.setFilm(film);

        return films;
    }

}
