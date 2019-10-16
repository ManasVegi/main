package seedu.address.logic.commands;

import static java.util.Objects.requireNonNull;
import static seedu.address.logic.parser.CliSyntax.PREFIX_AMOUNT;
import static seedu.address.logic.parser.CliSyntax.PREFIX_EXPIRY_DATE;
import static seedu.address.logic.parser.CliSyntax.PREFIX_NAME;
import static seedu.address.logic.parser.CliSyntax.PREFIX_TAG;

import seedu.address.logic.commands.exceptions.CommandException;
import seedu.address.model.Model;
import seedu.address.model.food.GroceryItem;

/**
 * Adds a person to the address book.
 */
public class AddGroceryCommand extends Command {

    public static final String COMMAND_WORD = "add";

    public static final String MESSAGE_USAGE = COMMAND_WORD + ": Adds a food item to the grocery list. "
            + "Parameters: "
            + PREFIX_NAME + "NAME "
            + PREFIX_AMOUNT + "AMOUNT "
            + PREFIX_EXPIRY_DATE + "EXPIRY_DATE "
            + "[" + PREFIX_TAG + "TAG]...\n"
            + "Example: " + COMMAND_WORD + " "
            + PREFIX_NAME + "Apples "
            + PREFIX_AMOUNT + "300g"
            + PREFIX_EXPIRY_DATE + "30.11.2019"
            + PREFIX_TAG + "healthy "
            + PREFIX_TAG + "fruit";

    public static final String MESSAGE_SUCCESS = "New food item added: %1$s";
    public static final String MESSAGE_DUPLICATE_PERSON = "This food item already exists in the grocery list";

    private final GroceryItem toAdd;

    /**
     * Creates an AddGroceryCommand to add the specified {@code Person}
     */
    public AddGroceryCommand(GroceryItem food) {
        requireNonNull(food);
        toAdd = food;
    }

    @Override
    public CommandResult execute(Model model) throws CommandException {
        requireNonNull(model);

        if (model.hasGroceryItem(toAdd)) {
            throw new CommandException(MESSAGE_DUPLICATE_PERSON);
        }

        model.addGroceryItem(toAdd);
        return new CommandResult(String.format(MESSAGE_SUCCESS, toAdd));
    }

    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof AddGroceryCommand // instanceof handles nulls
                && toAdd.equals(((AddGroceryCommand) other).toAdd));
    }
}