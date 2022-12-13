package org.ResumerApp.api.word;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.ResumerApp.api.PersonalDetails.PersonalDetailsRepo;
import org.ResumerApp.api.PersonalDetails.PersonalDetailsService;
import org.ResumerApp.api.languages.LanguagesRepo;
import org.ResumerApp.api.languages.LanguagesService;
import org.apache.poi.xwpf.usermodel.ParagraphAlignment;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigureOrder;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.exc.InvalidFormatException;

@Component
public class helper {

	@Autowired
	private LanguagesRepo languagesRepo;
	
	@Autowired
	private LanguagesService languagesService;
	
	@Autowired
	private PersonalDetailsService personalDetailsService;
	
	@Autowired
	private PersonalDetailsRepo personalDetailsRepo;
	
	
	public ByteArrayInputStream generateWord() throws FileNotFoundException , IOException , InvalidFormatException
	{
		try(XWPFDocument doc = new XWPFDocument())
		{
			XWPFParagraph p1 = doc.createParagraph();
			p1.setAlignment(ParagraphAlignment.CENTER);
			
			XWPFRun r1 = p1.createRun();
			r1.setText(personalDetailsService.getPersonalDetails(1L));
			
			ByteArrayOutputStream b = new ByteArrayOutputStream();
			doc.write(b);
			return new ByteArrayInputStream(b.toByteArray());
		}
	}
}
