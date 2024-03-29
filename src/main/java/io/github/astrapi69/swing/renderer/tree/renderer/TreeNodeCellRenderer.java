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
package io.github.astrapi69.swing.renderer.tree.renderer;

import java.awt.Component;

import javax.swing.Icon;
import javax.swing.JLabel;
import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeCellRenderer;

import io.github.astrapi69.gen.tree.TreeNode;

public class TreeNodeCellRenderer<T> extends DefaultTreeCellRenderer
{
	protected final DefaultTreeCellRenderer renderer = new DefaultTreeCellRenderer();
	protected final JLabel treeLabel = new JLabel("init-tree-label");

	@Override
	public Component getTreeCellRendererComponent(JTree tree, Object value, boolean selected,
		boolean expanded, boolean leaf, int row, boolean hasFocus)
	{
		if (value instanceof TreeNode)
		{
			return initialize((TreeNode<T>)value);
		}
		if (value instanceof DefaultMutableTreeNode)
		{
			DefaultMutableTreeNode node = (DefaultMutableTreeNode)value;
			Object userObject = node.getUserObject();
			if (userObject instanceof TreeNode)
			{
				return initialize((TreeNode<T>)userObject);
			}
		}
		return renderer.getTreeCellRendererComponent(tree, value, selected, expanded, leaf, row,
			hasFocus);
	}

	protected JLabel initialize(TreeNode<T> userObject)
	{
		TreeNode<T> treeNode = userObject;
		String displayValue = treeNode.getDisplayValue();
		treeLabel.setText(displayValue);
		if (treeNode.isLeaf())
		{
			treeLabel.setIcon(getLeafIcon());
		}
		else
		{
			if (treeNode.hasChildren())
			{
				treeLabel.setIcon(getOpenIcon());
			}
			else
			{
				treeLabel.setIcon(getClosedIcon());
			}
		}
		return treeLabel;
	}

	/**
	 * {@inheritDoc}
	 */
	public Icon getOpenIcon()
	{
		return renderer.getOpenIcon();
	}

	/**
	 * {@inheritDoc}
	 */
	public Icon getLeafIcon()
	{
		return renderer.getLeafIcon();
	}

	/**
	 * {@inheritDoc}
	 */
	public Icon getClosedIcon()
	{
		return renderer.getClosedIcon();
	}


}
