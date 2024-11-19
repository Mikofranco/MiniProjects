package BarcodeScanner;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.oned.Code128Writer;

import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Path;

public class BarcodeGenerator {
    public static void main(String[] args) {
        String productCode = "PROD12345";
        String brand = "Bling  Cleaner";
        String name = "NGA";

        String productDetails = productCode + "|" + brand ;
        String filePath = "barcode.png";

        try {
            Code128Writer barcodeWriter = new Code128Writer();
            BitMatrix bitMatrix = barcodeWriter.encode(productDetails, BarcodeFormat.CODE_128, 400, 100);

            Path path = FileSystems.getDefault().getPath(filePath);
            MatrixToImageWriter.writeToPath(bitMatrix, "PNG", path);

            System.out.println("Barcode generated at " + filePath);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
