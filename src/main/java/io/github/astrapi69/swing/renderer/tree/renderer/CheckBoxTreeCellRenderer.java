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

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;

import javax.swing.Icon;
import javax.swing.JCheckBox;
import javax.swing.JPanel;
import javax.swing.JTree;
import javax.swing.UIManager;
import javax.swing.plaf.ColorUIResource;
import javax.swing.tree.TreeCellRenderer;

import io.github.astrapi69.swing.component.factory.DimensionFactory;
import io.github.astrapi69.swing.renderer.tree.renderer.label.CheckBoxTreeLabel;
import io.github.astrapi69.swing.renderer.tree.renderer.model.CheckableTreeNode;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.experimental.FieldDefaults;

@Getter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class CheckBoxTreeCellRenderer extends JPanel implements TreeCellRenderer
{

	final JCheckBox checkBox;

	final Icon closedIcon;

	final CheckBoxTreeLabel label;
	final Icon leafIcon;
	final Icon openIcon;
	final Color textBackground;
	final Color textForeground;

	public CheckBoxTreeCellRenderer()
	{
		setLayout(null);
		leafIcon = UIManager.getIcon("Tree.leafIcon");
		openIcon = UIManager.getIcon("Tree.openIcon");
		closedIcon = UIManager.getIcon("Tree.closedIcon");
		textBackground = UIManager.getColor("Tree.textBackground");
		textForeground = UIManager.getColor("Tree.textForeground");
		add(checkBox = newCheckBox());
		add(label = newTreeLabel());
	}

	@Override
	public void doLayout()
	{
		Dimension checkboxDimension = checkBox.getPreferredSize();
		Dimension labelDimension = label.getPreferredSize();
		int yAxisCheckbox = 0;
		int yAxisLabel = 0;
		if (checkboxDimension.height < labelDimension.height)
		{
			yAxisCheckbox = (labelDimension.height - checkboxDimension.height) / 2;
		}
		else
		{
			yAxisLabel = (checkboxDimension.height - labelDimension.height) / 2;
		}
		checkBox.setLocation(0, yAxisCheckbox);
		checkBox.setBounds(0, yAxisCheckbox, checkboxDimension.width, checkboxDimension.height);
		label.setLocation(checkboxDimension.width, yAxisLabel);
		label.setBounds(checkboxDimension.width, yAxisLabel, labelDimension.width,
			labelDimension.height);
	}

	@Override
	public Dimension getPreferredSize()
	{
		return DimensionFactory.getPreferredSize(checkBox, label);
	}

	@Override
	public Component getTreeCellRendererComponent(JTree tree, Object value, boolean isSelected,
		boolean expanded, boolean leaf, int row, boolean hasFocus)
	{
		String stringValue = tree.convertValueToText(value, isSelected, expanded, leaf, row,
			hasFocus);
		setEnabled(tree.isEnabled());
		checkBox.setSelected(((CheckableTreeNode)value).isSelected());
		label.setFont(tree.getFont());
		label.setText(stringValue);
		label.setSelected(isSelected);
		label.setFocused(hasFocus);
		if (leaf)
		{
			label.setIcon(leafIcon);
		}
		else if (expanded)
		{
			label.setIcon(openIcon);
		}
		else
		{
			label.setIcon(closedIcon);
		}
		return this;
	}

	protected JCheckBox newCheckBox()
	{
		JCheckBox jCheckBox = new JCheckBox();
		jCheckBox.setBackground(textBackground);
		return jCheckBox;
	}

	protected CheckBoxTreeLabel newTreeLabel()
	{
		CheckBoxTreeLabel treeLabel = new CheckBoxTreeLabel();
		treeLabel.setForeground(textForeground);
		return treeLabel;
	}

	@Override
	public void setBackground(Color color)
	{
		if (color instanceof ColorUIResource)
		{
			color = null;
		}
		super.setBackground(color);
	}

}
