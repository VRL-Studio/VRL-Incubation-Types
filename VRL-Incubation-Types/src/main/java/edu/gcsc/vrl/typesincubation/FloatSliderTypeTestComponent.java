/// package's name
package edu.gcsc.vrl.typesincubation;

/// imports
import eu.mihosoft.vrl.annotation.ComponentInfo;
import eu.mihosoft.vrl.annotation.ParamInfo;
import java.io.Serializable;

/**
 *
 * @author stephan
 */
@ComponentInfo(name = "FloatSliderTypeTestComponent", category = "Custom/TypesIncubation/Sliders")
public class FloatSliderTypeTestComponent implements Serializable {

	private static final long serialVersionUID = 1L;

	/**
	 *
	 * @param f 
	 */
	public void test(
		@ParamInfo(name = "A float slider", typeName = "Float slider", style = "slider", options = "value=0; min=-100; max=100; step=0.1") Float f) {

	}

}
