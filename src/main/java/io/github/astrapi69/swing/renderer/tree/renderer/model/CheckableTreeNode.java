/**
 * The MIT License
 *
 * Copyright (C) 2021 Asterios Raptis
 *
 * Permission is hereby granted, free of charge, to any person obtaining
 * a copy of this software and associated documentation files (the
 * "Software"), to deal in the Software without restriction, including
 * without limitation the rights to use, copy, modify, merge, publish,
 * distribute, sublicense, and/or sell copies of the Software, and to
 * permit persons to whom the Software is furnished to do so, subject to
 * the following conditions:
 *
 * The above copyright notice and this permission notice shall be
 * included in all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND,
 * EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF
 * MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND
 * NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE
 * LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION
 * OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION
 * WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 */
package io.github.astrapi69.swing.renderer.tree.renderer.model;

import java.util.Enumeration;

import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.TreeNode;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

/**
 * The class {@link CheckableTreeNode}
 */
@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class CheckableTreeNode extends DefaultMutableTreeNode
{

	boolean selected;

	/**
	 * Instantiates a new Checkable tree node.
	 */
	public CheckableTreeNode()
	{
		this(null);
	}

	/**
	 * Instantiates a new Checkable tree node.
	 *
	 * @param userObject
	 *            the user object
	 */
	public CheckableTreeNode(Object userObject)
	{
		this(userObject, true, false);
	}

	/**
	 * Instantiates a new Checkable tree node.
	 *
	 * @param userObject
	 *            the user object
	 * @param allowsChildren
	 *            the allows children
	 * @param isSelected
	 *            the is selected
	 */
	public CheckableTreeNode(Object userObject, boolean allowsChildren, boolean isSelected)
	{
		super(userObject, allowsChildren);
		this.selected = isSelected;
	}

	/**
	 * Sets the selected flag
	 *
	 * @param selected
	 *            the selected flag to set
	 */
	@SuppressWarnings("unchecked")
	public void setSelected(boolean selected)
	{
		this.selected = selected;
		Enumeration<TreeNode> e = children.elements();
		while (e.hasMoreElements())
		{
			CheckableTreeNode node = (CheckableTreeNode)e.nextElement();
			node.setSelected(selected);
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void setUserObject(Object obj)
	{
		if (obj instanceof Boolean)
		{
			setSelected(((Boolean)obj).booleanValue());
		}
		else
		{
			super.setUserObject(obj);
		}
	}

}
