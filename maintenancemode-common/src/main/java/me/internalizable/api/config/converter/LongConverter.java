package me.internalizable.api.config.converter;

public class LongConverter implements IValueConverter<Long> {

	@Override
	public String convert( Long value ) {
		return value.toString();
	}

	@Override
	public Long revert( String serialized ) {
		return Long.valueOf( serialized );
	}

}
