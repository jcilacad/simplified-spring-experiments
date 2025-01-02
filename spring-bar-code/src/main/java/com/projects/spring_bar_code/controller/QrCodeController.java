package com.projects.spring_bar_code.controller;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.datamatrix.DataMatrixWriter;
import com.google.zxing.pdf417.PDF417Writer;
import com.google.zxing.pdf417.encoder.PDF417;
import com.google.zxing.qrcode.QRCodeWriter;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.awt.image.BufferedImage;

@RestController
@RequestMapping("/api/v1/qr")
public class QrCodeController {

    @GetMapping(value = "/{barcode}", produces = MediaType.IMAGE_PNG_VALUE)
    public ResponseEntity<BufferedImage> barbecueEAN13Barcode(@PathVariable String barcode) throws Exception {
        QRCodeWriter qrCodeWriter = new QRCodeWriter();
        BitMatrix bitMatrix = qrCodeWriter.encode(barcode, BarcodeFormat.QR_CODE, 200, 200);

//        DataMatrixWriter dataMatrixWriter = new DataMatrixWriter();
//        BitMatrix bitMatrix = dataMatrixWriter.encode(barcode, BarcodeFormat.DATA_MATRIX, 200, 200);

//        PDF417Writer pdf417Writer = new PDF417Writer();
//        BitMatrix bitMatrix = pdf417Writer.encode(barcode, BarcodeFormat.PDF_417, 200, 200);

        return ResponseEntity.ok(MatrixToImageWriter.toBufferedImage(bitMatrix));
    }
}
