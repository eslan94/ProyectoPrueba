package com.taller.Controlador;

import com.taller.Servicio.PdfFacturaServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ControladorPdfFactura {
    @Autowired
    PdfFacturaServicio pdfFacturaServicio;

    @GetMapping("/carros/pdf")
    public ResponseEntity<byte[]> descargarPdf() throws Exception {
        byte[] pdf = pdfFacturaServicio.generarPdf();
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_PDF);
        headers.setContentDispositionFormData("attachment", "productos.pdf");
        return new ResponseEntity<>(pdf, headers, HttpStatus.OK);
    }
}
