package com.nonave.sharebook.bussines.handler;

import java.io.*;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.xhtmlrenderer.extend.FontResolver;
import org.xhtmlrenderer.pdf.ITextRenderer;

public class HtmlToPdf {


	private static String htmlToXhtml(String html) {
		Document document = Jsoup.parse(html);
		document.outputSettings().syntax(Document.OutputSettings.Syntax.xml);
		return document.html();
	}

	private static OutputStream xhtmlToPdf(String xhtml, String outFileName) throws IOException {
		File output = new File(outFileName);
		ITextRenderer iTextRenderer = new ITextRenderer();
		// FontResolver resolver = iTextRenderer.getFontResolver();
		// iTextRenderer.getFontResolver().addFont("MyFont.ttf", true);
		iTextRenderer.setDocumentFromString(xhtml);
		iTextRenderer.layout();
		OutputStream os = new FileOutputStream(output);
		iTextRenderer.createPDF(os);
		os.close();
		return os;
	}
	
	
	public static void main(String[] args) throws IOException {
		String html = "<h1>hello</h1>";
		String xhtml = htmlToXhtml(html);
		System.out.println(xhtmlToPdf(xhtml, "output.pdf"));
	}
	
}