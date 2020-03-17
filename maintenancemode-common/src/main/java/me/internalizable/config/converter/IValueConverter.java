package me.internalizable.config.converter;

public interface IValueConverter<T> {

	/**
	 * Converts the specified value to a string.
	 *
	 * @param value The value to convert.
	 *
	 * @return The converted value.
	 */
	String convert(T value) throws ConversionException;

	/**
	 * Reverts the conversion process.
	 *
	 * @param serialized The serialized string of the object.
	 *
	 * @return The de-serialized object.
	 */
	T revert(String serialized) throws ReversionException;

}
