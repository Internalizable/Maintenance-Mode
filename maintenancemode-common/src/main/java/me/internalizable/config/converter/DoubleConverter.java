package me.internalizable.config.converter;

public class DoubleConverter implements IValueConverter<Double> {

	@Override
	public String convert( Double value ) {
		return value.toString();
	}

	@Override
	public Double revert( String serialized ) {
		return Double.valueOf( serialized );
	}

}
