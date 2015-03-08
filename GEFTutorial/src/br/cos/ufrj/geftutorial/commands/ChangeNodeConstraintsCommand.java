package br.cos.ufrj.geftutorial.commands;

import org.eclipse.gef.commands.Command;

import br.cos.ufrj.geftutorial.model.Node;

public class ChangeNodeConstraintsCommand extends Command {

	int x;
	int y;
	int w;
	int h;
	Node node;

	public ChangeNodeConstraintsCommand(Node node, int x, int y, int w, int h) {
		this.node = node;
		this.x = x;
		this.y = y;
		this.w = w;
		this.h = h;
	}

	@Override
	public void execute() {
		node.setConstraints(x, y, w, h);
	}
}