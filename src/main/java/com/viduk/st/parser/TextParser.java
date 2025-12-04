package com.viduk.st.parser;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.viduk.st.component.*;

public class TextParser extends AbstractParser{
  private static final Logger log = LogManager.getLogger();
  private static final String TEXT_DELIMITER_REGEX = "\\n+";

  public TextParser(AbstractParser nextParser) {
    super(nextParser);
  }
  @Override
  public TextComposite parse(String string) {
    TextComposite text = new TextComposite(TextComponentType.TEXT);
    String[] paragraphs = string.split(TEXT_DELIMITER_REGEX);
    for(String paragraph : paragraphs){
      TextComponent paragraphComponent = getNextParser().parse(paragraph);
      text.addComponent(paragraphComponent);
    }
    log.info("Text has been parsed");
    return text;
  }
}