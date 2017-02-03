package console.zcomp.helper;

import com.google.gwt.cell.client.Cell;

public interface TooltipSelector<T> {

	String selectTooltip(Cell.Context context, T value);
}