package com.viduk.st.reader.Impl;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.nio.file.*;

import com.viduk.st.exception.CustomException;
import com.viduk.st.reader.*;

public class CustomReaderImpl implements CustomReader {

	private static final Logger log = LogManager.getLogger();
	
	public String readFile(String filepath) throws CustomException {
		String readedFile;
		Path path = Paths.get(filepath);
		if(!Files.exists(path)) {
			log.log(Level.ERROR, "input File doesn't exist" + filepath);
			throw new CustomException("File doesn't exsists" + filepath);
		}
		try{
			readedFile = Files.readString(path);
		}
		catch(IOException e) {
			log.log(Level.ERROR, "input File error", e);
			throw new CustomException("File error", e);
		}
		log.log(Level.INFO, "File successfully readed");
		return readedFile;	
	}
}
