package tac.program.interfaces;

import tac.gui.components.AtlasTree;
import tac.program.model.AtlasTreeModel;

/**
 * Identifies nodes in {@link AtlasTree} / {@link AtlasTreeModel} that can be
 * deleted (including sub-nodes). Nodes implementing this interface will show a
 * "delete" entry in it's context menu.
 */
public interface CapabilityDeletable {

	public void delete();
}
