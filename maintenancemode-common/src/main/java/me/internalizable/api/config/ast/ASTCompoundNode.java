package me.internalizable.api.config.ast;

import java.util.Map;

public class ASTCompoundNode extends ASTNode {

	private final Map<String, ASTNode> fields;

	public ASTCompoundNode( final String name, final Map<String, ASTNode> fields ) {
		super( name );
		this.fields = fields;
	}

	public ASTNode getField( String name ) {
		return this.fields.get( name );
	}

}
