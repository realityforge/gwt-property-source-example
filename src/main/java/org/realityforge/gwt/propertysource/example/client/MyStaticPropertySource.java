package org.realityforge.gwt.propertysource.example.client;

import com.github.legioth.propertysource.client.PropertySource;
import com.github.legioth.propertysource.client.annotations.BooleanConversion;
import com.github.legioth.propertysource.client.annotations.Namespace;
import com.github.legioth.propertysource.client.annotations.Property;
import java.util.List;

@Namespace("foo")
public interface MyStaticPropertySource extends PropertySource {
    boolean bool();

    String string();

    String singleConf();

    List<String> multiConf();

    @Property("foo.string")
    @BooleanConversion(truePattern = ".*[1,3]")
    boolean isString1or3();

    @Property("user.agent")
    String userAgent();

    @Property("user.agent")
    @BooleanConversion(trueValues = { "gecko1_8", "safari" })
    boolean isOpenSourceEngine();

    @Property("user.agent")
    @BooleanConversion(truePattern = "ie\\d+")
    boolean isIE();

    @Property("foo.singleConf")
    List<String> singleAsList();

    @Property("foo.multiConf")
    @BooleanConversion(trueValues = { "Conf1", "Conf2" })
    boolean multiContains1or2();

    @Property("foo.multiConf")
    @BooleanConversion(trueValues = { "Conf1", "Conf2" }, matchAll = true)
    boolean multiContains1and2();
}
