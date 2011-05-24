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
 * Easing function where the change starts backward then flings forward (adapted from Android interpolators).
 * 
 * @author Emmanuel Bourg
 * @version $Revision$, $Date$
 */
public class Anticipate implements TimelineEase {
    
    private float tension = 1.70158f;

    public Anticipate() {
    }

    public Anticipate(float tension) {
        this.tension = tension;
    }

    public float map(float t) {
        return t * t * ((tension + 1) * t - tension);
    }
}
