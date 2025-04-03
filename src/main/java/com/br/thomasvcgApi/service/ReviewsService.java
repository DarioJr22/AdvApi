package com.br.thomasvcgApi.service;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class ReviewsService {


    public Object getGoogleProfile(){
        // URL da solicitação
        String url = "https://maps.googleapis.com/maps/api/place/details/json?place_id=ChIJLaOg3Tc9qwcRTemoMuGJ6Rc&fields=reviews&language=pt-BR&key=AIzaSyCi1vkD3KyBMcanxRMCLCJvYBam67D1hWE";

        // Configurar o RestTemplate
        RestTemplate restTemplate = new RestTemplateBuilder().build();

        // Fazer a solicitação
        ResponseEntity<String> response = restTemplate.getForEntity(url, String.class);
        System.out.println(response);
        // Exibir a resposta
        return response;
    }


}
