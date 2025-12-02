package com.viduk.st.component;

public class TextLeaf extends TextComponent{
		private char leaf;
		
		public TextLeaf(TextComponentType componentType, char leaf) {
			super(componentType);
			this.leaf = leaf;
		}
		@Override
		public String printTextComponent() {
			return String.valueOf(leaf);
		}
}