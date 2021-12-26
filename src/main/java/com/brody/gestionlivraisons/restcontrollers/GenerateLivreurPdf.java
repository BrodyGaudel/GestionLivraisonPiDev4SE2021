package com.brody.gestionlivraisons.restcontrollers;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.brody.gestionlivraisons.entities.Livraison;
import com.brody.gestionlivraisons.entities.Livreur;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

public class GenerateLivreurPdf {
	
	private static final Logger logger = LoggerFactory.getLogger(GenerateLivreurPdf.class);
	
	public static ByteArrayInputStream livreursReporte(List<Livreur> livreurs) {
		
		Document document = new Document();
        ByteArrayOutputStream out = new ByteArrayOutputStream();
		
        try {

            PdfPTable table = new PdfPTable(8);
            table.setWidthPercentage(100);
            //table.setWidths(new int[]{1, 3, 3,3,3,3,3,3});
            table.setWidths(new int[]{8, 8, 8,8,8,8,8,8});

            Font headFont = FontFactory.getFont(FontFactory.HELVETICA_BOLD);
            
           

            PdfPCell hcell;
            
            hcell = new PdfPCell(new Phrase("SALAIRE", headFont));
            hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
            table.addCell(hcell);
            
            hcell = new PdfPCell(new Phrase("MATRICULE", headFont));
            hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
            table.addCell(hcell);
            
            hcell = new PdfPCell(new Phrase("CIN", headFont));
            hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
            table.addCell(hcell);
            
            hcell = new PdfPCell(new Phrase("MOYEN_TRANSPORT", headFont));
            hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
            table.addCell(hcell);

            hcell = new PdfPCell(new Phrase("DISPONIBILITE", headFont));
            hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
            table.addCell(hcell);
            
            hcell = new PdfPCell(new Phrase("NOM", headFont));
            hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
            table.addCell(hcell);

            hcell = new PdfPCell(new Phrase("PRENOM", headFont));
            hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
            table.addCell(hcell);
            
            hcell = new PdfPCell(new Phrase("LIVRAISONS", headFont));
            hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
            table.addCell(hcell);
            
            
            
            for(Livreur b: livreurs) {
            	PdfPCell cell;
            	
            	cell = new PdfPCell(new Phrase(String.valueOf(b.getSalaire())));
                cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
                cell.setHorizontalAlignment(Element.ALIGN_CENTER);
                table.addCell(cell);

                cell = new PdfPCell(new Phrase(String.valueOf(b.getMatricule())));
                cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
                cell.setHorizontalAlignment(Element.ALIGN_CENTER);
                table.addCell(cell);

                cell = new PdfPCell(new Phrase((String.valueOf(b.getCin()))));
                cell.setPaddingLeft(5);
                cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
                cell.setHorizontalAlignment(Element.ALIGN_LEFT);
                table.addCell(cell);
                
                cell = new PdfPCell(new Phrase((String.valueOf(b.getMoyenTransport()))));
                cell.setPaddingLeft(5);
                cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
                cell.setHorizontalAlignment(Element.ALIGN_LEFT);
                table.addCell(cell);
                
                cell = new PdfPCell(new Phrase((String.valueOf(b.getDisponibility()))));
                cell.setPaddingLeft(5);
                cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
                cell.setHorizontalAlignment(Element.ALIGN_LEFT);
                table.addCell(cell);
                
                cell = new PdfPCell(new Phrase((String.valueOf(b.getNom()))));
                cell.setPaddingLeft(5);
                cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
                cell.setHorizontalAlignment(Element.ALIGN_LEFT);
                table.addCell(cell);
                
                
                cell = new PdfPCell(new Phrase((String.valueOf(b.getPrenom()))));
                cell.setPaddingLeft(5);
                cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
                cell.setHorizontalAlignment(Element.ALIGN_LEFT);
                table.addCell(cell);
                
                List<Long> listOfIdLivraisons = new ArrayList<Long>();
                List<Livraison> livraisons = new ArrayList<Livraison>();
                
                livraisons=b.getLivraisons();
                for(Livraison l :livraisons) {
                	listOfIdLivraisons.add(l.getIdLivraison());
                }
                cell = new PdfPCell(new Phrase((String.valueOf(listOfIdLivraisons))));
                cell.setPaddingLeft(5);
                cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
                cell.setHorizontalAlignment(Element.ALIGN_LEFT);
                table.addCell(cell);
            }
            PdfWriter.getInstance(document, out);
            document.open();
            document.add(table);

            document.close();
            
        }catch (DocumentException ex) {

            logger.error("Error occurred: {0}", ex);
        }
        return new ByteArrayInputStream(out.toByteArray());
		
	}

}
