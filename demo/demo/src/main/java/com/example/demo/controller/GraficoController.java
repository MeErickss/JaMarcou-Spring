package com.example.demo.controller;

import org.knowm.xchart.BitmapEncoder;
import org.knowm.xchart.CategoryChart;
import org.knowm.xchart.CategoryChartBuilder;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.util.List;

@RestController
public class GraficoController {

    @GetMapping("/grafico/vendas.png")
    public ResponseEntity<byte[]> gerarGrafico() throws Exception {
        List<String> categorias = List.of("Jan", "Fev", "Mar");
        List<Integer> valores = List.of(10, 15, 8);

        CategoryChart chart = new CategoryChartBuilder()
                .width(800).height(600)
                .title("Vendas")
                .xAxisTitle("Mês")
                .yAxisTitle("Quantidade")
                .build();

        chart.addSeries("Serie A", categorias, valores);

        BufferedImage image = BitmapEncoder.getBufferedImage(chart);
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        ImageIO.write(image, "png", baos);

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.IMAGE_PNG);
        return ResponseEntity.ok().headers(headers).body(baos.toByteArray());
    }
}