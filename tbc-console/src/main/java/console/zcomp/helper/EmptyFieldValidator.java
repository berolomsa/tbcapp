package console.zcomp.helper;

import com.google.gwt.editor.client.Editor;
import com.google.gwt.editor.client.EditorError;
import com.sencha.gxt.widget.core.client.form.error.DefaultEditorError;
import com.sencha.gxt.widget.core.client.form.validator.AbstractValidator;

import java.util.List;

public class EmptyFieldValidator extends AbstractValidator<String> {

	@Override
	public List<EditorError> validate(Editor<String> editor, String value) {
		if (value == null || value.trim().isEmpty()) {
			return createError(new DefaultEditorError(editor, "Required field", value));
		}
		return null;
	}
}