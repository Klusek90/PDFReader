
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripperByArea;

public class Main {
    public static void main(String[] args) throws Exception {
         PDDocument pdDocument = new PDDocument();

        JFrame frame = new JFrame("So Converter");
        frame.setSize(400, 200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);

        File pdfFile = new File("CTBReverse.pdf");

        pdDocument =pdDocument.load(pdfFile);
        System.out.println(pdDocument.getNumberOfPages());

        PDFTextStripperByArea stripper = new PDFTextStripperByArea();

        stripper.addRegion("oko", new Rectangle(50,50,50,50));
        stripper.extractRegions(pdDocument.getPage(0));
        System.out.println(stripper.getTextForRegion("oko"));




    }
}
