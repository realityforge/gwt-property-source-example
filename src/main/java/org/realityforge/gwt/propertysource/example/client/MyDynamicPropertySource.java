package org.realityforge.gwt.propertysource.example.client;

import com.github.legioth.propertysource.client.DynamicPropertySource;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MyDynamicPropertySource
  extends DynamicPropertySource
{
  public boolean isString2()
  {
    return "string2".equals( getSelectionPropertyValue( "foo.string" ) );
  }

  public String combineProperties()
  {
    final String value = getSelectionPropertyValue( "user.agent" );
    final StringBuilder sb = new StringBuilder();
    for ( final String string : getConfigurationPropertyValues( "foo.multiConf" ) )
    {
      sb.append( value ).append( string );
    }
    return sb.toString();
  }

  public List<String> multiConfigReversed()
  {
    final List<String> propertyValues =
      new ArrayList<String>( getConfigurationPropertyValues( "foo.multiConf" ) );
    // Reverse
    Collections.reverse( propertyValues );
    return propertyValues;
  }

  public String readSystemProperties()
  {
    /*
     * Even though the code is never run by GWT, the compiler will still
     * check that it's valid. System.getProperty(String) is not supported by
     * GWT, but System.getProperty(String, String) is.
     */
    return "Module compiled with Java " +
           System.getProperty( "java.version", "" ) + " from " +
           System.getProperty( "java.vendor", "" ) + " on " +
           System.getProperty( "os.arch", "" ) + " " +
           System.getProperty( "os.name", "" ) + " " +
           System.getProperty( "os.version", "" );
  }
}
