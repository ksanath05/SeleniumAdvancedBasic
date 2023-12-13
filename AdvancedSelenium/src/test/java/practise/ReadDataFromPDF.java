package practise;

import java.io.File;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;

public class ReadDataFromPDF {

	public static void main(String[] args) throws Throwable {
		
		File fpdf = new File("./src/test/resources/Selenium-Cheat-Sheet-2022.pdf");
		
		PDDocument doc = new PDDocument().load(fpdf);
		
		int pages = doc.getNumberOfPages();

		System.out.println(pages);
		
		PDFTextStripper content = new PDFTextStripper();
		String entirepdf = content.getText(doc);
		
		System.out.println(entirepdf);
	}
	

}
