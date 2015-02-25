/// package's name
package edu.gcsc.vrl.typesincubation.components;

/// imports
import eu.mihosoft.vrl.annotation.ComponentInfo;
import eu.mihosoft.vrl.annotation.ParamInfo;
import java.io.Serializable;

/**
 *
 * @author stephan
 */
@ComponentInfo(name="DoubleSliderTextFieldTypeTestComponent", category="Custom/TypesIncubation/Sliders")
public class DoubleSliderTextFieldTypeTestComponent implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 *
	 * @param d
	 */
	public void test(
		@ParamInfo(name = "A double slider with textfield", typeName = "Double slider with textfield", style = "slider-textfield", options = "value=0; min=-100; max=100; step=0.1") Double d) {

	}

}
