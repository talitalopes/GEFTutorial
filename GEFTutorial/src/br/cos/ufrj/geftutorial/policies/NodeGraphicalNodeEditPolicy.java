package br.cos.ufrj.geftutorial.policies;

import org.eclipse.gef.commands.Command;
import org.eclipse.gef.editpolicies.GraphicalNodeEditPolicy;
import org.eclipse.gef.requests.CreateConnectionRequest;
import org.eclipse.gef.requests.ReconnectRequest;

import br.cos.ufrj.geftutorial.commands.CreateLinkCommand;
import br.cos.ufrj.geftutorial.model.Link;
import br.cos.ufrj.geftutorial.model.Node;

public class NodeGraphicalNodeEditPolicy extends GraphicalNodeEditPolicy {

	@Override
	protected Command getConnectionCompleteCommand(
			CreateConnectionRequest request) {
		CreateLinkCommand command = (CreateLinkCommand) request
				.getStartCommand();
		command.setTarget((Node) getHost().getModel());
		return command;
	}

	@Override
	protected Command getConnectionCreateCommand(CreateConnectionRequest request) {
		Node source = (Node) getHost().getModel();
		Link link = (Link) request.getNewObject();
		CreateLinkCommand command = new CreateLinkCommand(link, source);
		request.setStartCommand(command);
		return command;
	}

	@Override
	protected Command getReconnectTargetCommand(ReconnectRequest request) {
		return null;
	}

	@Override
	protected Command getReconnectSourceCommand(ReconnectRequest request) {
		return null;
	}

}