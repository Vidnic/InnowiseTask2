package com.viduk.st.parser;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.viduk.st.component.*;

public class SentenceParser extends AbstractParser {
    private static final Logger log = LogManager.getLogger();
    private static final String SENTENCE_DELIMITER_REGEX = "\\s+";
    
    public SentenceParser(AbstractParser nextParser) {
        super(nextParser);
    }
    @Override
    public TextComponent parse(String sentence) {
        TextComposite sentenceComposite = new TextComposite(TextComponentType.SENTENCE);
        String[] lexemes = sentence.split(SENTENCE_DELIMITER_REGEX);
        for (String lexeme : lexemes) {
            if (!lexeme.trim().isEmpty()) {
                TextComponent lexemeComponent = getNextParser().parse(lexeme.trim());
                sentenceComposite.addComponent(lexemeComponent);
            }
        }
        log.info("Sentence has been parsed");
        return sentenceComposite;
    }
}