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
package io.github.astrapi69.swing.tree.renderer.state;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import io.github.astrapi69.swing.renderer.tree.renderer.state.SimpleTreeCellRendererState;

class SimpleTreeCellRendererStateTest
{

	@Test
	void getState()
	{
		SimpleTreeCellRendererState actual;
		SimpleTreeCellRendererState expected;
		// new scenario...
		actual = SimpleTreeCellRendererState.getState(true, false, false);
		expected = SimpleTreeCellRendererState.LEAF;
		assertEquals(expected, actual);
		// new scenario...
		actual = SimpleTreeCellRendererState.getState(true, false, true);
		expected = SimpleTreeCellRendererState.LEAF;
		assertEquals(expected, actual);
		// new scenario...
		actual = SimpleTreeCellRendererState.getState(true, true, false);
		expected = SimpleTreeCellRendererState.SELECTED_LEAF;
		assertEquals(expected, actual);
		// new scenario...
		actual = SimpleTreeCellRendererState.getState(true, true, true);
		expected = SimpleTreeCellRendererState.SELECTED_LEAF;
		assertEquals(expected, actual);
		// new scenario...
		actual = SimpleTreeCellRendererState.getState(false, false, false);
		expected = SimpleTreeCellRendererState.NODE;
		assertEquals(expected, actual);
		// new scenario...
		actual = SimpleTreeCellRendererState.getState(false, true, false);
		expected = SimpleTreeCellRendererState.SELECTED_NODE;
		assertEquals(expected, actual);
		// new scenario...
		actual = SimpleTreeCellRendererState.getState(false, true, true);
		expected = SimpleTreeCellRendererState.SELECTED_NODE_WITH_CHILDREN;
		assertEquals(expected, actual);
		// new scenario...
		actual = SimpleTreeCellRendererState.getState(false, false, true);
		expected = SimpleTreeCellRendererState.NODE_WITH_CHILDREN;
		assertEquals(expected, actual);
	}

	@Test
	void getRenderState()
	{
		SimpleTreeCellRendererState actual;
		SimpleTreeCellRendererState expected;
		// new scenario...
		actual = SimpleTreeCellRendererState.getRenderState(true, false, false);
		expected = SimpleTreeCellRendererState.LEAF;
		assertEquals(expected, actual);
		// new scenario...
		actual = SimpleTreeCellRendererState.getRenderState(true, false, true);
		expected = SimpleTreeCellRendererState.LEAF;
		assertEquals(expected, actual);
		// new scenario...
		actual = SimpleTreeCellRendererState.getRenderState(true, true, false);
		expected = SimpleTreeCellRendererState.SELECTED_LEAF;
		assertEquals(expected, actual);
		// new scenario...
		actual = SimpleTreeCellRendererState.getRenderState(true, true, true);
		expected = SimpleTreeCellRendererState.SELECTED_LEAF;
		assertEquals(expected, actual);
		// new scenario...
		actual = SimpleTreeCellRendererState.getRenderState(false, false, false);
		expected = SimpleTreeCellRendererState.NODE;
		assertEquals(expected, actual);
		// new scenario...
		actual = SimpleTreeCellRendererState.getRenderState(false, true, false);
		expected = SimpleTreeCellRendererState.SELECTED_NODE;
		assertEquals(expected, actual);
		// new scenario...
		actual = SimpleTreeCellRendererState.getRenderState(false, true, true);
		expected = SimpleTreeCellRendererState.SELECTED_NODE_WITH_CHILDREN;
		assertEquals(expected, actual);
		// new scenario...
		actual = SimpleTreeCellRendererState.getRenderState(false, false, true);
		expected = SimpleTreeCellRendererState.NODE_WITH_CHILDREN;
		assertEquals(expected, actual);
	}
}
