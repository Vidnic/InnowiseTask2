package com.viduk.st.parser;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.viduk.st.component.*;

public class WordParser extends AbstractParser {
    private static final Logger log = LogManager.getLogger();
    
    public WordParser(AbstractParser nextParser) {
        super(nextParser);
    }
    @Override
    public TextComponent parse(String word) {
        TextComposite wordComposite = new TextComposite(TextComponentType.WORD);
        
        for (char ch : word.toCharArray()) {
            TextComponent letterComponent = new TextLeaf(TextComponentType.WORD, ch);
            wordComposite.addComponent(letterComponent);
        }
        
        log.info("Word has been parsed");
        return wordComposite;
    }
}