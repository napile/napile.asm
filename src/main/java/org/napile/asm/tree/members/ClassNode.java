/***
 * ASM: a very small and fast Java bytecode manipulation framework
 * Copyright (c) 2000-2011 INRIA, France Telecom
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions
 * are met:
 * 1. Redistributions of source code must retain the above copyright
 *    notice, this list of conditions and the following disclaimer.
 * 2. Redistributions in binary form must reproduce the above copyright
 *    notice, this list of conditions and the following disclaimer in the
 *    documentation and/or other materials provided with the distribution.
 * 3. Neither the name of the copyright holders nor the names of its
 *    contributors may be used to endorse or promote products derived from
 *    this software without specific prior written permission.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS"
 * AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE
 * IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE
 * ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT OWNER OR CONTRIBUTORS BE
 * LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR
 * CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF
 * SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS
 * INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN
 * CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE)
 * ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF
 * THE POSSIBILITY OF SUCH DAMAGE.
 */
package org.napile.asm.tree.members;

import java.util.ArrayList;
import java.util.List;

import org.jetbrains.annotations.NotNull;
import org.napile.asm.AnnotationVisitor;
import org.napile.asm.Attribute;
import org.napile.asm.tree.OldAnnotationNode;
import org.napile.asm.tree.members.types.ClassTypeNode;
import org.napile.asmNew.Modifier;
import org.napile.asmNew.visitors.AsmVisitor;
import org.napile.compiler.lang.resolve.name.FqName;

/**
 * A node that represents a class.
 *
 * @author Eric Bruneton
 * @author VISTALL
 */
public class ClassNode extends AbstractMemberNode<ClassNode>
{
	/**
	 * The internal name of the class (see
	 * {@link org.napile.asm.Type#getInternalName() getInternalName}).
	 */
	public final FqName name;

	/**
	 * The name of the source file from which this class was compiled. May be
	 * <tt>null</tt>.
	 */
	public String sourceFile;

	/**
	 * Debug information to compute the correspondance between source and
	 * compiled elements of the class. May be <tt>null</tt>.
	 */
	public String sourceDebug;

	/**
	 * The internal name of the enclosing class of the class. May be
	 * <tt>null</tt>.
	 */
	public String outerClass;

	/**
	 * The name of the method that contains the class, or <tt>null</tt> if the
	 * class is not enclosed in a method.
	 */
	public String outerMethod;

	/**
	 * The descriptor of the method that contains the class, or <tt>null</tt>
	 * if the class is not enclosed in a method.
	 */
	public String outerMethodDesc;

	/**
	 * The runtime visible annotations of this class. This list is a list of
	 * {@link org.napile.asm.tree.OldAnnotationNode} objects. May be <tt>null</tt>.
	 *
	 * @associates OldAnnotationNode
	 * @label visible
	 */
	public List<OldAnnotationNode> visibleAnnotations;

	/**
	 * The runtime invisible annotations of this class. This list is a list of
	 * {@link org.napile.asm.tree.OldAnnotationNode} objects. May be <tt>null</tt>.
	 *
	 * @associates OldAnnotationNode
	 * @label invisible
	 */
	public List<OldAnnotationNode> invisibleAnnotations;

	/**
	 * The non standard attributes of this class. This list is a list of
	 * {@link Attribute} objects. May be <tt>null</tt>.
	 *
	 * @associates Attribute
	 */
	public List<Attribute> attrs;

	@NotNull
	public List<AbstractMemberNode> members = new ArrayList<AbstractMemberNode>();

	@NotNull
	public final List<ClassTypeNode> supers = new ArrayList<ClassTypeNode>(1);

	public ClassNode(@NotNull Modifier[] modifiers, @NotNull FqName fqName)
	{
		super(modifiers);

		this.name = fqName;
	}

	public ClassNode visitSuper(@NotNull String s)
	{
		return visitSuper(new ClassTypeNode(new FqName(s)));
	}

	public ClassNode visitSuper(@NotNull FqName fqName)
	{
		return visitSuper(new ClassTypeNode(fqName));
	}

	public ClassNode visitSuper(@NotNull ClassTypeNode typeNode)
	{
		supers.add(typeNode);
		return this;
	}

	public void visitSource(final String file, final String debug)
	{
		sourceFile = file;
		sourceDebug = debug;
	}

	public void visitOuterClass(final String owner, final String name, final String desc)
	{
		outerClass = owner;
		outerMethod = name;
		outerMethodDesc = desc;
	}

	public AnnotationVisitor visitAnnotation(final String desc, final boolean visible)
	{
		OldAnnotationNode an = new OldAnnotationNode(desc);
		if(visible)
		{
			if(visibleAnnotations == null)
			{
				visibleAnnotations = new ArrayList<OldAnnotationNode>(1);
			}
			visibleAnnotations.add(an);
		}
		else
		{
			if(invisibleAnnotations == null)
			{
				invisibleAnnotations = new ArrayList<OldAnnotationNode>(1);
			}
			invisibleAnnotations.add(an);
		}
		return an;
	}

	public void visitAttribute(final Attribute attr)
	{
		if(attrs == null)
		{
			attrs = new ArrayList<Attribute>(1);
		}
		attrs.add(attr);
	}

	public void visitEnd()
	{
	}

	// ------------------------------------------------------------------------
	// Accept method
	// ------------------------------------------------------------------------

	@Override
	public <T> void accept(@org.jetbrains.annotations.NotNull final AsmVisitor<T> asmVisitor, T a2)
	{
		asmVisitor.visitClassNode(this, a2);
	}
}
