package com.viduk.st.parser;

import com.viduk.st.component.TextComponent;

public abstract class AbstractTextParser {
  private AbstractTextParser nextParser;

  public AbstractTextParser(AbstractTextParser nextParser) {
    this.nextParser = nextParser;
  }

  public void setNextParser(AbstractTextParser nextParser) {
    this.nextParser = nextParser;
  }

  public AbstractTextParser getNextParser() {
    return nextParser;
  }

  public abstract TextComponent parse(String string);
}