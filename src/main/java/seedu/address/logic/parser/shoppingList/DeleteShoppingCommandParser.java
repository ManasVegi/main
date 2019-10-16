package seedu.address.logic.parser.shoppingList;

import static seedu.address.commons.core.Messages.MESSAGE_INVALID_COMMAND_FORMAT;

import seedu.address.commons.core.index.Index;
import seedu.address.logic.commands.shoppingList.DeleteShoppingCommand;
import seedu.address.logic.parser.Parser;
import seedu.address.logic.parser.ParserUtil;
import seedu.address.logic.parser.exceptions.ParseException;

/**
 * Parses input arguments and creates a new DeleteShoppingCommand object
 */
public class DeleteShoppingCommandParser implements Parser<DeleteShoppingCommand> {

    /**
     * Parses the given {@code String} of arguments in the context of the DeleteShoppingCommand
     * and returns a DeleteShoppingCommand object for execution.
     * @throws ParseException if the user input does not conform the expected format
     */
    public DeleteShoppingCommand parse(String args) throws ParseException {
        try {
            Index index = ParserUtil.parseIndex(args);
            return new DeleteShoppingCommand(index);
        } catch (ParseException pe) {
            throw new ParseException(
                    String.format(MESSAGE_INVALID_COMMAND_FORMAT, DeleteShoppingCommand.MESSAGE_USAGE), pe);
        }
    }

}

