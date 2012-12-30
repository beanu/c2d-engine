package info.u250.spriter.dom;

/**
 * <p>
 * Java class for AnimationObjectRef complex type.
 * 
 * <p>
 * The following schema fragment specifies the expected content contained within
 * this class.
 * 
 * <pre>
 * &lt;complexType name="AnimationObjectRef">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;attribute name="id" type="{http://www.w3.org/2001/XMLSchema}int" />
 *       &lt;attribute name="timeline" type="{http://www.w3.org/2001/XMLSchema}int" />
 *       &lt;attribute name="key" type="{http://www.w3.org/2001/XMLSchema}int" />
 *       &lt;attribute name="z_index" type="{http://www.w3.org/2001/XMLSchema}int" />
 *       &lt;attribute name="parent" type="{http://www.w3.org/2001/XMLSchema}int" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */

public class AnimationObjectRef {

	protected Integer id;

	protected Integer timeline;

	protected Integer key;

	protected Integer zIndex;

	protected Integer parent;

	/**
	 * Gets the value of the id property.
	 * 
	 * @return possible object is {@link Integer }
	 * 
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * Sets the value of the id property.
	 * 
	 * @param value
	 *            allowed object is {@link Integer }
	 * 
	 */
	public void setId(Integer value) {
		this.id = value;
	}

	/**
	 * Gets the value of the timeline property.
	 * 
	 * @return possible object is {@link Integer }
	 * 
	 */
	public Integer getTimeline() {
		return timeline;
	}

	/**
	 * Sets the value of the timeline property.
	 * 
	 * @param value
	 *            allowed object is {@link Integer }
	 * 
	 */
	public void setTimeline(Integer value) {
		this.timeline = value;
	}

	/**
	 * Gets the value of the key property.
	 * 
	 * @return possible object is {@link Integer }
	 * 
	 */
	public Integer getKey() {
		return key;
	}

	/**
	 * Sets the value of the key property.
	 * 
	 * @param value
	 *            allowed object is {@link Integer }
	 * 
	 */
	public void setKey(Integer value) {
		this.key = value;
	}

	/**
	 * Gets the value of the zIndex property.
	 * 
	 * @return possible object is {@link Integer }
	 * 
	 */
	public Integer getZIndex() {
		return zIndex;
	}

	/**
	 * Sets the value of the zIndex property.
	 * 
	 * @param value
	 *            allowed object is {@link Integer }
	 * 
	 */
	public void setZIndex(Integer value) {
		this.zIndex = value;
	}

	/**
	 * Gets the value of the parent property.
	 * 
	 * @return possible object is {@link Integer }
	 * 
	 */
	public Integer getParent() {
		return parent;
	}

	/**
	 * Sets the value of the parent property.
	 * 
	 * @param value
	 *            allowed object is {@link Integer }
	 * 
	 */
	public void setParent(Integer value) {
		this.parent = value;
	}

}
