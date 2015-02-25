/// package's name
package edu.gcsc.vrl.typesincubation;

/// imports
import edu.gcsc.vrl.typesincubation.components.FloatSliderArrayTypeTestComponent;
import edu.gcsc.vrl.typesincubation.components.DoubleSliderTypeTestComponent;
import edu.gcsc.vrl.typesincubation.components.DenseMatrixTypeTestComponent;
import edu.gcsc.vrl.typesincubation.components.SparseMatrixTypeTestComponent;
import edu.gcsc.vrl.typesincubation.components.DenseVectorTypeTestComponent;
import edu.gcsc.vrl.typesincubation.components.FloatSliderTypeTestComponent;
import edu.gcsc.vrl.typesincubation.components.DoubleSliderArrayTypeTestComponent;
import edu.gcsc.vrl.typesincubation.components.SparseVectorTypeTestComponent;
import edu.gcsc.vrl.typesincubation.components.FloatSliderTextFieldTypeTestComponent;
import edu.gcsc.vrl.typesincubation.components.DoubleSliderTextFieldTypeTestComponent;
import edu.gcsc.vrl.typesincubation.sliders.DoubleSliderType;
import edu.gcsc.vrl.typesincubation.sliders.DoubleSliderArrayType;
import edu.gcsc.vrl.typesincubation.sliders.DoubleSliderTextFieldType;
import eu.mihosoft.vrl.io.IOUtil;
import eu.mihosoft.vrl.io.VJarUtil;
import eu.mihosoft.vrl.io.VersionInfo;
import eu.mihosoft.vrl.lang.visual.CompletionUtil;
import eu.mihosoft.vrl.system.InitPluginAPI;
import eu.mihosoft.vrl.system.PluginAPI;
import eu.mihosoft.vrl.system.PluginDependency;
import eu.mihosoft.vrl.system.PluginIdentifier;
import eu.mihosoft.vrl.system.ProjectTemplate;
import eu.mihosoft.vrl.system.VPluginAPI;
import eu.mihosoft.vrl.system.VPluginConfigurator;
import eu.mihosoft.vrl.system.VRLPlugin;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Stephan Grein <stephan.grein@gcsc.uni-frankfurt.de>
 * @brief plugin configurator
 */
public class VRLIncubationTypesPluginConfigurator extends VPluginConfigurator {

	private File templateProjectSrc;

	public VRLIncubationTypesPluginConfigurator() {
		// identification of plugin, description and copyright
		setIdentifier(new PluginIdentifier("Incubation-Types-Plugin", "0.0.0"));

		setDescription("Incubation for VRL TypeRepresentations");

		setCopyrightInfo("VRLIncubationTypes",
			"(c) GCSC", "www.neurobox.eu", "license", "license text");

		// allow export package to use by other projects
		exportPackage("edu.gcsc.vrl.typesincubation");

		// specify dependencies
		addDependency(new PluginDependency("VRL", "0.4.2.7", VersionInfo.UNDEFINED));
	}

	@Override
	public void register(PluginAPI api) {
		// register plugin with canvas
		if (api instanceof VPluginAPI) {
			VPluginAPI vapi = (VPluginAPI) api;
			vapi.addTypeRepresentation(DoubleSliderType.class);
			vapi.addTypeRepresentation(DoubleSliderArrayType.class);
			vapi.addTypeRepresentation(DoubleSliderTextFieldType.class);
			vapi.addComponent(FloatSliderTypeTestComponent.class);
			vapi.addComponent(FloatSliderArrayTypeTestComponent.class);
			vapi.addComponent(FloatSliderTextFieldTypeTestComponent.class);
			vapi.addComponent(DoubleSliderTypeTestComponent.class);
			vapi.addComponent(DoubleSliderArrayTypeTestComponent.class);
			vapi.addComponent(DoubleSliderTextFieldTypeTestComponent.class);
			
			vapi.addComponent(DenseMatrixTypeTestComponent.class);
			vapi.addComponent(SparseMatrixTypeTestComponent.class);
			
			vapi.addComponent(DenseVectorTypeTestComponent.class);
			vapi.addComponent(SparseVectorTypeTestComponent.class);
			
			/**
			 * @note we can also add all classes via reflections 
			 */
			
		}
	}

	@Override
	public void unregister(PluginAPI api) {
		// nothing to unregister
	}

	@Override
	public void install(InitPluginAPI iApi) {
		// ensure template projects are updated
		new File(iApi.getResourceFolder(), "template-01.vrlp").delete();
	}

	@Override
	public void init(InitPluginAPI iApi) {

		CompletionUtil.registerClassesFromJar(
			VJarUtil.getClassLocation(VRLIncubationTypesPluginConfigurator.class));

		initTemplateProject(iApi);
	}

	private void initTemplateProject(InitPluginAPI iApi) {
		templateProjectSrc = new File(iApi.getResourceFolder(), "template-01.vrlp");

		if (!templateProjectSrc.exists()) {
			saveProjectTemplate();
		}

		iApi.addProjectTemplate(new ProjectTemplate() {

			@Override
			public String getName() {
				return "Incubation-Types Template 1 (Sliders)";
			}

			@Override
			public File getSource() {
				return templateProjectSrc;
			}

			@Override
			public String getDescription() {
				return "Test the visual representation of the " +
					"various slider types";
			}

			@Override
			public BufferedImage getIcon() {
				return null;
			}
		});
	}
	
	/**
	 * @todo add another template-02 and template-03 for matrices and vectors too
	 */
		
	private void saveProjectTemplate() {
		InputStream in = VRLIncubationTypesPluginConfigurator.class.getResourceAsStream(
			"/edu/gcsc/vrl/typesincubation/resources/projects/template-01.vrlp");
		try {
			IOUtil.saveStreamToFile(in, templateProjectSrc);
		} catch (FileNotFoundException ex) {
			Logger.getLogger(VRLPlugin.class.getName()).
				log(Level.SEVERE, null, ex);
		} catch (IOException ex) {
			Logger.getLogger(VRLPlugin.class.getName()).
				log(Level.SEVERE, null, ex);
		}
	}
}
