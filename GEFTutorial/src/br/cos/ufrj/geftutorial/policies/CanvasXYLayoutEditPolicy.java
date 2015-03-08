package br.cos.ufrj.geftutorial.policies;

import org.eclipse.gef.commands.Command;
import org.eclipse.gef.editpolicies.XYLayoutEditPolicy;
import org.eclipse.gef.requests.CreateRequest;

import br.cos.ufrj.geftutorial.commands.CreateNodeCommand;
import br.cos.ufrj.geftutorial.model.Canvas;
import br.cos.ufrj.geftutorial.model.Node;

public class CanvasXYLayoutEditPolicy extends XYLayoutEditPolicy {

	@Override
	protected Command getCreateCommand(CreateRequest request) {
		Node node = (Node) request.getNewObject();
		node.setX(request.getLocation().x);
		node.setY(request.getLocation().y);
		node.setW(50);
		node.setH(50);
		Canvas canvas = (Canvas) getHost().getModel();
		return new CreateNodeCommand(canvas, node);
	}
}