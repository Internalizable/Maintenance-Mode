package me.internalizable.api.config.ast;

import lombok.Getter;

@Getter
public class ASTValueNode extends ASTNode {

	private final String value;

	public ASTValueNode( final String name, final String value ) {
		super( name );
		this.value = value;
	}

}
