package org.realityforge.gwt.propertysource.example.client;

import com.google.gwt.core.shared.GWT;
import org.realityforge.gwt.propertysource.client.PropertySource;
import org.realityforge.gwt.propertysource.client.annotations.BooleanConversion;
import org.realityforge.gwt.propertysource.client.annotations.Property;

public class UserAgentPermutation
{
  @Property( "user.agent" )
  interface Properties
    extends PropertySource
  {
    @BooleanConversion( truePattern = "gecko.*" )
    boolean isGecko();

    @BooleanConversion( trueValues = "safari" )
    boolean isSafari();

    @BooleanConversion( trueValues = "opera" )
    boolean isOpera();

    @BooleanConversion( truePattern = "ie\\d+" )
    boolean isIe();

    @BooleanConversion( trueValues = "ie6" )
    boolean isIe6();

    @BooleanConversion( trueValues = "ie8" )
    boolean isIe8();

    @BooleanConversion( trueValues = "ie9" )
    boolean isIe9();

    String name();
  }

  private static Properties get()
  {
    return GWT.create( Properties.class );
  }

  public static boolean isGecko()
  {
    return get().isGecko();
  }

  public static boolean isSafari()
  {
    return get().isSafari();
  }

  public static boolean isOpera()
  {
    return get().isOpera();
  }

  public static boolean isIe()
  {
    return get().isIe();
  }

  public static boolean isIe6()
  {
    return get().isIe6();
  }

  public static boolean isIe8()
  {
    return get().isIe8();
  }

  public static boolean isIe9()
  {
    return get().isIe9();
  }

  public static String getName()
  {
    return get().name();
  }
}
