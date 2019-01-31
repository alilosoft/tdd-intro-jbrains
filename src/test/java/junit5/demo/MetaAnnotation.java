package junit5.demo;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
@ParameterizedTest(name = "Elaborate name listing all {arguments}")
@ValueSource(strings = {"Hello", "JUnit5"})
public @interface MetaAnnotation {
}
