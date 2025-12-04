package com.viduk.st.component;

import java.util.ArrayList;
import java.util.List;

import com.viduk.st.exception.*;

public class TextComposite extends TextComponent{

	List<TextComponent> components = new ArrayList<>();
	
	public TextComposite(TextComponentType elementType) {
		super(elementType);
	}
	public void addComponent(TextComponent component) {
		components.add(component);
	}
	public TextComponent getComponent(int index) throws CustomException {
		if(index < 0 || index >= components.size()) {
			throw new CustomException("Index out of bounds for getComponent:" + index);
		}
		return components.get(index);
	}
	public List<TextComponent> getComponentList(){
		return components;
	}
	public void setComponent(int index, TextComponent component) throws CustomException {
		if(index < 0 || index >= components.size()) {
			throw new CustomException("Index out of bounds for setComponent:" + index);
		}
		components.set(index, component);
	}
	@Override
	public String printTextComponent() {
		StringBuilder builder = new StringBuilder();
		for(TextComponent component : components) {
			builder.append(component.toString());
		}
		return builder.toString();
	}
}