/*
 * generated by Xtext
 */
package org.jnario.spec.ui;

import org.eclipse.xtext.ui.guice.AbstractGuiceAwareExecutableExtensionFactory;
import org.osgi.framework.Bundle;

import com.google.inject.Injector;

/**
 * This class was generated. Customizations should only happen in a newly
 * introduced subclass. 
 */
public class SpecExecutableExtensionFactory extends AbstractGuiceAwareExecutableExtensionFactory {

	@Override
	protected Bundle getBundle() {
		return org.jnario.spec.ui.internal.SpecActivator.getInstance().getBundle();
	}
	
	@Override
	protected Injector getInjector() {
		return org.jnario.spec.ui.internal.SpecActivator.getInstance().getInjector("org.jnario.spec.Spec");
	}
	
}
