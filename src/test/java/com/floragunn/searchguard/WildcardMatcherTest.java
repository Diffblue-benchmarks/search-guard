package com.floragunn.searchguard.support;

import com.floragunn.searchguard.support.WildcardMatcher;
import org.junit.Assert;
import org.junit.Test;

public class WildcardMatcherTest {

  @Test
  public void testMatchesTrue() {

    // Arrange
    final String pattern = "=";
    final String[] candidate = {null};
    final boolean ignoreCase = true;

    // Act
    final String[] retval = WildcardMatcher.matches(pattern, candidate, ignoreCase);

    // Assert result
    Assert.assertArrayEquals(new String[] {}, retval);
  }

  @Test
  public void testMatchesFalse() {

    // Arrange
    final String pattern = "*";
    final String[] candidate = {"*"};
    final boolean ignoreCase = false;

    // Act
    final String[] retval = WildcardMatcher.matches(pattern, candidate, ignoreCase);

    // Assert result
    Assert.assertArrayEquals(new String[] {"*"}, retval);
  }
}
