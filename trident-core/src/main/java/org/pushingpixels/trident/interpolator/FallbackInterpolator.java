/**
 * Copyright 2011 Emmanuel Bourg
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.pushingpixels.trident.interpolator;

/**
 * Fallback interpolator used when an interpolator for the type T cannot be
 * found. This interpolator returns the initial value for the first half of
 * the timeline, and the target value for the second half.
 * 
 * @author Emmanuel Bourg
 * @version $Revision$, $Date$
 */
public class FallbackInterpolator<T> implements PropertyInterpolator<T> {

    public Class getBasePropertyClass() {
        return null;
    }

    public T interpolate(T from, T to, float timelinePosition) {
        if (timelinePosition < 0.5f) {
            return from;
        } else {
            return to;
        }
    }
}
