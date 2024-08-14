package com.taller.Servicio;

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import com.taller.Entidad.Carros;
import com.taller.Entidad.Factura;
import com.taller.Repositorio.CarrosRepositorio;
import com.taller.Repositorio.FacturaRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.List;

@Service
public class PdfFacturaServicio {
    @Autowired
    private CarrosRepositorio carrosRepositorio;

    public byte[] generarPdf() throws DocumentException, IOException {
        List<Carros> carro = carrosRepositorio.findAll();
        Document document = new Document();
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        PdfWriter.getInstance(document, baos);
        document.open();
        document.add(new Paragraph("Listado de Carros", FontFactory.getFont("Arial", 14, Font.BOLD)));
        PdfPTable table = new PdfPTable(5); // Cambiado de 3 a 5 columnas
        table.setWidthPercentage(100);
        table.addCell(new PdfPCell(new Phrase("Código", FontFactory.getFont("Arial", 12))));
        table.addCell(new PdfPCell(new Phrase("Modelo", FontFactory.getFont("Arial", 12))));
        table.addCell(new PdfPCell(new Phrase("Marca", FontFactory.getFont("Arial", 12))));
        table.addCell(new PdfPCell(new Phrase("Color", FontFactory.getFont("Arial", 12))));
        table.addCell(new PdfPCell(new Phrase("Descripcion", FontFactory.getFont("Arial", 12))));
        for (Carros carros : carro) {
            table.addCell(new PdfPCell(new Phrase(String.valueOf(carros.getId()), FontFactory.getFont("Arial", 12))));
            table.addCell(new PdfPCell(new Phrase(carros.getModelo(), FontFactory.getFont("Arial", 12))));
            table.addCell(new PdfPCell(new Phrase(carros.getMarca(), FontFactory.getFont("Arial", 12)))); // Agregado
            table.addCell(new PdfPCell(new Phrase(carros.getColor(), FontFactory.getFont("Arial", 12))));
            table.addCell(new PdfPCell(new Phrase(carros.getDescripcion(), FontFactory.getFont("Arial", 12))));
        }
        document.add(table);
        document.close();
        return baos.toByteArray();
    }
}
