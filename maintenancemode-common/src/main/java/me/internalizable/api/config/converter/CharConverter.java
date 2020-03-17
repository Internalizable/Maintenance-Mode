package me.internalizable.api.config.converter;

public class CharConverter implements IValueConverter<Character> {

	@Override
	public String convert( Character value ) {
		return value.toString();
	}

	@Override
	public Character revert( String serialized ) {
		return serialized.charAt( 0 );
	}

}
