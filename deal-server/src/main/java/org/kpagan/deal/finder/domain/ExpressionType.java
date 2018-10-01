/**
 * 
 */
package org.kpagan.deal.finder.domain;

/**
 * @author paganelis
 *
 */
public enum ExpressionType {

	/**
	 * locates elements by the value of the "id" attribute
	 */
	ID,
	/**
	 * locates A elements by the exact text they display
	 */
	LINK_TEXT,
	/**
	 * locates A elements that contain the given text
	 */
	PARTIAL_LINK_TEXT,
	/**
	 * locates elements by the value of the "name" attribute
	 */
	NAME,
	/**
	 * locates elements by their tag name
	 */
	TAG_NAME,
	/**
	 * locates elements via XPath
	 */
	XPATH,
	/**
	 * locates elements by the value of the "class" attribute
	 */
	CLASS_NAME,
	/**
	 * locates elements by CSS
	 */
	CSS_SELECTOR
	
}
