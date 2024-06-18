package jay.tdd_practice;

import jakarta.persistence.EntityManager;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;
import org.testcontainers.containers.MariaDBContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
@Testcontainers
public class MariaDbTest {

    @Autowired
    MemberRepository memberRepository;

    @Autowired
    EntityManager em;

    @Container
    public static MariaDBContainer<?> mariaDBContainer = new MariaDBContainer<>("mariadb:latest")
            .withDatabaseName("testdb")
            .withUsername("test")
            .withPassword("test");

    @Test
    public void testDatabaseConnection() throws Exception {
        String jdbcUrl = mariaDBContainer.getJdbcUrl();
        String username = mariaDBContainer.getUsername();
        String password = mariaDBContainer.getPassword();

        // Use jdbcUrl, username, and password to connect to the database and perform tests
        // Example: try (Connection connection = DriverManager.getConnection(jdbcUrl, username, password)) { ... }
        try (Connection connection = DriverManager.getConnection(jdbcUrl, username, password)) {
            try (Statement statement = connection.createStatement()) {
                ResultSet resultSet = statement.executeQuery("SELECT 1");
                assertTrue(resultSet.next());
            }
        }

        // Simple assertion to check if container is running
        assertTrue(mariaDBContainer.isRunning());
    }

    @Test
    @Transactional
    public void 기본_데이터_저장() throws Exception {
        assertTrue(mariaDBContainer.isRunning());

        Member member = new Member("jay", "email");

        em.persist(member);
        em.flush();

        List<Member> members = memberRepository.findAllMembers();

        assertEquals(1, members.size());

    }


}