package com.example.coletorDeDados.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.coletorDeDados.Entity.consultaDeDados;
import com.example.coletorDeDados.Repository.consultaDeDadosRepository;

@Service
public class consultaDeDadosService {

    @Autowired
    private consultaDeDadosRepository consultaRepository;

    public List<consultaDeDados> scrapeAndSaveData(String query) {
        try {
            List<consultaDeDados> videos = new ArrayList<>();

            Document document = Jsoup.connect("https://www.youtube.com/results?search_query=" + query).get();
            Elements videoElements = document.select("div#contents ytd-video-renderer");

            for (Element videoElement : videoElements) {
                consultaDeDados video = new consultaDeDados();
                video.setTitulo(videoElement.select("h3 a#video-title").text());
                video.setDescricao(videoElement.select("div#description-container").text());
                video.setTituloCanal(videoElement.select("ytd-channel-name a#avatar-link").text());

                videos.add(video);
            }

            // Salvar no repositório
            return consultaRepository.saveAll(videos);

            // Para resolver alguma excessão se necessário
        } catch (IOException e) {
            e.printStackTrace();

            return null;
        }

    }
}
