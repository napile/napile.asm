package org.napile.asm.writters;

import java.util.List;

import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.napile.asm.Modifier;
import org.napile.asm.tree.members.*;
import org.napile.asm.tree.members.bytecode.Instruction;
import org.napile.asm.tree.members.bytecode.InstructionVisitor;
import org.napile.asm.tree.members.bytecode.MethodRef;
import org.napile.asm.tree.members.bytecode.VariableRef;
import org.napile.asm.tree.members.bytecode.impl.*;
import org.napile.asm.tree.members.types.ClassTypeNode;
import org.napile.asm.tree.members.types.ThisTypeNode;
import org.napile.asm.tree.members.types.TypeNode;
import org.napile.compiler.lang.resolve.name.FqName;

/**
 * @author VISTALL
 * @date 17:51/31.08.12
 */
public abstract class BytecodeToXmlWriter<R> extends AsmWriter<Element, R> implements InstructionVisitor<Element>
{
	protected Document document;
	protected FqName fqName;

	@Override
	protected void start()
	{
		document = DocumentHelper.createDocument();
	}

	@Override
	public void visitAnnotationNode(AnnotationNode annotationNode, Element o)
	{
		final Element temp = o.addElement("annotation");
		temp.addAttribute("name", annotationNode.getName().getFqName());
	}

	@Override
	public void visitClassNode(ClassNode classNode, Element a2)
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
	}

	@Override
	public void visitMethodNode(MethodNode methodNode, Element a2)
	{
		final Element temp = a2.addElement("method");
		temp.addAttribute("name", methodNode.name);

		addMemberElements(temp, methodNode);

		ifNotEmptyAdd(methodNode.annotations, "annotations", temp);

		if(methodNode.returnType != null)
			methodNode.returnType.accept(this, temp.addElement("return_type"));

		ifNotEmptyAdd(methodNode.parameters, "parameters", temp);

		if(methodNode.instructions.size() > 0)
		{
			Element parent = temp.addElement("code");
			parent.addAttribute("max_locals", String.valueOf(methodNode.maxLocals));
			for(Instruction instruction : methodNode.instructions)
				instruction.accept(this, parent);
		}
	}

	@Override
	public void visitConstructorNode(ConstructorNode constructorNode, Element a2)
	{
		final Element temp = a2.addElement("constructor");

		addMemberElements(temp, constructorNode);

		ifNotEmptyAdd(constructorNode.annotations, "annotations", temp);

		ifNotEmptyAdd(constructorNode.parameters, "parameters", temp);

		if(constructorNode.instructions.size() > 0)
		{
			Element parent = temp.addElement("code");
			parent.addAttribute("max_locals", String.valueOf(constructorNode.maxLocals));
			for(Instruction instruction : constructorNode.instructions)
				instruction.accept(this, parent);
		}
	}

	@Override
	public void visitStaticConstructorNode(StaticConstructorNode constructorNode, Element a2)
	{
		final Element temp = a2.addElement("static_constructor");

		if(constructorNode.instructions.size() > 0)
		{
			Element parent = temp.addElement("code");
			parent.addAttribute("max_locals", String.valueOf(constructorNode.maxLocals));
			for(Instruction instruction : constructorNode.instructions)
				instruction.accept(this, parent);
		}
	}

	@Override
	public void visitVariableNode(VariableNode variableNode, Element a2)
	{
		final Element temp = a2.addElement("variable");
		temp.addAttribute("name", variableNode.name);

		addMemberElements(temp, variableNode);

		ifNotEmptyAdd(variableNode.annotations, "annotations", temp);

		variableNode.returnType.accept(this, temp.addElement("return_type"));
	}

	@Override
	public void visitMethodParameterNode(MethodParameterNode methodParameterNode, Element element)
	{
		final Element temp = element.addElement("parameter");
		temp.addAttribute("name", methodParameterNode.name);

		addMemberElements(temp, methodParameterNode);

		ifNotEmptyAdd(methodParameterNode.annotations, "annotations", element);

		methodParameterNode.typeNode.accept(this, temp);
	}

	@Override
	public void visitTypeParameter(TypeParameterNode typeParameterNode, Element a2)
	{
		Element temp = a2.addElement("type_parameter");
		temp.addAttribute("name", typeParameterNode.name);

		ifNotEmptyAdd(typeParameterNode.supers, "extends", temp);
	}

	@Override
	public void visitTypeNode(TypeNode typeNode, Element a2)
	{
		final Element element = a2.addElement("type");
		element.addAttribute("nullable", String.valueOf(typeNode.nullable));

		ifNotEmptyAdd(typeNode.annotations, "annotations", element);

		typeNode.typeConstructorNode.accept(this, element);

		ifNotEmptyAdd(typeNode.arguments, "type_arguments", element);
	}

	@Override
	public void visitClassTypeNode(ClassTypeNode classTypeNode, Element a2)
	{
		final Element temp = a2.addElement("class_type");
		temp.addAttribute("name", classTypeNode.getClassName().getFqName());
	}

	@Override
	public void visitThisTypeNode(ThisTypeNode thisTypeNode, Element a2)
	{
		a2.addElement("this_type");
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
	public void visitLoad(LoadInstruction instruction, Element a)
	{
		Element element = a.addElement("load");
		element.addAttribute("val", String.valueOf(instruction.varIndex));
	}

	public void visitDup(DupInstruction instruction, Element a)
	{
		a.addElement("dup");
	}

	@Override
	public void visitStore(StoreInstruction instruction, Element a)
	{
		Element element = a.addElement("store");
		element.addAttribute("val", String.valueOf(instruction.varIndex));
	}

	@Override
	public void visitNewObject(NewObjectInstruction instruction, Element a)
	{
		Element element = a.addElement("new_object");
		instruction.value.accept(this, element);
	}

	@Override
	public void visitNewByte(NewByteInstruction instruction, Element a)
	{
		Element element = a.addElement("new_byte");
		element.addAttribute("val", String.valueOf(instruction.value));
	}

	@Override
	public void visitNewShort(NewShortInstruction instruction, Element a)
	{
		Element element = a.addElement("new_short");
		element.addAttribute("val", String.valueOf(instruction.value));
	}

	@Override
	public void visitNewInt(NewIntInstruction instruction, Element a)
	{
		Element element = a.addElement("new_int");
		element.addAttribute("val", String.valueOf(instruction.value));
	}

	@Override
	public void visitNewLong(NewLongInstruction instruction, Element a)
	{
		Element element = a.addElement("new_long");
		element.addAttribute("val", String.valueOf(instruction.value));
	}

	@Override
	public void visitNewFloat(NewFloatInstruction instruction, Element a)
	{
		Element element = a.addElement("new_float");
		element.addAttribute("val", String.valueOf(instruction.value));
	}

	@Override
	public void visitNewDouble(NewDoubleInstruction instruction, Element a)
	{
		Element element = a.addElement("new_double");
		element.addAttribute("val", String.valueOf(instruction.value));
	}

	@Override
	public void visitNewChar(NewCharInstruction instruction, Element a)
	{
		Element element = a.addElement("new_char");
		element.addAttribute("val", String.valueOf(instruction.value));
	}

	@Override
	public void visitNewString(NewStringInstruction instruction, Element a)
	{
		Element element = a.addElement("new_string");
		element.addAttribute("val", String.valueOf(instruction.value));
	}

	@Override
	public void visitReturn(ReturnInstruction instruction, Element a)
	{
		a.addElement("return");
	}

	@Override
	public void visitInvokeStatic(InvokeStaticInstruction instruction, Element a)
	{
		Element temp = a.addElement("invoke_static");
		temp = temp.addElement("method");
		MethodRef methodRef = instruction.methodRef;
		temp.addAttribute("name", methodRef.method.toString());
		if(methodRef.returnType != null)
			methodRef.returnType.accept(this, temp.addElement("return_type"));
		ifNotEmptyAdd(methodRef.parameters, "parameters", temp);
	}

	@Override
	public void visitInvokeSpecial(InvokeSpecialInstruction instruction, Element a)
	{
		Element temp = a.addElement("invoke_special");
		temp = temp.addElement("method");
		MethodRef methodRef = instruction.methodRef;
		temp.addAttribute("name", methodRef.method.toString());
		if(methodRef.returnType != null)
			methodRef.returnType.accept(this, temp.addElement("return_type"));
		ifNotEmptyAdd(methodRef.parameters, "parameters", temp);
	}

	@Override
	public void visitInvokeVirtual(InvokeVirtualInstruction instruction, Element a)
	{
		Element temp = a.addElement("invoke_virtual");
		temp = temp.addElement("method");
		MethodRef methodRef = instruction.methodRef;
		temp.addAttribute("name", methodRef.method.toString());
		if(methodRef.returnType != null)
			methodRef.returnType.accept(this, temp.addElement("return_type"));
		ifNotEmptyAdd(methodRef.parameters, "parameters", temp);
	}

	@Override
	public void visitPutToVariable(PutToVariableInstruction instruction, Element a)
	{
		Element temp = a.addElement("put_to_variable");
		temp = temp.addElement("variable");
		VariableRef variableRef = instruction.variableRef;
		temp.addAttribute("name", variableRef.variable.toString());
		variableRef.returnType.accept(this, temp);
	}

	@Override
	public void visitPutToStaticVariable(PutToStaticVariableInstruction instruction, Element a)
	{
		Element temp = a.addElement("put_to_static_variable");
		temp = temp.addElement("variable");
		VariableRef variableRef = instruction.variableRef;
		temp.addAttribute("name", variableRef.variable.toString());
		variableRef.returnType.accept(this, temp);
	}

	@Override
	public void visitGetVariable(GetVariableInstruction instruction, Element a)
	{
		Element temp = a.addElement("get_variable");
		temp = temp.addElement("variable");
		VariableRef variableRef = instruction.variableRef;
		temp.addAttribute("name", variableRef.variable.toString());
		variableRef.returnType.accept(this, temp);
	}

	@Override
	public void visitGetStaticVariable(GetStaticVariableInstruction instruction, Element a)
	{
		Element temp = a.addElement("get_static_variable");
		temp = temp.addElement("variable");
		VariableRef variableRef = instruction.variableRef;
		temp.addAttribute("name", variableRef.variable.toString());
		variableRef.returnType.accept(this, temp);
	}
}
