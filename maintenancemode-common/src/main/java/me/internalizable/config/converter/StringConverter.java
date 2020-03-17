package me.internalizable.config.converter;

public class StringConverter implements IValueConverter<String> {

	@Override
	public String convert( String value ) {
		return "\"" + value + "\"";
	}

	@Override
	public String revert( String serialized ) {
		return serialized;
	}
}
