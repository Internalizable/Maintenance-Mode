package me.internalizable.config.converter;

public class IntegerConverter implements IValueConverter<Integer> {

	@Override
	public String convert( Integer value ) {
		return value.toString();
	}

	@Override
	public Integer revert( String serialized ) {
		return Integer.valueOf( serialized );
	}

}
