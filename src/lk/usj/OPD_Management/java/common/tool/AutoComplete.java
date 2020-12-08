package lk.usj.OPD_Management.java.common.tool;//package lk.ijse.login.tool;
//
//import com.jfoenix.controls.JFXTextField;
//import impl.org.controlsfx.autocompletion.AutoCompletionTextFieldBinding;
//import impl.org.controlsfx.autocompletion.SuggestionProvider;
//import javafx.collections.ObservableList;
//import javafx.event.EventHandler;
//import javafx.scene.control.TextField;
//import org.controlsfx.control.textfield.AutoCompletionBinding;
//
//import java.util.HashSet;
//import java.util.Set;
//
//public final class AutoComplete<T extends SearchProvider> {
//    private final TextField textField;
//    // T is the Class of the list.
//
//    private Set<T> autoCompletions;
//    private SuggestionProvider<T> provider;
//    private ObservableList<T> resultSet;
//    private AutoCompletionTextFieldBinding<T> tAutoCompletionTextFieldBinding;
//
//    public AutoComplete(TextField textField) {
//        this.textField = textField;
//        autoCompletions = new HashSet<>();
//        provider = SuggestionProvider.create(autoCompletions);
//        tAutoCompletionTextFieldBinding = new AutoCompletionTextFieldBinding<>(textField, provider);
//    }
//
//    public AutoComplete(JFXTextField textField, ObservableList<T> resultSet) {
//        this(textField);
//        changeSuggestion(resultSet);
//    }
//
//    private void change() {
//        provider.clearSuggestions();
//        autoCompletions = new HashSet<>(resultSet);
//
//        provider.addPossibleSuggestions(autoCompletions);
//
//    }
//
//    public void changeSuggestion(ObservableList<T> list) {
//        this.resultSet = list;
//        change();
//    }
//
//    public void setAutoCompletionsAction(EventHandler<AutoCompletionBinding.AutoCompletionEvent<T>> e) {
//        tAutoCompletionTextFieldBinding.setOnAutoCompleted(e);
//    }
//
//    public T getSelectedItemByName() {
//        if (resultSet == null || textField == null) return null;
//        String name = textField.getText().trim();
//        for (T oneItem : resultSet) {
//            if (oneItem.getName().equals(name)) {
//                return oneItem;
//            }
//
//        }
//        return null;
//    }
//
//    public T getSelectedItemByID() {
//        String id = textField.getText().trim();
//        for (T oneItem : resultSet) {
//            if (oneItem.getID() == Integer.parseInt(id))
//                return oneItem;
//        }
//        return null;
//    }
//
//    public T searchByID(int id) {
//        for (T oneItem : resultSet) {
//            if (oneItem.getID() == id)
//                return oneItem;
//        }
//        return null;
//    }
//
//    public T searchByID(String id) {
//        return searchByID(Integer.parseInt(id));
//    }
//
//    public boolean isResultSetEmpty() {
//        return resultSet == null;
//    }
//}
