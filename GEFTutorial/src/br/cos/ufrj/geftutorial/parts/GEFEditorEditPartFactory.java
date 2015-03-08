package br.cos.ufrj.geftutorial.parts;

import org.eclipse.gef.EditPart;
import org.eclipse.gef.EditPartFactory;

import br.cos.ufrj.geftutorial.model.Canvas;
import br.cos.ufrj.geftutorial.model.Link;
import br.cos.ufrj.geftutorial.model.Node;

public class GEFEditorEditPartFactory implements EditPartFactory {

	@Override
	public EditPart createEditPart(EditPart context, Object model) {
		if (model.getClass().equals(Node.class)) {
			return new NodeEditPart((Node) model);
		}
		
		if (model.getClass().equals(Canvas.class)) {
			return new CanvasEditPart((Canvas) model);
		}
		
		if (model.getClass().equals(Link.class)) {
			return new LinkEditPart((Link) model);
		}
		
		throw new IllegalArgumentException("Model entity not supported yet.");
	}

}
