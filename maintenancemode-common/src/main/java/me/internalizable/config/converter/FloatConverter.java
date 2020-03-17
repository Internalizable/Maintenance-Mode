package me.internalizable.config.converter;

public class FloatConverter implements IValueConverter<Float> {

	@Override
	public String convert( Float value ) {
		return value.toString();
	}

	@Override
	public Float revert( String serialized ) {
		return Float.valueOf( serialized );
	}

}
