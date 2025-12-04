package com.viduk.st.parser;

import com.viduk.st.component.TextComponent;

public abstract class AbstractParser {
  private AbstractParser nextParser;

  public AbstractParser(AbstractParser nextParser) {
    this.nextParser = nextParser;
  }

  public void setNextParser(AbstractParser nextParser) {
    this.nextParser = nextParser;
  }

  public AbstractParser getNextParser() {
    return nextParser;
  }

  public abstract TextComponent parse(String string);
}