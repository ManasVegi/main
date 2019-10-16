package seedu.address.ui;

import java.util.logging.Logger;

import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.layout.Region;

import seedu.address.commons.core.LogsCenter;
import seedu.address.model.food.TemplateItem;


/**
 * Panel containing the list of template items.
 */
public class TemplateItemPanel extends UiPart<Region> {
    private static final String FXML = "TemplateItemPanel.fxml";
    private final Logger logger = LogsCenter.getLogger(TemplateItemPanel.class);

    @FXML
    private ListView<TemplateItem> templateItemView;

    public TemplateItemPanel(ObservableList<TemplateItem> templateItemList) {
        super(FXML);
        templateItemView.setItems(templateItemList);
        templateItemView.setCellFactory(listView -> new TemplateItemViewCell());
    }

    /**
     * Custom {@code ListCell} that displays the graphics of a {@code TemplateItem} using a {@code TemplateItemCard}.
     */
    class TemplateItemViewCell extends ListCell<TemplateItem> {
        @Override
        protected void updateItem(TemplateItem templateItem, boolean empty) {
            super.updateItem(templateItem, empty);

            if (empty || templateItem == null) {
                setGraphic(null);
                setText(null);
            } else {
                setGraphic(new TemplateItemCard(templateItem, getIndex() + 1).getRoot());
            }
        }
    }

}
