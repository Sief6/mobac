//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, vJAXB 2.1.3 in JDK 1.6 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2009.08.04 at 03:17:38 PM MESZ 
//

package tac.data.gpx.gpx10;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAnyElement;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;

import tac.data.gpx.common.BoundsType;

/**
 * <p>
 * Java class for anonymous complex type.
 * 
 * <p>
 * The following schema fragment specifies the expected content contained within
 * this class.
 * 
 * <pre>
 * &lt;complexType&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base=&quot;{http://www.w3.org/2001/XMLSchema}anyType&quot;&gt;
 *       &lt;sequence&gt;
 *         &lt;element name=&quot;name&quot; type=&quot;{http://www.w3.org/2001/XMLSchema}string&quot; minOccurs=&quot;0&quot;/&gt;
 *         &lt;element name=&quot;desc&quot; type=&quot;{http://www.w3.org/2001/XMLSchema}string&quot; minOccurs=&quot;0&quot;/&gt;
 *         &lt;element name=&quot;author&quot; type=&quot;{http://www.w3.org/2001/XMLSchema}string&quot; minOccurs=&quot;0&quot;/&gt;
 *         &lt;element name=&quot;email&quot; type=&quot;{http://www.topografix.com/GPX/1/0}emailType&quot; minOccurs=&quot;0&quot;/&gt;
 *         &lt;element name=&quot;url&quot; type=&quot;{http://www.w3.org/2001/XMLSchema}anyURI&quot; minOccurs=&quot;0&quot;/&gt;
 *         &lt;element name=&quot;urlname&quot; type=&quot;{http://www.w3.org/2001/XMLSchema}string&quot; minOccurs=&quot;0&quot;/&gt;
 *         &lt;element name=&quot;time&quot; type=&quot;{http://www.w3.org/2001/XMLSchema}dateTime&quot; minOccurs=&quot;0&quot;/&gt;
 *         &lt;element name=&quot;keywords&quot; type=&quot;{http://www.w3.org/2001/XMLSchema}string&quot; minOccurs=&quot;0&quot;/&gt;
 *         &lt;element name=&quot;bounds&quot; type=&quot;{http://www.topografix.com/GPX/1/0}boundsType&quot; minOccurs=&quot;0&quot;/&gt;
 *         &lt;element name=&quot;wpt&quot; maxOccurs=&quot;unbounded&quot; minOccurs=&quot;0&quot;&gt;
 *           &lt;complexType&gt;
 *             &lt;complexContent&gt;
 *               &lt;restriction base=&quot;{http://www.w3.org/2001/XMLSchema}anyType&quot;&gt;
 *                 &lt;sequence&gt;
 *                   &lt;element name=&quot;ele&quot; type=&quot;{http://www.w3.org/2001/XMLSchema}decimal&quot; minOccurs=&quot;0&quot;/&gt;
 *                   &lt;element name=&quot;time&quot; type=&quot;{http://www.w3.org/2001/XMLSchema}dateTime&quot; minOccurs=&quot;0&quot;/&gt;
 *                   &lt;element name=&quot;magvar&quot; type=&quot;{http://www.topografix.com/GPX/1/0}degreesType&quot; minOccurs=&quot;0&quot;/&gt;
 *                   &lt;element name=&quot;geoidheight&quot; type=&quot;{http://www.w3.org/2001/XMLSchema}decimal&quot; minOccurs=&quot;0&quot;/&gt;
 *                   &lt;element name=&quot;name&quot; type=&quot;{http://www.w3.org/2001/XMLSchema}string&quot; minOccurs=&quot;0&quot;/&gt;
 *                   &lt;element name=&quot;cmt&quot; type=&quot;{http://www.w3.org/2001/XMLSchema}string&quot; minOccurs=&quot;0&quot;/&gt;
 *                   &lt;element name=&quot;desc&quot; type=&quot;{http://www.w3.org/2001/XMLSchema}string&quot; minOccurs=&quot;0&quot;/&gt;
 *                   &lt;element name=&quot;src&quot; type=&quot;{http://www.w3.org/2001/XMLSchema}string&quot; minOccurs=&quot;0&quot;/&gt;
 *                   &lt;element name=&quot;url&quot; type=&quot;{http://www.w3.org/2001/XMLSchema}anyURI&quot; minOccurs=&quot;0&quot;/&gt;
 *                   &lt;element name=&quot;urlname&quot; type=&quot;{http://www.w3.org/2001/XMLSchema}string&quot; minOccurs=&quot;0&quot;/&gt;
 *                   &lt;element name=&quot;sym&quot; type=&quot;{http://www.w3.org/2001/XMLSchema}string&quot; minOccurs=&quot;0&quot;/&gt;
 *                   &lt;element name=&quot;type&quot; type=&quot;{http://www.w3.org/2001/XMLSchema}string&quot; minOccurs=&quot;0&quot;/&gt;
 *                   &lt;element name=&quot;fix&quot; type=&quot;{http://www.topografix.com/GPX/1/0}fixType&quot; minOccurs=&quot;0&quot;/&gt;
 *                   &lt;element name=&quot;sat&quot; type=&quot;{http://www.w3.org/2001/XMLSchema}nonNegativeInteger&quot; minOccurs=&quot;0&quot;/&gt;
 *                   &lt;element name=&quot;hdop&quot; type=&quot;{http://www.w3.org/2001/XMLSchema}decimal&quot; minOccurs=&quot;0&quot;/&gt;
 *                   &lt;element name=&quot;vdop&quot; type=&quot;{http://www.w3.org/2001/XMLSchema}decimal&quot; minOccurs=&quot;0&quot;/&gt;
 *                   &lt;element name=&quot;pdop&quot; type=&quot;{http://www.w3.org/2001/XMLSchema}decimal&quot; minOccurs=&quot;0&quot;/&gt;
 *                   &lt;element name=&quot;ageofdgpsdata&quot; type=&quot;{http://www.w3.org/2001/XMLSchema}decimal&quot; minOccurs=&quot;0&quot;/&gt;
 *                   &lt;element name=&quot;dgpsid&quot; type=&quot;{http://www.topografix.com/GPX/1/0}dgpsStationType&quot; minOccurs=&quot;0&quot;/&gt;
 *                   &lt;any/&gt;
 *                 &lt;/sequence&gt;
 *                 &lt;attribute name=&quot;lat&quot; use=&quot;required&quot; type=&quot;{http://www.topografix.com/GPX/1/0}latitudeType&quot; /&gt;
 *                 &lt;attribute name=&quot;lon&quot; use=&quot;required&quot; type=&quot;{http://www.topografix.com/GPX/1/0}longitudeType&quot; /&gt;
 *               &lt;/restriction&gt;
 *             &lt;/complexContent&gt;
 *           &lt;/complexType&gt;
 *         &lt;/element&gt;
 *         &lt;element name=&quot;rte&quot; maxOccurs=&quot;unbounded&quot; minOccurs=&quot;0&quot;&gt;
 *           &lt;complexType&gt;
 *             &lt;complexContent&gt;
 *               &lt;restriction base=&quot;{http://www.w3.org/2001/XMLSchema}anyType&quot;&gt;
 *                 &lt;sequence&gt;
 *                   &lt;element name=&quot;name&quot; type=&quot;{http://www.w3.org/2001/XMLSchema}string&quot; minOccurs=&quot;0&quot;/&gt;
 *                   &lt;element name=&quot;cmt&quot; type=&quot;{http://www.w3.org/2001/XMLSchema}string&quot; minOccurs=&quot;0&quot;/&gt;
 *                   &lt;element name=&quot;desc&quot; type=&quot;{http://www.w3.org/2001/XMLSchema}string&quot; minOccurs=&quot;0&quot;/&gt;
 *                   &lt;element name=&quot;src&quot; type=&quot;{http://www.w3.org/2001/XMLSchema}string&quot; minOccurs=&quot;0&quot;/&gt;
 *                   &lt;element name=&quot;url&quot; type=&quot;{http://www.w3.org/2001/XMLSchema}anyURI&quot; minOccurs=&quot;0&quot;/&gt;
 *                   &lt;element name=&quot;urlname&quot; type=&quot;{http://www.w3.org/2001/XMLSchema}string&quot; minOccurs=&quot;0&quot;/&gt;
 *                   &lt;element name=&quot;number&quot; type=&quot;{http://www.w3.org/2001/XMLSchema}nonNegativeInteger&quot; minOccurs=&quot;0&quot;/&gt;
 *                   &lt;any/&gt;
 *                   &lt;element name=&quot;rtept&quot; maxOccurs=&quot;unbounded&quot; minOccurs=&quot;0&quot;&gt;
 *                     &lt;complexType&gt;
 *                       &lt;complexContent&gt;
 *                         &lt;restriction base=&quot;{http://www.w3.org/2001/XMLSchema}anyType&quot;&gt;
 *                           &lt;sequence&gt;
 *                             &lt;element name=&quot;ele&quot; type=&quot;{http://www.w3.org/2001/XMLSchema}decimal&quot; minOccurs=&quot;0&quot;/&gt;
 *                             &lt;element name=&quot;time&quot; type=&quot;{http://www.w3.org/2001/XMLSchema}dateTime&quot; minOccurs=&quot;0&quot;/&gt;
 *                             &lt;element name=&quot;magvar&quot; type=&quot;{http://www.topografix.com/GPX/1/0}degreesType&quot; minOccurs=&quot;0&quot;/&gt;
 *                             &lt;element name=&quot;geoidheight&quot; type=&quot;{http://www.w3.org/2001/XMLSchema}decimal&quot; minOccurs=&quot;0&quot;/&gt;
 *                             &lt;element name=&quot;name&quot; type=&quot;{http://www.w3.org/2001/XMLSchema}string&quot; minOccurs=&quot;0&quot;/&gt;
 *                             &lt;element name=&quot;cmt&quot; type=&quot;{http://www.w3.org/2001/XMLSchema}string&quot; minOccurs=&quot;0&quot;/&gt;
 *                             &lt;element name=&quot;desc&quot; type=&quot;{http://www.w3.org/2001/XMLSchema}string&quot; minOccurs=&quot;0&quot;/&gt;
 *                             &lt;element name=&quot;src&quot; type=&quot;{http://www.w3.org/2001/XMLSchema}string&quot; minOccurs=&quot;0&quot;/&gt;
 *                             &lt;element name=&quot;url&quot; type=&quot;{http://www.w3.org/2001/XMLSchema}anyURI&quot; minOccurs=&quot;0&quot;/&gt;
 *                             &lt;element name=&quot;urlname&quot; type=&quot;{http://www.w3.org/2001/XMLSchema}string&quot; minOccurs=&quot;0&quot;/&gt;
 *                             &lt;element name=&quot;sym&quot; type=&quot;{http://www.w3.org/2001/XMLSchema}string&quot; minOccurs=&quot;0&quot;/&gt;
 *                             &lt;element name=&quot;type&quot; type=&quot;{http://www.w3.org/2001/XMLSchema}string&quot; minOccurs=&quot;0&quot;/&gt;
 *                             &lt;element name=&quot;fix&quot; type=&quot;{http://www.topografix.com/GPX/1/0}fixType&quot; minOccurs=&quot;0&quot;/&gt;
 *                             &lt;element name=&quot;sat&quot; type=&quot;{http://www.w3.org/2001/XMLSchema}nonNegativeInteger&quot; minOccurs=&quot;0&quot;/&gt;
 *                             &lt;element name=&quot;hdop&quot; type=&quot;{http://www.w3.org/2001/XMLSchema}decimal&quot; minOccurs=&quot;0&quot;/&gt;
 *                             &lt;element name=&quot;vdop&quot; type=&quot;{http://www.w3.org/2001/XMLSchema}decimal&quot; minOccurs=&quot;0&quot;/&gt;
 *                             &lt;element name=&quot;pdop&quot; type=&quot;{http://www.w3.org/2001/XMLSchema}decimal&quot; minOccurs=&quot;0&quot;/&gt;
 *                             &lt;element name=&quot;ageofdgpsdata&quot; type=&quot;{http://www.w3.org/2001/XMLSchema}decimal&quot; minOccurs=&quot;0&quot;/&gt;
 *                             &lt;element name=&quot;dgpsid&quot; type=&quot;{http://www.topografix.com/GPX/1/0}dgpsStationType&quot; minOccurs=&quot;0&quot;/&gt;
 *                             &lt;any/&gt;
 *                           &lt;/sequence&gt;
 *                           &lt;attribute name=&quot;lat&quot; use=&quot;required&quot; type=&quot;{http://www.topografix.com/GPX/1/0}latitudeType&quot; /&gt;
 *                           &lt;attribute name=&quot;lon&quot; use=&quot;required&quot; type=&quot;{http://www.topografix.com/GPX/1/0}longitudeType&quot; /&gt;
 *                         &lt;/restriction&gt;
 *                       &lt;/complexContent&gt;
 *                     &lt;/complexType&gt;
 *                   &lt;/element&gt;
 *                 &lt;/sequence&gt;
 *               &lt;/restriction&gt;
 *             &lt;/complexContent&gt;
 *           &lt;/complexType&gt;
 *         &lt;/element&gt;
 *         &lt;element name=&quot;trk&quot; maxOccurs=&quot;unbounded&quot; minOccurs=&quot;0&quot;&gt;
 *           &lt;complexType&gt;
 *             &lt;complexContent&gt;
 *               &lt;restriction base=&quot;{http://www.w3.org/2001/XMLSchema}anyType&quot;&gt;
 *                 &lt;sequence&gt;
 *                   &lt;element name=&quot;name&quot; type=&quot;{http://www.w3.org/2001/XMLSchema}string&quot; minOccurs=&quot;0&quot;/&gt;
 *                   &lt;element name=&quot;cmt&quot; type=&quot;{http://www.w3.org/2001/XMLSchema}string&quot; minOccurs=&quot;0&quot;/&gt;
 *                   &lt;element name=&quot;desc&quot; type=&quot;{http://www.w3.org/2001/XMLSchema}string&quot; minOccurs=&quot;0&quot;/&gt;
 *                   &lt;element name=&quot;src&quot; type=&quot;{http://www.w3.org/2001/XMLSchema}string&quot; minOccurs=&quot;0&quot;/&gt;
 *                   &lt;element name=&quot;url&quot; type=&quot;{http://www.w3.org/2001/XMLSchema}anyURI&quot; minOccurs=&quot;0&quot;/&gt;
 *                   &lt;element name=&quot;urlname&quot; type=&quot;{http://www.w3.org/2001/XMLSchema}string&quot; minOccurs=&quot;0&quot;/&gt;
 *                   &lt;element name=&quot;number&quot; type=&quot;{http://www.w3.org/2001/XMLSchema}nonNegativeInteger&quot; minOccurs=&quot;0&quot;/&gt;
 *                   &lt;any/&gt;
 *                   &lt;element name=&quot;trkseg&quot; maxOccurs=&quot;unbounded&quot; minOccurs=&quot;0&quot;&gt;
 *                     &lt;complexType&gt;
 *                       &lt;complexContent&gt;
 *                         &lt;restriction base=&quot;{http://www.w3.org/2001/XMLSchema}anyType&quot;&gt;
 *                           &lt;sequence&gt;
 *                             &lt;element name=&quot;trkpt&quot; maxOccurs=&quot;unbounded&quot; minOccurs=&quot;0&quot;&gt;
 *                               &lt;complexType&gt;
 *                                 &lt;complexContent&gt;
 *                                   &lt;restriction base=&quot;{http://www.w3.org/2001/XMLSchema}anyType&quot;&gt;
 *                                     &lt;sequence&gt;
 *                                       &lt;element name=&quot;ele&quot; type=&quot;{http://www.w3.org/2001/XMLSchema}decimal&quot; minOccurs=&quot;0&quot;/&gt;
 *                                       &lt;element name=&quot;time&quot; type=&quot;{http://www.w3.org/2001/XMLSchema}dateTime&quot; minOccurs=&quot;0&quot;/&gt;
 *                                       &lt;element name=&quot;course&quot; type=&quot;{http://www.topografix.com/GPX/1/0}degreesType&quot; minOccurs=&quot;0&quot;/&gt;
 *                                       &lt;element name=&quot;speed&quot; type=&quot;{http://www.w3.org/2001/XMLSchema}decimal&quot; minOccurs=&quot;0&quot;/&gt;
 *                                       &lt;element name=&quot;magvar&quot; type=&quot;{http://www.topografix.com/GPX/1/0}degreesType&quot; minOccurs=&quot;0&quot;/&gt;
 *                                       &lt;element name=&quot;geoidheight&quot; type=&quot;{http://www.w3.org/2001/XMLSchema}decimal&quot; minOccurs=&quot;0&quot;/&gt;
 *                                       &lt;element name=&quot;name&quot; type=&quot;{http://www.w3.org/2001/XMLSchema}string&quot; minOccurs=&quot;0&quot;/&gt;
 *                                       &lt;element name=&quot;cmt&quot; type=&quot;{http://www.w3.org/2001/XMLSchema}string&quot; minOccurs=&quot;0&quot;/&gt;
 *                                       &lt;element name=&quot;desc&quot; type=&quot;{http://www.w3.org/2001/XMLSchema}string&quot; minOccurs=&quot;0&quot;/&gt;
 *                                       &lt;element name=&quot;src&quot; type=&quot;{http://www.w3.org/2001/XMLSchema}string&quot; minOccurs=&quot;0&quot;/&gt;
 *                                       &lt;element name=&quot;url&quot; type=&quot;{http://www.w3.org/2001/XMLSchema}anyURI&quot; minOccurs=&quot;0&quot;/&gt;
 *                                       &lt;element name=&quot;urlname&quot; type=&quot;{http://www.w3.org/2001/XMLSchema}string&quot; minOccurs=&quot;0&quot;/&gt;
 *                                       &lt;element name=&quot;sym&quot; type=&quot;{http://www.w3.org/2001/XMLSchema}string&quot; minOccurs=&quot;0&quot;/&gt;
 *                                       &lt;element name=&quot;type&quot; type=&quot;{http://www.w3.org/2001/XMLSchema}string&quot; minOccurs=&quot;0&quot;/&gt;
 *                                       &lt;element name=&quot;fix&quot; type=&quot;{http://www.topografix.com/GPX/1/0}fixType&quot; minOccurs=&quot;0&quot;/&gt;
 *                                       &lt;element name=&quot;sat&quot; type=&quot;{http://www.w3.org/2001/XMLSchema}nonNegativeInteger&quot; minOccurs=&quot;0&quot;/&gt;
 *                                       &lt;element name=&quot;hdop&quot; type=&quot;{http://www.w3.org/2001/XMLSchema}decimal&quot; minOccurs=&quot;0&quot;/&gt;
 *                                       &lt;element name=&quot;vdop&quot; type=&quot;{http://www.w3.org/2001/XMLSchema}decimal&quot; minOccurs=&quot;0&quot;/&gt;
 *                                       &lt;element name=&quot;pdop&quot; type=&quot;{http://www.w3.org/2001/XMLSchema}decimal&quot; minOccurs=&quot;0&quot;/&gt;
 *                                       &lt;element name=&quot;ageofdgpsdata&quot; type=&quot;{http://www.w3.org/2001/XMLSchema}decimal&quot; minOccurs=&quot;0&quot;/&gt;
 *                                       &lt;element name=&quot;dgpsid&quot; type=&quot;{http://www.topografix.com/GPX/1/0}dgpsStationType&quot; minOccurs=&quot;0&quot;/&gt;
 *                                       &lt;any/&gt;
 *                                     &lt;/sequence&gt;
 *                                     &lt;attribute name=&quot;lat&quot; use=&quot;required&quot; type=&quot;{http://www.topografix.com/GPX/1/0}latitudeType&quot; /&gt;
 *                                     &lt;attribute name=&quot;lon&quot; use=&quot;required&quot; type=&quot;{http://www.topografix.com/GPX/1/0}longitudeType&quot; /&gt;
 *                                   &lt;/restriction&gt;
 *                                 &lt;/complexContent&gt;
 *                               &lt;/complexType&gt;
 *                             &lt;/element&gt;
 *                           &lt;/sequence&gt;
 *                         &lt;/restriction&gt;
 *                       &lt;/complexContent&gt;
 *                     &lt;/complexType&gt;
 *                   &lt;/element&gt;
 *                 &lt;/sequence&gt;
 *               &lt;/restriction&gt;
 *             &lt;/complexContent&gt;
 *           &lt;/complexType&gt;
 *         &lt;/element&gt;
 *         &lt;any/&gt;
 *       &lt;/sequence&gt;
 *       &lt;attribute name=&quot;version&quot; use=&quot;required&quot; type=&quot;{http://www.w3.org/2001/XMLSchema}string&quot; fixed=&quot;1.0&quot; /&gt;
 *       &lt;attribute name=&quot;creator&quot; use=&quot;required&quot; type=&quot;{http://www.w3.org/2001/XMLSchema}string&quot; /&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = { "name", "desc", "author", "email", "url", "urlname", "time",
		"keywords", "bounds", "wpt", "rte", "trk", "any" })
@XmlRootElement(name = "gpx")
public class Gpx10 implements tac.data.gpx.interfaces.Gpx {

	protected String name;
	protected String desc;
	protected String author;
	protected String email;
	@XmlSchemaType(name = "anyURI")
	protected String url;
	protected String urlname;
	protected XMLGregorianCalendar time;
	protected String keywords;
	protected BoundsType bounds;
	protected List<WptType> wpt;
	protected List<RteType> rte;
	protected List<TrkType> trk;
	@XmlAnyElement(lax = true)
	protected List<Object> any;
	@XmlAttribute(required = true)
	protected String version;
	@XmlAttribute(required = true)
	protected String creator;

	/**
	 * Gets the value of the name property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getName() {
		return name;
	}

	/**
	 * Sets the value of the name property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setName(String value) {
		this.name = value;
	}

	/**
	 * Gets the value of the desc property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getDesc() {
		return desc;
	}

	/**
	 * Sets the value of the desc property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setDesc(String value) {
		this.desc = value;
	}

	/**
	 * Gets the value of the author property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getAuthor() {
		return author;
	}

	/**
	 * Sets the value of the author property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setAuthor(String value) {
		this.author = value;
	}

	/**
	 * Gets the value of the email property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * Sets the value of the email property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setEmail(String value) {
		this.email = value;
	}

	/**
	 * Gets the value of the url property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getUrl() {
		return url;
	}

	/**
	 * Sets the value of the url property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setUrl(String value) {
		this.url = value;
	}

	/**
	 * Gets the value of the urlname property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getUrlname() {
		return urlname;
	}

	/**
	 * Sets the value of the urlname property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setUrlname(String value) {
		this.urlname = value;
	}

	/**
	 * Gets the value of the time property.
	 * 
	 * @return possible object is {@link XMLGregorianCalendar }
	 * 
	 */
	public XMLGregorianCalendar getTime() {
		return time;
	}

	/**
	 * Sets the value of the time property.
	 * 
	 * @param value
	 *            allowed object is {@link XMLGregorianCalendar }
	 * 
	 */
	public void setTime(XMLGregorianCalendar value) {
		this.time = value;
	}

	/**
	 * Gets the value of the keywords property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getKeywords() {
		return keywords;
	}

	/**
	 * Sets the value of the keywords property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setKeywords(String value) {
		this.keywords = value;
	}

	/**
	 * Gets the value of the bounds property.
	 * 
	 * @return possible object is {@link BoundsType }
	 * 
	 */
	public BoundsType getBounds() {
		return bounds;
	}

	/**
	 * Sets the value of the bounds property.
	 * 
	 * @param value
	 *            allowed object is {@link BoundsType }
	 * 
	 */
	public void setBounds(BoundsType value) {
		this.bounds = value;
	}

	/**
	 * Gets the value of the wpt property.
	 * 
	 * <p>
	 * This accessor method returns a reference to the live list, not a
	 * snapshot. Therefore any modification you make to the returned list will
	 * be present inside the JAXB object. This is why there is not a
	 * <CODE>set</CODE> method for the wpt property.
	 * 
	 * <p>
	 * For example, to add a new item, do as follows:
	 * 
	 * <pre>
	 * getWpt().add(newItem);
	 * </pre>
	 * 
	 * 
	 * <p>
	 * Objects of the following type(s) are allowed in the list
	 * {@link Gpx10.Wpt }
	 * 
	 * 
	 */
	public List<WptType> getWpt() {
		if (wpt == null) {
			wpt = new ArrayList<WptType>();
		}
		return this.wpt;
	}

	/**
	 * Gets the value of the rte property.
	 * 
	 * <p>
	 * This accessor method returns a reference to the live list, not a
	 * snapshot. Therefore any modification you make to the returned list will
	 * be present inside the JAXB object. This is why there is not a
	 * <CODE>set</CODE> method for the rte property.
	 * 
	 * <p>
	 * For example, to add a new item, do as follows:
	 * 
	 * <pre>
	 * getRte().add(newItem);
	 * </pre>
	 * 
	 * 
	 * <p>
	 * Objects of the following type(s) are allowed in the list
	 * {@link Gpx10.Rte }
	 * 
	 * 
	 */
	public List<RteType> getRte() {
		if (rte == null) {
			rte = new ArrayList<RteType>();
		}
		return this.rte;
	}

	/**
	 * Gets the value of the trk property.
	 * 
	 * <p>
	 * This accessor method returns a reference to the live list, not a
	 * snapshot. Therefore any modification you make to the returned list will
	 * be present inside the JAXB object. This is why there is not a
	 * <CODE>set</CODE> method for the trk property.
	 * 
	 * <p>
	 * For example, to add a new item, do as follows:
	 * 
	 * <pre>
	 * getTrk().add(newItem);
	 * </pre>
	 * 
	 * 
	 * <p>
	 * Objects of the following type(s) are allowed in the list
	 * {@link Gpx10.Trk }
	 * 
	 * 
	 */
	public List<TrkType> getTrk() {
		if (trk == null) {
			trk = new ArrayList<TrkType>();
		}
		return this.trk;
	}

	/**
	 * Gets the value of the any property.
	 * 
	 * <p>
	 * This accessor method returns a reference to the live list, not a
	 * snapshot. Therefore any modification you make to the returned list will
	 * be present inside the JAXB object. This is why there is not a
	 * <CODE>set</CODE> method for the any property.
	 * 
	 * <p>
	 * For example, to add a new item, do as follows:
	 * 
	 * <pre>
	 * getAny().add(newItem);
	 * </pre>
	 * 
	 * 
	 * <p>
	 * Objects of the following type(s) are allowed in the list {@link Object }
	 * 
	 * 
	 */
	public List<Object> getAny() {
		if (any == null) {
			any = new ArrayList<Object>();
		}
		return this.any;
	}

	/**
	 * Gets the value of the version property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getVersion() {
		if (version == null) {
			return "1.0";
		} else {
			return version;
		}
	}

	/**
	 * Sets the value of the version property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setVersion(String value) {
		this.version = value;
	}

	/**
	 * Gets the value of the creator property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getCreator() {
		return creator;
	}

	/**
	 * Sets the value of the creator property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setCreator(String value) {
		this.creator = value;
	}

}