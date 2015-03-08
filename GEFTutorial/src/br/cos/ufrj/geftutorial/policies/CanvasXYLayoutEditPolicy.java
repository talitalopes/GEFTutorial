package br.cos.ufrj.geftutorial.policies;

import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.editpolicies.XYLayoutEditPolicy;
import org.eclipse.gef.requests.ChangeBoundsRequest;
import org.eclipse.gef.requests.CreateRequest;

import br.cos.ufrj.geftutorial.commands.ChangeNodeConstraintsCommand;
import br.cos.ufrj.geftutorial.commands.CreateNodeCommand;
import br.cos.ufrj.geftutorial.model.Canvas;
import br.cos.ufrj.geftutorial.model.Node;

public class CanvasXYLayoutEditPolicy extends XYLayoutEditPolicy {

	@Override
	protected Command getCreateCommand(CreateRequest request) {
		Node node = (Node) request.getNewObject();
		node.setConstraints(request.getLocation().x, request.getLocation().y,
				50, 50);
		Canvas canvas = (Canvas) getHost().getModel();
		return new CreateNodeCommand(canvas, node);
	}

	@Override
	protected Command createChangeConstraintCommand(
			ChangeBoundsRequest request, EditPart child, Object constraint) {
		Rectangle r = (Rectangle) constraint;
		ChangeNodeConstraintsCommand command = new ChangeNodeConstraintsCommand(
				(Node) child.getModel(), r.x, r.y, r.width, r.height);
		return command;
	}
}