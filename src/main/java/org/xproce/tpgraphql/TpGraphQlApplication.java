package org.xproce.tpgraphql;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.xproce.tpgraphql.Dao.entities.Creator;
import org.xproce.tpgraphql.Dao.entities.Video;
import org.xproce.tpgraphql.Dao.repositories.Creatorepository;
import org.xproce.tpgraphql.Dao.repositories.Videorepository;

import java.time.LocalDate;
import java.util.List;

@SpringBootApplication
public class TpGraphQlApplication {

    public static void main(String[] args) {
        SpringApplication.run(TpGraphQlApplication.class, args);
    }
    @Bean
    CommandLineRunner start(Creatorepository creatorRepository, Videorepository videoRepository) {
        return args -> {
            List<Creator> creators = List.of(
                    Creator.builder().name("fati").email("fati@example.com").build(),
                    Creator.builder().name("doha").email("doha@example.com").build()
            );
            creatorRepository.saveAll(creators);

            List<Video> videos = List.of(
                    Video.builder().name("fudu world").url("https://example.com/java")
                            .description("An amazing life")
                            .datePublication(LocalDate.now())
                            .creator(creators.get(0))
                            .build(),
                    Video.builder().name("heeeyyyyyyyyyyyyy").url("https://example.com/springboot")
                            .description("o heyyyyyyyyy")
                            .datePublication(LocalDate.now().minusDays(1))
                            .creator(creators.get(1))
                            .build()
            );
            videoRepository.saveAll(videos);
        };

}}
