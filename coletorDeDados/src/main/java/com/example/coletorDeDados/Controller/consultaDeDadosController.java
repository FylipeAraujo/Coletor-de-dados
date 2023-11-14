package com.example.coletorDeDados.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.coletorDeDados.Entity.consultaDeDados;
import com.example.coletorDeDados.Service.consultaDeDadosService;

@RestController
public class consultaDeDadosController {

    @Autowired
    private consultaDeDadosService videosService;

    // Rotas
    @GetMapping("/search-youtube")
    public List<consultaDeDados> searchYoutube(@RequestParam String query) {
        return videosService.scrapeAndSaveData(query);
    }

}
