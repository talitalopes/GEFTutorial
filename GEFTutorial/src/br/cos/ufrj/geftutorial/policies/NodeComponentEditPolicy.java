package br.cos.ufrj.geftutorial.policies;

import org.eclipse.gef.commands.Command;
import org.eclipse.gef.commands.CompoundCommand;
import org.eclipse.gef.editpolicies.ComponentEditPolicy;
import org.eclipse.gef.requests.GroupRequest;

import br.cos.ufrj.geftutorial.commands.DeleteLinkCommand;
import br.cos.ufrj.geftutorial.commands.DeleteNodeCommand;
import br.cos.ufrj.geftutorial.model.Canvas;
import br.cos.ufrj.geftutorial.model.Link;
import br.cos.ufrj.geftutorial.model.Node;

public class NodeComponentEditPolicy extends ComponentEditPolicy {
	@Override
	protected Command createDeleteCommand(GroupRequest deleteRequest) {
		Node node = (Node) getHost().getModel();
		Canvas canvas = (Canvas) getHost().getParent().getModel();
		CompoundCommand command = new CompoundCommand();
		for (Link link : node.getOutgoingLinks()) {
			command.add(new DeleteLinkCommand(link));
		}
		for (Link link : node.getIncomingLinks()) {
			command.add(new DeleteLinkCommand(link));
		}
		command.add(new DeleteNodeCommand(canvas, node));

		return command;
	}
}