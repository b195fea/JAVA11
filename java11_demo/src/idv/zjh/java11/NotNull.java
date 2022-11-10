/**
 * 
 */
package idv.zjh.java11;

import java.lang.annotation.*;

@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.LOCAL_VARIABLE,ElementType.PARAMETER})
public @interface NotNull {}
