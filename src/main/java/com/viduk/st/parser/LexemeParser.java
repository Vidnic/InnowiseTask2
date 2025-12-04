package com.viduk.st.parser;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.viduk.st.component.*;

public class LexemeParser extends AbstractParser {
    private static final String LEXEME_DELIMITER_REGEX = "\\p{Punct}+$";
    private static final Logger log = LogManager.getLogger();

    public LexemeParser(AbstractParser nextParser) {
        super(nextParser);
    }
    
    @Override
    public TextComponent parse(String string) {
        TextComposite lexeme = new TextComposite(TextComponentType.LEXEME);
        String wordPart = string.replaceAll(LEXEME_DELIMITER_REGEX, "");
        String punctuationPart = string.substring(wordPart.length());
        
        if (!wordPart.isEmpty()) {
            TextComponent wordComponent = getNextParser().parse(wordPart);
            lexeme.addComponent(wordComponent);
        }
        if (!punctuationPart.isEmpty()) {
            for (char ch : punctuationPart.toCharArray()) {
                TextComponent punctuationComponent = new TextLeaf(TextComponentType.PUNCTUATION, ch);
                lexeme.addComponent(punctuationComponent);
            }
        }
        log.info("Lexeme has been parsed");
        return lexeme;
    }
}