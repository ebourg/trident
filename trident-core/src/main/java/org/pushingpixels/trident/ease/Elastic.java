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

package org.pushingpixels.trident.ease;

/**
 * Elastic easing function, based on Robert Penner formula.
 * 
 * @author Emmanuel Bourg
 * @version $Revision$, $Date$
 */
public class Elastic implements TimelineEase {

    private final float a;
    private final float p;
    private final double s;

    public Elastic() {
        this(1, 0.33f);
    }

    public Elastic(float a, float p) {
        this.a = Math.max(1, a);
        this.p = p;
        
        s = p / (2 * Math.PI) * Math.asin(1 / this.a);
    }

    public float map(float t) {
        if (t <= 0) {
            return 0;
        }
        
        if (t >= 1) {
            return 1;
        }
        
        return (float) (a * Math.pow(2, -10 * t) * Math.sin((t - s) * (2 * Math.PI) / p) + 1);
    }
}
