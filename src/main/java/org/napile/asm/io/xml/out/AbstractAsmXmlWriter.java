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
import org.napile.asm.tree.members.types.TypeNode;
import org.napile.asm.tree.members.types.constructors.ClassTypeNode;
import org.napile.asm.tree.members.types.constructors.ThisTypeNode;
import org.napile.asm.tree.members.types.constructors.TypeParameterValueTypeNode;

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
		temp.addAttribute("name", annotationNode.getName().getFqName());
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
		temp.addAttribute("name", methodNode.name);

		addMemberElements(temp, methodNode);

		ifNotEmptyAdd(methodNode.annotations, "annotations", temp);

		if(methodNode.returnType != null)
			methodNode.returnType.accept(this, temp.addElement("return_type"));

		ifNotEmptyAdd(methodNode.parameters, "parameters", temp);

		visitCode(temp, methodNode.maxLocals, methodNode.instructions);
		return temp;
	}

	@Override
	public Element visitConstructorNode(ConstructorNode constructorNode, Element a2)
	{
		final Element temp = a2.addElement("constructor");

		addMemberElements(temp, constructorNode);

		ifNotEmptyAdd(constructorNode.annotations, "annotations", temp);

		ifNotEmptyAdd(constructorNode.parameters, "parameters", temp);

		visitCode(temp, constructorNode.maxLocals, constructorNode.instructions);
		return temp;
	}

	@Override
	public Element visitStaticConstructorNode(StaticConstructorNode constructorNode, Element a2)
	{
		final Element temp = a2.addElement("static_constructor");

		visitCode(temp, constructorNode.maxLocals, constructorNode.instructions);

		return temp;
	}

	private void visitCode(@NotNull Element temp, int maxLocals, @NotNull  List<Instruction> instructions)
	{
		if(instructions.size() > 0)
		{
			Element parent = temp.addElement("code");
			parent.addAttribute("max_locals", String.valueOf(maxLocals));

			int i = 0;
			for(Instruction instruction : instructions)
			{
				Element e = instruction.accept(this, parent);

				if(hasOption(AsmWriterOption.INSTRUCTION_INDEX_IN_COMMENT))
				{
					e.addComment(String.valueOf(i));

					i ++;
				}
			}
		}
	}

	@Override
	public Element visitVariableNode(VariableNode variableNode, Element a2)
	{
		final Element temp = a2.addElement("variable");
		temp.addAttribute("name", variableNode.name);

		addMemberElements(temp, variableNode);

		ifNotEmptyAdd(variableNode.annotations, "annotations", temp);

		variableNode.returnType.accept(this, temp.addElement("return_type"));
		return temp;
	}

	@Override
	public Element visitMethodParameterNode(MethodParameterNode methodParameterNode, Element element)
	{
		final Element temp = element.addElement("parameter");
		temp.addAttribute("name", methodParameterNode.name);

		addMemberElements(temp, methodParameterNode);

		ifNotEmptyAdd(methodParameterNode.annotations, "annotations", element);

		methodParameterNode.typeNode.accept(this, temp);
		return temp;
	}

	@Override
	public Element visitTypeParameter(TypeParameterNode typeParameterNode, Element a2)
	{
		Element temp = a2.addElement("type_parameter");
		temp.addAttribute("name", typeParameterNode.name);

		ifNotEmptyAdd(typeParameterNode.supers, "extends", temp);
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
	public Element visitTypeParameterValueTypeNode(TypeParameterValueTypeNode typeParameterValueTypeNode, Element a2)
	{
		final Element temp = a2.addElement("type_parameter_value_type");
		temp.addAttribute("name", typeParameterValueTypeNode.name);
		return temp;
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

	public Element visitDup(DupInstruction instruction, Element a)
	{
		return a.addElement("dup");
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
		element.addAttribute("val", String.valueOf(instruction.value));
		return element;
	}

	@Override
	public Element visitReturn(ReturnInstruction instruction, Element a)
	{
		return a.addElement("return");
	}

	@Override
	public Element visitThrowInstruction(ThrowInstruction instruction, Element a)
	{
		return a.addElement("throw");
	}

	@Override
	public Element visitSwapInstruction(SwapInstruction swapInstruction, Element a)
	{
		return a.addElement("swap");
	}

	@Override
	public Element visitPopInstruction(PopInstruction popInstruction, Element a)
	{
		return a.addElement("pop");
	}

	@Override
	public Element visitJumpIfInstruction(JumpIfInstruction instruction, Element a)
	{
		Element element = a.addElement("jump_if");
		element.addAttribute("val", String.valueOf(instruction.value));
		return element;
	}

	@Override
	public Element visitJumpInstruction(JumpInstruction instruction, Element a)
	{
		Element element = a.addElement("jump");
		element.addAttribute("val", String.valueOf(instruction.value));
		return element;
	}

	@Override
	public Element visitInvokeStatic(InvokeStaticInstruction instruction, Element a)
	{
		final Element temp = a.addElement("invoke_static");
		Element temp2 = temp.addElement("method");
		MethodRef methodRef = instruction.methodRef;
		temp2.addAttribute("name", methodRef.method.toString());
		if(methodRef.returnType != null)
			methodRef.returnType.accept(this, temp2.addElement("return_type"));
		ifNotEmptyAdd(methodRef.parameters, "parameters", temp2);
		return temp;
	}

	@Override
	public Element visitInvokeSpecial(InvokeSpecialInstruction instruction, Element a)
	{
		final Element temp = a.addElement("invoke_special");
		Element temp2 = temp.addElement("method");
		MethodRef methodRef = instruction.methodRef;
		temp2.addAttribute("name", methodRef.method.toString());
		if(methodRef.returnType != null)
			methodRef.returnType.accept(this, temp2.addElement("return_type"));
		ifNotEmptyAdd(methodRef.parameters, "parameters", temp2);
		return temp;
	}

	@Override
	public Element visitInvokeVirtual(InvokeVirtualInstruction instruction, Element a)
	{
		final Element temp = a.addElement("invoke_virtual");
		Element temp2 = temp.addElement("method");
		MethodRef methodRef = instruction.methodRef;
		temp2.addAttribute("name", methodRef.method.toString());
		if(methodRef.returnType != null)
			methodRef.returnType.accept(this, temp2.addElement("return_type"));
		ifNotEmptyAdd(methodRef.parameters, "parameters", temp2);
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
