package com.viduk.st.reader;

import com.viduk.st.exception.CustomException;

public interface CustomReader {
	String readFile(String filepath) throws CustomException;
}
