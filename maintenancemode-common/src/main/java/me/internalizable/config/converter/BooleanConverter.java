
package me.internalizable.config.converter;


public class BooleanConverter implements IValueConverter<Boolean> {

	@Override
	public String convert( Boolean value ) {
		return value.toString();
	}

	@Override
	public Boolean revert( String serialized ) {
		return Boolean.valueOf( serialized );
	}

}
