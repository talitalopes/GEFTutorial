package br.cos.ufrj.geftutorial;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.gef.DefaultEditDomain;
import org.eclipse.gef.palette.PaletteRoot;
import org.eclipse.gef.ui.parts.GraphicalEditorWithFlyoutPalette;

import br.cos.ufrj.geftutorial.model.Canvas;
import br.cos.ufrj.geftutorial.parts.GEFEditorEditPartFactory;

public class GEFEditor extends GraphicalEditorWithFlyoutPalette {

	public GEFEditor() {
	    setEditDomain(new DefaultEditDomain(this));		
	}

	@Override
	protected PaletteRoot getPaletteRoot() {
		return new GEFEditorPalette();
	}

	@Override
	public void doSave(IProgressMonitor arg0) {
	}

	@Override
	protected void initializeGraphicalViewer() {
		super.initializeGraphicalViewer();
		getGraphicalViewer().setEditPartFactory(new GEFEditorEditPartFactory());
		getGraphicalViewer().setContents(new Canvas());
	}
}
