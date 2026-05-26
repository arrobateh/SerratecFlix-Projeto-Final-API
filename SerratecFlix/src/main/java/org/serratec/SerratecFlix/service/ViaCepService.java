package org.serratec.SerratecFlix.service;

import org.serratec.SerratecFlix.dto.ViaCepDto;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class ViaCepService {

    public ViaCepDto buscarViaCep(String cep) {

        String url = "https://viacep.com.br/ws/" + cep + "/json/";

        RestTemplate restTemplate = new RestTemplate();

        return  restTemplate.getForObject(url, ViaCepDto.class);
    }
}
