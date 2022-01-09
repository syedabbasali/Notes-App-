package com.esc.practice.apps.notes;

import java.util.Arrays;

import org.dozer.DozerBeanMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;

@SpringBootApplication(scanBasePackages = { "com.esc.practice.apps.notes.web", "com.esc.practice.apps.notes.service",
		"com.esc.practice.apps.notes.service.*", "com.esc.practice.apps.notes.dao",
		"com.esc.practice.apps.notes.dao.*" })
@OpenAPIDefinition(info = @Info(title = "Notes Application API", version = "1.0", description = "CRUD operations for Notes. \r\n1. createNotesApi:\n" + 
		"	'body' is mandatory. \n" + 
		"	But if you send attachment then please fill all the attachment related fields, or fill none of them.\n" + 
		"	And before sending the attchment extract the byteArray of the content, the original name of the attachment(e.g. syed_resume.pdf) and the content type(e.g. application/pdf). Encode the attachment content to string with the help of Base64 library. And then fill the respective fields( 'attachment', 'attachmentName', 'attachmentType').\n" + 
		"\n" + 
		"2. updateNotesApi:\n" + 
		"	'notesId', 'body' are mandatory.\n" + 
		"\n" + 
		"3. getNotesApi:\n" + 
		"	This API does not contain any mandatory field. If you dont fill any field(Just instantiate the class and send, don't set any value) then it will give you all the records. But if you want to add any specific filter please set those fields. \n" + 
		"	\n" + 
		"4. deleteNotesApi:\n" + 
		"	'notesId' is mandatory."))
public class NotesAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(NotesAppApplication.class, args);
	}

	@Bean
	public DozerBeanMapper createDozerBean() {
		DozerBeanMapper dozer = new DozerBeanMapper();
		dozer.setMappingFiles(Arrays.asList("dozerBeanMapping.xml"));
		return dozer;
	}

}
