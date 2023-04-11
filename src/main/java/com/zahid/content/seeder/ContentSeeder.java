package com.zahid.content.seeder;

import java.io.InputStream;
import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.javafaker.Faker;
import com.zahid.content.model.Content;
import com.zahid.content.model.ContentType;
import com.zahid.content.model.StatusType;
import com.zahid.content.repository.ContentRepository;
import com.zahid.content.service.ContentService;

import lombok.extern.log4j.Log4j2;

@Log4j2
@Component
public class ContentSeeder implements CommandLineRunner {

    @Autowired
    private ContentRepository contentRepository;

    @Autowired
    private ContentService contentService;

    @Autowired
    private ObjectMapper objectMapper;

    @Override
    public void run(String... args) throws Exception {
        // loadData();
        seedData();
        // throw new UnsupportedOperationException("Unimplemented method 'run'");
    }

    // seed data using json file
    private void seedData() {

        try (InputStream inputStream = TypeReference.class.getResourceAsStream("/data/content.json")) {
            contentRepository.saveAll(objectMapper.readValue(inputStream, new TypeReference<List<Content>>() {}));

        } catch (Exception e) {
            // TODO: handle exception
        }
    }

    // seed data using java faker
    public void loadData() {

        Faker faker = new Faker();
        // Random random = new Random();
        List<Content> contentList = contentService.getAllEntities();

        if (contentList.size() == 0) {
            ContentType[] typeList = ContentType.values();
            StatusType[] statusList = StatusType.values();

            for (int i = 0; i < 100; i++) {

                String title = faker.book().title(); // Miss Samanta Schmidt
                String description = faker.gameOfThrones().quote();

                ContentType type = typeList[new Random().nextInt(typeList.length)];
                StatusType status = statusList[new Random().nextInt(statusList.length)];

                String url = faker.internet().url();

                Content content = new Content(title, description, type, status, url);
                contentList.add(content);
            }
            contentRepository.saveAll(contentList);
        }

        log.info("Total Content(s): {}", contentList.size());
    }
}
