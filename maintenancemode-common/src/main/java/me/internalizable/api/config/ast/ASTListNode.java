package me.internalizable.api.config.ast;

import java.util.Iterator;
import java.util.List;


public class ASTListNode extends ASTNode implements Iterable<ASTNode> {

	private final List<ASTNode> elements;

	public ASTListNode( final String name, final List<ASTNode> elements ) {
		super( name );
		this.elements = elements;
	}

	@Override
	public Iterator<ASTNode> iterator() {
		return this.elements.iterator();
	}

	public int size() {
		return this.elements.size();
	}

}
