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

import javax.swing.Icon;
import javax.swing.JLabel;

import org.apache.commons.lang3.StringUtils;

import io.github.astrapi69.gen.tree.TreeNode;
import io.github.astrapi69.icon.ImageIconFactory;
import io.github.astrapi69.icon.StringIcon;
import io.github.astrapi69.swing.renderer.tree.GenericTreeElement;

public class GenericTreeNodeCellRenderer<T> extends TreeNodeCellRenderer<GenericTreeElement<T>>
{

	protected JLabel initialize(TreeNode<GenericTreeElement<T>> userObject)
	{
		TreeNode<GenericTreeElement<T>> treeNode = userObject;
		String displayValue = treeNode.getDisplayValue();
		GenericTreeElement<T> value = treeNode.getValue();
		if (value != null)
		{
			String iconPath = value.getIconPath();
			if (StringUtils.isNotEmpty(iconPath))
			{
				Icon customTreeIcon;
				try
				{
					customTreeIcon = ImageIconFactory.newImageIcon(iconPath);
				}
				catch (Exception e)
				{
					customTreeIcon = new StringIcon(treeLabel, iconPath);
				}
				if (value.isWithText())
				{
					treeLabel.setText(displayValue);
				}
				else
				{
					treeLabel.setText("");
				}
				treeLabel.setToolTipText(displayValue);
				treeLabel.setIcon(customTreeIcon);
				return treeLabel;
			}
		}
		return super.initialize(userObject);
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
