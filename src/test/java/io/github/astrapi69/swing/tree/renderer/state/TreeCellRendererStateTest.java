package io.github.astrapi69.swing.tree.renderer.state;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TreeCellRendererStateTest
{

	@Test
	void getState()
	{
		TreeCellRendererState actual;
		TreeCellRendererState expected;
		// new scenario...
		actual = TreeCellRendererState.getState(false, false, false, false, false);
		expected = TreeCellRendererState.NODE;
		assertEquals(expected, actual);
		// new scenario...
		actual = TreeCellRendererState.getState(false, false, false, false, true);
		expected = TreeCellRendererState.NODE_WITH_CHILDREN;
		assertEquals(expected, actual);
		// new scenario...
		actual = TreeCellRendererState.getState(false, false, false, true, false);
		expected = TreeCellRendererState.NODE;
		assertEquals(expected, actual);
		// new scenario...
		actual = TreeCellRendererState.getState(false, false, false, true, true);
		expected = TreeCellRendererState.NODE_WITH_CHILDREN;
		assertEquals(expected, actual);
		// new scenario...
		actual = TreeCellRendererState.getState(false, false, true, false, false);
		expected = TreeCellRendererState.EXPANDED_NODE;
		assertEquals(expected, actual);
		// new scenario...
		actual = TreeCellRendererState.getState(false, false, true, false, true);
		expected = TreeCellRendererState.EXPANDED_NODE_WITH_CHILDREN;
		assertEquals(expected, actual);
		// new scenario...
		actual = TreeCellRendererState.getState(false, false, true, true, false);
		expected = TreeCellRendererState.EXPANDED_NODE;
		assertEquals(expected, actual);
		// new scenario...
		actual = TreeCellRendererState.getState(false, false, true, true, true);
		expected = TreeCellRendererState.EXPANDED_NODE_WITH_CHILDREN;
		assertEquals(expected, actual);
		// new scenario...
		actual = TreeCellRendererState.getState(false, true, false, false, false);
		expected = TreeCellRendererState.SELECTED_NODE;
		assertEquals(expected, actual);
		// new scenario...
		actual = TreeCellRendererState.getState(false, true, false, false, true);
		expected = TreeCellRendererState.SELECTED_NODE_WITH_CHILDREN;
		assertEquals(expected, actual);
		// new scenario...
		actual = TreeCellRendererState.getState(false, true, false, true, false);
		expected = TreeCellRendererState.SELECTED_FOCUSED_NODE;
		assertEquals(expected, actual);
		// new scenario...
		actual = TreeCellRendererState.getState(false, true, false, true, true);
		expected = TreeCellRendererState.SELECTED_FOCUSED_NODE_WITH_CHILDREN;
		assertEquals(expected, actual);
		// new scenario...
		actual = TreeCellRendererState.getState(false, true, true, false, false);
		expected = TreeCellRendererState.EXPANDED_SELECTED_NODE;
		assertEquals(expected, actual);
		// new scenario...
		actual = TreeCellRendererState.getState(false, true, true, false, true);
		expected = TreeCellRendererState.EXPANDED_SELECTED_NODE_WITH_CHILDREN;
		assertEquals(expected, actual);
		// new scenario...
		actual = TreeCellRendererState.getState(false, true, true, true, false);
		expected = TreeCellRendererState.EXPANDED_SELECTED_FOCUSED_NODE;
		assertEquals(expected, actual);
		// new scenario...
		actual = TreeCellRendererState.getState(false, true, true, true, true);
		expected = TreeCellRendererState.EXPANDED_SELECTED_FOCUSED_NODE_WITH_CHILDREN;
		assertEquals(expected, actual);
		// leafs ...
		// new scenario...
		actual = TreeCellRendererState.getState(true, false, false, false, false);
		expected = TreeCellRendererState.LEAF;
		assertEquals(expected, actual);
		// new scenario...
		actual = TreeCellRendererState.getState(true, false, false, false, true);
		expected = TreeCellRendererState.LEAF;
		assertEquals(expected, actual);
		// new scenario...
		actual = TreeCellRendererState.getState(true, false, false, true, false);
		expected = TreeCellRendererState.LEAF;
		assertEquals(expected, actual);
		// new scenario...
		actual = TreeCellRendererState.getState(true, false, false, true, true);
		expected = TreeCellRendererState.LEAF;
		assertEquals(expected, actual);
		// new scenario...
		actual = TreeCellRendererState.getState(true, false, true, false, false);
		expected = TreeCellRendererState.LEAF;
		assertEquals(expected, actual);
		// new scenario...
		actual = TreeCellRendererState.getState(true, false, true, false, true);
		expected = TreeCellRendererState.LEAF;
		assertEquals(expected, actual);
		// new scenario...
		actual = TreeCellRendererState.getState(true, false, true, true, false);
		expected = TreeCellRendererState.LEAF;
		assertEquals(expected, actual);
		// new scenario...
		actual = TreeCellRendererState.getState(true, false, true, true, true);
		expected = TreeCellRendererState.LEAF;
		assertEquals(expected, actual);
		// new scenario...
		actual = TreeCellRendererState.getState(true, true, false, false, false);
		expected = TreeCellRendererState.SELECTED_LEAF;
		assertEquals(expected, actual);
		// new scenario...
		actual = TreeCellRendererState.getState(true, true, false, false, true);
		expected = TreeCellRendererState.SELECTED_LEAF;
		assertEquals(expected, actual);
		// new scenario...
		actual = TreeCellRendererState.getState(true, true, false, true, false);
		expected = TreeCellRendererState.SELECTED_FOCUSED_LEAF;
		assertEquals(expected, actual);
		// new scenario...
		actual = TreeCellRendererState.getState(true, true, false, true, true);
		expected = TreeCellRendererState.SELECTED_FOCUSED_LEAF;
		assertEquals(expected, actual);
		// new scenario...
		actual = TreeCellRendererState.getState(true, true, true, false, false);
		expected = TreeCellRendererState.SELECTED_LEAF;
		assertEquals(expected, actual);
		// new scenario...
		actual = TreeCellRendererState.getState(true, true, true, false, true);
		expected = TreeCellRendererState.SELECTED_LEAF;
		assertEquals(expected, actual);
		// new scenario...
		actual = TreeCellRendererState.getState(true, true, true, true, false);
		expected = TreeCellRendererState.SELECTED_FOCUSED_LEAF;
		assertEquals(expected, actual);
		// new scenario...
		actual = TreeCellRendererState.getState(true, true, true, true, true);
		expected = TreeCellRendererState.SELECTED_FOCUSED_LEAF;
		assertEquals(expected, actual);
	}

	@Test
	void getRenderState()
	{
		TreeCellRendererState actual;
		TreeCellRendererState expected;
		// new scenario...
		actual = TreeCellRendererState.getRenderState(false, false, false, false, false);
		expected = TreeCellRendererState.NODE;
		assertEquals(expected, actual);
		// new scenario...
		actual = TreeCellRendererState.getRenderState(false, false, false, false, true);
		expected = TreeCellRendererState.NODE_WITH_CHILDREN;
		assertEquals(expected, actual);
		// new scenario...
		actual = TreeCellRendererState.getRenderState(false, false, false, true, false);
		expected = TreeCellRendererState.NODE;
		assertEquals(expected, actual);
		// new scenario...
		actual = TreeCellRendererState.getRenderState(false, false, false, true, true);
		expected = TreeCellRendererState.NODE_WITH_CHILDREN;
		assertEquals(expected, actual);
		// new scenario...
		actual = TreeCellRendererState.getRenderState(false, false, true, false, false);
		expected = TreeCellRendererState.EXPANDED_NODE;
		assertEquals(expected, actual);
		// new scenario...
		actual = TreeCellRendererState.getRenderState(false, false, true, false, true);
		expected = TreeCellRendererState.EXPANDED_NODE_WITH_CHILDREN;
		assertEquals(expected, actual);
		// new scenario...
		actual = TreeCellRendererState.getRenderState(false, false, true, true, false);
		expected = TreeCellRendererState.EXPANDED_NODE;
		assertEquals(expected, actual);
		// new scenario...
		actual = TreeCellRendererState.getRenderState(false, false, true, true, true);
		expected = TreeCellRendererState.EXPANDED_NODE_WITH_CHILDREN;
		assertEquals(expected, actual);
		// new scenario...
		actual = TreeCellRendererState.getRenderState(false, true, false, false, false);
		expected = TreeCellRendererState.SELECTED_NODE;
		assertEquals(expected, actual);
		// new scenario...
		actual = TreeCellRendererState.getRenderState(false, true, false, false, true);
		expected = TreeCellRendererState.SELECTED_NODE_WITH_CHILDREN;
		assertEquals(expected, actual);
		// new scenario...
		actual = TreeCellRendererState.getRenderState(false, true, false, true, false);
		expected = TreeCellRendererState.SELECTED_FOCUSED_NODE;
		assertEquals(expected, actual);
		// new scenario...
		actual = TreeCellRendererState.getRenderState(false, true, false, true, true);
		expected = TreeCellRendererState.SELECTED_FOCUSED_NODE_WITH_CHILDREN;
		assertEquals(expected, actual);
		// new scenario...
		actual = TreeCellRendererState.getRenderState(false, true, true, false, false);
		expected = TreeCellRendererState.EXPANDED_SELECTED_NODE;
		assertEquals(expected, actual);
		// new scenario...
		actual = TreeCellRendererState.getRenderState(false, true, true, false, true);
		expected = TreeCellRendererState.EXPANDED_SELECTED_NODE_WITH_CHILDREN;
		assertEquals(expected, actual);
		// new scenario...
		actual = TreeCellRendererState.getRenderState(false, true, true, true, false);
		expected = TreeCellRendererState.EXPANDED_SELECTED_FOCUSED_NODE;
		assertEquals(expected, actual);
		// new scenario...
		actual = TreeCellRendererState.getRenderState(false, true, true, true, true);
		expected = TreeCellRendererState.EXPANDED_SELECTED_FOCUSED_NODE_WITH_CHILDREN;
		assertEquals(expected, actual);
		// leafs ...
		// new scenario...
		actual = TreeCellRendererState.getRenderState(true, false, false, false, false);
		expected = TreeCellRendererState.LEAF;
		assertEquals(expected, actual);
		// new scenario...
		actual = TreeCellRendererState.getRenderState(true, false, false, false, true);
		expected = TreeCellRendererState.LEAF;
		assertEquals(expected, actual);
		// new scenario...
		actual = TreeCellRendererState.getRenderState(true, false, false, true, false);
		expected = TreeCellRendererState.LEAF;
		assertEquals(expected, actual);
		// new scenario...
		actual = TreeCellRendererState.getRenderState(true, false, false, true, true);
		expected = TreeCellRendererState.LEAF;
		assertEquals(expected, actual);
		// new scenario...
		actual = TreeCellRendererState.getRenderState(true, false, true, false, false);
		expected = TreeCellRendererState.LEAF;
		assertEquals(expected, actual);
		// new scenario...
		actual = TreeCellRendererState.getRenderState(true, false, true, false, true);
		expected = TreeCellRendererState.LEAF;
		assertEquals(expected, actual);
		// new scenario...
		actual = TreeCellRendererState.getRenderState(true, false, true, true, false);
		expected = TreeCellRendererState.LEAF;
		assertEquals(expected, actual);
		// new scenario...
		actual = TreeCellRendererState.getRenderState(true, false, true, true, true);
		expected = TreeCellRendererState.LEAF;
		assertEquals(expected, actual);
		// new scenario...
		actual = TreeCellRendererState.getRenderState(true, true, false, false, false);
		expected = TreeCellRendererState.SELECTED_LEAF;
		assertEquals(expected, actual);
		// new scenario...
		actual = TreeCellRendererState.getRenderState(true, true, false, false, true);
		expected = TreeCellRendererState.SELECTED_LEAF;
		assertEquals(expected, actual);
		// new scenario...
		actual = TreeCellRendererState.getRenderState(true, true, false, true, false);
		expected = TreeCellRendererState.SELECTED_FOCUSED_LEAF;
		assertEquals(expected, actual);
		// new scenario...
		actual = TreeCellRendererState.getRenderState(true, true, false, true, true);
		expected = TreeCellRendererState.SELECTED_FOCUSED_LEAF;
		assertEquals(expected, actual);
		// new scenario...
		actual = TreeCellRendererState.getRenderState(true, true, true, false, false);
		expected = TreeCellRendererState.SELECTED_LEAF;
		assertEquals(expected, actual);
		// new scenario...
		actual = TreeCellRendererState.getRenderState(true, true, true, false, true);
		expected = TreeCellRendererState.SELECTED_LEAF;
		assertEquals(expected, actual);
		// new scenario...
		actual = TreeCellRendererState.getRenderState(true, true, true, true, false);
		expected = TreeCellRendererState.SELECTED_FOCUSED_LEAF;
		assertEquals(expected, actual);
		// new scenario...
		actual = TreeCellRendererState.getRenderState(true, true, true, true, true);
		expected = TreeCellRendererState.SELECTED_FOCUSED_LEAF;
		assertEquals(expected, actual);
	}

}
