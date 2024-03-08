package io.kowsu.dp.behavioral;

public class CommandPattern {

    public static void main(String[] args) {
        System.out.println("Copy command ");
        CommandInvoker copyCommandInvoker = new CommandInvoker(new CopyCommandImpl(new CopyCommand()));
        System.out.println("Cut command");
        CommandInvoker cutCommandInvoker = new CommandInvoker(new CutCommandImpl(new CutCommand()));
    }
}

/**
 * Command interface
 */
interface TextEditorCommand {
    void execute();
}

/**
 * CommandInvoker
 */

class CommandInvoker {
    private final TextEditorCommand command;

    public CommandInvoker(TextEditorCommand command) {
        this.command = command;
    }

    public void invoke() {
        this.command.execute();
    }

}

/**
 * Cut command concrete implementation
 */

class CutCommandImpl implements TextEditorCommand {

    private final CutCommand command;

    public CutCommandImpl(CutCommand command) {
        this.command = command;
    }
    @Override
    public void execute() {
        this.command.cut();
    }
}


/**
 * Copy command concrete implementation
 */
class CopyCommandImpl implements TextEditorCommand {

    private final CopyCommand command;

    public CopyCommandImpl(CopyCommand command) {
        this.command = command;
    }
    @Override
    public void execute() {
        this.command.copy();
    }
}


/**
 * Cut Command Receiver
 */

class CutCommand {
    public void cut() {
        System.out.println("Cut action done");
    }
}

/**
 * Copy command receiver
 */
class CopyCommand {
    public void copy() {
        System.out.println("Copy action done");
    }
}