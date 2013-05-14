package org.napile.asm.util.evaluate;

import org.napile.asm.tree.MemberAddListener;
import org.napile.asm.tree.members.AbstractMemberNode;
import org.napile.asm.tree.members.ClassNode;
import org.napile.asm.tree.members.MethodNode;
import org.napile.asm.tree.members.VariableNode;

/**
 * @author VISTALL
 * @date 21:08/21.12.12
 */
public class MethodEvaluatorListener implements MemberAddListener
{
	@Override
	public void onMemberAdd(ClassNode c, AbstractMemberNode<?> memberNode)
	{
		if(memberNode instanceof MethodNode)
		{
			new Evaluator((MethodNode) memberNode).testIt();
		}
		else if(memberNode instanceof VariableNode)
		{
			new Evaluator((VariableNode) memberNode).testIt();
		}
	}
}
