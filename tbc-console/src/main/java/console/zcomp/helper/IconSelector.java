package console.zcomp.helper;

import com.google.gwt.cell.client.Cell;
import com.google.gwt.resources.client.ImageResource;

public interface IconSelector<T> {

	ImageResource selectIcon(Cell.Context context, T value);
}