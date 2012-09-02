package org.napile.asm.util;

import java.util.Collection;
import java.util.Iterator;

import org.jetbrains.annotations.NotNull;

/**
 * @author VISTALL
 * @date 0:05/02.09.12
 */
public class Comparing2
{
	public static <T> boolean equal(@NotNull Collection<? extends T> o1, @NotNull Collection<? extends T> o2)
	{
		if(o1.size() != o2.size())
			return false;

		Iterator<? extends T> iterator1 = o1.iterator();
		Iterator<? extends T> iterator2 = o2.iterator();

		while(iterator1.hasNext() && iterator2.hasNext())
		{
			T t1 = iterator1.next();
			T t2 = iterator2.next();

			if(!t1.equals(t2))
				return false;
		}
		return true;
	}
}
