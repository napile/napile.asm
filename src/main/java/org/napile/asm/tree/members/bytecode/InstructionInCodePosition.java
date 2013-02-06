package org.napile.asm.tree.members.bytecode;

/**
 * @author VISTALL
 * @date 13:43/06.02.13
 */
public class InstructionInCodePosition
{
	public static final InstructionInCodePosition EMPTY_POSITION = new InstructionInCodePosition(null, -1, -1);

	private final String file;
	private final int line;
	private final int column;

	public InstructionInCodePosition(String file, int line, int column)
	{
		this.file = file;
		this.line = line;
		this.column = column;
	}

	public String getFile()
	{
		return file;
	}

	public int getLine()
	{
		return line;
	}

	public int getColumn()
	{
		return column;
	}

	@Override
	public String toString()
	{
		final StringBuilder sb = new StringBuilder();
		sb.append("InstructionInCodePosition");
		sb.append("{file='").append(file).append('\'');
		sb.append(", line=").append(line);
		sb.append(", column=").append(column);
		sb.append('}');
		return sb.toString();
	}
}
