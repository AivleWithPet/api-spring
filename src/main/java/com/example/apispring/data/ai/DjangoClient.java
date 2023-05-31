package com.example.apispring.data.ai;

import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.util.Collections;

public class DjangoClient {
    public static void sendDataToDjango(String url, String json) {
        RestTemplate restTemplate = new RestTemplate();
        String csrfToken = DjangoCSRFTokenProvider.getCSRFToken("http://localhost:8000/ai/");

        // CSRF 토큰을 요청 헤더에 포함
        HttpHeaders headers = new HttpHeaders();
        // HTTP 요청 헤더 설정
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
        headers.add("X-CSRFToken", csrfToken);


        // JSON 데이터를 요청 본문에 포함
        RequestEntity<String> requestEntity = new RequestEntity<>(json, headers, HttpMethod.POST, URI.create(url));

        System.out.println("시작");
        // Django 서버에 POST 요청 전송
        ResponseEntity<String> response = restTemplate.exchange(requestEntity, String.class);
        System.out.println("종료");
        // 응답 확인
        if (response.getStatusCode().is2xxSuccessful()) {
            System.out.println("Data sent to Django successfully.");
        } else {
            System.out.println("Failed to send data to Django. Response: " + response.getBody());
        }
    }
}
