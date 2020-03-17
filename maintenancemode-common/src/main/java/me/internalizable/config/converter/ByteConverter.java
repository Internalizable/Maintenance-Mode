package me.internalizable.config.converter;

public class ByteConverter implements IValueConverter<Byte> {

	@Override
	public String convert( Byte value ) {
		return value.toString();
	}

	@Override
	public Byte revert( String serialized ) {
		return Byte.valueOf( serialized );
	}

}
