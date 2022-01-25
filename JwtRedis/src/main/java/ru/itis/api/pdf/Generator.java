package ru.itis.api.pdf;

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.PdfWriter;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

import java.io.*;
import java.util.Scanner;


public class Generator {
    private static final String PATH_FTLH = "src/main/resources/pdfGen.ftlh";

    public static void main(String[] args) {
        ConnectionFactory connectionFactory = new ConnectionFactory();
        connectionFactory.setHost("localhost");


        try {
            Scanner scanner = new Scanner(System.in);
            scanner.nextLine();
            Connection connection = connectionFactory.newConnection();
            Channel channel = connection.createChannel();
            channel.basicConsume("queue_1", true, (consumerTag, message) -> {
                String name = new String(message.getBody());
                try {
                    export(name);
                } catch ( DocumentException e) {
                    e.printStackTrace();
                }
            }, consumerTag -> {
            });

        } catch (Exception e) {
            throw new IllegalArgumentException(e);
        }

    }

    public static void export(String name) throws  DocumentException {
        double random = Math.random();
        String headerValue = "pdf_" + random + ".pdf";

        Document document = new Document(PageSize.A4);
        try {
            PdfWriter.getInstance(document, new FileOutputStream(headerValue));
        } catch (Exception e) {
            throw new IllegalArgumentException(e);
        }

        document.open();

        document.open();
        Font font = FontFactory.getFont(FontFactory.COURIER, 16, BaseColor.BLACK);
        Chunk chunk = new Chunk("Hello World", font);

        Paragraph firstName = new Paragraph(name, font);
        document.add(firstName);
        document.close();

    }
}

