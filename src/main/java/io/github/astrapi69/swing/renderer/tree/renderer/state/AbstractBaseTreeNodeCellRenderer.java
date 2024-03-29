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
package io.github.astrapi69.swing.renderer.tree.renderer.state;

import java.awt.Component;

import javax.swing.Icon;
import javax.swing.JLabel;
import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeCellRenderer;

import io.github.astrapi69.gen.tree.BaseTreeNode;

/**
 * The class {@link AbstractBaseTreeNodeCellRenderer}
 *
 * @param <T>
 *            the type parameter
 * @param <K>
 *            the type parameter
 */
public class AbstractBaseTreeNodeCellRenderer<T, K> extends DefaultTreeCellRenderer
{

	/**
	 * The decorated renderer
	 */
	protected final DefaultTreeCellRenderer renderer = new DefaultTreeCellRenderer();

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Component getTreeCellRendererComponent(JTree tree, Object value, boolean selected,
		boolean expanded, boolean leaf, int row, boolean hasFocus)
	{
		if (value instanceof BaseTreeNode)
		{
			BaseTreeNode<T, K> baseTreeNode = (BaseTreeNode<T, K>)value;
			return initialize(tree, baseTreeNode, selected, expanded, leaf, row, hasFocus);
		}
		if (value instanceof DefaultMutableTreeNode)
		{
			DefaultMutableTreeNode node = (DefaultMutableTreeNode)value;
			Object userObject = node.getUserObject();
			if (userObject instanceof BaseTreeNode)
			{
				BaseTreeNode<T, K> baseTreeNode = (BaseTreeNode<T, K>)userObject;
				return initialize(tree, baseTreeNode, selected, expanded, leaf, row, hasFocus);
			}
		}
		return renderer.getTreeCellRendererComponent(tree, value, selected, expanded, leaf, row,
			hasFocus);
	}

	/**
	 * Initialize the {@link JLabel} object
	 *
	 * @param tree
	 *            the tree
	 * @param userObject
	 *            the user object
	 * @param selected
	 *            the selected
	 * @param expanded
	 *            the expanded
	 * @param leaf
	 *            the leaf
	 * @param row
	 *            the row
	 * @param hasFocus
	 *            the flag if the {@link JLabel} object has the focus
	 * @return the {@link JLabel} object
	 */
	protected JLabel initialize(JTree tree, BaseTreeNode<T, K> userObject, boolean selected,
		boolean expanded, boolean leaf, int row, boolean hasFocus)
	{
		JLabel treeLabel = new JLabel("init-tree-label");
		BaseTreeNode<T, K> treeNode = userObject;
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
