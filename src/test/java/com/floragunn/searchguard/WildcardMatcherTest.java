package com.floragunn.searchguard.support;

import com.floragunn.searchguard.support.WildcardMatcher;
import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;

public class WildcardMatcherTest {

  @Test
  public void containsWildcardInputNotNullOutputFalse() {

    // Arrange
    final String pattern = ".";

    // Act
    final boolean retval = WildcardMatcher.containsWildcard(pattern);

    // Assert result
    Assert.assertEquals(false, retval);
  }

  @Test
  public void containsWildcardInputNotNullOutputFalse2() {

    // Arrange
    final String pattern = "/--,,//-";

    // Act
    final boolean retval = WildcardMatcher.containsWildcard(pattern);

    // Assert result
    Assert.assertEquals(false, retval);
  }

  @Test
  public void containsWildcardInputNotNullOutputFalse3() {

    // Arrange
    final String pattern = "/\u000e\u000e//...";

    // Act
    final boolean retval = WildcardMatcher.containsWildcard(pattern);

    // Assert result
    Assert.assertEquals(false, retval);
  }

  @Test
  public void containsWildcardInputNotNullOutputTrue() {

    // Arrange
    final String pattern = "?";

    // Act
    final boolean retval = WildcardMatcher.containsWildcard(pattern);

    // Assert result
    Assert.assertEquals(true, retval);
  }


  @Test
  public void containsWildcardInputNotNullOutputTrue2() {

    // Arrange
    final String pattern = "/";

    // Act
    final boolean retval = WildcardMatcher.containsWildcard(pattern);

    // Assert result
    Assert.assertEquals(true, retval);
  }

  @Test
  public void containsWildcardInputNotNullOutputTrue3() {

    // Arrange
    final String pattern = "///>>NN*";

    // Act
    final boolean retval = WildcardMatcher.containsWildcard(pattern);

    // Assert result
    Assert.assertEquals(true, retval);
  }

  @Test
  public void containsWildcardInputNotNullOutputTrue4() {

    // Arrange
    final String pattern = "+\u0001\u0001\b\b*?";

    // Act
    final boolean retval = WildcardMatcher.containsWildcard(pattern);

    // Assert result
    Assert.assertEquals(true, retval);
  }

  @Test
  public void matchesInputNotNull0TrueOutput0() {

    // Arrange
    final String pattern = "*55555555/";
    final String[] candidate = {};
    final boolean ignoreCase = true;

    // Act
    final String[] retval = WildcardMatcher.matches(pattern, candidate, ignoreCase);

    // Assert result
    Assert.assertArrayEquals(new String[] {}, retval);
  }
  
  @Test
  public void wildcardRetainInSetInput00OutputFalse() {

    // Arrange
    final java.util.HashSet<String> set = new java.util.HashSet<String>();
    final String[] setContainingWc = {};

    // Act
    final boolean retval = WildcardMatcher.wildcardRetainInSet(set, setContainingWc);

    // Assert result
    Assert.assertEquals(false, retval);
  }
}
