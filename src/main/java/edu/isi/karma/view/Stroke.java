/**
 * 
 */
package edu.isi.karma.view;

import java.util.Collection;
import java.util.Iterator;

/**
 * @author szekely
 * 
 */
public class Stroke {

	private static Stroke rootStroke = new Stroke(StrokeStyle.none, "root", 0);

	public static Stroke getRootStroke() {
		return rootStroke;
	}

	public enum StrokeStyle {
		outer, inner, none
	}

	private final StrokeStyle style;

	private final String hTableId;

	private final int depth;

	public Stroke(StrokeStyle style, String hTableId, int depth) {
		super();
		this.style = style;
		this.hTableId = hTableId;
		this.depth = depth;
	}

	public Stroke(int depth){
		this(StrokeStyle.none, "dummy", depth);
	}
	
	public StrokeStyle getStyle() {
		return style;
	}

	public String gethTableId() {
		return hTableId;
	}

	public int getDepth() {
		return depth;
	}

	public String toString() {
		return "s(" + depth + ":" + style.name() + ":" + hTableId + ")";
	}

	public static String toString(Collection<Stroke> strokeList) {
		StringBuffer b = new StringBuffer();
		Iterator<Stroke> it = strokeList.iterator();
		while (it.hasNext()) {
			b.append(it.next().toString());
			if (it.hasNext()) {
				b.append("/");
			}
		}
		return b.toString();
	}
}