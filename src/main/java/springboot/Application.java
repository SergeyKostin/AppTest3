package springboot;

import connect.ConnectMongoDB;
import model.Film;
import model.Films;
import model.Genre;
import model.Producer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Properties;

@Controller
@SpringBootApplication
public class Application {
    private ConnectMongoDB connectMongoDB;

    public void setUp(){
        Properties properties=new Properties();
        properties.setProperty("host","localhost");
        properties.setProperty("port","27017");
        properties.setProperty("dbname","admin");
        properties.setProperty("login","root");
        properties.setProperty("password","root");
        properties.setProperty("genre","genre");
        properties.setProperty("film","film");
        properties.setProperty("producer","producer");
        this.connectMongoDB=new ConnectMongoDB(properties);
    }

    public static void main(String[]args)throws Exception{
        SpringApplication.run(Application.class,args);
    }
    @RequestMapping("/hello")
    public String showHello(Map<String,Object> model){
        List<Films> films=new ArrayList<>();
        Films films1=new Films();
        Film film1=new Film("Good day");
        Genre commedy=new Genre("commedy");
        Producer prod1=new Producer("David","James","Arquette");
        films1.setFilm(film1);
        films1.setGenre(commedy);
        films1.setProducer(prod1);
        films.add(films1);
        model.put("films",films);
        return "hello-world";
    }
}
