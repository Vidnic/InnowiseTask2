package com.viduk.st.component;

public abstract class TextComponent {
		private TextComponentType componentType;
		
		public TextComponent(TextComponentType componentType) {
			this.componentType = componentType;
		}
		
		public TextComponentType getElementType() {
			return componentType;
		}
		
		public void setElementType(TextComponentType elementType) {
			this.componentType = elementType;
		}
		
		public abstract String printTextComponent();
}