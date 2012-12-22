package org.napile.asm.tree;

import org.napile.asm.tree.members.AbstractMemberNode;
import org.napile.asm.tree.members.ClassNode;

/**
 * @author VISTALL
 * @date 21:05/21.12.12
 */
public interface MemberAddListener
{
	void onMemberAdd(ClassNode c, AbstractMemberNode<?> memberNode);
}
