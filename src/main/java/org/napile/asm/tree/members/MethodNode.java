/***
 * ASM: a very small and fast Java bytecode manipulation framework
 * Copyright (c) 2000-2011 INRIA, France Telecom
 * Copyright (c) 2011 Google
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
import org.napile.asm.Handle;
import org.napile.asm.Label;
import org.napile.asm.MethodVisitor;
import org.napile.asm.Opcodes;
import org.napile.asm.Type;
import org.napile.asm.tree.*;
import org.napile.asm.tree.members.bytecode.Instruction;
import org.napile.asm.tree.members.types.TypeNode;
import org.napile.asmNew.Modifier;
import org.napile.asmNew.visitors.AsmVisitor;
import com.intellij.util.ArrayUtil;

/**
 * A node that represents a method.
 *
 * @author Eric Bruneton
 */
public class MethodNode extends AbstractMemberNode<MethodNode>
{
	/**
	 * The method's name.
	 */
	public String name;

	/**
	 * Return type of method
	 */
	public TypeNode returnType;

	/**
	 * Parameters of method
	 */
	@NotNull
	public List<MethodParameterNode> parameters = new ArrayList<MethodParameterNode>(0);

	/**
	 * Code instruction
	 */
	@NotNull
	public List<Instruction> instructions = new ArrayList<Instruction>(0);

	/**
	 * The non standard attributes of this method. This list is a list of
	 * {@link Attribute} objects. May be <tt>null</tt>.
	 *
	 * @associates Attribute
	 */
	public List<Attribute> attrs;

	/**
	 * The default value of this annotation interface method. This field must be
	 * a {@link Byte}, {@link Boolean}, {@link Character}, {@link Short},
	 * {@link Integer}, {@link Long}, {@link Float}, {@link Double},
	 * {@link String} or {@link Type}, or an two elements String array (for
	 * enumeration values), a {@link org.napile.asm.tree.OldAnnotationNode}, or a {@link List} of
	 * values of one of the preceding types. May be <tt>null</tt>.
	 */
	public Object annotationDefault;


	/**
	 * The instructions of this method. This list is a list of
	 * {@link org.napile.asm.tree.AbstractInsnNode} objects.
	 *
	 * @associates AbstractInsnNode
	 * @label instructions
	 */
	public InsnList instructions0;

	/**
	 * The try catch blocks of this method. This list is a list of
	 * {@link org.napile.asm.tree.TryCatchBlockNode} objects.
	 *
	 * @associates TryCatchBlockNode
	 */
	public List<TryCatchBlockNode> tryCatchBlocks;

	/**
	 * The maximum stack size of this method.
	 */
	public int maxStack;

	/**
	 * The maximum number of local variables of this method.
	 */
	public int maxLocals;

	/**
	 * The local variables of this method. This list is a list of
	 * {@link org.napile.asm.tree.LocalVariableNode} objects. May be <tt>null</tt>
	 *
	 * @associates LocalVariableNode
	 */
	public List<LocalVariableNode> localVariables;

	/**
	 * If the accept method has been called on this object.
	 */
	private boolean visited;

	/**
	 * Constructs a new {@link MethodNode}.
	 *
	 * @param name       the method's nam
	 *  (see {@link org.napile.asm.Type#getInternalName() getInternalName}). May be
	 */
	public MethodNode(@NotNull final Modifier[] modifiers, @NotNull String name)
	{
		super(modifiers);
		this.name = name;

		if(!ArrayUtil.contains(modifiers, Modifier.ABSTRACT))
			this.localVariables = new ArrayList<LocalVariableNode>(5);
		this.tryCatchBlocks = new ArrayList<TryCatchBlockNode>();

		this.instructions0 = new InsnList();
	}

	// ------------------------------------------------------------------------
	// Implementation of the MethodVisitor abstract class
	// ------------------------------------------------------------------------
	public AnnotationVisitor visitAnnotationDefault()
	{
		return new OldAnnotationNode(new ArrayList<Object>(0)
		{
			@Override
			public boolean add(final Object o)
			{
				annotationDefault = o;
				return super.add(o);
			}
		});
	}

	public void visitAttribute(final Attribute attr)
	{
		if(attrs == null)
		{
			attrs = new ArrayList<Attribute>(1);
		}
		attrs.add(attr);
	}

	public void visitCode()
	{
	}

	public void visitFrame(final int type, final int nLocal, final Object[] local, final int nStack, final Object[] stack)
	{
		instructions0.add(new FrameNode(type, nLocal, local == null ? null : getLabelNodes(local), nStack, stack == null ? null : getLabelNodes(stack)));
	}

	public void visitInsn(final int opcode)
	{
		instructions0.add(new InsnNode(opcode));
	}

	public void visitIntInsn(final int opcode, final int operand)
	{
		instructions0.add(new IntInsnNode(opcode, operand));
	}

	public void visitVarInsn(final int opcode, final int var)
	{
		instructions0.add(new VarInsnNode(opcode, var));
	}

	public void visitTypeInsn(final int opcode, final String type)
	{
		instructions0.add(new TypeInsnNode(opcode, type));
	}

	public void visitFieldInsn(final int opcode, final String owner, final String name, final String desc)
	{
		instructions0.add(new FieldInsnNode(opcode, owner, name, desc));
	}

	public void visitMethodInsn(final int opcode, final String owner, final String name, final String desc)
	{
		instructions0.add(new MethodInsnNode(opcode, owner, name, desc));
	}

	public void visitInvokeDynamicInsn(String name, String desc, Handle bsm, Object... bsmArgs)
	{
		instructions0.add(new InvokeDynamicInsnNode(name, desc, bsm, bsmArgs));
	}

	public void visitJumpInsn(final int opcode, final Label label)
	{
		instructions0.add(new JumpInsnNode(opcode, getLabelNode(label)));
	}

	public void visitLabel(final Label label)
	{
		instructions0.add(getLabelNode(label));
	}

	public void visitLdcInsn(final Object cst)
	{
		instructions0.add(new LdcInsnNode(cst));
	}

	public void visitIincInsn(final int var, final int increment)
	{
		instructions0.add(new IincInsnNode(var, increment));
	}

	public void visitTableSwitchInsn(final int min, final int max, final Label dflt, final Label... labels)
	{
		instructions0.add(new TableSwitchInsnNode(min, max, getLabelNode(dflt), getLabelNodes(labels)));
	}

	public void visitLookupSwitchInsn(final Label dflt, final int[] keys, final Label[] labels)
	{
		instructions0.add(new LookupSwitchInsnNode(getLabelNode(dflt), keys, getLabelNodes(labels)));
	}

	public void visitMultiANewArrayInsn(final String desc, final int dims)
	{
		instructions0.add(new MultiANewArrayInsnNode(desc, dims));
	}

	public void visitTryCatchBlock(final Label start, final Label end, final Label handler, final String type)
	{
		tryCatchBlocks.add(new TryCatchBlockNode(getLabelNode(start), getLabelNode(end), getLabelNode(handler), type));
	}

	public void visitLocalVariable(final String name, final String desc, final String signature, final Label start, final Label end, final int index)
	{
		localVariables.add(new LocalVariableNode(name, desc, signature, getLabelNode(start), getLabelNode(end), index));
	}

	public void visitLineNumber(final int line, final Label start)
	{
		instructions0.add(new LineNumberNode(line, getLabelNode(start)));
	}

	public void visitMaxs(final int maxStack, final int maxLocals)
	{
		this.maxStack = maxStack;
		this.maxLocals = maxLocals;
	}

	public void visitEnd()
	{
	}

	/**
	 * Returns the LabelNode corresponding to the given Label. Creates a new
	 * LabelNode if necessary. The default implementation of this method uses
	 * the {@link Label#info} field to store associations between labels and
	 * label nodes.
	 *
	 * @param l a Label.
	 * @return the LabelNode corresponding to l.
	 */
	protected LabelNode getLabelNode(final Label l)
	{
		if(!(l.info instanceof LabelNode))
		{
			l.info = new LabelNode(l);
		}
		return (LabelNode) l.info;
	}

	private LabelNode[] getLabelNodes(final Label[] l)
	{
		LabelNode[] nodes = new LabelNode[l.length];
		for(int i = 0; i < l.length; ++i)
		{
			nodes[i] = getLabelNode(l[i]);
		}
		return nodes;
	}

	private Object[] getLabelNodes(final Object[] objs)
	{
		Object[] nodes = new Object[objs.length];
		for(int i = 0; i < objs.length; ++i)
		{
			Object o = objs[i];
			if(o instanceof Label)
			{
				o = getLabelNode((Label) o);
			}
			nodes[i] = o;
		}
		return nodes;
	}

	// ------------------------------------------------------------------------
	// Accept method
	// ------------------------------------------------------------------------

	/**
	 * Checks that this method node is compatible with the given ASM API
	 * version. This methods checks that this node, and all its nodes
	 * recursively, do not contain elements that were introduced in more recent
	 * versions of the ASM API than the given version.
	 *
	 * @param api an ASM API version. Must be one of {@link Opcodes#ASM4}.
	 */
	public void check(final int api)
	{
		// nothing to do
	}


	/**
	 * Makes the given method visitor visit this method.
	 *
	 * @param mv a method visitor.
	 */
	public void accept(final MethodVisitor mv)
	{
		// visits the method attributes
		int i, j, n;
		if(annotationDefault != null)
		{
			AnnotationVisitor av = mv.visitAnnotationDefault();
			OldAnnotationNode.accept(av, null, annotationDefault);
			if(av != null)
			{
				av.visitEnd();
			}
		}

		if(visited)
		{
			instructions0.resetLabels();
		}
		n = attrs == null ? 0 : attrs.size();
		for(i = 0; i < n; ++i)
		{
			mv.visitAttribute(attrs.get(i));
		}
		// visits the method's code
		if(instructions0.size() > 0)
		{
			mv.visitCode();
			// visits try catch blocks
			n = tryCatchBlocks == null ? 0 : tryCatchBlocks.size();
			for(i = 0; i < n; ++i)
			{
				tryCatchBlocks.get(i).accept(mv);
			}
			// visits instructions
			instructions0.accept(mv);
			// visits local variables
			n = localVariables == null ? 0 : localVariables.size();
			for(i = 0; i < n; ++i)
			{
				localVariables.get(i).accept(mv);
			}
			// visits maxs
			mv.visitMaxs(maxStack, maxLocals);
			visited = true;
		}
		mv.visitEnd();
	}

	@Override
	public <T> void accept(@org.jetbrains.annotations.NotNull final AsmVisitor<T> asmVisitor, T a2)
	{
		asmVisitor.visitMethodNode(this, a2);
	}
}
