package org.napile.asm.writters;

import java.util.List;

import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.napile.asm.tree.members.AbstractMemberNode;
import org.napile.asm.tree.members.AnnotationNode;
import org.napile.asm.tree.members.Node;
import org.napile.asm.tree.members.ClassNode;
import org.napile.asm.tree.members.MethodNode;
import org.napile.asm.tree.members.MethodParameterNode;
import org.napile.asm.tree.members.TypeParameterNode;
import org.napile.asm.tree.members.VariableNode;
import org.napile.asm.tree.members.bytecode.Instruction;
import org.napile.asm.tree.members.bytecode.InstructionVisitor;
import org.napile.asm.tree.members.bytecode.MethodRef;
import org.napile.asm.tree.members.bytecode.impl.InvokeStaticInstruction;
import org.napile.asm.tree.members.bytecode.impl.LoadInstruction;
import org.napile.asm.tree.members.bytecode.impl.NewIntInstruction;
import org.napile.asm.tree.members.bytecode.impl.ReturnInstruction;
import org.napile.asm.tree.members.bytecode.impl.StoreInstruction;
import org.napile.asm.tree.members.types.ClassTypeNode;
import org.napile.asm.tree.members.types.ThisTypeNode;
import org.napile.asm.tree.members.types.TypeNode;
import org.napile.asm.Modifier;

/**
 * @author VISTALL
 * @date 17:51/31.08.12
 */
public abstract class BytecodeToXmlWriter<R> extends AsmWriter<Element, R> implements InstructionVisitor<Element>
{
	protected Document document = null;

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

	@Override
	public void visitLoad(LoadInstruction instruction, Element a)
	{
		Element element = a.addElement("load");
		element.addAttribute("val", String.valueOf(instruction.varIndex));
	}

	@Override
	public void visitStore(StoreInstruction instruction, Element a)
	{
		Element element = a.addElement("store");
		element.addAttribute("val", String.valueOf(instruction.varIndex));
	}

	@Override
	public void visitNewInt(NewIntInstruction instruction, Element a)
	{
		Element element = a.addElement("new_int");
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
}
