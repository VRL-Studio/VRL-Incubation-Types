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
@ComponentInfo(name="FloatSliderTextFieldTypeTestComponent", category="Custom/TypesIncubation/Sliders")
public class FloatSliderTextFieldTypeTestComponent implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 *
	 * @param f
	 */
	public void test(
		@ParamInfo(name = "A float slider with textfield", typeName = "Float slider with textfield", style = "slider-textfield", options = "value=0; min=-100; max=100; step=0.1") Float f) {

	}

}
