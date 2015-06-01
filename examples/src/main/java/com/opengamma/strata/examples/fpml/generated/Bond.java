//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2015.05.20 at 01:28:29 PM CDT 
//


package com.opengamma.strata.examples.fpml.generated;

import java.math.BigDecimal;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * An exchange traded bond.
 * 
 * <p>Java class for Bond complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="Bond">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.fpml.org/FpML-5/pretrade}UnderlyingAsset">
 *       &lt;sequence>
 *         &lt;group ref="{http://www.fpml.org/FpML-5/pretrade}FixedIncomeSecurityContent.model"/>
 *         &lt;element name="parValue" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
 *         &lt;element name="faceAmount" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
 *         &lt;group ref="{http://www.fpml.org/FpML-5/pretrade}BondCalculation.model"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Bond", propOrder = {
    "issuerName",
    "issuerPartyReference",
    "seniority",
    "couponType",
    "couponRate",
    "maturity",
    "parValue",
    "faceAmount",
    "paymentFrequency",
    "dayCountFraction"
})
@XmlSeeAlso({
    ConvertibleBond.class
})
public class Bond
    extends UnderlyingAsset
{

    protected String issuerName;
    protected PartyReference issuerPartyReference;
    protected CreditSeniority seniority;
    protected CouponType couponType;
    protected BigDecimal couponRate;
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar maturity;
    protected BigDecimal parValue;
    protected BigDecimal faceAmount;
    protected Period paymentFrequency;
    protected DayCountFraction dayCountFraction;

    /**
     * Gets the value of the issuerName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIssuerName() {
        return issuerName;
    }

    /**
     * Sets the value of the issuerName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIssuerName(String value) {
        this.issuerName = value;
    }

    /**
     * Gets the value of the issuerPartyReference property.
     * 
     * @return
     *     possible object is
     *     {@link PartyReference }
     *     
     */
    public PartyReference getIssuerPartyReference() {
        return issuerPartyReference;
    }

    /**
     * Sets the value of the issuerPartyReference property.
     * 
     * @param value
     *     allowed object is
     *     {@link PartyReference }
     *     
     */
    public void setIssuerPartyReference(PartyReference value) {
        this.issuerPartyReference = value;
    }

    /**
     * Gets the value of the seniority property.
     * 
     * @return
     *     possible object is
     *     {@link CreditSeniority }
     *     
     */
    public CreditSeniority getSeniority() {
        return seniority;
    }

    /**
     * Sets the value of the seniority property.
     * 
     * @param value
     *     allowed object is
     *     {@link CreditSeniority }
     *     
     */
    public void setSeniority(CreditSeniority value) {
        this.seniority = value;
    }

    /**
     * Gets the value of the couponType property.
     * 
     * @return
     *     possible object is
     *     {@link CouponType }
     *     
     */
    public CouponType getCouponType() {
        return couponType;
    }

    /**
     * Sets the value of the couponType property.
     * 
     * @param value
     *     allowed object is
     *     {@link CouponType }
     *     
     */
    public void setCouponType(CouponType value) {
        this.couponType = value;
    }

    /**
     * Gets the value of the couponRate property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getCouponRate() {
        return couponRate;
    }

    /**
     * Sets the value of the couponRate property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setCouponRate(BigDecimal value) {
        this.couponRate = value;
    }

    /**
     * Gets the value of the maturity property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getMaturity() {
        return maturity;
    }

    /**
     * Sets the value of the maturity property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setMaturity(XMLGregorianCalendar value) {
        this.maturity = value;
    }

    /**
     * Gets the value of the parValue property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getParValue() {
        return parValue;
    }

    /**
     * Sets the value of the parValue property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setParValue(BigDecimal value) {
        this.parValue = value;
    }

    /**
     * Gets the value of the faceAmount property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getFaceAmount() {
        return faceAmount;
    }

    /**
     * Sets the value of the faceAmount property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setFaceAmount(BigDecimal value) {
        this.faceAmount = value;
    }

    /**
     * Gets the value of the paymentFrequency property.
     * 
     * @return
     *     possible object is
     *     {@link Period }
     *     
     */
    public Period getPaymentFrequency() {
        return paymentFrequency;
    }

    /**
     * Sets the value of the paymentFrequency property.
     * 
     * @param value
     *     allowed object is
     *     {@link Period }
     *     
     */
    public void setPaymentFrequency(Period value) {
        this.paymentFrequency = value;
    }

    /**
     * Gets the value of the dayCountFraction property.
     * 
     * @return
     *     possible object is
     *     {@link DayCountFraction }
     *     
     */
    public DayCountFraction getDayCountFraction() {
        return dayCountFraction;
    }

    /**
     * Sets the value of the dayCountFraction property.
     * 
     * @param value
     *     allowed object is
     *     {@link DayCountFraction }
     *     
     */
    public void setDayCountFraction(DayCountFraction value) {
        this.dayCountFraction = value;
    }

}