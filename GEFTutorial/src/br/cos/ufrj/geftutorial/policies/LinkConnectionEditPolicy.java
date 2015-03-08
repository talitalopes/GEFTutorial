package br.cos.ufrj.geftutorial.policies;

import org.eclipse.gef.commands.Command;
import org.eclipse.gef.editpolicies.ConnectionEditPolicy;
import org.eclipse.gef.requests.GroupRequest;

import br.cos.ufrj.geftutorial.commands.DeleteLinkCommand;
import br.cos.ufrj.geftutorial.model.Link;

public class LinkConnectionEditPolicy extends ConnectionEditPolicy {

	@Override
	protected Command getDeleteCommand(GroupRequest request) {
		Link link = (Link) getHost().getModel();
		return new DeleteLinkCommand(link);
	}

}