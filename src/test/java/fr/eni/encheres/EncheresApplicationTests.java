package fr.eni.encheres;

import fr.eni.encheres.repository.ArticleRepositorySQL;
import fr.eni.encheres.repository.rowMapper.ArticleRowMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class EncheresApplicationTests {

    @Autowired
    ArticleRepositorySQL articleRepositorySQL;


    @Test
    void testReaAll() {
        articleRepositorySQL.readFullAll().forEach(System.out::println);
    }

}
