/*******************************************************************************************
 * The MIT License (MIT)
 * 
 * Copyright (c) 2013 Erik R Serating
 * 
 * Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated
 * documentation files (the "Software"), to deal in the Software without restriction, including without limitation the
 * rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, and to permit
 * persons to whom the Software is furnished to do so, subject to the following conditions:
 * 
 * The above copyright notice and this permission notice shall be included in all copies or substantial portions of the
 * Software.
 * 
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE
 * WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR
 * COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR
 * OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 *********************************************************************************************/
package com.google.code.siren4j.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Annotation to define an entity. Every resource class should have one of these annotations
 * to define the name and self uri. Adding links and actions here is convenient but optional as they can
 * also be added dynamically at runtime.
 * 
 * <pre>
 * <code>
 * Usage:
 * 
 *      &#064;Siren4JEntity(name = "course", uri = "/courses/{courseid}",
 *         links = {
 *             &#064;Siren4JLink(rel = "reviews", href="/courseReviews/course/{courseid}")
 *         },
 *         actions = {
 *             &#064;Siren4JAction(
 *                 name = "addReview",
 *                 method = Method.POST,
 *                 href = "/courseReviews/course/{courseid}",
 *                 fields = {
 *       	            &#064;Siren4JActionField(name = "userid", type = "text", required = true ),
 *       	            &#064;Siren4JActionField(name = "body", type = "text", required = true, maxLength = 250)
 *                 }
 *            )
 *         }
 *     )
 * 
 *     <table border="1">
 *       <thead>
 *          <tr><th>Property</th><th>Required</th><th>Description</th></tr>
 *       </thead>
 *       <tbody>
 *          <tr><td>name</td><td>no</td><td>Unique name for the entity. (Deprecated) use entity class.</td></tr>
 *          <tr><td>entityClass</td><td>no</td><td>Array of strings to classify the entity.</td></tr>
 *          <tr><td>uri</td><td>no</td><td>URI pattern to self</td></tr>
 *          <tr><td>suppressClassProperty</td><td>no</td><td>If true, will suppress the $class property which is used for deserialization.</td></tr>
 *          <tr><td>links</td><td>no</td><td>One or more {@link Siren4JLink} annotations.</td></tr>
 *          <tr><td>actions</td><td>no</td><td>One or more {@link Siren4JAction} annotations.</td></tr>
 *       </tbody>
 *     </table>     
 *     
 * </code>
 * </pre>
 *
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@com.google.code.siren4j.annotations.Siren4JAnnotation
public @interface Siren4JEntity {
    @Deprecated
    String name() default "";
    
    String[] entityClass() default {};
    
    boolean suppressClassProperty() default false;
    
    String uri() default "";

    Siren4JLink[] links() default {};

    Siren4JAction[] actions() default {};
    
}
