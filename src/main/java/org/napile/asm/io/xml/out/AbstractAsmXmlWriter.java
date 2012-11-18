/*
 * Copyright 2010-2012 napile.org
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.napile.asm.io.xml.out;

import java.util.List;

import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.jetbrains.annotations.NotNull;
import org.napile.asm.Modifier;
import org.napile.asm.io.AsmWriter;
import org.napile.asm.io.AsmWriterOption;
import org.napile.asm.resolve.name.FqName;
import org.napile.asm.tree.members.*;
import org.napile.asm.tree.members.bytecode.Instruction;
import org.napile.asm.tree.members.bytecode.InstructionVisitor;
import org.napile.asm.tree.members.bytecode.MethodRef;
import org.napile.asm.tree.members.bytecode.VariableRef;
import org.napile.asm.tree.members.bytecode.impl.*;
import org.napile.asm.tree.members.bytecode.tryCatch.CatchBlock;
import org.napile.asm.tree.members.bytecode.tryCatch.TryCatchBlockNode;
import org.napile.asm.tree.members.types.TypeNode;
import org.napile.asm.tree.members.types.constructors.ClassTypeNode;
import org.napile.asm.tree.members.types.constructors.MethodTypeNode;
import org.napile.asm.tree.members.types.constructors.ThisTypeNode;
import org.napile.asm.tree.members.types.constructors.TypeParameterValueTypeNode;
import org.napile.asm.util.StringWrapper;

/**
 * @author VISTALL
 * @date 17:51/31.08.12
 */
public abstract class AbstractAsmXmlWriter<A> extends AsmWriter<Element, Element, A> implements InstructionVisitor<Element, Element>
{
	protected Document document;
	protected FqName fqName;

	@Override
	protected void start()
	{
		document = DocumentHelper.createDocument();
	}

	@Override
	public Element visitAnnotationNode(AnnotationNode annotationNode, Element o)
	{
		final Element temp = o.addElement("annotation");
		visitCode(temp, annotationNode);
		return temp;
	}

	@Override
	public Element visitClassNode(ClassNode classNode, Element a2)
	{
		Element element = document.addElement("class");
		fqName = classNode.name;

		element.addAttribute("version", String.valueOf(langVersion.ordinal()));
		element.addAttribute("name", classNode.name.getFqName());

		addMemberElements(element, classNode);

		ifNotEmptyAdd(classNode.annotations, "annotations", element);

		ifNotEmptyAdd(classNode.supers, "extends", element);

		for(AbstractMemberNode memberNode : classNode.members)
			memberNode.accept(this, element);
		return element;
	}

	@Override
	public Element visitMethodNode(MethodNode methodNode, Element a2)
	{
		final Element temp = a2.addElement("method");
		temp.addAttribute("name", methodNode.name.getIdentifier());

		addMemberElements(temp, methodNode);

		ifNotEmptyAdd(methodNode.annotations, "annotations", temp);

		methodNode.returnType.accept(this, temp.addElement("return_type"));

		ifNotEmptyAdd(methodNode.parameters, "parameters", temp);

		visitCode(temp, methodNode);
		return temp;
	}

	@Override
	public Element visitMacroNode(MacroNode macroNode, Element a2)
	{
		final Element temp = a2.addElement("macro");
		temp.addAttribute("name", macroNode.name.getIdentifier());

		addMemberElements(temp, macroNode);

		ifNotEmptyAdd(macroNode.annotations, "annotations", temp);

		macroNode.returnType.accept(this, temp.addElement("return_type"));

		ifNotEmptyAdd(macroNode.parameters, "parameters", temp);

		visitCode(temp, macroNode);
		return temp;
	}

	@Override
	public Element visitConstructorNode(ConstructorNode constructorNode, Element a2)
	{
		final Element temp = a2.addElement("constructor");

		addMemberElements(temp, constructorNode);

		ifNotEmptyAdd(constructorNode.annotations, "annotations", temp);

		ifNotEmptyAdd(constructorNode.parameters, "parameters", temp);

		visitCode(temp, constructorNode);
		return temp;
	}

	@Override
	public Element visitStaticConstructorNode(StaticConstructorNode constructorNode, Element a2)
	{
		final Element temp = a2.addElement("static_constructor");

		visitCode(temp, constructorNode);

		return temp;
	}

	private void visitCode(@NotNull Element temp, @NotNull LikeMethodNode<?> methodNode)
	{
		if(!methodNode.instructions.isEmpty())
		{
			Element parent = temp.addElement("code");
			parent.addAttribute("max_locals", String.valueOf(methodNode.maxLocals));

			int i = 0;
			for(Instruction instruction : methodNode.instructions)
			{
				Element e = instruction.accept(this, parent);

				if(hasOption(AsmWriterOption.INSTRUCTION_INDEX_IN_COMMENT))
					e.addComment(String.valueOf(i ++));
			}
		}

		if(!methodNode.tryCatchBlockNodes.isEmpty())
			ifNotEmptyAdd(methodNode.tryCatchBlockNodes, "try_catch_block", temp.addElement("try_catch_blocks"));
	}

	@Override
	public Element visitVariableNode(VariableNode variableNode, Element a2)
	{
		final Element temp = a2.addElement("variable");
		temp.addAttribute("name", variableNode.name.getIdentifier());

		addMemberElements(temp, variableNode);

		ifNotEmptyAdd(variableNode.annotations, "annotations", temp);

		variableNode.returnType.accept(this, temp.addElement("return_type"));
		return temp;
	}

	@Override
	public Element visitMethodParameterNode(MethodParameterNode methodParameterNode, Element element)
	{
		final Element temp = element.addElement("parameter");
		temp.addAttribute("name", methodParameterNode.name.getIdentifier());

		addMemberElements(temp, methodParameterNode);

		ifNotEmptyAdd(methodParameterNode.annotations, "annotations", element);

		methodParameterNode.typeNode.accept(this, temp);
		return temp;
	}

	@Override
	public Element visitTypeParameter(TypeParameterNode typeParameterNode, Element a2)
	{
		Element temp = a2.addElement("type_parameter");
		temp.addAttribute("name", typeParameterNode.name.getIdentifier());

		ifNotEmptyAdd(typeParameterNode.supers, "extends", temp);

		Element constructorsElement = temp.addElement("type_parameter_constructors");
		for(List<MethodParameterNode> p : typeParameterNode.constructors)
			ifNotEmptyAdd(p, "type_parameter_constructor", constructorsElement);
		return temp;
	}

	@Override
	public Element visitTypeNode(TypeNode typeNode, Element a2)
	{
		final Element element = a2.addElement("type");
		element.addAttribute("nullable", String.valueOf(typeNode.nullable));

		ifNotEmptyAdd(typeNode.annotations, "annotations", element);

		typeNode.typeConstructorNode.accept(this, element);

		ifNotEmptyAdd(typeNode.arguments, "type_arguments", element);
		return element;
	}

	@Override
	public Element visitClassTypeNode(ClassTypeNode classTypeNode, Element a2)
	{
		final Element temp = a2.addElement("class_type");
		temp.addAttribute("name", classTypeNode.className.getFqName());
		return temp;
	}

	@Override
	public Element visitThisTypeNode(ThisTypeNode thisTypeNode, Element a2)
	{
		return a2.addElement("this_type");
	}

	@Override
	public Element visitMethodTypeNode(MethodTypeNode methodTypeNode, Element a2)
	{
		final Element temp = a2.addElement("method_type");

		methodTypeNode.returnType.accept(this, temp.addElement("return_type"));

		ifNotEmptyAdd(methodTypeNode.parameters, "parameters", temp);

		return temp;
	}

	@Override
	public Element visitTypeParameterValueTypeNode(TypeParameterValueTypeNode typeParameterValueTypeNode, Element a2)
	{
		final Element temp = a2.addElement("type_parameter_value_type");
		temp.addAttribute("name", typeParameterValueTypeNode.name.getIdentifier());
		return temp;
	}

	@Override
	public Element visitTryCatchBlockNode(TryCatchBlockNode tryCatchBlockNode, Element arg)
	{
		Element tryElement = arg.addElement("try");
		tryElement.addAttribute("start_index", String.valueOf(tryCatchBlockNode.tryBlock.startIndex));
		tryElement.addAttribute("end_index", String.valueOf(tryCatchBlockNode.tryBlock.endIndex));

		for(CatchBlock catchBlock : tryCatchBlockNode.catchBlocks)
		{
			Element catchElement = arg.addElement("catch");
			catchElement.addAttribute("start_index", String.valueOf(catchBlock.startIndex));
			catchElement.addAttribute("end_index", String.valueOf(catchBlock.endIndex));
			catchElement.addAttribute("variable_index", String.valueOf(catchBlock.variableIndex));

			catchBlock.exception.accept(this, catchElement);
		}
		return arg;
	}

	private void ifNotEmptyAdd(List<? extends Node> list, String name, Element parent)
	{
		if(list.size() > 0)
		{
			Element p = parent.addElement(name);
			for(Node asmNode : list)
				asmNode.accept(this, p);
		}
	}

	private void addMemberElements(Element parent, AbstractMemberNode<?> m)
	{
		if(m.modifiers.length > 0)
		{
			Element tag = parent.addElement("modifiers");
			for(Modifier modifier : m.modifiers)
				tag.addElement(modifier.name().toLowerCase());
		}

		ifNotEmptyAdd(m.typeParameters, "type_parameters", parent);
	}

	//-----------------------------------------------------------------------------

	@Override
	public Element visitLoad(LoadInstruction instruction, Element a)
	{
		Element element = a.addElement("load");
		element.addAttribute("val", String.valueOf(instruction.varIndex));
		return element;
	}

	@Override
	public Element visitDup(DupInstruction instruction, Element a)
	{
		return a.addElement("dup");
	}

	@Override
	public Element visitDup1x1(Dup1x1Instruction instruction, Element a)
	{
		return a.addElement("dup1x1");
	}

	@Override
	public Element visitStore(StoreInstruction instruction, Element a)
	{
		Element element = a.addElement("store");
		element.addAttribute("val", String.valueOf(instruction.varIndex));
		return element;
	}

	@Override
	public Element visitNewObject(NewObjectInstruction instruction, Element a)
	{
		Element element = a.addElement("new_object");
		instruction.value.accept(this, element);
		ifNotEmptyAdd(instruction.parameters, "parameters", element);
		return element;
	}

	@Override
	public Element visitNewByte(NewByteInstruction instruction, Element a)
	{
		Element element = a.addElement("new_byte");
		element.addAttribute("val", String.valueOf(instruction.value));
		return element;
	}

	@Override
	public Element visitNewShort(NewShortInstruction instruction, Element a)
	{
		Element element = a.addElement("new_short");
		element.addAttribute("val", String.valueOf(instruction.value));
		return element;
	}

	@Override
	public Element visitNewInt(NewIntInstruction instruction, Element a)
	{
		Element element = a.addElement("new_int");
		element.addAttribute("val", String.valueOf(instruction.value));
		return element;
	}

	@Override
	public Element visitNewLong(NewLongInstruction instruction, Element a)
	{
		Element element = a.addElement("new_long");
		element.addAttribute("val", String.valueOf(instruction.value));
		return element;
	}

	@Override
	public Element visitNewFloat(NewFloatInstruction instruction, Element a)
	{
		Element element = a.addElement("new_float");
		element.addAttribute("val", String.valueOf(instruction.value));
		return element;
	}

	@Override
	public Element visitNewDouble(NewDoubleInstruction instruction, Element a)
	{
		Element element = a.addElement("new_double");
		element.addAttribute("val", String.valueOf(instruction.value));
		return element;
	}

	@Override
	public Element visitNewChar(NewCharInstruction instruction, Element a)
	{
		Element element = a.addElement("new_char");
		element.addAttribute("val", String.valueOf(instruction.value));
		return element;
	}

	@Override
	public Element visitNewString(NewStringInstruction instruction, Element a)
	{
		Element element = a.addElement("new_string");
		element.addAttribute("val", StringWrapper.wrapToXml(instruction.value));
		return element;
	}

	@Override
	public Element visitReturn(ReturnInstruction instruction, Element a)
	{
		return a.addElement("return");
	}

	@Override
	public Element visitThrow(ThrowInstruction instruction, Element a)
	{
		return a.addElement("throw");
	}

	@Override
	public Element visitSwap(SwapInstruction swapInstruction, Element a)
	{
		return a.addElement("swap");
	}

	@Override
	public Element visitPop(PopInstruction popInstruction, Element a)
	{
		return a.addElement("pop");
	}

	@Override
	public Element visitJumpIf(JumpIfInstruction instruction, Element a)
	{
		Element element = a.addElement("jump_if");
		element.addAttribute("val", String.valueOf(instruction.value));
		return element;
	}

	@Override
	public Element visitJump(JumpInstruction instruction, Element a)
	{
		Element element = a.addElement("jump");
		element.addAttribute("val", String.valueOf(instruction.value));
		return element;
	}

	@Override
	public Element visitTypeOf(TypeOfInstruction instruction, Element a)
	{
		Element element = a.addElement("type_of");
		instruction.value.accept(this, element);
		return element;
	}

	@Override
	public Element visitClassOf(ClassOfInstruction instruction, Element a)
	{
		Element element = a.addElement("class_of");
		instruction.value.accept(this, element);
		return element;
	}

	@Override
	public Element visitIs(IsInstruction instruction, Element a)
	{
		Element element = a.addElement("is");
		instruction.value.accept(this, element);
		return element;
	}

	@Override
	public Element visitInvokeStatic(InvokeStaticInstruction instruction, Element a)
	{
		final Element temp = a.addElement("invoke_static");
		Element temp2 = temp.addElement("method");
		MethodRef methodRef = instruction.methodRef;
		temp2.addAttribute("name", methodRef.method.toString());
		methodRef.returnType.accept(this, temp2.addElement("return_type"));
		ifNotEmptyAdd(methodRef.parameters, "parameters", temp2);
		ifNotEmptyAdd(methodRef.typeArguments, "type_arguments", temp2);
		return temp;
	}

	@Override
	public Element visitInvokeSpecial(InvokeSpecialInstruction instruction, Element a)
	{
		final Element temp = a.addElement("invoke_special");
		Element temp2 = temp.addElement("method");
		MethodRef methodRef = instruction.methodRef;
		temp2.addAttribute("name", methodRef.method.toString());
		methodRef.returnType.accept(this, temp2.addElement("return_type"));
		ifNotEmptyAdd(methodRef.parameters, "parameters", temp2);
		ifNotEmptyAdd(methodRef.typeArguments, "type_arguments", temp2);
		return temp;
	}

	@Override
	public Element visitInvokeVirtual(InvokeVirtualInstruction instruction, Element a)
	{
		final Element temp = a.addElement("invoke_virtual");
		Element temp2 = temp.addElement("method");
		MethodRef methodRef = instruction.methodRef;
		temp2.addAttribute("name", methodRef.method.toString());
		methodRef.returnType.accept(this, temp2.addElement("return_type"));
		ifNotEmptyAdd(methodRef.parameters, "parameters", temp2);
		ifNotEmptyAdd(methodRef.typeArguments, "type_arguments", temp2);
		return temp;
	}

	@Override
	public Element visitInvokeAnonym(InvokeAnonymInstruction instruction, Element a)
	{
		final Element temp = a.addElement("invoke_anonym");
		Element temp2 = temp.addElement("method");
		MethodRef methodRef = instruction.methodRef;
		methodRef.returnType.accept(this, temp2.addElement("return_type"));
		ifNotEmptyAdd(methodRef.parameters, "parameters", temp2);
		ifNotEmptyAdd(methodRef.typeArguments, "type_arguments", temp2);
		return temp;
	}

	@Override
	public Element visitMacroSpecial(MacroSpecialInstruction instruction, Element a)
	{
		final Element temp = a.addElement("macro_special");
		Element temp2 = temp.addElement("method");
		MethodRef methodRef = instruction.methodRef;
		temp2.addAttribute("name", methodRef.method.toString());
		methodRef.returnType.accept(this, temp2.addElement("return_type"));
		ifNotEmptyAdd(methodRef.parameters, "parameters", temp2);
		ifNotEmptyAdd(methodRef.typeArguments, "type_arguments", temp2);
		return temp;
	}

	@Override
	public Element visitMacroStatic(MacroStaticInstruction instruction, Element a)
	{
		final Element temp = a.addElement("macro_static");
		Element temp2 = temp.addElement("method");
		MethodRef methodRef = instruction.methodRef;
		temp2.addAttribute("name", methodRef.method.toString());
		methodRef.returnType.accept(this, temp2.addElement("return_type"));
		ifNotEmptyAdd(methodRef.parameters, "parameters", temp2);
		ifNotEmptyAdd(methodRef.typeArguments, "type_arguments", temp2);
		return temp;
	}

	@Override
	public Element visitMacroVirtual(MacroVirtualInstruction instruction, Element a)
	{
		final Element temp = a.addElement("macro_virtual");
		Element temp2 = temp.addElement("method");
		MethodRef methodRef = instruction.methodRef;
		temp2.addAttribute("name", methodRef.method.toString());
		methodRef.returnType.accept(this, temp2.addElement("return_type"));
		ifNotEmptyAdd(methodRef.parameters, "parameters", temp2);
		ifNotEmptyAdd(methodRef.typeArguments, "type_arguments", temp2);
		return temp;
	}

	@Override
	public Element visitLinkMethod(LinkMethodInstruction instruction, Element a)
	{
		final Element temp = a.addElement("link_method");
		Element temp2 = temp.addElement("method");
		MethodRef methodRef = instruction.methodRef;
		temp2.addAttribute("name", methodRef.method.toString());
		methodRef.returnType.accept(this, temp2.addElement("return_type"));
		ifNotEmptyAdd(methodRef.parameters, "parameters", temp2);
		ifNotEmptyAdd(methodRef.typeArguments, "type_arguments", temp2);
		return temp;
	}

	@Override
	public Element visitLinkStaticMethod(LinkStaticMethodInstruction instruction, Element a)
	{
		final Element temp = a.addElement("link_static_method");
		Element temp2 = temp.addElement("method");
		MethodRef methodRef = instruction.methodRef;
		temp2.addAttribute("name", methodRef.method.toString());
		methodRef.returnType.accept(this, temp2.addElement("return_type"));
		ifNotEmptyAdd(methodRef.parameters, "parameters", temp2);
		ifNotEmptyAdd(methodRef.typeArguments, "type_arguments", temp2);
		return temp;
	}

	@Override
	public Element visitPutToVariable(PutToVariableInstruction instruction, Element a)
	{
		final Element temp = a.addElement("put_to_variable");
		Element temp2 = temp.addElement("variable");
		VariableRef variableRef = instruction.variableRef;
		temp2.addAttribute("name", variableRef.variable.toString());
		variableRef.returnType.accept(this, temp2);
		return temp;
	}

	@Override
	public Element visitPutToStaticVariable(PutToStaticVariableInstruction instruction, Element a)
	{
		final Element temp = a.addElement("put_to_static_variable");
		Element temp2 = temp.addElement("variable");
		VariableRef variableRef = instruction.variableRef;
		temp2.addAttribute("name", variableRef.variable.toString());
		variableRef.returnType.accept(this, temp2);
		return temp;
	}

	@Override
	public Element visitGetVariable(GetVariableInstruction instruction, Element a)
	{
		final Element temp = a.addElement("get_variable");
		Element temp2 = temp.addElement("variable");
		VariableRef variableRef = instruction.variableRef;
		temp2.addAttribute("name", variableRef.variable.toString());
		variableRef.returnType.accept(this, temp2);
		return temp;
	}

	@Override
	public Element visitGetStaticVariable(GetStaticVariableInstruction instruction, Element a)
	{
		final Element temp = a.addElement("get_static_variable");
		Element temp2 = temp.addElement("variable");
		VariableRef variableRef = instruction.variableRef;
		temp2.addAttribute("name", variableRef.variable.toString());
		variableRef.returnType.accept(this, temp2);
		return temp;
	}
}
