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

package org.napile.asm.tree.members.bytecode;

import org.napile.asm.tree.members.bytecode.impl.*;

/**
 * @author VISTALL
 * @date 22:23/31.08.12
 */
public interface InstructionVisitor<T, R>
{
	R visitDup(DupInstruction instruction, T a);

	R visitLoad(LoadInstruction instruction, T a);

	R visitStore(StoreInstruction instruction, T a);

	R visitNewObject(NewObjectInstruction instruction, T a);

	R visitNewByte(NewByteInstruction instruction, T a);

	R visitNewShort(NewShortInstruction instruction, T a);

	R visitNewInt(NewIntInstruction instruction, T a);

	R visitNewLong(NewLongInstruction instruction, T a);

	R visitNewFloat(NewFloatInstruction instruction, T a);

	R visitNewDouble(NewDoubleInstruction instruction, T a);

	R visitNewChar(NewCharInstruction instruction, T a);

	R visitNewString(NewStringInstruction instruction, T a);

	R visitReturn(ReturnInstruction instruction, T a);

	R visitInvokeStatic(InvokeStaticInstruction instruction, T a);

	R visitInvokeSpecial(InvokeSpecialInstruction instruction, T a);

	R visitInvokeVirtual(InvokeVirtualInstruction instruction, T a);

	R visitMacroStatic(MacroStaticInstruction instruction, T a);

	R visitMacroSpecial(MacroSpecialInstruction instruction, T a);

	R visitMacroVirtual(MacroVirtualInstruction instruction, T a);

	R visitInvokeAnonym(InvokeAnonymInstruction instruction, T a2);

	R visitPutToVariable(PutToVariableInstruction instruction, T a);

	R visitPutToStaticVariable(PutToStaticVariableInstruction instruction, T a);

	R visitGetVariable(GetVariableInstruction instruction, T a);

	R visitGetStaticVariable(GetStaticVariableInstruction instruction, T a);

	R visitThrow(ThrowInstruction throwInstruction, T a2);

	R visitSwap(SwapInstruction swapInstruction, T a2);

	R visitPop(PopInstruction popInstruction, T a2);

	R visitJumpIf(JumpIfInstruction jumpIfInstruction, T a2);

	R visitJump(JumpInstruction jumpInstruction, T a2);

	R visitTypeOf(TypeOfInstruction typeOfInstruction, T a2);

	R visitClassOf(ClassOfInstruction classOfInstruction, T a2);

	R visitIs(IsInstruction isInstruction, T a2);

	R visitDup1x1(Dup1x1Instruction instruction, T a2);

	R visitLinkMethod(LinkMethodInstruction instruction, T a2);

	R visitLinkStaticMethod(LinkStaticMethodInstruction instruction, T a2);
}
