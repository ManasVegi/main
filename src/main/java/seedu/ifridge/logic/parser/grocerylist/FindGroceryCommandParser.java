package seedu.ifridge.logic.parser.grocerylist;

import static seedu.ifridge.commons.core.Messages.MESSAGE_INVALID_COMMAND_FORMAT;

import java.util.Arrays;

import seedu.ifridge.logic.commands.grocerylist.FindGroceryCommand;
import seedu.ifridge.logic.parser.Parser;
import seedu.ifridge.logic.parser.exceptions.ParseException;
import seedu.ifridge.model.food.NameContainsKeywordsPredicate;

/**
 * Parses input arguments and creates a new FindCommand object
 */
public class FindGroceryCommandParser implements Parser<FindGroceryCommand> {

    /**
     * Parses the given {@code String} of arguments in the context of the FindCommand
     * and returns a FindCommand object for execution.
     * @throws ParseException if the user input does not conform the expected format
     */
    public FindGroceryCommand parse(String args) throws ParseException {
        String trimmedArgs = args.trim();
        if (trimmedArgs.isEmpty()) {
            throw new ParseException(
                    String.format(MESSAGE_INVALID_COMMAND_FORMAT, FindGroceryCommand.MESSAGE_USAGE));
        }

        String[] nameKeywords = trimmedArgs.split("\\s+");

        return new FindGroceryCommand(new NameContainsKeywordsPredicate(Arrays.asList(nameKeywords)));
    }

}
