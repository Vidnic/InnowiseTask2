package com.viduk.st.parser;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.viduk.st.component.*;

public class ParagraphParser extends AbstractParser{
	private static final Logger log = LogManager.getLogger();
	private static final String PARAGRAPH_DELIMITER_REGEX = "(?<=[.!?])\\s+";
	
	public ParagraphParser(AbstractParser nextParser) {
    super(nextParser);
  }
	@Override
	public TextComposite parse(String paragraph) {
		TextComposite result = new TextComposite(TextComponentType.PARAGRAPH);
		String[] sentences = paragraph.split(PARAGRAPH_DELIMITER_REGEX);
		for(String sentence : sentences) {
			TextComponent sentenceComponent = getNextParser().parse(sentence);
			result.addComponent(sentenceComponent);
		}
		log.info("Text has been parsed");
		return result;
	}
}