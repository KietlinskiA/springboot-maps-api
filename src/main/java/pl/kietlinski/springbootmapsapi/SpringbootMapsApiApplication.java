package pl.kietlinski.springbootmapsapi;


import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import pl.kietlinski.springbootmapsapi.dto.ResultDTO;
import pl.kietlinski.springbootmapsapi.model.location.Result;

@SpringBootApplication
public class SpringbootMapsApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootMapsApiApplication.class, args);
    }

    @Bean
    public ModelMapper getModelMapper(){
        ModelMapper modelMapper = new ModelMapper();

        modelMapper.addMappings(new PropertyMap<Result, ResultDTO>() {
            @Override
            protected void configure() {
                map().setIcon(source.getIcon());
                map().setName(source.getName());
                map().setRating(source.getRating());
                map().setVicinity(source.getVicinity());
            }
        });

        return modelMapper;
    }
}
