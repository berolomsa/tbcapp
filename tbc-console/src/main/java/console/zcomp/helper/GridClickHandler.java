package console.zcomp.helper;

import com.google.gwt.cell.client.Cell;

public interface GridClickHandler<T> {

	void onClick(Cell.Context context, T value);
}