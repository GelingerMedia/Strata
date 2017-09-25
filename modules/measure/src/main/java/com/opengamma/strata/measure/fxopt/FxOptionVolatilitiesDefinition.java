/*
 * Copyright (C) 2017 - present by OpenGamma Inc. and the OpenGamma group of companies
 *
 * Please see distribution for license.
 */
package com.opengamma.strata.measure.fxopt;

import java.io.Serializable;
import java.time.ZonedDateTime;
import java.util.Map;
import java.util.NoSuchElementException;

import org.joda.beans.Bean;
import org.joda.beans.BeanBuilder;
import org.joda.beans.ImmutableBean;
import org.joda.beans.JodaBeanUtils;
import org.joda.beans.MetaBean;
import org.joda.beans.MetaProperty;
import org.joda.beans.gen.BeanDefinition;
import org.joda.beans.gen.PropertyDefinition;
import org.joda.beans.impl.direct.DirectMetaBean;
import org.joda.beans.impl.direct.DirectMetaProperty;
import org.joda.beans.impl.direct.DirectMetaPropertyMap;
import org.joda.beans.impl.direct.DirectPrivateBeanBuilder;

import com.google.common.collect.ImmutableList;
import com.opengamma.strata.basics.ReferenceData;
import com.opengamma.strata.collect.array.DoubleArray;
import com.opengamma.strata.market.observable.QuoteId;
import com.opengamma.strata.pricer.fxopt.FxOptionVolatilities;

/**
 * The definition of how to build FX option volatilities.
 * <p>
 * This stores an instance of specification {@code FxOptionVolatilitiesSpecification}.
 */
@BeanDefinition(builderScope = "private")
public final class FxOptionVolatilitiesDefinition
    implements ImmutableBean, Serializable {

  /**
   * The FX option volatility specification.
   */
  @PropertyDefinition(validate = "notNull")
  private final FxOptionVolatilitiesSpecification specification;

  /**
   * Obtains an instance.
   * 
   * @param specification  the specification
   * @return the instance
   */
  public static FxOptionVolatilitiesDefinition of(FxOptionVolatilitiesSpecification specification) {
    return new FxOptionVolatilitiesDefinition(specification);
  }

  //-------------------------------------------------------------------------
  /**
   * Creates FX option volatilities.
   * <p>
   * The number and ordering of {@code parameters} must be coherent to those of nodes, {@code #getNodes()}.
   * 
   * @param valuationDateTime  the valuation date time
   * @param parameters  the parameters
   * @param refData  the reference data
   * @return the volatilities
   */
  public FxOptionVolatilities volatilities(
      ZonedDateTime valuationDateTime,
      DoubleArray parameters,
      ReferenceData refData) {

    return specification.volatilities(valuationDateTime, parameters, refData);
  }

  /**
   * Obtains the inputs required to create the FX option volatilities.
   * 
   * @return the inputs
   */
  public ImmutableList<QuoteId> volatilitiesInputs() {
    return specification.volatilitiesInputs();
  }

  /**
   * Gets the number of parameters.
   * 
   * @return the number of parameters
   */
  public int getParameterCount() {
    return specification.getParameterCount();
  }

  //------------------------- AUTOGENERATED START -------------------------
  /**
   * The meta-bean for {@code FxOptionVolatilitiesDefinition}.
   * @return the meta-bean, not null
   */
  public static FxOptionVolatilitiesDefinition.Meta meta() {
    return FxOptionVolatilitiesDefinition.Meta.INSTANCE;
  }

  static {
    MetaBean.register(FxOptionVolatilitiesDefinition.Meta.INSTANCE);
  }

  /**
   * The serialization version id.
   */
  private static final long serialVersionUID = 1L;

  private FxOptionVolatilitiesDefinition(
      FxOptionVolatilitiesSpecification specification) {
    JodaBeanUtils.notNull(specification, "specification");
    this.specification = specification;
  }

  @Override
  public FxOptionVolatilitiesDefinition.Meta metaBean() {
    return FxOptionVolatilitiesDefinition.Meta.INSTANCE;
  }

  //-----------------------------------------------------------------------
  /**
   * Gets the FX option volatility specification.
   * @return the value of the property, not null
   */
  public FxOptionVolatilitiesSpecification getSpecification() {
    return specification;
  }

  //-----------------------------------------------------------------------
  @Override
  public boolean equals(Object obj) {
    if (obj == this) {
      return true;
    }
    if (obj != null && obj.getClass() == this.getClass()) {
      FxOptionVolatilitiesDefinition other = (FxOptionVolatilitiesDefinition) obj;
      return JodaBeanUtils.equal(specification, other.specification);
    }
    return false;
  }

  @Override
  public int hashCode() {
    int hash = getClass().hashCode();
    hash = hash * 31 + JodaBeanUtils.hashCode(specification);
    return hash;
  }

  @Override
  public String toString() {
    StringBuilder buf = new StringBuilder(64);
    buf.append("FxOptionVolatilitiesDefinition{");
    buf.append("specification").append('=').append(JodaBeanUtils.toString(specification));
    buf.append('}');
    return buf.toString();
  }

  //-----------------------------------------------------------------------
  /**
   * The meta-bean for {@code FxOptionVolatilitiesDefinition}.
   */
  public static final class Meta extends DirectMetaBean {
    /**
     * The singleton instance of the meta-bean.
     */
    static final Meta INSTANCE = new Meta();

    /**
     * The meta-property for the {@code specification} property.
     */
    private final MetaProperty<FxOptionVolatilitiesSpecification> specification = DirectMetaProperty.ofImmutable(
        this, "specification", FxOptionVolatilitiesDefinition.class, FxOptionVolatilitiesSpecification.class);
    /**
     * The meta-properties.
     */
    private final Map<String, MetaProperty<?>> metaPropertyMap$ = new DirectMetaPropertyMap(
        this, null,
        "specification");

    /**
     * Restricted constructor.
     */
    private Meta() {
    }

    @Override
    protected MetaProperty<?> metaPropertyGet(String propertyName) {
      switch (propertyName.hashCode()) {
        case 1307197699:  // specification
          return specification;
      }
      return super.metaPropertyGet(propertyName);
    }

    @Override
    public BeanBuilder<? extends FxOptionVolatilitiesDefinition> builder() {
      return new FxOptionVolatilitiesDefinition.Builder();
    }

    @Override
    public Class<? extends FxOptionVolatilitiesDefinition> beanType() {
      return FxOptionVolatilitiesDefinition.class;
    }

    @Override
    public Map<String, MetaProperty<?>> metaPropertyMap() {
      return metaPropertyMap$;
    }

    //-----------------------------------------------------------------------
    /**
     * The meta-property for the {@code specification} property.
     * @return the meta-property, not null
     */
    public MetaProperty<FxOptionVolatilitiesSpecification> specification() {
      return specification;
    }

    //-----------------------------------------------------------------------
    @Override
    protected Object propertyGet(Bean bean, String propertyName, boolean quiet) {
      switch (propertyName.hashCode()) {
        case 1307197699:  // specification
          return ((FxOptionVolatilitiesDefinition) bean).getSpecification();
      }
      return super.propertyGet(bean, propertyName, quiet);
    }

    @Override
    protected void propertySet(Bean bean, String propertyName, Object newValue, boolean quiet) {
      metaProperty(propertyName);
      if (quiet) {
        return;
      }
      throw new UnsupportedOperationException("Property cannot be written: " + propertyName);
    }

  }

  //-----------------------------------------------------------------------
  /**
   * The bean-builder for {@code FxOptionVolatilitiesDefinition}.
   */
  private static final class Builder extends DirectPrivateBeanBuilder<FxOptionVolatilitiesDefinition> {

    private FxOptionVolatilitiesSpecification specification;

    /**
     * Restricted constructor.
     */
    private Builder() {
    }

    //-----------------------------------------------------------------------
    @Override
    public Object get(String propertyName) {
      switch (propertyName.hashCode()) {
        case 1307197699:  // specification
          return specification;
        default:
          throw new NoSuchElementException("Unknown property: " + propertyName);
      }
    }

    @Override
    public Builder set(String propertyName, Object newValue) {
      switch (propertyName.hashCode()) {
        case 1307197699:  // specification
          this.specification = (FxOptionVolatilitiesSpecification) newValue;
          break;
        default:
          throw new NoSuchElementException("Unknown property: " + propertyName);
      }
      return this;
    }

    @Override
    public FxOptionVolatilitiesDefinition build() {
      return new FxOptionVolatilitiesDefinition(
          specification);
    }

    //-----------------------------------------------------------------------
    @Override
    public String toString() {
      StringBuilder buf = new StringBuilder(64);
      buf.append("FxOptionVolatilitiesDefinition.Builder{");
      buf.append("specification").append('=').append(JodaBeanUtils.toString(specification));
      buf.append('}');
      return buf.toString();
    }

  }

  //-------------------------- AUTOGENERATED END --------------------------
}
