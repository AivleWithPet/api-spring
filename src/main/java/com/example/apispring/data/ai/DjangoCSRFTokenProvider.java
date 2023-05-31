package com.example.apispring.data.ai;
import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;
import java.net.URI;
public class DjangoCSRFTokenProvider {
    public static String getCSRFToken(String csrfTokenUrl) {
        RestTemplate restTemplate = new RestTemplate();

        HttpHeaders headers = restTemplate.headForHeaders(csrfTokenUrl);

        String csrfToken = headers.getFirst(HttpHeaders.SET_COOKIE);

        return csrfToken;
    }
}
//        // CSRF 토큰을 가져올 엔드포인트 URL
//        URI csrfTokenUri = URI.create(csrfTokenUrl);
//
//        // GET 요청을 통해 CSRF 토큰을 얻음
//        RequestEntity<Void> requestEntity = new RequestEntity<>(HttpMethod.GET, csrfTokenUri);
//
//        ResponseEntity<Void> responseEntity = restTemplate.exchange(requestEntity, Void.class);
//        // 응답 헤더에서 CSRF 토큰 값을 추출
//        String csrfToken = responseEntity.getHeaders().getFirst("X-CSRFToken");
