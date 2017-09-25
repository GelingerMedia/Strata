/*
 * Copyright (C) 2017 - present by OpenGamma Inc. and the OpenGamma group of companies
 *
 * Please see distribution for license.
 */
package com.opengamma.strata.measure;

import static com.opengamma.strata.collect.TestHelper.assertSerialization;
import static com.opengamma.strata.collect.TestHelper.coverBeanEquals;
import static com.opengamma.strata.collect.TestHelper.coverImmutableBean;
import static org.testng.Assert.assertEquals;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;

import org.testng.annotations.Test;

import com.opengamma.strata.data.scenario.MarketDataBox;
import com.opengamma.strata.data.scenario.ScenarioArray;

/**
 * Test {@link ValuationZoneTimeDefinition}.
 */
@Test
public class ValuationZoneTimeDefinitionTest {

  private static final ScenarioArray<LocalTime> LOCAL_TIMES = ScenarioArray.of(
      LocalTime.of(12, 20), LocalTime.of(10, 10), LocalTime.of(9, 35));
  private static final ScenarioArray<LocalTime> LOCAL_TIME = ScenarioArray.of(LocalTime.of(15, 12));
  private static final ZoneId ZONE_ID = ZoneId.of("Z");

  public void test_of() {
    ValuationZoneTimeDefinition test = ValuationZoneTimeDefinition.of(LOCAL_TIMES, ZONE_ID);
    assertEquals(test.getLocalTimes(), LOCAL_TIMES);
    assertEquals(test.getZoneId(), ZONE_ID);
  }

  public void test_toZonedDateTime_scenario() {
    ValuationZoneTimeDefinition test = ValuationZoneTimeDefinition.of(LOCAL_TIMES, ZONE_ID);
    MarketDataBox<LocalDate> dates = MarketDataBox.ofScenarioValues(
        LocalDate.of(2016, 10, 21), LocalDate.of(2016, 10, 22), LocalDate.of(2016, 10, 23));
    MarketDataBox<ZonedDateTime> computed = test.toZonedDateTime(dates);
    MarketDataBox<ZonedDateTime> expected = MarketDataBox.ofScenarioValue(ScenarioArray.of(
        dates.getValue(0).atTime(LOCAL_TIMES.get(0)).atZone(ZONE_ID),
        dates.getValue(1).atTime(LOCAL_TIMES.get(1)).atZone(ZONE_ID),
        dates.getValue(2).atTime(LOCAL_TIMES.get(2)).atZone(ZONE_ID)));
    assertEquals(computed, expected);
  }

  public void test_toZonedDateTime_single() {
    ValuationZoneTimeDefinition test = ValuationZoneTimeDefinition.of(LOCAL_TIME, ZONE_ID);
    MarketDataBox<LocalDate> dates = MarketDataBox.ofSingleValue(LocalDate.of(2016, 10, 21));
    MarketDataBox<ZonedDateTime> computed = test.toZonedDateTime(dates);
    MarketDataBox<ZonedDateTime> expected = MarketDataBox.ofSingleValue(
        dates.getSingleValue().atTime(LOCAL_TIME.get(0)).atZone(ZONE_ID));
    assertEquals(computed, expected);
  }

  //-------------------------------------------------------------------------
  public void coverage() {
    ValuationZoneTimeDefinition test1 = ValuationZoneTimeDefinition.of(LOCAL_TIMES, ZONE_ID);
    coverImmutableBean(test1);
    ValuationZoneTimeDefinition test2 = ValuationZoneTimeDefinition.of(LOCAL_TIME, ZoneId.of("Europe/London"));
    coverBeanEquals(test1, test2);
  }

  public void test_serialization() {
    ValuationZoneTimeDefinition test = ValuationZoneTimeDefinition.of(LOCAL_TIMES, ZONE_ID);
    assertSerialization(test);
  }

}
