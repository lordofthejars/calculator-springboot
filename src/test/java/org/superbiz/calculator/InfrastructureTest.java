package org.superbiz.calculator;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class InfrastructureTest {

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    public void should_deploy_correctly_application() {

        // given
        // when
        final ResponseEntity<String> response = restTemplate.getForEntity("/healthz", String.class);

        // then
        assertThat(response).returns(200, ResponseEntity::getStatusCodeValue);
    }

}
