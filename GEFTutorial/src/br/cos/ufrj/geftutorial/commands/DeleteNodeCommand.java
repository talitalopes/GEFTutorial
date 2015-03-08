package br.cos.ufrj.geftutorial.commands;

import org.eclipse.gef.commands.Command;

import br.cos.ufrj.geftutorial.model.Canvas;
import br.cos.ufrj.geftutorial.model.Node;

public class DeleteNodeCommand extends Command {

	private Canvas canvas;
	private Node node;

	public DeleteNodeCommand(Canvas canvas, Node node) {
		this.canvas = canvas;
		this.node = node;
	}

	@Override
	public void execute() {
		canvas.removeNode(node);
	}

	@Override
	public void undo() {
		canvas.addNode(node);
	}

}