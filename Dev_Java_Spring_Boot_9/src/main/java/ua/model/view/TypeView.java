package ua.model.view;

import ua.entity.Type;

public class TypeView {
	String type;

	public TypeView(Type type) {
		this.type = type.name();
	}
}
