package console.zcomp.helper;

import com.google.gwt.cell.client.Cell;

public interface BooleanStateSelector<T> {

	boolean check(Cell.Context context, T value);
}