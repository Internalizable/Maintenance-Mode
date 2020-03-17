package me.internalizable.config.converter;

public class ShortConverter implements IValueConverter<Short> {

	@Override
	public String convert( Short value ) {
		return value.toString();
	}

	@Override
	public Short revert( String serialized ) {
		return Short.valueOf( serialized );
	}

}
